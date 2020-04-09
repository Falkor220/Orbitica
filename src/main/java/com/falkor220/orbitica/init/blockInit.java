package com.falkor220.orbitica.init;

import com.falkor220.orbitica.Orbitica;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@ObjectHolder(Orbitica.MOD_ID)
@Mod.EventBusSubscriber(modid = Orbitica.MOD_ID, bus = Bus.MOD)
public class blockInit {
    public static final Block melodi_ore = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3f, 4f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)).setRegistryName("melodi_ore"));
    }
    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new BlockItem(melodi_ore, new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)).setRegistryName("melodi_ore"));
    }
}
