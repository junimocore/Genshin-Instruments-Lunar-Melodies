package com.stump.genshinstrument_lm.client.gui.instrument.pipa;

import com.stump.genshinstrument_lm.client.gui.instrument.partial.CyclableSoundType;
import com.stump.genshinstrument_lm.sound.GISounds;
import com.stump.genshinstrument_lm.sound.NoteSound;

import java.util.function.Supplier;

public enum PipaSoundType implements CyclableSoundType<PipaSoundType> {
    REGULAR(() -> GISounds.PIPA_REGULAR),
    TREMOLO(() -> GISounds.PIPA_TERMOLO);

    private final Supplier<NoteSound[]> soundArr;
    private PipaSoundType(final Supplier<NoteSound[]> soundType) {
        this.soundArr = soundType;
    }

    public Supplier<NoteSound[]> getSoundArr() {
        return soundArr;
    }

    public PipaSoundType getNext() {
        return values()[(ordinal() + 1) % values().length];
    }

}
