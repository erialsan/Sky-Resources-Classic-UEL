package com.skyresourcesclassic.registry;

import com.skyresourcesclassic.ConfigOptions;
import com.skyresourcesclassic.RandomHelper;
import com.skyresourcesclassic.References;
import com.skyresourcesclassic.alchemy.fluid.FluidRegisterInfo;
import com.skyresourcesclassic.base.HeatSources;
import com.skyresourcesclassic.base.ModFuelHandler;
import com.skyresourcesclassic.recipe.ProcessRecipeManager;
import com.skyresourcesclassic.technology.item.GemRegisterInfo;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Arrays;

public class ModCrafting {
    public static void init() {
        CraftingRegistry.addShapedOreRecipe(new ItemStack(Blocks.SNOW_LAYER, 3),
                new Object[]{"XX", 'X', new ItemStack(Items.SNOWBALL)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.survivalistFishingRod),
                new Object[]{" X", "XY", 'X', new ItemStack(Items.STICK), 'Y', new ItemStack(Items.STRING)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.cactusKnife),
                new Object[]{" #", "# ", '#', new ItemStack(ModItems.itemComponent[0])});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.ironKnife), new Object[]{"#  ", "#X ", " #X", 'X',
                new ItemStack(Items.STICK), '#', new ItemStack(Items.IRON_INGOT)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.stoneKnife), new Object[]{"#  ", "#X ", " #X", 'X',
                new ItemStack(Items.STICK), '#', new ItemStack(Blocks.COBBLESTONE)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.diamondKnife), new Object[]{"#  ", "#X ", " #X", 'X',
                new ItemStack(Items.STICK), '#', new ItemStack(Items.DIAMOND)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.stoneGrinder), new Object[]{"#  ", " # ", "  X", 'X',
                new ItemStack(Items.STICK), '#', new ItemStack(Blocks.COBBLESTONE)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.ironGrinder), new Object[]{"#  ", " # ", "  X", 'X',
                new ItemStack(Items.STICK), '#', new ItemStack(Items.IRON_INGOT)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.diamondGrinder), new Object[]{"#  ", " # ", "  X", 'X',
                new ItemStack(Items.STICK), '#', new ItemStack(Items.DIAMOND)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.cactusFruitNeedle), new Object[]{"X", "Y", 'X',
                new ItemStack(ModItems.cactusFruit), 'Y', new ItemStack(ModItems.itemComponent[0])});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.sandstoneInfusionStone),
                new Object[]{"X", "Y", 'X', new ItemStack(ModItems.itemComponent[0]), 'Y',
                        new ItemStack(Blocks.SANDSTONE, 1, OreDictionary.WILDCARD_VALUE)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.redSandstoneInfusionStone),
                new Object[]{"X", "Y", 'X', new ItemStack(ModItems.itemComponent[0]), 'Y',
                        new ItemStack(Blocks.RED_SANDSTONE, 1, OreDictionary.WILDCARD_VALUE)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.alchemicalInfusionStone),
                new Object[]{"X", "Y", 'X', new ItemStack(ModItems.itemComponent[5]), 'Y',
                        new ItemStack(ModItems.itemComponent[4])});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.itemComponent[5]),
                new Object[]{"X", "X", 'X', new ItemStack(ModItems.itemComponent[4])});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.itemComponent[6]),
                new Object[]{"XXX", "XYX", "XXX", 'X', "plankWood", 'Y', Items.GUNPOWDER});
        CraftingRegistry.addShapelessOreRecipe(new ItemStack(ModItems.itemComponent[12], 4), Items.ROTTEN_FLESH,
                new ItemStack(Items.DYE, 1, 15), new ItemStack(Items.DYE, 1, 15), new ItemStack(Items.DYE, 1, 15));
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.itemComponent[7]),
                new Object[]{"XXX", "XYX", "XXX", 'X', "ingotIron", 'Y', Items.BLAZE_POWDER});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.combustionHeater[0]), new Object[]{
                "XYX", "X X", "XXX", 'X', "logWood", 'Y', new ItemStack(ModItems.itemComponent[6])});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.combustionHeater[1]), new Object[]{
                "XYX", "X X", "XXX", 'X', "ingotIron", 'Y', new ItemStack(ModItems.itemComponent[7])});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.combustionHeater[3]),
                new Object[]{"XYX", "X X", "XZX", 'X', new ItemStack(ModItems.itemComponent[11]), 'Y',
                        new ItemStack(ModItems.itemComponent[7]), 'Z',
                        new ItemStack(ModItems.itemComponent[9])});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.compressedCoalBlock), new Object[]{"XXX",
                "XYX", "XXX", 'X', new ItemStack(Blocks.COAL_BLOCK), 'Y', new ItemStack(Items.COAL)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.blazePowderBlock),
                new Object[]{"XX", "XX", 'X', new ItemStack(Items.BLAZE_POWDER)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.heavySnow),
                new Object[]{"XX", "XX", 'X', new ItemStack(ModItems.heavySnowball)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.miniFreezer),
                new Object[]{"X", "X", 'X', new ItemStack(Blocks.SNOW)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.alchemicalCondenser[0]), new Object[]{
                "XXX", "X X", "XYX", 'X', "cobblestone", 'Y', new ItemStack(ModItems.itemComponent[6])});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.alchemicalCondenser[1]), new Object[]{
                "XXX", "X X", "XYX", 'X', "ingotIron", 'Y', new ItemStack(ModItems.itemComponent[10])});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.alchemicalCondenser[3]),
                new Object[]{"XXX", "X X", "XYX", 'X', new ItemStack(ModItems.itemComponent[11]), 'Y',
                        new ItemStack(ModItems.itemComponent[10])});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.coalInfusedBlock),
                new Object[]{"XXX", "XXX", "XXX", 'X', new ItemStack(ModItems.itemComponent[1])});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.itemComponent[1]),
                new Object[]{"X", 'X', new ItemStack(ModBlocks.coalInfusedBlock)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.darkMatterBlock),
                new Object[]{"XXX", "XXX", "XXX", 'X', new ItemStack(ModItems.itemComponent[11])});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.itemComponent[11], 9),
                new Object[]{"X", 'X', new ItemStack(ModBlocks.darkMatterBlock)});
        CraftingRegistry.addShapelessOreRecipe(new ItemStack(ModBlocks.heavySnow2),
                new Object[]{new ItemStack(ModBlocks.heavySnow), new ItemStack(ModBlocks.heavySnow),
                        new ItemStack(Items.ROTTEN_FLESH)});
        CraftingRegistry.addShapelessOreRecipe(new ItemStack(Blocks.SAPLING, 1, 1),
                new Object[]{new ItemStack(Blocks.DIRT, 1, OreDictionary.WILDCARD_VALUE),
                        new ItemStack(Items.PUMPKIN_SEEDS), new ItemStack(Items.PUMPKIN_SEEDS),
                        new ItemStack(Items.DYE, 1, 15)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.itemComponent[8], 3),
                new Object[]{" X ", "XXX", " X ", 'X', "treeSapling"});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.itemComponent[8], 3),
                new Object[]{" X ", "XXX", " X ", 'X', "cropWheat"});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.itemComponent[8], 3),
                new Object[]{" X ", "XXX", " X ", 'X', "treeLeaves"});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.itemComponent[8], 3),
                new Object[]{" X ", "XXX", " X ", 'X', ModItems.cactusFruit});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.itemComponent[8], 3),
                new Object[]{" X ", "XXX", " X ", 'X', "cropPotato"});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.itemComponent[8], 3),
                new Object[]{" X ", "XXX", " X ", 'X', "cropCarrot"});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.itemComponent[8], 3),
                new Object[]{" X ", "XXX", " X ", 'X', "sugarcane"});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.itemComponent[8], 3),
                new Object[]{" X ", "XXX", " X ", 'X', "dustWood"});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.ironFreezer), new Object[]{"XXX", "XZX",
                "XXX", 'X', "ingotFrozenIron", 'Z', new ItemStack(ModBlocks.miniFreezer)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.dirtFurnace),
                new Object[]{"X", "Y", 'X', "dirt", 'Y', new ItemStack(ModItems.itemComponent[6])});

        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.waterExtractor),
                new Object[]{"XXX", " XX", 'X', "plankWood"});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.crucible),
                new Object[]{"X X", "X X", "XXX", 'X', new ItemStack(Items.BRICK)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.fluidDropper),
                new Object[]{"XXX", "X X", "X X", 'X', "cobblestone"});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.fleshySnowNugget, 3), new Object[]{"XX",
                "XY", 'X', new ItemStack(Items.SNOWBALL), 'Y', new ItemStack(Items.ROTTEN_FLESH)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.itemComponent[10]), new Object[]{"XXX",
                "XYX", "XXX", 'X', "ingotFrozenIron", 'Y', new ItemStack(Items.GLOWSTONE_DUST)});

        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.crystallizer[0]), new Object[]{"XYX",
                "X X", "X X", 'X', "cobblestone", 'Y', new ItemStack(ModItems.itemComponent[6])});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.crystallizer[1]), new Object[]{"XYX",
                "X X", "X X", 'X', "ingotIron", 'Y', new ItemStack(ModItems.itemComponent[10])});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.crystallizer[3]),
                new Object[]{"XYX", "X X", "X X", 'X', new ItemStack(ModItems.itemComponent[11]), 'Y',
                        new ItemStack(ModItems.itemComponent[10])});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.combustionCollector),
                new Object[]{"XXX", "XYX", "XXX", 'X', "ingotIron", 'Y', new ItemStack(Blocks.HOPPER)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.quickDropper), new Object[]{"XXX", "XZX",
                "XYX", 'X', "ingotIron", 'Y', new ItemStack(Blocks.DROPPER), 'Z', new ItemStack(Blocks.GLOWSTONE)});

        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.darkMatterWarper), new Object[]{"XXX",
                "XYX", "XXX", 'X', new ItemStack(Blocks.OBSIDIAN), 'Y', new ItemStack(ModItems.itemComponent[11])});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.endPortalCore),
                new Object[]{"XZX", "AYA", "XZX", 'X', new ItemStack(ModItems.itemComponent[11]), 'Y',
                        new ItemStack(Items.ENDER_EYE), 'Z', new ItemStack(ModItems.itemComponent[8]), 'A',
                        new ItemStack(ModItems.itemComponent[4])});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.sandyNetherrack, 4),
                new Object[]{"XY", "ZX", 'X', new ItemStack(Blocks.SAND), 'Y', new ItemStack(Items.NETHER_WART), 'Z',
                        new ItemStack(Blocks.NETHERRACK)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.lifeInfuser),
                new Object[]{"XXX", " X ", " Y ", 'X', "logWood", 'Y', new ItemStack(ModItems.healthGem)});
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.lifeInjector),
                new Object[]{" Y ", " X ", "XXX", 'X', "logWood", 'Y', new ItemStack(Items.DIAMOND_SWORD)});
        CraftingRegistry.addShapelessOreRecipe(new ItemStack(ModItems.heavyExpSnowball, 3),
                new ItemStack(ModItems.heavySnowball), new ItemStack(ModItems.heavySnowball),
                new ItemStack(ModItems.heavySnowball), new ItemStack(Items.GUNPOWDER));
        CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.crucibleInserter),
                new Object[]{"XYX", "X X", "X X", 'X', "ingotIron", 'Y', new ItemStack(Blocks.DROPPER)});

        String steelIngot = OreDictionary.getOres("ingotSteel").size() > 0 ? "ingotSteel"
                : OreDictionary.getOres("ingotElectricalSteel").size() > 0 ? "ingotElectricalSteel" : "ingotIron";
        String coalDust = OreDictionary.getOres("dustCoal").size() > 0 ? "dustCoal" : "dustRedstone";
        {
            CraftingRegistry.addShapedOreRecipe(new ItemStack(ModItems.itemComponent[9]),
                    new Object[]{"XZX", "XYX", "XZX", 'X', steelIngot, 'Y', Blocks.REDSTONE_BLOCK, 'Z', coalDust});
            CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.combustionHeater[2]),
                    new Object[]{"XZX", "XYX", "XYX", 'X', steelIngot, 'Y',
                            new ItemStack(ModItems.itemComponent[9]), 'Z',
                            new ItemStack(ModItems.itemComponent[7])});
            CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.poweredHeater),
                    new Object[]{"XZX", "XYX", "XXX", 'X', steelIngot, 'Y',
                            new ItemStack(ModItems.itemComponent[9]), 'Z',
                            new ItemStack(ModItems.itemComponent[7])});
            CraftingRegistry
                    .addShapedOreRecipe(new ItemStack(ModBlocks.rockCrusher),
                            new Object[]{"XXX", "XYX", "XZX", 'X', steelIngot, 'Y',
                                    new ItemStack(ModItems.diamondGrinder), 'Z',
                                    new ItemStack(ModItems.itemComponent[9])});
            CraftingRegistry
                    .addShapedOreRecipe(new ItemStack(ModBlocks.rockCleaner),
                            new Object[]{"XXX", "XYX", "XZX", 'X', steelIngot, 'Y',
                                    new ItemStack(Items.CAULDRON), 'Z',
                                    new ItemStack(ModItems.itemComponent[9])});
            CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.alchemicalCondenser[2]),
                    new Object[]{"XXX", "XZX", "XYX", 'X', steelIngot, 'Y',
                            new ItemStack(ModItems.itemComponent[10]), 'Z',
                            new ItemStack(ModItems.itemComponent[7])});
            CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.crystallizer[2]),
                    new Object[]{"XYX", "XZX", "X X", 'X', steelIngot, 'Y',
                            new ItemStack(ModItems.itemComponent[10]), 'Z',
                            new ItemStack(ModItems.itemComponent[7])});
            CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.aqueousConcentrator),
                    new Object[]{"XAX", "XZX", "XYX", 'X', steelIngot, 'Y',
                            new ItemStack(ModItems.itemComponent[9]), 'Z', new ItemStack(ModItems.waterExtractor),
                            'A', new ItemStack(Blocks.SNOW)});
            CraftingRegistry.addShapedOreRecipe(new ItemStack(ModBlocks.aqueousDeconcentrator),
                    new Object[]{"XAX", "XZX", "XYX", 'X', steelIngot, 'Y',
                            new ItemStack(ModItems.itemComponent[9]), 'Z', new ItemStack(ModItems.waterExtractor),
                            'A', new ItemStack(Blocks.SAND)});
        }
        GameRegistry.addSmelting(ModBlocks.dryCactus, new ItemStack(Items.DYE, 1, 7), 0.2F);

        GameRegistry.addSmelting(new ItemStack(ModItems.itemComponent[8]), new ItemStack(Items.COAL, 1, 1), 0.1F);

        ProcessRecipeManager.infusionRecipes.addRecipe(new ItemStack(Blocks.SAPLING, 1, 4), 10,
                new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.itemComponent[0], 10),
                        new ItemStack(ModBlocks.cactusFruitNeedle))));

        ProcessRecipeManager.infusionRecipes.addRecipe(new ItemStack(Blocks.SAPLING, 1, 0), 10,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Items.APPLE, 10, 0), "treeSapling")));

        ProcessRecipeManager.infusionRecipes.addRecipe(new ItemStack(Blocks.DIRT, 1, 1), 15, new ArrayList<Object>(
                Arrays.asList(new ItemStack(ModItems.cactusFruit, 4), new ItemStack(Blocks.SAND, 1, 1))));

        ProcessRecipeManager.infusionRecipes.addRecipe(new ItemStack(Blocks.CACTUS, 3), 8,
                new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.itemComponent[0], 6),
                        new ItemStack(Blocks.CACTUS, 1, OreDictionary.WILDCARD_VALUE))));

        ProcessRecipeManager.infusionRecipes.addRecipe(new ItemStack(Blocks.DEADBUSH), 10,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Items.ROTTEN_FLESH, 4), "treeSapling")));

        ProcessRecipeManager.infusionRecipes.addRecipe(new ItemStack(Blocks.GRASS, 1), 14,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Items.WHEAT_SEEDS, 4), new ItemStack(Blocks.DIRT))));

        ProcessRecipeManager.infusionRecipes.addRecipe(new ItemStack(Items.APPLE), 10,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Items.SUGAR, 10), new ItemStack(Blocks.HAY_BLOCK))));

        ProcessRecipeManager.infusionRecipes.addRecipe(new ItemStack(Blocks.SAPLING, 1, 5), 19, new ArrayList<Object>(
                Arrays.asList(new ItemStack(Items.GUNPOWDER, 10), new ItemStack(Blocks.SAPLING, 1, 0))));

        ProcessRecipeManager.infusionRecipes.addRecipe(new ItemStack(Blocks.SAPLING, 1, 3), 19,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Items.DYE, 10, 3), "treeSapling")));

        ProcessRecipeManager.infusionRecipes.addRecipe(new ItemStack(Blocks.SAPLING, 1, 2), 19,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Items.DYE, 10, 15), "treeSapling")));

        ProcessRecipeManager.infusionRecipes.addRecipe(new ItemStack(Items.REEDS), 19,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Items.SPECKLED_MELON, 3),
                        new ItemStack(Blocks.PUMPKIN, 1, OreDictionary.WILDCARD_VALUE))));

        ProcessRecipeManager.infusionRecipes.addRecipe(new ItemStack(Items.NETHER_WART), 19,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Items.SPIDER_EYE, 8),
                        new ItemStack(Blocks.RED_MUSHROOM, 1, OreDictionary.WILDCARD_VALUE))));

        ProcessRecipeManager.infusionRecipes.addRecipe(new ItemStack(Blocks.RED_MUSHROOM), 15,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Items.DYE, 8, 1),
                        new ItemStack(Blocks.TALLGRASS, 1, OreDictionary.WILDCARD_VALUE))));

        ProcessRecipeManager.infusionRecipes.addRecipe(new ItemStack(Blocks.BROWN_MUSHROOM), 15,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Items.DYE, 8, 3),
                        new ItemStack(Blocks.TALLGRASS, 1, OreDictionary.WILDCARD_VALUE))));

        ProcessRecipeManager.infusionRecipes.addRecipe(new ItemStack(ModItems.healthGem), 15,
                new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.itemComponent[3], 1),
                        new ItemStack(Blocks.CHORUS_FLOWER, 1, OreDictionary.WILDCARD_VALUE))));

        ProcessRecipeManager.infusionRecipes.addRecipe(new ItemStack(Items.CHORUS_FRUIT), 12, new ArrayList<Object>(Arrays.asList(new ItemStack(Items.ENDER_EYE, 4), new ItemStack(Blocks.MELON_BLOCK))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(Items.COAL, 1), 50,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Items.COAL, 1, 1))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(Items.BLAZE_POWDER, 3), 75,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Items.GUNPOWDER))));
        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(Items.GUNPOWDER), 120,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Items.FLINT))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(Items.DIAMOND, 1), 1000,
                new ArrayList<Object>(Arrays.asList(new ItemStack(ModBlocks.compressedCoalBlock, 1))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(Blocks.SAND, 12, 1), 200,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Blocks.SAND, 12), new ItemStack(Items.DYE, 1, 1))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(ModItems.metalCrystal[0]), 90,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Blocks.GLASS, 6),
                        new ItemStack(Items.ROTTEN_FLESH, 4), new ItemStack(Items.BLAZE_POWDER, 2))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(ModItems.metalCrystal[1]), 240,
                new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[0]),
                        new ItemStack(Items.IRON_INGOT, 2), new ItemStack(Items.REDSTONE, 6))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(ModItems.metalCrystal[2]), 125,
                new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[0]),
                        new ItemStack(Items.IRON_INGOT, 1), new ItemStack(Items.GUNPOWDER, 3))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(ModItems.metalCrystal[3]), 230,
                new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[2]),
                        new ItemStack(Items.IRON_INGOT, 2), new ItemStack(Items.BLAZE_POWDER, 4))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(ModItems.metalCrystal[4]), 400,
                new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[1]),
                        new ItemStack(Items.GOLD_INGOT, 2), new ItemStack(Items.SUGAR, 6))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(ModItems.metalCrystal[5]), 180,
                new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[0]),
                        new ItemStack(Items.IRON_INGOT, 3), new ItemStack(Items.SUGAR, 2))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(ModItems.metalCrystal[6]), 420,
                new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[0]),
                        new ItemStack(Items.IRON_INGOT, 3), new ItemStack(Items.GLOWSTONE_DUST, 3))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(ModItems.metalCrystal[7]), 600,
                new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[1]),
                        new ItemStack(Items.GOLD_INGOT, 4), new ItemStack(Items.DYE, 8, 4))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(ModItems.metalCrystal[8]), 160,
                new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[0]),
                        new ItemStack(Items.IRON_INGOT, 3), new ItemStack(Items.DYE, 6, 15))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(ModItems.metalCrystal[9]), 300,
                new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[0]),
                        new ItemStack(Items.IRON_INGOT, 5), new ItemStack(Items.COAL, 4))));

        ProcessRecipeManager.combustionRecipes
                .addRecipe(new ItemStack(ModItems.metalCrystal[10]), 1200,
                        new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[9]),
                                new ItemStack(Items.DYE, 9, 4), new ItemStack(Items.QUARTZ, 3),
                                new ItemStack(Items.GOLD_INGOT, 2))));

        ProcessRecipeManager.combustionRecipes
                .addRecipe(new ItemStack(ModItems.metalCrystal[11]), 1200,
                        new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[9]),
                                new ItemStack(Items.MAGMA_CREAM, 5), new ItemStack(Items.QUARTZ, 2),
                                new ItemStack(Items.GOLD_INGOT, 3))));

        ProcessRecipeManager.combustionRecipes
                .addRecipe(new ItemStack(ModItems.metalCrystal[12]), 800,
                        new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[1]),
                                new ItemStack(Items.GOLD_INGOT, 3), new ItemStack(Items.QUARTZ, 2),
                                new ItemStack(Items.REDSTONE, 7))));

        ProcessRecipeManager.combustionRecipes
                .addRecipe(new ItemStack(ModItems.metalCrystal[13]), 2000,
                        new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[1]),
                                new ItemStack(Items.GOLD_INGOT, 6), new ItemStack(Items.ENDER_EYE, 3),
                                new ItemStack(ModItems.itemComponent[11], 2))));

        ProcessRecipeManager.combustionRecipes
                .addRecipe(new ItemStack(ModItems.metalCrystal[14]), 1400,
                        new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[0]),
                                new ItemStack(Items.GOLD_INGOT, 2), new ItemStack(Items.IRON_INGOT, 4),
                                new ItemStack(Items.QUARTZ, 5))));

        ProcessRecipeManager.combustionRecipes
                .addRecipe(new ItemStack(ModItems.metalCrystal[15]), 1500,
                        new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[1]),
                                new ItemStack(Items.GOLD_INGOT, 3), new ItemStack(Items.NETHERBRICK, 4),
                                new ItemStack(Items.COAL, 5))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(ModItems.metalCrystal[16]), 1800,
                new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[1]),
                        new ItemStack(Items.GOLD_INGOT, 3), new ItemStack(Items.IRON_INGOT, 8),
                        new ItemStack(Items.QUARTZ, 5), new ItemStack(Items.SUGAR, 2))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(ModItems.metalCrystal[17]), 2600,
                new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[1]),
                        new ItemStack(Items.GOLD_INGOT, 7), new ItemStack(Items.DIAMOND, 5),
                        new ItemStack(Blocks.OBSIDIAN, 5), new ItemStack(Items.SUGAR, 2))));

        ProcessRecipeManager.combustionRecipes
                .addRecipe(new ItemStack(ModItems.metalCrystal[18]), 1000,
                        new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[1]),
                                new ItemStack(Blocks.STONE, 4), new ItemStack(Items.IRON_INGOT, 6),
                                new ItemStack(Blocks.DIRT, 3))));

        ProcessRecipeManager.combustionRecipes
                .addRecipe(new ItemStack(ModItems.metalCrystal[19]), 1300,
                        new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[1]),
                                new ItemStack(Items.GUNPOWDER, 3), new ItemStack(Items.IRON_INGOT, 5),
                                new ItemStack(Items.GOLD_INGOT, 3))));

        ProcessRecipeManager.combustionRecipes
                .addRecipe(new ItemStack(ModItems.metalCrystal[20]), 700,
                        new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[0]),
                                new ItemStack(Items.REDSTONE, 4), new ItemStack(Items.IRON_INGOT, 3),
                                new ItemStack(Items.DYE, 3, 9))));

        ProcessRecipeManager.combustionRecipes
                .addRecipe(new ItemStack(ModItems.metalCrystal[21]), 1800,
                        new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.metalCrystal[1]),
                                new ItemStack(Items.GOLD_INGOT, 6), new ItemStack(Items.DYE, 6, 4),
                                new ItemStack(ModItems.itemComponent[11]))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(ModBlocks.dryCactus), 400,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Blocks.BONE_BLOCK), new ItemStack(Items.DYE, 8, 7),
                        new ItemStack(Blocks.LEAVES, 8, 1))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(Items.REDSTONE, 4), 400, new ArrayList<Object>(
                Arrays.asList(new ItemStack(Items.GUNPOWDER, 2), new ItemStack(Items.BLAZE_POWDER, 2))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(ModItems.itemComponent[1], 4), 400,
                new ArrayList<Object>(
                        Arrays.asList(new ItemStack(Items.COAL, 3), new ItemStack(ModItems.itemComponent[2]))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(ModItems.itemComponent[3]), 1200,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Items.DIAMOND, 1),
                        new ItemStack(ModItems.itemComponent[2], 8))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(ModItems.itemComponent[4]), 1000,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Items.GOLD_INGOT, 1),
                        new ItemStack(ModItems.itemComponent[2], 4))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(ModItems.itemComponent[2], 4), 700,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Items.REDSTONE, 1), new ItemStack(Items.DYE, 1, 4),
                        new ItemStack(Items.GLOWSTONE_DUST, 1), new ItemStack(Items.BLAZE_POWDER, 1))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(Items.WHEAT_SEEDS, 1), 50,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Blocks.DEADBUSH, 1), new ItemStack(Items.FLINT, 2))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(Blocks.DIRT), 100,
                new ArrayList<Object>(Arrays.asList(new ItemStack(ModItems.itemComponent[8], 8))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(Items.SLIME_BALL), 200, new ArrayList<Object>(
                Arrays.asList(new ItemStack(ModItems.itemComponent[8], 8), new ItemStack(Items.SNOWBALL))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(ModItems.itemComponent[15]), 1400,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Items.POISONOUS_POTATO, 3),
                        new ItemStack(Items.FERMENTED_SPIDER_EYE, 2), new ItemStack(Items.GUNPOWDER, 2))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(Items.PRISMARINE_SHARD, 4), 800,
                new ArrayList<Object>(
                        Arrays.asList(new ItemStack(Items.QUARTZ, 4), new ItemStack(Blocks.MOSSY_COBBLESTONE))));
        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(Items.PRISMARINE_CRYSTALS, 4), 1200,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Items.QUARTZ, 4), new ItemStack(Blocks.GLASS, 3))));

        ItemStack waterBottle = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER);

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(Items.SNOWBALL), 200,
                new ArrayList<Object>(Arrays.asList(waterBottle)));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(Blocks.NETHERRACK, 4), 800,
                new ArrayList<Object>(
                        Arrays.asList(new ItemStack(Blocks.COBBLESTONE, 8), new ItemStack(Items.BLAZE_POWDER, 2))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(ModItems.itemComponent[11]), 1400,
                new ArrayList<Object>(
                        Arrays.asList(new ItemStack(Blocks.OBSIDIAN, 3), new ItemStack(Items.NETHERBRICK, 6),
                                new ItemStack(OreDictionary.getOres(steelIngot).get(0).getItem(), 3,
                                        OreDictionary.getOres(steelIngot).get(0).getMetadata()))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(Items.GLOWSTONE_DUST, 5), 500,
                new ArrayList<Object>(
                        Arrays.asList(new ItemStack(Items.REDSTONE, 4), new ItemStack(Items.BLAZE_POWDER, 2))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(Items.DYE, 8, 4), 800, new ArrayList<Object>(
                Arrays.asList(new ItemStack(ModItems.metalCrystal[15]), new ItemStack(Items.FLINT, 3))));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(Blocks.END_STONE, 1), 1400,
                new ArrayList<Object>(Arrays.asList(new ItemStack(Blocks.STONE, 6, 3), new ItemStack(Items.SUGAR, 2),
                        new ItemStack(Items.ENDER_PEARL, 4), new ItemStack(Items.QUARTZ, 2),
                        new ItemStack(Blocks.BONE_BLOCK, 4))));

        ProcessRecipeManager.rockGrinderRecipes.addRecipe(new ItemStack(Blocks.GRAVEL), 1,
                new ItemStack(Blocks.COBBLESTONE));
        ProcessRecipeManager.rockGrinderRecipes.addRecipe(new ItemStack(Blocks.SAND), 1, new ItemStack(Blocks.GRAVEL));
        ProcessRecipeManager.rockGrinderRecipes.addRecipe(new ItemStack(Items.FLINT), .3f,
                new ItemStack(Blocks.GRAVEL));
        ProcessRecipeManager.rockGrinderRecipes.addRecipe(new ItemStack(ModItems.itemComponent[14]), 1,
                new ItemStack(Blocks.STONE));
        ProcessRecipeManager.rockGrinderRecipes.addRecipe(new ItemStack(ModItems.itemComponent[17]), 1,
                new ItemStack(Blocks.NETHERRACK));
        ProcessRecipeManager.rockGrinderRecipes.addRecipe(new ItemStack(ModItems.itemComponent[13]), 1.5f, "logWood");

        for (int i = 0; i < ModItems.gemList.size(); i++) {
            if (ConfigOptions.general.allowAllGemTypes || OreDictionary
                    .getOres("gem" + RandomHelper.capatilizeString(ModItems.gemList.get(i).name)).size() > 0)
                ProcessRecipeManager.rockGrinderRecipes.addRecipe(new ItemStack(ModItems.dirtyGem[i]),
                        ModItems.gemList.get(i).rarity, ModItems.gemList.get(i).block);
        }

        for (int i = 0; i < ModFluids.crystalFluidInfos().length; i++) {
            ProcessRecipeManager.crucibleRecipes.addRecipe(new FluidStack(ModFluids.crystalFluids.get(i), 1000), 0,
                    new ItemStack(ModItems.metalCrystal[ModFluids.crystalFluidInfos()[i].crystalIndex]));
        }
        ProcessRecipeManager.crucibleRecipes.addRecipe(new FluidStack(FluidRegistry.LAVA, 200), 0,
                new ItemStack(Blocks.NETHERRACK));

        ProcessRecipeManager.crucibleRecipes.addRecipe(new FluidStack(FluidRegistry.LAVA, 1000), 0,
                new ItemStack(ModBlocks.blazePowderBlock));

        ProcessRecipeManager.waterExtractorExtractRecipes.addRecipe(
                new ArrayList<Object>(
                        Arrays.asList(new ItemStack(ModBlocks.dryCactus), new FluidStack(FluidRegistry.WATER, 50))),
                0, new ItemStack(Blocks.CACTUS));
        ProcessRecipeManager.waterExtractorExtractRecipes.addRecipe(
                new ArrayList<Object>(Arrays.asList(ItemStack.EMPTY, new FluidStack(FluidRegistry.WATER, 50))), 0,
                new ItemStack(Blocks.SNOW));
        ProcessRecipeManager.waterExtractorExtractRecipes.addRecipe(
                new ArrayList<Object>(Arrays.asList(ItemStack.EMPTY, new FluidStack(FluidRegistry.WATER, 20))), 0,
                "treeLeaves");

        ProcessRecipeManager.waterExtractorInsertRecipes.addRecipe(new ItemStack(Blocks.CLAY), 0, new ArrayList<Object>(
                Arrays.asList(new ItemStack(Blocks.DIRT), new FluidStack(FluidRegistry.WATER, 200))));

        ProcessRecipeManager.waterExtractorInsertRecipes.addRecipe(new ItemStack(Blocks.CACTUS), 0, new ArrayList<Object>(
                Arrays.asList(new ItemStack(ModBlocks.dryCactus), new FluidStack(FluidRegistry.WATER, 1200))));

        ProcessRecipeManager.freezerRecipes.addRecipe(new ItemStack(ModItems.heavySnowball), 40,
                new ItemStack(Items.SNOWBALL, 4));
        ProcessRecipeManager.freezerRecipes.addRecipe(new ItemStack(Blocks.DIRT, 1, 1), 800,
                new ItemStack(ModBlocks.heavySnow2));
        ProcessRecipeManager.freezerRecipes.addRecipe(new ItemStack(Blocks.ICE), 2000, waterBottle);
        ProcessRecipeManager.freezerRecipes.addRecipe(new ItemStack(ModItems.itemComponent[16]), 3000,
                new ItemStack(Items.IRON_INGOT));
        ProcessRecipeManager.freezerRecipes.addRecipe(new ItemStack(Blocks.SOUL_SAND), 1500,
                new ItemStack(ModBlocks.sandyNetherrack));

        MinecraftForge.addGrassSeed(new ItemStack(Items.BEETROOT_SEEDS), 10);
        MinecraftForge.addGrassSeed(new ItemStack(Items.MELON_SEEDS), 8);
        MinecraftForge.addGrassSeed(new ItemStack(Items.PUMPKIN_SEEDS), 8);
        MinecraftForge.addGrassSeed(new ItemStack(Items.DYE, 1, 3), 4);

        HeatSources.addHeatSource(Blocks.FIRE.getDefaultState(), 7);
        HeatSources.addHeatSource(Blocks.LAVA.getDefaultState(), 5);
        HeatSources.addHeatSource(Blocks.FLOWING_LAVA.getDefaultState(), 3);
        HeatSources.addHeatSource(Blocks.TORCH.getDefaultState(), 1);
        HeatSources.addHeatSource(Blocks.OBSIDIAN.getDefaultState(), 4);
        Block magmaBlock = Block.REGISTRY.getObject(new ResourceLocation("minecraft", "magma"));
        HeatSources.addHeatSource(magmaBlock.getDefaultState(), 8);

        GameRegistry.registerFuelHandler(new ModFuelHandler());

        ProcessRecipeManager.knifeRecipes.addRecipe(new ItemStack(ModItems.cactusFruit, 2), 1, new ItemStack(Blocks.CACTUS));
        ProcessRecipeManager.knifeRecipes.addRecipe(new ItemStack(Items.MELON, 9), 1, new ItemStack(Blocks.MELON_BLOCK));
        ProcessRecipeManager.knifeRecipes.addRecipe(new ItemStack(Blocks.PLANKS, 6), 1, new ItemStack(Blocks.LOG));
        ProcessRecipeManager.knifeRecipes.addRecipe(new ItemStack(Blocks.PLANKS, 6, 1), 1, new ItemStack(Blocks.LOG, 1, 1));
        ProcessRecipeManager.knifeRecipes.addRecipe(new ItemStack(Blocks.PLANKS, 6, 2), 1, new ItemStack(Blocks.LOG, 1, 2));
        ProcessRecipeManager.knifeRecipes.addRecipe(new ItemStack(Blocks.PLANKS, 6, 3), 1, new ItemStack(Blocks.LOG, 1, 3));
        ProcessRecipeManager.knifeRecipes.addRecipe(new ItemStack(Blocks.PLANKS, 6, 4), 1, new ItemStack(Blocks.LOG2));
        ProcessRecipeManager.knifeRecipes.addRecipe(new ItemStack(Blocks.PLANKS, 6, 5), 1, new ItemStack(Blocks.LOG2, 1, 1));
        ProcessRecipeManager.knifeRecipes.addRecipe(new ItemStack(Items.STICK, 3), 1, "plankWood");

        if (OreDictionary.getOres("dustUranium").size() > 0) {
            for (ItemStack s : OreDictionary.getOres("dustUranium")) {
                if (Loader.isModLoaded("bigreactors")
                        && s.getItem() == Item.REGISTRY.getObject(new ResourceLocation("bigreactors", "dustmetals")))
                    continue;
                ProcessRecipeManager.combustionRecipes
                        .addRecipe(new ItemStack(s.getItem(), 5, s.getItemDamage()), 1100,
                                new ArrayList<Object>(Arrays.asList(new ItemStack(Items.REDSTONE, 2),
                                        new ItemStack(Items.BLAZE_POWDER, 1),
                                        new ItemStack(ModItems.itemComponent[15], 2))));
            }
        }

        if (OreDictionary.getOres("dustThorium").size() > 0) {
            ItemStack s = OreDictionary.getOres("dustThorium").get(0);
            ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(s.getItem(), 5, s.getItemDamage()), 1500,
                    new ArrayList<Object>(Arrays.asList(new ItemStack(Items.REDSTONE, 2),
                            new ItemStack(Items.SPIDER_EYE, 1), new ItemStack(Items.BLAZE_POWDER, 3),
                            new ItemStack(ModItems.itemComponent[15], 5))));
        }

        for (FluidRegisterInfo i : ModFluids.crystalFluidInfos()) {
            String dust = "dust" + RandomHelper.capatilizeString(i.name);
            if (OreDictionary.getOres(dust).size() > 0) {
                ItemStack dustStack = OreDictionary.getOres(dust).get(0);
                dustStack.setCount(1);
                if (i.type == FluidRegisterInfo.CrystalFluidType.NORMAL) {
                    ProcessRecipeManager.cauldronCleanRecipes.addRecipe(dustStack, 1F / (((float) Math.pow((i.rarity + 2.5f), 3.7f))),
                            new ItemStack(ModItems.itemComponent[14], 1));
                } else if (i.type == FluidRegisterInfo.CrystalFluidType.MOLTEN) {
                    ProcessRecipeManager.cauldronCleanRecipes.addRecipe(dustStack, 1F / (((float) Math.pow((i.rarity + 2.5f), 4.4f))),
                            new ItemStack(ModItems.itemComponent[17], 1));
                }
            }
        }
        for (GemRegisterInfo i : ModItems.gemList) {
            String gem = "gem" + RandomHelper.capatilizeString(i.name);
            if (OreDictionary.getOres(gem).size() > 0) {
                ProcessRecipeManager.cauldronCleanRecipes.addRecipe(OreDictionary.getOres(gem).get(0), 1F,
                        new ItemStack(ModItems.dirtyGem[ModItems.gemList.indexOf(i)]));
            }
        }

        if (OreDictionary.getOres("crystalCertus").size() > 0) {
            ProcessRecipeManager.cauldronCleanRecipes.addRecipe(OreDictionary.getOres("crystalCertus").get(0), 1F,
                    new ItemStack(ModItems.dirtyGem[43]));
        }

        LootTableList.register(new ResourceLocation(References.ModID, "gameplay/fishingsurvivalist"));
        LootTableList.register(new ResourceLocation(References.ModID, "gameplay/fishing/survivalistjunk"));
    }

    public static void postInit() {
        for (ProcessRecipeManager m : ProcessRecipeManager.getManagers()) {
            m.ctRecipes();
        }
        HeatSources.ctRecipes();
    }

    public static void initOreDict() {
        OreDictionary.registerOre("ingotFrozenIron", new ItemStack(ModItems.itemComponent[16]));
        OreDictionary.registerOre("dustWood", new ItemStack(ModItems.itemComponent[13]));

    }
}
