package crimsonspade.berserksandbosses.Entity;

import crimsonspade.berserksandbosses.Registry.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class MaliceSoulflame extends PathfinderMob {
    private float allowedHeightOffset = 2F;
    private int nextHeightOffsetChangeTick;

    public MaliceSoulflame(EntityType<? extends MaliceSoulflame> p_149105_, Level p_149106_) {
        super(p_149105_, p_149106_);
    }

    public void aiStep() {
        if (!this.onGround && this.getDeltaMovement().y < 0.0D) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.6D, 1.0D));
        }

        if (this.level.isClientSide) {
            for(int i = 0; i < 2; ++i) {
                this.level.addParticle(ParticleTypes.PORTAL, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
            }
        }

        super.aiStep();
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

    protected void customServerAiStep() {
        --this.nextHeightOffsetChangeTick;
        if (this.nextHeightOffsetChangeTick <= 0) {
            this.nextHeightOffsetChangeTick = 100;
            this.allowedHeightOffset = 0.5F + (float)this.random.nextGaussian() * 3.0F;
        }

        LivingEntity livingentity = this.getTarget();
        if (livingentity != null && livingentity.getEyeY() > this.getEyeY() + (double)this.allowedHeightOffset && this.canAttack(livingentity)) {
            Vec3 vec3 = this.getDeltaMovement();
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, ((double)0.3F - vec3.y) * (double)0.3F, 0.0D));
            this.hasImpulse = true;
        }

        super.customServerAiStep();
    }

    @Override
    protected @NotNull PathNavigation createNavigation(@NotNull Level pLevel) {
        return new FlyingPathNavigation(this, pLevel);
    }

    @Override
    protected int calculateFallDamage(float pDistance, float pDamageMultiplier) {
        return 0;
    }

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Strider.class, true));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomFlyingGoal(this, 1));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Phantom.class, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Axolotl.class, true));
        this.goalSelector.addGoal(3, new MergeGoal());
    }

    public void die(){
        this.getNavigation().moveTo(this.getX(), 350, this.getZ(), 2);
    }

    @Override
    public void tick() {
        super.tick();
        if (getTarget() != null){
            getNavigation().moveTo(getTarget().position().x(),getTarget().position().y(),getTarget().position().z(), 1);
        }
        if (this.getBlockY() > 300) {
            this.discard();
        }
    }

    public class MergeGoal extends Goal{
        Mob mob = MaliceSoulflame.this;
        Path path;

        @Override
        public boolean canUse() {
            var target = this.mob.getTarget();
            if (target != null && target.isAlive()) {
                this.path = this.mob.getNavigation().createPath(target, 1);
                return this.path != null;
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
                if (this.mob.getTarget().getType().equals(EntityType.AXOLOTL) && !(this.mob.getTarget() instanceof BerserkAxolotl)){
                    BerserkAxolotl toSpawn = new BerserkAxolotl(EntityRegistry.BERSERK_AXOLOTL.get(), level);
                    toSpawn.setPos(this.mob.getTarget().position());
                    level.addFreshEntity(toSpawn);
                    this.mob.getTarget().discard();
                    this.mob.discard();
                } else if (this.mob.getTarget().getType().equals(EntityType.STRIDER) && !(this.mob.getTarget() instanceof BerserkStrider)){
                    BerserkStrider toSpawn = new BerserkStrider(EntityRegistry.BERSERK_STRIDER.get(), level);
                    toSpawn.setPos(this.mob.getTarget().position());
                    level.addFreshEntity(toSpawn);
                    this.mob.getTarget().discard();
                    this.mob.discard();
                } else if (this.mob.getTarget().getType().equals(EntityType.PHANTOM) && !(this.mob.getTarget() instanceof BerserkPhantom)){
                    BerserkPhantom toSpawn = new BerserkPhantom(EntityRegistry.BERSERK_PHANTOM.get(), level);
                    toSpawn.setPos(this.mob.getTarget().position());
                    level.addFreshEntity(toSpawn);
                    this.mob.getTarget().discard();
                    this.mob.discard();
                }
            }
        }

        protected double getAttackReachSqr(LivingEntity pAttackTarget) {
            return (double)(this.mob.getBbWidth() * 2.0F * this.mob.getBbWidth() * 2.0F + pAttackTarget.getBbWidth());
        }
    }

    public static AttributeSupplier setAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.FOLLOW_RANGE, 16D)
                .add(Attributes.FLYING_SPEED, 0.3D)
                .add(Attributes.ATTACK_DAMAGE, 5.0D).build();
    }
}
