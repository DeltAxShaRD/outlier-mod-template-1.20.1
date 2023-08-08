package ariafey.outlier;

import ariafey.outlier.block.ModBlocks;
import ariafey.outlier.enchantment.ModEnchantments;
import ariafey.outlier.item.ModItemGroup;
import ariafey.outlier.item.ModItems;
import ariafey.outlier.sound.ModSounds;
import ariafey.outlier.util.ModRegistries;
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


	}
}