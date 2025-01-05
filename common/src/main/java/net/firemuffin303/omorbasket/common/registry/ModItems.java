package net.firemuffin303.omorbasket.common.registry;

import net.firemuffin303.omorbasket.common.item.PicnicBasketItem;
import net.firemuffin303.omorbasket.ModPlatform;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.function.Supplier;

public class ModItems {
    public static final ArrayList<Item> PICNIC = new ArrayList<>();

    public static final Supplier<Item> WHITE_PICNIC_BASKET = register("white_picnic_basket",new PicnicBasketItem(ModBlocks.WHITE_PICNIC_BASKET.get()));
    public static final Supplier<Item> LIGHT_GRAY_PICNIC_BASKET = register("light_gray_picnic_basket",new PicnicBasketItem(ModBlocks.LIGHT_GRAY_PICNIC_BASKET.get()));
    public static final Supplier<Item> GRAY_PICNIC_BASKET = register("gray_picnic_basket",new PicnicBasketItem(ModBlocks.GRAY_PICNIC_BASKET.get()));
    public static final Supplier<Item> BLACK_PICNIC_BASKET = register("black_picnic_basket",new PicnicBasketItem(ModBlocks.BLACK_PICNIC_BASKET.get()));
    public static final Supplier<Item> BROWN_PICNIC_BASKET = register("brown_picnic_basket",new PicnicBasketItem(ModBlocks.BROWN_PICNIC_BASKET.get()));
    public static final Supplier<Item> RED_PICNIC_BASKET = register( "red_picnic_basket",new PicnicBasketItem(ModBlocks.RED_PICNIC_BASKET.get()));
    public static final Supplier<Item> ORANGE_PICNIC_BASKET = register("orange_picnic_basket",new PicnicBasketItem(ModBlocks.ORANGE_PICNIC_BASKET.get()));
    public static final Supplier<Item> YELLOW_PICNIC_BASKET = register("yellow_picnic_basket",new PicnicBasketItem(ModBlocks.YELLOW_PICNIC_BASKET.get()));
    public static final Supplier<Item> LIME_PICNIC_BASKET = register("lime_picnic_basket",new PicnicBasketItem(ModBlocks.LIME_PICNIC_BASKET.get()));
    public static final Supplier<Item> GREEN_PICNIC_BASKET = register("green_picnic_basket",new PicnicBasketItem(ModBlocks.GREEN_PICNIC_BASKET.get()));
    public static final Supplier<Item> CYAN_PICNIC_BASKET = register("cyan_picnic_basket",new PicnicBasketItem(ModBlocks.CYAN_PICNIC_BASKET.get()));
    public static final Supplier<Item> LIGHT_BLUE_PICNIC_BASKET = register("light_blue_picnic_basket",new PicnicBasketItem(ModBlocks.LIGHT_BLUE_PICNIC_BASKET.get()));
    public static final Supplier<Item> BLUE_PICNIC_BASKET = register("blue_picnic_basket",new PicnicBasketItem(ModBlocks.BLUE_PICNIC_BASKET.get()));
    public static final Supplier<Item> PURPLE_PICNIC_BASKET = register("purple_picnic_basket",new PicnicBasketItem(ModBlocks.PURPLE_PICNIC_BASKET.get()));
    public static final Supplier<Item> MAGENTA_PICNIC_BASKET = register("magenta_picnic_basket",new PicnicBasketItem(ModBlocks.MAGENTA_PICNIC_BASKET.get()));
    public static final Supplier<Item> PINK_PICNIC_BASKET = register("pink_picnic_basket",new PicnicBasketItem(ModBlocks.PINK_PICNIC_BASKET.get()));

    public static void init(){}

    private static Supplier<Item> register(String id, Item item){
        PICNIC.add(item);
        return ModPlatform.registryItem(id,() -> item);
    }
}
