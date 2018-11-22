package com.skyresourcesclassic.plugin.ctweaker;

import com.skyresourcesclassic.recipe.ProcessRecipe;
import com.skyresourcesclassic.recipe.ProcessRecipeManager;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ZenClass("mods.skyresourcesclassic.combustion")
public class MTCombustionRecipe extends MTRecipeBase {

    @ZenMethod
    public static void addRecipe(IItemStack output, IItemStack[] input, int temperature) {
        List<Object> inputs = new ArrayList<>();
        inputs.addAll(Arrays.asList(CraftTweakerPlugin.toStacks(input)));
        addRecipe(new ProcessRecipe(Arrays.asList(CraftTweakerPlugin.toStack(output)), inputs, temperature, "combustion"),
                ProcessRecipeManager.combustionRecipes);
    }

    @ZenMethod
    public static void removeRecipe(IItemStack output) {
        removeRecipe(new ProcessRecipe(Arrays.asList(CraftTweakerPlugin.toStack(output)), Collections.emptyList(), 0, "combustion"),
                ProcessRecipeManager.combustionRecipes);
    }

}
