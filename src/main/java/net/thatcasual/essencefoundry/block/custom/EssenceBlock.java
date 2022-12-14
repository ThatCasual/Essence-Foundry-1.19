package net.thatcasual.essencefoundry.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.thatcasual.essencefoundry.EssenceFoundryMod;
import net.thatcasual.essencefoundry.item.ModItemGroups;
import net.thatcasual.essencefoundry.util.DynamicTooltip;
import net.thatcasual.essencefoundry.util.RegistrationData;

public class EssenceBlock extends Block {

    private int tier_id;
    public RegistrationData regdata = new RegistrationData();

    private EssenceBlock(Block.Settings settings, String name, int tier_id, ItemGroup tab, DynamicTooltip dynamic_tooltip) {
        super(settings);
        this.tier_id = tier_id;
        this.regdata.name = name;
        this.regdata.tab = tab;
        this.regdata.dynamic_tooltip = dynamic_tooltip;

    }

    public static class EssenceBlockBuilder{
        private Block.Settings settings = FabricBlockSettings
                .of(Material.AMETHYST)
                .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                .strength(2f).requiresTool();
        private String name = "unnamed";
        private int tier_id = EssenceFoundryMod.BASIC_TIER;
        private ItemGroup tab = ModItemGroups.ESSENCE_FOUNDRY;
        private DynamicTooltip dynamic_tooltip = new DynamicTooltip();

        public EssenceBlockBuilder settings(Block.Settings settings){
            this.settings = settings;
            return this;
        }

        public EssenceBlockBuilder name(String name){
            this.name = name;
            return this;
        }

        public EssenceBlockBuilder tier_id(int tier_id) {
            this.tier_id = tier_id;
            return this;
        }

        public EssenceBlockBuilder tab(ItemGroup tab){
            this.tab = tab;
            return this;
        }

        public EssenceBlockBuilder dynamicTooltip(DynamicTooltip dynamic_tooltip){
            this.dynamic_tooltip = dynamic_tooltip;
            return this;
        }

        public EssenceBlock build(){
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
            return new EssenceBlock(settings, name, tier_id, tab, dynamic_tooltip);
        }
    }

}
