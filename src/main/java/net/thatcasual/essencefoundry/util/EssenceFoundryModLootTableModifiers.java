package net.thatcasual.essencefoundry.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;
import net.thatcasual.essencefoundry.item.ModItems;

public class EssenceFoundryModLootTableModifiers {

    private static final Identifier SKELETON_ID
            = new Identifier("minecraft", "entities/skeleton");
    private static  final Identifier CHICKEN_ID
            = new Identifier("minecraft", "entities/chicken");
    private static  final Identifier GHAST_ID
            = new Identifier("minecraft", "entities/ghast");
    private static  final Identifier POLAR_BEAR_ID
            = new Identifier("minecraft", "entities/polar_bear");
    private static  final Identifier WOLF_ID
            = new Identifier("minecraft", "entities/wolf");
    private static  final Identifier SHEEP_ID
            = new Identifier("minecraft", "entities/sheep");
    private static  final Identifier SKELETON_HORSE_ID
            = new Identifier("minecraft", "entities/skeleton_horse");
    private static  final Identifier SHULK_ID
            = new Identifier("minecraft", "entities/shulk");
    private static  final Identifier WANDERING_TRADER_ID
            = new Identifier("minecraft", "entities/wandering_trader");
    private static  final Identifier BEE_ID
            = new Identifier("minecraft", "entities/bee");
    private static  final Identifier LLAMA_ID
            = new Identifier("minecraft", "entities/llama");
    private static  final Identifier TRADER_LLAMA_ID
            = new Identifier("minecraft", "entities/trader_llama");
    private static  final Identifier FOX_ID
            = new Identifier("minecraft", "entities/fox");
    private static  final Identifier OCELOT_ID
            = new Identifier("minecraft", "entities/ocelot");
    private static  final Identifier PUFFERFISH_ID
            = new Identifier("minecraft", "entities/pufferfish");
    private static  final Identifier TROPICAL_FISH_ID
            = new Identifier("minecraft", "entities/tropical_fish");
    private static  final Identifier CREEPER_ID
            = new Identifier("minecraft", "entities/creeper");
    private static  final Identifier SLIME_ID
            = new Identifier("minecraft", "entities/slime");
    private static  final Identifier AXOLOTL_ID
            = new Identifier("minecraft", "entities/axolotl");
    private static  final Identifier PIG_ID
            = new Identifier("minecraft", "entities/pig");
    private static  final Identifier BAT_ID
            = new Identifier("minecraft", "entities/bat");
    private static  final Identifier CAT_ID
            = new Identifier("minecraft", "entities/cat");
    private static  final Identifier DOLPHIN_ID
            = new Identifier("minecraft", "entities/dolphin");
    private static  final Identifier GOAT_ID
            = new Identifier("minecraft", "entities/goat");
    private static  final Identifier PANDA_ID
            = new Identifier("minecraft", "entities/panda");
    private static  final Identifier STRAY_ID
            = new Identifier("minecraft", "entities/stray");
    private static  final Identifier RABBIT_ID
            = new Identifier("minecraft", "entities/rabbit");
    private static  final Identifier SALMON_ID
            = new Identifier("minecraft", "entities/salmon");
    private static  final Identifier SQUID_ID
            = new Identifier("minecraft", "entities/squid");
    private static  final Identifier WITCH_ID
            = new Identifier("minecraft", "entities/witch");
    private static  final Identifier COD_ID
            = new Identifier("minecraft", "entities/cod");
    private static  final Identifier COW_ID
            = new Identifier("minecraft", "entities/cow");
    private static  final Identifier HUSK_ID
            = new Identifier("minecraft", "entities/husk");
    private static  final Identifier DONKEY_ID
            = new Identifier("minecraft", "entities/donkey");
    private static  final Identifier HORSE_ID
            = new Identifier("minecraft", "entities/hrose");
    private static  final Identifier MULE_ID
            = new Identifier("minecraft", "entities/mule");
    private static  final Identifier TADPOLE_ID
            = new Identifier("minecraft", "entities/tadpole");
    private static final Identifier ZOMBIE_ID
            = new Identifier("minecraft", "entities/zombie");
    private static  final Identifier ZOMBIE_VILLAGER_ID
            = new Identifier("minecraft", "entities/zombie_villager");
    private static  final Identifier PARROT_ID
            = new Identifier("minecraft", "entities/parrot");
    private static  final Identifier TURTLE_ID
            = new Identifier("minecraft", "entities/turtle");
    private static  final Identifier CAVE_SPIDER_ID
            = new Identifier("minecraft", "entities/cave_spider");
    private static  final Identifier GLOW_SQUID_ID
            = new Identifier("minecraft", "entities/glow_squid");
    private static  final Identifier PHANTOM_ID
            = new Identifier("minecraft", "entities/phantom");
    private static  final Identifier ENDERMITE_ID
            = new Identifier("minecraft", "entities/endermite");
    private static  final Identifier SILVERFISH_ID
            = new Identifier("minecraft", "entities/silverfish");
    private static  final Identifier PILLAGER_ID
            = new Identifier("minecraft", "entities/pillager");
    private static  final Identifier VINDICATOR_ID
            = new Identifier("minecraft", "entities/vindicator");
    private static  final Identifier EVOKER_ID
            = new Identifier("minecraft", "entities/evoker");
    private static  final Identifier VEX_ID
            = new Identifier("minecraft", "entities/vex");
    private static  final Identifier RAVAGER_ID
            = new Identifier("minecraft", "entities/ravager");
    private static  final Identifier SPIDER_ID
            = new Identifier("minecraft", "entities/spider");
    private static  final Identifier ALLAY_ID
            = new Identifier("minecraft", "entities/allay");
    private static  final Identifier GUARDIAN_ID
            = new Identifier("minecraft", "entities/guardian");
    private static  final Identifier ELDER_GUARDIAN_ID
            = new Identifier("minecraft", "entities/elder_guardian");
    private static  final Identifier DROWNED_ID
            = new Identifier("minecraft", "entities/drowned");
    private static  final Identifier BLAZE_ID
            = new Identifier("minecraft", "entities/blaze");
    private static  final Identifier HOGLIN_ID
            = new Identifier("minecraft", "entities/hoglin");
    private static  final Identifier PIGLIN_ID
            = new Identifier("minecraft", "entities/piglin");
    private static  final Identifier PIGLIN_BRUTE_ID
            = new Identifier("minecraft", "entities/piglin_brute");
    private static  final Identifier ZOGLIN_ID
            = new Identifier("minecraft", "entities/zoglin");
    private static  final Identifier ZOMBIFIED_PIGLIN_ID
            = new Identifier("minecraft", "entities/zombified_piglin");
    private static  final Identifier MAGMA_CUBE_ID
            = new Identifier("minecraft", "entities/magma_cube");
    private static  final Identifier MOOSHROOM_ID
            = new Identifier("minecraft", "entities/mooshroom");
    private static  final Identifier STRIDER_ID
            = new Identifier("minecraft", "entities/strider");
    private static  final Identifier ENDERMAN_ID
            = new Identifier("minecraft", "entities/enderman");
    private static  final Identifier WITHER_SKELETON_ID
            = new Identifier("minecraft", "entities/skeleton");
    private static  final Identifier WARDEN_ID
            = new Identifier("minecraft", "entities/warden");

