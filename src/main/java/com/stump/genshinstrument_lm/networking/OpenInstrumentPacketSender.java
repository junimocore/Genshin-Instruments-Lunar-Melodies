package com.stump.genshinstrument_lm.networking;

import net.minecraft.server.level.ServerPlayer;

@FunctionalInterface
public interface OpenInstrumentPacketSender {
    void send(final ServerPlayer player);
}