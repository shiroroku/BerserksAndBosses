package crimsonspade.berserksandbosses.Entity;

import crimsonspade.berserksandbosses.Registry.EntityRegistry;
import crimsonspade.berserksandbosses.Registry.ItemRegistry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public class SpacefractureShurikenProjectile extends ThrowableItemProjectile{
    public SpacefractureShurikenProjectile(EntityType<? extends ThrowableItemProjectile> p_37442_, Level p_37443_) {
        super(p_37442_, p_37443_);
    }

    @Override
    protected @NotNull Item getDefaultItem() {
        return ItemRegistry.SPACEFRACTURE_SHURIKEN.get();
    }

    public SpacefractureShurikenProjectile(LivingEntity p_37439_, Level p_37440_) {
        super(EntityRegistry.SPACEFRACTURE_SHURIKEN_PROJECTILE.get(), p_37439_, p_37440_);
    }

    @Override
    protected void onHitEntity(@NotNull EntityHitResult pResult) {
        Entity entity = pResult.getEntity();
        entity.hurt(DamageSource.thrown(this, this.getOwner()), 8);
        if(this.getOwner() == null || level.isClientSide()){
            return;
        }
        this.getOwner().teleportTo(entity.xOld, entity.yOld, entity.zOld);
        super.onHitEntity(pResult);
    }

    @Override
    protected void onHit(@NotNull HitResult pResult) {
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte)3);
            this.discard();
            if(this.getOwner() == null){
                return;
            }
            this.getOwner().teleportTo(pResult.getLocation().x(), pResult.getLocation().y(), pResult.getLocation().z());
        }
        super.onHit(pResult);
    }
}
