package com.falkor220.orbitica.init;

import com.falkor220.orbitica.Orbitica;
import com.falkor220.orbitica.objects.items.WandItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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

    //armor
    public static final Item melodi_helmet = null;
    public static final Item melodi_chestplate = null;
    public static final Item melodi_leggings = null;
    public static final Item melodi_boots = null;

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

        //armor
        event.getRegistry().register(new ArmorItem(ModItemMaterial.MELODI, EquipmentSlotType.HEAD, new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)).setRegistryName("melodi_helmet"));
        event.getRegistry().register(new ArmorItem(ModItemMaterial.MELODI, EquipmentSlotType.CHEST, new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)).setRegistryName("melodi_chestplate"));
        event.getRegistry().register(new ArmorItem(ModItemMaterial.MELODI, EquipmentSlotType.LEGS, new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)).setRegistryName("melodi_leggings"));
        event.getRegistry().register(new ArmorItem(ModItemMaterial.MELODI, EquipmentSlotType.FEET, new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)).setRegistryName("melodi_boots"));
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

    public enum ModItemMaterial implements IArmorMaterial{
        //Boots, Legs, Chest, Head
        MELODI(Orbitica.MOD_ID + ":melodi_armor", 5, new int[] {7, 9, 11, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0f, () -> {
            return Ingredient.fromItems(itemInit.melodi_crystal);
        });

        private static final int[] MAX_DAMAGE_ARRAY = new int[] {70, 90, 100, 90};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyValue<Ingredient> repairMaterial;

        private ModItemMaterial(String nameIn, int maxDamageFactor, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn){
            this.name = nameIn;
            this.maxDamageFactor = maxDamageFactor;
            this.damageReductionAmountArray = damageReductionAmountIn;
            this.enchantability = enchantabilityIn;
            this.soundEvent = soundEventIn;
            this.toughness = toughnessIn;
            this.repairMaterial = new LazyValue<>(repairMaterialIn);
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return this.damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return this.soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public float getToughness() {
            return toughness;
        }
    }
}
