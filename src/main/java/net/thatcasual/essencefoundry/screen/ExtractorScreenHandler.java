package net.thatcasual.essencefoundry.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.thatcasual.essencefoundry.block.entity.ExtractorBlockEntity;

public class ExtractorScreenHandler extends ScreenHandler {

    public static final int PLAYER_INVENTORY_START_X = 8;
    public static final int PLAYER_INVENTORY_START_Y = 102;
    private static final int PLAYER_HOTBAR_START_X = 8;
    private static final int PLAYER_HOTBAR_START_Y = 160;
    private static final int SLOT_INCREMENT = 18;
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;

    public ExtractorScreenHandler(int syncId, PlayerInventory playerInventory){
        // SimpleInventory size must match block entity inventory size.
        this(syncId, playerInventory, new SimpleInventory(ExtractorBlockEntity.INVENTORY_SIZE), new ArrayPropertyDelegate(4));
    }

    public ExtractorScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate) {
        super(ModScreenHandlers.EXTRACTOR_SCREEN_HANDLER, syncId);
        checkSize(inventory, ExtractorBlockEntity.INVENTORY_SIZE);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);
        this.propertyDelegate = delegate;

        this.addSlot(new Slot(inventory, ExtractorBlockEntity.BUCKET_TO_EMPTY_SLOT, 39, 24));
        this.addSlot(new Slot(inventory, ExtractorBlockEntity.EMPTIED_BUCKET_SLOT, 39, 64));
        this.addSlot(new Slot(inventory, ExtractorBlockEntity.BUCKET_TO_FILL_SLOT, 104, 24));
        this.addSlot(new Slot(inventory, ExtractorBlockEntity.FILLED_BUCKET_SLOT, 104, 64));
        this.addSlot(new Slot(inventory, ExtractorBlockEntity.ITEM_FOR_EXTRACTING_SLOT, 128, 24));
        this.addSlot(new Slot(inventory, ExtractorBlockEntity.EMPTIED_ITEM_SLOT, 128, 64));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(delegate);

    }

    public boolean isCrafting(){
        return propertyDelegate.get(ExtractorBlockEntity.PROGRESS) > 0;
    }

    public int getScaledProgress(){
        int progress = this.propertyDelegate.get(ExtractorBlockEntity.PROGRESS);
        int maxProgress = this.propertyDelegate.get(ExtractorBlockEntity.MAX_PROGRESS);
        int progressArrowSize = 26;
        return maxProgress != 0
                && progress != 0
                ? progress * progressArrowSize / maxProgress : 0;
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()){
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()){
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)){
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)){
                return ItemStack.EMPTY;
            }
            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory){
        for (int y = 0; y < 3; ++y){
            for (int x = 0; x < 9; ++x){
                this.addSlot(new Slot(playerInventory,  x + y * 9 + 9, PLAYER_INVENTORY_START_X + x * SLOT_INCREMENT, PLAYER_INVENTORY_START_Y + y * SLOT_INCREMENT));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory){
        for (int x = 0; x < 9; ++x){
            this.addSlot(new Slot(playerInventory, x, PLAYER_HOTBAR_START_X + x * SLOT_INCREMENT, PLAYER_HOTBAR_START_Y));
        }
    }
}
