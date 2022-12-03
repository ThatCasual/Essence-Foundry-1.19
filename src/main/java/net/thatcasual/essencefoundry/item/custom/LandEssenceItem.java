package net.thatcasual.essencefoundry.item.custom;

import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.thatcasual.essencefoundry.util.DynamicTooltip;

public class LandEssenceItem extends EssenceItem{

    public LandEssenceItem(Settings settings, DynamicTooltip dynamictooltip) {
        super(settings, dynamictooltip);
        this.fulltip.addToTooltip(Text.translatable("Land Tier").formatted(Formatting.GRAY));
    }
}
