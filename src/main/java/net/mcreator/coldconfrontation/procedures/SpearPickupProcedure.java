package net.mcreator.coldconfrontation.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.coldconfrontation.entity.SpearEntityEntity;

import java.util.concurrent.atomic.AtomicReference;

public class SpearPickupProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double modifier = 0;
		if (!world.isClientSide()) {
			if (entity.onGround() && (entity instanceof SpearEntityEntity _datEntI ? _datEntI.getEntityData().get(SpearEntityEntity.DATA_spearstate) : 0) == 1) {
				if (sourceentity instanceof Player _player) {
					ItemStack _setstack = (new Object() {
						public ItemStack getItemStack(int sltid, Entity entity) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
							return _retval.get();
						}
					}.getItemStack(0, entity));
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}
}
