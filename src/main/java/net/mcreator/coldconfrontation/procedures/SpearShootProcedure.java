package net.mcreator.coldconfrontation.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.coldconfrontation.init.ColdconfrontationModItems;
import net.mcreator.coldconfrontation.init.ColdconfrontationModEntities;
import net.mcreator.coldconfrontation.entity.SpearEntityEntity;

public class SpearShootProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getBoolean("isCharging")) {
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt(2, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = ColdconfrontationModEntities.SPEAR_ENTITY.get().spawn(_serverLevel, BlockPos.containing(x, (y + 1), z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				}
				{
					final int _slotid = 0;
					final ItemStack _setstack = (itemstack.copy());
					_setstack.setCount(1);
					(entitytospawn).getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable _modHandler)
							_modHandler.setStackInSlot(_slotid, _setstack);
					});
				}
				if ((entitytospawn) instanceof SpearEntityEntity _datEntSetS)
					_datEntSetS.getEntityData().set(SpearEntityEntity.DATA_owner, (entity.getStringUUID()));
				if (itemstack.getItem() == ColdconfrontationModItems.WOODEN_SPEAR.get()) {
					if ((entitytospawn) instanceof SpearEntityEntity _datEntSetS)
						_datEntSetS.getEntityData().set(SpearEntityEntity.DATA_texture, "coldconfrontation:textures/entities/spear_wood.png");
					if ((entitytospawn) instanceof SpearEntityEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SpearEntityEntity.DATA_strength, 30);
					if ((entitytospawn) instanceof SpearEntityEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SpearEntityEntity.DATA_damage, (int) 4.5);
				} else if (itemstack.getItem() == ColdconfrontationModItems.STONE_SPEAR.get()) {
					if ((entitytospawn) instanceof SpearEntityEntity _datEntSetS)
						_datEntSetS.getEntityData().set(SpearEntityEntity.DATA_texture, "coldconfrontation:textures/entities/spear_stone.png");
					if ((entitytospawn) instanceof SpearEntityEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SpearEntityEntity.DATA_strength, 35);
					if ((entitytospawn) instanceof SpearEntityEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SpearEntityEntity.DATA_damage, (int) 5.5);
				} else if (itemstack.getItem() == ColdconfrontationModItems.IRON_SPEAR.get()) {
					if ((entitytospawn) instanceof SpearEntityEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SpearEntityEntity.DATA_damage, (int) 7.5);
					if ((entitytospawn) instanceof SpearEntityEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SpearEntityEntity.DATA_strength, 40);
				}
			}
			itemstack.shrink(1);
		}
	}
}
