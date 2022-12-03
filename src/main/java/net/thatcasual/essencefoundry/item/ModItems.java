package net.thatcasual.essencefoundry.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thatcasual.essencefoundry.EssenceFoundryMod;
import net.thatcasual.essencefoundry.item.custom.EssenceItem;
import net.thatcasual.essencefoundry.util.DynamicTooltip;


public class ModItems extends Item{

    public static EssenceItem pre_SKELETON_ESSENCE = new EssenceItem.EssenceItemBuilder()
            .settings(new FabricItemSettings().group(ModItemGroups.ESSENCE_FOUNDRY))
            .name("skeleton_essence")
            .dynamic_tooltip(new DynamicTooltip(Text.translatable("Has a 5% chance to drop from regular skeletons.")
                    .formatted(Formatting.LIGHT_PURPLE)))
            .build();


    public static EssenceItem pre_ZOMBIE_ESSENCE = new EssenceItem.EssenceItemBuilder()
                .settings(new FabricItemSettings().group(ModItemGroups.ESSENCE_FOUNDRY))
                .name("zombie_essence")
                .dynamic_tooltip(new DynamicTooltip(Text.translatable("Has a 5% chance to drop from regular zombies.")
                        .formatted(Formatting.LIGHT_PURPLE)))
                .build();


    public static EssenceItem pre_CHICKEN_ESSENCE = new EssenceItem.EssenceItemBuilder()
                .settings(new FabricItemSettings().group(ModItemGroups.ESSENCE_FOUNDRY))
                .name("chicken_essence")
                .dynamic_tooltip(new DynamicTooltip(Text.translatable("Has a 5% chance to drop from regular chicken.")
                        .formatted(Formatting.LIGHT_PURPLE)))
                .build();




    public ModItems(Settings settings) {
        super(settings);
    }

    private static Item registerItem(EssenceItem item){
        return Registry.register(Registry.ITEM, new Identifier(EssenceFoundryMod.MOD_ID, item.getItemName()), item);
    }

    public static void registerModItems(){
        EssenceFoundryMod.LOGGER.debug("Registering ModItems for " + EssenceFoundryMod.MOD_ID);
        final Item SKELETON_ESSENCE = registerItem(pre_SKELETON_ESSENCE);
        final Item ZOMBIE_ESSENCE = registerItem(pre_ZOMBIE_ESSENCE);
        final Item CHICKEN_ESSENCE = registerItem(pre_CHICKEN_ESSENCE);
    }

}
