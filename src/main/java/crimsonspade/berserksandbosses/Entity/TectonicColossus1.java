package crimsonspade.berserksandbosses.Entity;

import crimsonspade.berserksandbosses.Registry.EntityRegistry;
import crimsonspade.berserksandbosses.Registry.SoundRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class TectonicColossus1 extends Monster {
    public TectonicColossus1(EntityType<? extends TectonicColossus1> p_32889_, Level p_32890_) {
        super(p_32889_, p_32890_);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.FOLLOW_RANGE, 25.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.ATTACK_DAMAGE, 8.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.5D)
                .add(Attributes.ARMOR, 3.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 1.5D)
                .build();
    }

    @Override
    public void die(DamageSource pCause) {
        if (!this.getLevel().isClientSide()) {
            var form2 = new TectonicColossus2(EntityRegistry.TECTONIC_COLOSSUS_2.get(), this.getLevel());
            form2.setPos(this.position());
            form2.setSpawnState(1);
            Objects.requireNonNull(Objects.requireNonNull(this.getLevel().getServer()).getLevel(Level.OVERWORLD)).setWeatherParameters(0, 100000, true, true);
            this.getLevel().addFreshEntity(form2);
        } else {
            for (Player nearbyPlayer : level.getNearbyPlayers(TargetingConditions.forNonCombat(), null, AABB.ofSize(this.position(), 30, 30, 30))) {
                nearbyPlayer.playSound(SoundRegistry.COLOSSUS_MUSIC.get(), 1f, 1f);
            }
        }
        super.die(pCause);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return (double) (4.0 + entity.getBbWidth() * entity.getBbWidth());
            }
        });
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new FloatGoal(this));
    }

    @Override
    public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
        return false;
    }

    @Override
    public SoundEvent getHurtSound(@NotNull DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
    }
}
