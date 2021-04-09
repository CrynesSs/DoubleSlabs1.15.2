package com.mod.CrynessDoubleSlabs.Blocks.Double_Slabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class DoubleSlabBlock extends SlabBlock {
    public DoubleSlabBlock() {
        super(Block.Properties.create(Material.CLAY).hardnessAndResistance(0.5F).notSolid());
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new DoubleSlabTE();
    }
}
