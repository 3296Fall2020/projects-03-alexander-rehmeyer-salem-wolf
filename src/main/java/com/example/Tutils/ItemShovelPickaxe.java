package com.example.Tutils;

import net.minecraft.item.*;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.material.Material;

public class ItemShovelPickaxe extends ToolItem
{
    // All of the blocks that this tool is effective on
    private static final Set<Block> EFFECTIVE_ON = ImmutableSet.of(
        Blocks.ACTIVATOR_RAIL,
        Blocks.COAL_ORE,
        Blocks.COBBLESTONE,
        Blocks.DETECTOR_RAIL,
        Blocks.DIAMOND_BLOCK,
        Blocks.DIAMOND_ORE,
        Blocks.POWERED_RAIL,
        Blocks.GOLD_BLOCK,
        Blocks.GOLD_ORE,
        Blocks.NETHER_GOLD_ORE,
        Blocks.ICE,
        Blocks.IRON_BLOCK,
        Blocks.IRON_ORE,
        Blocks.LAPIS_BLOCK,
        Blocks.LAPIS_ORE,
        Blocks.MOSSY_COBBLESTONE,
        Blocks.NETHERRACK,
        Blocks.PACKED_ICE,
        Blocks.BLUE_ICE,
        Blocks.RAIL,
        Blocks.REDSTONE_ORE,
        Blocks.SANDSTONE,
        Blocks.CHISELED_SANDSTONE,
        Blocks.CUT_SANDSTONE,
        Blocks.CHISELED_RED_SANDSTONE,
        Blocks.CUT_RED_SANDSTONE,
        Blocks.RED_SANDSTONE,
        Blocks.STONE,
        Blocks.GRANITE,
        Blocks.POLISHED_GRANITE,
        Blocks.DIORITE,
        Blocks.POLISHED_DIORITE,
        Blocks.ANDESITE,
        Blocks.POLISHED_ANDESITE,
        Blocks.STONE_SLAB,
        Blocks.SMOOTH_STONE_SLAB,
        Blocks.SANDSTONE_SLAB,
        Blocks.PETRIFIED_OAK_SLAB,
        Blocks.COBBLESTONE_SLAB,
        Blocks.BRICK_SLAB,
        Blocks.STONE_BRICK_SLAB,
        Blocks.NETHER_BRICK_SLAB,
        Blocks.QUARTZ_SLAB,
        Blocks.RED_SANDSTONE_SLAB,
        Blocks.PURPUR_SLAB,
        Blocks.SMOOTH_QUARTZ,
        Blocks.SMOOTH_RED_SANDSTONE,
        Blocks.SMOOTH_SANDSTONE,
        Blocks.SMOOTH_STONE,
        Blocks.STONE_BUTTON,
        Blocks.STONE_PRESSURE_PLATE,
        Blocks.POLISHED_GRANITE_SLAB,
        Blocks.SMOOTH_RED_SANDSTONE_SLAB,
        Blocks.MOSSY_STONE_BRICK_SLAB,
        Blocks.POLISHED_DIORITE_SLAB,
        Blocks.MOSSY_COBBLESTONE_SLAB,
        Blocks.END_STONE_BRICK_SLAB,
        Blocks.SMOOTH_SANDSTONE_SLAB,
        Blocks.SMOOTH_QUARTZ_SLAB,
        Blocks.GRANITE_SLAB,
        Blocks.ANDESITE_SLAB,
        Blocks.RED_NETHER_BRICK_SLAB,
        Blocks.POLISHED_ANDESITE_SLAB,
        Blocks.DIORITE_SLAB,
        Blocks.SHULKER_BOX,
        Blocks.BLACK_SHULKER_BOX,
        Blocks.BLUE_SHULKER_BOX,
        Blocks.BROWN_SHULKER_BOX,
        Blocks.CYAN_SHULKER_BOX,
        Blocks.GRAY_SHULKER_BOX,
        Blocks.GREEN_SHULKER_BOX,
        Blocks.LIGHT_BLUE_SHULKER_BOX,
        Blocks.LIGHT_GRAY_SHULKER_BOX,
        Blocks.LIME_SHULKER_BOX,
        Blocks.MAGENTA_SHULKER_BOX,
        Blocks.ORANGE_SHULKER_BOX,
        Blocks.PINK_SHULKER_BOX,
        Blocks.PURPLE_SHULKER_BOX,
        Blocks.RED_SHULKER_BOX,
        Blocks.WHITE_SHULKER_BOX,
        Blocks.YELLOW_SHULKER_BOX,
        Blocks.PISTON,
        Blocks.STICKY_PISTON,
        Blocks.PISTON_HEAD,
        Blocks.CLAY,
        Blocks.DIRT,
        Blocks.COARSE_DIRT,
        Blocks.PODZOL,
        Blocks.FARMLAND,
        Blocks.GRASS_BLOCK,
        Blocks.GRAVEL,
        Blocks.MYCELIUM,
        Blocks.SAND,
        Blocks.RED_SAND,
        Blocks.SNOW_BLOCK,
        Blocks.SNOW,
        Blocks.SOUL_SAND,
        Blocks.GRASS_PATH,
        Blocks.WHITE_CONCRETE_POWDER,
        Blocks.ORANGE_CONCRETE_POWDER,
        Blocks.MAGENTA_CONCRETE_POWDER,
        Blocks.LIGHT_BLUE_CONCRETE_POWDER,
        Blocks.YELLOW_CONCRETE_POWDER,
        Blocks.LIME_CONCRETE_POWDER,
        Blocks.PINK_CONCRETE_POWDER,
        Blocks.GRAY_CONCRETE_POWDER,
        Blocks.LIGHT_GRAY_CONCRETE_POWDER,
        Blocks.CYAN_CONCRETE_POWDER,
        Blocks.PURPLE_CONCRETE_POWDER,
        Blocks.BLUE_CONCRETE_POWDER,
        Blocks.BROWN_CONCRETE_POWDER,
        Blocks.GREEN_CONCRETE_POWDER,
        Blocks.RED_CONCRETE_POWDER,
        Blocks.BLACK_CONCRETE_POWDER,
        Blocks.SOUL_SOIL);

