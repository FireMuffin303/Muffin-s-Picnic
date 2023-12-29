package net.firemuffin303.omorbasket;

import com.mojang.datafixers.util.Pair;
import net.firemuffin303.omorbasket.common.registry.ModBlocks;
import net.firemuffin303.omorbasket.common.registry.ModItems;
import net.firemuffin303.omorbasket.mixin.StructurePoolAccessorMixin;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class OmorBasketMod {
    public static final String MOD_ID = "omorbasket";



    public static void init() {
        ModBlocks.ModBlockEntityTypes.init();
        ModBlocks.init();
        ModItems.init();
    }

    public static void addToStructurePool(MinecraftServer server, ResourceLocation poolIdentifier, ResourceLocation nbtIdentifier, int weight) {
        Holder.Reference<StructureProcessorList> emptyProcessorList = server.registryAccess().registryOrThrow(Registries.PROCESSOR_LIST)
                .getHolderOrThrow(ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation("minecraft", "empty")));

        server.registryAccess().registryOrThrow(Registries.TEMPLATE_POOL).getOptional(poolIdentifier).ifPresentOrElse((structurePool) -> {
            SinglePoolElement singlePoolElement = (SinglePoolElement) StructurePoolElement.legacy(nbtIdentifier.toString(), emptyProcessorList).apply(StructureTemplatePool.Projection.RIGID);
            List<Pair<StructurePoolElement, Integer>> elementCounts = new ArrayList(((StructurePoolAccessorMixin)structurePool).getRawTemplates());
            elementCounts.add(Pair.of(singlePoolElement, weight));
            ((StructurePoolAccessorMixin)structurePool).setRawTemplates(elementCounts);
            IntStream.range(0, weight).forEach((value) -> {
                ((StructurePoolAccessorMixin)structurePool).getTemplates().add(singlePoolElement);
                //LOGGER.info( ((StructurePoolAccessorMixin)structurePool).getTemplates().toString());

            });
        }, () -> {

        });
    }
}
