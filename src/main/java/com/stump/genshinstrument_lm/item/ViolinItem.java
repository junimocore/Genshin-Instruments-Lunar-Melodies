package com.stump.genshinstrument_lm.item;

import com.stump.genshinstrument_lm.GInstrumentMod;
import com.stump.genshinstrument_lm.event.InstrumentPlayedEvent;
import com.stump.genshinstrument_lm.networking.packet.instrument.util.InstrumentPacketUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

class ViolinItem extends AccessoryInstrumentItem {
    public ViolinItem() {
        super((player) -> InstrumentPacketUtil.sendOpenPacket(
                player, new ResourceLocation(GInstrumentMod.MODID, "violin")
            ),
            (InstrumentAccessoryItem) ModItems.VIOLIN_BOW.get(),
            "Philharmonia"
        );
    }

    @Override
    public int hurtAccessoryBy(final InstrumentPlayedEvent<?> event, final ItemStack accessory) {
        return super.hurtAccessoryBy(event, accessory);
    }
}
