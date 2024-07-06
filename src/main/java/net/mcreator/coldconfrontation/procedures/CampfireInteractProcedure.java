package net.mcreator.coldconfrontation.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.coldconfrontation.network.ColdconfrontationModVariables;

public class CampfireInteractProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = x;
			entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.campfireX = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = y;
			entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.campfireY = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = z;
			entity.getCapability(ColdconfrontationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.campfireZ = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("[Spawn Point Set]"), false);
	}
}
