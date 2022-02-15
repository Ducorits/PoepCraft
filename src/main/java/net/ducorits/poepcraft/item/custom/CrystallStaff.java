package net.ducorits.poepcraft.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.*;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class CrystallStaff extends Item {
    public CrystallStaff(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        Vec3d vec3d = user.getRotationVec(1.0f);
        double f = user.getX() - (user.getX() - vec3d.x * 4.0);
//        double g = user.getBodyY(0.5) - (0.5 +
        double g = user.getY() - (user.getY() - vec3d.y * 4.0);
        double h = user.getZ() - (user.getZ() - vec3d.z * 4.0);
        FireballEntity fireballEntity = new FireballEntity(world, user, f, g, h, 1);
        fireballEntity.setPosition(user.getX() + vec3d.x * 2.0, user.getBodyY(.9) + vec3d.y * 2.0, fireballEntity.getZ() + vec3d.z * 2.0);
        world.spawnEntity(fireballEntity);
        if (!world.isClient) {
            user.sendMessage(new LiteralText("Vec: " + f + " " + g + " " + h), false);
        }
        return TypedActionResult.success(itemStack, true);
    }
}
