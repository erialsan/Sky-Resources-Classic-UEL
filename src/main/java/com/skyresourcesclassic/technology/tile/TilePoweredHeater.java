package com.skyresourcesclassic.technology.tile;

import com.skyresourcesclassic.base.IHeatSource;
import com.skyresourcesclassic.base.tile.TileGenericPower;
import com.skyresourcesclassic.technology.block.BlockHeater;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.energy.IEnergyStorage;

public class TilePoweredHeater extends TileGenericPower implements ITickable, IEnergyStorage, IHeatSource {
    public TilePoweredHeater() {
        super("powered_heater", 100000, 2000, 0);
    }

    private int getPowerUsage() {
        return 120 * getHeat() / 30;
    }

    @Override
    public void update() {
        if (!world.isRemote) {
            if (getEnergyStored() >= getPowerUsage() && getRedstoneSignal() > 0) {
                internalExtractEnergy(getPowerUsage(), false);
                world.setBlockState(getPos(),
                        world.getBlockState(getPos()).withProperty(BlockHeater.RUNNING, true), 3);
            } else
                world.setBlockState(getPos(),
                        world.getBlockState(getPos()).withProperty(BlockHeater.RUNNING, false), 3);

            markDirty();
        }
    }

    @Override
    public int getHeatValue() {
        return getEnergyStored() >= getPowerUsage() && getRedstoneSignal() > 0 ? getHeat() : 0;
    }

    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
        return oldState.getBlock() != newState.getBlock();
    }

    private int getHeat() {
        return getTier() == 3 ? 30 : 120;
    }

    private int getTier() {
        return ((BlockHeater) getWorld().getBlockState(pos).getBlock()).getTier();
    }
}