
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.coldconfrontation.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.coldconfrontation.ColdconfrontationMod;

public class ColdconfrontationModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ColdconfrontationMod.MODID);
	public static final RegistryObject<CreativeModeTab> TAB_COLD_CONFRONTATION = REGISTRY.register("tab_cold_confrontation",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.coldconfrontation.tab_cold_confrontation")).icon(() -> new ItemStack(ColdconfrontationModBlocks.PINE_SAPLING.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ColdconfrontationModBlocks.PERMAFROSTED_TUNDRA_GRASS.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.PERMAFROSTED_SOIL.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.TUNDRA_SHORT_GRASS.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.PINE_LEAVES.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.PINE_SAPLING.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.PINE_LOG.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.PINE_WOOD.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.STRIPPED_PINE_LOG.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.STRIPPED_PINE_WOOD.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.PINE_PLANKS.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.PINE_STAIRS.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.PINE_SLAB.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.PINE_FENCE.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.PINE_FENCE_GATE.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.PINE_DOOR.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.PINE_TRAPDOOR.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.PINE_PRESSURE_PLATE.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.PINE_BUTTON.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.SPRUCE_PALISADES.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.SPRUCE_PALISADE_BLOCK.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.SPRUCE_PALISADE_ROOF_STAIRS.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.SPRUCE_PALISADE_ROOF_SLAB.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.PINE_PALISADES.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.PINE_PALISADE_BLOCK.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.PINE_PALISADE_ROOF_STAIRS.get().asItem());
				tabData.accept(ColdconfrontationModBlocks.PINE_PALISADE_ROOF_SLAB.get().asItem());
			})

					.build());
}
