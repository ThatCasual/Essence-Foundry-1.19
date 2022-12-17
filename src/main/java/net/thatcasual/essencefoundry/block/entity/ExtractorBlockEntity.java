package net.thatcasual.essencefoundry.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.thatcasual.essencefoundry.block.custom.ExtractorBlock;
import net.thatcasual.essencefoundry.fluid.ModFluids;
import net.thatcasual.essencefoundry.recipe.ExtractorRecipe;
import net.thatcasual.essencefoundry.screen.ExtractorScreenHandler;
import net.thatcasual.essencefoundry.util.ModBlockEntitySideManager;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ExtractorBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {

    //INVENTORY VARIABLES inventory size constant & constants names to use as slot index numbers.
    public static final int INVENTORY_SIZE = 6;
    public static final int BUCKET_TO_EMPTY_SLOT = 0;
    public static final int EMPTIED_BUCKET_SLOT = 1;
    public static final int BUCKET_TO_FILL_SLOT = 2;
    public static final int FILLED_BUCKET_SLOT = 3;
    public static final int ITEM_FOR_EXTRACTING_SLOT = 4;
    public static final int EMPTIED_ITEM_SLOT = 5;

    //PROPERTY DELEGATE VARIABLES for sync between client and server.
    protected final PropertyDelegate propertyDelegate;

    //Crafting management variables index names to be used with the PropertyDelegate get and set functions.
    public static final int PROGRESS = 0;
    public static final int MAX_PROGRESS = 1;
    public static final int FLUID = 2;
    public static final int MAX_FLUID = 3;

    //Side manager.
    public static ModBlockEntitySideManager sideManager;

    //The block entity's inventory.
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(INVENTORY_SIZE, ItemStack.EMPTY);

    //Craft management variables.
    private int progress = 0;
    private int maxProgress = 72;
    private int fluid = 0;

    private int maxFluid = 64000;

    public ExtractorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.EXTRACTOR, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index){
                    case PROGRESS: return ExtractorBlockEntity.this.progress;
                    case MAX_PROGRESS: return ExtractorBlockEntity.this.maxProgress;
                    case FLUID: return ExtractorBlockEntity.this.fluid;
                    case MAX_FLUID: return ExtractorBlockEntity.this.maxFluid;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case PROGRESS: ExtractorBlockEntity.this.progress = value; break;
                    case MAX_PROGRESS: ExtractorBlockEntity.this.maxProgress = value; break;
                    case FLUID: ExtractorBlockEntity.this.fluid = value; break;
                    case MAX_FLUID: ExtractorBlockEntity.this.maxFluid = value; break;
                }
            }

            @Override
            public int size() {
                return 4;
            }
        };

        this.sideManager = new ModBlockEntitySideManager(INVENTORY_SIZE);
        sideManager.registerInsert(ModBlockEntitySideManager.LEFT, BUCKET_TO_EMPTY_SLOT, ModFluids.OBSIDIAN_TEARS_BUCKET);
        sideManager.registerInsert(ModBlockEntitySideManager.TOP, ITEM_FOR_EXTRACTING_SLOT, Items.CRYING_OBSIDIAN);
        sideManager.registerInsert(ModBlockEntitySideManager.BACK, BUCKET_TO_FILL_SLOT, Items.BUCKET);
        sideManager.registerExtract(ModBlockEntitySideManager.BOTTOM, EMPTIED_BUCKET_SLOT, Items.BUCKET);
        sideManager.registerExtract(ModBlockEntitySideManager.BOTTOM, FILLED_BUCKET_SLOT, ModFluids.OBSIDIAN_TEARS_BUCKET);
        sideManager.registerExtract(ModBlockEntitySideManager.BOTTOM, EMPTIED_ITEM_SLOT, ModFluids.OBSIDIAN_TEARS_BUCKET);

    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("Extractor").formatted(Formatting.GOLD);
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new ExtractorScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("extractor.progress", progress);
        nbt.putInt("extractor.fluid", fluid);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("extractor.progress");
        fluid = nbt.getInt("extractor.fluid");
    }

    private void resetProgress(){
        this.progress = 0;
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, ExtractorBlockEntity entity) {
        if(world.isClient()) { return; }

        if (hasRecipe(entity)){
            entity.progress++;
            markDirty(world,blockPos,state);
            if (entity.progress >= entity.maxProgress){
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
            markDirty(world, blockPos, state);
        }

        SimpleInventory inventory = constructSimpleInventory(entity);
        if(hasBucketToEmpty(inventory) && canInsertIntoSlot(inventory, EMPTIED_BUCKET_SLOT, 1, Items.BUCKET)){
            if (addFluid(1000, entity)) {
                entity.setStack(BUCKET_TO_EMPTY_SLOT, ItemStack.EMPTY);
                entity.setStack(EMPTIED_BUCKET_SLOT, new ItemStack(Items.BUCKET, entity.getStack(EMPTIED_BUCKET_SLOT).getCount() + 1));
                System.out.println(entity.fluid);
            }
        }
        if(hasBucketToFill(inventory) && entity.getStack(FILLED_BUCKET_SLOT).isEmpty()){
            if (removeFluid(1000, entity)) {
                entity.setStack(BUCKET_TO_FILL_SLOT, new ItemStack(Items.BUCKET, entity.getStack(BUCKET_TO_FILL_SLOT).getCount() - 1));
                entity.setStack(FILLED_BUCKET_SLOT, new ItemStack(ModFluids.OBSIDIAN_TEARS_BUCKET, 1));
                System.out.println(entity.fluid);
            }
        }

    }

    private static boolean addFluid(int amount, ExtractorBlockEntity entity) {
        if (entity.fluid + amount <= entity.maxFluid){
            entity.fluid += amount;
            return true;
        }
        return false;
    }
    private static boolean removeFluid(int amount, ExtractorBlockEntity entity) {
        if (entity.fluid - amount >= 0){
            entity.fluid -= amount;
            return true;
        }
        return false;
    }

    private static boolean hasBucketToEmpty(SimpleInventory inventory) {
        return inventory.getStack(BUCKET_TO_EMPTY_SLOT).getItem() == ModFluids.OBSIDIAN_TEARS_BUCKET;
    }
    private static boolean hasBucketToFill(SimpleInventory inventory) {
        return inventory.getStack(BUCKET_TO_FILL_SLOT).getItem() == Items.BUCKET;
    }

    private static SimpleInventory constructSimpleInventory(ExtractorBlockEntity entity){
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++){
            inventory.setStack(i, entity.getStack(i));
        }
        return inventory;
    }

    private static void craftItem(ExtractorBlockEntity entity) {
        SimpleInventory inventory = constructSimpleInventory(entity);

        Optional<ExtractorRecipe> recipe = entity.getWorld().getRecipeManager()
                .getFirstMatch(ExtractorRecipe.Type.INSTANCE, inventory, entity.getWorld());

        if(hasRecipe(entity)){
            if (addFluid(250, entity)) {
                entity.removeStack(ITEM_FOR_EXTRACTING_SLOT, 1);
                entity.setStack(EMPTIED_ITEM_SLOT, new ItemStack(recipe.get().getOutput().getItem(), entity.getStack(EMPTIED_ITEM_SLOT).getCount() + recipe.get().getOutput().getCount()));
                entity.resetProgress();
                System.out.println(entity.fluid);
            }
        }
    }

    private static boolean hasRecipe(ExtractorBlockEntity entity) {
        SimpleInventory inventory = constructSimpleInventory(entity);

        Optional<ExtractorRecipe> match = entity.getWorld().getRecipeManager()
                .getFirstMatch(ExtractorRecipe.Type.INSTANCE, inventory, entity.getWorld());

        return match.isPresent() && canInsertIntoSlot(inventory, EMPTIED_ITEM_SLOT, 1, match.get().getOutput().getItem());

    }

    // Checks that the output slot (slot 2) either contains the proper item stack or is empty.
    private static boolean canInsertIntoSlot(SimpleInventory inventory, int slot, int count, Item output) {
        return (inventory.getStack(slot).getItem() == output
                || inventory.getStack(slot).isEmpty())
                && inventory.getStack(slot).getMaxCount() >= inventory.getStack(slot).getCount() + count;
    }

    // Checks that the amount we are trying to insert into the output slot (slot 2) will not exceed the max stack count of the item.


    //SIDED INVENTORY
    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        Direction facing  = this.getWorld().getBlockState(this.pos).get(ExtractorBlock.FACING);
        return sideManager.checkIsAllowedInsert(facing, side, slot, stack.getItem());
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        Direction facing  = this.getWorld().getBlockState(this.pos).get(ExtractorBlock.FACING);
        return sideManager.checkIsAllowedExtract(facing, side, slot, stack.getItem());
    }
}
