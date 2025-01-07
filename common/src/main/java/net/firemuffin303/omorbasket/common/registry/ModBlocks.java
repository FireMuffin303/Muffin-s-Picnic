package net.firemuffin303.omorbasket.common.registry;

import net.firemuffin303.omorbasket.common.block.BasketBlock;
import net.firemuffin303.omorbasket.common.block.entity.BasketBlockEntity;
import net.firemuffin303.omorbasket.ModPlatform;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final ArrayList<Supplier<Block>> PICNIC = new ArrayList<>();

    public static final Supplier<Block> WHITE_PICNIC_BASKET = register("white_picnic_basket",() -> new BasketBlock(DyeColor.WHITE, BlockBehaviour.Properties.of()
            .mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).instabreak().ignitedByLava().noOcclusion()));

    public static final Supplier<Block> LIGHT_GRAY_PICNIC_BASKET;
    public static final Supplier<Block> GRAY_PICNIC_BASKET;
    public static final Supplier<Block> BLACK_PICNIC_BASKET;
    public static final Supplier<Block> BROWN_PICNIC_BASKET;
    public static final Supplier<Block> RED_PICNIC_BASKET;
    public static final Supplier<Block> ORANGE_PICNIC_BASKET;
    public static final Supplier<Block> YELLOW_PICNIC_BASKET;
    public static final Supplier<Block> LIME_PICNIC_BASKET;
    public static final Supplier<Block> GREEN_PICNIC_BASKET;
    public static final Supplier<Block> CYAN_PICNIC_BASKET;
    public static final Supplier<Block> LIGHT_BLUE_PICNIC_BASKET;
    public static final Supplier<Block> BLUE_PICNIC_BASKET;
    public static final Supplier<Block> PURPLE_PICNIC_BASKET;
    public static final Supplier<Block> MAGENTA_PICNIC_BASKET;
    public static final Supplier<Block> PINK_PICNIC_BASKET;

    public static void init(){
    }

    public static Supplier<Block> register(String id, Supplier<Block> block){
        Supplier<Block> blockSupplier = ModPlatform.registryBlock(id,block);
        PICNIC.add(blockSupplier);
        return blockSupplier;
    }

    static{

        LIGHT_GRAY_PICNIC_BASKET = register("light_gray_picnic_basket",() -> new BasketBlock(DyeColor.LIGHT_GRAY,BlockBehaviour.Properties.ofFullCopy(ModBlocks.WHITE_PICNIC_BASKET.get())));
        GRAY_PICNIC_BASKET = register("gray_picnic_basket",() -> new BasketBlock(DyeColor.GRAY,BlockBehaviour.Properties.ofFullCopy(ModBlocks.WHITE_PICNIC_BASKET.get())));
        BLACK_PICNIC_BASKET = register("black_picnic_basket",() -> new BasketBlock(DyeColor.BLACK,BlockBehaviour.Properties.ofFullCopy(ModBlocks.WHITE_PICNIC_BASKET.get())));
        BROWN_PICNIC_BASKET = register("brown_picnic_basket",() -> new BasketBlock(DyeColor.BROWN,BlockBehaviour.Properties.ofFullCopy(ModBlocks.WHITE_PICNIC_BASKET.get())));
        RED_PICNIC_BASKET = register("red_picnic_basket",() -> new BasketBlock(DyeColor.RED,BlockBehaviour.Properties.ofFullCopy(ModBlocks.WHITE_PICNIC_BASKET.get())));
        ORANGE_PICNIC_BASKET = register("orange_picnic_basket",() -> new BasketBlock(DyeColor.ORANGE,BlockBehaviour.Properties.ofFullCopy(ModBlocks.WHITE_PICNIC_BASKET.get())));
        YELLOW_PICNIC_BASKET = register("yellow_picnic_basket",() -> new BasketBlock(DyeColor.YELLOW,BlockBehaviour.Properties.ofFullCopy(ModBlocks.WHITE_PICNIC_BASKET.get())));
        LIME_PICNIC_BASKET = register("lime_picnic_basket",() -> new BasketBlock(DyeColor.LIME,BlockBehaviour.Properties.ofFullCopy(ModBlocks.WHITE_PICNIC_BASKET.get())));
        GREEN_PICNIC_BASKET = register("green_picnic_basket",() -> new BasketBlock(DyeColor.GREEN,BlockBehaviour.Properties.ofFullCopy(ModBlocks.WHITE_PICNIC_BASKET.get())));
        CYAN_PICNIC_BASKET = register("cyan_picnic_basket",() -> new BasketBlock(DyeColor.CYAN,BlockBehaviour.Properties.ofFullCopy(ModBlocks.WHITE_PICNIC_BASKET.get())));
        LIGHT_BLUE_PICNIC_BASKET = register("light_blue_picnic_basket",() -> new BasketBlock(DyeColor.LIGHT_BLUE,BlockBehaviour.Properties.ofFullCopy(ModBlocks.WHITE_PICNIC_BASKET.get())));
        BLUE_PICNIC_BASKET = register("blue_picnic_basket",() -> new BasketBlock(DyeColor.BLUE,BlockBehaviour.Properties.ofFullCopy(ModBlocks.WHITE_PICNIC_BASKET.get())));
        PURPLE_PICNIC_BASKET = register("purple_picnic_basket",() -> new BasketBlock(DyeColor.PURPLE,BlockBehaviour.Properties.ofFullCopy(ModBlocks.WHITE_PICNIC_BASKET.get())));
        MAGENTA_PICNIC_BASKET = register("magenta_picnic_basket",() -> new BasketBlock(DyeColor.MAGENTA,BlockBehaviour.Properties.ofFullCopy(ModBlocks.WHITE_PICNIC_BASKET.get())));
        PINK_PICNIC_BASKET = register("pink_picnic_basket",() -> new BasketBlock(DyeColor.PINK,BlockBehaviour.Properties.ofFullCopy(ModBlocks.WHITE_PICNIC_BASKET.get())));
    }

    public static class ModBlockEntityTypes {


        public static Supplier<BlockEntityType<BasketBlockEntity>> BASKET_BLOCK_ENTITY = ModPlatform.registerBlockEntity("picnic_basket",BasketBlockEntity::new,
                WHITE_PICNIC_BASKET.get(),LIGHT_GRAY_PICNIC_BASKET.get(),GRAY_PICNIC_BASKET.get(),BLACK_PICNIC_BASKET.get(),
                        BROWN_PICNIC_BASKET.get(),RED_PICNIC_BASKET.get(),ORANGE_PICNIC_BASKET.get(),YELLOW_PICNIC_BASKET.get(),
                        LIME_PICNIC_BASKET.get(),GREEN_PICNIC_BASKET.get(),CYAN_PICNIC_BASKET.get(),LIGHT_BLUE_PICNIC_BASKET.get(),
                        BLUE_PICNIC_BASKET.get(),PURPLE_PICNIC_BASKET.get(),MAGENTA_PICNIC_BASKET.get(),PINK_PICNIC_BASKET.get());

        public static void init(){
        }
    }
}
