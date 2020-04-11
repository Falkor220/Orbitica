package com.falkor220.orbitica;

import com.falkor220.orbitica.init.blockInitNew;
import com.falkor220.orbitica.init.itemInitNew;
import com.falkor220.orbitica.world.gen.MelodiOreGen;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("orbitica")
@Mod.EventBusSubscriber(modid = Orbitica.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Orbitica
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "orbitica";
    public static Orbitica instance;

    public Orbitica() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        itemInitNew.ITEMS.register(modEventBus);
        blockInitNew.BLOCKS.register(modEventBus);

        instance = this;

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event){
        final IForgeRegistry<Item> registry = event.getRegistry();

        blockInitNew.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
        RenderTypeLookup.setRenderLayer(blockInitNew.MELODI_GLASS.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(blockInitNew.BELL_SAPLING.get(), RenderType.getCutout());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event){
        MelodiOreGen.generateOre();
    }


    public static class OrbiticaItemGroup extends ItemGroup{
        public static final OrbiticaItemGroup instance = new OrbiticaItemGroup(ItemGroup.GROUPS.length, "orbitica");
        private OrbiticaItemGroup(int index, String label){
            super(index, label);
        }
        public ItemStack createIcon(){
            return new ItemStack(itemInitNew.MELODI_CRYSTAL.get());
        }
    }
}
