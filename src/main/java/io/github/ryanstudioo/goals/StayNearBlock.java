package io.github.ryanstudioo.goals;

import io.github.ryanstudioo.items.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.BlockPos;

public class StayNearBlock extends Goal {
    private final PathAwareEntity mob;
    private final double speed;
    private final int maxDistance; // max distance allowed from block
    private BlockPos targetPos;

    public StayNearBlock(PathAwareEntity mob, double speed, int maxDistance) {
        this.mob = mob;
        this.speed = speed;
        this.maxDistance = maxDistance;
    }

    @Override
    public boolean canStart() {
        BlockPos mobPos = this.mob.getBlockPos();
        int radius = 10;

        for (BlockPos pos : BlockPos.iterateOutwards(mobPos, radius, radius, radius)) {
            if (isTargetBlock(pos)) {
                targetPos = pos.toImmutable();
                return true;
            }
        }
        return false;
    }

    @Override
    public void start() {
        moveToTarget();
    }

    @Override
    public boolean shouldContinue() {
        if (targetPos == null) return false;

        double distSq = mob.squaredDistanceTo(
                targetPos.getX() + 0.5,
                targetPos.getY(),
                targetPos.getZ() + 0.5
        );

        // If too far, move back
        if (distSq > (maxDistance * maxDistance)) {
            moveToTarget();
            return true;
        }

        return true; // stay active so mob keeps “guarding” the block
    }

    private void moveToTarget() {
        mob.getNavigation().startMovingTo(
                targetPos.getX() + 0.5,
                targetPos.getY(),
                targetPos.getZ() + 0.5,
                speed
        );
    }

    private boolean isTargetBlock(BlockPos pos) {
        return mob.getWorld().getBlockState(pos).getBlock() == ModBlocks.CHEESE_BLOCK;
    }
}
