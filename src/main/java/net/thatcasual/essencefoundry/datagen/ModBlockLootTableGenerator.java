package net.thatcasual.essencefoundry.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.BlockLootTableGenerator;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.util.Identifier;
import net.thatcasual.essencefoundry.EssenceFoundryMod;
import net.thatcasual.essencefoundry.block.ModBlocks;

import java.util.function.BiConsumer;

public class ModBlockLootTableGenerator extends SimpleFabricLootTableProvider {

    public ModBlockLootTableGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator, LootContextTypes.BLOCK);
    }

    public void registerBlockDrop(BiConsumer<Identifier, LootTable.Builder> identifierBuilderBiConsumer, Block block, String name){
        identifierBuilderBiConsumer.accept(new Identifier(EssenceFoundryMod.MOD_ID, "blocks/extractor"),
                BlockLootTableGenerator.drops(ModBlocks.pre_EXTRACTOR));
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> identifierBuilderBiConsumer) {
        BiConsumer<Identifier, LootTable.Builder> biconsumer = identifierBuilderBiConsumer;

        registerBlockDrop(biconsumer, ModBlocks.pre_EXTRACTOR, ModBlocks.pre_EXTRACTOR.regdata.name);
    }
}
