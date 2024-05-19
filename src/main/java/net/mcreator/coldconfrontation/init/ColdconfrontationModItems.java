
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

import net.mcreator.coldconfrontation.ColdconfrontationMod;

public class ColdconfrontationModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ColdconfrontationMod.MODID);
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
	public static final RegistryObject<Item> PINE_LEAVES = block(ColdconfrontationModBlocks.PINE_LEAVES);
	public static final RegistryObject<Item> PINE_SAPLING = block(ColdconfrontationModBlocks.PINE_SAPLING);
	public static final RegistryObject<Item> PERMAFROSTED_SOIL = block(ColdconfrontationModBlocks.PERMAFROSTED_SOIL);
	public static final RegistryObject<Item> PERMAFROSTED_TUNDRA_GRASS = block(ColdconfrontationModBlocks.PERMAFROSTED_TUNDRA_GRASS);
	public static final RegistryObject<Item> TUNDRA_SHORT_GRASS = block(ColdconfrontationModBlocks.TUNDRA_SHORT_GRASS);

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
	}
}
