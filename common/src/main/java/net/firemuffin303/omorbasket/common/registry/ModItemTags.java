package net.firemuffin303.omorbasket.common.registry;

import net.firemuffin303.omorbasket.PicnicMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> PICNIC_BASKET_DISALLOWED = TagKey.create(Registries.ITEM, new ResourceLocation(PicnicMod.MOD_ID,"picnic_basket_disallowed"));

}
