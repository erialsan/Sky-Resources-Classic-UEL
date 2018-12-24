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
       registerTileEntity(TileCombustionHeater.class,
                References.ModID + "::combustionHeatertile");
        registerTileEntity(FluidDropperTile.class, References.ModID + ":fluidDroppertile");
        registerTileEntity(CondenserTile.class, References.ModID + ":condensertile");
        registerTileEntity(CrucibleTile.class, References.ModID + ":crucibletile");
        registerTileEntity(FreezerTile.class, References.ModID + ":freezertile");
        registerTileEntity(MiniFreezerTile.class, References.ModID + ":minifreezertile");
        registerTileEntity(DirtFurnaceTile.class, References.ModID + ":dirtfurnacetile");
        registerTileEntity(TilePoweredHeater.class, References.ModID + ":poweredHeatertile");
        registerTileEntity(TilePoweredCombustionHeater.class,
                References.ModID + ":poweredcombustionheatertile");
        registerTileEntity(CrystallizerTile.class, References.ModID + ":crystallizertile");
        registerTileEntity(TileDarkMatterWarper.class, References.ModID + ":darkmatterwarpertile");
        registerTileEntity(TileEndPortalCore.class, References.ModID + ":endportalcoretile");
        registerTileEntity(LifeInfuserTile.class, References.ModID + ":lifeinfusertile");
        registerTileEntity(LifeInjectorTile.class, References.ModID + ":lifeinjectortile");
        registerTileEntity(TileCrucibleInserter.class, References.ModID + ":crucibleinsertertile");
        registerTileEntity(TileRockCrusher.class, References.ModID + ":rockcrushertile");
        registerTileEntity(TileRockCleaner.class, References.ModID + ":rockcleanertile");
        registerTileEntity(TileCombustionCollector.class, References.ModID + ":combustioncollectortile");
        registerTileEntity(TileQuickDropper.class, References.ModID + ":quickdroppertile");
        registerTileEntity(TileAqueousConcentrator.class, References.ModID + ":aqueousconcentratortile");
        registerTileEntity(TileBeeAttractor.class, References.ModID + ":beeAttractorTile");
        registerTileEntity(TileWildlifeAttractor.class, References.ModID + ":wildlifeAttractorTile");

        EntityRegistry.registerModEntity(new ResourceLocation(References.ModID, "heavysnowball"),
                EntityHeavySnowball.class, References.ModID + ":heavysnowball", 1, SkyResourcesClassic.instance, 64, 2, true);
        EntityRegistry.registerModEntity(new ResourceLocation(References.ModID, "heavyexplosivesnowball"),
                EntityHeavyExplosiveSnowball.class, References.ModID + ":heavyexplosivesnowball", 2,
                SkyResourcesClassic.instance, 64, 2, true);
    }

    private static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String key) {
        GameRegistry.registerTileEntity(tileEntityClass, new ResourceLocation(key));
    }
}
