package net.thatcasual.essencefoundry.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.thatcasual.essencefoundry.EssenceFoundryMod;
import net.thatcasual.essencefoundry.item.custom.EssenceItem;
import net.thatcasual.essencefoundry.item.custom.LandEssenceItem;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModItems extends EssenceItem{

    public static final Item ZOMBIE_ESSENCE = registerItem("zombie_essence",
            new LandEssenceItem(new FabricItemSettings().group(ModItemGroups.ESSENCE_FOUNDRY)) {
                @Override
                public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Text.translatable("Has a 5% chance to drop from regular zombies").formatted(Formatting.LIGHT_PURPLE));
                        tooltip.add(Text.translatable("and a 10% chance to drop from zombie villagers.").formatted(Formatting.LIGHT_PURPLE));
                        tooltip.add(Text.translatable("Land Tier").formatted(Formatting.GRAY));
                    } else {
                        tooltip.add(Text.translatable("Hold Shift for more info.").formatted(Formatting.DARK_PURPLE));
                    }
                }
            });
    public static final Item SKELETON_ESSENCE = registerItem("skeleton_essence",
            new LandEssenceItem(new FabricItemSettings().group(ModItemGroups.ESSENCE_FOUNDRY)){
                @Override
                public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

                    if (Screen.hasShiftDown()) {
                        tooltip.add(Text.translatable("Has a 5% chance to drop from regular skeletons").formatted(Formatting.LIGHT_PURPLE));
                        tooltip.add(Text.translatable("and a 10% chance to drop from strays.").formatted(Formatting.LIGHT_PURPLE));
                        tooltip.add(Text.translatable("Land Tier").formatted(Formatting.GRAY));
                    } else {
                        tooltip.add(Text.translatable("Hold Shift for more info.").formatted(Formatting.DARK_PURPLE));
                    }
                }
            });

    public ModItems(Settings settings) {
        super(settings);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(EssenceFoundryMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        EssenceFoundryMod.LOGGER.debug("Registering ModItems for " + EssenceFoundryMod.MOD_ID);
    }

}
