package net.thatcasual.essencefoundry.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thatcasual.essencefoundry.EssenceFoundryMod;
import net.thatcasual.essencefoundry.block.custom.EssenceBlock;
import net.thatcasual.essencefoundry.block.custom.LandEssenceBlocks;
import net.thatcasual.essencefoundry.item.ModItemGroups;

public class ModBlocks extends EssenceBlock {

    public static final Block ZOMBIE_ESSENCE_BLOCK = registerBlock("zombie_essence_block",
            new LandEssenceBlocks(FabricBlockSettings.of(Material.AMETHYST).sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(2f).requiresTool()), ModItemGroups.ESSENCE_FOUNDRY);

    public static final Block SKELETON_ESSENCE_BLOCK = registerBlock("skeleton_essence_block",
            new LandEssenceBlocks(FabricBlockSettings.of(Material.AMETHYST).sounds(BlockSoundGroup.AMETHYST_BLOCK).strength(2f).requiresTool()), ModItemGroups.ESSENCE_FOUNDRY);

    public static void  registerModBlocks(){
        EssenceFoundryMod.LOGGER.debug("Registering ModBlocks for " + EssenceFoundryMod.MOD_ID);
    }

    public ModBlocks(Settings settings) {
        super(settings);
    }
}
