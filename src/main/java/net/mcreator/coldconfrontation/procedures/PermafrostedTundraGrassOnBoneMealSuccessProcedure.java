package net.mcreator.coldconfrontation.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.coldconfrontation.init.ColdconfrontationModBlocks;

public class PermafrostedTundraGrassOnBoneMealSuccessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double RandomX = 0;
		double RandomZ = 0;
		RandomX = x + Mth.nextInt(RandomSource.create(), -3, 3);
		RandomZ = z + Mth.nextInt(RandomSource.create(), -3, 3);
		for (int index0 = 0; index0 < 6; index0++) {
			if ((world.getBlockState(BlockPos.containing(RandomX - 1, y - 1, RandomZ - 1))).getBlock() == ColdconfrontationModBlocks.PERMAFROSTED_TUNDRA_GRASS.get()
					&& (world.getBlockState(BlockPos.containing(RandomX, y, RandomZ))).getBlock() == Blocks.AIR) {
				world.setBlock(BlockPos.containing(RandomX, y, RandomZ),
						(ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("coldconfrontation:decaying_tundra_plants"))).getRandomElement(RandomSource.create()).orElseGet(() -> Blocks.AIR)).defaultBlockState(), 3);
			}
		}
	}
}
