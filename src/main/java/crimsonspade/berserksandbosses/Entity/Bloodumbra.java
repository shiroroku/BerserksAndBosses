package crimsonspade.berserksandbosses.Entity;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class Bloodumbra extends Husk {
    public Bloodumbra(EntityType<? extends Bloodumbra> p_32889_, Level p_32890_) {
        super(p_32889_, p_32890_);
    }
    @Override
    public boolean doHurtTarget(@NotNull Entity pEntity) {
        boolean flag = super.doHurtTarget(pEntity);
        if (flag && this.getMainHandItem().isEmpty() && pEntity instanceof LivingEntity) {
            ((LivingEntity) pEntity).addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 1));
        }

        return flag;
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.FOLLOW_RANGE, 16.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.ATTACK_DAMAGE, 6.0D)
                .add(Attributes.ARMOR, 2.0D)
                .build();
    }
}