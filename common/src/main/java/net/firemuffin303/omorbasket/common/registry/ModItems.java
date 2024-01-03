package net.firemuffin303.omorbasket.common.registry;

import net.firemuffin303.omorbasket.common.item.PicnicBasketItem;
import net.firemuffin303.omorbasket.util.ModPlatform;
import net.minecraft.world.item.Item;

import java.util.ArrayList;

public class ModItems {
    public static final ArrayList<Item> PICNIC = new ArrayList<>();

    public static final Item WHITE_PICNIC_BASKET = new PicnicBasketItem(ModBlocks.WHITE_PICNIC_BASKET);
    public static final Item LIGHT_GRAY_PICNIC_BASKET = new PicnicBasketItem(ModBlocks.LIGHT_GRAY_PICNIC_BASKET);
    public static final Item GRAY_PICNIC_BASKET = new PicnicBasketItem(ModBlocks.GRAY_PICNIC_BASKET);
    public static final Item BLACK_PICNIC_BASKET = new PicnicBasketItem(ModBlocks.BLACK_PICNIC_BASKET);
    public static final Item BROWN_PICNIC_BASKET = new PicnicBasketItem(ModBlocks.BROWN_PICNIC_BASKET);
    public static final Item RED_PICNIC_BASKET = new PicnicBasketItem(ModBlocks.RED_PICNIC_BASKET);
    public static final Item ORANGE_PICNIC_BASKET = new PicnicBasketItem(ModBlocks.ORANGE_PICNIC_BASKET);
    public static final Item YELLOW_PICNIC_BASKET = new PicnicBasketItem(ModBlocks.YELLOW_PICNIC_BASKET);
    public static final Item LIME_PICNIC_BASKET = new PicnicBasketItem(ModBlocks.LIME_PICNIC_BASKET);
    public static final Item GREEN_PICNIC_BASKET = new PicnicBasketItem(ModBlocks.GREEN_PICNIC_BASKET);
    public static final Item CYAN_PICNIC_BASKET = new PicnicBasketItem(ModBlocks.CYAN_PICNIC_BASKET);
    public static final Item LIGHT_BLUE_PICNIC_BASKET = new PicnicBasketItem(ModBlocks.LIGHT_BLUE_PICNIC_BASKET);
    public static final Item BLUE_PICNIC_BASKET = new PicnicBasketItem(ModBlocks.BLUE_PICNIC_BASKET);
    public static final Item PURPLE_PICNIC_BASKET = new PicnicBasketItem(ModBlocks.PURPLE_PICNIC_BASKET);
    public static final Item MAGENTA_PICNIC_BASKET = new PicnicBasketItem(ModBlocks.MAGENTA_PICNIC_BASKET);
    public static final Item PINK_PICNIC_BASKET = new PicnicBasketItem(ModBlocks.PINK_PICNIC_BASKET);

    public static void init(){
        register("white_picnic_basket",WHITE_PICNIC_BASKET);
        register("light_gray_picnic_basket",LIGHT_GRAY_PICNIC_BASKET);
        register("gray_picnic_basket",GRAY_PICNIC_BASKET);
        register("black_picnic_basket",BLACK_PICNIC_BASKET);
        register("brown_picnic_basket",BROWN_PICNIC_BASKET);
        register("red_picnic_basket",RED_PICNIC_BASKET);
        register("orange_picnic_basket",ORANGE_PICNIC_BASKET);
        register("yellow_picnic_basket",YELLOW_PICNIC_BASKET);
        register("lime_picnic_basket",LIME_PICNIC_BASKET);
        register("green_picnic_basket",GREEN_PICNIC_BASKET);
        register("cyan_picnic_basket",CYAN_PICNIC_BASKET);
        register("light_blue_picnic_basket",LIGHT_BLUE_PICNIC_BASKET);
        register("blue_picnic_basket",BLUE_PICNIC_BASKET);
        register("purple_picnic_basket",PURPLE_PICNIC_BASKET);
        register("magenta_picnic_basket",MAGENTA_PICNIC_BASKET);
        register("pink_picnic_basket",PINK_PICNIC_BASKET);
    }

    private static void register(String id, Item item){
        ModPlatform.registryItem(id,() -> item);
        PICNIC.add(item);
    }
}
