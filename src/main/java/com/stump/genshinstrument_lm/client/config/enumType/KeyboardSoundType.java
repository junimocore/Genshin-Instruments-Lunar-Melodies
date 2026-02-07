package com.stump.genshinstrument_lm.client.config.enumType;

import com.stump.genshinstrument_lm.sound.GISounds;
import com.stump.genshinstrument_lm.sound.NoteSound;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public enum KeyboardSoundType implements SoundType {
    EMI(() -> GISounds.KEYBOARD),
    GW2(() -> GISounds.KEYBOARD_GW2),
    YAMAHA_C5(() -> GISounds.KEYBOARD_YAMAHA_C5);

    private Supplier<NoteSound[]> soundArr;
    private KeyboardSoundType(final Supplier<NoteSound[]> soundType) {
        this.soundArr = soundType;
    }

    @Override
    public Supplier<NoteSound[]> getSoundArr() {
        return soundArr;
    }
}