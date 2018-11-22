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
    private static ArrayList<String> names = new ArrayList<String>();

    public MetalCrystalItem() {
        super();

        setUnlocalizedName(References.ModID + ".metal_crystal.");
        setRegistryName("metal_crystal");
        setHasSubtypes(true);
        this.setCreativeTab(ModCreativeTabs.tabAlchemy);

        itemList();
    }

    private void itemList() {
        for (int i = 0; i < ModFluids.crystalFluidInfos().length; i++) {
            names.add(ModFluids.getFluidInfo(i).name);
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName(stack) + names.get(stack.getItemDamage());
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item id, CreativeTabs creativeTab, NonNullList<ItemStack> list) {
        for (int i = 0; i < names.size(); i++)
            list.add(new ItemStack(id, 1, i));
    }

    public static ItemStack getStack(String name) {
        return new ItemStack(ModItems.metalCrystal, 1, names.indexOf(name));
    }

    public static ArrayList<String> getNames() {
        return names;
    }
}
