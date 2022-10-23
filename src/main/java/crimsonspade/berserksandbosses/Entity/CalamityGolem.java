package crimsonspade.berserksandbosses.Entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.DefendVillageTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class CalamityGolem extends Monster {
    public CalamityGolem(EntityType<? extends CalamityGolem> p_32889_, Level p_32890_) {
        super(p_32889_, p_32890_);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.FOLLOW_RANGE, 16.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.MAX_HEALTH, 100)
                .add(Attributes.ATTACK_DAMAGE, 14D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.5)
                .build();
    }

    private float getAttackDamage() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    public boolean doHurtTarget(Entity pEntity) {
        this.level.broadcastEntityEvent(this, (byte)4);
        float f = this.getAttackDamage();
        float f1 = (int)f > 0 ? f / 2.0F + (float)this.random.nextInt((int)f) : f;
        boolean flag = pEntity.hurt(DamageSource.mobAttack(this), f1);
        if (flag) {
            pEntity.setDeltaMovement(pEntity.getDeltaMovement().add(0.0D, (double)0.4F, 0.0D));
            this.doEnchantDamageEffects(this, pEntity);
        }

        this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
        return flag;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
        this.goalSelector.addGoal(2, new MoveBackToVillageGoal(this, 0.6D, false));
        this.goalSelector.addGoal(4, new GolemRandomStrollInVillageGoal(this, 0.6D));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, (entity) -> entity instanceof Player));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Villager.class, 10, true, false, (entity) -> entity instanceof Villager));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
    }

    @Override
    public MobType getMobType() {
        return MobType.ILLAGER;
    }
}
