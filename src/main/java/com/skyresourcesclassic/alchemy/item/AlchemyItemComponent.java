package com.skyresourcesclassic.alchemy.item;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.registry.ModCreativeTabs;
import com.skyresourcesclassic.registry.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;

public class AlchemyItemComponent extends Item {
    private static ArrayList<String> names = new ArrayList<String>();

    public static final String cactusNeedle = "cactus_needle";
    public static final String coalAlchemical = "coal_alchemical";
    public static final String dustAlchemical = "dust_alchemical";
    public static final String diamondAlchemical = "diamond_alchemical";
    public static final String goldIngotAlchemical = "gold_ingot_alchemical";
    public static final String goldNeedleAlchemical = "gold_needle_alchemical";

    public AlchemyItemComponent() {
        super();

        setUnlocalizedName(References.ModID + ".alchemy_item_component.");
        setRegistryName("alchemy_item_component");
        setHasSubtypes(true);
        this.setCreativeTab(ModCreativeTabs.tabAlchemy);

        itemList();
    }

    private void itemList() {
        names.add(0, cactusNeedle);
        names.add(1, coalAlchemical);
        names.add(2, dustAlchemical);
        names.add(3, diamondAlchemical);
        names.add(4, goldIngotAlchemical);
        names.add(5, goldNeedleAlchemical);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName(stack)
                + names.get(stack.getItemDamage());
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item id, CreativeTabs tab, NonNullList<ItemStack> list) {
        for (int i = 0; i < names.size(); i++)
            list.add(new ItemStack(id, 1, i));
    }

    public static ItemStack getStack(String name) {
        return new ItemStack(ModItems.alchemyComponent, 1, names.indexOf(name));
    }

    public static ArrayList<String> getNames() {
        return names;
    }
}
