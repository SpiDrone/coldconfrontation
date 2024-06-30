
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.coldconfrontation.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.coldconfrontation.world.inventory.EmptyGuiMenu;
import net.mcreator.coldconfrontation.ColdconfrontationMod;

public class ColdconfrontationModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ColdconfrontationMod.MODID);
	public static final RegistryObject<MenuType<EmptyGuiMenu>> EMPTY_GUI = REGISTRY.register("empty_gui", () -> IForgeMenuType.create(EmptyGuiMenu::new));
}
