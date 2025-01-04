package net.firemuffin303.omorbasket.fabric.client.registry;

import net.firemuffin303.omorbasket.fabric.client.screens.PicnicBasketScreen;
import net.firemuffin303.omorbasket.common.registry.ModMenuType;
import net.firemuffin303.omorbasket.ModPlatform;

public class ModScreens {
    public static void init(){
        ModPlatform.registerScreen(ModMenuType.PICNIC_BASKET, PicnicBasketScreen::new);
    }
}
