package com.example.Tutils;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ModBiomes
{
    public static DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Tutils.MOD_ID);

    public static RegistryObject<Biome> radiation_biome = BIOMES.register("radiation_biome",
            () -> makeRadiationBiome(0.125f, 0.125f)
            );

    public static Biome makeRadiationBiome(
            final float depth,
            final float scale
    )
    {
        final MobSpawnInfo.Builder mobSpawnInfoBuilder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.withDesertMobs(mobSpawnInfoBuilder);

        final BiomeGenerationSettings.Builder biomeGenerationSettingsBuilder = new BiomeGenerationSettings.Builder()
                .withSurfaceBuilder(new ConfiguredSurfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.BLACK_CONCRETE.getDefaultState(), Blocks.WHITE_CONCRETE.getDefaultState(), Blocks.DIRT.getDefaultState())));

        return new Biome.Builder()
                .precipitation(Biome.RainType.RAIN)
                .category(Biome.Category.PLAINS)
                .depth(depth)
                .scale(scale)
                .temperature(2)
                .downfall(3)
                .setEffects(
                        new BiomeAmbience.Builder()
                                .setWaterColor(0x16DA5C)
                                .setWaterFogColor(0x2DF118)
                                .setFogColor(0xB5F55D)
                                .withSkyColor(0xE2EC11)
                                .setMoodSound(MoodSoundAmbience.DEFAULT_CAVE)
                                .build()
                )
                .withMobSpawnSettings(mobSpawnInfoBuilder.copy())
                .withGenerationSettings(biomeGenerationSettingsBuilder.build())

                .build();
    }
}
