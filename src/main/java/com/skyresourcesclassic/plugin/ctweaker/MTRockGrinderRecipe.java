package com.skyresourcesclassic.plugin.ctweaker;

import com.skyresourcesclassic.recipe.ProcessRecipe;
import com.skyresourcesclassic.recipe.ProcessRecipeManager;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Arrays;
import java.util.Collections;

@ZenClass("mods.skyresourcesclassic.rockgrinder")
public class MTRockGrinderRecipe extends MTRecipeBase {

    @ZenMethod
    public static void addRecipe(IItemStack output, IItemStack input) {
        addRecipe(
                new ProcessRecipe(Arrays.asList(CraftTweakerPlugin.toStack(output)),
                        Arrays.asList(CraftTweakerPlugin.toStack(input)), 1, "rockgrinder"),
                ProcessRecipeManager.rockGrinderRecipes);
    }

    @ZenMethod
    public static void addRecipe(IItemStack output, IItemStack input, float chance) {
        addRecipe(
                new ProcessRecipe(Arrays.asList(CraftTweakerPlugin.toStack(output)),
                        Arrays.asList(CraftTweakerPlugin.toStack(input)), chance, "rockgrinder"),
                ProcessRecipeManager.rockGrinderRecipes);
    }

    @ZenMethod
    public static void removeRecipe(IItemStack output) {
        removeRecipe(new ProcessRecipe(Arrays.asList(CraftTweakerPlugin.toStack(output)), Collections.emptyList(), 0,
                "rockgrinder"), ProcessRecipeManager.rockGrinderRecipes);
    }

}
