package SorrowIDT.rurustew;


import SorrowIDT.rurustew.item.knife;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Rurustew.MODID)
public class Rurustew {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "rurustew";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<Item> ITEMS= DeferredRegister.create(ForgeRegistries.ITEMS,
            Rurustew.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            Rurustew.MODID);
    //注册物品
    public static Item.Properties foodItem(FoodProperties food) {
        return new Item.Properties().food(food);
    }
    public static final RegistryObject<Item> rawPlayerMeat =ITEMS.register("rawplayermeat",
            ()->new Item(foodItem(new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).build())));
    public static final RegistryObject<Item> cookedPlayerMeat =ITEMS.register("cookedplayermeat",
            ()->new Item(foodItem(new FoodProperties.Builder().nutrition(8).saturationMod(0.8f).build())));
    public static final RegistryObject<Item> knife =ITEMS.register("knife",
            ()->new knife(new Item.Properties()));

    public static final RegistryObject<CreativeModeTab> RurustewTab =CREATIVE_MODE_TABS.register("rurustwtab",
            ()->new CreativeModeTab.Builder(CreativeModeTab.Row.TOP,0)
                    .title(Component.translatable("rurustew"))
                    .icon(() -> new ItemStack(Rurustew.knife.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(Rurustew.rawPlayerMeat.get());
                        output.accept(Rurustew.cookedPlayerMeat.get());
                        output.accept(Rurustew.knife.get());
                    }).build());


    public Rurustew() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();//MinecraftForge.EVENT_BUS,fuck you;

        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info("{}{}", Config.magicNumberIntroduction, Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
/*
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(knife);
            event.accept(rawPlayerMeat);
            event.accept(cookedPlayerMeat);
        }
*/
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
