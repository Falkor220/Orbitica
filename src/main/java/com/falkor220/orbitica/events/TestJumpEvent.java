package com.falkor220.orbitica.events;


import com.falkor220.orbitica.Orbitica;
import com.falkor220.orbitica.init.blockInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
/*
@Mod.EventBusSubscriber(modid = Orbitica.MOD_ID, bus = Bus.FORGE)
public class TestJumpEvent {
    @SubscribeEvent
    public static void testJumpEvent(LivingJumpEvent event){
        Orbitica.LOGGER.info("Jumped");
        LivingEntity livingEntity = event.getEntityLiving();
        World world = livingEntity.getEntityWorld();
        assert blockInit.melodi_ore != null;
        world.setBlockState(livingEntity.getPosition().add(0, 5, 0), blockInit.melodi_ore.getDefaultState());
        livingEntity.addPotionEffect(new EffectInstance(Effects.GLOWING, 600, 1));
    }
}
*/
