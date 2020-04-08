package com.falkor220.orbitica.init;

import com.falkor220.orbitica.Orbitica;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Orbitica.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Orbitica.MOD_ID)
public class itemInit {

    public static final Item example_item = null;
    public static final Item test_item = null;

    @SubscribeEvent
    public  static void registerItems(final RegistryEvent.Register<Item> event){
        event.getRegistry().register(new Item(new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)).setRegistryName("example_item"));
        event.getRegistry().register(new Item(new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance).food(new Food.Builder().hunger(10).saturation(1.2f).build())).setRegistryName("test_item"));
    }
}
