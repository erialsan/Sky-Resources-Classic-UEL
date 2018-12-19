package com.skyresourcesclassic.alchemy.block;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.alchemy.tile.CondenserTile;
import com.skyresourcesclassic.base.block.IMetaBlockName;
import com.skyresourcesclassic.registry.ModCreativeTabs;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Locale;

public class CondenserBlock extends BlockContainer implements IMetaBlockName {
    public static final PropertyEnum<CondenserVariants> variant = PropertyEnum.create("variant",
            CondenserVariants.class);

    private String[] condenserTypes = new String[]{"stone", "iron", "steel", "dark_matter"};

    public CondenserBlock(String name, float hardness, float resistance) {
        super(Material.ROCK);
        this.setUnlocalizedName(References.ModID + "." + name);
        this.setCreativeTab(ModCreativeTabs.tabAlchemy);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setRegistryName(name);
    }

    @Override
    public void getSubBlocks(CreativeTabs par2, NonNullList<ItemStack> par3)
    {
        par3.add(new ItemStack(this, 1, 0));
        par3.add(new ItemStack(this, 1, 1));
        par3.add(new ItemStack(this, 1, 2));
        par3.add(new ItemStack(this, 1, 3));
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new CondenserTile();
    }

    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, variant);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(variant).ordinal();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        if (meta >= CondenserVariants.values().length || meta < 0) {
            meta = 0;
        }
        return getDefaultState().withProperty(variant, CondenserVariants.values()[meta]);
    }

    public enum CondenserVariants implements IStringSerializable {
        STONE, IRON, STEEL, DARKMATTER;

        @Override
        public String getName() {
            return name().toLowerCase(Locale.ROOT);
        }

    }

    @Override
    public String getSpecialName(ItemStack stack) {
        return condenserTypes[stack.getItemDamage()];
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
                                  EntityPlayer player) {
        return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
    }
}
