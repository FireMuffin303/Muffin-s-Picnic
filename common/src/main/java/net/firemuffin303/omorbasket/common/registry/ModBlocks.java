package net.firemuffin303.omorbasket.common.registry;

import net.firemuffin303.omorbasket.common.block.BasketBlock;
import net.firemuffin303.omorbasket.common.block.entity.BasketBlockEntity;
import net.firemuffin303.omorbasket.util.ModPlatform;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class ModBlocks {
    public static final Block RED_PICNIC_BASKET = new BasketBlock(
            BlockBehaviour.Properties.of()
                            .mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                            .strength(2.5F).sound(SoundType.WOOD)
                    .instabreak()
                    .ignitedByLava().noOcclusion());

    public static final Block BLUE_PICNIC_BASKET = new BasketBlock(BlockBehaviour.Properties.copy(ModBlocks.RED_PICNIC_BASKET));

    public static void init(){
        ModPlatform.registryBlock("red_picnic_basket",() -> RED_PICNIC_BASKET);
        ModPlatform.registryBlock("blue_picnic_basket",() -> BLUE_PICNIC_BASKET);
    }

    public static class ModBlockEntityTypes {
        public static BlockEntityType<BasketBlockEntity> BASKET_BLOCK_ENTITY;

        public static void init(){
            BASKET_BLOCK_ENTITY = ModPlatform.registerBlockEntity("picnic_basket",BasketBlockEntity::new, ModBlocks.RED_PICNIC_BASKET);
        }
    }
}
