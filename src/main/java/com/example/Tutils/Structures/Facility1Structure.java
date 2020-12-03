package com.example.Tutils.Structures;
import com.example.Tutils.Tutils;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.data.BiomeProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.IglooStructure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraft.world.gen.Heightmap;
import org.apache.logging.log4j.Level;

import java.util.List;


public class Facility1Structure extends Structure<NoFeatureConfig>
{

	public Facility1Structure(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    /**
     * This is how the worldgen code knows what to call when it
     * is time to create the pieces of the structure for generation.
     */
    @Override
    public  IStartFactory<NoFeatureConfig> getStartFactory() {
        return Facility1Structure.Start::new;
    }


    /**
     * Generation stage for when to generate the structure.
     * This surface structure stage places the structure before plants and ores are generated.
     */
    @Override
    public GenerationStage.Decoration getDecorationStage() {
        return GenerationStage.Decoration.SURFACE_STRUCTURES;
    }



    /**
     * Handles calling up the structure's pieces class and height that structure will spawn at.
     */
    public static class Start extends StructureStart<NoFeatureConfig>  {
        public Start(Structure<NoFeatureConfig> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int referenceIn, long seedIn) {
            super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);
        }
        
        

        @Override
        public void func_230364_a_(DynamicRegistries dynamicRegistryManager, ChunkGenerator chunkGenerator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn, NoFeatureConfig config) {
        	
            // Turns the chunk coordinates into actual coordinates (Gets center of chunk)
            int x = (chunkX << 4) + 7;
            int z = (chunkZ << 4) + 7;
            int surfaceY = chunkGenerator.getHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG);
            BlockPos blockpos = new BlockPos(x, surfaceY, z);
          

            // Now adds the structure pieces to this.components with all details such as where each part goes
            // so that the structure can be added to the world by worldgen.
            Facility1Pieces.start(templateManagerIn, blockpos, Rotation.CLOCKWISE_180, this.components, this.rand);
  

            // Sets the bounds of the structure after creation
            this.recalculateStructureSize();
            

            // Locate structure for debugging
            //utils.LOGGER.log(Level.DEBUG, "Facility_1 at " + (blockpos.getX()) + " " + blockpos.getY() + " " + (blockpos.getZ()));
        }

    }
	
	
	
	
	
	
}
