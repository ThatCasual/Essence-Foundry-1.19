package net.thatcasual.essencefoundry.recipe;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thatcasual.essencefoundry.EssenceFoundryMod;

public class ModRecipes {

    public static void registerRecipes(){
        Registry.register(Registry.RECIPE_SERIALIZER,
                new Identifier(EssenceFoundryMod.MOD_ID, ExtractorRecipe.Serializer.ID),
                ExtractorRecipe.Serializer.INSTANCE);

        Registry.register(Registry.RECIPE_TYPE,
                new Identifier(EssenceFoundryMod.MOD_ID, ExtractorRecipe.Type.ID),
                ExtractorRecipe.Type.INSTANCE);
    }

}
