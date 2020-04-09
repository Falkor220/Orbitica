package com.falkor220.orbitica.objects.items;

import com.falkor220.orbitica.util.helpers.Keyboard;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class WandItem extends Item {

    public WandItem(Properties properties) {
        super(properties);

    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (Keyboard.isHoldingShift()) {
            tooltip.add(new StringTextComponent("Information Test"));
            super.addInformation(stack, worldIn, tooltip, flagIn);
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.addPotionEffect((new EffectInstance(Effects.REGENERATION,100, 3)));
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
