package com.skyresourcesclassic.registry;

import com.skyresourcesclassic.ConfigOptions;
import com.skyresourcesclassic.base.guide.SkyResourcesGuide;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;

public class ModGuidePages {
    public static void init() {
        SkyResourcesGuide.addPage("basics", "guide.skyresourcesclassic.stage1", new ItemStack(Blocks.BEDROCK));

        SkyResourcesGuide.addPage("sandIsland", "guide.skyresourcesclassic.stage1", new ItemStack(Blocks.SAND, 1, 1));

        SkyResourcesGuide.addPage("lifeInfusion", "guide.skyresourcesclassic.stage1",
                new ItemStack(ModItems.alchemicalInfusionStone));

        SkyResourcesGuide.addPage("snowIsland", "guide.skyresourcesclassic.stage1", new ItemStack(Blocks.SNOW));

        SkyResourcesGuide.addPage("miniFreezer", "guide.skyresourcesclassic.stage1", new ItemStack(ModBlocks.miniFreezer));

        SkyResourcesGuide.addPage("woodIsland", "guide.skyresourcesclassic.stage1", new ItemStack(Blocks.PLANKS, 1, 5));

        SkyResourcesGuide.addPage("grassIsland", "guide.skyresourcesclassic.stage1", new ItemStack(Blocks.GRASS));

        SkyResourcesGuide.addPage("combustionHeater", "guide.skyresourcesclassic.stage2",
                new ItemStack(ModBlocks.combustionHeater));

        SkyResourcesGuide.addPage("waterExtractor", "guide.skyresourcesclassic.stage2",
                new ItemStack(ModItems.waterExtractor));

        SkyResourcesGuide.addPage("dirtFurnace", "guide.skyresourcesclassic.stage2", new ItemStack(ModBlocks.dirtFurnace));

        if (ConfigOptions.general.meltableBlazeBlocks)
            SkyResourcesGuide.addPage("lavaBlaze", "guide.skyresourcesclassic.stage2", new ItemStack(ModBlocks.blazePowderBlock));
        else
            SkyResourcesGuide.addPage("lavaBlaze1", "guide.skyresourcesclassic.stage2", new ItemStack(ModBlocks.blazePowderBlock));

        SkyResourcesGuide.addPage("heatSources", "guide.skyresourcesclassic.stage2", new ItemStack(Blocks.TORCH));

        SkyResourcesGuide.addPage("rockGrinder", "guide.skyresourcesclassic.stage2", new ItemStack(ModItems.stoneGrinder));

        SkyResourcesGuide.addPage("metalCreation", "guide.skyresourcesclassic.stage2", new ItemStack(ModItems.metalCrystal));

        SkyResourcesGuide.addPage("crucible", "guide.skyresourcesclassic.stage2", new ItemStack(ModBlocks.crucible));

        SkyResourcesGuide.addPage("fluidDropper", "guide.skyresourcesclassic.stage2", new ItemStack(ModBlocks.fluidDropper));

        SkyResourcesGuide.addPage("alchemicalCondenser", "guide.skyresourcesclassic.stage2",
                new ItemStack(ModBlocks.alchemicalCondenser));

        SkyResourcesGuide.addPage("crystallizer", "guide.skyresourcesclassic.stage2",
                new ItemStack(ModBlocks.crystallizer));

        SkyResourcesGuide.addPage("crucibleInserter", "guide.skyresourcesclassic.stage2",
                new ItemStack(ModBlocks.crucibleInserter));

        SkyResourcesGuide.addPage("combustionCollector", "guide.skyresourcesclassic.stage2",
                new ItemStack(ModBlocks.combustionCollector));

        SkyResourcesGuide.addPage("quickDropper", "guide.skyresourcesclassic.stage2", new ItemStack(ModBlocks.quickDropper));

        SkyResourcesGuide.addPage("crushedStone", "guide.skyresourcesclassic.stage2",
                new ItemStack(ModItems.itemComponent[14]));

        SkyResourcesGuide.addPage("gemProduction", "guide.skyresourcesclassic.stage2", new ItemStack(Items.EMERALD));

        SkyResourcesGuide.addPage("alchemicalItems", "guide.skyresourcesclassic.stage3",
                new ItemStack(ModItems.itemComponent[0]));

        SkyResourcesGuide.addPage("ironFreezer", "guide.skyresourcesclassic.stage3", new ItemStack(ModBlocks.ironFreezer));

        SkyResourcesGuide.addPage("rockCrusher", "guide.skyresourcesclassic.stage3", new ItemStack(ModBlocks.rockCrusher));

        SkyResourcesGuide.addPage("rockCleaner", "guide.skyresourcesclassic.stage3", new ItemStack(ModBlocks.rockCleaner));

        SkyResourcesGuide.addPage("aqueous", "guide.skyresourcesclassic.stage3", new ItemStack(ModBlocks.aqueousConcentrator));

        SkyResourcesGuide.addPage("poweredHeater", "guide.skyresourcesclassic.stage3", new ItemStack(ModBlocks.poweredHeater));

        if (Loader.isModLoaded("voidislandcontrol"))
            SkyResourcesGuide.addPage("nether", "guide.skyresourcesclassic.misc", new ItemStack(Blocks.NETHERRACK));

        SkyResourcesGuide.addPage("dmWarper", "guide.skyresourcesclassic.stage3", new ItemStack(ModBlocks.darkMatterWarper));

        SkyResourcesGuide.addPage("healthGem", "guide.skyresourcesclassic.stage3", new ItemStack(ModItems.healthGem));

        SkyResourcesGuide.addPage("lifeInfuser", "guide.skyresourcesclassic.stage3", new ItemStack(ModBlocks.lifeInfuser));

        SkyResourcesGuide.addPage("end", "guide.skyresourcesclassic.stage3", new ItemStack(Items.ENDER_EYE));
    }
}
