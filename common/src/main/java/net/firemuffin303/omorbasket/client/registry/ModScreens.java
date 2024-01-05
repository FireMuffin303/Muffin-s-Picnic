package net.firemuffin303.omorbasket.client.registry;

import net.firemuffin303.omorbasket.client.screens.PicnicBasketScreen;
import net.firemuffin303.omorbasket.common.menu.PicnicBasketMenu;
import net.firemuffin303.omorbasket.common.registry.ModMenuType;
import net.firemuffin303.omorbasket.util.ModPlatform;

public class ModScreens {
    public static void init(){
        ModPlatform.registerScreen(ModMenuType.PICNIC_BASKET, PicnicBasketScreen::new);
    }
}
