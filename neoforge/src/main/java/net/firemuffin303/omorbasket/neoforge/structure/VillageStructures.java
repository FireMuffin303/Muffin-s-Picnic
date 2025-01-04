package net.firemuffin303.omorbasket.neoforge.structure;

import net.firemuffin303.omorbasket.PicnicMod;

public class VillageStructures {
    public static void addNewVillageBuilding(net.neoforged.neoforge.event.server.ServerAboutToStartEvent event){
        PicnicMod.initVillagerStructures(event.getServer());
    }
}
