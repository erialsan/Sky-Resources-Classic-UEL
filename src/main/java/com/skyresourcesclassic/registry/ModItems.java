package com.skyresourcesclassic.registry;

import com.skyresourcesclassic.References;
import com.skyresourcesclassic.SkyResourcesClassic;
import com.skyresourcesclassic.alchemy.item.*;
import com.skyresourcesclassic.base.item.*;
import com.skyresourcesclassic.technology.item.GemRegisterInfo;
import com.skyresourcesclassic.technology.item.ItemRockGrinder;
import com.skyresourcesclassic.technology.item.TechItemComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.GameData;

import java.util.ArrayList;

public class ModItems {
    public static Item alchemyComponent;
    public static Item metalCrystal;
    public static Item baseComponent;
    public static Item techComponent;
    public static Item healthGem;

    public static Item cactusFruit;
    public static Item fleshySnowNugget;

    public static Item waterExtractor;

    public static Item heavySnowball;
    public static Item heavyExpSnowball;

    public static Item dirtyGem;

    public static Item cactusKnife;
    public static Item ironKnife;
    public static Item diamondKnife;

    public static Item stoneGrinder;
    public static Item ironGrinder;
    public static Item diamondGrinder;

    public static Item sandstoneInfusionStone;
    public static Item redSandstoneInfusionStone;
    public static Item alchemicalInfusionStone;

    public static Item survivalistFishingRod;

    public static ArrayList<GemRegisterInfo> gemList = new ArrayList<GemRegisterInfo>();

