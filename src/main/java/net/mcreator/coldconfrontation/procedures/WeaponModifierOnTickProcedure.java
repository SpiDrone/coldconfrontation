package net.mcreator.coldconfrontation.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class WeaponModifierOnTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide() && entity.isAlive()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("coldconfrontation:spears")))) {
				if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getBoolean("isCharging"))) {
					if (!(((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get())
							.hasModifier((new AttributeModifier(UUID.fromString("7afeaa72-85dc-40be-aaf7-d502a29579e3"), "coldconfrontation_spearmodifier", 0.5, AttributeModifier.Operation.ADDITION)))))
						((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get())
								.addTransientModifier((new AttributeModifier(UUID.fromString("7afeaa72-85dc-40be-aaf7-d502a29579e3"), "coldconfrontation_spearmodifier", 0.5, AttributeModifier.Operation.ADDITION)));
				} else if (((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).getModifier(UUID.fromString("7afeaa72-85dc-40be-aaf7-d502a29579e3")) != null) {
					((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get())
							.removeModifier((new AttributeModifier(UUID.fromString("7afeaa72-85dc-40be-aaf7-d502a29579e3"), "coldconfrontation_spearmodifier", 0.5, AttributeModifier.Operation.ADDITION)));
				}
			} else if (((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).getModifier(UUID.fromString("7afeaa72-85dc-40be-aaf7-d502a29579e3")) != null) {
				((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get())
						.removeModifier((new AttributeModifier(UUID.fromString("7afeaa72-85dc-40be-aaf7-d502a29579e3"), "coldconfrontation_spearmodifier", 0.5, AttributeModifier.Operation.ADDITION)));
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Current Range: " + ((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_REACH.get()).getValue())), true);
		}
	}
}
