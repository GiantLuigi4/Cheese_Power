package com.mozz.cheesepower.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class CauldronPot extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(10.29752575615902, 5.523102475988704, 7, 11.39752575615902, 19.523102475988704, 8),
            Block.makeCuboidShape(9, 5, 6, 10, 6, 7.5),
            Block.makeCuboidShape(6, 5, 5, 9, 6, 6),
            Block.makeCuboidShape(5, 5, 6, 6, 6, 9),
            Block.makeCuboidShape(6, 5, 9, 9, 6, 10),
            Block.makeCuboidShape(9, 5, 7.5, 10, 6, 9),
            Block.makeCuboidShape(6, 4, 6, 9, 5, 9),
            Block.makeCuboidShape(14, 0, 12, 16, 3, 14),
            Block.makeCuboidShape(12, 0, 14, 16, 3, 16),
            Block.makeCuboidShape(0, 0, 12, 2, 3, 14),
            Block.makeCuboidShape(0, 0, 14, 4, 3, 16),
            Block.makeCuboidShape(14, 0, 2, 16, 3, 4),
            Block.makeCuboidShape(12, 0, 0, 16, 3, 2),
            Block.makeCuboidShape(0, 0, 2, 2, 3, 4),
            Block.makeCuboidShape(0, 0, 0, 4, 3, 2),
            Block.makeCuboidShape(2, 3, 14, 14, 16, 16),
            Block.makeCuboidShape(2, 3, 0, 14, 16, 2),
            Block.makeCuboidShape(14, 3, 0, 16, 16, 16),
            Block.makeCuboidShape(2, 3, 2, 14, 4, 14),
            Block.makeCuboidShape(0, 3, 0, 2, 16, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public CauldronPot(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Deprecated
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Deprecated
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Deprecated
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }


}
