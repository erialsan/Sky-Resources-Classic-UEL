package com.skyresourcesclassic.registry;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.SkyResourcesClassic;
import com.skyresourcesclassic.alchemy.tile.*;
import com.skyresourcesclassic.base.entity.EntityHeavyExplosiveSnowball;
import com.skyresourcesclassic.base.entity.EntityHeavySnowball;
import com.skyresourcesclassic.plugin.forestry.tile.TileBeeAttractor;
import com.skyresourcesclassic.technology.tile.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModEntities {
    public static void init() {
        registerTileEntity(TileCombustionHeater.class, ":combustion_heater_tile");
        registerTileEntity(FluidDropperTile.class, ":fluid_dropper_tile");
        registerTileEntity(CondenserTile.class, ":condenser_tile");
        registerTileEntity(CrucibleTile.class, ":crucible_tile");
        registerTileEntity(FreezerTile.class, ":freezer_tile");
        registerTileEntity(MiniFreezerTile.class, ":mini_freezer_tile");
        registerTileEntity(DirtFurnaceTile.class, ":dirt_furnace_tile");
        registerTileEntity(TilePoweredHeater.class, ":powered_heatertile");
        registerTileEntity(TilePoweredCombustionHeater.class, ":powered_combustion_heater_tile");
        registerTileEntity(CrystallizerTile.class, ":crystallizer_tile");
        registerTileEntity(TileDarkMatterWarper.class, ":dark_matter_warper_tile");
        registerTileEntity(TileEndPortalCore.class, ":end_portal_core_tile");
        registerTileEntity(LifeInfuserTile.class, ":life_infuser_tile");
        registerTileEntity(LifeInjectorTile.class, ":life_injector_tile");
        registerTileEntity(TileCrucibleInserter.class, ":crucible_inserter_tile");
        registerTileEntity(TileRockCrusher.class, ":rock_crusher_tile");
        registerTileEntity(TileRockCleaner.class, ":rock_cleaner_tile");
        registerTileEntity(TileCombustionCollector.class, ":combustion_collector_tile");
        registerTileEntity(TileQuickDropper.class, ":quick_dropper_tile");
        registerTileEntity(TileAqueousConcentrator.class, ":aqueous_concentrator_tile");
        registerTileEntity(TileBeeAttractor.class, ":bee_attractor_tile");
        registerTileEntity(TileWildlifeAttractor.class, ":wildlife_attractor_tile");
        registerTileEntity(TileHeater.class, ":heater_tile");

        EntityRegistry.registerModEntity(new ResourceLocation(References.ModID, "heavy_snowball"),
                EntityHeavySnowball.class, References.ModID + ":heavy_snowball", 1, SkyResourcesClassic.instance, 64, 2, true);
        EntityRegistry.registerModEntity(new ResourceLocation(References.ModID, "heavy_explosive_snowball"),
                EntityHeavyExplosiveSnowball.class, References.ModID + ":heavy_explosive_snowball", 2,
                SkyResourcesClassic.instance, 64, 2, true);
    }

    private static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String key) {
        GameRegistry.registerTileEntity(tileEntityClass, new ResourceLocation(References.ModID + key));
    }
}