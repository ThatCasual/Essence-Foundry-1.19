package net.thatcasual.essencefoundry.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.thatcasual.essencefoundry.EssenceFoundryMod;
import net.thatcasual.essencefoundry.util.DynamicTooltip;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EssenceItem extends Item {

    private Settings settings;
    private String name;
    private int tier_id;
    private DynamicTooltip dynamic_tooltip;

    public String getItemName(){
        return this.name;
    }

    public DynamicTooltip getDynamicTooltip(){
        return dynamic_tooltip;
    }

    public void setDynamicTooltip(DynamicTooltip dynamic_tooltip){
        this.dynamic_tooltip = dynamic_tooltip;
    }

    private EssenceItem(Settings settings, int tier_id, String name, DynamicTooltip dynamic_tooltip) {
        super(settings);
        this.name = name;
        this.tier_id = tier_id;
        this.dynamic_tooltip =dynamic_tooltip;
    }



    public static class EssenceItemBuilder{
        private Settings settings;
        private String name = "unnamed";
        private int tier_id = EssenceFoundryMod.BASIC_TIER;
        private DynamicTooltip dynamic_tooltip = new DynamicTooltip();

        public EssenceItemBuilder settings(Settings settings){
            this.settings = settings;
            return this;
        }

        public EssenceItemBuilder name(String name){
            this.name = name;
            return this;
        }

        public EssenceItemBuilder tier_id(int tier_id) {
            this.tier_id = tier_id;
            return this;
        }

        public EssenceItemBuilder dynamic_tooltip(DynamicTooltip dynamic_tooltip){
            this.dynamic_tooltip = dynamic_tooltip;
            return this;
        }

        public EssenceItem build(){
            switch (this.tier_id){
                case EssenceFoundryMod.BASIC_TIER:
                    this.dynamic_tooltip.addToTooltip(Text.translatable("Basic Tier").formatted(Formatting.GRAY));
                    break;
                case EssenceFoundryMod.ENCOUNTER_TIER:
                    this.dynamic_tooltip.addToTooltip(Text.translatable("Encounter Tier").formatted(Formatting.BLUE));
                    break;
                case EssenceFoundryMod.NETHER_TIER:
                    this.dynamic_tooltip.addToTooltip(Text.translatable("Nether Tier").formatted(Formatting.DARK_PURPLE));
                    break;
                case EssenceFoundryMod.END_TIER:
                    this.dynamic_tooltip.addToTooltip(Text.translatable("End Tier").formatted(Formatting.GOLD));
                    break;
                default:
                    break;
            }
            return new EssenceItem(settings, tier_id, name, dynamic_tooltip);
        }
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
}
