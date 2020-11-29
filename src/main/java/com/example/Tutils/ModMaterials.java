package com.example.Tutils;

import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.RepairItemRecipe;

// Needed to create a new material to use in creating a custom tool
public enum ModMaterials implements IItemTier
{
    // Establish the materials for the custom tools in the mod
    uranium(10.0f, 9.0f, 30000, 3, 25, ModItems.uranium_ingot.get()),
    wood(4.0f, 2.0f, 59, 0, 15, Items.STICK),
    stone(6.0f, 4.0f, 131, 1, 5, Items.COBBLESTONE),
    iron(7.0f, 6.0f, 250, 2, 14, Items.IRON_INGOT),
    gold(5.0f, 10.0f, 32, 2, 22, Items.GOLD_INGOT),
    diamond(8.0f, 8.0f, 1561, 3, 10, Items.DIAMOND);

    // Stores the necessary statistics for a given custom material
    private float attackDamage, efficiency;
    private int durability, harvestLevel, enchantability;
    private Item repairMaterial;

    // Constructor for a new custom material
    private ModMaterials(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial)
    {
        // tells how much damage a tool made from this material will generally apply
        this.attackDamage = attackDamage;
        // tells how fast a tool made from this material will mine/break a block
        this.efficiency = efficiency;
        // tells how many times a tool made from this material can be used
        this .durability = durability;
        // tells what a tool made from this material is able to mine/break
        this.harvestLevel = harvestLevel;
        // tells at what value tools made from this material will get better enchantments at lower levels
        this.enchantability = enchantability;
        // tells what material a tool made from this material can be repaired with
        this.repairMaterial = repairMaterial;
    }

    // returns the custom material's durability value
    @Override
    public int getMaxUses() {
        return this.durability;
    }

    // returns the custom material's efficiency value
    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    // returns the custom material's attack damage value
    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    // returns the custom material's harvest level value
    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    // returns the custom material's enchantability value
    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    // returns the custom material's repair material
    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(this.repairMaterial);
    }
}
