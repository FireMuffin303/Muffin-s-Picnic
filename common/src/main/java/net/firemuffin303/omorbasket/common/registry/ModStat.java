package net.firemuffin303.omorbasket.common.registry;

import net.firemuffin303.omorbasket.ModPlatform;
import net.minecraft.resources.ResourceLocation;

public class ModStat {
    public static ResourceLocation OPEN_PICNIC_BASKET;

    public static void init(){
        OPEN_PICNIC_BASKET = ModPlatform.registryCustomStat("open_picnic_basket");

    }
}
