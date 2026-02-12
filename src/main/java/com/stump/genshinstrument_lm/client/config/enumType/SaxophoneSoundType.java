package com.stump.genshinstrument_lm.client.config.enumType;

import com.stump.genshinstrument_lm.sound.GISounds;
import com.stump.genshinstrument_lm.sound.SoundOption;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public enum SaxophoneSoundType implements SoundType {
    EMI(() -> new SoundOption(GISounds.SAXOPHONE)),
    BARITONE(() -> new SoundOption(GISounds.SAXOPHONE_BARITONE)),
    TENOR(() -> new SoundOption(GISounds.SAXOPHONE_TENOR));

    private final Supplier<SoundOption> soundArr;
    private SaxophoneSoundType(final Supplier<SoundOption> soundType) {
        this.soundArr = soundType;
    }

    @Override
    public Supplier<SoundOption> getSoundArr() {
        return soundArr;
    }
}