
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.coldconfrontation.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.coldconfrontation.potion.WetMobEffect;
import net.mcreator.coldconfrontation.potion.WarmMobEffect;
import net.mcreator.coldconfrontation.ColdconfrontationMod;

public class ColdconfrontationModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ColdconfrontationMod.MODID);
	public static final RegistryObject<MobEffect> WARM = REGISTRY.register("warm", () -> new WarmMobEffect());
	public static final RegistryObject<MobEffect> WET = REGISTRY.register("wet", () -> new WetMobEffect());
}
