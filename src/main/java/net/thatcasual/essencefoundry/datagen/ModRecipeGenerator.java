package net.thatcasual.essencefoundry.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.thatcasual.essencefoundry.block.ModBlocks;
import net.thatcasual.essencefoundry.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {

        offerStonecuttingRecipe(exporter, ModBlocks.pre_TILED_WHITE_ESSENCE_BLOCK, ModBlocks.pre_WHITE_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_PETALED_WHITE_ESSENCE_BLOCK, ModBlocks.pre_WHITE_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_TILED_MAGENTA_ESSENCE_BLOCK, ModBlocks.pre_MAGENTA_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_PETALED_MAGENTA_ESSENCE_BLOCK, ModBlocks.pre_MAGENTA_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_TILED_YELLOW_ESSENCE_BLOCK, ModBlocks.pre_YELLOW_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_PETALED_YELLOW_ESSENCE_BLOCK, ModBlocks.pre_YELLOW_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_TILED_LIME_ESSENCE_BLOCK, ModBlocks.pre_LIME_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_PETALED_LIME_ESSENCE_BLOCK, ModBlocks.pre_LIME_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_TILED_PINK_ESSENCE_BLOCK, ModBlocks.pre_PINK_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_PETALED_PINK_ESSENCE_BLOCK, ModBlocks.pre_PINK_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_TILED_LIGHT_GRAY_ESSENCE_BLOCK, ModBlocks.pre_LIGHT_GRAY_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_PETALED_LIGHT_GRAY_ESSENCE_BLOCK, ModBlocks.pre_LIGHT_GRAY_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_TILED_BROWN_ESSENCE_BLOCK, ModBlocks.pre_BROWN_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_PETALED_BROWN_ESSENCE_BLOCK, ModBlocks.pre_BROWN_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_TILED_GREEN_ESSENCE_BLOCK, ModBlocks.pre_GREEN_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_PETALED_GREEN_ESSENCE_BLOCK, ModBlocks.pre_GREEN_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_TILED_CYAN_ESSENCE_BLOCK, ModBlocks.pre_CYAN_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_PETALED_CYAN_ESSENCE_BLOCK, ModBlocks.pre_CYAN_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_TILED_PURPLE_ESSENCE_BLOCK, ModBlocks.pre_PURPLE_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_PETALED_PURPLE_ESSENCE_BLOCK, ModBlocks.pre_PURPLE_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_TILED_GRAY_ESSENCE_BLOCK, ModBlocks.pre_GRAY_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_PETALED_GRAY_ESSENCE_BLOCK, ModBlocks.pre_GRAY_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_TILED_LIGHT_BLUE_ESSENCE_BLOCK, ModBlocks.pre_LIGHT_BLUE_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_PETALED_LIGHT_BLUE_ESSENCE_BLOCK, ModBlocks.pre_LIGHT_BLUE_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_TILED_BLUE_ESSENCE_BLOCK, ModBlocks.pre_BLUE_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_PETALED_BLUE_ESSENCE_BLOCK, ModBlocks.pre_BLUE_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_TILED_ORANGE_ESSENCE_BLOCK, ModBlocks.pre_ORANGE_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_PETALED_ORANGE_ESSENCE_BLOCK, ModBlocks.pre_ORANGE_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_TILED_RED_ESSENCE_BLOCK, ModBlocks.pre_RED_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_PETALED_RED_ESSENCE_BLOCK, ModBlocks.pre_RED_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_TILED_BLACK_ESSENCE_BLOCK, ModBlocks.pre_BLACK_ESSENCE_BLOCK);
        offerStonecuttingRecipe(exporter, ModBlocks.pre_PETALED_BLACK_ESSENCE_BLOCK, ModBlocks.pre_BLACK_ESSENCE_BLOCK);

    }
}
