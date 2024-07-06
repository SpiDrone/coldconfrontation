
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.coldconfrontation.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.coldconfrontation.client.particle.CampfireFlameParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ColdconfrontationModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(ColdconfrontationModParticleTypes.CAMPFIRE_FLAME.get(), CampfireFlameParticle::provider);
	}
}
