package io.github.ryanstudioo;

import io.github.ryanstudioo.entity.RatEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;


@Environment(EnvType.CLIENT)
public class EntityRenderer extends MobEntityRenderer<io.github.ryanstudioo.entity.RatEntity, RatEntityModel> {


    private static final Identifier TEXTURE = Identifier.of("ratmod", "textures/entity/rat.png");

    public EntityRenderer(EntityRendererFactory.Context context) {
        super(context, new RatEntityModel(context.getPart(RatEntityModel.LAYER)), 0.3f);
    }

    @Override
    public Identifier getTexture(RatEntity entity) {
        return TEXTURE;
    }


}

