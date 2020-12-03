package com.example.Tutils;

import com.example.Tutils.Blocks.AdvancedObserver;
import com.example.Tutils.Blocks.RedstoneReceiver;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Tutils.MOD_ID);

    public static final RegistryObject<Block> uranium_block = BLOCKS.register("uranium_block",
            () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)));

    public static final RegistryObject<Block> RedstoneReceiver = BLOCKS.register("redstone_reciver", RedstoneReceiver::new);
    public static final RegistryObject<Block> AdvancedObserver = BLOCKS.register("advanced_observer", AdvancedObserver::new);

    public static final RegistryObject<Block> uranium_ore = BLOCKS.register("uranium_ore",
            () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.STONE)));


}
