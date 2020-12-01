package com.example.Tutils.Structures;

import com.example.Tutils.Tutils;
import com.example.Tutils.TUStructures;
import com.google.common.collect.ImmutableMap;

import net.minecraft.block.Blocks;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.BarrelTileEntity;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Facility1Pieces {
	
	public static final ResourceLocation FAC_1 = new ResourceLocation(Tutils.MOD_ID, "facility_1");
	public static final ResourceLocation FAC_1A = new ResourceLocation(Tutils.MOD_ID, "facility_1a");
	private static final Map<ResourceLocation, BlockPos> OFFSET = ImmutableMap.of(FAC_1, new BlockPos(0, 1, 0), FAC_1A, new BlockPos(0, 1, 0));
	
	
    public static void start(TemplateManager templateManager, BlockPos pos, Rotation rotation, List<StructurePiece> pieceList, Random random) {
        int x = pos.getX();
        int z = pos.getZ();

        // factor in piece rotation
        BlockPos rotationOffSet = new BlockPos(0, 0, 0).rotate(rotation);
        BlockPos blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.add(new Facility1Pieces.Piece(templateManager, FAC_1, blockpos, rotation));
        
        
        rotationOffSet = new BlockPos(-11, 0, 0).rotate(rotation);
        blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.add(new Facility1Pieces.Piece(templateManager, FAC_1A, blockpos, rotation));

    }
    
    
    public static class Piece extends TemplateStructurePiece {
        private ResourceLocation resourceLocation;
        private Rotation rotation;

        
        public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos, Rotation rotationIn) {
            super(TUStructures.F1, 0);
            this.resourceLocation = resourceLocationIn;
            BlockPos blockpos = new BlockPos(0,0,0); //Facility1Pieces.OFFSET.get(resourceLocation);
            this.templatePosition = pos.add(blockpos.getX(), blockpos.getY(), blockpos.getZ());
            this.rotation = rotationIn;
            this.setupPiece(templateManagerIn);
        }
        

        public Piece(TemplateManager templateManagerIn, CompoundNBT tagCompound) {
            super(TUStructures.F1, tagCompound);
            this.resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
            this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
            this.setupPiece(templateManagerIn);
        }

        private void setupPiece(TemplateManager templateManager) {
            Template template = templateManager.getTemplateDefaulted(this.resourceLocation);
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE);
            this.setup(template, this.templatePosition, placementsettings);
        }
        
        //For adding loot later
		@Override
		protected void handleDataMarker(String function, BlockPos pos, IServerWorld worldIn, Random rand,
				MutableBoundingBox sbb) {
			
		  
            if (function.contains("chest")) {
            	
                worldIn.setBlockState(pos, Blocks.CHEST.getDefaultState(), 2);
                TileEntity tileentity = worldIn.getTileEntity(pos);

                //check if there's a chest
                if (tileentity instanceof ChestTileEntity) {
                     ((ChestTileEntity) tileentity).setLootTable(LootTables.CHESTS_SPAWN_BONUS_CHEST, rand.nextLong());
                }
                
                
            }
			
		}
    }
	
	
	

}
