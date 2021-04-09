package com.mod.CrynessDoubleSlabs.Core;

import com.mod.CrynessDoubleSlabs.Blocks.Double_Slabs.DoubleSlabModelLoader;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CrynessDoubleSlabs.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    @SubscribeEvent
    public static void onTextureStitch(TextureStitchEvent.Pre event) {
        if (!event.getMap().getTextureLocation().equals(AtlasTexture.LOCATION_BLOCKS_TEXTURE)) {
            return;
        }
        event.addSprite(new ResourceLocation(CrynessDoubleSlabs.MOD_ID,"block/double_slab"));
    }
    @SubscribeEvent
    public static void onModelRegistryEvent(ModelRegistryEvent event) {
        System.out.println("Registering Loader");
        ModelLoaderRegistry.registerLoader(new ResourceLocation(CrynessDoubleSlabs.MOD_ID, "fancyloader"), new DoubleSlabModelLoader());
    }
}
