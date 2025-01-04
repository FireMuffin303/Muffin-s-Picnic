package net.firemuffin303.omorbasket.common.registry;

import net.firemuffin303.omorbasket.common.BasketColoringRecipe;
import net.firemuffin303.omorbasket.ModPlatform;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;

import java.util.function.Supplier;

public class ModRecipeSerializer {
    public static final Supplier<RecipeSerializer<BasketColoringRecipe>> BASKET_COLORING = ModPlatform.registerRecipeSerializer("basket_coloring",() -> new SimpleCraftingRecipeSerializer<>(BasketColoringRecipe::new));

    public static void init(){}
}