    public static void  modifyLootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {

            if(SKELETON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_SKELETON_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(CHICKEN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_CHICKEN_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(GHAST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_GHAST_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(POLAR_BEAR_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_POLAR_BEAR_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(WOLF_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_WOLF_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(SHEEP_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_SHEEP_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(SKELETON_HORSE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_SKELETON_HORSE_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(SHULK_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_SHULK_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(WANDERING_TRADER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_WANDERING_TRADER_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(BEE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_BEE_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(LLAMA_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_LLAMA_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(TRADER_LLAMA_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_TRADER_LLAMA_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(FOX_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_FOX_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(OCELOT_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_OCELOT_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(PUFFERFISH_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_PUFFERFISH_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(TROPICAL_FISH_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_TROPICAL_FISH_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(CREEPER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_CREEPER_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(SLIME_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_SLIME_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(AXOLOTL_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_AXOLOTL_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(PIG_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_PIG_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(BAT_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_BAT_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(CAT_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_CAT_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(DOLPHIN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_DOLPHIN_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(GOAT_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_GOAT_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(PANDA_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_PANDA_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(STRAY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_STRAY_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(RABBIT_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_RABBIT_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(SALMON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_SALMON_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(SQUID_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_SQUID_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(WITCH_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_WITCH_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(COD_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_COD_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(COW_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_COW_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(HUSK_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_HUSK_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(DONKEY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_DONKEY_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(HORSE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_HORSE_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(MULE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_MULE_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(TADPOLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_TADPOLE_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(ZOMBIE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_ZOMBIE_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(ZOMBIE_VILLAGER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_ZOMBIE_VILLAGER_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(PARROT_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_PARROT_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(TURTLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_TURTLE_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(CAVE_SPIDER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_CAVE_SPIDER_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(GLOW_SQUID_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                    .with(ItemEntry.builder(ModItems.pre_GLOW_SQUID_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(PHANTOM_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_PHANTOM_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(ENDERMITE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_ENDERMITE_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(SILVERFISH_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_SILVERFISH_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(PILLAGER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_PILLAGER_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(VINDICATOR_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_VINDICATOR_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(EVOKER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_EVOKER_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(VEX_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_VEX_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(RAVAGER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_RAVAGER_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(SPIDER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_SPIDER_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(ALLAY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_ALLAY_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(GUARDIAN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_GUARDIAN_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(ELDER_GUARDIAN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_ELDER_GUARDIAN_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(DROWNED_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_DROWNED_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if( BLAZE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_BLAZE_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(HOGLIN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_HOGLIN_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(PIGLIN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_PIGLIN_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(PIGLIN_BRUTE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_PIGLIN_BRUTE_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(ZOGLIN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_ZOGLIN_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(ZOMBIFIED_PIGLIN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_ZOMBIFIED_PIGLIN_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(MAGMA_CUBE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_MAGMA_CUBE_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(MOOSHROOM_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_MOOSHROOM_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(STRIDER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_STRIDER_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(ENDERMAN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_ENDERMAN_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(WITHER_SKELETON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_WITHER_SKELETON_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

            if(WARDEN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) //Drops 1 essence.
                        .conditionally(RandomChanceLootCondition.builder(.05f)) //5% drop chance.
                        .with(ItemEntry.builder(ModItems.pre_WARDEN_ESSENCE));
                tableBuilder.pool(poolBuilder.build());
            }

        });
    }

}
