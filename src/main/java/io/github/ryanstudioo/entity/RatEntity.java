package io.github.ryanstudioo.entity;

import io.github.ryanstudioo.ModEntities;
import io.github.ryanstudioo.goals.StayNearBlock;
import io.github.ryanstudioo.items.ModItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class RatEntity extends AnimalEntity {


    public RatEntity(EntityType<? extends RatEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createModAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 10.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.2)
                .add(EntityAttributes.ATTACK_DAMAGE, 1.0)
                .add(EntityAttributes.FOLLOW_RANGE, 16.0)
                .add(EntityAttributes.KNOCKBACK_RESISTANCE, 0.0)
                .add(EntityAttributes.TEMPT_RANGE, 10.0);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.5));
        this.goalSelector.add(2, new EscapeSunlightGoal(this, 1.0));
        this.goalSelector.add(3, new AnimalMateGoal(this, 1.2D));
        this.goalSelector.add(4, new TemptGoal(this, 1.1D, stack -> stack.isOf(ModItems.cheese), false));
        this.goalSelector.add(5, new StayNearBlock(this, 0.9, 10));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(7, new WanderAroundGoal(this, 1.0D));
        this.goalSelector.add(8, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(9, new LookAroundGoal(this));
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return ModItems.cheese == stack.getItem();
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        RatEntity babyRat = ModEntities.RAT.create(world, SpawnReason.BREEDING);
        if (babyRat != null) {
            babyRat.setBaby(true);
        }
        return babyRat;
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData) {
        super.initialize(world, difficulty, spawnReason, entityData);
        System.out.println("Rat spawned at " + this.getBlockPos());
        return entityData;
    }



}
