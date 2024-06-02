
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.coldconfrontation.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.BlockItem;

import net.mcreator.coldconfrontation.item.SaskatoonBerryItem;
import net.mcreator.coldconfrontation.ColdconfrontationMod;

public class ColdconfrontationModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ColdconfrontationMod.MODID);
	public static final RegistryObject<Item> PERMAFROSTED_TUNDRA_GRASS = block(ColdconfrontationModBlocks.PERMAFROSTED_TUNDRA_GRASS);
	public static final RegistryObject<Item> PERMAFROSTED_SOIL = block(ColdconfrontationModBlocks.PERMAFROSTED_SOIL);
	public static final RegistryObject<Item> TUNDRA_SHORT_GRASS = block(ColdconfrontationModBlocks.TUNDRA_SHORT_GRASS);
	public static final RegistryObject<Item> TALL_TUNDRA_GRASS = doubleBlock(ColdconfrontationModBlocks.TALL_TUNDRA_GRASS);
	public static final RegistryObject<Item> ARCTIC_WILLOW = block(ColdconfrontationModBlocks.ARCTIC_WILLOW);
	public static final RegistryObject<Item> SASKATOON_BERRY = REGISTRY.register("saskatoon_berry", () -> new SaskatoonBerryItem());
	public static final RegistryObject<Item> PINE_LEAVES = block(ColdconfrontationModBlocks.PINE_LEAVES);
	public static final RegistryObject<Item> PINE_SAPLING = block(ColdconfrontationModBlocks.PINE_SAPLING);
	public static final RegistryObject<Item> PINE_LOG = block(ColdconfrontationModBlocks.PINE_LOG);
	public static final RegistryObject<Item> PINE_WOOD = block(ColdconfrontationModBlocks.PINE_WOOD);
	public static final RegistryObject<Item> STRIPPED_PINE_LOG = block(ColdconfrontationModBlocks.STRIPPED_PINE_LOG);
	public static final RegistryObject<Item> STRIPPED_PINE_WOOD = block(ColdconfrontationModBlocks.STRIPPED_PINE_WOOD);
	public static final RegistryObject<Item> PINE_PLANKS = block(ColdconfrontationModBlocks.PINE_PLANKS);
	public static final RegistryObject<Item> PINE_STAIRS = block(ColdconfrontationModBlocks.PINE_STAIRS);
	public static final RegistryObject<Item> PINE_SLAB = block(ColdconfrontationModBlocks.PINE_SLAB);
	public static final RegistryObject<Item> PINE_FENCE = block(ColdconfrontationModBlocks.PINE_FENCE);
	public static final RegistryObject<Item> PINE_FENCE_GATE = block(ColdconfrontationModBlocks.PINE_FENCE_GATE);
	public static final RegistryObject<Item> PINE_DOOR = doubleBlock(ColdconfrontationModBlocks.PINE_DOOR);
	public static final RegistryObject<Item> PINE_TRAPDOOR = block(ColdconfrontationModBlocks.PINE_TRAPDOOR);
	public static final RegistryObject<Item> PINE_PRESSURE_PLATE = block(ColdconfrontationModBlocks.PINE_PRESSURE_PLATE);
	public static final RegistryObject<Item> PINE_BUTTON = block(ColdconfrontationModBlocks.PINE_BUTTON);
	public static final RegistryObject<Item> SPRUCE_PALISADES = block(ColdconfrontationModBlocks.SPRUCE_PALISADES);
	public static final RegistryObject<Item> SPRUCE_PALISADE_BLOCK = block(ColdconfrontationModBlocks.SPRUCE_PALISADE_BLOCK);
	public static final RegistryObject<Item> SPRUCE_PALISADE_ROOF_STAIRS = block(ColdconfrontationModBlocks.SPRUCE_PALISADE_ROOF_STAIRS);
	public static final RegistryObject<Item> SPRUCE_PALISADE_ROOF_SLAB = block(ColdconfrontationModBlocks.SPRUCE_PALISADE_ROOF_SLAB);
	public static final RegistryObject<Item> PINE_PALISADES = block(ColdconfrontationModBlocks.PINE_PALISADES);
	public static final RegistryObject<Item> PINE_PALISADE_BLOCK = block(ColdconfrontationModBlocks.PINE_PALISADE_BLOCK);
	public static final RegistryObject<Item> PINE_PALISADE_ROOF_STAIRS = block(ColdconfrontationModBlocks.PINE_PALISADE_ROOF_STAIRS);
	public static final RegistryObject<Item> PINE_PALISADE_ROOF_SLAB = block(ColdconfrontationModBlocks.PINE_PALISADE_ROOF_SLAB);
	public static final RegistryObject<Item> WINTERWOOD_WOOD = block(ColdconfrontationModBlocks.WINTERWOOD_WOOD);
	public static final RegistryObject<Item> WINTERWOOD_LOG = block(ColdconfrontationModBlocks.WINTERWOOD_LOG);
	public static final RegistryObject<Item> WINTERWOOD_PLANKS = block(ColdconfrontationModBlocks.WINTERWOOD_PLANKS);
	public static final RegistryObject<Item> WINTERWOOD_LEAVES = block(ColdconfrontationModBlocks.WINTERWOOD_LEAVES);
	public static final RegistryObject<Item> WINTERWOOD_STAIRS = block(ColdconfrontationModBlocks.WINTERWOOD_STAIRS);
	public static final RegistryObject<Item> WINTERWOOD_SLAB = block(ColdconfrontationModBlocks.WINTERWOOD_SLAB);
	public static final RegistryObject<Item> WINTERWOOD_FENCE = block(ColdconfrontationModBlocks.WINTERWOOD_FENCE);
	public static final RegistryObject<Item> WINTERWOOD_FENCE_GATE = block(ColdconfrontationModBlocks.WINTERWOOD_FENCE_GATE);
	public static final RegistryObject<Item> WINTERWOOD_PRESSURE_PLATE = block(ColdconfrontationModBlocks.WINTERWOOD_PRESSURE_PLATE);
	public static final RegistryObject<Item> WINTERWOOD_BUTTON = block(ColdconfrontationModBlocks.WINTERWOOD_BUTTON);
	public static final RegistryObject<Item> STRIPPED_WINTERWOOD_LOG = block(ColdconfrontationModBlocks.STRIPPED_WINTERWOOD_LOG);
	public static final RegistryObject<Item> WINTERWOOD_DOOR = doubleBlock(ColdconfrontationModBlocks.WINTERWOOD_DOOR);
	public static final RegistryObject<Item> WINTERWOOD_TRAPDOOR = block(ColdconfrontationModBlocks.WINTERWOOD_TRAPDOOR);
	public static final RegistryObject<Item> WINTERWOOD_SAPPLING = block(ColdconfrontationModBlocks.WINTERWOOD_SAPPLING);
	public static final RegistryObject<Item> SASKATOON_BERRY_BUSH = block(ColdconfrontationModBlocks.SASKATOON_BERRY_BUSH);

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
	}
}
