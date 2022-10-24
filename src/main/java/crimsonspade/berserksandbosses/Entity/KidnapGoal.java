package crimsonspade.berserksandbosses.Entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.pathfinder.Path;

import java.util.function.Supplier;

public class KidnapGoal extends Goal {
    protected Mob mob;
    protected Path path;
    protected Supplier<Path> destination;
    public KidnapGoal(Mob mob, Supplier<Path> destination) {
        this.mob = mob;
        this.destination = destination;
    }

    @Override
    public boolean canUse() {
        if (this.mob.getLevel().getGameTime() % 100 == 0) {
            var target = this.mob.getTarget();
            if (target != null && target.isAlive()) {
                this.path = this.mob.getNavigation().createPath(target, 1);
                return this.path != null;
            }
        }
        return false;
    }

    public boolean canContinueToUse() {
        LivingEntity livingentity = this.mob.getTarget();
        if (livingentity == null) {
            return false;
        } else if (!livingentity.isAlive()) {
            return false;
        } else if (!this.mob.isWithinRestriction(livingentity.blockPosition())) {
            return false;
        } else {
            return !(livingentity instanceof Player) || !livingentity.isSpectator() && !((Player)livingentity).isCreative();
        }
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    @Override
    public void start() {
        if (this.mob.getTarget() == null){
            return;
        }
        mob.getNavigation().moveTo(path, 3.0);
    }

    @Override
    public void tick() {
        if (this.mob.getTarget() == null){
            return;
        }
        if (this.mob.getTarget().distanceToSqr(this.mob) < this.getAttackReachSqr(this.mob.getTarget())){
            if(!((this.mob.getTarget().isPassenger() || this.mob.isPassenger()) && this.mob.getPassengers().contains(this.mob.getTarget()))) {
                this.mob.getTarget().startRiding(this.mob, true);
                this.mob.canBeRiddenInWater(this.mob.getTarget());
            } else {
                this.mob.getNavigation().moveTo(this.destination.get(), 3);
            }
        }
    }

    protected double getAttackReachSqr(LivingEntity pAttackTarget) {
        return (double)(this.mob.getBbWidth() * 2.0F * this.mob.getBbWidth() * 2.0F + pAttackTarget.getBbWidth());
    }
}
