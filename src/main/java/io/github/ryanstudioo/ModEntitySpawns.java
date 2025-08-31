package io.github.ryanstudioo;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.world.Heightmap;

public class ModEntitySpawns {

    public static void initialize(){
        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(),
                SpawnGroup.CREATURE,
                ModEntities.RAT,
                60,
                1,
                3);

        SpawnRestriction.register(ModEntities.RAT,
                SpawnRestriction.getLocation(ModEntities.RAT),
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, spawnReason, pos, random) -> {
                    int light = world.getLightLevel(pos);
                    boolean solidBlockBelow = !world.getBlockState(pos.down()).isAir();
                    boolean airAbove = world.getBlockState(pos).isAir();
                    boolean underground = pos.getY() <= 50;
                    boolean canSpawn = light <= 8 && solidBlockBelow && airAbove && underground;

                    return canSpawn;
                }
                );
    }

}
