package com.skyresourcesclassic.technology.item;

import java.util.ArrayList;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.registry.ModCreativeTabs;
import com.skyresourcesclassic.registry.ModItems;

import com.skyresourcesclassic.References;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TechItemComponent extends Item
{
	private static ArrayList<String> names = new ArrayList<String>();

	public static final String stoneCrushed = "stone_crushed";
	public static final String radioactiveMix = "radioactive_mix";
	public static final String frozenIronIngot = "frozen_ron_ingot";
	public static final String netherrackCrushed = "netherrack_rushed";

	public TechItemComponent()
	{
		super();

		setUnlocalizedName(References.ModID + ".tech_item_component.");
		setRegistryName("tech_item_component");
		setHasSubtypes(true);
		this.setCreativeTab(ModCreativeTabs.tabTech);

		itemList();
	}

	private void itemList()
	{
		names.add(0, stoneCrushed);
		names.add(1, radioactiveMix);
		names.add(2, frozenIronIngot);
		names.add(3, netherrackCrushed);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName(stack) + names.get(stack.getItemDamage());
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs creativeTab, NonNullList<ItemStack> list)
	{
		for (int i = 0; i < names.size(); i++)
			list.add(new ItemStack(id, 1, i));
	}

	public static ItemStack getStack(String name)
	{
		return new ItemStack(ModItems.techComponent, 1, names.indexOf(name));
	}

	public static ArrayList<String> getNames()
	{
		return names;
	}
}