    public static void init() {
        ModItems.addGem("emerald", 0xFF12DB3A, 0.005F);
        ModItems.addGem("diamond", 0xFF6BFFFD, 0.011F);
        ModItems.addGem("ruby", 0xFFFA1E1E, 0.005F);
        ModItems.addGem("sapphire", 0xFF1E46FA, 0.005F);
        ModItems.addGem("peridot", 0xFF1CB800, 0.005F);
        ModItems.addGem("redGarnet", 0xFFC90014, 0.005F);
        ModItems.addGem("yellowGarnet", 0xFFF7FF0F, 0.005F);
        ModItems.addGem("apatite", 0xFF2B95FF, 0.200F);
        ModItems.addGem("amber", 0xFFF5CC53, 0.007F);
        ModItems.addGem("lepidolite", 0xFF57008A, 0.007F);
        ModItems.addGem("malachite", 0xFF23AD00, 0.007F);
        ModItems.addGem("onyx", 0xFF3D3D3D, 0.007F);
        ModItems.addGem("moldavite", 0xFFADFF99, 0.007F);
        ModItems.addGem("agate", 0xFFFF63FF, 0.007F);
        ModItems.addGem("opal", 0xFFDEDEDE, 0.007F);
        ModItems.addGem("amethyst", 0xFF780078, 0.006F);
        ModItems.addGem("jasper", 0xFF874800, 0.006F);
        ModItems.addGem("aquamarine", 0xFF36E7FF, 0.006F);
        ModItems.addGem("heliodor", 0xFFFFFF7D, 0.006F);
        ModItems.addGem("turquoise", 0xFF2EF2C8, 0.006F);
        ModItems.addGem("moonstone", 0xFF016A8A, 0.006F);
        ModItems.addGem("morganite", 0xFFFA61FF, 0.006F);
        ModItems.addGem("carnelian", 0xFF630606, 0.006F);
        ModItems.addGem("beryl", 0xFF46E334, 0.005F);
        ModItems.addGem("goldenBeryl", 0xFFD6AE2B, 0.005F);
        ModItems.addGem("citrine", 0xFF871616, 0.005F);
        ModItems.addGem("indicolite", 0xFF39E6BD, 0.005F);
        ModItems.addGem("garnet", 0xFFFF9999, 0.005F);
        ModItems.addGem("topaz", 0xFFFFD399, 0.005F);
        ModItems.addGem("ametrine", 0xFFA300BF, 0.005F);
        ModItems.addGem("tanzanite", 0xFF00076E, 0.005F);
        ModItems.addGem("violetSapphire", 0xFF451287, 0.004F);
        ModItems.addGem("alexandrite", 0xFFE3E3E3, 0.004F);
        ModItems.addGem("blueTopaz", 0xFF1000C4, 0.004F);
        ModItems.addGem("spinel", 0xFF750000, 0.004F);
        ModItems.addGem("iolite", 0xFF9502CF, 0.004F);
        ModItems.addGem("blackDiamond", 0xFF262626, 0.003F);
        ModItems.addGem("chaos", 0xFFFFE6FB, 0.003F);
        ModItems.addGem("enderEssence", 0xFF356E19, 0.003F);
        ModItems.addGem("dark", 0xFF242424, 0.09F);

        alchemyComponent = registerItem(new AlchemyItemComponent());
        metalCrystal = registerItem(new MetalCrystalItem());
        dirtyGem = registerItem(new DirtyGemItem());
        baseComponent = registerItem(new BaseItemComponent());
        techComponent = registerItem(new TechItemComponent());
        healthGem = registerItem(new ItemHealthGem());
        waterExtractor = registerItem(new ItemWaterExtractor());
        heavySnowball = registerItem(new ItemHeavySnowball("heavy_snowball", "heavy_snowball"));
        heavyExpSnowball = registerItem(new ItemHeavyExplosiveSnowball("heavy_explosive_snowball", "heavy_explosive_snowball"));
        cactusFruit = registerItem(new ModItemFood(3, 2F, false, "cactus_fruit", "cactus_fruit"));
        fleshySnowNugget = registerItem(
                new ModItemFood(4, 1.5F, false, "fleshy_snow_nugget", "fleshy_snow_nugget"));
        cactusKnife = registerItem(new ItemKnife(SkyResourcesClassic.materialCactusNeedle,
                "cactus_cutting_knife", "cactus_cutting_knife"));
        ironKnife = registerItem(
                new ItemKnife(ToolMaterial.IRON, "iron_cutting_knife", "Iron_cutting_knife"));
        diamondKnife = registerItem(
                new ItemKnife(ToolMaterial.DIAMOND, "diamond_cutting_knife", "diamond_cutting_knife"));

        stoneGrinder = registerItem(
                new ItemRockGrinder(ToolMaterial.STONE, "stone_grinder", "stone_grinder"));
        ironGrinder = registerItem(
                new ItemRockGrinder(ToolMaterial.IRON, "iron_grinder", "iron_grinder"));
        diamondGrinder = registerItem(
                new ItemRockGrinder(ToolMaterial.DIAMOND, "diamond_grinder", "diamond_grinder"));

        sandstoneInfusionStone = registerItem(
                new ItemInfusionStone(100, "sandstone_infusion_stone", "sandstone_infusion_stone"));
        redSandstoneInfusionStone = registerItem(new ItemInfusionStone(80,
                "red_sandstone_infusion_stone", "red_sandstone_infusion_stone"));
        alchemicalInfusionStone = registerItem(
                new ItemInfusionStone(1500, "alchemical_infusion_stone", "alchemical_infusion_stone"));
        survivalistFishingRod = registerItem(
                new ItemSurvivalFishingRod("survivalist_fishing_rod", "survivalist_fishing_rod"));
    }

    private static Item registerItem(Item item, String name) {
        GameData.register_impl(item.setRegistryName(new ResourceLocation(References.ModID, name)));

        return item;
    }

    private static Item registerItem(Item item) {
        if (item.getRegistryName() == null) {
            SkyResourcesClassic.logger.error(
                    "Item {} doesn't have a registry name. Item will not be registered.",
                    item.getClass().getCanonicalName());
            return item;
        }
        GameData.register_impl(item);

        return item;
    }

    public static void addGem(String name, int color, float rarity) {
        gemList.add(new GemRegisterInfo(name, color, rarity));
    }
}
