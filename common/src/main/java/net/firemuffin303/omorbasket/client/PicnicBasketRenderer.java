package net.firemuffin303.omorbasket.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;

public class PicnicBasketRenderer <T extends BlockEntity & LidBlockEntity> implements BlockEntityRenderer<T> {
    private final ModelPart lid;
    private final ModelPart bottom;

    public PicnicBasketRenderer(BlockEntityRendererProvider.Context context){
        ModelPart modelPart = context.bakeLayer(ModelLayers.CHEST);
        this.bottom = modelPart.getChild("bottom");
        this.lid = modelPart.getChild("lid");
    }

    public static LayerDefinition createSingleBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 19).addBox(2.0F, 0.0F, 1.0F, 13.0F, 8.0F, 14.0F), PartPose.ZERO);
        partDefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 0).addBox(2.0F, 0.0F, 0.0F, 13.0F, 2.0F, 14.0F), PartPose.offset(0.0F, 8.0F, 1.0F));
        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void render(T blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        Level level = blockEntity.getLevel();
    }
}
