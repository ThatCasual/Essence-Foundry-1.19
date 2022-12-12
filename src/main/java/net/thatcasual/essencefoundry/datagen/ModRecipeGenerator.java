package net.thatcasual.essencefoundry.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.thatcasual.essencefoundry.block.ModBlocks;
import net.thatcasual.essencefoundry.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    private void createSpawnEggRecipe(Consumer<RecipeJsonProvider> exporter, Item essence, Item result){
        ShapedRecipeJsonBuilder.create(result)
                .pattern("ExE")
                .pattern("xEx")
                .pattern("ExE")
                .input('E', essence)
                .input('x', Items.EGG)
                .criterion(RecipeProvider.hasItem(essence),
                        RecipeProvider.conditionsFromItem(essence))
                .criterion(RecipeProvider.hasItem(Items.EGG),
                        RecipeProvider.conditionsFromItem(Items.EGG))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(result)));
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {

        //Makes tiled and petaled variants of essence blocks craftable in the stonecutter.
        for(String key : ModBlocks.essenceBlocks.keySet()){
                offerStonecuttingRecipe(exporter, ModBlocks.tiledEssenceBlocks.get("tiled_"+key), ModBlocks.essenceBlocks.get(key));
                offerStonecuttingRecipe(exporter, ModBlocks.petaledEssenceBlocks.get("petaled_"+key), ModBlocks.essenceBlocks.get(key));
        }


        //Creates egg recipe for each essence as assigned in ModItems.essenceEggAssignments.
        for(String key : ModItems.essenceEggAssignments.keySet()){
            createSpawnEggRecipe(exporter, ModItems.essenceItems.get(key), ModItems.essenceEggAssignments.get(key));
        }

    }
}
