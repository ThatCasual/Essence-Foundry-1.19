package net.thatcasual.essencefoundry.block.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thatcasual.essencefoundry.EssenceFoundryMod;
import net.thatcasual.essencefoundry.util.DynamicTooltip;
import net.thatcasual.essencefoundry.util.DynamicTooltipBlockItem;

public abstract class EssenceBlock extends Block {

    public static Block registerBlock(String name, Block block, ItemGroup tab, DynamicTooltip dynamictooltip){
        registerBlockItem(name, block, tab, dynamictooltip);
        return Registry.register(Registry.BLOCK, new Identifier(EssenceFoundryMod.MOD_ID, name), block);
    }

    public static Item registerBlockItem(String name, Block block, ItemGroup tab, DynamicTooltip dynamictooltip){
        return Registry.register(Registry.ITEM, new Identifier(EssenceFoundryMod.MOD_ID, name),
                new DynamicTooltipBlockItem(block, new FabricItemSettings().group(tab), dynamictooltip));
    }

    public EssenceBlock(Settings settings) {
        super(settings);
    }

}
