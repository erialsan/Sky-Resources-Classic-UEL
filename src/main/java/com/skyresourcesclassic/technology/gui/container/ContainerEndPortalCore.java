package com.skyresourcesclassic.technology.gui.container;

import com.skyresourcesclassic.base.gui.ContainerBase;
import com.skyresourcesclassic.base.gui.SlotSpecial;
import com.skyresourcesclassic.technology.tile.TileEndPortalCore;
import net.minecraft.inventory.IInventory;

public class ContainerEndPortalCore extends ContainerBase {
    private int burnTime;

    public ContainerEndPortalCore(IInventory playerInv,
                                  TileEndPortalCore te) {
        super(playerInv, te);

        this.addSlotToContainer(new SlotSpecial(tile.getInventory(), 0, 80, 53));
    }
}
