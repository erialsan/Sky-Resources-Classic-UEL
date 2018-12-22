package com.skyresourcesclassic;

import com.skyresourcesclassic.alchemy.item.ItemInfusionStone;
import com.skyresourcesclassic.technology.item.ItemRockGrinder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

public class ItemHelper {
    private static List<ItemStack> infusionStones = new ArrayList<>();

    public static List<ItemStack> getInfusionStones() {
        return infusionStones;
    }

    public static void addInfusionStone(ItemInfusionStone item) {
        infusionStones.add(new ItemStack(item));
    }

    private static List<ItemStack> rockGrinders = new ArrayList<>();

    public static List<ItemStack> getRockGrinders() {
        return rockGrinders;
    }

    public static void addRockGrinder(ItemRockGrinder item) {
        rockGrinders.add(new ItemStack(item));
    }

    private static List<ItemStack> knives = new ArrayList<>();

    public static List<ItemStack> getKnives() {
        return knives;
    }

    public static void addKnife(Item item) {
        knives.add(new ItemStack(item));
    }

    public static boolean itemStacksEqualOD(ItemStack stack1, ItemStack stack2) {
        if (stack1.isItemEqual(stack2))
            return true;

        if (!stack1.isEmpty() && !stack2.isEmpty() && stack1.getMetadata() == OreDictionary.WILDCARD_VALUE
                || stack2.getMetadata() == OreDictionary.WILDCARD_VALUE) {
            return stack1.getItem() == stack2.getItem();
        }
        return false;
    }
}
