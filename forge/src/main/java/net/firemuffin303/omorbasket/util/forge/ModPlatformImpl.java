package net.firemuffin303.omorbasket.util.forge;

import net.firemuffin303.omorbasket.forge.OmorBasketForge;
import net.firemuffin303.omorbasket.util.ModPlatform;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.ArrayList;
import java.util.function.Supplier;

public class ModPlatformImpl {
    public static <T extends Block> Supplier<T> registryBlock(String id, Supplier<T> block) {
        OmorBasketForge.BLOCK.register(id,block);
        return block;
    }


    public static <T extends Item> Supplier<T> registryItem(String id, Supplier<T> item) {
        OmorBasketForge.ITEMS.register(id,item);
        return item;
    }


    public static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String id,ModPlatform.BlockEntitySupplier<T> blockEntityTypeSupplier,Block... block) {
        BlockEntityType<T> blockEntityType = BlockEntityType.Builder.of(blockEntityTypeSupplier::create,block).build(null);
        OmorBasketForge.BLOCK_ENTITY_TYPES.register(id,()->blockEntityType);
        return blockEntityType;
    }

    public static <T extends BlockEntity> BlockEntityType.Builder<T> buildBlockEntity(ModPlatform.BlockEntitySupplier<T> blockEntityTypeSupplier, Block block) {
        return BlockEntityType.Builder.of(blockEntityTypeSupplier::create,block);
    }

    public static <T extends AbstractContainerMenu> MenuType<T> registryMenu(String id, ModPlatform.MenuSupplier<T> menu) {
        MenuType<T> menuType = new MenuType(menu::create, FeatureFlags.VANILLA_SET);
        OmorBasketForge.MENU_TYPE.register(id,() -> menuType);
        return menuType;
    }

    public static <M extends AbstractContainerMenu,U extends Screen & MenuAccess<M>> void registerScreen(MenuType<M> menuType, ModPlatform.ScreenConstructor<M, U> screen) {
        MenuScreens.register(menuType,screen::create);
    }

    public static <T extends Entity> void registerEntityRenderer(EntityType<T> entityTypeSupplier, EntityRendererProvider<T> entityRendererProvider) {
        EntityRenderers.register(entityTypeSupplier, entityRendererProvider);
    }

}
