package com.stump.genshinstrument_lm.client.gui.instrument.trombone;

import com.stump.genshinstrument_lm.client.config.ModClientConfigs;
import com.stump.genshinstrument_lm.client.config.enumType.TromboneSoundType;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.InstrumentScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.grid.GridInstrumentScreen;
import com.stump.genshinstrument_lm.client.gui.options.partial.SoundTypeOptionsScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TromboneOptionsScreen extends SoundTypeOptionsScreen<TromboneSoundType> {
    private static final String SOUND_TYPE_KEY = "button.genshinstrument_lm.trombone.soundType",
        OPTIONS_LABEL_KEY = "label.genshinstrument_lm.trombone_options";

    public TromboneOptionsScreen(final GridInstrumentScreen screen) {
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
    protected TromboneSoundType getInitSoundType() {
        return ModClientConfigs.TROMBONE_SOUND_TYPE.get();
    }

    @Override
    protected TromboneSoundType[] values() {
        return TromboneSoundType.values();
    }


    @Override
    protected void saveSoundType(TromboneSoundType soundType) {
        ModClientConfigs.TROMBONE_SOUND_TYPE.set(soundType);
    }

    @Override
    protected boolean isValidForSet(InstrumentScreen screen) {
        return screen instanceof TromboneScreen;
    }
}
