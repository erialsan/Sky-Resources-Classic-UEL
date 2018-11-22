package com.skyresourcesclassic.plugin.ctweaker;

import com.skyresourcesclassic.recipe.ProcessRecipe;
import com.skyresourcesclassic.recipe.ProcessRecipeManager;
import crafttweaker.api.item.IItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Arrays;

@ZenClass("mods.skyresourcesclassic.waterextractor.extract")
public class MTWaterExtractorExtractRecipe extends MTRecipeBase {
    @ZenMethod
    public static void addRecipe(int waterOut, IItemStack output, IItemStack input) {
        addRecipe(
                new ProcessRecipe(
                        Arrays.asList(CraftTweakerPlugin.toStack(output),
                                new FluidStack(FluidRegistry.WATER, waterOut)),
                        Arrays.asList(CraftTweakerPlugin.toStack(input)), 0, "waterextractor-extract"),
                ProcessRecipeManager.waterExtractorExtractRecipes);
    }

    @ZenMethod
    public static void removeRecipe(int waterOut, IItemStack output, IItemStack input) {
        removeRecipe(
                new ProcessRecipe(
                        Arrays.asList(CraftTweakerPlugin.toStack(output),
                                new FluidStack(FluidRegistry.WATER, waterOut)),
                        Arrays.asList(CraftTweakerPlugin.toStack(input)), 0, "waterextractor-extract"),
                ProcessRecipeManager.waterExtractorExtractRecipes);
    }

}
