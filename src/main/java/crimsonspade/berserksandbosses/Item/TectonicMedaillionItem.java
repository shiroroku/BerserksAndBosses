package crimsonspade.berserksandbosses.Item;

import crimsonspade.berserksandbosses.Entity.TectonicColossus1;
import crimsonspade.berserksandbosses.Registry.EntityRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class TectonicMedaillionItem extends Item {
    public TectonicMedaillionItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(new TranslatableComponent("tooltip.berserksandbosses.tectonic_medaillion"));
    }

    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()){
            var position = pContext.getClickLocation();
            pContext.getItemInHand().hurtAndBreak(1, Objects.requireNonNull(pContext.getPlayer()), (p_41288_) -> {
                p_41288_.broadcastBreakEvent(pContext.getHand());
            });
            TectonicColossus1 boss = new TectonicColossus1(EntityRegistry.TECTONIC_COLOSSUS_1.get(), pContext.getLevel());
            boss.setPos(position);
            pContext.getLevel().addFreshEntity(boss);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }
}
