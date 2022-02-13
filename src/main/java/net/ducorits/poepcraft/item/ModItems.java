package net.ducorits.poepcraft.item;

import net.ducorits.poepcraft.PoepCraft;
import net.ducorits.poepcraft.block.WcRolGordijn;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import static net.ducorits.poepcraft.block.ModBlocks.*;

public class ModItems {
    public static final Item BIG_BERTHA = registerItem("big_bertha", new SwordItem(ToolMaterials.DIAMOND, 6, 2,
            new FabricItemSettings().group(ItemGroup.COMBAT).rarity(Rarity.EPIC)));
    public static final Item CRYSTAL_STAFF = registerItem("crystal_staff", new Item(new FabricItemSettings().group(ItemGroup.COMBAT).maxDamage(10).rarity(Rarity.EPIC)));




    //Items.register("diamond_sword", (Item)new SwordItem(ToolMaterials.DIAMOND, 3, -2.4f, new Item.Settings().group(ItemGroup.COMBAT)))
    //SwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Item.Settings settings)


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(PoepCraft.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PoepCraft.LOGGER.info("Registering Mod Items for " + PoepCraft.MOD_ID);
        Registry.register(Registry.ITEM, new Identifier("poepcraft", "kak"), new BlockItem(KAK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier("poepcraft", "hoop_kak"), new BlockItem(HOOP_KAK, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier("poepcraft", WcRolGordijn.NAME), new BlockItem(WC_ROL_GORDIJN,
                new FabricItemSettings().group(ItemGroup.MISC)));

    }

}
