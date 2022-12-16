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
    public static final int INVENTORY_SIZE = 3;
    public static final int BUCKET_TO_EMPTY = 0;
    public static final int BUCKET_TO_FILL = 1;
    public static final int CRYING_OBSIDIAN_SLOT = 2;
    public static final int DRAINED_OBSIDIAN_SLOT = 3;

    //PROPERTY DELEGATE VARIABLES for sync between client and server.
    protected final PropertyDelegate propertyDelegate;

    //Crafting management variables index names to be used with the PropertyDelegate get and set functions.
    public static final int PROGRESS = 0;
    public static final int MAX_PROGRESS = 1;

    //Side manager.
    public static ModBlockEntitySideManager sideManager;

    //The block entity's inventory.
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(INVENTORY_SIZE, ItemStack.EMPTY);

    //Craft management variables.
    private int progress = 0;
    private int maxProgress = 72;

    public ExtractorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.EXTRACTOR, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch (index){
                    case PROGRESS: return ExtractorBlockEntity.this.progress;
                    case MAX_PROGRESS: return ExtractorBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case PROGRESS: ExtractorBlockEntity.this.progress = value; break;
                    case MAX_PROGRESS: ExtractorBlockEntity.this.maxProgress = value; break;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };

        this.sideManager = new ModBlockEntitySideManager(INVENTORY_SIZE);
        sideManager.registerInsert(ModBlockEntitySideManager.LEFT, BUCKET_TO_EMPTY, ModFluids.OBSIDIAN_TEARS_BUCKET);
        sideManager.registerInsert(ModBlockEntitySideManager.TOP, BUCKET_TO_FILL, Items.CRYING_OBSIDIAN);
        sideManager.registerExtract(ModBlockEntitySideManager.BOTTOM, CRYING_OBSIDIAN_SLOT, ModFluids.OBSIDIAN_TEARS_BUCKET);

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
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("extractor.progress");
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
    }

    private static void craftItem(ExtractorBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++){
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<ExtractorRecipe> recipe = entity.getWorld().getRecipeManager()
                .getFirstMatch(ExtractorRecipe.Type.INSTANCE, inventory, entity.getWorld());

        if(hasRecipe(entity)){
            entity.removeStack(BUCKET_TO_FILL,1);
            entity.setStack(CRYING_OBSIDIAN_SLOT, new ItemStack(recipe.get().getOutput().getItem(), entity.getStack(CRYING_OBSIDIAN_SLOT).getCount() + 1));
            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(ExtractorBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++){
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<ExtractorRecipe> match = entity.getWorld().getRecipeManager()
                .getFirstMatch(ExtractorRecipe.Type.INSTANCE, inventory, entity.getWorld());

        return match.isPresent()
                && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput().getItem());

    }

    // Checks that the output slot (slot 2) either contains the proper item stack or is empty.
    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(CRYING_OBSIDIAN_SLOT).getItem() == output
                || inventory.getStack(CRYING_OBSIDIAN_SLOT).isEmpty();
    }

    // Checks that the amount we are trying to insert into the output slot (slot 2) will not exceed the max stack count of the item.
    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(CRYING_OBSIDIAN_SLOT).getMaxCount() > inventory.getStack(CRYING_OBSIDIAN_SLOT).getCount();
    }

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
