package com.example.Tutils.Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class RedstoneReciver extends Block {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public RedstoneReciver(){
        super(AbstractBlock.Properties.create(Material.IRON));
        this.setDefaultState(this.stateContainer.getBaseState().with(POWERED, Boolean.valueOf(false)));
    }

    public boolean canProvidePower(BlockState state) {
        return true;
    }

    public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return blockState.get(POWERED) ? 15 : 0;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (state.get(POWERED)) {
           return ActionResultType.CONSUME;
        } else {
          this.powerBlock(state, worldIn, pos);
           return ActionResultType.func_233537_a_(worldIn.isRemote);
        }
    }

    public void powerBlock(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.with(POWERED, Boolean.valueOf(true)), 3);
        this.updateNeighbors(state, world, pos);
        world.getPendingBlockTicks().scheduleTick(pos, this, 40);
    }

    private void updateNeighbors(BlockState state, World worldIn, BlockPos pos) {
        for(Direction direction : Direction.values()) {
            worldIn.notifyNeighborsOfStateChange(pos.offset(direction), this);
        }
    }

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (state.get(POWERED)) {
            worldIn.setBlockState(pos, state.with(POWERED, Boolean.valueOf(false)), 3);
            this.updateNeighbors(state, worldIn, pos);
        }
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }
}
