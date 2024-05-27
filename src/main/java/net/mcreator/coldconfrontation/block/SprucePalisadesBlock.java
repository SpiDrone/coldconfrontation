
package net.mcreator.coldconfrontation.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.coldconfrontation.procedures.ProcPalisadesUpdateNeighborProcedure;

import java.util.List;
import java.util.Collections;

public class SprucePalisadesBlock extends Block {
	private static final BooleanProperty NORTH = BlockStateProperties.NORTH;
	private static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
	private static final BooleanProperty EAST = BlockStateProperties.EAST;
	private static final BooleanProperty WEST = BlockStateProperties.WEST;

	public SprucePalisadesBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(4f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(stateDefinition.any().setValue(NORTH, false).setValue(SOUTH, false).setValue(EAST, false).setValue(WEST, false));
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(NORTH, SOUTH, EAST, WEST);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, BlockGetter world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		int tn = 0;
		int ts = 0;
		int te = 0;
		int tw = 0;
		if (state.getValue(NORTH))
			tn = 1;
		if (state.getValue(SOUTH))
			ts = 1;
		if (state.getValue(EAST))
			te = 1;
		if (state.getValue(WEST))
			tw = 1;
		return Shapes.or(box(4, 0, 4, 12, 16, 12), box(4 * tn, 0 * tn, 0 * tn, 12 * tn, 16 * tn, 4 * tn), box(4 * ts, 0 * ts, 12 * ts, 12 * ts, 16 * ts, 16 * ts), box(12 * te, 0 * te, 4 * te, 16 * te, 16 * te, 12 * te),
				box(0 * tw, 0 * tw, 4 * tw, 4 * tw, 16 * tw, 12 * tw));
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 8;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 4;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		ProcPalisadesUpdateNeighborProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		ProcPalisadesUpdateNeighborProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
