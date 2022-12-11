package net.thatcasual.essencefoundry.fluid;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thatcasual.essencefoundry.EssenceFoundryMod;
import net.thatcasual.essencefoundry.item.ModItemGroups;
import net.thatcasual.essencefoundry.util.DynamicTooltip;
import net.thatcasual.essencefoundry.util.DynamicTooltipBucketItem;

public class ModFluids {

    public static FlowableFluid STILL_OBSIDIAN_TEARS;
    public static FlowableFluid FLOWING_OBSIDIAN_TEARS;
    public static Block OBSIDIAN_TEARS_BLOCK;
    public static Item OBSIDIAN_TEARS_BUCKET;


    private static FlowableFluid registerStillFluid(String name){
        return Registry.register(Registry.FLUID, new Identifier(EssenceFoundryMod.MOD_ID, name), new ObsidianTearsFluid.Still());
    }
    private static FlowableFluid registerFlowingFluid(String name){
        return Registry.register(Registry.FLUID, new Identifier(EssenceFoundryMod.MOD_ID, name), new ObsidianTearsFluid.FLowing());
    }
    private static Block registerFluidBlock(String name, FlowableFluid fluid){
        return Registry.register(Registry.BLOCK, new Identifier(EssenceFoundryMod.MOD_ID, name), new FluidBlock(fluid, FabricBlockSettings.copyOf(Blocks.WATER)){});
    }private static Item registerBucketItem(String name, FlowableFluid fluid, DynamicTooltip dynamic_tooltip){
        return Registry.register(Registry.ITEM, new Identifier(EssenceFoundryMod.MOD_ID, name), new DynamicTooltipBucketItem(fluid,
                new FabricItemSettings().group(ModItemGroups.ESSENCE_FOUNDRY).recipeRemainder(Items.BUCKET).maxCount(1),
                dynamic_tooltip));
    }

    public static void registerModFluids(){
        STILL_OBSIDIAN_TEARS = registerStillFluid("obsidian_tears");
        FLOWING_OBSIDIAN_TEARS = registerFlowingFluid("flowing_obsidian_tears");
        OBSIDIAN_TEARS_BLOCK = registerFluidBlock("obsidian_tears_block", STILL_OBSIDIAN_TEARS);
        OBSIDIAN_TEARS_BUCKET = registerBucketItem("obsidian_tears_bucket", STILL_OBSIDIAN_TEARS, new DynamicTooltip(Text.translatable("Extracted from crying obsidian.")));
    }

}