    // Map used to lookup shovel right click interactions
    protected static final Map<Block, BlockState> SHOVEL_LOOKUP = Maps.newHashMap(ImmutableMap.of(Blocks.GRASS_BLOCK, Blocks.GRASS_PATH.getDefaultState()));

    // Constructor for creating an ItemShovelPickaxe object
    public ItemShovelPickaxe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder)
    {
        super((float)attackDamageIn, attackSpeedIn, tier, EFFECTIVE_ON, builder.addToolType(net.minecraftforge.common.ToolType.PICKAXE, tier.getHarvestLevel()).addToolType(net.minecraftforge.common.ToolType.SHOVEL, tier.getHarvestLevel()));
    }

    //Check whether this Item can harvest the given Block
    public boolean canHarvestBlock(BlockState blockIn)
    {
        int i = this.getTier().getHarvestLevel();
        if (blockIn.getHarvestTool() == net.minecraftforge.common.ToolType.PICKAXE)
        {
            return i >= blockIn.getHarvestLevel();
        }
        else if(blockIn.getHarvestTool() == net.minecraftforge.common.ToolType.SHOVEL)
        {
            return blockIn.isIn(Blocks.SNOW) || blockIn.isIn(Blocks.SNOW_BLOCK);
        }
        else
        {
            Material material = blockIn.getMaterial();
            return material == Material.ROCK || material == Material.IRON || material == Material.ANVIL;
        }
    }

    public float getDestroySpeed(ItemStack stack, BlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK ? super.getDestroySpeed(stack, state) : this.efficiency;
    }

    // Called when this item is used when targeting a Block
    public ActionResultType onItemUse(ItemUseContext context)
    {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        BlockState blockstate = world.getBlockState(blockpos);
        if (context.getFace() == Direction.DOWN)
        {
            return ActionResultType.PASS;
        }
        else
        {
            PlayerEntity playerentity = context.getPlayer();
            BlockState blockstate1 = blockstate.getToolModifiedState(world, blockpos, playerentity, context.getItem(), net.minecraftforge.common.ToolType.SHOVEL);
            BlockState blockstate2 = null;
            if (blockstate1 != null && world.isAirBlock(blockpos.up()))
            {
                world.playSound(playerentity, blockpos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                blockstate2 = blockstate1;
            }
            else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.get(CampfireBlock.LIT))
            {
                if (!world.isRemote())
                {
                    world.playEvent((PlayerEntity)null, 1009, blockpos, 0);
                }

                CampfireBlock.extinguish(world, blockpos, blockstate);
                blockstate2 = blockstate.with(CampfireBlock.LIT, Boolean.valueOf(false));
            }

            if (blockstate2 != null)
            {
                if (!world.isRemote)
                {
                    world.setBlockState(blockpos, blockstate2, 11);
                    if (playerentity != null)
                    {
                        context.getItem().damageItem(1, playerentity, (player) -> {
                            player.sendBreakAnimation(context.getHand());
                        });
                    }
                }

                return ActionResultType.func_233537_a_(world.isRemote);
            }
            else
            {
                return ActionResultType.PASS;
            }
        }
    }

    @javax.annotation.Nullable
    public static BlockState getShovelPathingState(BlockState originalState) {
        return SHOVEL_LOOKUP.get(originalState.getBlock());
    }
}
