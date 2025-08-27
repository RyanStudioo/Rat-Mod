package io.github.ryanstudioo;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.SilverfishEntityModel;

public class RatmodClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Register the model layer with silverfish model data
        EntityModelLayerRegistry.registerModelLayer(
                RatEntityModel.LAYER,
                SilverfishEntityModel::getTexturedModelData
        );

        // Register the entity renderer
        EntityRendererRegistry.register(ModEntities.RAT, EntityRenderer::new);

    }
}