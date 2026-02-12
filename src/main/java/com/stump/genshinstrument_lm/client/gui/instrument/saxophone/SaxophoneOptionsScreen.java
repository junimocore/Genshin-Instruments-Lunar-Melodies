package com.stump.genshinstrument_lm.client.gui.instrument.saxophone;

import com.stump.genshinstrument_lm.client.config.ModClientConfigs;
import com.stump.genshinstrument_lm.client.config.enumType.SaxophoneSoundType;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.InstrumentScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.grid.GridInstrumentScreen;
import com.stump.genshinstrument_lm.client.gui.options.partial.SoundTypeOptionsScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SaxophoneOptionsScreen extends SoundTypeOptionsScreen<SaxophoneSoundType> {
    private static final String SOUND_TYPE_KEY = "button.genshinstrument_lm.saxophone.soundType",
        OPTIONS_LABEL_KEY = "label.genshinstrument_lm.saxophone_options";

    public SaxophoneOptionsScreen(final GridInstrumentScreen screen) {
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
    protected SaxophoneSoundType getInitSoundType() {
        return ModClientConfigs.SAXOPHONE_SOUND_TYPE.get();
    }

    @Override
    protected SaxophoneSoundType[] values() {
        return SaxophoneSoundType.values();
    }


    @Override
    protected void saveSoundType(SaxophoneSoundType soundType) {
        ModClientConfigs.SAXOPHONE_SOUND_TYPE.set(soundType);
    }

    @Override
    protected boolean isValidForSet(InstrumentScreen screen) {
        return screen instanceof SaxophoneScreen;
    }
}
