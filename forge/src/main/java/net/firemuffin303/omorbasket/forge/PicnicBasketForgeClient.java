package net.firemuffin303.omorbasket.forge;

import net.firemuffin303.omorbasket.PicnicMod;
import net.firemuffin303.omorbasket.client.registry.ModBlockEntityRenderer;
import net.firemuffin303.omorbasket.client.registry.ModScreens;
import net.firemuffin303.omorbasket.util.ModPlatform;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = PicnicMod.MOD_ID,value = Dist.CLIENT,bus = Mod.EventBusSubscriber.Bus.MOD)
public class PicnicBasketForgeClient {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        event.enqueueWork(
                ModScreens::init
        ) ;
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

}
