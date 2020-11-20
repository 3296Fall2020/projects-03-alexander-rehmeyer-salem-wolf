package com.example.Tutils.Items;

import com.example.Tutils.Blocks.RedstoneReceiver;
import com.example.Tutils.Tutils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class RedstoneRemote extends Item {

    public RedstoneRemote(){
        super(new Item.Properties().group(Tutils.TAB));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemStackIn = playerIn.getHeldItem(handIn);
        CompoundNBT nbtTagCompound = itemStackIn.getTag();

        if (playerIn.isSneaking()) { // player isSneaking (shift pressed); save (or overwrite) current location
            if (nbtTagCompound == null) {
                nbtTagCompound = new CompoundNBT();
                itemStackIn.setTag(nbtTagCompound);
            }

            RayTraceResult lookingAt = Minecraft.getInstance().objectMouseOver;
            if (lookingAt != null && lookingAt.getType() == RayTraceResult.Type.BLOCK) {
                double x = lookingAt.getHitVec().getX();
                double y = lookingAt.getHitVec().getY();
                double z = lookingAt.getHitVec().getZ();
                if(worldIn.getBlockState(new BlockPos(x,y,z)).getBlock() instanceof RedstoneReceiver){
                    nbtTagCompound.putBoolean("bound", true);
                    nbtTagCompound.putInt("x", (int)x);
                    nbtTagCompound.putInt("y", (int)y);
                    nbtTagCompound.putInt("z", (int)z);
                    playerIn.sendStatusMessage(new StringTextComponent(String.format("Bounding to the receiver at X:%d Y:%d Z:%d", (int)x, (int)y, (int)z)), true);
                }
            }
            return new ActionResult<ItemStack>(ActionResultType.SUCCESS, itemStackIn);
        }

        boolean bound = false;
        if (nbtTagCompound != null && nbtTagCompound.contains("bound")  ) {
            bound = nbtTagCompound.getBoolean("bound");
        }
        if (bound) {
            int x = nbtTagCompound.getInt("x");
            int y = nbtTagCompound.getInt("y");
            int z = nbtTagCompound.getInt("z");
            worldIn.getBlockState(new BlockPos(x,y,z));
            if(worldIn.getBlockState(new BlockPos(x,y,z)).getBlock() instanceof RedstoneReceiver){
                ((RedstoneReceiver) worldIn.getBlockState(new BlockPos(x,y,z)).getBlock()).powerBlock(worldIn.getBlockState(new BlockPos(x,y,z)), worldIn, new BlockPos(x,y,z));
            } else {
                itemStackIn.setTag(null);
            }
            return new ActionResult<ItemStack>(ActionResultType.SUCCESS, itemStackIn);
        } else {
            if (worldIn.isRemote) {  // only on the client side, else you will get two messages..
                final boolean PRINT_IN_CHAT_WINDOW = true;
                playerIn.sendStatusMessage(new StringTextComponent("Remote doesn't have a bounded Redstone Receiver! Shift right click on a receiver to bound it to a remote."), PRINT_IN_CHAT_WINDOW);
            }
            return new ActionResult<ItemStack>(ActionResultType.FAIL, itemStackIn);
        }

    }


}
