package com.skyresourcesclassic.technology.tile;

import com.skyresourcesclassic.base.tile.TileItemInventory;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;

public class TileQuickDropper extends TileItemInventory implements ITickable {
    public TileQuickDropper() {
        super("quick_dropper", 1);
    }

    @Override
    public void update() {
        if (!world.isRemote) {
            updateRedstone();
            if (getRedstoneSignal() == 0 && world.isAirBlock(pos.down())
                    && !getInventory().getStackInSlot(0).isEmpty()) {
                EntityItem item = new EntityItem(world, pos.down().getX() + 0.5f, pos.down().getY() + 0.5f,
                        pos.down().getZ() + 0.5f, getInventory().getStackInSlot(0));
                item.motionY = 0;
                item.motionX = 0;
                item.motionZ = 0;
                world.spawnEntity(item);
                getInventory().setStackInSlot(0, ItemStack.EMPTY);
            }
            markDirty();
        }
    }
}
