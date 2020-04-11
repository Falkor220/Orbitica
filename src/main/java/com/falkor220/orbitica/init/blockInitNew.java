package com.falkor220.orbitica.init;

import com.falkor220.orbitica.Orbitica;
import com.falkor220.orbitica.objects.blocks.CustomSaplingBlock;
import com.falkor220.orbitica.world.gen.bellTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class blockInitNew {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Orbitica.MOD_ID);

    public static final RegistryObject<Block> MELODI_ORE = BLOCKS.register("melodi_ore", ()  -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3f, 3 )));
    public static final RegistryObject<Block> MELODI_CRYSTAL_BLOCK = BLOCKS.register("melodi_crystal_block", () -> new Block(Block.Properties.create(Material.GLASS)));
    public static final RegistryObject<Block> MELODI_GLASS = BLOCKS.register("melodi_glass", () -> new Block(Block.Properties.create(Material.GLASS).notSolid()));
    public static final RegistryObject<Block> BELL_PLANKS = BLOCKS.register("bell_planks", () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> BELL_LOG = BLOCKS.register("bell_log", () -> new LogBlock(MaterialColor.PINK, Block.Properties.from(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> BELL_LEAVES = BLOCKS.register("bell_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> BELL_SAPLING = BLOCKS.register("bell_sapling", () -> new CustomSaplingBlock(() -> new bellTree(), Block.Properties.from(Blocks.OAK_SAPLING)));


}

