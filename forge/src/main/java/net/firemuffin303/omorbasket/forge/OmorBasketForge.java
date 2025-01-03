package net.firemuffin303.omorbasket.forge;

import net.firemuffin303.omorbasket.PicnicMod;
import net.firemuffin303.omorbasket.common.registry.*;
import net.firemuffin303.omorbasket.forge.gamerule.EnumValue;
import net.firemuffin303.omorbasket.forge.structure.VillageStructures;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod(PicnicMod.MOD_ID)
public class OmorBasketForge {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PicnicMod.MOD_ID);
    public static final DeferredRegister<MenuType<?>> MENU_TYPE = DeferredRegister.create(ForgeRegistries.MENU_TYPES, PicnicMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, PicnicMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PicnicMod.MOD_ID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS,PicnicMod.MOD_ID);

    //I hate forge. And I know that once this updated to 1.20.2+, I will free from forge. :D
    //I spend too much time on forge.
    public static final GameRules.Key<GameRules.IntegerValue> PICNIC_ALLOWANCE = GameRules.register(PicnicMod.MOD_ID+":picnicAllowance",GameRules.Category.MISC, GameRules.IntegerValue.create(3));

    public OmorBasketForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //OmorBasketMod.init();
        modEventBus.register(this);
        MENU_TYPE.register(modEventBus);
        BLOCK_ENTITY_TYPES.register(modEventBus);
        BLOCK.register(modEventBus);
        ITEMS.register(modEventBus);
        RECIPE_SERIALIZERS.register(modEventBus);

        modEventBus.addListener(EventPriority.HIGH,this::registerEvent);
        modEventBus.addListener(EventPriority.HIGH,this::registerCreativeTabModify);
        modEventBus.addListener(EventPriority.HIGH,this::commonSetup);
        MinecraftForge.EVENT_BUS.addListener(VillageStructures::addNewVillageBuilding);


    }


    public void registerCreativeTabModify(BuildCreativeModeTabContentsEvent event){
        if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS || event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS){
            ModItems.PICNIC.forEach(event::accept);
        }
    }

    public void registerEvent(RegisterEvent registerEvent){
        registerEvent.register(ForgeRegistries.Keys.MENU_TYPES,helper -> ModMenuType.init());
        registerEvent.register(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES,helper -> ModBlocks.ModBlockEntityTypes.init());
        registerEvent.register(ForgeRegistries.Keys.BLOCKS,helper -> ModBlocks.init());
        registerEvent.register(ForgeRegistries.Keys.ITEMS,helper -> ModItems.init());
        registerEvent.register(ForgeRegistries.Keys.RECIPE_SERIALIZERS,helper -> ModRecipeSerializer.init());
    }

    private void commonSetup(FMLCommonSetupEvent event){
        event.enqueueWork(ModStat::init);
    }
}
