package net.mcreator.coldconfrontation.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class MutatedWolfEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide() && world.getServer() != null) {
			for (ItemStack itemstackiterator : world.getServer().getLootData().getLootTable(new ResourceLocation("coldconfrontation:entities/mutated_wolf"))
					.getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
