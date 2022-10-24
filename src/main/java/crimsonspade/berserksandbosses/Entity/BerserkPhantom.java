package crimsonspade.berserksandbosses.Entity;

import crimsonspade.berserksandbosses.Registry.EntityRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class BerserkPhantom extends Phantom {
    public int suriveTime = 96000;

    public BerserkPhantom(EntityType<? extends BerserkPhantom> p_149105_, Level p_149106_) {
        super(p_149105_, p_149106_);
    }

    @Override
    public void tick() {
        super.tick();
        suriveTime --;
        if (suriveTime <= 0){
            var entity = new MaliceSoulflame(EntityRegistry.MALICE_SOULFLAME.get(), this.level);
            entity.setPos(this.position());
            this.level.addFreshEntity(entity);
            entity.die();
            this.kill();
        }
    }

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(1, new KidnapGoal(this, () -> this.navigation.createPath(this.blockPosition().above(300), 1)) {
            @Override
            public void tick() {
                super.tick();
                if (this.mob.position().y() > 300) {
                    this.mob.getTarget().unRide();
                }
            }

            @Override
            public boolean canUse() {
                var target = this.mob.getTarget();
                if (target != null && target.isAlive()) {
                    this.path = this.mob.getNavigation().createPath(target, 1);
                    return this.path != null;
                }
                return false;
            }
        });
        super.registerGoals();
    }

    @Override
    protected @NotNull PathNavigation createNavigation(@NotNull Level pLevel) {
        return new FlyingPathNavigation(this, pLevel);
    }

    public static AttributeSupplier setAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 120.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.FOLLOW_RANGE, 16D)
                .add(Attributes.FLYING_SPEED, 0.3D)
                .add(Attributes.ATTACK_DAMAGE, 1.0D).build();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag p_149158_) {
        super.addAdditionalSaveData(p_149158_);
        p_149158_.putInt("surviveTime", this.suriveTime);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag p_149145_) {
        super.readAdditionalSaveData(p_149145_);
        this.suriveTime = p_149145_.getInt("surviveTime");
        if (this.firstTick){
            suriveTime = 96000;
        }
    }
}
