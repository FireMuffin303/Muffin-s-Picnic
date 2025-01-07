package net.firemuffin303.omorbasket.common.item;

import net.firemuffin303.omorbasket.client.BasketTooltipComponent;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class PicnicBasketItem extends BlockItem {
    public PicnicBasketItem(Block block) {
        super(block, new Properties().stacksTo(1).component(DataComponents.CONTAINER,ItemContainerContents.EMPTY));
    }

    private static Stream<ItemStack> getContents(ItemStack itemStack) {
        ItemContainerContents containerContents = itemStack.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY);
        return containerContents.nonEmptyStream();
    }

    public @NotNull Optional<TooltipComponent> getTooltipImage(ItemStack itemStack) {
        NonNullList<ItemStack> nonNullList = NonNullList.create();
        Stream<ItemStack> var10000 = getContents(itemStack);
        Objects.requireNonNull(nonNullList);
        var10000.forEach(nonNullList::add);
        return Optional.of(new BasketTooltipComponent(nonNullList));
    }

    @Override
    public boolean canFitInsideContainerItems() {
        return false;
    }
}
