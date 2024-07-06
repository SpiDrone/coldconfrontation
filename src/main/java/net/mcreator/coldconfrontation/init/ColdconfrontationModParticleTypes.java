
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.coldconfrontation.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.coldconfrontation.ColdconfrontationMod;

public class ColdconfrontationModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ColdconfrontationMod.MODID);
	public static final RegistryObject<SimpleParticleType> CAMPFIRE_FLAME = REGISTRY.register("campfire_flame", () -> new SimpleParticleType(false));
}
