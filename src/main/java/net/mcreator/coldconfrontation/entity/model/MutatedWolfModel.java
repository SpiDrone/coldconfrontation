package net.mcreator.coldconfrontation.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.coldconfrontation.entity.MutatedWolfEntity;

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
