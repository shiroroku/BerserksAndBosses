package crimsonspade.berserksandbosses.Registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import java.util.List;

public class BrewingRegistry {
    public void registerRecipes() {
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                Ingredient.of(new ItemStack(Items.HONEY_BOTTLE)),
                Ingredient.of(new ItemStack(ItemRegistry.BLOODUMBRA_EYE.get())),
                PotionUtils.setCustomEffects(new ItemStack(Items.POTION), List.of(new MobEffectInstance(MobEffects.NIGHT_VISION, 9600, 1)))));
    }
}
