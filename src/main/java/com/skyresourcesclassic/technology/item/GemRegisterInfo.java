package com.skyresourcesclassic.technology.item;

import net.minecraft.item.ItemStack;

public class GemRegisterInfo {
    public String name;
    public int color;
    public float rarity;
    public ItemStack block;

    public GemRegisterInfo(String nameIn, int colorIn, float rarityIn, ItemStack itemStack) {
        name = nameIn;
        color = colorIn;
        rarity = rarityIn;
        block = itemStack;
    }
}
