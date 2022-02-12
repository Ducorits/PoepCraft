package net.ducorits.poepcraft;

import net.ducorits.poepcraft.block.ModBlocks;
import net.ducorits.poepcraft.fluids.Diarree;
import net.ducorits.poepcraft.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PoepCraft implements ModInitializer {
    public static final String MOD_ID = "poepcraft";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static Block DIARREE;
    public static FlowableFluid STILL_DIARREE;
    public static FlowableFluid FLOWING_DIARREE;
    public static Item DIARREE_BUCKET;


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
        DIARREE = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "diarree"), new FluidBlock(STILL_DIARREE, FabricBlockSettings.copy(Blocks.WATER)){});
        STILL_DIARREE = Registry.register(Registry.FLUID, new Identifier(MOD_ID, "diarree"), new Diarree.Still());
        FLOWING_DIARREE = Registry.register(Registry.FLUID, new Identifier(MOD_ID, "flowing_diarree"), new Diarree.Flowing());
        DIARREE_BUCKET = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "diarree_bucket"),
                new BucketItem(STILL_DIARREE, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
    }
}
