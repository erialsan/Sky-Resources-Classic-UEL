package com.skyresourcesclassic.jei.heatsources;

import com.skyresourcesclassic.References;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;

import java.util.List;

public class HeatSourcesRecipeCategory extends BlankRecipeCategory
{
	private static final int slotInputStack = 0;
	private final IDrawable background;

	private final String localizedName = I18n.translateToLocalFormatted("jei.skyresourcesclassic.recipe.heatsources");

	public HeatSourcesRecipeCategory(IGuiHelper guiHelper)
	{
		super();
		background = guiHelper.createDrawable(
				new ResourceLocation(References.ModID, "textures/gui/jei/concentrator.png"), 20, 0, 70, 25);
	}

	@Override
	public void drawExtras(Minecraft minecraft)
	{
	}

	@Override
	public IDrawable getBackground()
	{
		return background;
	}

	@Override
	public String getTitle()
	{
		return localizedName;
	}

	@Override
	public String getUid()
	{
		return References.ModID + ":heatsources";
	}

	@Override
	public void setRecipe(IRecipeLayout layout, IRecipeWrapper wrapper, IIngredients ingredients)
	{
		layout.getItemStacks().init(slotInputStack, true, 1, 5);

		List<List<ItemStack>> inputs = ingredients.getInputs(ItemStack.class);
		if (inputs != null && inputs.size() > 0)
		{
			layout.getItemStacks().set(slotInputStack, inputs.get(0));
		}

	}

	@Override
	public String getModName()
	{
		return References.ModName;
	}

}
