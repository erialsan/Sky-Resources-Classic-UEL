package com.skyresourcesclassic;

import com.skyresourcesclassic.proxy.CommonProxy;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = References.ModID, name = References.ModName, version = References.Version)
public class SkyResourcesClassic {
    @SidedProxy(clientSide = "com.skyresourcesclassic.proxy.ClientProxy", serverSide = "com.skyresourcesclassic.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static SkyResourcesClassic instance;

    public static Logger logger;

    public static ToolMaterial materialCactusNeedle = EnumHelper
            .addToolMaterial("CACTUSNEEDLE", 0, 4, 5, 1, 5);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    public SkyResourcesClassic() {
        FluidRegistry.enableUniversalBucket();
    }
}
