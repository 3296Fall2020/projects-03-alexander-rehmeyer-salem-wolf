package com.example.Tutils;

import com.example.Tutils.Items.RedstoneRemote;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.client.model.obj.MaterialLibrary;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Tutils.MOD_ID);

    // Uranium Tools
    public static final RegistryObject<Item> uranium_ingot = ITEMS.register("uranium_ingot", () -> new Item(new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<PickaxeItem> uranium_pickaxe = ITEMS.register("uranium_pickaxe", () -> new PickaxeItem(ModMaterials.uranium, -2, 6, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<SwordItem> uranium_sword = ITEMS.register("uranium_sword", () -> new SwordItem(ModMaterials.uranium, 0, 60.f, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<AxeItem> uranium_axe = ITEMS.register("uranium_axe", () -> new AxeItem(ModMaterials.uranium, -1.0f, 6.0f, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<ShovelItem> uranium_shovel = ITEMS.register("uranium_shovel", () -> new ShovelItem(ModMaterials.uranium, -3.0f, 6.0f, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<HoeItem> uranium_hoe = ITEMS.register("uranium_hoe", () -> new HoeItem(ModMaterials.uranium, 1, 6.0f, new Item.Properties().group(Tutils.TAB)));

    // Redstone Devices
    public static final RegistryObject<Item> redstone_remote = ITEMS.register("redstone_remote", RedstoneRemote::new);

    // Multi-Tools
    public static final RegistryObject<ItemShovelPickaxe> wooden_shovel_pickaxe = ITEMS.register("wooden_shovel_pickaxe", () -> new ItemShovelPickaxe(ModMaterials.wood, -2, 6, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<ItemShovelPickaxe> stone_shovel_pickaxe = ITEMS.register("stone_shovel_pickaxe", () -> new ItemShovelPickaxe(ModMaterials.stone, -2, 6, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<ItemShovelPickaxe> iron_shovel_pickaxe = ITEMS.register("iron_shovel_pickaxe", () -> new ItemShovelPickaxe(ModMaterials.iron, -2, 6, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<ItemShovelPickaxe> gold_shovel_pickaxe = ITEMS.register("gold_shovel_pickaxe", () -> new ItemShovelPickaxe(ModMaterials.gold, -2, 6, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<ItemShovelPickaxe> diamond_shovel_pickaxe = ITEMS.register("diamond_shovel_pickaxe", () -> new ItemShovelPickaxe(ModMaterials.diamond, -2, 6, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<ItemShovelPickaxe> uranium_shovel_pickaxe = ITEMS.register("uranium_shovel_pickaxe", () -> new ItemShovelPickaxe(ModMaterials.uranium, -2, 6, new Item.Properties().group(Tutils.TAB)));

    public static final RegistryObject<ItemAxePickaxe> wooden_axe_pickaxe = ITEMS.register("wooden_axe_pickaxe", () -> new ItemAxePickaxe(ModMaterials.wood, -2, 6, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<ItemAxePickaxe> stone_axe_pickaxe = ITEMS.register("stone_axe_pickaxe", () -> new ItemAxePickaxe(ModMaterials.stone, -2, 6, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<ItemAxePickaxe> iron_axe_pickaxe = ITEMS.register("iron_axe_pickaxe", () -> new ItemAxePickaxe(ModMaterials.iron, -2, 6, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<ItemAxePickaxe> gold_axe_pickaxe = ITEMS.register("gold_axe_pickaxe", () -> new ItemAxePickaxe(ModMaterials.gold, -2, 6, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<ItemAxePickaxe> diamond_axe_pickaxe = ITEMS.register("diamond_axe_pickaxe", () -> new ItemAxePickaxe(ModMaterials.diamond, -2, 6, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<ItemAxePickaxe> uranium_axe_pickaxe = ITEMS.register("uranium_axe_pickaxe", () -> new ItemAxePickaxe(ModMaterials.uranium, -2, 6, new Item.Properties().group(Tutils.TAB)));

    public static final RegistryObject<ItemAxeShovel> wooden_axe_shovel = ITEMS.register("wooden_axe_shovel", () -> new ItemAxeShovel(ModMaterials.wood, -2, 6, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<ItemAxeShovel> stone_axe_shovel = ITEMS.register("stone_axe_shovel", () -> new ItemAxeShovel(ModMaterials.stone, -2, 6, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<ItemAxeShovel> iron_axe_shovel = ITEMS.register("iron_axe_shovel", () -> new ItemAxeShovel(ModMaterials.iron, -2, 6, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<ItemAxeShovel> gold_axe_shovel = ITEMS.register("gold_axe_shovel", () -> new ItemAxeShovel(ModMaterials.gold, -2, 6, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<ItemAxeShovel> diamond_axe_shovel = ITEMS.register("diamond_axe_shovel", () -> new ItemAxeShovel(ModMaterials.diamond, -2, 6, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<ItemAxeShovel> uranium_axe_shovel = ITEMS.register("uranium_axe_shovel", () -> new ItemAxeShovel(ModMaterials.uranium, -2, 6, new Item.Properties().group(Tutils.TAB)));

    // Block items
    public static final RegistryObject<Item> uranium_block = ITEMS.register("uranium_block", () -> new BlockItem(ModBlocks.uranium_block.get(), new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<Item> uranium_ore = ITEMS.register("uranium_ore", () -> new BlockItem(ModBlocks.uranium_ore.get(), new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<Item> Hoer = ITEMS.register("hoer", () -> new BlockItem(ModBlocks.Hoer.get(), new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<Item> RedstoneReciver = ITEMS.register("redstone_reciver", () -> new BlockItem(ModBlocks.RedstoneReceiver.get(), new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<Item> AdvancedObserver = ITEMS.register("advanced_observer", () -> new BlockItem(ModBlocks.AdvancedObserver.get(), new Item.Properties().group(Tutils.TAB)));
}
