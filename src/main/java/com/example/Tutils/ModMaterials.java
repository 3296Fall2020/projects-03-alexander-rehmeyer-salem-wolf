package com.example.Tutils;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

// Needed to create a new material to use in creating a custom tool
public enum ModMaterials implements IItemTier
{
    // Establish the uranium material
    uranium(10.0f, 9.0f, 30000, 3, 25, ModItems.uranium_ingot.get());

    // Stores the necessary statistics for a given custom material
    private float attackDamage, efficiency;
    private int durability, harvestLevel, enchantability;
    private Item repairMaterial;

    // Constructor for a new custom material
    private ModMaterials(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial)
    {
        this.attackDamage = attackDamage;
        this.efficiency = efficiency;
        this .durability = durability;
        this.harvestLevel = harvestLevel;
        this.enchantability = enchantability;
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