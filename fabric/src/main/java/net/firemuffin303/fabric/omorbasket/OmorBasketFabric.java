package net.firemuffin303.fabric.omorbasket;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.firemuffin303.omorbasket.PicnicMod;
import net.firemuffin303.omorbasket.common.registry.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OmorBasketFabric implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger(PicnicMod.MOD_ID);


    @Override
    public void onInitialize() {
        PicnicMod.init();

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(content -> {
            ModItems.PICNIC.forEach(content::accept);
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COLORED_BLOCKS).register(content -> {
            ModItems.PICNIC.forEach(content::accept);
        });

        ServerLifecycleEvents.SERVER_STARTING.register((server) ->{
            LOGGER.info("initializing village plains structure");
            PicnicMod.initVillagerStructures(server);
                });
    }
}
