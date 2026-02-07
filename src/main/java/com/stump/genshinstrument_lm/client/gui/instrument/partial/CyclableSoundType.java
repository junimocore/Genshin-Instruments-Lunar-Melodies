package com.stump.genshinstrument_lm.client.gui.instrument.partial;

import com.stump.genshinstrument_lm.client.config.enumType.SoundType;

public interface CyclableSoundType<T extends SoundType> extends SoundType {
    public T getNext();
}
