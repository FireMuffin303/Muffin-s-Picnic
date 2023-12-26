package net.firemuffin303.omorbasket.util.forge;

import net.firemuffin303.omorbasket.forge.OmorBasketForge;
import net.firemuffin303.omorbasket.util.ModPlatform;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.AbstractContainerMenu;
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


    public static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String id,ModPlatform.BlockEntitySupplier<T> blockEntityTypeSupplier,Block block) {
        BlockEntityType<T> blockEntityType = BlockEntityType.Builder.of(blockEntityTypeSupplier::create,block).build(null);
        OmorBasketForge.BLOCK_ENTITY_TYPES.register(id,()->blockEntityType);
        return blockEntityType;
    }

    public static <T extends BlockEntity> BlockEntityType.Builder<T> buildBlockEntity(ModPlatform.BlockEntitySupplier<T> blockEntityTypeSupplier, Block block) {
        return BlockEntityType.Builder.of(blockEntityTypeSupplier::create,block);
    }

    public static <T extends AbstractContainerMenu> void registryMenu(String id, ModPlatform.MenuSupplier<T> menu) {

    }
}
