package com.skyresourcesclassic.jei.condenser;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.alchemy.fluid.FluidRegisterInfo;
import com.skyresourcesclassic.registry.ModBlocks;
import com.skyresourcesclassic.registry.ModFluids;
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

import java.util.ArrayList;
import java.util.List;

public class CondenserRecipeCategory implements IRecipeCategory {
    private static final int slotInputFluid = 0;
    private static final int slotOutput = 1;
    private static final int slotCondenser = 2;
    public static final String UUID = References.ModID + ":condenser";

    private final IDrawable background;

    private final String localizedName = I18n.translateToLocalFormatted("jei.skyresourcesclassic.recipe.condenser");

    public CondenserRecipeCategory(IGuiHelper guiHelper) {
        super();
        background = guiHelper.createDrawable(new ResourceLocation(References.ModID, "textures/gui/jei/condenser.png"),
                0, 0, 86, 50);
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
        layout.getFluidStacks().init(slotInputFluid, true, 2, 18);
        layout.getItemStacks().init(slotOutput, false, 64, 28);
        layout.getItemStacks().init(slotCondenser, true, 1, 35);

        List<List<FluidStack>> inputs = ingredients.getInputs(FluidStack.class);
        layout.getFluidStacks().set(slotInputFluid, inputs.get(0));

        List<ItemStack> condensers = new ArrayList();
        if (ModFluids.getFluidInfo(
                ModFluids.crystalFluids.indexOf(inputs.get(0).get(0).getFluid())).type == FluidRegisterInfo.CrystalFluidType.NORMAL) {
            condensers.add(new ItemStack(ModBlocks.alchemicalCondenser[0]));
        }
        for (int i = 1; i < ModBlocks.alchemicalCondenser.length; i++)
            condensers.add(new ItemStack(ModBlocks.alchemicalCondenser[i]));
        List<List<ItemStack>> outputs = ingredients.getOutputs(ItemStack.class);
        layout.getItemStacks().set(slotOutput, outputs.get(0));
        layout.getItemStacks().set(slotCondenser, condensers);
    }

    @Override
    public String getModName() {
        return References.ModName;
    }

}
