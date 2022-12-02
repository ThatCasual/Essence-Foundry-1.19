package net.thatcasual.essencefoundry.util;

import net.fabricmc.fabric.api.loot.v2.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.util.Identifier;
import net.thatcasual.essencefoundry.item.ModItems;

public class EssenceFoundryModLootTableModifiers {

    private static final Identifier SKELETON_ID
            = new Identifier("minecraft", "entities/skeleton");
    private static final Identifier ZOMBIE_ID
            = new Identifier("minecraft", "entities/zombie");

    public static void  modifyLootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {

            if(SKELETON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.SKELETON_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(ZOMBIE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.ZOMBIE_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

        });
    }

}
