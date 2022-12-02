package net.thatcasual.essencefoundry.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.thatcasual.essencefoundry.util.DynamicTooltip;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LandEssenceItem extends EssenceItem{

    public LandEssenceItem(Settings settings, @Nullable DynamicTooltip dynamictooltip) {
        super(settings, dynamictooltip);
        this.fulltip.addToTooltip(Text.translatable("Land Tier").formatted(Formatting.GRAY));
    }
}
