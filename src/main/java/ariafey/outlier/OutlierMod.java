package ariafey.outlier;

import ariafey.outlier.block.ModBlocks;
import ariafey.outlier.block.entity.ModBlockEntities;
import ariafey.outlier.effect.ModEffects;
import ariafey.outlier.enchantment.ModEnchantments;
import ariafey.outlier.fluid.ModFluids;
import ariafey.outlier.item.ModItemGroup;
import ariafey.outlier.item.ModItems;
import ariafey.outlier.painting.ModPaintings;
import ariafey.outlier.particle.ModParticles;
import ariafey.outlier.potion.ModPotions;
import ariafey.outlier.recipe.ModRecipes;
import ariafey.outlier.screen.ModScreenHandlers;
import ariafey.outlier.sound.ModSounds;
import ariafey.outlier.util.ModLootTableModifiers;
import ariafey.outlier.util.ModRegistries;
import ariafey.outlier.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* Hello! This is the Outlier Mod!*/
public class OutlierMod implements ModInitializer {
	public static final String MOD_ID = "outlier-mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModRegistries.registerModStuffs();
		ModEnchantments.registerModEnchantments();
		ModSounds.registerSounds();
		ModLootTableModifiers.modifyLootTables();
		ModPaintings.registerPaintings();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModParticles.registerParticles();
		ModVillagers.registerVillagers();
		ModFluids.registerFluids();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandler();
		ModRecipes.registerRecipes();


	}
}