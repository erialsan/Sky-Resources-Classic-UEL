package com.skyresourcesclassic.alchemy.item;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.registry.ModCreativeTabs;
import net.minecraft.item.Item;

public class DirtyGemItem extends Item {

    public DirtyGemItem(String gem) {
        super();

        setUnlocalizedName(References.ModID + ".dirty_" + gem);
        setRegistryName("dirty_" + gem);
        setHasSubtypes(true);
        this.setCreativeTab(ModCreativeTabs.tabTech);
    }
}
