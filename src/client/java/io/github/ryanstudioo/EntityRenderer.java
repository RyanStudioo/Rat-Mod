package io.github.ryanstudioo;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;


@Environment(EnvType.CLIENT)
public class EntityRenderer extends MobEntityRenderer<io.github.ryanstudioo.entity.RatEntity,LivingEntityRenderState, RatEntityModel> {


    private static final Identifier TEXTURE = Identifier.of("ratmod", "textures/entity/rat.png");

    public EntityRenderer(EntityRendererFactory.Context context) {
        super(context, new RatEntityModel(context.getPart(RatEntityModel.LAYER)), 0.3f);
    }

    @Override
    public Identifier getTexture(LivingEntityRenderState state) {
        return TEXTURE; // Return actual texture, not null
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState(); // Return actual state, not null
    }
}

