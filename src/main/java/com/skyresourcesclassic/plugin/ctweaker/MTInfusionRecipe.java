package com.skyresourcesclassic.plugin.ctweaker;

import com.skyresourcesclassic.recipe.ProcessRecipe;
import com.skyresourcesclassic.recipe.ProcessRecipeManager;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import net.minecraft.item.ItemBlock;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ZenClass("mods.skyresourcesclassic.infusion")
@ZenRegister
public class MTInfusionRecipe extends MTRecipeBase {

    @ZenMethod
    public static void addRecipe(IItemStack output, IItemStack inputStack, IItemStack inputBlock, int health) {
        if (!(CraftTweakerPlugin.toStack(inputBlock).getItem() instanceof ItemBlock)) {
            CraftTweakerAPI.logError("Input block is not block. Did not add recipe.");
            return;
        }
        List<Object> inputs = new ArrayList<>();
        inputs.addAll(Arrays.asList(CraftTweakerPlugin.toStack(inputStack), CraftTweakerPlugin.toStack(inputBlock)));
        addRecipe(
                new ProcessRecipe(Arrays.asList(CraftTweakerPlugin.toStack(output)), inputs, health, "infusion"),
                ProcessRecipeManager.infusionRecipes);
    }

    @ZenMethod
    public static void removeRecipe(IItemStack output) {
        removeRecipe(new ProcessRecipe(Arrays.asList(CraftTweakerPlugin.toStack(output)), Collections.emptyList(), 0,
                "infusion"), ProcessRecipeManager.infusionRecipes);
    }

}
