package net.mcreator.coldconfrontation.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

public class FuckyouProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double varX = 0;
		double varZ = 0;
		varX = -4;
		varZ = -4;
		while (true) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, (x + varX), y, (z + varZ), 4, Level.ExplosionInteraction.NONE);
			if (varX == 4) {
				if (varZ == 4) {
					break;
				} else {
					varX = -4;
					varZ = varZ + 1;
				}
			} else {
				varX = varX + 1;
			}
		}
	}
}
