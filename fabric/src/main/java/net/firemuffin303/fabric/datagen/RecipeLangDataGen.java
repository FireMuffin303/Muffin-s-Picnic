package net.firemuffin303.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.firemuffin303.omorbasket.common.registry.ModItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class RecipeLangDataGen extends FabricRecipeProvider {
    public RecipeLangDataGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PICNIC_BASKET,1).define('A', Items.SPRUCE_SLAB).define('B',Items.RED_CARPET).pattern("ABA").pattern("AAA").unlockedBy(getHasName(Items.SPRUCE_SLAB),has(Items.SPRUCE_SLAB)).save(exporter,"crafting/"+getItemName(ModItems.PICNIC_BASKET)+"_from_crafting");

    }
}
