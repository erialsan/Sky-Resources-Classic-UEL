package com.skyresourcesclassic.base.block;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.registry.ModCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BaseBlock extends Block {

    public BaseBlock(Material material, String name, float hardness, float resistance,
                     SoundType stepSound) {
        super(material);
        this.setTranslationKey(References.ModID + "." + name);
        this.setCreativeTab(ModCreativeTabs.tabMain);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setRegistryName(name);
        this.setSoundType(stepSound);
    }
}
