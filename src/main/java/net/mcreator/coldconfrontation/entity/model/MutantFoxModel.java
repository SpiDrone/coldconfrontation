package net.mcreator.coldconfrontation.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.coldconfrontation.entity.MutantFoxEntity;

public class MutantFoxModel extends GeoModel<MutantFoxEntity> {
	@Override
	public ResourceLocation getAnimationResource(MutantFoxEntity entity) {
		return new ResourceLocation("coldconfrontation", "animations/fox.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MutantFoxEntity entity) {
		return new ResourceLocation("coldconfrontation", "geo/fox.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MutantFoxEntity entity) {
		return new ResourceLocation("coldconfrontation", "textures/entities/" + entity.getTexture() + ".png");
	}

}
