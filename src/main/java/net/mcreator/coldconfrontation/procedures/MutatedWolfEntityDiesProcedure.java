package net.mcreator.coldconfrontation.procedures;

import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

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
