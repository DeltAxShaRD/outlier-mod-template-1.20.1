package ariafey.outlier.block;

import ariafey.outlier.OutlierMod;
import ariafey.outlier.block.custom.CauliflowerCropBlock;
import ariafey.outlier.block.custom.GemEmpoweringStationBlock;
import ariafey.outlier.block.custom.PinkGarnetLampBlock;
import ariafey.outlier.block.custom.SoundBlock;
import ariafey.outlier.sound.ModSounds;
import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block PINK_GARNET_STAIRS = registerBlock("pink_garnet_stairs",
            new StairsBlock(ModBlocks.PINK_GARNET_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block PINK_GARNET_SLAB = registerBlock("pink_garnet_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));


    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));

    public static final Block SOUND_BLOCK = registerBlock("sound_block",
            new SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block PINK_GARNET_LAMP_BLOCK = registerBlock("pink_garnet_lamp_block",
            new PinkGarnetLampBlock(FabricBlockSettings.create().mapColor(MapColor.PINK)
                    .luminance(state -> state.get(PinkGarnetLampBlock.CLICKED) ? 15 : 0).sounds(ModSounds.PINK_GARNET_LAMP_SOUNDS).strength(4f).requiresTool()));
    public static final Block PINK_GARNET_BUTTON = registerBlock("pink_garnet_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE_BUTTON), BlockSetType.IRON, 5, false));
    public static final Block PINK_GARNET_PRESSURE_PLATE = registerBlock("pink_garnet_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.STONE_PRESSURE_PLATE),
                    BlockSetType.IRON));
    public static final Block PINK_GARNET_FENCE = registerBlock("pink_garnet_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block PINK_GARNET_FENCE_GATE = registerBlock("pink_garnet_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), WoodType.WARPED));
    public static final Block PINK_GARNET_WALL = registerBlock("pink_garnet_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block PINK_GARNET_DOOR = registerBlock("pink_garnet_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_DOOR), BlockSetType.IRON));
    public static final Block PINK_GARNET_TRAPDOOR = registerBlock("pink_garnet_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_TRAPDOOR), BlockSetType.IRON));

    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE), UniformIntProvider.create(5, 8)));
    public static final Block END_STONE_PINK_GARNET_ORE = registerBlock("end_stone_pink_garnet_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE), UniformIntProvider.create(5, 8)));
    public static final Block NETHER_PINK_GARNET_ORE = registerBlock("nether_pink_garnet_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE), UniformIntProvider.create(5, 8)));
    public static final Block DEEPSLATE_PINK_GARNET_ORE = registerBlock("deepslate_pink_garnet_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE), UniformIntProvider.create(5, 8)));

    public static final Block CAULIFLOWER_CROP = registerBlockWithoutItem("cauliflower_crop",
            new CauliflowerCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static final Block PETUNIA = registerBlock("petunia",
            new FlowerBlock(StatusEffects.HERO_OF_THE_VILLAGE, 4, FabricBlockSettings.copyOf(Blocks.ALLIUM)));
    public static final Block POTTED_PETUNIA = registerBlockWithoutItem("potted_petunia",
            new FlowerPotBlock(PETUNIA, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM)));


    public static final Block GEM_EMPOWERING_STATION = registerBlock("gem_empowering_station",
            new GemEmpoweringStationBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(OutlierMod.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(OutlierMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(OutlierMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        OutlierMod.LOGGER.info("Registering Mod Blocks for " + OutlierMod.MOD_ID);
    }
}
