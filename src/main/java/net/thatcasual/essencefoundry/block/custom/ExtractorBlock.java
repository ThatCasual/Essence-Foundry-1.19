package net.thatcasual.essencefoundry.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.thatcasual.essencefoundry.block.entity.ExtractorBlockEntity;
import net.thatcasual.essencefoundry.block.entity.ModBlockEntities;
import net.thatcasual.essencefoundry.item.ModItemGroups;
import net.thatcasual.essencefoundry.util.DynamicTooltip;
import net.thatcasual.essencefoundry.util.RegistrationData;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class ExtractorBlock extends BlockWithEntity implements BlockEntityProvider {

    public  static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static RegistrationData regdata = new RegistrationData();

    private static VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(0,0,0,16,12,16),
            Block.createCuboidShape(5,12,5,11,16,11))
            .reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
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

    //BLOCK ENTITY

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()){
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if(blockEntity instanceof ExtractorBlockEntity){
                ItemScatterer.spawn(world, pos, (ExtractorBlockEntity)blockEntity);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient){
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);
            if(screenHandlerFactory != null){
                player.openHandledScreen(screenHandlerFactory);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ExtractorBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.EXTRACTOR, ExtractorBlockEntity::tick);
    }

    //BUILDER & CONSTRUCTOR

    private ExtractorBlock(Settings settings, String name, ItemGroup tab, DynamicTooltip dynamic_tooltip) {
        super(settings);
        this.regdata.name = name;
        this.regdata.tab = tab;
        this.regdata.dynamic_tooltip = dynamic_tooltip;
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
