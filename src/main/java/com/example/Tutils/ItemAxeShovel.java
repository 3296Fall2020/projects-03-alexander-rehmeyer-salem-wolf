package com.example.Tutils;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Set;

public class ItemAxeShovel extends ToolItem
{
    private static final Set<Block> EFFECTIVE_ON_BLOCKS = Sets.newHashSet(Blocks.CLAY,
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
        Blocks.SOUL_SOIL,
        Blocks.LADDER,
        Blocks.SCAFFOLDING,
        Blocks.OAK_BUTTON,
        Blocks.SPRUCE_BUTTON,
        Blocks.BIRCH_BUTTON,
        Blocks.JUNGLE_BUTTON,
        Blocks.DARK_OAK_BUTTON,
        Blocks.ACACIA_BUTTON,
        Blocks.CRIMSON_BUTTON,
        Blocks.WARPED_BUTTON);

    private static final Set<Material> EFFECTIVE_ON_MATERIALS = Sets.newHashSet(
        Material.WOOD,
        Material.NETHER_WOOD,
        Material.PLANTS,
        Material.TALL_PLANTS,
        Material.BAMBOO,
        Material.GOURD);

    protected static final Map<Block, Block> BLOCK_STRIPPING_MAP = (new ImmutableMap.Builder<Block,
        Block>()).put(Blocks.OAK_WOOD,
        Blocks.STRIPPED_OAK_WOOD).put(Blocks.OAK_LOG,
        Blocks.STRIPPED_OAK_LOG).put(Blocks.DARK_OAK_WOOD,
        Blocks.STRIPPED_DARK_OAK_WOOD).put(Blocks.DARK_OAK_LOG,
        Blocks.STRIPPED_DARK_OAK_LOG).put(Blocks.ACACIA_WOOD,
        Blocks.STRIPPED_ACACIA_WOOD).put(Blocks.ACACIA_LOG,
        Blocks.STRIPPED_ACACIA_LOG).put(Blocks.BIRCH_WOOD,
        Blocks.STRIPPED_BIRCH_WOOD).put(Blocks.BIRCH_LOG,
        Blocks.STRIPPED_BIRCH_LOG).put(Blocks.JUNGLE_WOOD,
        Blocks.STRIPPED_JUNGLE_WOOD).put(Blocks.JUNGLE_LOG,
        Blocks.STRIPPED_JUNGLE_LOG).put(Blocks.SPRUCE_WOOD,
        Blocks.STRIPPED_SPRUCE_WOOD).put(Blocks.SPRUCE_LOG,
        Blocks.STRIPPED_SPRUCE_LOG).put(Blocks.WARPED_STEM,
        Blocks.STRIPPED_WARPED_STEM).put(Blocks.WARPED_HYPHAE,
        Blocks.STRIPPED_WARPED_HYPHAE).put(Blocks.CRIMSON_STEM,
        Blocks.STRIPPED_CRIMSON_STEM).put(Blocks.CRIMSON_HYPHAE,
        Blocks.STRIPPED_CRIMSON_HYPHAE).build();


    // Map used to lookup shovel right click interactions
    protected static final Map<Block, BlockState> SHOVEL_LOOKUP = Maps.newHashMap(ImmutableMap.of(Blocks.GRASS_BLOCK, Blocks.GRASS_PATH.getDefaultState()));

    public ItemAxeShovel(IItemTier tier, float attackDamageIn, float attackSpeedIn, Item.Properties builder)
    {
        super(attackDamageIn, attackSpeedIn, tier, EFFECTIVE_ON_BLOCKS, builder.addToolType(net.minecraftforge.common.ToolType.SHOVEL, tier.getHarvestLevel()));
    }

    // Check whether this Item can harvest the given Block
    public boolean canHarvestBlock(BlockState blockIn)
    {
        return blockIn.isIn(Blocks.SNOW) || blockIn.isIn(Blocks.SNOW_BLOCK);
    }

    public float getDestroySpeed(ItemStack stack, BlockState state)
    {
        Material material = state.getMaterial();
        return EFFECTIVE_ON_MATERIALS.contains(material) ? this.efficiency : super.getDestroySpeed(stack, state);
    }

    // Called when this item is used when targetting a Block
    public ActionResultType onItemUse(ItemUseContext context)
    {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        BlockState blockstate = world.getBlockState(blockpos);
        BlockState block = blockstate.getToolModifiedState(world, blockpos, context.getPlayer(), context.getItem(), net.minecraftforge.common.ToolType.AXE);

        if (context.getFace() == Direction.DOWN)
        {
            return ActionResultType.PASS;
        }
        else if (block != null)
        {
            PlayerEntity playerentity = context.getPlayer();
            world.playSound(playerentity, blockpos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (!world.isRemote)
            {
                world.setBlockState(blockpos, block, 11);
                if (playerentity != null)
                {
                    context.getItem().damageItem(1, playerentity, (p_220040_1_) -> {
                        p_220040_1_.sendBreakAnimation(context.getHand());
                    });
                }
            }
            return ActionResultType.func_233537_a_(world.isRemote);
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
    public static BlockState getShovelPathingState(BlockState originalState)
    {
        return SHOVEL_LOOKUP.get(originalState.getBlock());
    }

    @javax.annotation.Nullable
    public static BlockState getAxeStrippingState(BlockState originalState) {
        Block block = BLOCK_STRIPPING_MAP.get(originalState.getBlock());
        return block != null ? block.getDefaultState().with(RotatedPillarBlock.AXIS, originalState.get(RotatedPillarBlock.AXIS)) : null;
    }
}
