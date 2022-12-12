package net.thatcasual.essencefoundry.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;
import net.thatcasual.essencefoundry.item.ModItems;

import java.util.LinkedHashMap;

public class EssenceFoundryModLootTableModifiers {

    public static LinkedHashMap<String, Identifier> mob_identifiers = new LinkedHashMap<>(){{
        //Creates a mob Identifier for each essence in ModItems.essenceItems.
        String mob;
        for(String key : ModItems.essenceItems.keySet()){
            mob = key.substring(0, key.length()-8);
            put(mob, new Identifier("minecraft","entities/"+mob));
        }
    }};

    public static void  modifyLootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {

            //Creates a 5% essence drop chance for each mob.
            for(var key : mob_identifiers.keySet()){
                if(mob_identifiers.get(key).equals(id)){
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                            .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                            .with(ItemEntry.builder(ModItems.essenceItems.get(key+"_essence")));
                    tableBuilder.pool(poolBuilder.build());
                }
            }
        });
    }

}
