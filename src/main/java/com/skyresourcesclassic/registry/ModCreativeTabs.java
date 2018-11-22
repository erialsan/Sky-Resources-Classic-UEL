package com.skyresourcesclassic.registry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModCreativeTabs {

    public static CreativeTabs tabMain = new CreativeTabs(
            "skyresourcesclassic.tabMain") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.ironKnife);
        }
    };

    public static CreativeTabs tabAlchemy = new CreativeTabs(
            "skyresourcesclassic.tabAlchemy") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.sandstoneInfusionStone);
        }
    };

    public static CreativeTabs tabTech = new CreativeTabs(
            "skyresourcesclassic.tabTech") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(ModBlocks.combustionHeater);
        }
    };
}
