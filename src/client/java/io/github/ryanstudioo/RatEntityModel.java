package io.github.ryanstudioo;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SilverfishEntityModel;
import net.minecraft.util.Identifier;

public class RatEntityModel extends SilverfishEntityModel {
    public static final EntityModelLayer LAYER = new EntityModelLayer(Identifier.of("ratmod", "rat"), "main");

    public RatEntityModel(ModelPart modelPart) {
        super(modelPart);
    }

    public static EntityModelLayer getLayer(String path) {
        return LAYER;
    }
}