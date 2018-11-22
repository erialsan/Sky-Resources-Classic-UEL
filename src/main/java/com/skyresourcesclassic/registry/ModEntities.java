package com.skyresourcesclassic.registry;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.SkyResourcesClassic;
import com.skyresourcesclassic.alchemy.tile.*;
import com.skyresourcesclassic.base.entity.EntityHeavyExplosiveSnowball;
import com.skyresourcesclassic.base.entity.EntityHeavySnowball;
import com.skyresourcesclassic.plugin.forestry.tile.TileBeeAttractor;
import com.skyresourcesclassic.technology.tile.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModEntities {
    public static void init() {
        GameRegistry.registerTileEntity(TileCombustionHeater.class,
                References.ModID + References.ModID + "::combustionHeatertile");
        GameRegistry.registerTileEntity(FluidDropperTile.class, References.ModID + ":fluidDroppertile");
        GameRegistry.registerTileEntity(CondenserTile.class, References.ModID + ":condensertile");
        GameRegistry.registerTileEntity(CrucibleTile.class, References.ModID + ":crucibletile");
        GameRegistry.registerTileEntity(FreezerTile.class, References.ModID + ":freezertile");
        GameRegistry.registerTileEntity(MiniFreezerTile.class, References.ModID + ":minifreezertile");
        GameRegistry.registerTileEntity(DirtFurnaceTile.class, References.ModID + ":dirtfurnacetile");
        GameRegistry.registerTileEntity(TilePoweredHeater.class, References.ModID + ":poweredHeatertile");
        GameRegistry.registerTileEntity(TilePoweredCombustionHeater.class,
                References.ModID + ":poweredcombustionheatertile");
        GameRegistry.registerTileEntity(CrystallizerTile.class, References.ModID + ":crystallizertile");
        GameRegistry.registerTileEntity(TileDarkMatterWarper.class, References.ModID + ":darkmatterwarpertile");
        GameRegistry.registerTileEntity(TileEndPortalCore.class, References.ModID + ":endportalcoretile");
        GameRegistry.registerTileEntity(LifeInfuserTile.class, References.ModID + ":lifeinfusertile");
        GameRegistry.registerTileEntity(LifeInjectorTile.class, References.ModID + ":lifeinjectortile");
        GameRegistry.registerTileEntity(TileCrucibleInserter.class, References.ModID + ":crucibleinsertertile");
        GameRegistry.registerTileEntity(TileRockCrusher.class, References.ModID + ":rockcrushertile");
        GameRegistry.registerTileEntity(TileRockCleaner.class, References.ModID + ":rockcleanertile");
        GameRegistry.registerTileEntity(TileCombustionCollector.class, References.ModID + ":combustioncollectortile");
        GameRegistry.registerTileEntity(TileQuickDropper.class, References.ModID + ":quickdroppertile");
        GameRegistry.registerTileEntity(TileAqueousConcentrator.class, References.ModID + ":aqueousconcentratortile");
        GameRegistry.registerTileEntity(TileBeeAttractor.class, References.ModID + ":beeAttractorTile");

        EntityRegistry.registerModEntity(new ResourceLocation(References.ModID, "heavysnowball"),
                EntityHeavySnowball.class, References.ModID + ":heavysnowball", 1, SkyResourcesClassic.instance, 64, 2, true);
        EntityRegistry.registerModEntity(new ResourceLocation(References.ModID, "heavyexplosivesnowball"),
                EntityHeavyExplosiveSnowball.class, References.ModID + ":heavyexplosivesnowball", 2,
                SkyResourcesClassic.instance, 64, 2, true);

    }
}
