package com.mod.CrynessDoubleSlabs.Core;

import com.mod.CrynessDoubleSlabs.Blocks.Double_Slabs.DoubleSlabTE;
import com.mod.CrynessDoubleSlabs.Inits.BlockInit;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CrynessDoubleSlabs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {

    @SubscribeEvent
    public static void onBlockBreak(final BlockEvent.BreakEvent event) {
        if (event.getState().getBlock().equals(BlockInit.DOUBLE_SLAB.get())) {
            BlockPos eventPos = event.getPos();
            DoubleSlabTE te = (DoubleSlabTE) event.getWorld().getTileEntity(eventPos);
            if (te == null) {
                return;
            }
            if (!event.getPlayer().isCreative()) {
                if (te.getTextures().getKey() != null) {
                    InventoryHelper.spawnItemStack((World) event.getWorld(), eventPos.getX(), eventPos.getY(), eventPos.getZ(), new ItemStack(te.getTextures().getKey().getBlock()));
                }
                if (te.getTextures().getValue() != null) {
                    InventoryHelper.spawnItemStack((World) event.getWorld(), eventPos.getX(), eventPos.getY(), eventPos.getZ(), new ItemStack(te.getTextures().getValue().getBlock()));
                }
            }
        }
    }
}
