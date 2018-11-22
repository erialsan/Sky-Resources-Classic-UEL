package com.skyresourcesclassic.registry;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.alchemy.block.*;
import com.skyresourcesclassic.alchemy.fluid.FluidCrystalBlock;
import com.skyresourcesclassic.alchemy.fluid.FluidRegisterInfo.CrystalFluidType;
import com.skyresourcesclassic.base.block.*;
import com.skyresourcesclassic.technology.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.registries.GameData;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static Block cactusFruitNeedle;

    public static Block combustionHeater;
    public static Block crucible;
    public static Block fluidDropper;
    public static Block alchemicalCondenser;
    public static Block crystallizer;
    public static Block miniFreezer;
    public static Block ironFreezer;
    public static Block poweredHeater;
    public static Block darkMatterWarper;
    public static Block endPortalCore;
    public static Block lifeInfuser;
    public static Block lifeInjector;
    public static Block crucibleInserter;
    public static Block rockCrusher;
    public static Block rockCleaner;
    public static Block combustionCollector;
    public static Block quickDropper;
    public static Block aqueousConcentrator;
    public static Block aqueousDeconcentrator;

    public static Block compressedCoalBlock;
    public static Block coalInfusedBlock;
    public static Block sandyNetherrack;
    public static Block darkMatterBlock;
    public static Block heavySnow;
    public static Block heavySnow2;

    public static Block blazePowderBlock;

    public static Block dryCactus;
    public static Block dirtFurnace;

    public static List<Block> crystalFluidBlocks;

    public static void init() {
        crystalFluidBlocks = new ArrayList<Block>();
        cactusFruitNeedle = registerBlock(new TransparentBlock(Material.PLANTS, "cactus_fruit_needle",
                "cactus_fruit_needle", 0.5F, 0.5F, new AxisAlignedBB(0.3D, 0D, 0.3D, 0.7D, 0.8D, 0.7D), SoundType.PLANT));

        compressedCoalBlock = registerBlock(
                new BaseBlock(Material.ROCK, "compressed_coal_block", "compressed_coal_block", 6F, 6F, SoundType.STONE));

        sandyNetherrack = registerBlock(
                new BaseBlock(Material.ROCK, "sandy_netherrack", "sandy_netherrack", 2F, 2F, SoundType.STONE));

        coalInfusedBlock = registerBlock(
                new BaseBlock(Material.ROCK, "coal_infused_block", "coal_infused_block", 6F, 6F, SoundType.STONE));
        darkMatterBlock = registerBlock(
                new BaseBlock(Material.ROCK, "dark_matter_block", "dark_matter_block", 10F, 12F, SoundType.STONE));

        blazePowderBlock = registerBlock(new BlazePowderBlock(Material.CLAY, "blaze_powder_block", "blaze_powder_block",
                0.5F, 0.5F, SoundType.GROUND));
        heavySnow = registerBlock(new BaseBlock(Material.CLAY, "heavy_snow", "heavy_snow", 0.5F, 0.5F, SoundType.SNOW));
        heavySnow2 = registerBlock(new BaseBlock(Material.CLAY, "heavy_snow2", "heavy_snow2", 1F, 1F, SoundType.SNOW));

        registerItemBlock(
                alchemicalCondenser = new CondenserBlock("alchemical_condenser", "alchemical_condenser", 2F, 12F));

        registerItemBlock(crystallizer = new CrystallizerBlock("crystallizer", "crystallizer", 6F, 12F));

        poweredHeater = registerBlock(new BlockPoweredHeater("powered_heater", "powered_heater", 4F, 12F));
        darkMatterWarper = registerBlock(new BlockDarkMatterWarper("dark_matter_warper", "dark_matter_warper", 8F, 12F));
        endPortalCore = registerBlock(new BlockEndPortalCore("end_portal_core", "end_portal_core", 6F, 12F));
        rockCrusher = registerBlock(new BlockRockCrusher("rock_crusher", "rock_crusher", 6F, 12F));
        rockCleaner = registerBlock(new BlockRockCleaner("rock_cleaner", "rock_cleaner", 6F, 12F));
        combustionCollector = registerBlock(
                new BlockCombustionCollector("combustion_collector", "combustion_collector", 6F, 12F));
        quickDropper = registerBlock(new BlockQuickDropper("quick_dropper", "quick_dropper", 6F, 12F));
        lifeInfuser = registerBlock(new LifeInfuserBlock("life_infuser", "life_infuser", 6F, 12F));
        lifeInjector = registerBlock(new LifeInjectorBlock("life_injector", "life_injector", 6F, 12F));

        miniFreezer = registerBlock(new BlockMiniFreezer("mini_freezer", "mini_freezer", 0.5F, 0.5F));
        ironFreezer = registerBlock(new BlockFreezer("iron_freezer", "iron_freezer", 2F, 2F));

        crucible = registerBlock(new CrucibleBlock("crucible", "crucible", 2F, 12F));

        fluidDropper = registerBlock(new FluidDropperBlock("fluid_dropper", "fluid_dropper", 2F, 12F));

        crucibleInserter = registerBlock(new BlockCrucibleInserter("crucible_inserter", "crucible_inserter", 2F, 12F));
        aqueousConcentrator = registerBlock(
                new BlockAqueousConcentrator("aqueous_concentrator", "aqueous_concentrator", 2F, 12F));
        aqueousDeconcentrator = registerBlock(
                new BlockAqueousDeconcentrator("aqueous_deconcentrator", "aqueous_deconcentrator", 2F, 12F));

        registerItemBlock(
                combustionHeater = new CombustionHeaterBlock("combustion_heater", "combustion_heater", 2F, 12F));
        dryCactus = registerBlock(new BlockDryCactus());

        dirtFurnace = registerBlock(new BlockDirtFurnace("dirt_furnace", "dirt_furnace", 0.5F, 0.5F));

        for (int i = 0; i < ModFluids.crystalFluidInfos().length; i++) {
            CrystalFluidType type = ModFluids.crystalFluidInfos()[i].type;
            crystalFluidBlocks.add(registerBlockOnly(new FluidCrystalBlock(ModFluids.crystalFluids.get(i),
                    type == CrystalFluidType.NORMAL ? Material.WATER : Material.LAVA,
                    ModFluids.crystalFluidInfos()[i].name + (type == CrystalFluidType.NORMAL ? "" : "molten")
                            + "crystal_fluid_block",
                    ModFluids.crystalFluidInfos()[i].name + (type == CrystalFluidType.NORMAL ? "" : "molten")
                            + "crystal_fluid_block")));
        }
    }

    public static Block registerBlockOnly(Block block, String name) {
        GameData.register_impl(block.setRegistryName(new ResourceLocation(References.ModID, name)));

        return block;
    }

    public static Block registerBlock(Block block, String name) {
        GameData.register_impl(block.setRegistryName(new ResourceLocation(References.ModID, name)));
        GameData.register_impl(new ItemBlock(block).setRegistryName(new ResourceLocation(References.ModID, name)));

        return block;
    }

    public static Block registerBlockOnly(Block block) {
        GameData.register_impl(block);

        return block;
    }

    public static Block registerBlock(Block block) {
        GameData.register_impl(block);
        GameData.register_impl(new ItemBlock(block).setRegistryName(block.getRegistryName()));

        return block;
    }

    public static void registerItemBlock(Block block) {
        GameData.register_impl(block);
        GameData.register_impl(new ItemBlockMeta(block).setRegistryName(block.getRegistryName()));

    }
}
