package crimsonspade.berserksandbosses.Entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
//TODO: implement shuriken
public class ShurikenProjectile extends ThrowableItemProjectile {
    public ShurikenProjectile(EntityType<? extends ThrowableItemProjectile> p_37442_, Level p_37443_) {
        super(p_37442_, p_37443_);
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }
}
