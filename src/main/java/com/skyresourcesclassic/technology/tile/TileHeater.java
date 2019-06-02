package com.skyresourcesclassic.technology.tile;

import com.skyresourcesclassic.base.IHeatSource;
import com.skyresourcesclassic.base.tile.TileItemInventory;
import com.skyresourcesclassic.technology.block.BlockHeater;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileHeater extends TileItemInventory implements ITickable, IHeatSource {
    public TileHeater() {
        super("heater", 1, null, new Integer[]{0});
    }

    public int fuelBurnTime = 0;
    public int currentItemBurnTime = 0;

    private int getTier() {
        return ((BlockHeater) getWorld().getBlockState(pos).getBlock()).getTier();
    }

    @Override
    public void update() {
        if (!world.isRemote) {
            if (fuelBurnTime > 0 && getRedstoneSignal() > 0) {
                fuelBurnTime--;
                world.setBlockState(getPos(),
                        world.getBlockState(getPos()).withProperty(BlockHeater.RUNNING, true), 3);
            } else
                world.setBlockState(getPos(),
                        world.getBlockState(getPos()).withProperty(BlockHeater.RUNNING, false), 3);

            if (getRedstoneSignal() > 0) {
                if (fuelBurnTime > 0 || this.getInventory().getStackInSlot(0) != ItemStack.EMPTY) {
                    if (fuelBurnTime == 0
                            && isValidFuel(getInventory().getStackInSlot(0))) {
                        this.currentItemBurnTime = this.fuelBurnTime = getFuelBurnTime(getInventory().getStackInSlot(0));

                        if (fuelBurnTime > 0) {
                            if (this.getInventory().getStackInSlot(0) != ItemStack.EMPTY) {
                                this.getInventory().getStackInSlot(0).shrink(1);

                                if (this.getInventory().getStackInSlot(0).getCount() == 0) {
                                    this.getInventory().setStackInSlot(0, getInventory().getStackInSlot(0).getItem()
                                            .getContainerItem(getInventory().getStackInSlot(0)));
                                }
                            }
                        }
                    }
                }
            }
            this.markDirty();
        }
    }

    private int getFuelBurnTime(ItemStack stack) {
        return TileEntityFurnace.getItemBurnTime(stack) * 5 / getHeat();
    }

    private boolean isValidFuel(ItemStack stack) {
        return !(TileEntityFurnace.getItemBurnTime(stack) <= 0 || getFuelBurnTime(stack) <= 0);
    }

    @Override
    public int getHeatValue() {
        if (fuelBurnTime > 0 && this.getRedstoneSignal() > 0)
            return getHeat();
        return 0;
    }

    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
        return oldState.getBlock() != newState.getBlock();
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        compound.setInteger("fuel", fuelBurnTime);
        compound.setInteger("item", currentItemBurnTime);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        fuelBurnTime = compound.getInteger("fuel");
        currentItemBurnTime = compound.getInteger("item");
    }

    private int getHeat() {
        if (getTier() == 1)
            return 5;
        else
            return 10;
    }
}
