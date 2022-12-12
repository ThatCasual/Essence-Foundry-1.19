package net.thatcasual.essencefoundry.item;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thatcasual.essencefoundry.EssenceFoundryMod;
import net.thatcasual.essencefoundry.item.custom.EssenceItem;

import java.util.LinkedHashMap;


public class ModItems extends Item{

    //Assign essence names to the spawn egg they craft.
    /*
    * All mob identifiers for loot table modification and spawn egg recipes are procedurally generated based on this hashmap.
    * Ensure ALL essence names are added here with their respective spawn eggs.
    * */
    public static LinkedHashMap<String, Item> essenceEggAssignments = new LinkedHashMap<>(){{
        put("skeleton_essence", Items.SKELETON_SPAWN_EGG);
        put("chicken_essence", Items.CHICKEN_SPAWN_EGG);
        put("ghast_essence", Items.GHAST_SPAWN_EGG);
        put("polar_bear_essence", Items.POLAR_BEAR_SPAWN_EGG);
        put("wolf_essence", Items.WOLF_SPAWN_EGG);
        put("sheep_essence", Items.SHEEP_SPAWN_EGG);
        put("skeleton_horse_essence", Items.SKELETON_HORSE_SPAWN_EGG);
        put("shulker_essence", Items.SHULKER_SPAWN_EGG);
        put("wandering_trader_essence", Items.WANDERING_TRADER_SPAWN_EGG);
        put("bee_essence", Items.BEE_SPAWN_EGG);
        put("llama_essence", Items.LLAMA_SPAWN_EGG);
        put("trader_llama_essence", Items.TRADER_LLAMA_SPAWN_EGG);
        put("fox_essence", Items.FOX_SPAWN_EGG);
        put("ocelot_essence", Items.OCELOT_SPAWN_EGG);
        put("pufferfish_essence", Items.PUFFERFISH_SPAWN_EGG);
        put("tropical_fish_essence", Items.TROPICAL_FISH_SPAWN_EGG);
        put("creeper_essence", Items.CREEPER_SPAWN_EGG);
        put("slime_essence", Items.SLIME_SPAWN_EGG);
        put("axolotl_essence", Items.AXOLOTL_SPAWN_EGG);
        put("pig_essence", Items.PIG_SPAWN_EGG);
        put("bat_essence", Items.BAT_SPAWN_EGG);
        put("cat_essence", Items.CAT_SPAWN_EGG);
        put("dolphin_essence", Items.DOLPHIN_SPAWN_EGG);
        put("goat_essence", Items.GOAT_SPAWN_EGG);
        put("panda_essence", Items.PANDA_SPAWN_EGG);
        put("stray_essence", Items.STRAY_SPAWN_EGG);
        put("rabbit_essence", Items.RABBIT_SPAWN_EGG);
        put("salmon_essence", Items.SALMON_SPAWN_EGG);
        put("squid_essence", Items.SQUID_SPAWN_EGG);
        put("witch_essence", Items.WITCH_SPAWN_EGG);
        put("cod_essence", Items.COD_SPAWN_EGG);
        put("cow_essence", Items.COW_SPAWN_EGG);
        put("husk_essence", Items.HUSK_SPAWN_EGG);
        put("donkey_essence", Items.DONKEY_SPAWN_EGG);
        put("horse_essence", Items.HORSE_SPAWN_EGG);
        put("mule_essence", Items.MULE_SPAWN_EGG);
        put("tadpole_essence", Items.TADPOLE_SPAWN_EGG);
        put("zombie_essence", Items.ZOMBIE_SPAWN_EGG);
        put("zombie_villager_essence", Items.ZOMBIE_VILLAGER_SPAWN_EGG);
        put("parrot_essence", Items.PARROT_SPAWN_EGG);
        put("turtle_essence", Items.TURTLE_SPAWN_EGG);
        put("cave_spider_essence", Items.CAVE_SPIDER_SPAWN_EGG);
        put("glow_squid_essence", Items.GLOW_SQUID_SPAWN_EGG);
        put("phantom_essence", Items.PHANTOM_SPAWN_EGG);
        put("endermite_essence", Items.ENDERMITE_SPAWN_EGG);
        put("silverfish_essence", Items.SILVERFISH_SPAWN_EGG);
        put("pillager_essence", Items.PILLAGER_SPAWN_EGG);
        put("vindicator_essence", Items.VINDICATOR_SPAWN_EGG);
        put("evoker_essence", Items.EVOKER_SPAWN_EGG);
        put("vex_essence", Items.VEX_SPAWN_EGG);
        put("ravager_essence", Items.RAVAGER_SPAWN_EGG);
        put("spider_essence", Items.SPIDER_SPAWN_EGG);
        put("allay_essence", Items.ALLAY_SPAWN_EGG);
        put("guardian_essence", Items.GUARDIAN_SPAWN_EGG);
        put("drowned_essence", Items.DROWNED_SPAWN_EGG);
        put("elder_guardian_essence", Items.ELDER_GUARDIAN_SPAWN_EGG);
        put("blaze_essence", Items.BLAZE_SPAWN_EGG);
        put("hoglin_essence", Items.HOGLIN_SPAWN_EGG);
        put("piglin_essence", Items.PIGLIN_SPAWN_EGG);
        put("piglin_brute_essence", Items.PIGLIN_BRUTE_SPAWN_EGG);
        put("zoglin_essence", Items.ZOGLIN_SPAWN_EGG);
        put("zombified_piglin_essence", Items.ZOMBIFIED_PIGLIN_SPAWN_EGG);
        put("magma_cube_essence", Items.MAGMA_CUBE_SPAWN_EGG);
        put("mooshroom_essence", Items.MOOSHROOM_SPAWN_EGG);
        put("strider_essence", Items.STRIDER_SPAWN_EGG);
        put("enderman_essence", Items.ENDERMAN_SPAWN_EGG);
        put("wither_skeleton_essence", Items.WITHER_SKELETON_SPAWN_EGG);
        put("warden_essence", Items.WARDEN_SPAWN_EGG);
    }};

    public static LinkedHashMap<String, Item> essenceItems = new LinkedHashMap<>();

    public ModItems(Settings settings) {
        super(settings);
    }

    private static Item registerItem(EssenceItem item){
        return Registry.register(Registry.ITEM, new Identifier(EssenceFoundryMod.MOD_ID, item.getItemName()), item);
    }

    public static void registerModItems(){
        EssenceFoundryMod.LOGGER.debug("Registering ModItems for " + EssenceFoundryMod.MOD_ID + "...");

        //Register an Item for each essence and add it to the essence_items hashmap.
        for(String key : essenceEggAssignments.keySet()){
            essenceItems.put(key, registerItem(new EssenceItem.EssenceItemBuilder().name(key).build()));
        }

        EssenceFoundryMod.LOGGER.debug("Finished registering ModItems for " + EssenceFoundryMod.MOD_ID + ".");
    }

}
