package net.firemuffin303.omorbasket.client.renderer;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.firemuffin303.omorbasket.PicnicMod;
import net.firemuffin303.omorbasket.common.block.BasketBlock;
import net.firemuffin303.omorbasket.common.block.entity.BasketBlockEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class PicnicBasketRenderer implements BlockEntityRenderer<BasketBlockEntity> {
    public static final List<ResourceLocation> MATERIALS;
    private final ModelPart lid;
    private final ModelPart bottom;
    private final ModelPart handle;

    public static final ModelLayerLocation LAYER = new ModelLayerLocation(new ResourceLocation(PicnicMod.MOD_ID,"picnic_basket"),"main");

    public PicnicBasketRenderer(BlockEntityRendererProvider.Context context){
        ModelPart modelPart = context.bakeLayer(LAYER);
        this.bottom = modelPart.getChild("bottom");
        this.lid = modelPart.getChild("lid");
        this.handle = modelPart.getChild("handle");
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, 0.0F, 2.0F, 14.0F, 8.0F, 12.0F), PartPose.ZERO);
        partDefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 20).addBox(1.0F, 0.0F, 0.0F, 14.0F, 2.0F, 12.0F), PartPose.offset(0.0F, 8.0F, 2.0F));
        partDefinition.addOrReplaceChild("handle", CubeListBuilder.create().texOffs(8,34)
                .addBox(-1.0f,0.0f,0.0f,18.0f,8.0f,0.0f),
                PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 1.4f, 0.0F, 0.0F));
        return LayerDefinition.create(meshDefinition, 64, 64);

    }

    @Override
    public void render(BasketBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        float g = 0;

        if(blockEntity.hasLevel()){
            BlockState blockState = blockEntity.getLevel().getBlockState(blockEntity.getBlockPos());
            if(blockState.getBlock() instanceof BasketBlock){
                g = blockState.getValue(BasketBlock.FACING).toYRot();
            }
        }

        ResourceLocation resourceLocation = MATERIALS.get(blockEntity.getColor().getId());

        if(blockEntity.getColor().equals(DyeColor.BLACK) & blockEntity.getName().getString().toLowerCase(Locale.ROOT).equals("something")){
            resourceLocation = new ResourceLocation(PicnicMod.MOD_ID,"textures/block/picnic_basket/something.png");
        }

        poseStack.pushPose();
        poseStack.translate(0.5F, 0.5F, 0.5F);
        poseStack.mulPose(Axis.YP.rotationDegrees(-g));
        poseStack.translate(-0.5F, -0.5F, -0.5F);
        float openNess = blockEntity.getOpenNess(f);
        openNess = 1.0F - openNess;
        openNess = 1.0F - openNess * openNess * openNess;
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(resourceLocation));
        this.handle.render(poseStack,vertexConsumer,i,j);
        this.render(poseStack, vertexConsumer, this.lid, this.bottom, openNess, i, j);

       //ResourceLocation colorOverlay = MATERIALS.get(blockEntity.getColor().getId());

       //if(blockEntity.getColor().equals(DyeColor.BLACK) & blockEntity.getName().getString().toLowerCase(Locale.ROOT).equals("something")){
       //    colorOverlay = new ResourceLocation(OmorBasketMod.MOD_ID,"textures/block/picnic_basket/something.png");
       //}


        //this.lid.render(poseStack,multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(colorOverlay)),i,j);
        //this.bottom.render(poseStack,multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(colorOverlay)),i,j);
        poseStack.popPose();
    }


    private void render(PoseStack poseStack, VertexConsumer vertexConsumer, ModelPart modelPart, ModelPart modelPart2, float f, int i, int j) {
        modelPart.xRot = -(f * 1.5707964F);
        modelPart.render(poseStack, vertexConsumer, i, j);
        modelPart2.render(poseStack, vertexConsumer, i, j);

    }

    public ModelPart getLid() {
        return this.lid;
    }

    public ModelPart getBottom() {
        return this.bottom;
    }



    static {
        MATERIALS = Stream.of(DyeColor.values()).map((dyeColor) -> {
            return new ResourceLocation(PicnicMod.MOD_ID,"textures/block/picnic_basket/" + dyeColor.getName() +".png");
        }).collect(ImmutableList.toImmutableList());
    }
}
