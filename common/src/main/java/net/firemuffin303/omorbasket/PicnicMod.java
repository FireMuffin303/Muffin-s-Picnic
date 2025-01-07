package net.firemuffin303.omorbasket;

import com.mojang.datafixers.util.Pair;
import com.mojang.logging.LogUtils;
import net.firemuffin303.omorbasket.common.registry.*;
import net.firemuffin303.omorbasket.mixin.StructurePoolAccessorMixin;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
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

public class PicnicMod {
    public static final String MOD_ID = "muffins_picnic";


    public static void init() {
        LogUtils.getLogger().info("Muffin's Picnic Loaded");
        ModMenuType.init();
        ModBlocks.init();
        ModBlocks.ModBlockEntityTypes.init();
        ModItems.init();
        ModRecipeSerializer.init();
        ModStat.init();
    }

    public static void initVillagerStructures(MinecraftServer server){
        addToStructurePool(server,ResourceLocation.fromNamespaceAndPath("minecraft","village/plains/houses"),
                ResourceLocation.fromNamespaceAndPath(PicnicMod.MOD_ID, "village/plains/picnic"),1);

    }

    //Learned how it worked from Farmer's Delight Fabric
    public static void addToStructurePool(MinecraftServer server, ResourceLocation poolIdentifier, ResourceLocation nbtIdentifier, int weight) {
        Holder<StructureProcessorList> emptyProcessList = server.registryAccess().registryOrThrow(Registries.PROCESSOR_LIST)
                .getHolderOrThrow(ResourceKey.create(Registries.PROCESSOR_LIST, ResourceLocation.fromNamespaceAndPath("minecraft", "empty")));
        Registry<StructureTemplatePool> structureTemplatePools = server.registryAccess().registry(Registries.TEMPLATE_POOL).orElseThrow();

        StructureTemplatePool structure = structureTemplatePools.get(poolIdentifier);

        if(structure == null){
            return;
        }

        SinglePoolElement singlePoolElement = StructurePoolElement.legacy(nbtIdentifier.toString(),emptyProcessList)
                .apply(StructureTemplatePool.Projection.RIGID);

        List<Pair<StructurePoolElement,Integer>> elements = new ArrayList<>(((StructurePoolAccessorMixin)structure).getRawTemplates());
        elements.add(Pair.of(singlePoolElement,weight));
        ((StructurePoolAccessorMixin)structure).setRawTemplates(elements);

        for(int i = 0; i < weight; i++){
            ((StructurePoolAccessorMixin)structure).getTemplates().add(singlePoolElement);
        }
    }

    public enum PicnicAllowance{
        NOT_BLACKLIST,
        ONLY_WHITELIST,
        ONLY_FOOD
    }
}
