package net.firemuffin303.omorbasket.neoforge;

import net.firemuffin303.omorbasket.PicnicMod;
import net.firemuffin303.omorbasket.common.registry.*;
import net.firemuffin303.omorbasket.neoforge.structure.VillageStructures;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(PicnicMod.MOD_ID)
public class OmorBasketNeoForge {
    public static final DeferredRegister<MenuType<?>> MENU_TYPE = DeferredRegister.create(BuiltInRegistries.MENU, PicnicMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(BuiltInRegistries.BLOCK, PicnicMod.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, PicnicMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, PicnicMod.MOD_ID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER,PicnicMod.MOD_ID);
    public static final DeferredRegister<ResourceLocation> CUSTOM_STAT = DeferredRegister.create(BuiltInRegistries.CUSTOM_STAT,PicnicMod.MOD_ID);

    //I hate forge. And I know that once this updated to 1.20.2+, I will free from forge. :D
    //I spend too much time on forge.
    public static final GameRules.Key<GameRules.IntegerValue> PICNIC_ALLOWANCE = GameRules.register(PicnicMod.MOD_ID+":picnicAllowance",GameRules.Category.MISC, GameRules.IntegerValue.create(3));

    public OmorBasketNeoForge(IEventBus modEventBus) {
        // Submit our event bus to let architectury register our content on the right time
        //PicnicMod.init();

        MENU_TYPE.register(modEventBus);
        BLOCK.register(modEventBus);
        BLOCK_ENTITY_TYPES.register(modEventBus);
        ITEMS.register(modEventBus);
        RECIPE_SERIALIZERS.register(modEventBus);
        CUSTOM_STAT.register(modEventBus);

        modEventBus.addListener(EventPriority.HIGH,this::registerEvent);
        modEventBus.addListener(EventPriority.HIGH,this::registerCreativeTabModify);
        modEventBus.addListener(EventPriority.HIGH,this::commonSetup);
        NeoForge.EVENT_BUS.addListener(VillageStructures::addNewVillageBuilding);

        if(FMLEnvironment.dist.isClient()){
            PicnicBasketNeoForgeClient.init();
        }
    }


    public void registerCreativeTabModify(BuildCreativeModeTabContentsEvent event){
        if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS || event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS){
            ModItems.PICNIC.forEach(event::accept);
        }
    }

    public void registerEvent(RegisterEvent registerEvent){
        registerEvent.register(Registries.MENU,helper -> ModMenuType.init());
        registerEvent.register(Registries.BLOCK_ENTITY_TYPE,helper -> ModBlocks.ModBlockEntityTypes.init());
        registerEvent.register(Registries.BLOCK,helper -> ModBlocks.init());
        registerEvent.register(Registries.ITEM,helper -> ModItems.init());
        registerEvent.register(Registries.RECIPE_SERIALIZER,helper -> ModRecipeSerializer.init());
        registerEvent.register(Registries.CUSTOM_STAT,helper -> ModStat.init());
    }

    private void commonSetup(FMLCommonSetupEvent event){
        //event.enqueueWork(ModStat::init);
    }
}
