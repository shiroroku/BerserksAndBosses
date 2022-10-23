package crimsonspade.berserksandbosses.Mixin;

import crimsonspade.berserksandbosses.Entity.CalamityGolem;
import crimsonspade.berserksandbosses.Registry.EntityRegistry;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.minecraft.world.entity.monster.Evoker$EvokerAttackSpellGoal")
public class EvokerGolemConvert{
    @Inject(at = @At("HEAD"), method = "performSpellCasting")
    protected void convertGolem(CallbackInfo ci){
        try {
            var inner = Class.forName("net.minecraft.world.entity.monster.Evoker$EvokerAttackSpellGoal").cast((Object)this);
            LivingEntity entity = (Evoker) inner.getClass().getDeclaredField("this$0").get(inner);
            var entities = entity.getLevel().getEntitiesOfClass(IronGolem.class, AABB.ofSize(entity.position(), 10, 10, 10));
            if(entities.size() > 0){
                CalamityGolem entityToSpawn = new CalamityGolem(EntityRegistry.CALAMITY_GOLEM.get(), entity.getLevel());
                entityToSpawn.setPos(entities.get(0).position());
                entities.get(0).discard();
                entity.getLevel().addFreshEntity(entityToSpawn);
            }
        } catch (Exception exception){
            System.out.println(exception);
        }
    }
}
