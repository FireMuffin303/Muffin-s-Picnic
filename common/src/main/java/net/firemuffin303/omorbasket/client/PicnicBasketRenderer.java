package net.firemuffin303.omorbasket.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.firemuffin303.omorbasket.OmorBasketMod;
import net.firemuffin303.omorbasket.common.block.BasketBlock;
import net.firemuffin303.omorbasket.common.block.entity.BasketBlockEntity;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Arrays;
import java.util.Comparator;

public class PicnicBasketRenderer implements BlockEntityRenderer<BasketBlockEntity> {
    public static final Material[] MATERIALS;
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
    public void render(BasketBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        Direction direction = Direction.UP;
        if(blockEntity.hasLevel()){
            BlockState blockState = blockEntity.getLevel().getBlockState(blockEntity.getBlockPos());
            if(blockState.getBlock() instanceof BasketBlock){
                direction = blockState.getValue(BasketBlock.FACING);
            }
        }

        DyeColor dyeColor = blockEntity.getColor();
        Material material = MATERIALS[dyeColor.getId()];

        poseStack.pushPose();
        poseStack.translate(0.5F, 0.5F, 0.5F);
        poseStack.mulPose(direction.getRotation());
        VertexConsumer vertexConsumer = material.buffer(multiBufferSource, RenderType::entityCutoutNoCull);
        this.render(poseStack, vertexConsumer, this.lid, this.bottom, f, i, j);
        poseStack.popPose();
    }

    private void render(PoseStack poseStack, VertexConsumer vertexConsumer, ModelPart modelPart, ModelPart modelPart2, float f, int i, int j) {
        modelPart.xRot = -(f * 1.5707964F);
        modelPart.render(poseStack, vertexConsumer, i, j);
        modelPart2.render(poseStack, vertexConsumer, i, j);

    }

    static {
        MATERIALS = Arrays.stream(DyeColor.values()).sorted(Comparator.comparingInt(DyeColor::getId)).map((dyeColor) ->{
            return new Material(new ResourceLocation(OmorBasketMod.MOD_ID,"textures/atlas/picnic_basket.png"), new ResourceLocation(OmorBasketMod.MOD_ID,"entity/picnic_basket/" + dyeColor.getName()));
        }).toArray(Material[]::new);
    }
}
