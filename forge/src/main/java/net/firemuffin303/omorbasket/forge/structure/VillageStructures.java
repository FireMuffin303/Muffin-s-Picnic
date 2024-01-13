package net.firemuffin303.omorbasket.forge.structure;

import net.firemuffin303.omorbasket.PicnicMod;
import net.minecraftforge.event.server.ServerAboutToStartEvent;

public class VillageStructures {
    public static void addNewVillageBuilding(ServerAboutToStartEvent event){
        PicnicMod.initVillagerStructures(event.getServer());
    }
}
