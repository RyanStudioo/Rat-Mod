package io.github.ryanstudioo;

import io.github.ryanstudioo.entity.RatEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SilverfishEntityModel;

import net.minecraft.util.Identifier;

public class RatEntityModel extends SilverfishEntityModel<RatEntity> {
    public static final EntityModelLayer LAYER = new EntityModelLayer(
            Identifier.of("ratmod", "rat"), "main"
    );

    public RatEntityModel(ModelPart root) {
        super(root);
    }
}