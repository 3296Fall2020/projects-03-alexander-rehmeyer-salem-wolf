package com.example.Tutils.Structures;

import com.example.Tutils.Tutils;
import com.example.Tutils.TUStructures;
import com.google.common.collect.ImmutableMap;

import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
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
	
	public static final ResourceLocation FAC_1 = new ResourceLocation(Tutils.MODID, "facility_1");
	
	
    public static void start(TemplateManager templateManager, BlockPos pos, Rotation rotation, List<StructurePiece> pieceList, Random random) {
        int x = pos.getX();
        int z = pos.getZ();

        // This is how we factor in rotation for multi-piece structures.
        //
        // I would recommend using the OFFSET map above to have each piece at correct height relative of each other
        // and keep the X and Z equal to 0. And then in rotations, have the centermost piece have a rotation
        // of 0, 0, 0 and then have all other pieces' rotation be based off of the bottommost left corner of
        // that piece (the corner that is smallest in X and Z).
        //
        // Lots of trial and error may be needed to get this right for your structure.
        BlockPos rotationOffSet = new BlockPos(0, 0, 0).rotate(rotation);
        BlockPos blockpos = rotationOffSet.add(x, pos.getY(), z);
        pieceList.add(new Facility1Pieces.Piece(templateManager, FAC_1, blockpos, rotation));


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

		@Override
		protected void handleDataMarker(String function, BlockPos pos, IServerWorld worldIn, Random rand,
				MutableBoundingBox sbb) {
			// TODO Auto-generated method stub
			
		}
    }
	
	
	

}
