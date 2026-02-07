package com.stump.genshinstrument_lm.server.command;

import com.stump.genshinstrument_lm.GInstrumentMod;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.FORGE, modid = GInstrumentMod.MODID)
public class ModCommands {

    @SubscribeEvent
    public static void onCommandsRegister(final RegisterCommandsEvent event) {
        EMIRecordCommand.register(event.getDispatcher());
    }

}
