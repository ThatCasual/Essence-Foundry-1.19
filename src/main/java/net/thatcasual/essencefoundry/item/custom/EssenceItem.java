package net.thatcasual.essencefoundry.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.thatcasual.essencefoundry.EssenceFoundryMod;
import net.thatcasual.essencefoundry.item.ModItemGroups;
import net.thatcasual.essencefoundry.util.DynamicTooltip;
import net.thatcasual.essencefoundry.util.RegistrationData;

public class EssenceItem extends Item {

    private int tier_id;
    private RegistrationData regdata = new RegistrationData();

    public String getItemName(){
        return this.regdata.name;
    }


    private EssenceItem(Settings settings, int tier_id, String name, ItemGroup tab, DynamicTooltip dynamic_tooltip) {
        super(settings);
        this.tier_id = tier_id;
        this.regdata.name = name;
        this.regdata.tab = tab;
        this.regdata.dynamic_tooltip = dynamic_tooltip;
    }



    public static class EssenceItemBuilder{
        private Settings settings;
        private String name = "unnamed";
        private int tier_id = EssenceFoundryMod.BASIC_TIER;
        private ItemGroup tab = ModItemGroups.ESSENCE_FOUNDRY;
        private DynamicTooltip dynamic_tooltip = new DynamicTooltip(Text.translatable("Has a 5% chance to drop from its respective mob.")
                .formatted(Formatting.LIGHT_PURPLE));

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

        public EssenceItemBuilder tab(ItemGroup tab){
            this.tab = tab;
            return this;
        }

        public EssenceItemBuilder dynamicTooltip(DynamicTooltip dynamic_tooltip){
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
            if(this.settings == null){
                this.settings = new FabricItemSettings().group(this.tab);
            }
            return new EssenceItem(settings, tier_id, name, tab, dynamic_tooltip);
        }
    }
}
