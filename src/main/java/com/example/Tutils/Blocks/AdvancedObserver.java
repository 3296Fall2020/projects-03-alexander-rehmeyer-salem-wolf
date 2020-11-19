package com.example.Tutils.Blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class AdvancedObserver extends ObserverBlock {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public AdvancedObserver(){
        super(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(3.0F).setRequiresTool().setOpaque(AdvancedObserver::isntSolid));
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.SOUTH).with(POWERED, Boolean.valueOf(false)));
    }

    @SubscribeEvent
    public static void blockadded(BlockEvent.NeighborNotifyEvent event){
        for(Direction dir : Direction.values()){
            for(int i = 1; i <= 5; i++){
                Block block = event.getWorld().getBlockState(event.getPos().offset(dir, i)).getBlock();
                if(block instanceof AdvancedObserver && dir.getOpposite() == event.getWorld().getBlockState(event.getPos().offset(dir, i)).get(FACING)){
                    ((AdvancedObserver)event.getWorld().getBlockState(event.getPos().offset(dir, i)).getBlock()).startSignal(event.getWorld(), event.getPos().offset(dir, i));
                } else if (!block.isAir(event.getWorld().getBlockState(event.getPos().offset(dir, i)), event.getWorld(), event.getPos().offset(dir, i))) {
                    break;
                }
            }
        }

    }

    public void startSignal(IWorld worldIn, BlockPos pos) {
        if (!worldIn.isRemote() && !worldIn.getPendingBlockTicks().isTickScheduled(pos, this)) {
            worldIn.getPendingBlockTicks().scheduleTick(pos, this, 2);
        }

    }

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (state.get(POWERED)) {
            worldIn.setBlockState(pos, state.with(POWERED, Boolean.valueOf(false)), 2);
        } else {
            worldIn.setBlockState(pos, state.with(POWERED, Boolean.valueOf(true)), 2);
            worldIn.getPendingBlockTicks().scheduleTick(pos, this, 2);
        }

        this.updateNeighborsInFront(worldIn, pos, state);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, POWERED);
    }

    private static boolean isntSolid(BlockState state, IBlockReader reader, BlockPos pos) {
        return false;
    }
}
