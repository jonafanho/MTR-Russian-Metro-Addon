package ru.weryskok.mtrrumetro.mod.blocks;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.DirectionHelper;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.Blocks;
import org.mtr.mod.block.IBlock;

import javax.annotation.Nonnull;
import java.util.List;

public class BlockMoscowOldTicketBarrierSideCover extends BlockExtension implements DirectionHelper {

	public BlockMoscowOldTicketBarrierSideCover() {
		super(Blocks.createDefaultBlockSettings(true, state -> 5).nonOpaque());
	}

	@Override
	public BlockState getPlacementState2(ItemPlacementContext ctx) {
		return getDefaultState2().with(new Property<>(FACING.data), ctx.getPlayerFacing().data);
	}

	@Nonnull
	@Override
	public VoxelShape getOutlineShape2(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		final Direction facing = IBlock.getStatePropertySafe(state, FACING);
		return IBlock.getVoxelShapeByDirection(10.9, 0.0, -2.0, 16.0, 24.1, 19.5, facing);
	}

	@Nonnull
	@Override
	public VoxelShape getCollisionShape2(BlockState state, BlockView world, BlockPos blockPos, ShapeContext context) {
		final Direction facing = IBlock.getStatePropertySafe(state, FACING);
		return IBlock.getVoxelShapeByDirection(10.9, 0.0, -2.0, 16.0, 24.1, 19.5, facing);
	}

	@Override
	public void addBlockProperties(List<HolderBase<?>> builder) {
		builder.add(FACING);
	}
}
