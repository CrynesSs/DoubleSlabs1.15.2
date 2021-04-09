package com.mod.CrynessDoubleSlabs.Blocks.Double_Slabs;

import com.mod.CrynessDoubleSlabs.Core.CrynessDoubleSlabs;
import javafx.util.Pair;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ILightReader;
import net.minecraftforge.client.model.data.EmptyModelData;
import net.minecraftforge.client.model.data.IDynamicBakedModel;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.data.ModelDataMap;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

public class DoubleSlabBakedModel implements IDynamicBakedModel {
    public static final ResourceLocation TEXTURE = new ResourceLocation(CrynessDoubleSlabs.MOD_ID, "block/double_slab");


    public DoubleSlabBakedModel() {

    }

    @Override
    public boolean isAmbientOcclusion(BlockState state) {
        return true;
    }

    @Nonnull
    @Override
    public IModelData getModelData(@Nonnull ILightReader world, @Nonnull BlockPos pos, @Nonnull BlockState state, @Nonnull IModelData tileData) {
        return new ModelDataMap.Builder()
                .withInitial(DoubleSlabTE.TOP_AND_BOTTOM_TEXTURE, ((DoubleSlabTE) Objects.requireNonNull(world.getTileEntity(pos))).textures)
                .build();
    }

    @SuppressWarnings("deprecation")
    private TextureAtlasSprite getTexture() {
        return Minecraft.getInstance().getAtlasSpriteGetter(AtlasTexture.LOCATION_BLOCKS_TEXTURE).apply(DoubleSlabBakedModel.TEXTURE);
    }

    @Nonnull
    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand, @Nonnull IModelData extraData) {
        Pair<BlockState, BlockState> topAndBottomState = extraData.getData(DoubleSlabTE.TOP_AND_BOTTOM_TEXTURE);
        if (state == null || topAndBottomState == null) {
            return Collections.emptyList();
        }
        switch (state.get(SlabBlock.TYPE)) {
            case BOTTOM: {
                IBakedModel model1 = Minecraft.getInstance().getBlockRendererDispatcher().getBlockModelShapes().getModel(topAndBottomState.getKey());
                if (model1.equals(Minecraft.getInstance().getModelManager().getMissingModel())) {
                    return Collections.emptyList();
                } else {
                    return model1.getQuads(topAndBottomState.getKey(), side, rand, EmptyModelData.INSTANCE);
                }
            }
            case TOP: {
                IBakedModel model2 = Minecraft.getInstance().getBlockRendererDispatcher().getBlockModelShapes().getModel(topAndBottomState.getValue());
                if (model2.equals(Minecraft.getInstance().getModelManager().getMissingModel())) {
                    return Collections.emptyList();
                } else {
                    return model2.getQuads(topAndBottomState.getKey(), side, rand, EmptyModelData.INSTANCE);
                }
            }
            case DOUBLE: {
                IBakedModel model1 = Minecraft.getInstance().getBlockRendererDispatcher().getBlockModelShapes().getModel(topAndBottomState.getKey());
                IBakedModel model2 = Minecraft.getInstance().getBlockRendererDispatcher().getBlockModelShapes().getModel(topAndBottomState.getValue());
                if (model1.equals(Minecraft.getInstance().getModelManager().getMissingModel()) || model2.equals(Minecraft.getInstance().getModelManager().getMissingModel())) {
                    return Collections.emptyList();
                } else {
                    List<BakedQuad> quads = new ArrayList<>();
                    quads.addAll(model1.getQuads(topAndBottomState.getKey(), side, rand, EmptyModelData.INSTANCE));
                    quads.addAll(model2.getQuads(topAndBottomState.getValue(), side, rand, EmptyModelData.INSTANCE));
                    return quads;
                }
            }
            default: {
                return Collections.emptyList();
            }
        }
    }

    @Override
    public boolean isAmbientOcclusion() {
        return true;
    }

    @Override
    public boolean isGui3d() {
        return false;
    }

    @Override
    public boolean func_230044_c_() {
        return false;
    }

    @Override
    public boolean isBuiltInRenderer() {
        return false;
    }

    @Override
    @Nonnull
    public TextureAtlasSprite getParticleTexture() {
        return getTexture();
    }

    @Override
    @Nonnull
    public ItemOverrideList getOverrides() {
        return ItemOverrideList.EMPTY;
    }
}
