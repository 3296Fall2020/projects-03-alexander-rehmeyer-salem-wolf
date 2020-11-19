package com.example.Tutils;

import com.example.Tutils.Items.RedstoneRemote;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Tutils.MOD_ID);

    // Items
    public static final RegistryObject<Item> uranium_ingot = ITEMS.register("uranium_ingot", () -> new Item(new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<Item> redstone_remote = ITEMS.register("redstone_remote", RedstoneRemote::new);

    // Block items
    public static final RegistryObject<Item> uranium_block = ITEMS.register("uranium_block", () -> new BlockItem(ModBlocks.uranium_block.get(), new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<Item> RedstoneReciver = ITEMS.register("redstone_reciver", () -> new BlockItem(ModBlocks.RedstoneReceiver.get(), new Item.Properties().group(Tutils.TAB)));
    public static final RegistryObject<Item> AdvancedObserver = ITEMS.register("advanced_observer", () -> new BlockItem(ModBlocks.AdvancedObserver.get(), new Item.Properties().group(Tutils.TAB)));
}
