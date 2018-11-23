package com.skyresourcesclassic.base.item;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.registry.ModCreativeTabs;
import com.skyresourcesclassic.registry.ModItems;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

public class BaseItemComponent extends Item {
    private static ArrayList<String> names = new ArrayList<String>();

    public static final String woodHeatComp = "wood_heat_component";
    public static final String ironHeatComp = "iron_heat_component";
    public static final String plantMatter = "plant_matter";
    public static final String steelPowerComp = "steel_power_component";
    public static final String frozenIronComp = "frozen_iron_cooling_component";
    public static final String darkMatter = "dark_matter";
    public static final String enrichedBonemeal = "enriched_bonemeal";
    public static final String sawdust = "sawdust";

    public BaseItemComponent() {
        super();

        setUnlocalizedName(References.ModID + ".base_item_component.");
        setRegistryName("base_item_component");
        setHasSubtypes(true);
        this.setCreativeTab(ModCreativeTabs.tabMain);

        itemList();
    }

    private void itemList() {
        names.add(0, woodHeatComp);
        names.add(1, ironHeatComp);
        names.add(2, plantMatter);
        names.add(3, steelPowerComp);
        names.add(4, frozenIronComp);
        names.add(5, darkMatter);
        names.add(6, enrichedBonemeal);
        names.add(7, sawdust);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName(stack) + names.get(stack.getItemDamage());
    }

    public static ItemStack getStack(String name) {
        return new ItemStack(ModItems.baseComponent, 1, names.indexOf(name));
    }

    public static ArrayList<String> getNames() {
        return names;
    }

    public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand,
                                      EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.canPlayerEdit(pos.offset(facing), facing, playerIn.getHeldItem(hand))) {
            return EnumActionResult.FAIL;
        } else {
            if (playerIn.getHeldItem(hand).getMetadata() == names.indexOf(plantMatter)
                    || playerIn.getHeldItem(hand).getMetadata() == names.indexOf(enrichedBonemeal)) {
                if (applyBonemeal(playerIn.getHeldItem(hand), worldIn, pos, playerIn)) {
                    if (!worldIn.isRemote) {
                        worldIn.playEvent(2005, pos, 0);
                    }

                    return EnumActionResult.SUCCESS;
                }
            }

            return EnumActionResult.PASS;
        }
    }

    public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List list, boolean par4) {
        if (stack.getMetadata() == names.indexOf(plantMatter)) {
            list.add(TextFormatting.DARK_GRAY + "Acts as bonemeal");
            list.add(TextFormatting.DARK_GRAY + "2-4x as effective as normal bonemeal");
        } else if (stack.getMetadata() == names.indexOf(enrichedBonemeal)) {
            list.add(TextFormatting.DARK_GRAY + "2-4x as effective as normal bonemeal");
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs creativeTab, NonNullList<ItemStack> list) {
        if (isInCreativeTab(creativeTab))
            for (int i = 0; i < names.size(); i++)
                list.add(new ItemStack(this, 1, i));
    }

    public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos target, EntityPlayer player) {
        IBlockState iblockstate = worldIn.getBlockState(target);

        int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, worldIn, target, iblockstate,
                stack, EnumHand.MAIN_HAND);
        if (hook != 0)
            return hook > 0;

        if (iblockstate.getBlock() instanceof IGrowable) {
            IGrowable igrowable = (IGrowable) iblockstate.getBlock();

            for (int i = 0; i < worldIn.rand.nextInt(4) + 2; i++) {
                if (igrowable.canGrow(worldIn, target, iblockstate, worldIn.isRemote)) {
                    if (!worldIn.isRemote) {
                        if (igrowable.canUseBonemeal(worldIn, worldIn.rand, target, iblockstate)) {
                            igrowable.grow(worldIn, worldIn.rand, target, iblockstate);
                        }

                        stack.shrink(1);
                    }

                    return true;
                }
            }
        }

        return false;
    }
}
