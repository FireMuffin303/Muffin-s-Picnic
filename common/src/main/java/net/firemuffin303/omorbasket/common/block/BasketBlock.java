package net.firemuffin303.omorbasket.common.block;

import net.firemuffin303.omorbasket.common.block.entity.BasketBlockEntity;
import net.firemuffin303.omorbasket.common.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BasketBlock extends BaseEntityBlock implements SimpleWaterloggedBlock{
    public static final DirectionProperty FACING;
    public static final ResourceLocation CONTENTS;
    public static final BooleanProperty WATERLOGGED;
    public static final VoxelShape R_AABB = Block.box(2.0D, 0.0D, 1.0D, 14.0D, 10.0D, 15.0D);
    public static final VoxelShape AABB = Block.box(1.0D, 0.0D, 2.0D, 15.0D, 10.0D, 14.0D);

    public BasketBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any().setValue(FACING, Direction.NORTH)).setValue(WATERLOGGED,false));

    }

    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof BasketBlockEntity) {
                player.openMenu((BasketBlockEntity)blockEntity);
                player.awardStat(Stats.OPEN_BARREL);
                PiglinAi.angerNearbyPiglins(player, true);
            }

            return InteractionResult.CONSUME;
        }
    }

    public void playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof BasketBlockEntity basketBlockEntity) {
            if (!level.isClientSide && player.isCreative() && !basketBlockEntity.isEmpty()) {
                ItemStack itemStack = new ItemStack(ModBlocks.WHITE_PICNIC_BASKET);
                blockEntity.saveToItem(itemStack);
                if (basketBlockEntity.hasCustomName()) {
                    itemStack.setHoverName(basketBlockEntity.getCustomName());
                }

                ItemEntity itemEntity = new ItemEntity(level, (double)blockPos.getX() + 0.5D, (double)blockPos.getY() + 0.5D, (double)blockPos.getZ() + 0.5D, itemStack);
                itemEntity.setDefaultPickUpDelay();
                level.addFreshEntity(itemEntity);
            } else {
                basketBlockEntity.unpackLootTable(player);
            }
        }

        super.playerWillDestroy(level, blockPos, blockState, player);
    }

    public List<ItemStack> getDrops(BlockState blockState, LootParams.Builder builder) {
        BlockEntity blockEntity = (BlockEntity)builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (blockEntity instanceof BasketBlockEntity basketBlockEntity) {
            builder = builder.withDynamicDrop(CONTENTS, (consumer) -> {
                for(int i = 0; i < basketBlockEntity.getContainerSize(); ++i) {
                    consumer.accept(basketBlockEntity.getItem(i));
                }

            });
        }

        return super.getDrops(blockState, builder);
    }

    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, LivingEntity livingEntity, ItemStack itemStack) {
        if (itemStack.hasCustomHoverName()) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof BasketBlockEntity) {
                ((BasketBlockEntity)blockEntity).setCustomName(itemStack.getHoverName());
            }
        }

    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return switch (blockState.getValue(FACING)) {
            case EAST, WEST -> R_AABB;
            default -> AABB;
        };
    }

    public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        if (!blockState.is(blockState2.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof BasketBlockEntity) {
                level.updateNeighbourForOutputSignal(blockPos, blockState.getBlock());
            }

            super.onRemove(blockState, level, blockPos, blockState2, bl);
        }
    }

    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    public boolean hasAnalogOutputSignal(BlockState blockState) {
        return true;
    }

    public int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos blockPos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(blockPos));
    }

    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return (BlockState)blockState.setValue(FACING, rotation.rotate((Direction)blockState.getValue(FACING)));
    }

    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation((Direction)blockState.getValue(FACING)));
    }



    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        return (BlockState)this.defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new BasketBlockEntity(blockPos,blockState);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING,WATERLOGGED});
    }

    public boolean isPathfindable(BlockState arg, BlockGetter arg2, BlockPos arg3, PathComputationType arg4) {
        return false;
    }

    static{
        FACING = HorizontalDirectionalBlock.FACING;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        CONTENTS = new ResourceLocation("contents");
    }
}
