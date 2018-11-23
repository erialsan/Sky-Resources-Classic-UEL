package com.skyresourcesclassic.jei;

import com.skyresourcesclassic.ItemHelper;
import com.skyresourcesclassic.References;
import com.skyresourcesclassic.jei.cauldronclean.CauldronCleanRecipeCategory;
import com.skyresourcesclassic.jei.combustion.CombustionRecipeCategory;
import com.skyresourcesclassic.jei.condenser.CondenserRecipeCategory;
import com.skyresourcesclassic.jei.condenser.CondenserRecipeHandler;
import com.skyresourcesclassic.jei.condenser.CondenserRecipeMaker;
import com.skyresourcesclassic.jei.crucible.CrucibleRecipeCategory;
import com.skyresourcesclassic.jei.freezer.FreezerRecipeCategory;
import com.skyresourcesclassic.jei.heatsources.HeatSourceHandler;
import com.skyresourcesclassic.jei.heatsources.HeatSourcesRecipeCategory;
import com.skyresourcesclassic.jei.infusion.InfusionRecipeCategory;
import com.skyresourcesclassic.jei.knife.KnifeRecipeCategory;
import com.skyresourcesclassic.jei.rockgrinder.RockGrinderRecipeCategory;
import com.skyresourcesclassic.jei.waterextractor.WaterExtractorRecipeCategory;
import com.skyresourcesclassic.recipe.ProcessRecipeManager;
import com.skyresourcesclassic.registry.ModBlocks;
import com.skyresourcesclassic.registry.ModItems;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.gui.Focus;
import mezz.jei.plugins.jei.JEIInternalPlugin;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

@mezz.jei.api.JEIPlugin
public class JEIPlugin implements IModPlugin {
    @Override
    public void onRuntimeAvailable(IJeiRuntime arg0) {

    }

    @Override
    public void register(IModRegistry registry) {
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        registry.addRecipeCategories(new InfusionRecipeCategory(jeiHelpers.getGuiHelper()),
                new CombustionRecipeCategory(jeiHelpers.getGuiHelper()),
                new RockGrinderRecipeCategory(jeiHelpers.getGuiHelper()),
                new KnifeRecipeCategory(jeiHelpers.getGuiHelper()),
                new CrucibleRecipeCategory(jeiHelpers.getGuiHelper()),
                new FreezerRecipeCategory(jeiHelpers.getGuiHelper()),
                new HeatSourcesRecipeCategory(jeiHelpers.getGuiHelper()),
                new WaterExtractorRecipeCategory(jeiHelpers.getGuiHelper()),
                new CauldronCleanRecipeCategory(jeiHelpers.getGuiHelper()),
                new CondenserRecipeCategory(jeiHelpers.getGuiHelper()));
        registry.addRecipeHandlers(new ProcessRecipeHandler(), new HeatSourceHandler(), new CondenserRecipeHandler());

        registry.addRecipes(ProcessRecipeManager.infusionRecipes.getRecipes());
        registry.addRecipes(ProcessRecipeManager.combustionRecipes.getRecipes());
        registry.addRecipes(ProcessRecipeManager.rockGrinderRecipes.getRecipes());
        registry.addRecipes(ProcessRecipeManager.crucibleRecipes.getRecipes());
        registry.addRecipes(ProcessRecipeManager.freezerRecipes.getRecipes());
        registry.addRecipes(ProcessRecipeManager.knifeRecipes.getRecipes());
        registry.addRecipes(HeatSourceHandler.getSources());
        registry.addRecipes(ProcessRecipeManager.waterExtractorExtractRecipes.getRecipes());
        registry.addRecipes(ProcessRecipeManager.waterExtractorInsertRecipes.getRecipes());
        if (ProcessRecipeManager.cauldronCleanRecipes.getRecipes().size() > 0)
            registry.addRecipes(ProcessRecipeManager.cauldronCleanRecipes.getRecipes());
        registry.addRecipes(CondenserRecipeMaker.getRecipes());

        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.combustionHeater, 1, 0),
                References.ModID + ":combustion");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.combustionHeater, 1, 1),
                References.ModID + ":combustion");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.combustionHeater, 1, 2),
                References.ModID + ":combustion");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.combustionHeater, 1, 3),
                References.ModID + ":combustion");
        registry.addRecipeCategoryCraftingItem(new ItemStack(Items.CAULDRON, 1, 0),
                References.ModID + ":cauldronclean");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.rockCleaner),
                References.ModID + ":cauldronclean");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.alchemicalCondenser, 1, 0),
                References.ModID + ":condenser");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.alchemicalCondenser, 1, 1),
                References.ModID + ":condenser");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.alchemicalCondenser, 1, 2),
                References.ModID + ":condenser");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.alchemicalCondenser, 1, 3),
                References.ModID + ":condenser");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.crucible, 1, 0), References.ModID + ":crucible");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.miniFreezer, 1, 0),
                References.ModID + ":freezer");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.ironFreezer, 1, 0),
                References.ModID + ":freezer");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModItems.waterExtractor),
                References.ModID + ":waterextractor");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.aqueousConcentrator),
                References.ModID + ":waterextractor");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.aqueousDeconcentrator),
                References.ModID + ":waterextractor");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.dirtFurnace), "minecraft.smelting");
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.dirtFurnace), "minecraft.fuel");
        for (ItemStack i : ItemHelper.getRockGrinders()) {
            registry.addRecipeCategoryCraftingItem(i, References.ModID + ":rockgrinder");
        }
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.rockCrusher), References.ModID + ":rockgrinder");
        for (ItemStack i : ItemHelper.getInfusionStones()) {
            registry.addRecipeCategoryCraftingItem(i, References.ModID + ":infusion");
        }
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.lifeInfuser), References.ModID + ":infusion");

        registry.addDescription(new ItemStack(ModItems.alchemyComponent, 1, 0), "jei.skyresourcesclassic.desc.cactusNeedle");
        registry.addDescription(new ItemStack(ModBlocks.blazePowderBlock, 1, 0),
                "jei.skyresourcesclassic.desc.blazePowderBlock");
        for (ItemStack i : ItemHelper.getKnives()) {
            registry.addRecipeCategoryCraftingItem(i, References.ModID + ":knife");
        }
    }

    public static void openRecipesGui(ItemStack stack) {
        IRecipesGui gui = JEIInternalPlugin.jeiRuntime.getRecipesGui();
        gui.show(new Focus(mezz.jei.api.recipe.IFocus.Mode.OUTPUT, stack));
    }

    @Override
    public void registerIngredients(IModIngredientRegistration imodingredientregistration) {

    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistry isubtyperegistry) {

    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration arg0) {
        // TODO Auto-generated method stub

    }
}
