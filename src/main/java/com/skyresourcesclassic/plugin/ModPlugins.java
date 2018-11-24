package com.skyresourcesclassic.plugin;

import com.skyresourcesclassic.plugin.actuallyadditions.ActAddPlugin;
import com.skyresourcesclassic.plugin.armorplus.ArmorPlusPlugin;
import com.skyresourcesclassic.plugin.ctweaker.CraftTweakerPlugin;
import com.skyresourcesclassic.plugin.extremereactors.ExtremeReactorsPlugin;
import com.skyresourcesclassic.plugin.forestry.ForestryPlugin;
import com.skyresourcesclassic.plugin.integdyn.IntegratedDynamicsPlugin;
import com.skyresourcesclassic.plugin.tconstruct.TConPlugin;
import com.skyresourcesclassic.plugin.techreborn.TechRebornPlugin;
import com.skyresourcesclassic.plugin.theoneprobe.TOPPlugin;
import net.minecraftforge.fml.common.Loader;

import java.util.ArrayList;

public class ModPlugins {
    public static ArrayList<IModPlugin> plugins = new ArrayList<IModPlugin>();

    public static void preInit() {
        if (Loader.isModLoaded("forestry"))
            plugins.add(new ForestryPlugin());
        if (Loader.isModLoaded("tconstruct"))
            plugins.add(new TConPlugin());
        if (Loader.isModLoaded("techreborn"))
            plugins.add(new TechRebornPlugin());
        if (Loader.isModLoaded("armorplus"))
            plugins.add(new ArmorPlusPlugin());
        if (Loader.isModLoaded("integrateddynamics"))
            plugins.add(new IntegratedDynamicsPlugin());
        if (Loader.isModLoaded("bigreactors"))
            plugins.add(new ExtremeReactorsPlugin());
        if (Loader.isModLoaded("actuallyadditions"))
            plugins.add(new ActAddPlugin());
        if (Loader.isModLoaded("crafttweaker"))
            plugins.add(new CraftTweakerPlugin());
        if (Loader.isModLoaded("theoneprobe"))
            plugins.add(new TOPPlugin());

        for (IModPlugin p : plugins) {
            p.preInit();
        }
    }

    public static void init() {
        for (IModPlugin p : plugins) {
            p.init();
        }
    }

    public static void postInit() {
        for (IModPlugin p : plugins) {
            p.postInit();
        }
    }

    public static void initRenderers() {
        for (IModPlugin p : plugins) {
            p.initRenderers();
        }
    }
}
