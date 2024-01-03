package net.firemuffin303.omorbasket.common.registry;

import net.firemuffin303.omorbasket.common.item.PicnicBasketItem;
import net.firemuffin303.omorbasket.util.ModPlatform;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final Item RED_PICNIC_BASKET = new PicnicBasketItem(ModBlocks.RED_PICNIC_BASKET);
    public static final Item BLUE_PICNIC_BASKET = new PicnicBasketItem(ModBlocks.BLUE_PICNIC_BASKET);

    public static void init(){
        ModPlatform.registryItem("red_picnic_basket",() -> RED_PICNIC_BASKET);
        ModPlatform.registryItem("blue_picnic_basket",() -> BLUE_PICNIC_BASKET);
    }
}
