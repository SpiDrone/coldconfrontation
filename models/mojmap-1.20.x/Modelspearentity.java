
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import net.mcreator.coldconfrontation.entity.SpearEntityEntity;
import net.mcreator.coldconfrontation.client.model.Modelspearentity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelspearentity<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "spearentity"), "main");
	private final ModelPart bone;

	public Modelspearentity(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, -3.5F));
		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(22, 0).addBox(0.0F, -14.0F, 0.5F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(22, 5).addBox(-2.5F, -14.0F, 3.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(24, 27)
						.addBox(-0.5F, 7.0F, 2.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.2F)).texOffs(19, 28).addBox(-0.5F, -8.0F, 2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.2F)).texOffs(28, 10)
						.addBox(-0.5F, -9.0F, 2.5F, 1.0F, 21.0F, 1.0F, new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.1284F, 3.0F, 3.4619F, 1.5708F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.bone.xRot = (Float.parseFloat(entity instanceof SpearEntityEntity _datEntS ? _datEntS.getEntityData().get(SpearEntityEntity.DATA_pitch) : "0")) / (180F / (float) Math.PI);
	}
}
