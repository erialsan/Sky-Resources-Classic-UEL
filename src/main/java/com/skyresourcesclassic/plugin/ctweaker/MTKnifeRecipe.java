package com.skyresourcesclassic.plugin.ctweaker;

import com.skyresourcesclassic.recipe.ProcessRecipe;
import com.skyresourcesclassic.recipe.ProcessRecipeManager;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Arrays;
import java.util.Collections;

@ZenClass("mods.skyresourcesclassic.knife")
@ZenRegister
public class MTKnifeRecipe extends MTRecipeBase {

    @ZenMethod
    public static void addRecipe(IItemStack output, IItemStack input) {
        addRecipe(
                new ProcessRecipe(Arrays.asList(CraftTweakerPlugin.toStack(output)),
                        Arrays.asList(CraftTweakerPlugin.toStack(input)), 1, "knife"),
                ProcessRecipeManager.knifeRecipes);
    }

    @ZenMethod
    public static void removeRecipe(IItemStack output) {
        removeRecipe(new ProcessRecipe(Arrays.asList(CraftTweakerPlugin.toStack(output)), Collections.emptyList(), 0,
                "knife"), ProcessRecipeManager.knifeRecipes);
    }

}
