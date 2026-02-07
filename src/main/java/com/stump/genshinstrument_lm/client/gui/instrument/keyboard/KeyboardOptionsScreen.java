package com.stump.genshinstrument_lm.client.gui.instrument.keyboard;

import com.stump.genshinstrument_lm.client.config.ModClientConfigs;
import com.stump.genshinstrument_lm.client.config.enumType.KeyboardSoundType;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.InstrumentScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.grid.GridInstrumentScreen;
import com.stump.genshinstrument_lm.client.gui.options.partial.SoundTypeOptionsScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KeyboardOptionsScreen extends SoundTypeOptionsScreen<KeyboardSoundType> {
    private static final String SOUND_TYPE_KEY = "button.genshinstrument_lm.keyboard.soundType",
        OPTIONS_LABEL_KEY = "label.genshinstrument_lm.keyboard_options";
    
    public KeyboardOptionsScreen(final GridInstrumentScreen screen) {
        super(screen);
    }
    

    @Override
    protected String soundTypeButtonKey() {
        return SOUND_TYPE_KEY;
    }
    @Override
    protected String optionsLabelKey() {
        return OPTIONS_LABEL_KEY;
    }


    @Override
    protected KeyboardSoundType getInitSoundType() {
        return ModClientConfigs.KEYBOARD_SOUND_TYPE.get();
    }

    @Override
    protected KeyboardSoundType[] values() {
        return KeyboardSoundType.values();
    }


    @Override
    protected void saveSoundType(KeyboardSoundType soundType) {
        ModClientConfigs.KEYBOARD_SOUND_TYPE.set(soundType);
    }

    @Override
    protected boolean isValidForSet(InstrumentScreen screen) {
        return screen instanceof KeyboardScreen;
    }
}
