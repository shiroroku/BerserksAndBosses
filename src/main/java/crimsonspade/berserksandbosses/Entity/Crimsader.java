package crimsonspade.berserksandbosses.Entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class Crimsader extends Monster implements RangedAttackMob{

    public Crimsader(EntityType<? extends Crimsader> p_149105_, Level p_149106_) {
        super(p_149105_, p_149106_);
    }

    @Override
    public PathNavigation getNavigation() {
        return new FlyingPathNavigation(this, this.getLevel());
    }

    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
        return false;
    }

    @Override
    public void travel(Vec3 pTravelVector) {
        if (this.isInWater()) {
            this.moveRelative(0.02F, pTravelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale((double)0.8F));
        } else if (this.isInLava()) {
            this.moveRelative(0.02F, pTravelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.5D));
        } else {
            BlockPos ground = new BlockPos(this.getX(), this.getY() - 1.0D, this.getZ());
            float f = 0.91F;
            if (this.onGround) {
                f = this.level.getBlockState(ground).getFriction(this.level, ground, this) * 0.91F;
            }

            float f1 = 0.16277137F / (f * f * f);
            f = 0.91F;
            if (this.onGround) {
                f = this.level.getBlockState(ground).getFriction(this.level, ground, this) * 0.91F;
            }

            this.moveRelative(this.onGround ? 0.1F * f1 : 0.02F, pTravelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale((double)f));
        }

        this.calculateEntityAnimation(this, false);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, false, false));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, BerserkAxolotl.class, false, false));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, BerserkPhantom.class, false, false));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, BerserkStrider.class, false, false));
        this.goalSelector.addGoal(7, new Goal() {
            {
                this.setFlags(EnumSet.of(Goal.Flag.MOVE));
            }

            public boolean canUse() {
                if (Crimsader.this.getTarget() != null && !Crimsader.this.getMoveControl().hasWanted()) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public boolean canContinueToUse() {
                return Crimsader.this.getMoveControl().hasWanted() && Crimsader.this.getTarget() != null
                        && Crimsader.this.getTarget().isAlive();
            }

            @Override
            public void start() {
                LivingEntity livingentity = Crimsader.this.getTarget();
                Vec3 vec3d = livingentity.getEyePosition(1);
                Crimsader.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1);
            }

            @Override
            public void tick() {
                LivingEntity livingentity = Crimsader.this.getTarget();
                if (Crimsader.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
                    Crimsader.this.doHurtTarget(livingentity);
                } else {
                    double d0 = Crimsader.this.distanceToSqr(livingentity);
                    if (d0 < 16) {
                        Vec3 vec3d = livingentity.getEyePosition(1);
                        Crimsader.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1);
                    }
                }
            }
        });
        this.goalSelector.addGoal(1, new WaterAvoidingRandomFlyingGoal(this, 1));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 10, false){
            @Override
            protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
                double d0 = this.getAttackReachSqr(pEnemy);
                if (pDistToEnemySqr <= d0 && this.getTicksUntilNextAttack() <= 0) {
                    this.resetAttackCooldown();
                    this.mob.swing(InteractionHand.MAIN_HAND);
                    this.mob.doHurtTarget(pEnemy);
                    Crimsader.this.level.explode(Crimsader.this, Crimsader.this.getX(), Crimsader.this.getY(), Crimsader.this.getZ(), 5, Explosion.BlockInteraction.NONE);
                }
            }
        });
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1, 1, 10));
        this.targetSelector.addGoal(9, new HurtByTargetGoal(this));
    }


    public static AttributeSupplier setAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 350)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.FOLLOW_RANGE, 16D)
                .add(Attributes.ARMOR, 3D)
                .add(Attributes.FLYING_SPEED, 0.3D)
                .add(Attributes.ATTACK_KNOCKBACK, 1)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 6.0D).build();
    }

    @Override
    public void performRangedAttack(LivingEntity pTarget, float pDistanceFactor) {
        if (pDistanceFactor > 20){
            return;
        }
        var shuriken = new SpacefractureShurikenProjectile(this, level);
        double d0 = pTarget.getX() - this.getX();
        double d1 = pTarget.getY(0.3333333333333333D) - shuriken.getY();
        double d2 = pTarget.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2) * (double)0.2F;
        shuriken.shoot(d0, d1 + d3, d2, 1.5F, 0.0F);
        level.addFreshEntity(shuriken);
    }
}
