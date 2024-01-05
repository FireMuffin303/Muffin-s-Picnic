package net.firemuffin303.fabric.omorbasket.client;

import net.fabricmc.api.ClientModInitializer;
import net.firemuffin303.omorbasket.client.registry.ModScreens;

public class PicnicBasketFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModScreens.init();
    }
}
