package com.skyresourcesclassic.base.item;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.recipe.ProcessRecipe;
import com.skyresourcesclassic.recipe.ProcessRecipeManager;
import com.skyresourcesclassic.registry.ModCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemWaterExtractor extends Item implements IFluidHandler {
    public static final int maxAmount = 4000;

    private FluidTank tank;

    public static final String[] extractorIcons = new String[]{"empty", "full1", "full2", "full3", "full4", "full5",
            "full6"};

    public ItemWaterExtractor() {
        this.maxStackSize = 1;
        this.setCreativeTab(ModCreativeTabs.tabMain);
        tank = new FluidTank(new FluidStack(FluidRegistry.WATER, 0), maxAmount);
        setTranslationKey(References.ModID + ".water_extractor");
        setRegistryName("water_extractor");
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BOW;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 70000;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        player.setActiveHand(hand);
        return new ActionResult(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase entity, int timeLeft) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            if (!world.isRemote && timeLeft <= getMaxItemUseDuration(stack) - 25) {
                readFromNBT(stack);
                Vec3d vec3d = player.getPositionVector().add(0, player.eyeHeight, 0);
                Vec3d vec3d1 = player.getLookVec();
                Vec3d vec3d2 = vec3d.add(vec3d1.x * 5, vec3d1.y * 5, vec3d1.z * 5);
                RayTraceResult rayTrace = world.rayTraceBlocks(vec3d, vec3d2, false, false, true);

                if ((rayTrace != null)) {
                    BlockPos pos = rayTrace.getBlockPos();

                    EnumFacing blockHitSide = rayTrace.sideHit;

                    Block block = world.getBlockState(pos).getBlock();

                    ProcessRecipe recipe = ProcessRecipeManager.waterExtractorExtractRecipes.getRecipe(
                            new ItemStack(block), 0, false, false);

                    if (recipe != null) {
                        for (int x = -1; x <= 1; x++) {
                            for (int y = -1; y <= 1; y++) {
                                for (int z = -1; z <= 1; z++) {
                                    BlockPos blockPos = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
                                    Block radiusBlock = world.getBlockState(blockPos).getBlock();
                                    if (block == radiusBlock) {
                                        ProcessRecipe radiusBlockRecipe = ProcessRecipeManager.waterExtractorExtractRecipes.getRecipe(
                                                new ItemStack(radiusBlock, 1, radiusBlock.getMetaFromState(world.getBlockState(blockPos))), 0, false, false);
                                        if (radiusBlockRecipe != null) {
                                            IBlockState recipeOut = Block.getBlockFromItem(radiusBlockRecipe.getOutputs().get(0).getItem())
                                                    .getStateFromMeta(radiusBlockRecipe.getOutputs().get(0).getMetadata());
                                            tank.fill(recipe.getFluidOutputs().get(0).copy(), true);
                                            writeToNBT(stack);
                                            world.setBlockState(blockPos, radiusBlockRecipe.getOutputs().get(0) == ItemStack.EMPTY
                                                    ? Blocks.AIR.getDefaultState() : recipeOut, 3);
                                        }
                                    }
                                }
                            }
                        }
                        world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.NEUTRAL,
                                1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F));
                        return;
                    }
                    if (world.getBlockState(pos.add(blockHitSide.getDirectionVec())) == Blocks.WATER.getDefaultState()
                            && getCompound(stack).getInteger("amount") < maxAmount) {
                        world.setBlockToAir(pos.add(blockHitSide.getDirectionVec()));
                        tank.fill(new FluidStack(FluidRegistry.WATER, 1000), true);
                        writeToNBT(stack);
                        world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.NEUTRAL,
                                1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F));
                    }
                }
            }
        }
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer playerIn, World world, BlockPos pos, EnumHand hand, EnumFacing side,
                                      float hitX, float hitY, float hitZ) {
        IBlockState iblockstate = world.getBlockState(pos);
        Block block = iblockstate.getBlock();
        ItemStack stack = playerIn.getHeldItem(hand);
        readFromNBT(stack);
        if (tank.getFluid() == null)
            return EnumActionResult.FAIL;
        if (world.getTileEntity(pos) instanceof IFluidHandler) {
            IFluidHandler tile = (IFluidHandler) world.getTileEntity(pos);
            tile.fill(tank.getFluid(), true);
            writeToNBT(stack);
            return EnumActionResult.SUCCESS;
        }

        ProcessRecipe recipe = ProcessRecipeManager.waterExtractorInsertRecipes.getRecipe(new ArrayList<>(
                        Arrays.asList(new ItemStack(block),
                                tank.getFluid().copy())),
                0, false, false);

        if (recipe != null) {
            IBlockState recipeOut = Block.getBlockFromItem(recipe.getOutputs().get(0).getItem())
                    .getDefaultState();
            world.setBlockState(pos, recipeOut, 3);
            tank.drain(new FluidStack(FluidRegistry.WATER, recipe.getFluidInputs().get(0).amount), true);
            writeToNBT(stack);
            world.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ,
                    SoundEvents.ENTITY_PLAYER_SPLASH, SoundCategory.NEUTRAL, 1.0F,
                    1.0F / (itemRand.nextFloat() * 0.4F + 1.2F));

            return EnumActionResult.SUCCESS;
        }

        // Place water
        if (tank.getFluidAmount() >= 1000 && playerIn.isSneaking()) {
            if (block == Blocks.SNOW_LAYER && iblockstate.getValue(BlockSnow.LAYERS).intValue() < 1) {
                side = EnumFacing.UP;
            } else if (!block.isReplaceable(world, pos)) {
                pos = pos.offset(side);
            }

            if (!playerIn.canPlayerEdit(pos, side, stack) || stack.getCount() == 0) {
                return EnumActionResult.FAIL;
            } else {
                if (FluidUtil.tryPlaceFluid(playerIn, world, pos, tank, tank.getFluid())) {
                    writeToNBT(stack);
                    return EnumActionResult.SUCCESS;
                }

                return EnumActionResult.FAIL;
            }
        }
        return EnumActionResult.FAIL;
    }

    private NBTTagCompound getCompound(ItemStack stack) {
        NBTTagCompound com = stack.getTagCompound();
        if (com == null)
            onCreated(stack, null, null);
        com = stack.getTagCompound();

        return com;
    }

    @Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
        itemStack.setTagCompound(new NBTTagCompound());
        readFromNBT(itemStack);
    }

    @Override
    public IFluidTankProperties[] getTankProperties() {
        return tank.getTankProperties();
    }

    @Override
    public int fill(FluidStack resource, boolean doFill) {
        if (resource != null) {
            int filled = tank.fill(resource, doFill);

            return filled;
        }

        return 0;
    }

    @Override
    public FluidStack drain(FluidStack resource, boolean doDrain) {
        if (resource != null) {
            return tank.drain(resource.amount, doDrain);
        }

        return null;
    }

    @Override
    public FluidStack drain(int maxDrain, boolean doDrain) {
        return tank.drain(maxDrain, doDrain);
    }

    public FluidTank getTank() {
        return tank;
    }

    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        readFromNBT(stack);
        tooltip.add("Water: " + tank.getFluidAmount() + " mB");
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void writeToNBT(ItemStack stack) {
        stack.setTagCompound(new NBTTagCompound());
        tank.writeToNBT(stack.getTagCompound());
    }

    public void readFromNBT(ItemStack stack) {
        if (stack.getTagCompound() == null)
            stack.setTagCompound(new NBTTagCompound());
        tank.readFromNBT(stack.getTagCompound());
    }
}
