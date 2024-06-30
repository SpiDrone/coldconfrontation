package net.mcreator.coldconfrontation.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.coldconfrontation.init.ColdconfrontationModEntities;
import net.mcreator.coldconfrontation.entity.SpearEntityEntity;

public class SpearShootProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getBoolean("isCharging")) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = ColdconfrontationModEntities.SPEAR_ENTITY.get().spawn(_serverLevel, BlockPos.containing(x, (y + 1), z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				}
				if ((entitytospawn) instanceof SpearEntityEntity _datEntSetS)
					_datEntSetS.getEntityData().set(SpearEntityEntity.DATA_owner, (entity.getStringUUID()));
			}
		}
	}
}
