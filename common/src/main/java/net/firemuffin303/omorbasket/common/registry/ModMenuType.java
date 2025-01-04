package net.firemuffin303.omorbasket.common.registry;

import net.firemuffin303.omorbasket.common.menu.PicnicBasketMenu;
import net.firemuffin303.omorbasket.ModPlatform;
import net.minecraft.world.inventory.MenuType;

public class ModMenuType {
    public static MenuType<PicnicBasketMenu> PICNIC_BASKET;

    public static void init(){
        PICNIC_BASKET = ModPlatform.registryMenu("picnic_basket", PicnicBasketMenu::new);
    }
}
