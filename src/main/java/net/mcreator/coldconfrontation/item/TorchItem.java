
package net.mcreator.coldconfrontation.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.coldconfrontation.procedures.HandTorchProcedure;

import java.util.List;

public class TorchItem extends Item {
	public TorchItem() {
		super(new Item.Properties().durability(100).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("(Max Heat 60%)"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (entity instanceof LivingEntity) {
			LivingEntity livingEntity = (LivingEntity) entity;
			boolean isMainHand = livingEntity.getMainHandItem() == itemstack;
			boolean isOffHand = livingEntity.getOffhandItem() == itemstack;
			if (isMainHand || isOffHand) {
				HandTorchProcedure.execute(entity, itemstack);
			}
		}
	}
}
