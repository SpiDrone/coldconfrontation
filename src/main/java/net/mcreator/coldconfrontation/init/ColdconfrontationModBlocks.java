
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.coldconfrontation.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.coldconfrontation.block.WinterwoodWoodBlock;
import net.mcreator.coldconfrontation.block.WinterwoodTrapdoorBlock;
import net.mcreator.coldconfrontation.block.WinterwoodStairsBlock;
import net.mcreator.coldconfrontation.block.WinterwoodSlabBlock;
import net.mcreator.coldconfrontation.block.WinterwoodSapplingBlock;
import net.mcreator.coldconfrontation.block.WinterwoodPressurePlateBlock;
import net.mcreator.coldconfrontation.block.WinterwoodPlanksBlock;
import net.mcreator.coldconfrontation.block.WinterwoodLogBlock;
import net.mcreator.coldconfrontation.block.WinterwoodLeavesBlock;
import net.mcreator.coldconfrontation.block.WinterwoodFenceGateBlock;
import net.mcreator.coldconfrontation.block.WinterwoodFenceBlock;
import net.mcreator.coldconfrontation.block.WinterwoodDoorBlock;
import net.mcreator.coldconfrontation.block.WinterwoodButtonBlock;
import net.mcreator.coldconfrontation.block.TundraShortGrassBlock;
import net.mcreator.coldconfrontation.block.TallTundraGrassBlock;
import net.mcreator.coldconfrontation.block.StrippedWinterwoodLogBlock;
import net.mcreator.coldconfrontation.block.StrippedPineWoodBlock;
import net.mcreator.coldconfrontation.block.StrippedPineLogBlock;
import net.mcreator.coldconfrontation.block.SprucePalisadesBlock;
import net.mcreator.coldconfrontation.block.SprucePalisadeRoofStairsBlock;
import net.mcreator.coldconfrontation.block.SprucePalisadeRoofSlabBlock;
import net.mcreator.coldconfrontation.block.SprucePalisadeBlockBlock;
import net.mcreator.coldconfrontation.block.SaskatoonBerryBushBlock;
import net.mcreator.coldconfrontation.block.PineWoodBlock;
import net.mcreator.coldconfrontation.block.PineTrapdoorBlock;
import net.mcreator.coldconfrontation.block.PineStairsBlock;
import net.mcreator.coldconfrontation.block.PineSlabBlock;
import net.mcreator.coldconfrontation.block.PineSaplingBlock;
import net.mcreator.coldconfrontation.block.PinePressurePlateBlock;
import net.mcreator.coldconfrontation.block.PinePlanksBlock;
import net.mcreator.coldconfrontation.block.PinePalisadesBlock;
import net.mcreator.coldconfrontation.block.PinePalisadeRoofStairsBlock;
import net.mcreator.coldconfrontation.block.PinePalisadeRoofSlabBlock;
import net.mcreator.coldconfrontation.block.PinePalisadeBlockBlock;
import net.mcreator.coldconfrontation.block.PineLogBlock;
import net.mcreator.coldconfrontation.block.PineLeavesBlock;
import net.mcreator.coldconfrontation.block.PineFenceGateBlock;
import net.mcreator.coldconfrontation.block.PineFenceBlock;
import net.mcreator.coldconfrontation.block.PineDoorBlock;
import net.mcreator.coldconfrontation.block.PineButtonBlock;
import net.mcreator.coldconfrontation.block.PermafrostedTundraGrassBlock;
import net.mcreator.coldconfrontation.block.PermafrostedSoilBlock;
import net.mcreator.coldconfrontation.block.ArcticWillowBlock;
import net.mcreator.coldconfrontation.ColdconfrontationMod;

