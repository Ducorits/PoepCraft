package net.ducorits.poepcraft.fluids;

import net.ducorits.poepcraft.PoepCraft;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;

public abstract class Diarree extends PoepCraftFluid {
    @Override
    public Fluid getStill() {
        return PoepCraft.STILL_DIARREE;
    }

    @Override
    public Fluid getFlowing() {
        return PoepCraft.FLOWING_DIARREE;
    }

    @Override
    public Item getBucketItem() {
        return PoepCraft.DIARREE_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        return PoepCraft.DIARREE.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
    }

    public static class Flowing extends Diarree {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }

    public static class Still extends Diarree {
        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }
}
