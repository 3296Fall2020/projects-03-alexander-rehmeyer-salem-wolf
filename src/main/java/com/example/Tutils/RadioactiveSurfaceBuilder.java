package com.example.Tutils;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class RadioactiveSurfaceBuilder extends SurfaceBuilderConfig
{
    public RadioactiveSurfaceBuilder(BlockState topMaterial, BlockState underMaterial, BlockState underWaterMaterial) {
        super(topMaterial, underMaterial, underWaterMaterial);
    }
}
