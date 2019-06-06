package com.skyresourcesclassic.technology.gui.container;

import com.skyresourcesclassic.base.gui.ContainerBase;
import com.skyresourcesclassic.base.gui.SlotSpecial;
import com.skyresourcesclassic.technology.tile.TileCrucibleInserter;
import net.minecraft.inventory.IInventory;

public class ContainerCrucibleInserter extends ContainerBase {
    public ContainerCrucibleInserter(IInventory playerInv, TileCrucibleInserter te) {
        super(playerInv, te);

        this.addSlotToContainer(new SlotSpecial(tile.getInventory(), 0, 80, 53));
    }
}