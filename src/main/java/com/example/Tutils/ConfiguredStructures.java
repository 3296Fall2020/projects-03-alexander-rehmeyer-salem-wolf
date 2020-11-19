package com.example.Tutils;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;


public class ConfiguredStructures {
		
    /**
     * Static instance of structure
     */
    public static StructureFeature<?, ?> CONFIGURED_FACILITY_1 = TUStructures.FACILITY_1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);

    
    public static void registerConfiguredStructures() {
        Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(Tutils.MOD_ID, "configured_facility_1"), CONFIGURED_FACILITY_1);


        FlatGenerationSettings.STRUCTURES.put(TUStructures.FACILITY_1, CONFIGURED_FACILITY_1);
    }

}
