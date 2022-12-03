package net.thatcasual.essencefoundry.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.thatcasual.essencefoundry.EssenceFoundryMod;
import net.thatcasual.essencefoundry.block.custom.BasicEssenceBlock;
import net.thatcasual.essencefoundry.block.custom.EssenceBlock;
import net.thatcasual.essencefoundry.item.ModItemGroups;
import net.thatcasual.essencefoundry.util.DynamicTooltip;

public class ModBlocks extends EssenceBlock {



    public static final Block LIME_ESSENCE_BLOCK = registerBlock("lime_essence_block",
            new BasicEssenceBlock(FabricBlockSettings.of(Material.AMETHYST).sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(2f).requiresTool(), new DynamicTooltip()), ModItemGroups.ESSENCE_FOUNDRY, new DynamicTooltip(BasicEssenceBlock.TIER_DESCRIPTION));

    public static final Block WHITE_ESSENCE_BLOCK = registerBlock("white_essence_block",
            new BasicEssenceBlock(FabricBlockSettings.of(Material.AMETHYST).sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(2f).requiresTool(), new DynamicTooltip()), ModItemGroups.ESSENCE_FOUNDRY, new DynamicTooltip(BasicEssenceBlock.TIER_DESCRIPTION));

    public static void  registerModBlocks(){
        EssenceFoundryMod.LOGGER.debug("Registering ModBlocks for " + EssenceFoundryMod.MOD_ID);
    }

    public ModBlocks(Settings settings) {
        super(settings);
    }
}
