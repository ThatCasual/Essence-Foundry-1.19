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
    public static EssenceBlock pre_LIME_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("lime_essence_block")
            .build();

    public static EssenceBlock pre_WHITE_ESSENCE_BLOCK = new EssenceBlock.EssenceBlockBuilder()
            .name("white_essence_block")
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
        final Block WHITE_ESSENCE_BLOCK = registerBlock(pre_WHITE_ESSENCE_BLOCK);
        final Block LIME_ESSENCE_BLOCK = registerBlock(pre_LIME_ESSENCE_BLOCK);
        EssenceFoundryMod.LOGGER.debug("Registering ModBlocks for " + EssenceFoundryMod.MOD_ID);
    }

    public ModBlocks(Settings settings) {
        super(settings);
    }
}
