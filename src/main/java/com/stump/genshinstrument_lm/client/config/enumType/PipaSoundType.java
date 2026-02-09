package com.stump.genshinstrument_lm.client.config.enumType;

import com.stump.genshinstrument_lm.sound.GISounds;
import com.stump.genshinstrument_lm.sound.SoundOption;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public enum PipaSoundType implements SoundType {
    REGULAR(() -> new SoundOption(GISounds.PIPA_REGULAR)),
    TREMOLO(() -> new SoundOption(GISounds.PIPA_TERMOLO));


    private final Supplier<SoundOption> soundArr;
    private PipaSoundType(final Supplier<SoundOption> soundType) {
        this.soundArr = soundType;
    }

    @Override
    public Supplier<SoundOption> getSoundArr() {
        return soundArr;
    }
}