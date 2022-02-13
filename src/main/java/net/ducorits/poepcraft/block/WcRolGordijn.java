package net.ducorits.poepcraft.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class WcRolGordijn extends HorizontalFacingBlock {

    public static final String NAME = "wc_rol_gordijn";

    public WcRolGordijn(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    // TODO Find a better way to accomplish this
    public static WcRolGordijn init() {
        FabricBlockSettings set = FabricBlockSettings.of(Material.STONE)
                .collidable(false)
                .breakByHand(true)
                .strength(0.5f)
                .noCollision();

        return new WcRolGordijn(set);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        switch(dir) {
            case NORTH:
                return VoxelShapes.cuboid(0.0f, 0.0f, 0.8f, 1.0f, 1.0f, 1.0f);
            case SOUTH:
                return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.2f);
            case EAST:
                return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 0.2f, 1.0f, 1.0f);
            case WEST:
                return VoxelShapes.cuboid(0.8f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            default:
                return VoxelShapes.fullCube();
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }

}
