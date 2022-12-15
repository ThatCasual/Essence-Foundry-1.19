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
import net.thatcasual.essencefoundry.item.ModItems;
import net.thatcasual.essencefoundry.recipe.ExtractorRecipe;
import net.thatcasual.essencefoundry.screen.ExtractorScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class ExtractorBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {

    public static final int PROGRESS = 0;
    public static final int MAX_PROGRESS = 1;

    public static final int OBSIDIAN_TEARS_BUCKET = 0;
    public static final int AMETHYST_SLOT = 1;
    public static final int OUTPUT_SLOT = 2;

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    private int fuelTime = 0;
    private int maxFuelTime = 0;

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
            entity.removeStack(AMETHYST_SLOT,1);
            entity.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().getOutput().getItem(), entity.getStack(OUTPUT_SLOT).getCount() + 1));
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
        return inventory.getStack(OUTPUT_SLOT).getItem() == output
                || inventory.getStack(OUTPUT_SLOT).isEmpty();
    }

    // Checks that the amount we are trying to insert into the output slot (slot 2) will not exceed the max stack count of the item.
    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(OUTPUT_SLOT).getMaxCount() > inventory.getStack(OUTPUT_SLOT).getCount();
    }

    //SIDED INVENTORY
    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        Direction localDirection = this.getWorld().getBlockState(this.pos).get(ExtractorBlock.FACING);

        Direction top = Direction.UP;
        Direction bottom = Direction.DOWN;
        Direction front = Direction.NORTH;
        Direction back = Direction.SOUTH;
        Direction left = Direction.EAST;
        Direction right = Direction.WEST;

        switch (localDirection){
            case SOUTH -> {
                front = Direction.SOUTH;
                back = Direction.NORTH;
                left = Direction.WEST;
                right = Direction.EAST;
            }
            case EAST -> {
                front = Direction.EAST;
                back = Direction.WEST;
                left = Direction.SOUTH;
                right = Direction.NORTH;
            }
            case WEST -> {
                front = Direction.WEST;
                back = Direction.EAST;
                left = Direction.NORTH;
                right = Direction.SOUTH;
            }
        }

        if (side == left && slot == OBSIDIAN_TEARS_BUCKET && stack.getItem() == ModFluids.OBSIDIAN_TEARS_BUCKET
        || side == top && slot == AMETHYST_SLOT && stack.getItem() == Items.CRYING_OBSIDIAN){
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        Direction localDirection = this.getWorld().getBlockState(this.pos).get(ExtractorBlock.FACING);

        Direction top = Direction.UP;
        Direction bottom = Direction.DOWN;
        Direction front = Direction.NORTH;
        Direction back = Direction.SOUTH;
        Direction left = Direction.EAST;
        Direction right = Direction.WEST;

        switch (localDirection){
            case SOUTH -> {
                front = Direction.SOUTH;
                back = Direction.NORTH;
                left = Direction.WEST;
                right = Direction.EAST;
            }
            case EAST -> {
                front = Direction.EAST;
                back = Direction.WEST;
                left = Direction.SOUTH;
                right = Direction.NORTH;
            }
            case WEST -> {
                front = Direction.WEST;
                back = Direction.EAST;
                left = Direction.NORTH;
                right = Direction.SOUTH;
            }
        }

        if (side == bottom && slot == OUTPUT_SLOT){
            return true;
        } else {
            return false;
        }
    }
}
