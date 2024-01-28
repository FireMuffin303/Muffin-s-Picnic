package net.firemuffin303.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.firemuffin303.omorbasket.common.registry.ModItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class RecipeLangDataGen extends FabricRecipeProvider {

    public RecipeLangDataGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        picnic(ModItems.WHITE_PICNIC_BASKET,Items.WHITE_CARPET,exporter);
        picnic(ModItems.LIGHT_GRAY_PICNIC_BASKET,Items.LIGHT_GRAY_CARPET,exporter);
        picnic(ModItems.GRAY_PICNIC_BASKET,Items.GRAY_CARPET,exporter);
        picnic(ModItems.BLACK_PICNIC_BASKET,Items.BLACK_CARPET,exporter);
        picnic(ModItems.BROWN_PICNIC_BASKET,Items.BROWN_CARPET,exporter);
        picnic(ModItems.RED_PICNIC_BASKET,Items.RED_CARPET,exporter);
        picnic(ModItems.ORANGE_PICNIC_BASKET,Items.ORANGE_CARPET,exporter);
        picnic(ModItems.YELLOW_PICNIC_BASKET,Items.YELLOW_CARPET,exporter);
        picnic(ModItems.LIME_PICNIC_BASKET,Items.LIME_CARPET,exporter);
        picnic(ModItems.GREEN_PICNIC_BASKET,Items.GREEN_CARPET,exporter);
        picnic(ModItems.CYAN_PICNIC_BASKET,Items.CYAN_CARPET,exporter);
        picnic(ModItems.LIGHT_BLUE_PICNIC_BASKET,Items.LIGHT_BLUE_CARPET,exporter);
        picnic(ModItems.BLUE_PICNIC_BASKET,Items.BLUE_CARPET,exporter);
        picnic(ModItems.PURPLE_PICNIC_BASKET,Items.PURPLE_CARPET,exporter);
        picnic(ModItems.MAGENTA_PICNIC_BASKET,Items.MAGENTA_CARPET,exporter);
        picnic(ModItems.PINK_PICNIC_BASKET,Items.PINK_CARPET,exporter);

    }

    public void picnic(Item result,Item carpet,Consumer<FinishedRecipe> consumer){
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS,result,1)
                .define('A',ItemTags.WOODEN_SLABS)
                .define('B',carpet)
                .define('C',ItemTags.PLANKS)
                .pattern("AAA")
                .pattern("CBC")
                .pattern("CCC")
                .unlockedBy(getHasName(carpet),has(carpet))
                .save(consumer, "crafting/"+getItemName(result)+"_from_crafting");
    }

}
