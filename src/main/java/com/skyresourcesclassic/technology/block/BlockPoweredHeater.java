package com.skyresourcesclassic.technology.block;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.registry.ModCreativeTabs;
import com.skyresourcesclassic.technology.tile.TilePoweredHeater;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class BlockPoweredHeater extends BlockContainer {

    public static final PropertyBool RUNNING = PropertyBool.create("running");

    public BlockPoweredHeater(String name, float hardness,
                              float resistance) {
        super(Material.IRON);
        this.setUnlocalizedName(References.ModID + "." + name);
        this.setCreativeTab(ModCreativeTabs.tabTech);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setRegistryName(name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(RUNNING, false));
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TilePoweredHeater();
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state,
                                    EntityPlayer player, EnumHand hand, EnumFacing side, float hitX,
                                    float hitY, float hitZ) {
        if (!world.isRemote) {
            if (player.getHeldItemMainhand().isEmpty() && !player.isSneaking()) {
                List<ITextComponent> toSend = new ArrayList();

                TilePoweredHeater tile = (TilePoweredHeater) world.getTileEntity(pos);
                toSend.add(new TextComponentString(TextFormatting.RED + "FE Stored: " + tile.getEnergyStored()
                        + " / " + tile.getMaxEnergyStored()));

                for (ITextComponent text : toSend) {
                    player.sendMessage(text);
                }

            }
        }
        return true;
    }

    public int getMetaFromState(IBlockState state) {

        if (state.getValue(RUNNING) == true) {
            return 1;
        }

        return 0;
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]
                {RUNNING});
    }
}
