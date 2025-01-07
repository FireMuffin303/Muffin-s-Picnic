package net.firemuffin303.omorbasket.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.firemuffin303.omorbasket.PicnicMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ChestDataGen extends SimpleFabricLootTableProvider {
    ResourceKey<LootTable> PICNIC_BASKET = ResourceKey.create(Registries.LOOT_TABLE,ResourceLocation.fromNamespaceAndPath(PicnicMod.MOD_ID,"chests/village/picnic_basket"));

    public ChestDataGen(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup, LootContextParamSets.CHEST);
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
        biConsumer.accept(PICNIC_BASKET,
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1,5))
                        .add(LootItem.lootTableItem(Items.COOKIE)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f,6.0f))))
                        .add(LootItem.lootTableItem(Items.HONEY_BOTTLE)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f,2.0f))))
                        .add(LootItem.lootTableItem(Items.BREAD)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f,3.0f))))
                        .add(LootItem.lootTableItem(Items.MELON_SLICE)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f,2.0f))))
                )
        );
    }
}
