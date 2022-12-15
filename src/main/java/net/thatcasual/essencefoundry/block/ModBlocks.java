package net.thatcasual.essencefoundry.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thatcasual.essencefoundry.EssenceFoundryMod;
import net.thatcasual.essencefoundry.block.custom.EssenceBlock;
import net.thatcasual.essencefoundry.block.custom.ExtractorBlock;
import net.thatcasual.essencefoundry.util.DynamicTooltip;
import net.thatcasual.essencefoundry.util.DynamicTooltipBlockItem;
import net.thatcasual.essencefoundry.util.RegistrationData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;

public class ModBlocks extends Block {

    //Specifies essence block colors.
    public static final ArrayList<String> colors = new ArrayList<>(){{
       add("white");
       add("magenta");
       add("yellow");
       add("lime");
       add("pink");
       add("light_gray");
       add("brown");
       add("green");
       add("cyan");
       add("purple");
        add("gray");
       add("light_blue");
       add("blue");
       add("orange");
       add("red");
       add("black");
    }};
    //Specifies essence block variants.
    public static final ArrayList<String> styles = new ArrayList<>(){{
        add("");
        add("tiled_");
        add("petaled_");
    }};
    //Specifies essence block shapes.
    public static final ArrayList<String> shapes = new ArrayList<>(){{
        add("block");
    }};

    //LinkedHashMap for each style variant.
    public static LinkedHashMap<String, Block> essenceBlocks = new LinkedHashMap();
    public static LinkedHashMap<String, Block> tiledEssenceBlocks = new LinkedHashMap();
    public static LinkedHashMap<String, Block> petaledEssenceBlocks = new LinkedHashMap();

    //Links the style prefix with the hashmap so the mod knows where to put each block upon registration.
    //Underscore is added here at the end of any prefixes so that it will not be present for names without prefixes.
    public static HashMap<String, LinkedHashMap> styleMapAssignments = new HashMap<>(){{
        put("", essenceBlocks);
        put("tiled_", tiledEssenceBlocks);
        put("petaled_", petaledEssenceBlocks);
    }};

    //Other blocks.
    public static LinkedHashMap<String, Block> otherBlocks = new LinkedHashMap<>();

    public static Block registerBlock(Block block, RegistrationData regdata){
        registerBlockItem(block, regdata);
        return Registry.register(Registry.BLOCK, new Identifier(EssenceFoundryMod.MOD_ID, regdata.name), block);
    }

    public static Item registerBlockItem(Block block, RegistrationData regdata){
        return Registry.register(Registry.ITEM, new Identifier(EssenceFoundryMod.MOD_ID, regdata.name),
                new DynamicTooltipBlockItem(block, new FabricItemSettings().group(regdata.tab), regdata.dynamic_tooltip));
    }

    public static void  registerModBlocks(){
        EssenceFoundryMod.LOGGER.debug("Registering ModBlocks for " + EssenceFoundryMod.MOD_ID + "...");

        //Creates a registered block item for each possible color, style, and shape combination and adds it to the essenceBlocks map.
        String name;
        EssenceBlock essenceBlock;
        for(String color : colors){
            for(String style : styles){
                for(String shape : shapes){
                    name = style + color + "_essence_" + shape;
                    essenceBlock = new EssenceBlock.EssenceBlockBuilder().name(name).build();
                    styleMapAssignments.get(style).put(name, registerBlock(essenceBlock, essenceBlock.regdata));
                    System.out.println("Created " + name + " -- " + essenceBlocks.get(name));
                }
            }
        }

        //Other blocks.
        name = "extractor";
        ExtractorBlock extractorBlock = new ExtractorBlock.ExtractorBuilder()
                .name(name)
                .dynamicTooltip(new DynamicTooltip(Text.translatable("Used to extract obsidian tears from crying obsidian.").formatted(Formatting.LIGHT_PURPLE)))
                .build();
        otherBlocks.put(name, registerBlock(extractorBlock, extractorBlock.regdata));

        EssenceFoundryMod.LOGGER.debug("Finished registering ModBlocks for " + EssenceFoundryMod.MOD_ID + ".");
    }

    public ModBlocks(Settings settings) {
        super(settings);
    }
}
