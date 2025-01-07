package net.firemuffin303.omorbasket.neoforge;

import com.mojang.logging.LogUtils;
import net.firemuffin303.omorbasket.PicnicMod;
import net.firemuffin303.omorbasket.ModPlatform;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.common.Tags;

import java.util.function.Supplier;

public class ModPlatformImpl {
    public static <T extends Block> Supplier<T> registryBlock(String id, Supplier<T> block) {
        return OmorBasketNeoForge.BLOCK.register(id,block);
    }


    public static <T extends Item> Supplier<T> registryItem(String id, Supplier<T> item) {
        return OmorBasketNeoForge.ITEMS.register(id,item);
    }


    public static <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, ModPlatform.BlockEntitySupplier<T> blockEntityTypeSupplier, Block... blocks) {
        return OmorBasketNeoForge.BLOCK_ENTITY_TYPES.register(id,()-> BlockEntityType.Builder.of(blockEntityTypeSupplier::create,blocks).build(null));
    }

    public static <T extends AbstractContainerMenu> MenuType<T> registryMenu(String id, ModPlatform.MenuSupplier<T> menu) {
        MenuType<T> menuType = new MenuType(menu::create, FeatureFlags.VANILLA_SET);
        OmorBasketNeoForge.MENU_TYPE.register(id,() -> menuType);
        return menuType;
    }

    public static <M extends AbstractContainerMenu,U extends Screen & MenuAccess<M>> void registerScreen(MenuType<M> menuType, ModPlatform.ScreenConstructor<M, U> screen) {
        MenuScreens.register(menuType,screen::create);
    }

    public static <T extends Entity> void registerEntityRenderer(EntityType<T> entityTypeSupplier, EntityRendererProvider<T> entityRendererProvider) {
        EntityRenderers.register(entityTypeSupplier, entityRendererProvider);
    }

    public static ResourceLocation registryCustomStat(String id) {
        ResourceLocation resourceLocation = new ResourceLocation(PicnicMod.MOD_ID,id);
        OmorBasketNeoForge.CUSTOM_STAT.register(id,() -> resourceLocation);
        //Stats.CUSTOM.get(resourceLocation, StatFormatter.DEFAULT);
        return resourceLocation;
    }

    public static <T extends Recipe<?>> Supplier<RecipeSerializer<T>> registerRecipeSerializer(String id, Supplier<RecipeSerializer<T>> recipeSerializer) {
        return OmorBasketNeoForge.RECIPE_SERIALIZERS.register(id,recipeSerializer);
    }

    public static PicnicMod.PicnicAllowance getPicnicAllowance(Level level) {
        int i = level.getGameRules().getRule(OmorBasketNeoForge.PICNIC_ALLOWANCE).get();
        switch(i){
            case 0,1 -> {
                return PicnicMod.PicnicAllowance.NOT_BLACKLIST;
            }
            case 2 -> {
                return PicnicMod.PicnicAllowance.ONLY_WHITELIST;
            }

            default -> {
                return PicnicMod.PicnicAllowance.ONLY_FOOD;
            }
        }
    }

    public static boolean getFoodTag(ItemStack itemStack) {
        return itemStack.is(Tags.Items.FOODS);
    }

}
