package net.firemuffin303.omorbasket.common.menu;

import net.firemuffin303.omorbasket.common.registry.ModItemTags;
import net.firemuffin303.omorbasket.common.registry.ModMenuType;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class PicnicBasketMenu extends AbstractContainerMenu {
    private static final int CONTAINER_SIZE = 9;
    private final Container container;

    public PicnicBasketMenu(int i, Inventory inventory) {
        this(i,inventory,new SimpleContainer(CONTAINER_SIZE));
    }

    public PicnicBasketMenu(int i, Inventory inventory, Container container) {
        super(ModMenuType.PICNIC_BASKET, i);
        checkContainerSize(container,CONTAINER_SIZE);
        this.container = container;
        container.startOpen(inventory.player);

        for(int j = 0; j < 3; ++j) {
            for(int k = 0; k < 3; ++k) {
                this.addSlot(new PicnicBasketSlot(container, k + j * 3, 62 + k * 18, 17 + j * 18));
            }
        }

        for(int j = 0; j < 3; ++j) {
            for(int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(inventory, k + j * 9 + 9, 8 + k * 18, 84 + j * 18));
            }
        }

        for(int j = 0; j < 9; ++j) {
            this.addSlot(new Slot(inventory, j, 8 + j * 18, 142));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = (Slot)this.slots.get(i);
        if (slot != null && slot.hasItem()) {
            ItemStack itemStack2 = slot.getItem();
            itemStack = itemStack2.copy();
            if (i < 9) {
                if (!this.moveItemStackTo(itemStack2, 9, 45, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemStack2, 0, 9, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemStack2);
        }

        return itemStack;
    }

    public void removed(Player player) {
        super.removed(player);
        this.container.stopOpen(player);
    }

    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }

    private static class PicnicBasketSlot extends Slot{

        public PicnicBasketSlot(Container container, int i, int j, int k) {
            super(container, i, j, k);
        }

        @Override
        public boolean mayPlace(ItemStack itemStack) {
            return itemStack.getItem().canFitInsideContainerItems() && !itemStack.is(ModItemTags.PICNIC_BASKET_DISALLOWED);
        }
    }
}
