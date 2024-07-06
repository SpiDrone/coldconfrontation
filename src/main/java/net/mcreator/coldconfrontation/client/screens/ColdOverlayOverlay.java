
package net.mcreator.coldconfrontation.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.coldconfrontation.network.ColdconfrontationModVariables;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class ColdOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (true) {
			float heat = (float) (entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).PlayerHeat;
			if (heat < 2500) {
				float alpha = 1 - (heat / 2500);
				RenderSystem.setShaderColor(1, 1, 1, alpha);
				event.getGuiGraphics().blit(new ResourceLocation("coldconfrontation:textures/screens/cold_overlay.png"), 0, 0, 0, 0, w, h, w, h);
			} else if (heat > 7500) {
				float alpha = (heat - 7500) / 2500;
				RenderSystem.setShaderColor(.85F, .2F, 0, alpha);
				event.getGuiGraphics().blit(new ResourceLocation("coldconfrontation:textures/screens/cold_overlay.png"), 0, 0, 0, 0, w, h, w, h);
			}
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
