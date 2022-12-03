package net.thatcasual.essencefoundry.item.custom;

import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.thatcasual.essencefoundry.util.DynamicTooltip;

public class BasicEssenceItem extends EssenceItem{

    public BasicEssenceItem(Settings settings, DynamicTooltip dynamictooltip) {
        super(settings, dynamictooltip);
        this.fulltip.addToTooltip(Text.translatable("Basic Tier").formatted(Formatting.GRAY));
    }
}
