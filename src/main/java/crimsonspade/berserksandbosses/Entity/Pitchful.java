package crimsonspade.berserksandbosses.Entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

import java.util.Random;

public class Pitchful extends Monster {
    public int lightTime = 0;
    public Player owner;

    public Pitchful(EntityType<? extends Pitchful> p_149105_, Level p_149106_) {
        super(p_149105_, p_149106_);
    }

    public Pitchful(EntityType<? extends Pitchful> type, Level level, Player owner){
        super(type, level);
        this.owner = owner;
    }

    public static boolean checkMobSpawnRules(EntityType<? extends Mob> pType, LevelAccessor pLevel, MobSpawnType pReason, BlockPos pPos, Random pRandom) {
        BlockPos blockpos = pPos.below();
        return (pReason == MobSpawnType.SPAWNER || pLevel.getBlockState(blockpos).isValidSpawn(pLevel, blockpos, pType)) && pLevel.getRawBrightness(pPos, 0) < 4;
    }

    @Override
    public void tick() {
        super.tick();
        if (getTarget() == null){
            this.setTarget(this.owner);
        }
        if(getTarget() != null && level.getRawBrightness(getTarget().getOnPos(), 0) < 3f) {
            lightTime++;
            if (lightTime >= 90) {
                getTarget().kill();
                this.discard();
            }
        } else if (getTarget() != null && level.getRawBrightness(getTarget().getOnPos(), 0) > 3) {
            this.discard();
        }
    }

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
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
    }
}
