package net.mcreator.coldconfrontation.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class WinterwoodLeavesBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? (world.getBlockState(BlockPos.containing(x, y - 1, z))).getValue(_getip1) : -1) == 0
				|| ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3
						? (world.getBlockState(BlockPos.containing(x, y + 1, z))).getValue(_getip3)
						: -1) == 0
				|| ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip5
						? (world.getBlockState(BlockPos.containing(x + 1, y, z))).getValue(_getip5)
						: -1) == 0
				|| ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip7
						? (world.getBlockState(BlockPos.containing(x - 1, y, z))).getValue(_getip7)
						: -1) == 0
				|| ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip9
						? (world.getBlockState(BlockPos.containing(x, y, z + 1))).getValue(_getip9)
						: -1) == 0
				|| ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip11
						? (world.getBlockState(BlockPos.containing(x, y, z - 1))).getValue(_getip11)
						: -1) == 0) {
			{
				int _value = 1;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		}
	}
}
