package net.firemuffin303.omorbasket.fabric.client.registry;

import net.firemuffin303.omorbasket.fabric.client.renderer.PicnicBasketRenderer;
import net.firemuffin303.omorbasket.common.registry.ModBlocks;
import net.firemuffin303.omorbasket.ModPlatform;

public class ModBlockEntityRenderer {
    public static void registerLayerDefinition(ModPlatform.LayerDefinitionRegistry registry){
        registry.register(PicnicBasketRenderer.LAYER,PicnicBasketRenderer::createLayer);
    }

    public static void registerBlockEntityRenderer(ModPlatform.BlockEntityRendererRegistry registry){
        registry.register(ModBlocks.ModBlockEntityTypes.BASKET_BLOCK_ENTITY, PicnicBasketRenderer::new);
    }
}
