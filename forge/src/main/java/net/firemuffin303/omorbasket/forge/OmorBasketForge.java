package net.firemuffin303.omorbasket.forge;

import net.firemuffin303.omorbasket.OmorBasketMod;
import net.firemuffin303.omorbasket.common.registry.ModBlocks;
import net.firemuffin303.omorbasket.common.registry.ModItems;
import net.firemuffin303.omorbasket.forge.structure.VillageStructures;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.CreativeModeTabRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod(OmorBasketMod.MOD_ID)
public class OmorBasketForge {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES,OmorBasketMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS,OmorBasketMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,OmorBasketMod.MOD_ID);

    public OmorBasketForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //OmorBasketMod.init();
        modEventBus.register(this);
        BLOCK_ENTITY_TYPES.register(modEventBus);
        BLOCK.register(modEventBus);
        ITEMS.register(modEventBus);

        modEventBus.addListener(EventPriority.HIGH,this::registerEvent);
        modEventBus.addListener(EventPriority.HIGH,this::registerCreativeTabModify);
        MinecraftForge.EVENT_BUS.addListener(VillageStructures::addNewVillageBuilding);
    }

    public void registerCreativeTabModify(BuildCreativeModeTabContentsEvent event){
        if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS){
            event.accept(ModItems.PICNIC_BASKET);
        }
    }

    public void registerEvent(RegisterEvent registerEvent){
        registerEvent.register(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES,helper -> ModBlocks.ModBlockEntityTypes.init());
        registerEvent.register(ForgeRegistries.Keys.BLOCKS,helper -> ModBlocks.init());
        registerEvent.register(ForgeRegistries.Keys.ITEMS,helper -> ModItems.init());
    }
}