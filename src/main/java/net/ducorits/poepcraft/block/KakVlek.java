package net.ducorits.poepcraft.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class KakVlek extends Block {
    public KakVlek(Settings settings) {
        super(settings);
    }

    public static final String NAME = "kak_vlek";

    public static KakVlek init() {
        FabricBlockSettings set = FabricBlockSettings.of(Material.SOIL)
                .collidable(true)
                .breakByHand(true)
                .strength(0.5f)
                .nonOpaque()
                .slipperiness(3.0f);

        return new KakVlek(set);
    }



    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            player.sendMessage(new LiteralText("UH, OH.. Glijd niet uit!"), false);
        }

        return ActionResult.SUCCESS;
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1f, 0.1f, 1f);
    }
}
