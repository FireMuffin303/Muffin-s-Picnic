package net.firemuffin303.omorbasket.util;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.firemuffin303.omorbasket.common.menu.PicnicBasketMenu;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.function.Supplier;

public class ModPlatform {



    @ExpectPlatform
    public static <T extends Block> Supplier<T> registryBlock(String id, Supplier<T> block){
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends Item> Supplier<T> registryItem(String id,Supplier<T> item){
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends AbstractContainerMenu> MenuType<T> registryMenu(String id, MenuSupplier<T> menu){
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <M extends AbstractContainerMenu,U extends Screen & MenuAccess<M>> void registerScreen(MenuType<M> menuType, ScreenConstructor<M,U> screen){
        throw new NotImplementedException();
    }

    @ExpectPlatform
    public static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String id,ModPlatform.BlockEntitySupplier<T> blockEntityTypeSupplier,Block block){
        throw new AssertionError();
    }

    @ExpectPlatform
    public static CreativeModeTab createCreativeModeTab(ResourceLocation resourceLocation, Supplier<ItemStack> icon, ArrayList<Item> itemList){
        throw new AssertionError();
    }


    @FunctionalInterface
    public interface BlockEntitySupplier<T extends BlockEntity> {
        T create(BlockPos blockPos, BlockState blockState);
    }

    @FunctionalInterface
    public interface MenuSupplier<T extends AbstractContainerMenu> {
        T create(int i, Inventory inventory);
    }

    public interface ScreenConstructor<T extends AbstractContainerMenu, U extends Screen & MenuAccess<T>> {
        U create(T abstractContainerMenu, Inventory inventory, Component component);
    }
}
