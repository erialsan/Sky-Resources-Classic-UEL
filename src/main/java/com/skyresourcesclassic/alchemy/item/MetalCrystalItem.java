package com.skyresourcesclassic.alchemy.item;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.registry.ModCreativeTabs;
import net.minecraft.item.Item;

public class MetalCrystalItem extends Item {

    public MetalCrystalItem(String material) {
        super();

        setTranslationKey(References.ModID + "." + material + "_crystal");
        setRegistryName(material + "_crystal");
        setHasSubtypes(true);
        this.setCreativeTab(ModCreativeTabs.tabAlchemy);
    }
}
