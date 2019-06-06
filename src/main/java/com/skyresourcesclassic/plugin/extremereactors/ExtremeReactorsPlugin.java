package com.skyresourcesclassic.plugin.extremereactors;

import com.skyresourcesclassic.base.guide.SkyResourcesGuide;
import com.skyresourcesclassic.plugin.IModPlugin;
import com.skyresourcesclassic.recipe.ProcessRecipeManager;
import com.skyresourcesclassic.registry.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Arrays;

public class ExtremeReactorsPlugin implements IModPlugin {

    public void preInit() {

    }

    public void init() {
        Item dust = Item.REGISTRY.getObject(new ResourceLocation("bigreactors", "dustyellorium"));
        Item ingot = Item.REGISTRY.getObject(new ResourceLocation("bigreactors", "ingotyellorium"));

        ProcessRecipeManager.combustionRecipes.addRecipe(new ItemStack(dust, 5), 1200, new ArrayList<>(
                Arrays.asList(new ItemStack(Items.REDSTONE, 2), new ItemStack(Items.GLOWSTONE_DUST, 1), new ItemStack(ModItems.itemComponent[15], 2))));

        SkyResourcesGuide.addPage("extremereactors", "guide.skyresourcesclassic.misc", new ItemStack(ingot, 1));
    }

    public void initRenderers() {

    }

    public void postInit() {

    }
}
