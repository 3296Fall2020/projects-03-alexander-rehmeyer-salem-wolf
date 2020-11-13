package com.example.Tutils;

import net.minecraft.item.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Tutils.MOD_ID);

    // Items
    public static final RegistryObject<Item> uranium_ingot = ITEMS.register("uranium_ingot", () -> new Item(new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<PickaxeItem> uranium_pickaxe = ITEMS.register("uranium_pickaxe", () -> new PickaxeItem(ModMaterials.uranium, -2, 6, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<SwordItem> uranium_sword = ITEMS.register("uranium_sword", () -> new SwordItem(ModMaterials.uranium, 0, 60.f, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<AxeItem> uranium_axe = ITEMS.register("uranium_axe", () -> new AxeItem(ModMaterials.uranium, -1.0f, 6.0f, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<ShovelItem> uranium_shovel = ITEMS.register("uranium_shovel", () -> new ShovelItem(ModMaterials.uranium, -3.0f, 6.0f, new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<HoeItem> uranium_hoe = ITEMS.register("uranium_hoe", () -> new HoeItem(ModMaterials.uranium, 1, 6.0f, new Item.Properties().group(Tutils.TAB)));

    // Block items
    public static final RegistryObject<Item> uranium_block = ITEMS.register("uranium_block", () -> new BlockItem(ModBlocks.uranium_block.get(), new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<Item> RedstoneReciver = ITEMS.register("redstone_reciver", () -> new BlockItem(ModBlocks.RedstoneReciver.get(), new Item.Properties().group(Tutils.TAB)));
}
