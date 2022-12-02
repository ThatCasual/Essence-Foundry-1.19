package net.thatcasual.essencefoundry.block.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.thatcasual.essencefoundry.EssenceFoundryMod;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class EssenceBlock extends Block {

    public static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(EssenceFoundryMod.MOD_ID, name), block);
    }

    public static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registry.ITEM, new Identifier(EssenceFoundryMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)){
            @Override
            public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

                if(Screen.hasShiftDown()){
                    tooltip.add(Text.literal("Has a 5% chance to drop from the respective mob.").formatted(Formatting.LIGHT_PURPLE));
                } else {
                    tooltip.add(Text.literal("Hold Shift for info.").formatted(Formatting.DARK_PURPLE));
                }

                super.appendTooltip(stack, world, tooltip, context);
            }
                });
    }

    public EssenceBlock(Settings settings) {super(settings);}

}
