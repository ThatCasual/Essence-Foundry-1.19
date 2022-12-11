package net.thatcasual.essencefoundry.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.thatcasual.essencefoundry.item.ModItemGroups;
import net.thatcasual.essencefoundry.util.DynamicTooltip;
import net.thatcasual.essencefoundry.util.RegistrationData;
import org.jetbrains.annotations.Nullable;

public class ExtractorBlock extends HorizontalFacingBlock {

    public  static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static RegistrationData regdata = new RegistrationData();

    private ExtractorBlock(Settings settings, String name, ItemGroup tab, DynamicTooltip dynamic_tooltip) {
        super(settings);
        this.regdata.name = name;
        this.regdata.tab = tab;
        this.regdata.dynamic_tooltip = dynamic_tooltip;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public static class ExtractorBuilder {
        private String name = "unnamed";
        private Block.Settings settings = FabricBlockSettings
                .of(Material.STONE)
                .strength(3f)
                .requiresTool()
                .nonOpaque();
        private ItemGroup tab = ModItemGroups.ESSENCE_FOUNDRY;
        private DynamicTooltip dynamic_tooltip = new DynamicTooltip();

        public ExtractorBuilder settings(Settings settings){
            this.settings = settings;
            return this;
        }
        public ExtractorBuilder name(String name){
            this.name = name;
            return this;
        }
        public ExtractorBuilder tab(ItemGroup tab){
            this.tab = tab;
            return this;
        }
        public ExtractorBuilder dynamicTooltip(DynamicTooltip dynamic_tooltip){
            this.dynamic_tooltip = dynamic_tooltip;
            return this;
        }

        public ExtractorBlock build(){
            return new ExtractorBlock(this.settings, this.name, this.tab, this.dynamic_tooltip);
        }

    }

}
