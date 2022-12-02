package net.thatcasual.essencefoundry.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.thatcasual.essencefoundry.util.DynamicTooltip;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public abstract class EssenceItem extends Item {

    public DynamicTooltip fulltip;

    public EssenceItem(Settings settings, @Nullable DynamicTooltip dynamictooltip) {
        super(settings);
        fulltip = dynamictooltip;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        if(Screen.hasShiftDown()){
            List<MutableText> text = fulltip.getEntries();
            for (int i = 0; i < text.size(); i++){
                tooltip.add(text.get(i));
            }

        } else {
            tooltip.add(Text.translatable("Hold Shift for info.").formatted(Formatting.DARK_PURPLE));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
}
