package ariafey.outlier.enchantment;

import ariafey.outlier.OutlierMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {

    public static final Enchantment LIGHTNING_STRIKER = register("lightning_striker",
            new LightningStrikerEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));


    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(OutlierMod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        OutlierMod.LOGGER.info("Registering Enchantments for " + OutlierMod.MOD_ID);
    }
}
