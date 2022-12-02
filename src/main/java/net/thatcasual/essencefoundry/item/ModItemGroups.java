package net.thatcasual.essencefoundry.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.thatcasual.essencefoundry.EssenceFoundryMod;

public class ModItemGroups {
    public static final ItemGroup ESSENCE_FOUNDRY = FabricItemGroupBuilder.build(
            new Identifier(EssenceFoundryMod.MOD_ID, "essence_foundry"), () -> new ItemStack(ModItems.SKELETON_ESSENCE));

}
