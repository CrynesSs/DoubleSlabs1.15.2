package com.mod.CrynessDoubleSlabs.Inits;

import com.mod.CrynessDoubleSlabs.Blocks.Double_Slabs.DoubleSlabBlock;
import com.mod.CrynessDoubleSlabs.Core.CrynessDoubleSlabs;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CrynessDoubleSlabs.MOD_ID);
    public static final RegistryObject<Block> DOUBLE_SLAB = BLOCKS.register("double_slab", DoubleSlabBlock::new);
}
