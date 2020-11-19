package com.example.Tutils;

import com.example.Tutils.Structures.*;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.event.RegistryEvent.Register;

public class TUStructures {

	
    public static Structure<NoFeatureConfig> FACILITY_1 = new Facility1Structure(NoFeatureConfig.field_236558_a_);
    public static IStructurePieceType F1 = Facility1Pieces.Piece::new;


    public static void registerStructures(Register<Structure<?>> event) {

        // Registers the structure 
        Tutils.register(event.getRegistry(), FACILITY_1, "facility_1");

        //DO NOT CHANGE STRUCTURE NAME
        registerStructure(
                FACILITY_1, /* The instance of the structure */
                new StructureSeparationSettings(10 /* maximum distance apart in chunks between spawn attempts */,
                        5 /* minimum distance apart in chunks between spawn attempts */,
                        1234567890 /* structure seed, prevents overlapping */),
                true);


        TUStructures.registerAllPieces();
    }


    public static <F extends Structure<?>> void registerStructure(
            F structure,
            StructureSeparationSettings structureSeparationSettings,
            boolean transformSurroundingLand)
    {

        //Structure.field_236365_a_.put(structure.getRegistryName().toString(), structure);
    	//List of vanilla structures
        Structure.NAME_STRUCTURE_BIMAP.put(structure.getRegistryName().toString(), structure);

        /*
         * Will add land at the base of the structure like it does for Villages and Outposts.
         * Doesn't work well on structure that have pieces stacked vertically.
         */
        if(transformSurroundingLand){
            Structure.field_236384_t_ =
                    ImmutableList.<Structure<?>>builder()
                            .addAll(Structure.field_236384_t_)
                            .add(structure)
                            .build();
        }


        DimensionStructuresSettings.field_236191_b_ =
                ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                        .putAll(DimensionStructuresSettings.field_236191_b_)
                        .put(structure, structureSeparationSettings)
                        .build();
    }

    /*
     * If you have multiple structures it is helpful to break out the registering of the pieces.
     * If you change the name you register the pieces with and load a world from before the name
     * was changed it will spam errors to the console, so pick a name you like before distributing
     * your mod and don't change it. Called by registerFeatures.
     */
    public static void registerAllPieces() {
        registerStructurePiece(F1, new ResourceLocation(Tutils.MOD_ID, "facility_1"));
    }


    static void registerStructurePiece(IStructurePieceType structurePiece, ResourceLocation rl) {
        Registry.register(Registry.STRUCTURE_PIECE, rl, structurePiece);
    }
    

}
