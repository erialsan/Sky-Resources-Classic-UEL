package com.skyresourcesclassic.plugin.ctweaker;

import com.skyresourcesclassic.recipe.ProcessRecipe;
import com.skyresourcesclassic.recipe.ProcessRecipeManager;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Arrays;
import java.util.Collections;

@ZenClass("mods.skyresourcesclassic.crucible")
@ZenRegister
public class MTCrucibleRecipe extends MTRecipeBase {
    @ZenMethod
    public static void addRecipe(ILiquidStack output, IItemStack input) {
        addRecipe(
                new ProcessRecipe(Arrays.asList(CraftTweakerPlugin.toFluidStack(output)),
                        Arrays.asList(CraftTweakerPlugin.toStack(input)), 0, "crucible"),
                ProcessRecipeManager.crucibleRecipes);
    }

    @ZenMethod
    public static void removeRecipe(ILiquidStack output) {
        removeRecipe(new ProcessRecipe(Arrays.asList(CraftTweakerPlugin.toFluidStack(output)), Collections.emptyList(),
                0, "crucible"), ProcessRecipeManager.crucibleRecipes);
    }

}
