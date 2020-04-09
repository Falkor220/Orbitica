package com.falkor220.orbitica.init;

import com.falkor220.orbitica.Orbitica;
import com.falkor220.orbitica.objects.items.WandItem;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Orbitica.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Orbitica.MOD_ID)
public class itemInit {

    //ore drops
    public static final Item melodi_crystal = null;
    public static final Item big_melodi_crystal = null;

    //tools
    public static final Item melodi_sword = null;
    public static final Item melodi_pick_axe = null;
    public static final Item melodi_axe = null;
    public static final Item melodi_hoe = null;
    public static final Item melodi_shovel = null;

    //wands
    public static final Item flute = null;

    @SubscribeEvent
    public  static void registerItems(final RegistryEvent.Register<Item> event){

        //ore drops
        event.getRegistry().register(new Item(new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)).setRegistryName("melodi_crystal"));
        event.getRegistry().register(new Item(new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)).setRegistryName("big_melodi_crystal"));

        //Tools
        event.getRegistry().register(new SwordItem(ModItemTier.MELODI, 3, -2.3f, new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)).setRegistryName("melodi_sword"));
        event.getRegistry().register(new PickaxeItem(ModItemTier.MELODI, 1, -2.7f, new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)).setRegistryName("melodi_pickaxe"));
        event.getRegistry().register(new AxeItem(ModItemTier.MELODI, 6, -2.8f, new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)).setRegistryName("melodi_axe"));
        event.getRegistry().register(new ShovelItem(ModItemTier.MELODI, 2, -2.8f, new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)).setRegistryName("melodi_shovel"));
        event.getRegistry().register(new HoeItem(ModItemTier.MELODI, -0.8f, new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)).setRegistryName("melodi_hoe"));

        //wands
        event.getRegistry().register(new WandItem(new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)).setRegistryName("flute_wand"));
    }

    public enum ModItemTier implements IItemTier{
        MELODI(2, 365, 7.0f, 2.0f, 30, () -> {
           return Ingredient.fromItems(itemInit.melodi_crystal);
        });

        private final int harvest_level;
        private final int max_uses;
        private final float efficiency;
        private final float attack_damage;
        private final int enchantability;
        private final LazyValue<Ingredient> repair_material;


        private ModItemTier(int harvest_level, int max_uses, float efficiency, float attack_damage, int enchantability, Supplier<Ingredient> repair_material){
            this.harvest_level = harvest_level;
            this.max_uses = max_uses;
            this.efficiency = efficiency;
            this.attack_damage = attack_damage;
            this.enchantability = enchantability;
            this.repair_material = new LazyValue<>(repair_material);
        }

        @Override
        public int getMaxUses() {
            return this.max_uses;
        }

        @Override
        public float getEfficiency() {
            return this.efficiency;
        }

        @Override
        public float getAttackDamage() {
            return this.attack_damage;
        }

        @Override
        public int getHarvestLevel() {
            return this.harvest_level;
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repair_material.getValue();
        }
    }
}
