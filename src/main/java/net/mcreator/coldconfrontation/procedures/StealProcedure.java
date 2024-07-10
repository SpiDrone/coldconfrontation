package net.mcreator.coldconfrontation.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.coldconfrontation.entity.SpearEntityEntity;
import net.mcreator.coldconfrontation.ColdconfrontationMod;

public class StealProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ColdconfrontationMod.LOGGER.info(entity instanceof SpearEntityEntity _datEntS ? _datEntS.getEntityData().get(SpearEntityEntity.DATA_texture) : "");
	}
}
