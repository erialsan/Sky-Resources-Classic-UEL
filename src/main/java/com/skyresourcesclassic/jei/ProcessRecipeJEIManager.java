package com.skyresourcesclassic.jei;

import com.skyresourcesclassic.recipe.ProcessRecipe;
import com.skyresourcesclassic.recipe.ProcessRecipeManager;
import mezz.jei.api.IGuiHelper;

import java.util.ArrayList;
import java.util.List;

public class ProcessRecipeJEIManager {
    public static <T extends ProcessRecipeJEI> List<T> getRecipes(Class<T> clazz, IGuiHelper guiHelper,
                                                                  String type) {
        List<T> recipes = new ArrayList<>();
        for (ProcessRecipe recipe : ProcessRecipeManager.getManagerFromType(type).getRecipes()) {
            recipes.add(createObject(clazz, guiHelper, recipe));
        }
        return recipes;
    }

    private static <T extends ProcessRecipeJEI> T createObject(Class<T> clazz, IGuiHelper guiHelper,
                                                               ProcessRecipe recipe) {
        try {
            return clazz.getDeclaredConstructor(IGuiHelper.class, ProcessRecipe.class).newInstance(guiHelper, recipe);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
