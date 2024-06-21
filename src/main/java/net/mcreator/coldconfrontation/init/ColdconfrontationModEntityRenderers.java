
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.coldconfrontation.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.coldconfrontation.client.renderer.MutantFoxRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ColdconfrontationModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ColdconfrontationModEntities.MUTANT_FOX.get(), MutantFoxRenderer::new);
	}
}
