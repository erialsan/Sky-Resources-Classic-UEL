package com.skyresourcesclassic.technology.tile;

import com.skyresourcesclassic.base.IHeatSource;
import com.skyresourcesclassic.base.tile.TileGenericPower;
import com.skyresourcesclassic.technology.block.BlockPoweredHeater;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.energy.IEnergyStorage;

public class TilePoweredHeater extends TileGenericPower implements ITickable, IEnergyStorage, IHeatSource {
    public TilePoweredHeater() {
        super("poweredHeater", 100000, 2000, 0);
    }

    private int powerUsage = 120;

    @Override
    public void update() {
        if (!world.isRemote) {
            if (getEnergyStored() >= powerUsage && this.getRedstoneSignal() > 0) {
                internalExtractEnergy(powerUsage, false);
                world.setBlockState(getPos(),
                        world.getBlockState(getPos()).withProperty(BlockPoweredHeater.RUNNING, true), 3);
            } else
                world.setBlockState(getPos(),
                        world.getBlockState(getPos()).withProperty(BlockPoweredHeater.RUNNING, false), 3);

            this.markDirty();
        }
    }

    @Override
    public int getHeatValue() {
        if (getEnergyStored() >= powerUsage && this.getRedstoneSignal() > 0)
            return 30;
        return 0;
    }

    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
        return oldState.getBlock() != newState.getBlock();
    }
}
