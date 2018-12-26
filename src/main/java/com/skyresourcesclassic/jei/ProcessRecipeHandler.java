package com.skyresourcesclassic.jei;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.recipe.ProcessRecipe;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class ProcessRecipeHandler implements IRecipeHandler<ProcessRecipe> {
    public ProcessRecipeHandler() {
    }

    @Override
    public Class<ProcessRecipe> getRecipeClass() {
        return ProcessRecipe.class;
    }

    @Override
    public IRecipeWrapper getRecipeWrapper(ProcessRecipe recipe) {
        return new ProcessRecipeJEI(recipe);
    }

    @Override
    public boolean isRecipeValid(ProcessRecipe recipe) {
        return true;
    }

    @Override
    public String getRecipeCategoryUid(ProcessRecipe recipe) {
        return References.ModID + ":" + recipe.getRecipeType().split("-")[0];
    }

}
