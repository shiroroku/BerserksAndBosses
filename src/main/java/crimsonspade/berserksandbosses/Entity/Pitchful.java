package crimsonspade.berserksandbosses.Entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class Pitchful extends Monster {
    public int lightTime = 90;

    public Pitchful(EntityType<? extends Pitchful> p_149105_, Level p_149106_) {
        super(p_149105_, p_149106_);
    }

    @Override
    public void tick() {
        super.tick();
        if(getTarget() != null && getTarget().getBrightness() < 3f) {
            lightTime--;
            if (lightTime <= 0) {
                getTarget().kill();
            }
        } else {
            this.discard();
        }
    }

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public boolean isInvulnerable() {
        return true;
    }

    public static AttributeSupplier setAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.FOLLOW_RANGE, 16D)
                .add(Attributes.FLYING_SPEED, 0.3D)
                .add(Attributes.ATTACK_DAMAGE, 12.0D).build();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag p_149158_) {
        super.addAdditionalSaveData(p_149158_);
        p_149158_.putInt("lightTime", this.lightTime);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag p_149145_) {
        super.readAdditionalSaveData(p_149145_);
        this.lightTime = p_149145_.getInt("lightTime");
        if (this.firstTick){
            lightTime = 90;
        }
    }
}
