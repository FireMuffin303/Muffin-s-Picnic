package net.firemuffin303.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.firemuffin303.omorbasket.common.registry.ModItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class RecipeLangDataGen extends FabricRecipeProvider {
    public RecipeLangDataGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WHITE_PICNIC_BASKET,1).define('A', ItemTags.WOODEN_SLABS).define('B',Items.WHITE_CARPET).pattern("ABA").pattern("AAA").unlockedBy(getHasName(Items.WHITE_CARPET),has(Items.WHITE_CARPET)).save(exporter,"crafting/"+getItemName(ModItems.WHITE_PICNIC_BASKET)+"_from_crafting");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.LIGHT_GRAY_PICNIC_BASKET,1).define('A', ItemTags.WOODEN_SLABS).define('B',Items.LIGHT_GRAY_CARPET).pattern("ABA").pattern("AAA").unlockedBy(getHasName(Items.LIGHT_GRAY_CARPET),has(Items.LIGHT_GRAY_CARPET)).save(exporter,"crafting/"+getItemName(ModItems.LIGHT_GRAY_PICNIC_BASKET)+"_from_crafting");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RED_PICNIC_BASKET,1).define('A', ItemTags.WOODEN_SLABS).define('B',Items.RED_CARPET).pattern("ABA").pattern("AAA").unlockedBy(getHasName(Items.SPRUCE_SLAB),has(Items.SPRUCE_SLAB)).save(exporter,"crafting/"+getItemName(ModItems.RED_PICNIC_BASKET)+"_from_crafting");

    }
}
