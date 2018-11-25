package com.skyresourcesclassic.plugin.ctweaker;

import com.skyresourcesclassic.plugin.IModPlugin;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.item.IngredientStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.oredict.IOreDictEntry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.util.ArrayList;
import java.util.List;

public class CraftTweakerPlugin implements IModPlugin {
    public void preInit() {

    }

    public void init() {
    }

    public void initRenderers() {

    }

    public void postInit() {

    }

    public static ItemStack toStack(IItemStack iStack) {
        return CraftTweakerMC.getItemStack(iStack);
    }

    public static ItemStack[] toStacks(IItemStack[] iStacks) {
        List<ItemStack> stacks = new ArrayList<ItemStack>();
        for (IItemStack is : iStacks) {
            stacks.add(toStack(is));
        }
        return stacks.toArray(new ItemStack[stacks.size()]);
    }

    public static Object toObject(IIngredient iStack) {
        if (iStack == null)
            return null;
        else {
            if (iStack instanceof IOreDictEntry)
                return ((IOreDictEntry) iStack).getName();
            else if (iStack instanceof IItemStack)
                return CraftTweakerMC.getItemStack((IItemStack) iStack);
            else if (iStack instanceof IngredientStack) {
                IIngredient ingr = ReflectionHelper.getPrivateValue(
                        IngredientStack.class, (IngredientStack) iStack,
                        "ingredient");
                return toObject(ingr);
            } else
                return null;
        }
    }

    public static Object[] toObjects(IIngredient[] iStacks) {
        List<Object> stacks = new ArrayList<Object>();
        for (IIngredient is : iStacks) {
            stacks.add(toObject(is));
        }
        return stacks.toArray();
    }

    public static FluidStack toFluidStack(ILiquidStack iStack) {
        return CraftTweakerMC.getLiquidStack(iStack);
    }
}
