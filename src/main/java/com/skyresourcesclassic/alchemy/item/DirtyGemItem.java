package com.skyresourcesclassic.alchemy.item;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.registry.ModCreativeTabs;
import com.skyresourcesclassic.registry.ModItems;
import com.skyresourcesclassic.technology.item.GemRegisterInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;

public class DirtyGemItem extends Item {

    public DirtyGemItem(String gem) {
        super();

        setUnlocalizedName(References.ModID + ".dirty_"  + gem);
        setRegistryName("dirty_" + gem);
        setHasSubtypes(true);
        this.setCreativeTab(ModCreativeTabs.tabTech);
    }
}
