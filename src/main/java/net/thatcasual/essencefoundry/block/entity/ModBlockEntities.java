package net.thatcasual.essencefoundry.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thatcasual.essencefoundry.EssenceFoundryMod;
import net.thatcasual.essencefoundry.block.ModBlocks;
import net.thatcasual.essencefoundry.block.custom.ExtractorBlock;

import javax.swing.text.html.parser.Entity;

public class ModBlockEntities {

    public static BlockEntityType<ExtractorBlockEntity> EXTRACTOR;

    public static void registerBlockEntities(){
        EXTRACTOR = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(EssenceFoundryMod.MOD_ID, "extractor"),
                FabricBlockEntityTypeBuilder.create(ExtractorBlockEntity::new,
                        ModBlocks.otherBlocks.get("extractor")).build(null));
    }

}
