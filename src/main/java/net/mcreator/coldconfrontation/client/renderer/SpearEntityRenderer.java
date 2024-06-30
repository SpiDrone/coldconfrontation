
package net.mcreator.coldconfrontation.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.coldconfrontation.entity.SpearEntityEntity;
import net.mcreator.coldconfrontation.client.model.Modelspearentity;

public class SpearEntityRenderer extends MobRenderer<SpearEntityEntity, Modelspearentity<SpearEntityEntity>> {
	public SpearEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelspearentity(context.bakeLayer(Modelspearentity.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(SpearEntityEntity entity) {
		return new ResourceLocation("coldconfrontation:textures/entities/spear1.png");
	}
}
