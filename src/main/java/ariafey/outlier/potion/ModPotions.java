package ariafey.outlier.potion;

import ariafey.outlier.OutlierMod;
import ariafey.outlier.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {

    public static final Potion SLIMEY_POTION = registerPotion("slimey_potion",
            new Potion(new StatusEffectInstance(ModEffects.SLIMEY, 200, 0)));

    private static Potion registerPotion(String name, Potion potion){
        return Registry.register(Registries.POTION, new Identifier(OutlierMod.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        OutlierMod.LOGGER.info("Reigstering Potions for " + OutlierMod.MOD_ID);
    }
}
