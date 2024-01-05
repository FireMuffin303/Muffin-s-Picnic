package net.firemuffin303.omorbasket.common.registry;

import net.firemuffin303.omorbasket.common.block.BasketBlock;
import net.firemuffin303.omorbasket.common.block.entity.BasketBlockEntity;
import net.firemuffin303.omorbasket.util.ModPlatform;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.ArrayList;

public class ModBlocks {
    public static final ArrayList<Block> PICNIC = new ArrayList<>();

    public static final Block WHITE_PICNIC_BASKET = new BasketBlock(DyeColor.WHITE,
            BlockBehaviour.Properties.of()
                            .mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                            .strength(2.5F).sound(SoundType.WOOD)
                    .instabreak()
                    .ignitedByLava().noOcclusion());

    public static final Block LIGHT_GRAY_PICNIC_BASKET = new BasketBlock(DyeColor.LIGHT_GRAY,BlockBehaviour.Properties.copy(ModBlocks.WHITE_PICNIC_BASKET));
    public static final Block GRAY_PICNIC_BASKET = new BasketBlock(DyeColor.GRAY,BlockBehaviour.Properties.copy(ModBlocks.WHITE_PICNIC_BASKET));
    public static final Block BLACK_PICNIC_BASKET = new BasketBlock(DyeColor.BLACK,BlockBehaviour.Properties.copy(ModBlocks.WHITE_PICNIC_BASKET));
    public static final Block BROWN_PICNIC_BASKET = new BasketBlock(DyeColor.BROWN,BlockBehaviour.Properties.copy(ModBlocks.WHITE_PICNIC_BASKET));
    public static final Block RED_PICNIC_BASKET = new BasketBlock(DyeColor.RED,BlockBehaviour.Properties.copy(ModBlocks.WHITE_PICNIC_BASKET));
    public static final Block ORANGE_PICNIC_BASKET = new BasketBlock(DyeColor.ORANGE,BlockBehaviour.Properties.copy(ModBlocks.WHITE_PICNIC_BASKET));
    public static final Block YELLOW_PICNIC_BASKET = new BasketBlock(DyeColor.YELLOW,BlockBehaviour.Properties.copy(ModBlocks.WHITE_PICNIC_BASKET));
    public static final Block LIME_PICNIC_BASKET = new BasketBlock(DyeColor.LIME,BlockBehaviour.Properties.copy(ModBlocks.WHITE_PICNIC_BASKET));
    public static final Block GREEN_PICNIC_BASKET = new BasketBlock(DyeColor.GREEN,BlockBehaviour.Properties.copy(ModBlocks.WHITE_PICNIC_BASKET));
    public static final Block CYAN_PICNIC_BASKET = new BasketBlock(DyeColor.CYAN,BlockBehaviour.Properties.copy(ModBlocks.WHITE_PICNIC_BASKET));
    public static final Block LIGHT_BLUE_PICNIC_BASKET = new BasketBlock(DyeColor.LIGHT_BLUE,BlockBehaviour.Properties.copy(ModBlocks.WHITE_PICNIC_BASKET));
    public static final Block BLUE_PICNIC_BASKET = new BasketBlock(DyeColor.BLUE,BlockBehaviour.Properties.copy(ModBlocks.WHITE_PICNIC_BASKET));
    public static final Block PURPLE_PICNIC_BASKET = new BasketBlock(DyeColor.PURPLE,BlockBehaviour.Properties.copy(ModBlocks.WHITE_PICNIC_BASKET));
    public static final Block MAGENTA_PICNIC_BASKET = new BasketBlock(DyeColor.MAGENTA,BlockBehaviour.Properties.copy(ModBlocks.WHITE_PICNIC_BASKET));
    public static final Block PINK_PICNIC_BASKET = new BasketBlock(DyeColor.PINK,BlockBehaviour.Properties.copy(ModBlocks.WHITE_PICNIC_BASKET));

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

    public static void register(String id,Block block){
        ModPlatform.registryBlock(id,() -> block);
        PICNIC.add(block);
    }

    public static class ModBlockEntityTypes {
        public static BlockEntityType<BasketBlockEntity> BASKET_BLOCK_ENTITY;

        public static void init(){
            BASKET_BLOCK_ENTITY = ModPlatform.registerBlockEntity("picnic_basket",BasketBlockEntity::new, ModBlocks.WHITE_PICNIC_BASKET);
        }
    }
}
