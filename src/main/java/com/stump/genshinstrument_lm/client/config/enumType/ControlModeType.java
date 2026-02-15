package com.stump.genshinstrument_lm.client.config.enumType;

import java.util.Locale;

public enum ControlModeType {
    DEFAULT,
    OCTAVE_SWAP;

    public String getKey() {
        return "button.genshinstrument_lm.control_mode." + toString().toLowerCase(Locale.ENGLISH);
    }
}
