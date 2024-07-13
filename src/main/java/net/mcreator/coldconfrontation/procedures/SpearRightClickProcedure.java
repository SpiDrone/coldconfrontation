package net.mcreator.coldconfrontation.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

public class SpearRightClickProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getBoolean("isCharging")) {
			itemstack.getOrCreateTag().putDouble("CustomModelData", 0);
			itemstack.getOrCreateTag().putBoolean("isCharging", false);
		} else {
			itemstack.getOrCreateTag().putBoolean("isCharging", true);
			itemstack.getOrCreateTag().putDouble("CustomModelData", 1);
			itemstack.getOrCreateTag().putDouble("chargeTimeStart", (world.dayTime()));
		}
	}
}
