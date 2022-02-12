package net.ducorits.poepcraft;

import net.ducorits.poepcraft.block.ModBlocks;
import net.ducorits.poepcraft.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PoepCraft implements ModInitializer {
    public static final String MOD_ID = "poepcraft";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
//        public static BlockEntityType<HoopKakEntity> DEMO_BLOCK_ENTITY;
//
//        @Override
//        public void onInitialize() {
//            DEMO_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "tutorial:demo_block_entity", FabricBlockEntityTypeBuilder.create(HoopKak::new, HoopKak).build(null));
//        }

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
    }
}
