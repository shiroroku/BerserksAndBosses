package crimsonspade.berserksandbosses.Item;

import net.minecraft.world.item.Item;

public class ShurikenItem extends Item {

    public ShurikenItem(Properties pProperties) {
        super(pProperties);
    }


    //TODO: implement shuriken
    /*public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, @NotNull InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (!pLevel.isClientSide) {
            ShurikenProjectile shuriken = new ShurikenProjectile(pLevel, pPlayer);
            shuriken.setItem(itemstack);
            shuriken.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(shuriken);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }*/
}
