package net.thatcasual.essencefoundry.util;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DynamicTooltipItem extends Item {

    private DynamicTooltip dynamic_tooltip;

    public DynamicTooltip getDynamicTooltip(){
        return dynamic_tooltip;
    }

    public void setDynamicTooltip(DynamicTooltip dynamic_tooltip){
        this.dynamic_tooltip = dynamic_tooltip;
    }

    public void addToDynamicTooltip(MutableText text){
        this.dynamic_tooltip.addToTooltip(text);
    }

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

    public DynamicTooltipItem(Settings settings, DynamicTooltip dynamic_tooltip) {
        super(settings);
        this.dynamic_tooltip = dynamic_tooltip;
    }
}
