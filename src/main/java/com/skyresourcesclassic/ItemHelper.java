package com.skyresourcesclassic;

import com.skyresourcesclassic.alchemy.item.ItemInfusionStone;
import com.skyresourcesclassic.technology.item.ItemRockGrinder;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

public class ItemHelper {
    private static List<ItemStack> infusionStones = new ArrayList<ItemStack>();

    public static List<ItemStack> getInfusionStones() {
        return infusionStones;
    }

    public static void addInfusionStone(ItemInfusionStone item) {
        infusionStones.add(new ItemStack(item));
    }

    private static List<ItemStack> rockGrinders = new ArrayList<ItemStack>();

    public static List<ItemStack> getRockGrinders() {
        return rockGrinders;
    }

    public static void addRockGrinder(ItemRockGrinder item) {
        rockGrinders.add(new ItemStack(item));
    }

    public static IBlockState getBlockStateFromStack(ItemStack stack) {
        int meta = stack.getMetadata();
        if (!(stack.getItem() instanceof ItemBlock))
            return null;

        Block block = ((ItemBlock) stack.getItem()).getBlock();

        return block.getStateFromMeta(meta);
    }

    private static List<ItemStack> knives = new ArrayList<ItemStack>();

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
