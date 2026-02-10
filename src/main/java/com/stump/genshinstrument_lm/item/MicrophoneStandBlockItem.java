package com.stump.genshinstrument_lm.item;

import com.stump.genshinstrument_lm.block.KeyboardStandBlock;
import com.stump.genshinstrument_lm.item.partial.instrument.CreditableBlockInstrumentItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class MicrophoneStandBlockItem extends CreditableBlockInstrumentItem {

    public MicrophoneStandBlockItem(Block pBlock, Properties pProperties, String credit) {
        super(pBlock, pProperties, credit);
    }
}
