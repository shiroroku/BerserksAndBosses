package crimsonspade.berserksandbosses.Entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;


public class TectonicColossus2 extends Monster implements IAnimatable {
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(TectonicColossus2.class,
            EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DEATH_STATE = SynchedEntityData.defineId(TectonicColossus2.class,
            EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> SPAWN_STATE = SynchedEntityData.defineId(TectonicColossus2.class,
            EntityDataSerializers.INT);

    private int spawnTimer;
    public TectonicColossus2(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }

    @Override
    public void die(DamageSource source) {
        if (!this.level.isClientSide) {
            if (source == DamageSource.OUT_OF_WORLD) {
                this.setDeathState(1);
                this.level.broadcastEntityEvent(this, (byte) 3);
                super.die(source);
            }
            if(this.getDeathState() == 0){
                this.goalSelector.getRunningGoals().forEach(WrappedGoal::stop);
                this.setDeathState(1);
                this.level.broadcastEntityEvent(this, (byte) 3);
                super.die(source);
            }
        }
    }

    @Override
    protected void tickDeath() {
        ++this.deathTime;
        if (this.deathTime >= 47) {
            this.remove(Entity.RemovalReason.KILLED);
            this.setDeathState(1);
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (getSpawnState() == 1){
            if (spawnTimer >= 100){
                setSpawnState(0);
            } else {
                spawnTimer++;
            }
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STATE, 0);
        this.entityData.define(DEATH_STATE, 0);
        this.entityData.define(SPAWN_STATE, 0);
    }

    @Override
    public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
        return false;
    }


    public int getAttckingState() {
        return this.entityData.get(STATE);
    }

    public int getSpawnState() {
        return this.entityData.get(SPAWN_STATE);
    }

    public int getDeathState(){
        return this.entityData.get(DEATH_STATE);
    }

    public void setDeathState(int time){
        this.entityData.set(DEATH_STATE, time);
    }

    public void setSpawnState(int time){
        this.entityData.set(SPAWN_STATE, time);
    }

    public void setAttackingState(int time) {
        this.entityData.set(STATE, time);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.FOLLOW_RANGE, 16.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.MAX_HEALTH, 150)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 1.5D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1D)
                .build();
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new ColossusAttackGoal(this, 1.2, random.nextInt(1, 3)));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(3, new SummonGoal(this, 16));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new FloatGoal(this));
    }

    class SummonGoal extends Goal{
        private final Entity entity;
        private final int dist;
        public SummonGoal(Entity entity, int dist) {
            this.entity = entity;
            this.dist = dist;
        }

        @Override
        public boolean canUse() {
            return this.entity.level.hasNearbyAlivePlayer(this.entity.getX(), this.entity.getY(), this.entity.getZ(), dist);
        }

        @Override
        public void start() {
            super.start();
            TectonicColossus2.this.entityData.set(STATE, 3);
        }

        @Override
        public void stop() {
            super.stop();
            TectonicColossus2.this.entityData.set(STATE, 0);
        }

        @Override
        public void tick() {
            if (this.entity.tickCount % 1000 == 0){
                ServerLevel serverlevel = (ServerLevel)this.entity.level;
                for(int i = 0; i < 3; ++i) {
                    Slime slime = new Slime(EntityType.SLIME, entity.level);
                    slime.getPersistentData().putInt("Size", 3);
                    slime.setPos(this.entity.position());
                    slime.push(this.entity.getRandomX(1) * 0.5D, 0.0D, this.entity.getRandomZ(1) * 0.5D);
                    serverlevel.addFreshEntity(slime);
                }
            }
            super.tick();
        }
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        this.setSpawnState(0);
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event){
        if ((this.dead || this.getHealth() < 0.01 || this.isDeadOrDying()) && this.entityData.get(DEATH_STATE) == 1) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("death", ILoopType.EDefaultLoopTypes.HOLD_ON_LAST_FRAME));
            return PlayState.CONTINUE;
        }
        if(this.entityData.get(SPAWN_STATE) == 1 && this.entityData.get(DEATH_STATE) != 1){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("unburrow", ILoopType.EDefaultLoopTypes.HOLD_ON_LAST_FRAME));
            return PlayState.CONTINUE;

        }
        if(event.isMoving() && this.entityData.get(DEATH_STATE) != 1){
            if (this.getTarget() != null) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", ILoopType.EDefaultLoopTypes.LOOP));
                return PlayState.CONTINUE;
            } else {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("walk2", ILoopType.EDefaultLoopTypes.LOOP));
                return PlayState.CONTINUE;
            }
        }
        if(this.getAttckingState() == 1 && this.entityData.get(DEATH_STATE) != 1){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("double_attack", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            return PlayState.CONTINUE;
        }
        if(this.getAttckingState() == 2 && this.entityData.get(DEATH_STATE) != 1){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("slam_attack", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            return PlayState.CONTINUE;
        }
        if(this.getAttckingState() == 2 && this.entityData.get(DEATH_STATE) != 1){
            if (this.random.nextBoolean()){
                event.getController().setAnimation(new AnimationBuilder().addAnimation("slime_spawn_attack_1", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            } else {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("slime_spawn_attack_2", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            }
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", ILoopType.EDefaultLoopTypes.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
