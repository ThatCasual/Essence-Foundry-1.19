package net.thatcasual.essencefoundry.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.BlockLootTableGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.util.Identifier;
import net.thatcasual.essencefoundry.EssenceFoundryMod;
import net.thatcasual.essencefoundry.block.ModBlocks;

import java.util.LinkedHashMap;
import java.util.function.BiConsumer;

public class ModBlockLootTableGenerator extends SimpleFabricLootTableProvider {

    public ModBlockLootTableGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator, LootContextTypes.BLOCK);
    }

    /*public void registerBlockDropsFor(LinkedHashMap map, BiConsumer<Identifier, LootTable.Builder> biconsumer){
        for(String key : map.keySet()){
            biconsumer.accept(new Identifier(EssenceFoundryMod.MOD_ID, "blocks/"+key),
                    BlockLootTableGenerator.drops(map.get(key)));
        }

    }*/

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> biconsumer) {

        for(String key : ModBlocks.essenceBlocks.keySet()){
            biconsumer.accept(new Identifier(EssenceFoundryMod.MOD_ID, "blocks/"+key),
                    BlockLootTableGenerator.drops(ModBlocks.essenceBlocks.get(key)));
        }
        for(String key : ModBlocks.tiledEssenceBlocks.keySet()){
            biconsumer.accept(new Identifier(EssenceFoundryMod.MOD_ID, "blocks/"+key),
                    BlockLootTableGenerator.drops(ModBlocks.tiledEssenceBlocks.get(key)));
        }
        for(String key : ModBlocks.petaledEssenceBlocks.keySet()){
            biconsumer.accept(new Identifier(EssenceFoundryMod.MOD_ID, "blocks/"+key),
                    BlockLootTableGenerator.drops(ModBlocks.petaledEssenceBlocks.get(key)));
        }
        for(String key : ModBlocks.otherBlocks.keySet()){
            biconsumer.accept(new Identifier(EssenceFoundryMod.MOD_ID, "blocks/"+key),
                    BlockLootTableGenerator.drops(ModBlocks.otherBlocks.get(key)));
        }

    }

}
