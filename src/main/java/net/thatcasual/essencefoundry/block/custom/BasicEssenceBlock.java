package net.thatcasual.essencefoundry.block.custom;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.thatcasual.essencefoundry.util.DynamicTooltip;

public class BasicEssenceBlock extends EssenceBlock{

    public static final MutableText TIER_DESCRIPTION = Text.translatable("Basic Tier").formatted(Formatting.GRAY);
    public BasicEssenceBlock(Settings settings, DynamicTooltip dynamictooltip) {
        super(settings);
    }
}
