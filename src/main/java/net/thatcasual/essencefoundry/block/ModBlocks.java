package net.thatcasual.essencefoundry.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thatcasual.essencefoundry.EssenceFoundryMod;
import net.thatcasual.essencefoundry.block.custom.EssenceBlock;
import net.thatcasual.essencefoundry.util.DynamicTooltipBlockItem;

public class ModBlocks extends Block {


    //create block w/ tooltip
    public static EssenceBlock pre_WHITE_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("white_essence_block")
            .build();
    public static EssenceBlock pre_TILED_WHITE_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("tiled_white_essence_block")
            .build();
    public static EssenceBlock pre_PETALED_WHITE_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("petaled_white_essence_block")
            .build();
    public static EssenceBlock pre_ORANGE_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("orange_essence_block")
            .build();
    public static EssenceBlock pre_TILED_ORANGE_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("tiled_orange_essence_block")
            .build();
    public static EssenceBlock pre_PETALED_ORANGE_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("petaled_orange_essence_block")
            .build();
    public static EssenceBlock pre_MAGENTA_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("magenta_essence_block")
            .build();
    public static EssenceBlock pre_TILED_MAGENTA_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("tiled_magenta_essence_block")
            .build();
    public static EssenceBlock pre_PETALED_MAGENTA_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("petaled_magenta_essence_block")
            .build();
    public static EssenceBlock pre_LIGHT_BLUE_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("light_blue_essence_block")
            .build();
    public static EssenceBlock pre_TILED_LIGHT_BLUE_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("tiled_light_blue_essence_block")
            .build();
    public static EssenceBlock pre_PETALED_LIGHT_BLUE_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("petaled_light_blue_essence_block")
            .build();
    public static EssenceBlock pre_YELLOW_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("yellow_essence_block")
            .build();
    public static EssenceBlock pre_TILED_YELLOW_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("tiled_yellow_essence_block")
            .build();
    public static EssenceBlock pre_PETALED_YELLOW_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("petaled_yellow_essence_block")
            .build();
    public static EssenceBlock pre_LIME_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("lime_essence_block")
            .build();
    public static EssenceBlock pre_TILED_LIME_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("tiled_lime_essence_block")
            .build();
    public static EssenceBlock pre_PETALED_LIME_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("petaled_lime_essence_block")
            .build();
    public static EssenceBlock pre_PINK_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("pink_essence_block")
            .build();
    public static EssenceBlock pre_TILED_PINK_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("tiled_pink_essence_block")
            .build();
    public static EssenceBlock pre_PETALED_PINK_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("petaled_pink_essence_block")
            .build();
    public static EssenceBlock pre_GRAY_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("gray_essence_block")
            .build();
    public static EssenceBlock pre_TILED_GRAY_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("tiled_gray_essence_block")
            .build();
    public static EssenceBlock pre_PETALED_GRAY_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("petaled_gray_essence_block")
            .build();
    public static EssenceBlock pre_LIGHT_GRAY_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("light_gray_essence_block")
            .build();
    public static EssenceBlock pre_TILED_LIGHT_GRAY_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("tiled_light_gray_essence_block")
            .build();
    public static EssenceBlock pre_PETALED_LIGHT_GRAY_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("petaled_light_gray_essence_block")
            .build();
    public static EssenceBlock pre_CYAN_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("cyan_essence_block")
            .build();
    public static EssenceBlock pre_TILED_CYAN_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("tiled_cyan_essence_block")
            .build();
    public static EssenceBlock pre_PETALED_CYAN_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("petaled_cyan_essence_block")
            .build();
    public static EssenceBlock pre_PURPLE_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("purple_essence_block")
            .build();
    public static EssenceBlock pre_TILED_PURPLE_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("tiled_purple_essence_block")
            .build();
    public static EssenceBlock pre_PETALED_PURPLE_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("petaled_purple_essence_block")
            .build();
    public static EssenceBlock pre_BLUE_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("blue_essence_block")
            .build();
    public static EssenceBlock pre_TILED_BLUE_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("tiled_blue_essence_block")
            .build();
    public static EssenceBlock pre_PETALED_BLUE_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("petaled_blue_essence_block")
            .build();
    public static EssenceBlock pre_BROWN_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("brown_essence_block")
            .build();
    public static EssenceBlock pre_TILED_BROWN_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("tiled_brown_essence_block")
            .build();
    public static EssenceBlock pre_PETALED_BROWN_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("petaled_brown_essence_block")
            .build();
    public static EssenceBlock pre_GREEN_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("green_essence_block")
            .build();
    public static EssenceBlock pre_TILED_GREEN_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("tiled_green_essence_block")
            .build();
    public static EssenceBlock pre_PETALED_GREEN_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("petaled_green_essence_block")
            .build();
    public static EssenceBlock pre_RED_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("red_essence_block")
            .build();
    public static EssenceBlock pre_TILED_RED_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("tiled_red_essence_block")
            .build();
    public static EssenceBlock pre_PETALED_RED_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("petaled_red_essence_block")
            .build();
    public static EssenceBlock pre_BLACK_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("black_essence_block")
            .build();
    public static EssenceBlock pre_TILED_BLACK_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("tiled_black_essence_block")
            .build();
    public static EssenceBlock pre_PETALED_BLACK_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("petaled_black_essence_block")
            .build();


