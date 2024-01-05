package net.firemuffin303.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ModDataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModelDataGen::new);
        pack.addProvider(BlockLootTableDataGen::new);
        pack.addProvider(ChestDataGen::new);
        pack.addProvider(LangDataGen::new);
        pack.addProvider(RecipeLangDataGen::new);
        pack.addProvider(TagDataGen::new);
    }
}
