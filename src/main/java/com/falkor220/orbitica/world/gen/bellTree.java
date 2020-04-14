package com.falkor220.orbitica.world.gen;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import com.falkor220.orbitica.init.blockInitNew;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.Random;

public class bellTree extends Tree{
    public static final TreeFeatureConfig BELL_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(blockInitNew.BELL_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(blockInitNew.BELL_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(2, 0))).baseHeight(8).heightRandA(2).foliageHeight(5).ignoreVines().trunkHeight(5).trunkHeightRandom(2).setSapling((IPlantable) blockInitNew.BELL_SAPLING.get()).build();


    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
        return Feature.NORMAL_TREE.withConfiguration(BELL_TREE_CONFIG);
    }
}