    public static Block registerBlock(EssenceBlock block){
        registerBlockItem(block);
        return Registry.register(Registry.BLOCK, new Identifier(EssenceFoundryMod.MOD_ID, block.getBlockName()), block);
    }

    public static Item registerBlockItem(EssenceBlock block){
        return Registry.register(Registry.ITEM, new Identifier(EssenceFoundryMod.MOD_ID, block.getBlockName()),
                new DynamicTooltipBlockItem(block, new FabricItemSettings().group(block.getTab()), block.getDynamicTooltip()));
    }

    public static void  registerModBlocks(){
        EssenceFoundryMod.LOGGER.debug("Registering ModBlocks for " + EssenceFoundryMod.MOD_ID + "...");
        final Block WHITE_ESSENCE_BLOCK = registerBlock(pre_WHITE_ESSENCE_BLOCK);
        final Block TILED_WHITE_ESSENCE_BLOCK = registerBlock(pre_TILED_WHITE_ESSENCE_BLOCK);
        final Block PETALED_WHITE_ESSENCE_BLOCK = registerBlock(pre_PETALED_WHITE_ESSENCE_BLOCK);
        final Block ORANGE_ESSENCE_BLOCK = registerBlock(pre_ORANGE_ESSENCE_BLOCK);
        final Block TILED_ORANGE_ESSENCE_BLOCK = registerBlock(pre_TILED_ORANGE_ESSENCE_BLOCK);
        final Block PETALED_ORANGE_ESSENCE_BLOCK = registerBlock(pre_PETALED_ORANGE_ESSENCE_BLOCK);
        final Block MAGENTA_ESSENCE_BLOCK = registerBlock(pre_MAGENTA_ESSENCE_BLOCK);
        final Block TILED_MAGENTA_ESSENCE_BLOCK = registerBlock(pre_TILED_MAGENTA_ESSENCE_BLOCK);
        final Block PETALED_MAGENTA_ESSENCE_BLOCK = registerBlock(pre_PETALED_MAGENTA_ESSENCE_BLOCK);
        final Block LIGHT_BLUE_ESSENCE_BLOCK = registerBlock(pre_LIGHT_BLUE_ESSENCE_BLOCK);
        final Block TILED_LIGHT_BLUE_ESSENCE_BLOCK = registerBlock(pre_TILED_LIGHT_BLUE_ESSENCE_BLOCK);
        final Block PETALED_LIGHT_BLUE_ESSENCE_BLOCK = registerBlock(pre_PETALED_LIGHT_BLUE_ESSENCE_BLOCK);
        final Block YELLOW_ESSENCE_BLOCK = registerBlock(pre_YELLOW_ESSENCE_BLOCK);
        final Block TILED_YELLOW_ESSENCE_BLOCK = registerBlock(pre_TILED_YELLOW_ESSENCE_BLOCK);
        final Block TILED_PETALED_ESSENCE_BLOCK = registerBlock(pre_PETALED_YELLOW_ESSENCE_BLOCK);
        final Block LIME_ESSENCE_BLOCK = registerBlock(pre_LIME_ESSENCE_BLOCK);
        final Block TILED_LIME_ESSENCE_BLOCK = registerBlock(pre_TILED_LIME_ESSENCE_BLOCK);
        final Block PETALED_LIME_ESSENCE_BLOCK = registerBlock(pre_PETALED_LIME_ESSENCE_BLOCK);
        final Block PINK_ESSENCE_BLOCK = registerBlock(pre_PINK_ESSENCE_BLOCK);
        final Block TILED_PINK_ESSENCE_BLOCK = registerBlock(pre_TILED_PINK_ESSENCE_BLOCK);
        final Block PETALED_PINK_ESSENCE_BLOCK = registerBlock(pre_PETALED_PINK_ESSENCE_BLOCK);
        final Block GRAY_ESSENCE_BLOCK = registerBlock(pre_GRAY_ESSENCE_BLOCK);
        final Block TILED_GRAY_ESSENCE_BLOCK = registerBlock(pre_TILED_GRAY_ESSENCE_BLOCK);
        final Block PETALED_GRAY_ESSENCE_BLOCK = registerBlock(pre_PETALED_GRAY_ESSENCE_BLOCK);
        final Block LIGHT_GRAY_ESSENCE_BLOCK = registerBlock(pre_LIGHT_GRAY_ESSENCE_BLOCK);
        final Block TILED_LIGHT_GRAY_ESSENCE_BLOCK = registerBlock(pre_TILED_LIGHT_GRAY_ESSENCE_BLOCK);
        final Block PETALED_LIGHT_GRAY_ESSENCE_BLOCK = registerBlock(pre_PETALED_LIGHT_GRAY_ESSENCE_BLOCK);
        final Block CYAN_ESSENCE_BLOCK = registerBlock(pre_CYAN_ESSENCE_BLOCK);
        final Block TILED_CYAN_ESSENCE_BLOCK = registerBlock(pre_TILED_CYAN_ESSENCE_BLOCK);
        final Block PETALED_CYAN_ESSENCE_BLOCK = registerBlock(pre_PETALED_CYAN_ESSENCE_BLOCK);
        final Block PURPLE_ESSENCE_BLOCK = registerBlock(pre_PURPLE_ESSENCE_BLOCK);
        final Block TILED_PURPLE_ESSENCE_BLOCK = registerBlock(pre_TILED_PURPLE_ESSENCE_BLOCK);
        final Block PETALED_PURPLE_ESSENCE_BLOCK = registerBlock(pre_PETALED_PURPLE_ESSENCE_BLOCK);
        final Block BLUE_ESSENCE_BLOCK = registerBlock(pre_BLUE_ESSENCE_BLOCK);
        final Block TILED_BLUE_ESSENCE_BLOCK = registerBlock(pre_TILED_BLUE_ESSENCE_BLOCK);
        final Block PETALED_BLUE_ESSENCE_BLOCK = registerBlock(pre_PETALED_BLUE_ESSENCE_BLOCK);
        final Block BROWN_ESSENCE_BLOCK = registerBlock(pre_BROWN_ESSENCE_BLOCK);
        final Block TILED_BROWN_ESSENCE_BLOCK = registerBlock(pre_TILED_BROWN_ESSENCE_BLOCK);
        final Block PETALED_BROWN_ESSENCE_BLOCK = registerBlock(pre_PETALED_BROWN_ESSENCE_BLOCK);
        final Block GREEN_ESSENCE_BLOCK = registerBlock(pre_GREEN_ESSENCE_BLOCK);
        final Block TILED_GREEN_ESSENCE_BLOCK = registerBlock(pre_TILED_GREEN_ESSENCE_BLOCK);
        final Block PETALED_GREEN_ESSENCE_BLOCK = registerBlock(pre_PETALED_GREEN_ESSENCE_BLOCK);
        final Block RED_ESSENCE_BLOCK = registerBlock(pre_RED_ESSENCE_BLOCK);
        final Block TILED_RED_ESSENCE_BLOCK = registerBlock(pre_TILED_RED_ESSENCE_BLOCK);
        final Block PETALED_RED_ESSENCE_BLOCK = registerBlock(pre_PETALED_RED_ESSENCE_BLOCK);
        final Block BLACK_ESSENCE_BLOCK = registerBlock(pre_BLACK_ESSENCE_BLOCK);
        final Block TILED_BLACK_ESSENCE_BLOCK = registerBlock(pre_TILED_BLACK_ESSENCE_BLOCK);
        final Block PETALED_BLACK_ESSENCE_BLOCK = registerBlock(pre_PETALED_BLACK_ESSENCE_BLOCK);
        EssenceFoundryMod.LOGGER.debug("Finished registering ModBlocks for " + EssenceFoundryMod.MOD_ID + ".");
    }

    public ModBlocks(Settings settings) {
        super(settings);
    }
}
