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

        //Stonecutter recipes for tiled and pedaled essence blocks.
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

        //Spawn egg crafting recipes.
        createSpawnEggRecipe(exporter, ModItems.pre_SKELETON_ESSENCE, Items.SKELETON_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_CHICKEN_ESSENCE, Items.CHICKEN_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_GHAST_ESSENCE, Items.GHAST_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_POLAR_BEAR_ESSENCE, Items.POLAR_BEAR_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_WOLF_ESSENCE, Items.WOLF_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_SHEEP_ESSENCE, Items.SHEEP_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_SKELETON_HORSE_ESSENCE, Items.SKELETON_HORSE_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_SHULKER_ESSENCE, Items.SHULKER_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_WANDERING_TRADER_ESSENCE, Items.WANDERING_TRADER_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_BEE_ESSENCE, Items.BEE_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_LLAMA_ESSENCE, Items.LLAMA_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_TRADER_LLAMA_ESSENCE, Items.TRADER_LLAMA_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_FOX_ESSENCE, Items.FOX_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_OCELOT_ESSENCE, Items.OCELOT_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_PUFFERFISH_ESSENCE, Items.PUFFERFISH_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_TROPICAL_FISH_ESSENCE, Items.TROPICAL_FISH_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_CREEPER_ESSENCE, Items.CREEPER_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_SLIME_ESSENCE, Items.SLIME_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_AXOLOTL_ESSENCE, Items.AXOLOTL_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_PIG_ESSENCE, Items.PIG_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_BAT_ESSENCE, Items.BAT_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_CAT_ESSENCE, Items.CAT_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_DOLPHIN_ESSENCE, Items.DOLPHIN_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_GOAT_ESSENCE, Items.GOAT_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_PANDA_ESSENCE, Items.PANDA_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_STRAY_ESSENCE, Items.STRAY_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_RABBIT_ESSENCE, Items.RABBIT_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_SALMON_ESSENCE, Items.SALMON_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_SQUID_ESSENCE, Items.SQUID_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_WITCH_ESSENCE, Items.WITCH_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_COD_ESSENCE, Items.COD_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_COW_ESSENCE, Items.COW_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_HUSK_ESSENCE, Items.HUSK_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_DONKEY_ESSENCE, Items.DONKEY_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_HORSE_ESSENCE, Items.HORSE_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_MULE_ESSENCE, Items.MULE_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_TADPOLE_ESSENCE, Items.TADPOLE_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_ZOMBIE_ESSENCE, Items.ZOMBIE_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_ZOMBIE_VILLAGER_ESSENCE, Items.ZOMBIE_VILLAGER_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_PARROT_ESSENCE, Items.PARROT_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_TURTLE_ESSENCE, Items.TURTLE_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_CAVE_SPIDER_ESSENCE, Items.CAVE_SPIDER_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_GLOW_SQUID_ESSENCE, Items.GLOW_SQUID_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_PHANTOM_ESSENCE, Items.PHANTOM_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_ENDERMITE_ESSENCE, Items.ENDERMITE_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_SILVERFISH_ESSENCE, Items.SILVERFISH_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_PILLAGER_ESSENCE, Items.PILLAGER_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_VINDICATOR_ESSENCE, Items.VINDICATOR_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_EVOKER_ESSENCE, Items.EVOKER_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_VEX_ESSENCE, Items.VEX_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_RAVAGER_ESSENCE, Items.RAVAGER_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_SPIDER_ESSENCE, Items.SPIDER_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_ALLAY_ESSENCE, Items.ALLAY_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_GUARDIAN_ESSENCE, Items.GUARDIAN_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_DROWNED_ESSENCE, Items.DROWNED_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_ELDER_GUARDIAN_ESSENCE, Items.ELDER_GUARDIAN_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_BLAZE_ESSENCE, Items.BLAZE_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_HOGLIN_ESSENCE, Items.HOGLIN_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_PIGLIN_ESSENCE, Items.PIGLIN_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_PIGLIN_BRUTE_ESSENCE, Items.PIGLIN_BRUTE_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_ZOGLIN_ESSENCE, Items.ZOGLIN_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_ZOMBIFIED_PIGLIN_ESSENCE, Items.ZOMBIFIED_PIGLIN_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_MAGMA_CUBE_ESSENCE, Items.MAGMA_CUBE_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_MOOSHROOM_ESSENCE, Items.MOOSHROOM_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_STRIDER_ESSENCE, Items.STRIDER_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_ENDERMAN_ESSENCE, Items.ENDERMAN_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_WITHER_SKELETON_ESSENCE, Items.WITHER_SKELETON_SPAWN_EGG);
        createSpawnEggRecipe(exporter, ModItems.pre_WARDEN_ESSENCE, Items.WARDEN_SPAWN_EGG);

    }
}
