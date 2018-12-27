package com.skyresourcesclassic.jei.waterextractor;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.base.item.ItemWaterExtractor;
import com.skyresourcesclassic.registry.ModItems;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;

public class WaterExtractorRecipeCategory implements IRecipeCategory {
    private static final int slotInputStack = 0;
    private static final int slotInputExtractor = 1;
    private static final int slotOutput = 2;
    private static final int slotInputFluid = 3;
    private static final int slotOutputFluid = 4;
    public static final String UUID = References.ModID + ":waterextractor";

    private final IDrawable background;

    private final String localizedName = I18n.translateToLocalFormatted(
            "jei.skyresourcesclassic.recipe.waterextractor");

    public WaterExtractorRecipeCategory(IGuiHelper guiHelper) {
        super();
        background = guiHelper
                .createDrawable(
                        new ResourceLocation(References.ModID,
                                "textures/gui/jei/extractor.png"),
                        0, 0, 150, 50);
    }

    @Override
    public void drawExtras(Minecraft minecraft) {
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public String getTitle() {
        return localizedName;
    }

    @Override
    public String getUid() {
        return UUID;
    }

    @Override
    public void setRecipe(IRecipeLayout layout, IRecipeWrapper wrapper, IIngredients ingredients) {
        layout.getItemStacks().init(slotInputExtractor, true, 32, 1);
        layout.getItemStacks().init(slotInputStack, true, 53, 29);
        layout.getItemStacks().init(slotOutput, false, 106, 15);
        layout.getFluidStacks().init(slotInputFluid, false, 3, 4, 14, 42,
                ItemWaterExtractor.maxAmount, true, null);
        layout.getFluidStacks().init(slotOutputFluid, false, 132, 4, 14, 42,
                ItemWaterExtractor.maxAmount, false, null);

        List<List<ItemStack>> inputs = ingredients.getInputs(ItemStack.class);
        List<List<FluidStack>> finputs = ingredients.getInputs(FluidStack.class);
        layout.getItemStacks().set(slotInputStack,
                inputs.get(0));
        layout.getItemStacks().set(slotInputExtractor,
                new ItemStack(ModItems.waterExtractor));
        List<List<ItemStack>> outputs = ingredients.getOutputs(ItemStack.class);
        List<List<FluidStack>> foutputs = ingredients.getOutputs(FluidStack.class);
        layout.getItemStacks().set(slotOutput, outputs.get(0));
        if (finputs != null && finputs.size() > 0)
            layout.getFluidStacks().set(slotInputFluid, finputs.get(0));
        if (foutputs != null && foutputs.size() > 0)
            layout.getFluidStacks().set(slotOutputFluid, foutputs.get(0));
    }

    @Override
    public String getModName() {
        return References.ModName;
    }

}
