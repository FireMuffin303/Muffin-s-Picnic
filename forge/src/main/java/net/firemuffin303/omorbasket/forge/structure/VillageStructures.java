package net.firemuffin303.omorbasket.forge.structure;

import net.firemuffin303.omorbasket.OmorBasketMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.server.ServerAboutToStartEvent;

public class VillageStructures {
    public static void addNewVillageBuilding(ServerAboutToStartEvent event){
        OmorBasketMod.addToStructurePool(event.getServer(),
                new ResourceLocation("minecraft","village/plains/houses"),
                new ResourceLocation(OmorBasketMod.MOD_ID, "village/plains/picnic"),2);
    }
}
