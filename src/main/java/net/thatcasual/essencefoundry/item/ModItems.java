package net.thatcasual.essencefoundry.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thatcasual.essencefoundry.EssenceFoundryMod;

public class ModItems {

    public static final Item ZOMBIE_ESSENCE = registerItem("zombie_essence",
            new Item(new FabricItemSettings().group(ModItemGroups.ESSENCE_FOUNDRY)));
    public static final Item SKELETON_ESSENCE = registerItem("skeleton_essence",
            new Item(new FabricItemSettings().group(ModItemGroups.ESSENCE_FOUNDRY)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(EssenceFoundryMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        EssenceFoundryMod.LOGGER.debug("Registering ModItems for " + EssenceFoundryMod.MOD_ID);
    }

}
