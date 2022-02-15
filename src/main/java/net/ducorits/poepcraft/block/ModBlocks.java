package net.ducorits.poepcraft.block;

import net.ducorits.poepcraft.PoepCraft;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block KAK = new Block(FabricBlockSettings.of(Material.SOIL, MapColor.DIRT_BROWN).strength(1F));
    public static final HoopKak HOOP_KAK = new HoopKak(FabricBlockSettings.of(Material.SOIL, MapColor.DIRT_BROWN).strength(1F));
//    public static final Block KAK_VLEK = new KakVlek(FabricBlockSettings.of(Material.SOIL, MapColor.DIRT_BROWN).strength(1F));
            //public static final Block STONE = Blocks.register("stone", new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.STONE_GRAY).requiresTool().strength(1.5f, 6.0f)));


    public static final Block KAK_VLEK = KakVlek.init();
    public static final WcRolGordijn WC_ROL_GORDIJN = WcRolGordijn.init();


    public static void registerModBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(PoepCraft.MOD_ID, "kak"), KAK);
        Registry.register(Registry.BLOCK, new Identifier(PoepCraft.MOD_ID, "hoop_kak"), HOOP_KAK);
        Registry.register(Registry.BLOCK, new Identifier(PoepCraft.MOD_ID, KakVlek.NAME), KAK_VLEK);
        Registry.register(Registry.BLOCK, new Identifier(PoepCraft.MOD_ID, WcRolGordijn.NAME), WC_ROL_GORDIJN);

        PoepCraft.LOGGER.info("Registering Mod Blocks for " + PoepCraft.MOD_ID);
    }
}
