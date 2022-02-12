package net.ducorits.poepcraft.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class WcRolGordijn extends Block {

    public static final String NAME = "wcrolgordijn";

    public WcRolGordijn(Settings settings) {
        super(settings);
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

}
