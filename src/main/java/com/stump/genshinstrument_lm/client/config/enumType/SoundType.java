package com.stump.genshinstrument_lm.client.config.enumType;

import com.stump.genshinstrument_lm.sound.NoteSound;
import com.stump.genshinstrument_lm.sound.SoundOption;

import java.util.Locale;
import java.util.function.Supplier;

public interface SoundType {
    Supplier<SoundOption> getSoundArr();

    /**
     * @return The name of this sound type
     * as in the translation files
     */
    default String getName() {
        return toString().toLowerCase(Locale.ENGLISH);
    }
}
