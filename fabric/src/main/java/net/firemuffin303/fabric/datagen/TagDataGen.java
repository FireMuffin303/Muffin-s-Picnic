package net.firemuffin303.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.firemuffin303.omorbasket.common.registry.ModItemTags;
import net.firemuffin303.omorbasket.common.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TagDataGen extends FabricTagProvider.ItemTagProvider{
    public TagDataGen(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture, null);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        ModItems.PICNIC.forEach((item) ->{
            getOrCreateTagBuilder(ModItemTags.PICNIC_BASKET_DISALLOWED)
                    .add(item);
        });

        //getOrCreateTagBuilder(ModItemTags.PICNIC_BASKET_DISALLOWED)
        //        .addTag(TagKey.create(Registries.ITEM,new ResourceLocation("create","toolboxes")));


    }
}
