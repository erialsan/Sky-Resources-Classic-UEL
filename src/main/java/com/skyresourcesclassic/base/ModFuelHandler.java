package com.skyresourcesclassic.base;

import com.skyresourcesclassic.registry.ModBlocks;
import com.skyresourcesclassic.registry.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class ModFuelHandler implements IFuelHandler {
    @Override
    public int getBurnTime(ItemStack fuel) {

        if (fuel.isItemEqual(new ItemStack(ModItems.itemComponent[2])))
            return 2400;
        else if (fuel.isItemEqual(new ItemStack(ModBlocks.coalInfusedBlock)))
            return 24000;
        else if (fuel.isItemEqual(new ItemStack(ModBlocks.compressedCoalBlock)))
            return 24000;

        return 0;
    }

}