public class ColdconfrontationModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ColdconfrontationMod.MODID);
	public static final RegistryObject<Block> PERMAFROSTED_TUNDRA_GRASS = REGISTRY.register("permafrosted_tundra_grass", () -> new PermafrostedTundraGrassBlock());
	public static final RegistryObject<Block> PERMAFROSTED_SOIL = REGISTRY.register("permafrosted_soil", () -> new PermafrostedSoilBlock());
	public static final RegistryObject<Block> TUNDRA_SHORT_GRASS = REGISTRY.register("tundra_short_grass", () -> new TundraShortGrassBlock());
	public static final RegistryObject<Block> TALL_TUNDRA_GRASS = REGISTRY.register("tall_tundra_grass", () -> new TallTundraGrassBlock());
	public static final RegistryObject<Block> ARCTIC_WILLOW = REGISTRY.register("arctic_willow", () -> new ArcticWillowBlock());
	public static final RegistryObject<Block> PINE_LEAVES = REGISTRY.register("pine_leaves", () -> new PineLeavesBlock());
	public static final RegistryObject<Block> PINE_SAPLING = REGISTRY.register("pine_sapling", () -> new PineSaplingBlock());
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
	public static final RegistryObject<Block> SPRUCE_PALISADES = REGISTRY.register("spruce_palisades", () -> new SprucePalisadesBlock());
	public static final RegistryObject<Block> SPRUCE_PALISADE_BLOCK = REGISTRY.register("spruce_palisade_block", () -> new SprucePalisadeBlockBlock());
	public static final RegistryObject<Block> SPRUCE_PALISADE_ROOF_STAIRS = REGISTRY.register("spruce_palisade_roof_stairs", () -> new SprucePalisadeRoofStairsBlock());
	public static final RegistryObject<Block> SPRUCE_PALISADE_ROOF_SLAB = REGISTRY.register("spruce_palisade_roof_slab", () -> new SprucePalisadeRoofSlabBlock());
	public static final RegistryObject<Block> PINE_PALISADES = REGISTRY.register("pine_palisades", () -> new PinePalisadesBlock());
	public static final RegistryObject<Block> PINE_PALISADE_BLOCK = REGISTRY.register("pine_palisade_block", () -> new PinePalisadeBlockBlock());
	public static final RegistryObject<Block> PINE_PALISADE_ROOF_STAIRS = REGISTRY.register("pine_palisade_roof_stairs", () -> new PinePalisadeRoofStairsBlock());
	public static final RegistryObject<Block> PINE_PALISADE_ROOF_SLAB = REGISTRY.register("pine_palisade_roof_slab", () -> new PinePalisadeRoofSlabBlock());
	public static final RegistryObject<Block> WINTERWOOD_WOOD = REGISTRY.register("winterwood_wood", () -> new WinterwoodWoodBlock());
	public static final RegistryObject<Block> WINTERWOOD_LOG = REGISTRY.register("winterwood_log", () -> new WinterwoodLogBlock());
	public static final RegistryObject<Block> WINTERWOOD_PLANKS = REGISTRY.register("winterwood_planks", () -> new WinterwoodPlanksBlock());
	public static final RegistryObject<Block> WINTERWOOD_LEAVES = REGISTRY.register("winterwood_leaves", () -> new WinterwoodLeavesBlock());
	public static final RegistryObject<Block> WINTERWOOD_STAIRS = REGISTRY.register("winterwood_stairs", () -> new WinterwoodStairsBlock());
	public static final RegistryObject<Block> WINTERWOOD_SLAB = REGISTRY.register("winterwood_slab", () -> new WinterwoodSlabBlock());
	public static final RegistryObject<Block> WINTERWOOD_FENCE = REGISTRY.register("winterwood_fence", () -> new WinterwoodFenceBlock());
	public static final RegistryObject<Block> WINTERWOOD_FENCE_GATE = REGISTRY.register("winterwood_fence_gate", () -> new WinterwoodFenceGateBlock());
	public static final RegistryObject<Block> WINTERWOOD_PRESSURE_PLATE = REGISTRY.register("winterwood_pressure_plate", () -> new WinterwoodPressurePlateBlock());
	public static final RegistryObject<Block> WINTERWOOD_BUTTON = REGISTRY.register("winterwood_button", () -> new WinterwoodButtonBlock());
	public static final RegistryObject<Block> STRIPPED_WINTERWOOD_LOG = REGISTRY.register("stripped_winterwood_log", () -> new StrippedWinterwoodLogBlock());
	public static final RegistryObject<Block> WINTERWOOD_DOOR = REGISTRY.register("winterwood_door", () -> new WinterwoodDoorBlock());
	public static final RegistryObject<Block> WINTERWOOD_TRAPDOOR = REGISTRY.register("winterwood_trapdoor", () -> new WinterwoodTrapdoorBlock());
	public static final RegistryObject<Block> WINTERWOOD_SAPPLING = REGISTRY.register("winterwood_sappling", () -> new WinterwoodSapplingBlock());
	public static final RegistryObject<Block> SASKATOON_BERRY_BUSH = REGISTRY.register("saskatoon_berry_bush", () -> new SaskatoonBerryBushBlock());
}
