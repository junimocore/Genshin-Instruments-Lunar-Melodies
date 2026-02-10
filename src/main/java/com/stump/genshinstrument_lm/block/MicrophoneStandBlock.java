package com.stump.genshinstrument_lm.block;

import com.stump.genshinstrument_lm.GInstrumentMod;
import com.stump.genshinstrument_lm.block.partial.DoubleInstrumentBlock;
import com.stump.genshinstrument_lm.block.partial.DoubleVerticalBlock;
import com.stump.genshinstrument_lm.networking.packet.instrument.util.InstrumentPacketUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MicrophoneStandBlock extends DoubleVerticalBlock {
    public static final VoxelShape
            SHAPE_BOTTOM_SOUTH = Block.box(5, 0, 5, 11, 16, 11),
            SHAPE_BOTTOM_EAST  = Block.box(5, 0, 5, 11, 16, 11),

            SHAPE_TOP_SOUTH    = Block.box(5, 0, 5, 11, 9, 11),
            SHAPE_TOP_EAST     = Block.box(5, 0, 5, 11, 9, 11);


    public MicrophoneStandBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected void onInstrumentOpen(ServerPlayer player) {
        InstrumentPacketUtil.sendOpenPacket(player, new ResourceLocation(GInstrumentMod.MODID, "microphone_stand"));
    }


    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        final Direction facing = pState.getValue(FACING);
        final boolean southOrNorth = (facing == Direction.SOUTH) || (facing == Direction.NORTH);

        return (pState.getValue(PART) == BlockPart.BOTTOM)
                ? (southOrNorth ? SHAPE_BOTTOM_SOUTH : SHAPE_BOTTOM_EAST)
                : (southOrNorth ? SHAPE_TOP_SOUTH : SHAPE_TOP_EAST);
    }

}