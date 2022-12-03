package net.thatcasual.essencefoundry.util;

import net.minecraft.block.Block;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class DynamicTooltipBlockItem extends BlockItem {

    private DynamicTooltip dynamic_tooltip;

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        if(Screen.hasShiftDown()){
            List<MutableText> text = dynamic_tooltip.getEntries();
            for (int i = 0; i < text.size(); i++){
                tooltip.add(text.get(i));
            }

        } else {
            tooltip.add(Text.translatable("Hold Shift for info.").formatted(Formatting.DARK_PURPLE));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
    public DynamicTooltipBlockItem(Block block, Settings settings, DynamicTooltip dynamictooltip) {
        super(block, settings);
        dynamic_tooltip = dynamictooltip;
    }
}
