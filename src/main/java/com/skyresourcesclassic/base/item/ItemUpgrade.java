package com.skyresourcesclassic.base.item;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.registry.ModCreativeTabs;
import com.skyresourcesclassic.registry.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

public class ItemUpgrade extends Item {
    private static ArrayList<String> names = new ArrayList<String>();

    public static final String speed1 = "speed1";
    public static final String speed2 = "speed2";
    public static final String speed3 = "speed3";
    public static final String productivity = "productivity";
    public static final String efficiency1 = "efficiency1";
    public static final String efficiency2 = "efficiency2";
    public static final String efficiency3 = "efficiency3";

    public ItemUpgrade() {
        super();

        setUnlocalizedName(References.ModID + ".upgrade.");
        setRegistryName("upgrade");
        setHasSubtypes(true);
        this.setCreativeTab(ModCreativeTabs.tabMain);
        this.maxStackSize = 4;

        itemList();
    }

    private void itemList() {
        names.add(speed1);
        names.add(speed2);
        names.add(speed3);
        names.add(productivity);
        names.add(efficiency1);
        names.add(efficiency2);
        names.add(efficiency3);
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
        return new ItemStack(ModItems.baseComponent, 1, names.indexOf(name));
    }

    public static ArrayList<String> getNames() {
        return names;
    }

    public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List list, boolean par4) {
        if (stack.getMetadata() == names.indexOf(speed1)) {
            list.add(TextFormatting.DARK_GRAY + "Machines run 25% faster");
            list.add(TextFormatting.RED + "Machines use 50% more energy");
        } else if (stack.getMetadata() == names.indexOf(speed2)) {
            list.add(TextFormatting.DARK_GRAY + "Machines run 50% faster");
            list.add(TextFormatting.RED + "Machines use 100% more energy");
        } else if (stack.getMetadata() == names.indexOf(speed3)) {
            list.add(TextFormatting.DARK_GRAY + "Machines run 100% faster");
            list.add(TextFormatting.RED + "Machines use 200% more energy");
        } else if (stack.getMetadata() == names.indexOf(productivity)) {
            list.add(TextFormatting.DARK_GRAY + "Machines have 2x output");
            list.add(TextFormatting.RED + "Machines use 100% more energy");
        } else if (stack.getMetadata() == names.indexOf(efficiency1)) {
            list.add(TextFormatting.DARK_GRAY + "Machines use 75% energy");
        } else if (stack.getMetadata() == names.indexOf(efficiency2)) {
            list.add(TextFormatting.DARK_GRAY + "Machines use 50% energy");
        } else if (stack.getMetadata() == names.indexOf(efficiency3)) {
            list.add(TextFormatting.DARK_GRAY + "Machines use 25% energy");
        }
    }

    public float getSpeedMultiplier(ItemStack stack) {
        if (stack.getMetadata() == names.indexOf(speed1))
            return 1.25f;
        else if (stack.getMetadata() == names.indexOf(speed2))
            return 1.5f;
        else if (stack.getMetadata() == names.indexOf(speed3))
            return 2f;

        return 1f;
    }

    public float getProductionMultiplier(ItemStack stack) {
        if (stack.getMetadata() == names.indexOf(productivity))
            return 2f;

        return 1f;
    }

    public float getEnergyMultiplier(ItemStack stack) {
        if (stack.getMetadata() == names.indexOf(speed1))
            return 1.5f;
        else if (stack.getMetadata() == names.indexOf(speed2))
            return 2f;
        else if (stack.getMetadata() == names.indexOf(speed3))
            return 3f;
        else if (stack.getMetadata() == names.indexOf(productivity))
            return 2f;
        else if (stack.getMetadata() == names.indexOf(efficiency1))
            return .75f;
        else if (stack.getMetadata() == names.indexOf(efficiency2))
            return .5f;
        else if (stack.getMetadata() == names.indexOf(efficiency3))
            return .25f;

        return 1f;
    }
}
