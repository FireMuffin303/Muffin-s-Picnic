package net.firemuffin303.omorbasket.util.fabric;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.firemuffin303.omorbasket.OmorBasketMod;
import net.firemuffin303.omorbasket.util.ModPlatform;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
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
        Registry.register(BuiltInRegistries.BLOCK,new ResourceLocation(OmorBasketMod.MOD_ID,id),block.get());
        return block;
    }


    public static <T extends Item> Supplier<T> registryItem(String id, Supplier<T> item) {
        Registry.register(BuiltInRegistries.ITEM,new ResourceLocation(OmorBasketMod.MOD_ID,id),item.get());
        return item;
    }

    public static CreativeModeTab createCreativeModeTab(ResourceLocation resourceLocation, Supplier<ItemStack> icon, ArrayList<Item> itemList) {
        CreativeModeTab creativeModeTab = FabricItemGroup.builder()
                .title(Component.translatable("itemGroup."+resourceLocation.getNamespace()+"."+resourceLocation.getPath()))
                .icon(icon)
                .displayItems((itemDisplayParameters, output) -> itemList.forEach(output::accept)).build();
        CreativeModeTab creativeModeTab1 = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,resourceLocation,creativeModeTab);
        return creativeModeTab1;
    }

    public static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String id,ModPlatform.BlockEntitySupplier<T> blockEntityTypeSupplier,Block block) {
        BlockEntityType<T> blockEntityType = BlockEntityType.Builder.of(blockEntityTypeSupplier::create,block).build(null);
        Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,new ResourceLocation(OmorBasketMod.MOD_ID,id),blockEntityType);
        return blockEntityType;
    }

    public static <T extends AbstractContainerMenu> void registryMenu(String id, ModPlatform.MenuSupplier<T> menu) {
        Registry.register(BuiltInRegistries.MENU,new ResourceLocation(OmorBasketMod.MOD_ID,id),new MenuType(menu::create, FeatureFlags.VANILLA_SET));
    }

}
