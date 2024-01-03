package net.firemuffin303.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.firemuffin303.omorbasket.OmorBasketMod;
import net.firemuffin303.omorbasket.common.registry.ModBlocks;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class ModelDataGen extends FabricModelProvider {

    public ModelDataGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        ModBlocks.PICNIC.forEach((block) -> {
            blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block,Variant.variant().with(VariantProperties.MODEL,new ResourceLocation("omorbasket","block/picnic_basket")))
                    .with(BlockModelGenerators.createHorizontalFacingDispatch()));
        });
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
    }

    private static ModelTemplate createModBlock(String string, TextureSlot... textureSlots) {
        return new ModelTemplate(Optional.of(new ResourceLocation(OmorBasketMod.MOD_ID, "block/" + string)),Optional.empty(), textureSlots);
    }
}
