package net.mcreator.coldconfrontation.entity.model;

import software.bernie.geckolib.core.animation.AnimationState;

public class MutatedWolfModel extends GeoModel<MutatedWolfEntity> {
	@Override
	public ResourceLocation getAnimationResource(MutatedWolfEntity entity) {
		return new ResourceLocation("coldconfrontation", "animations/fox.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MutatedWolfEntity entity) {
		return new ResourceLocation("coldconfrontation", "geo/fox.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MutatedWolfEntity entity) {
		return new ResourceLocation("coldconfrontation", "textures/entities/" + entity.getTexture() + ".png");
	}

}