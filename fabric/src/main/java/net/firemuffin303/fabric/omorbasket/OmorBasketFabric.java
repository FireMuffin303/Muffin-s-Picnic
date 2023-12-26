package net.firemuffin303.fabric.omorbasket;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.firemuffin303.omorbasket.OmorBasketMod;
import net.fabricmc.api.ModInitializer;
import net.firemuffin303.omorbasket.common.registry.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OmorBasketFabric implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger(OmorBasketMod.MOD_ID);


    @Override
    public void onInitialize() {
        OmorBasketMod.init();

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(content -> {
            content.accept(ModItems.PICNIC_BASKET);
        });

        ServerLifecycleEvents.SERVER_STARTING.register((server) ->{
            LOGGER.info("Registering structure in village type of plains");
            OmorBasketMod.addToStructurePool(server,
                    new ResourceLocation("minecraft","village/plains/houses"),
                    new ResourceLocation(OmorBasketMod.MOD_ID, "village/plains/picnic"),2);

        });

    }
}
