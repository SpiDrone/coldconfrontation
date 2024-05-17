
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.coldconfrontation.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.coldconfrontation.block.StrippedPineWoodBlock;
import net.mcreator.coldconfrontation.block.StrippedPineLogBlock;
import net.mcreator.coldconfrontation.block.PineWoodBlock;
import net.mcreator.coldconfrontation.block.PineTrapdoorBlock;
import net.mcreator.coldconfrontation.block.PineStairsBlock;
import net.mcreator.coldconfrontation.block.PineSlabBlock;
import net.mcreator.coldconfrontation.block.PineSaplingBlock;
import net.mcreator.coldconfrontation.block.PinePressurePlateBlock;
import net.mcreator.coldconfrontation.block.PinePlanksBlock;
import net.mcreator.coldconfrontation.block.PineLogBlock;
import net.mcreator.coldconfrontation.block.PineLeavesBlock;
import net.mcreator.coldconfrontation.block.PineFenceGateBlock;
import net.mcreator.coldconfrontation.block.PineFenceBlock;
import net.mcreator.coldconfrontation.block.PineDoorBlock;
import net.mcreator.coldconfrontation.block.PineButtonBlock;
import net.mcreator.coldconfrontation.ColdconfrontationMod;

public class ColdconfrontationModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ColdconfrontationMod.MODID);
	public static final RegistryObject<Block> PINE_LOG = REGISTRY.register("pine_log", () -> new PineLogBlock());
	public static final RegistryObject<Block> PINE_WOOD = REGISTRY.register("pine_wood", () -> new PineWoodBlock());
	public static final RegistryObject<Block> STRIPPED_PINE_LOG = REGISTRY.register("stripped_pine_log", () -> new StrippedPineLogBlock());
	public static final RegistryObject<Block> STRIPPED_PINE_WOOD = REGISTRY.register("stripped_pine_wood", () -> new StrippedPineWoodBlock());
	public static final RegistryObject<Block> PINE_PLANKS = REGISTRY.register("pine_planks", () -> new PinePlanksBlock());
	public static final RegistryObject<Block> PINE_STAIRS = REGISTRY.register("pine_stairs", () -> new PineStairsBlock());
	public static final RegistryObject<Block> PINE_SLAB = REGISTRY.register("pine_slab", () -> new PineSlabBlock());
	public static final RegistryObject<Block> PINE_FENCE = REGISTRY.register("pine_fence", () -> new PineFenceBlock());
	public static final RegistryObject<Block> PINE_FENCE_GATE = REGISTRY.register("pine_fence_gate", () -> new PineFenceGateBlock());
	public static final RegistryObject<Block> PINE_DOOR = REGISTRY.register("pine_door", () -> new PineDoorBlock());
	public static final RegistryObject<Block> PINE_TRAPDOOR = REGISTRY.register("pine_trapdoor", () -> new PineTrapdoorBlock());
	public static final RegistryObject<Block> PINE_PRESSURE_PLATE = REGISTRY.register("pine_pressure_plate", () -> new PinePressurePlateBlock());
	public static final RegistryObject<Block> PINE_BUTTON = REGISTRY.register("pine_button", () -> new PineButtonBlock());
	public static final RegistryObject<Block> PINE_LEAVES = REGISTRY.register("pine_leaves", () -> new PineLeavesBlock());
	public static final RegistryObject<Block> PINE_SAPLING = REGISTRY.register("pine_sapling", () -> new PineSaplingBlock());
}