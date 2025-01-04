package net.firemuffin303.omorbasket.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.TooltipComponentCallback;
import net.firemuffin303.omorbasket.fabric.client.registry.ModBlockEntityRenderer;
import net.firemuffin303.omorbasket.fabric.client.registry.ModScreens;
import net.firemuffin303.omorbasket.ModPlatform;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
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

        TooltipComponentCallback.EVENT.register(tooltipData -> {
            if(tooltipData instanceof BasketTooltipComponent basketTooltipComponent){
                return new BasketTooltipComponent.ClientBasketTooltipComponent(basketTooltipComponent);
            }

            return null;
        });
    }
}
