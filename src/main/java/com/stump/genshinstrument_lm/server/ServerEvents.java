package com.stump.genshinstrument_lm.server;

import com.stump.genshinstrument_lm.GInstrumentMod;
import com.stump.genshinstrument_lm.util.LooperRecordStateUtil;
import com.stump.genshinstrument_lm.event.InstrumentOpenStateChangedEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.FORGE, modid = GInstrumentMod.MODID)
public class ServerEvents {

    @SubscribeEvent
    public static void onInstrumentClosedStateClosed(final InstrumentOpenStateChangedEvent event) {
        if (event.player.level().isClientSide)
            return;

        if (!event.isOpen) {
            LooperRecordStateUtil.handle((ServerPlayer) event.player, event.hand, false);
        }
    }

}
