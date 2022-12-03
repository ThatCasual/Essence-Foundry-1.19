package net.thatcasual.essencefoundry;

import net.fabricmc.api.ModInitializer;
import net.thatcasual.essencefoundry.block.ModBlocks;
import net.thatcasual.essencefoundry.item.ModItems;
import net.thatcasual.essencefoundry.util.EssenceFoundryModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EssenceFoundryMod implements ModInitializer {
	public static final String MOD_ID = "essencefoundry";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final int BASIC_TIER = 1;
	public static final int ENCOUNTER_TIER = 2;
	public static final int NETHER_TIER = 3;
	public static final int END_TIER = 4;

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		EssenceFoundryModLootTableModifiers.modifyLootTables();

	}
}
