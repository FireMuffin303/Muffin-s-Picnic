package net.firemuffin303.omorbasket.common.registry;

import net.firemuffin303.omorbasket.util.ModPlatform;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final Item PICNIC_BASKET = new BlockItem(ModBlocks.PICNIC_BASKET,new Item.Properties().stacksTo(1));

    public static void init(){
        ModPlatform.registryItem("picnic_basket",() ->PICNIC_BASKET);
    }
}
