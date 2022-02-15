package net.ducorits.poepcraft;

import net.ducorits.poepcraft.block.KakVlek;
import net.ducorits.poepcraft.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;

public class PoepCraftClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {

        FluidRenderHandlerRegistry.INSTANCE.register(PoepCraft.DIARREE_STIL, PoepCraft.DIARREE_FLOW, new SimpleFluidRenderHandler(new Identifier("poepcraft:block/diarree_stil"), new Identifier("poepcraft:block/diarree_flow")));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getSolid(), PoepCraft.DIARREE_STIL, PoepCraft.DIARREE_FLOW);
        //if you want to use custom textures they needs to be registered.
        //In this example this is unnecessary because the vanilla water textures are already registered.
        //To register your custom textures use this method.
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier("poepcraft:block/diarree_stil"));
            registry.register(new Identifier("poepcraft:block/diarree_flow"));
        });
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KAK_VLEK, RenderLayer.getTranslucent());

        // ...
    }
}
