package ariafey.outlier.datagen;

import ariafey.outlier.OutlierMod;
import ariafey.outlier.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.UsingItemCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        Advancement rootAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.PINK_GARNET), Text.literal("Outlier Mod"),
                        Text.literal("Power in the Garnet!"), new Identifier(OutlierMod.MOD_ID,
                        "textures/block/pink_garnet_ore.png"),
                        AdvancementFrame.TASK, true, true, false))
                .criterion("has_pink_garnet", InventoryChangedCriterion.Conditions.items(ModItems.PINK_GARNET))
                .build(consumer, OutlierMod.MOD_ID + ":outlier");

        Advancement metalDetector = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.METAL_DETECTOR), Text.literal("Metal Detector"),
                        Text.literal("This might be useful."), new Identifier(OutlierMod.MOD_ID,
                        "textures/block/pink_garnet_ore.png"),
                        AdvancementFrame.TASK, true, true, false))
                .criterion("has_pink_garnet", InventoryChangedCriterion.Conditions.items(ModItems.METAL_DETECTOR))
                .parent(rootAdvancement)
                .build(consumer, OutlierMod.MOD_ID + ":metal_detector");
    }
}
