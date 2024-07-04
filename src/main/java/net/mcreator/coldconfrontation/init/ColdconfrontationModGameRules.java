
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.coldconfrontation.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ColdconfrontationModGameRules {
	public static final GameRules.Key<GameRules.IntegerValue> DEFAULT_COLD = GameRules.register("defaultCold", GameRules.Category.PLAYER, GameRules.IntegerValue.create(4));
}
