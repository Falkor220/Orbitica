package com.falkor220.orbitica.init;

import com.falkor220.orbitica.Orbitica;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class blockInitNew {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Orbitica.MOD_ID);

    public static final RegistryObject<Block> MELODI_ORE = BLOCKS.register("melodi_ore", ()  -> new Block(Block.Properties.create(Material.IRON)));
    public static final RegistryObject<Block> MELODI_CRYSTAL_BLOCK = BLOCKS.register("melodi_crystal_block", () -> new Block(Block.Properties.create(Material.IRON)));
    public static final RegistryObject<Block> MELODI_GLASS = BLOCKS.register("melodi_glass", () -> new Block(Block.Properties.create(Material.GLASS).notSolid()));

}

