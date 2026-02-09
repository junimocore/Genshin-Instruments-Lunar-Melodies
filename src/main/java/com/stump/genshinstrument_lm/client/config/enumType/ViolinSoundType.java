package com.stump.genshinstrument_lm.client.config.enumType;

import com.stump.genshinstrument_lm.sound.GISounds;
import com.stump.genshinstrument_lm.sound.NoteSound;
import com.stump.genshinstrument_lm.sound.SoundOption;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public enum ViolinSoundType implements SoundType {
    SLOW(() -> new SoundOption(GISounds.VIOLIN_SLOW)),
    FAST(() -> new SoundOption(GISounds.VIOLIN_FAST)),
    PIZZ(() -> new SoundOption(GISounds.VIOLIN_PIZZICATO));

    private final Supplier<SoundOption> soundArr;
    private ViolinSoundType(final Supplier<SoundOption> soundType) {
        this.soundArr = soundType;
    }

    @Override
    public Supplier<SoundOption> getSoundArr() {
        return soundArr;
    }
}