package net.firemuffin303.omorbasket.neoforge;

import net.firemuffin303.omorbasket.PicnicMod;
import net.firemuffin303.omorbasket.client.BasketTooltipComponent;
import net.firemuffin303.omorbasket.client.registry.ModBlockEntityRenderer;
import net.firemuffin303.omorbasket.client.registry.ModScreens;
import net.firemuffin303.omorbasket.ModPlatform;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterClientTooltipComponentFactoriesEvent;

import java.util.function.Supplier;

@EventBusSubscriber(modid = PicnicMod.MOD_ID,bus = EventBusSubscriber.Bus.MOD)
public class PicnicBasketNeoForgeClient {

    public static void init(){}

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        event.enqueueWork(ModScreens::init) ;
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event){
        ModBlockEntityRenderer.registerLayerDefinition(new ModPlatform.LayerDefinitionRegistry() {
            @Override
            public void register(ModelLayerLocation location, Supplier<LayerDefinition> definition) {
                event.registerLayerDefinition(location,definition);
            }
        });
    }

    @SubscribeEvent
    public static void registerRenderer(EntityRenderersEvent.RegisterRenderers event){
        ModBlockEntityRenderer.registerBlockEntityRenderer(new ModPlatform.BlockEntityRendererRegistry() {
            @Override
            public <T extends BlockEntity> void register(BlockEntityType<T> entityType, BlockEntityRendererProvider<T> blockEntityRendererProvider) {
                event.registerBlockEntityRenderer(entityType,blockEntityRendererProvider);
            }
        });
    }

    @SubscribeEvent
    public static void registerTooltip(RegisterClientTooltipComponentFactoriesEvent tooltipEvent){
        tooltipEvent.register(BasketTooltipComponent.class, BasketTooltipComponent.ClientBasketTooltipComponent::new);
    }

}
