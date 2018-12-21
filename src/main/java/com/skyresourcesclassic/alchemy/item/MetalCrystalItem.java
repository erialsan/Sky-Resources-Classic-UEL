package com.skyresourcesclassic.alchemy.item;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.registry.ModCreativeTabs;
import com.skyresourcesclassic.registry.ModFluids;
import com.skyresourcesclassic.registry.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;

public class MetalCrystalItem extends Item {

    public MetalCrystalItem(String material) {
        super();

        setUnlocalizedName(References.ModID + "." + material + "_crystal");
        setRegistryName(material + "_crystal");
        setHasSubtypes(true);
        this.setCreativeTab(ModCreativeTabs.tabAlchemy);
    }
}
