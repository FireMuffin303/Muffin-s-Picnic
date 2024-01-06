package net.firemuffin303.fabric.omorbasket.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.firemuffin303.omorbasket.OmorBasketMod;
import net.firemuffin303.omorbasket.client.registry.ModBlockEntityRenderer;
import net.firemuffin303.omorbasket.client.registry.ModScreens;
import net.firemuffin303.omorbasket.common.registry.ModBlocks;
import net.firemuffin303.omorbasket.util.ModPlatform;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class PicnicBasketFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModBlockEntityRenderer.registerBlockEntityRenderer(new ModPlatform.BlockEntityRendererRegistry() {
            @Override
            public <T extends BlockEntity> void register(BlockEntityType<T> entityType, BlockEntityRendererProvider<T> blockEntityRendererProvider) {
                net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry.register(entityType,blockEntityRendererProvider);
            }
        });

        ModBlockEntityRenderer.registerLayerDefinition(new ModPlatform.LayerDefinitionRegistry() {
            @Override
            public void register(ModelLayerLocation location, Supplier<LayerDefinition> definition) {
                EntityModelLayerRegistry.registerModelLayer(location, definition::get);
            }
        });

        ModScreens.init();

    }
}
