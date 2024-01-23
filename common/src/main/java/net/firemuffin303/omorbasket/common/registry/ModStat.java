package net.firemuffin303.omorbasket.common.registry;

import net.firemuffin303.omorbasket.PicnicMod;
import net.firemuffin303.omorbasket.util.ModPlatform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;

public class ModStat {
    public static ResourceLocation OPEN_PICNIC_BASKET;

    public static void init(){
        OPEN_PICNIC_BASKET = ModPlatform.registryCustomStat("open_picnic_basket");

    }
}
