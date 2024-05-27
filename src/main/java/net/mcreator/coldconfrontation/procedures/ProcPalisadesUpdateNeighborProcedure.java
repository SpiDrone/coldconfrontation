package net.mcreator.coldconfrontation.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class ProcPalisadesUpdateNeighborProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (Direction directioniterator : Direction.Plane.HORIZONTAL) {
			if ((world.getBlockState(BlockPos.containing(x + directioniterator.getStepX(), y, z + directioniterator.getStepZ()))).getBlock() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()
					|| world.getBlockState(BlockPos.containing(x + directioniterator.getStepX(), y, z + directioniterator.getStepZ())).isFaceSturdy(world, BlockPos.containing(x + directioniterator.getStepX(), y, z + directioniterator.getStepZ()),
							(directioniterator.getOpposite()))) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty(("" + directioniterator)) instanceof BooleanProperty _booleanProp)
						world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
				}
			} else {
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty(("" + directioniterator)) instanceof BooleanProperty _booleanProp)
						world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
				}
			}
		}
	}
}
