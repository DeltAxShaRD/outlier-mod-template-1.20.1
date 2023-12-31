package ariafey.outlier.util;

import ariafey.outlier.block.ModBlocks;
import ariafey.outlier.command.ReturnHomeCommand;
import ariafey.outlier.command.SetHomeCommand;
import ariafey.outlier.event.AttackEntityHandler;
import ariafey.outlier.event.PlayerCopyHandler;
import ariafey.outlier.item.ModItems;
import ariafey.outlier.mixin.BrewingRecipeRegistryMixin;
import ariafey.outlier.potion.ModPotions;
import ariafey.outlier.villager.ModVillagers;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
        registerModCompostables();
        registerCommands();
        registerEvents();
        registerPotionsRecipes();
        registerCustomTrades();
    }

    private static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.PEAT_BRICK, 2000);
    }

    private static void registerModCompostables() {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CAULIFLOWER, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CAULIFLOWER_SEEDS, 0.125f);
    }

    private static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
    }

    private static void registerEvents() {
        AttackEntityCallback.EVENT.register(new AttackEntityHandler());
        ServerPlayerEvents.COPY_FROM.register(new PlayerCopyHandler());
    }

    private static void registerPotionsRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.THICK, Items.SLIME_BALL, ModPotions.SLIMEY_POTION);
    }

    private static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                       new ItemStack(Items.EMERALD, 2),
                       new ItemStack(ModItems.CAULIFLOWER, 2), 6, 2, 0.02f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                       new ItemStack(Items.EMERALD, 10),
                       new ItemStack(ModItems.PINK_GARNET_PAXEL, 1), 1, 6, 0.08f
                    ));
                });
        //SoundMaster Custom Trades
        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                       new ItemStack(Items.EMERALD, 5),
                       new ItemStack(ModBlocks.SOUND_BLOCK, 1), 15, 3, 0.08f
                    ));
                });
    }
}
