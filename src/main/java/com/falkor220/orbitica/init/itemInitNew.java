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
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class itemInitNew {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Orbitica.MOD_ID);

    //ore drops
    public static final RegistryObject<Item> MELODI_CRYSTAL = ITEMS.register("melodi_crystal", () -> new Item(new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)));
    public static final RegistryObject<Item> BIG_MELODI_CRYSTAL = ITEMS.register("big_melodi_crystal", () -> new Item(new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)));

    //Tools
    public static final RegistryObject<Item> MELODI_SWORD = ITEMS.register("melodi_sword", () -> new SwordItem(ModItemTier.MELODI, 3, -1.3f, new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)));
    public static final RegistryObject<Item> MELODI_AXE = ITEMS.register("melodi_axe", () -> new AxeItem(ModItemTier.MELODI, 6, -2.8f, new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)));
    public static final RegistryObject<Item> MELODI_PICKAXE = ITEMS.register("melodi_pickaxe", () -> new PickaxeItem(ModItemTier.MELODI, 1, -2.7f, new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)));
    public static final RegistryObject<Item> MELODI_SHOVEL = ITEMS.register("melodi_shovel", () -> new ShovelItem(ModItemTier.MELODI, 2, -2.8f, new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)));
    public static final RegistryObject<Item> MELODI_HOE = ITEMS.register("melodi_hoe", () -> new HoeItem(ModItemTier.MELODI,-0.8f, new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)));

    //Wands
    public static final RegistryObject<Item> FLUTE_WAND = ITEMS.register("flute_wand", () -> new WandItem(new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)));

    //Armour (but americans spell it armor because they hate the letter 'u')
    public static final RegistryObject<Item> MELODI_HELMET = ITEMS.register("melodi_helmet", () -> new ArmorItem(ModItemMaterial.MELODI, EquipmentSlotType.HEAD, new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)));
    public static final RegistryObject<Item> MELODI_CHESTPLATE = ITEMS.register("melodi_chestplate", () -> new ArmorItem(ModItemMaterial.MELODI, EquipmentSlotType.HEAD, new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)));
    public static final RegistryObject<Item> MELODI_LEGGINGS = ITEMS.register("melodi_leggings", () -> new ArmorItem(ModItemMaterial.MELODI, EquipmentSlotType.HEAD, new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)));
    public static final RegistryObject<Item> MELODI_BOOTS = ITEMS.register("melodi_boots", () -> new ArmorItem(ModItemMaterial.MELODI, EquipmentSlotType.HEAD, new Item.Properties().group(Orbitica.OrbiticaItemGroup.instance)));




    public enum ModItemTier implements IItemTier {
        MELODI(2, 365, 7.0f, 2.0f, 30, () -> {
            return Ingredient.fromItems(itemInitNew.MELODI_CRYSTAL.get());
        });

        private final int harvest_level;
        private final int max_uses;
        private final float efficiency;
        private final float attack_damage;
        private final int enchantability;
        private final LazyValue<Ingredient> repair_material;


        private ModItemTier(int harvest_level, int max_uses, float efficiency, float attack_damage, int enchantability, Supplier<Ingredient> repair_material) {
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

    public enum ModItemMaterial implements IArmorMaterial {
        //Boots, Legs, Chest, Head
        MELODI(Orbitica.MOD_ID + ":melodi_armor", 5, new int[]{7, 9, 11, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0f, () -> {
            return Ingredient.fromItems(itemInitNew.MELODI_CRYSTAL.get());
        });

        private static final int[] MAX_DAMAGE_ARRAY = new int[]{70, 90, 100, 90};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyValue<Ingredient> repairMaterial;

        private ModItemMaterial(String nameIn, int maxDamageFactor, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
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
