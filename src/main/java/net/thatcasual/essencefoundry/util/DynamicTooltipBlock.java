package net.thatcasual.essencefoundry.util;

import net.minecraft.block.Block;
import net.minecraft.text.MutableText;

@Deprecated
public class DynamicTooltipBlock extends Block {

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

    public DynamicTooltipBlock(Settings settings, DynamicTooltip dynamic_tooltip) {
        super(settings);
        this.dynamic_tooltip = dynamic_tooltip;
    }
}
