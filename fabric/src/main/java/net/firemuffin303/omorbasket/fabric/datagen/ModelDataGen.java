package net.firemuffin303.omorbasket.fabric.datagen;

import com.mojang.logging.LogUtils;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.firemuffin303.omorbasket.PicnicMod;
import net.firemuffin303.omorbasket.common.block.BasketBlock;
import net.firemuffin303.omorbasket.common.registry.ModBlocks;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;

import java.util.Optional;

public class ModelDataGen extends FabricModelProvider {
    private final ModelTemplate PICNIC_BASKET_INVENTORY = new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(PicnicMod.MOD_ID, "item/picnic_basket_template")), Optional.empty(), TextureSlot.TEXTURE);

    public ModelDataGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        ModBlocks.PICNIC.forEach((block) ->{
            BasketBlock basketBlock = (BasketBlock) block.get();
            PICNIC_BASKET_INVENTORY.create(ModelLocationUtils.getModelLocation(block.get().asItem()), TextureMapping.defaultTexture(ResourceLocation.fromNamespaceAndPath(PicnicMod.MOD_ID,"block/picnic_basket/"+basketBlock.getColor().getName())), blockStateModelGenerator.modelOutput);
        });

        blockStateModelGenerator.blockEntityModels(ResourceLocation.fromNamespaceAndPath(PicnicMod.MOD_ID,"block/picnic_basket"), Blocks.SPRUCE_PLANKS)
                .createWithoutBlockItem(
                        ModBlocks.WHITE_PICNIC_BASKET.get(),
                        ModBlocks.LIGHT_GRAY_PICNIC_BASKET.get(),
                        ModBlocks.GRAY_PICNIC_BASKET.get(),
                        ModBlocks.BLACK_PICNIC_BASKET.get(),
                        ModBlocks.BROWN_PICNIC_BASKET.get(),
                        ModBlocks.RED_PICNIC_BASKET.get(),
                        ModBlocks.ORANGE_PICNIC_BASKET.get(),
                        ModBlocks.YELLOW_PICNIC_BASKET.get(),
                        ModBlocks.LIME_PICNIC_BASKET.get(),
                        ModBlocks.GREEN_PICNIC_BASKET.get(),
                        ModBlocks.LIGHT_BLUE_PICNIC_BASKET.get(),
                        ModBlocks.BLUE_PICNIC_BASKET.get(),
                        ModBlocks.CYAN_PICNIC_BASKET.get(),
                        ModBlocks.PURPLE_PICNIC_BASKET.get(),
                        ModBlocks.MAGENTA_PICNIC_BASKET.get(),
                        ModBlocks.PINK_PICNIC_BASKET.get());

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
    }

    private static ModelTemplate createModBlock(String string, TextureSlot... textureSlots) {
        return new ModelTemplate(Optional.of(ResourceLocation.fromNamespaceAndPath(PicnicMod.MOD_ID, "block/" + string)),Optional.empty(), textureSlots);
    }
}
