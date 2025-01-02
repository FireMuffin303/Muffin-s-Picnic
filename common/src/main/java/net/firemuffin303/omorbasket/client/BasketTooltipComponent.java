package net.firemuffin303.omorbasket.client;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.core.NonNullList;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;

public class BasketTooltipComponent implements TooltipComponent {
    public final NonNullList<ItemStack> items;

    public BasketTooltipComponent(NonNullList<ItemStack> items){
        this.items = items;
    }

    public NonNullList<ItemStack> getItems() {
        return items;
    }

    public static class ClientBasketTooltipComponent implements ClientTooltipComponent{
        public final NonNullList<ItemStack> items;

        public ClientBasketTooltipComponent(BasketTooltipComponent basketTooltipComponent){
            this.items = basketTooltipComponent.items;
        }

        @Override
        public void renderImage(Font font, int x, int y, GuiGraphics guiGraphics) {
            int itemX = x;
            int itemY= y;
            int index = 0;
            for(int i = 0; i < this.items.size();i++){
                ItemStack itemStack = this.items.get(i);
                guiGraphics.renderItem(itemStack,itemX,itemY,index);
                guiGraphics.renderItemDecorations(font,itemStack,itemX,itemY);
                itemX += 18;
                index++;
                if( index % 3 == 0 && index != 0){
                    itemX = x;
                    itemY += 18;
                }
            }
        }

        @Override
        public int getHeight() {
            return Mth.ceil(this.items.size() / 3f) * 18;
        }

        @Override
        public int getWidth(Font font) {
            return (this.items.size() / 3) * 18;
        }
    }
}
