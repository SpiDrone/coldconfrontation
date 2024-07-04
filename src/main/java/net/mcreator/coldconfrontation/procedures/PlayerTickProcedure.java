package net.mcreator.coldconfrontation.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.coldconfrontation.network.ColdconfrontationModVariables;
import net.mcreator.coldconfrontation.init.ColdconfrontationModMobEffects;
import net.mcreator.coldconfrontation.init.ColdconfrontationModGameRules;
import net.mcreator.coldconfrontation.init.ColdconfrontationModAttributes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double modifier = 0;
		if (world instanceof Level _lvl0 && _lvl0.isDay()) {
			modifier = (world.getLevelData().getGameRules().getInt(ColdconfrontationModGameRules.DEFAULT_COLD)) + (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) ? 3 : 0);
		} else {
			modifier = (world.getLevelData().getGameRules().getInt(ColdconfrontationModGameRules.DEFAULT_COLD)) + (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) ? 5 : 0);
		}
		modifier = Math.max(modifier - ((LivingEntity) entity).getAttribute(ColdconfrontationModAttributes.COLDRESISTANCE.get()).getValue(), 0);
		if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(ColdconfrontationModMobEffects.WARM.get()))) {
			{
				double _setval = Math.max((entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).PlayerHeat - modifier, 0);
				entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerHeat = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (entity.isInWaterRainOrBubble()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ColdconfrontationModMobEffects.WET.get(), 500, 1, false, false));
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("" + (entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ColdconfrontationModVariables.PlayerVariables())).PlayerHeat)), true);
	}
}
