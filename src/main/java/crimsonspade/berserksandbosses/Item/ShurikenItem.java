package crimsonspade.berserksandbosses.Item;

import crimsonspade.berserksandbosses.Entity.ShurikenProjectile;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ShurikenItem extends Item {

    public ShurikenItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(new TranslatableComponent("tooltip.berserksandbosses.shuriken"));
    }

    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, @NotNull InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (!pLevel.isClientSide) {
            ShurikenProjectile shurikenProjectile = new ShurikenProjectile(pPlayer, pLevel);
            shurikenProjectile.setItem(itemstack);
            shurikenProjectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(shurikenProjectile);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }
}
