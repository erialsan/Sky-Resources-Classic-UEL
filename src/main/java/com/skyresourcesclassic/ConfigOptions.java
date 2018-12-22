package com.skyresourcesclassic;

import net.minecraftforge.common.config.Config;

@Config(modid = References.ModID)
public class ConfigOptions {
    @Config.Comment("The general config options for Sky Resources Classic")
    public static general general = new general();


    @Config.Comment("The general config options for the Health Gem")
    public static health health = new health();

    @Config.Comment("Config options for the Condenser")
    public static condenser condenser = new condenser();

    @Config.Comment("Config options for the Knives")
    public static knife knife = new knife();

    @Config.Comment("Config options for the Combustion Chamber")
    public static combustion combustion = new combustion();

    @Config.Comment("Config options for the Crucible")
    public static crucible crucible = new crucible();

    @Config.Comment("Config options for the Fluid Dropper")
    public static fluidDropper fluidDropper = new fluidDropper();

    @Config.Comment("Config options for the guide")
    public static guide guide = new guide();

    @Config.Comment("Config options for the Rock Grinders")
    public static rockGrinder rockGrinder = new rockGrinder();

    public static class general

    {
        @Config.Comment("Makes the end portal less dangerous")
        @Config.Name("End Portal Wuss Mode")
        public boolean endWussMode = false;

        @Config.Comment("0=overworld, 1=nether")
        @Config.Name("Draconium Crystal Type")
        public int draconiumType = 1;

        @Config.Comment("Allows all dirty gem types to be obtainable")
        @Config.Name("All Dirty Gem Types")
        public boolean allowAllGemTypes = false;

        @Config.Comment("Display mod info in chat on login")
        @Config.Name("Login Mod Info")
        public boolean displayFirstChatInfo = true;

        @Config.Name("Should Blaze Blocks be meltable in-world?")
        public boolean meltableBlazeBlocks = true;
    }

    public static class health

    {

        @Config.Comment("Max health the Health Gem can store")
        @Config.Name("Health Gem Max Health Infusion")
        public int healthGemMaxHealth = 100;

        @Config.Comment("Percentage (min 0) of health stored to boost player health")
        @Config.Name("Health Gem Boost Percentage")
        public float healthGemPercentage = (float) 0.02;
    }

    public static class condenser

    {
        @Config.Comment("Base time for condensers to process")
        @Config.Name("Condenser Base Process Time")
        public int condenserProcessTimeBase = 250;
    }

    public static class knife

    {
        @Config.Name("Knife Base Damage")
        public float knifeBaseDamage = (float) 1.5;

        @Config.Name("Knife Base Durability")
        public float knifeBaseDurability = (float) 0.8;

    }


    public static class crucible

    {
        @Config.Name("Crucible Capacity")
        public int crucibleCapacity = 4000;
    }


    public static class combustion

    {

        @Config.Comment("Amount of heat from fuel gained")
        @Config.Name("Combustion Fuel Heat Multiplier")
        public float combustionHeatMultiplier = (float) 0.5;
    }


    public static class fluidDropper

    {
        @Config.Name("Fluid Dropper Capacity")
        public int fluidDropperCapacity = 1000;

    }

    public static class guide

    {

        @Config.Name("Remember Current Guide Page")
        public boolean rememberGuide = true;

        @Config.Name("Allow guide to be opened")
        public boolean allowGuide = true;

    }

    public static class rockGrinder

    {
        @Config.Name("Rock Grinder Base Damage")
        public float rockGrinderBaseDamage = (float) 2.5;

        @Config.Name("Rock Grinder Base Durability")
        public float rockGrinderBaseDurability = (float) 0.8;
    }
}