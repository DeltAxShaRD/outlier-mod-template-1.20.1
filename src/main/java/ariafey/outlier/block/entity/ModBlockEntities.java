package ariafey.outlier.block.entity;

import ariafey.outlier.OutlierMod;
import ariafey.outlier.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static final BlockEntityType<GemEmpoweringStationBlockEntity> GEM_EMPOWERING_STATION_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(OutlierMod.MOD_ID, "gem_empowering_station_block_entity"),
                    FabricBlockEntityTypeBuilder.create(GemEmpoweringStationBlockEntity::new,
                    ModBlocks.GEM_EMPOWERING_STATION).build(null));

    public static void registerBlockEntities() {
        OutlierMod.LOGGER.info("Registering Mod Block Entities for " + OutlierMod.MOD_ID);
    }
}
