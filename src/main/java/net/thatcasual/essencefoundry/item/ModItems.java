package net.thatcasual.essencefoundry.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thatcasual.essencefoundry.EssenceFoundryMod;
import net.thatcasual.essencefoundry.item.custom.BasicEssenceItem;
import net.thatcasual.essencefoundry.item.custom.EssenceItem;
import net.thatcasual.essencefoundry.util.DynamicTooltip;
import org.jetbrains.annotations.Nullable;

public class ModItems extends EssenceItem{

    public static final Item ZOMBIE_ESSENCE = registerItem("zombie_essence",
            new BasicEssenceItem(new FabricItemSettings().group(ModItemGroups.ESSENCE_FOUNDRY),
                    new DynamicTooltip(Text.translatable("Has a 5% chance to drop from regular zombies.")
                            .formatted(Formatting.LIGHT_PURPLE))));

    public static final Item SKELETON_ESSENCE = registerItem("skeleton_essence",
            new BasicEssenceItem(new FabricItemSettings().group(ModItemGroups.ESSENCE_FOUNDRY),
                    new DynamicTooltip(Text.translatable("Has a 5% chance to drop from regular skeletons.")
                            .formatted(Formatting.LIGHT_PURPLE))));

    public static final Item CHICKEN_ESSENCE = registerItem("chicken_essence",
            new BasicEssenceItem(new FabricItemSettings().group(ModItemGroups.ESSENCE_FOUNDRY),
                    new DynamicTooltip(Text.translatable("Has a 5% chance to drop from chickens.")
                            .formatted(Formatting.LIGHT_PURPLE))));

    public ModItems(Settings settings, DynamicTooltip dynamictooltip) {
        super(settings, dynamictooltip);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(EssenceFoundryMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        EssenceFoundryMod.LOGGER.debug("Registering ModItems for " + EssenceFoundryMod.MOD_ID);
    }

}
