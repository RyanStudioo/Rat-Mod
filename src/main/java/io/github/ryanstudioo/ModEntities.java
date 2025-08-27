package io.github.ryanstudioo;

import io.github.ryanstudioo.entity.RatEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<RatEntity> RAT = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Ratmod.MOD_ID, "rat"),
            EntityType.Builder.create(RatEntity::new,  SpawnGroup.CREATURE).dimensions(0.2f, 0.2f).build(
                    RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of("ratmod", "rat"))));


    public static void registerEntities() {
        FabricDefaultAttributeRegistry.register(ModEntities.RAT, RatEntity.createModAttributes());
    }
}
