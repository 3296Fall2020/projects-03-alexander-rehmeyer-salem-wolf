package com.example.Tutils;

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

    // Block items
    public static final RegistryObject<Item> uranium_block = ITEMS.register("uranium_block", () -> new BlockItem(ModBlocks.uranium_block.get(), new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<Item> uranium_ore = ITEMS.register("uranium_ore", () -> new BlockItem(ModBlocks.uranium_ore.get(), new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<Item> RedstoneReciver = ITEMS.register("redstone_reciver", () -> new BlockItem(ModBlocks.RedstoneReciver.get(), new Item.Properties().group(Tutils.TAB)));
}
