package net.mcreator.coldconfrontation.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

import net.mcreator.coldconfrontation.init.ColdconfrontationModEntities;
import net.mcreator.coldconfrontation.entity.MutantFoxEntity;
import net.mcreator.coldconfrontation.ColdconfrontationMod;

public class BigballsProcedure {
	public static void execute(LevelAccessor world) {
		ColdconfrontationMod.LOGGER.info(world instanceof Level _level ? new MutantFoxEntity(ColdconfrontationModEntities.MUTANT_FOX.get(), _level) : null);
	}
}
