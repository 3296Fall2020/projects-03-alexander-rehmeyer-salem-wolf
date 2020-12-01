package com.example.Tutils.Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class Hoer extends Block {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public Hoer(){
        super(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f));
        this.setDefaultState(this.getDefaultState().with(POWERED, Boolean.valueOf(false)));
    }

    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!worldIn.isRemote) {
            boolean flag = state.get(POWERED);
            if (flag == worldIn.isBlockPowered(pos)) {
                if (flag) {
                    worldIn.getPendingBlockTicks().scheduleTick(pos, this, 4);
                    hoeTheGround(worldIn, pos);
                } else {
                    worldIn.setBlockState(pos, state.func_235896_a_(POWERED), 2);
                }
            }
        }

    }

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (state.get(POWERED) && !worldIn.isBlockPowered(pos)) {
            worldIn.setBlockState(pos, state.func_235896_a_(POWERED), 2);
        }

    }

    public void hoeTheGround(World world, BlockPos blockpos){
        blockpos = blockpos.offset(Direction.UP, 1);
        for(int i = -5; i <= 5; i++){
            for(int q = -5; q <= 5; q++){
                BlockPos blockpostemp = blockpos.offset(Direction.EAST, i).offset(Direction.NORTH, q);
                BlockState blockstate = world.getBlockState(blockpostemp).getToolModifiedState(world, blockpostemp, null, null, net.minecraftforge.common.ToolType.HOE);
                if (blockstate != null && !world.isRemote) {
                    world.setBlockState(blockpostemp, blockstate, 11);
                }
            }
        }
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }
}
