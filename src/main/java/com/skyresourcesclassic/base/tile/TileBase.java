package com.skyresourcesclassic.base.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public class TileBase extends TileEntity {
    private String name;

    public TileBase(String name) {
        this.name = name;
    }

    public ITextComponent getDisplayName() {
        return new TextComponentTranslation("container.skyresourcesclassic." + name);
    }

    private int redstoneSignal, prevRedstoneSignal;

    public boolean receivedPulse() {
        return getRedstoneSignal() > 0 && prevRedstoneSignal == 0;
    }

    private boolean canAcceptRedstone() {
        return true;
    }

    public int getRedstoneSignal() {

        updateRedstone();
        return redstoneSignal;
    }

    public void updateRedstone() {
        if (!world.isRemote) {
            prevRedstoneSignal = redstoneSignal;
            redstoneSignal = 0;
            if (canAcceptRedstone()) {
                for (EnumFacing dir : EnumFacing.VALUES) {
                    int redstoneSide = getWorld().getRedstonePower(getPos().offset(dir), dir);
                    redstoneSignal = Math.max(redstoneSignal, redstoneSide);
                }
            }
        }
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound nbtTag = new NBTTagCompound();
        this.writeToNBT(nbtTag);
        return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
        super.onDataPacket(net, packet);
        this.readFromNBT(packet.getNbtCompound());
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        writeToNBT(nbtTagCompound);
        return nbtTagCompound;
    }

    @Override
    public void handleUpdateTag(NBTTagCompound tag) {
        this.readFromNBT(tag);
    }

    @Override
    public void markDirty() {
        super.markDirty();
        if (world != null && !world.isRemote)
            world.notifyBlockUpdate(getPos(), world.getBlockState(getPos()), world.getBlockState(getPos()), 0);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        compound.setInteger("pSignal", prevRedstoneSignal);
        compound.setInteger("signal", redstoneSignal);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        prevRedstoneSignal = compound.getInteger("pSignal");
        redstoneSignal = compound.getInteger("signal");
    }
}
