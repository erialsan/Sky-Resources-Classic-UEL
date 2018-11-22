package com.skyresourcesclassic.base.item;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.registry.ModCreativeTabs;
import net.minecraft.item.ItemFood;

public class ModItemFood extends ItemFood {

    public ModItemFood(int amount, float saturation, boolean isWolfFood,
                       String unlocalizedName, String registryName) {
        super(amount, saturation, isWolfFood);
        this.setUnlocalizedName(References.ModID + "." + unlocalizedName);
        setRegistryName(registryName);
        this.setCreativeTab(ModCreativeTabs.tabMain);
    }

}
