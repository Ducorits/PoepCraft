package net.ducorits.poepcraft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class PoepCraftClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        FluidRenderHandlerRegistry.INSTANCE.register(PoepCraft.STILL_DIARREE, PoepCraft.FLOWING_DIARREE, new SimpleFluidRenderHandler(
                new Identifier("minecraft:block/water_still"),
                new Identifier("minecraft:block/water_flow"),
                0x4CC248
        ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), PoepCraft.STILL_DIARREE, PoepCraft.FLOWING_DIARREE);

        //if you want to use custom textures they needs to be registered.
        //In this example this is unnecessary because the vanilla water textures are already registered.
        //To register your custom textures use this method.
        //ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
        //    registry.register(new Identifier("modid:block/custom_fluid_still"));
        //    registry.register(new Identifier("modid:block/custom_fluid_flowing"));
        //});

        // ...
    }
}
