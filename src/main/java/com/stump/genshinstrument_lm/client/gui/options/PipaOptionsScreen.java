package com.stump.genshinstrument_lm.client.gui.options;

import com.stump.genshinstrument_lm.client.config.ModClientConfigs;
import com.stump.genshinstrument_lm.client.gui.instrument.pipa.PipaScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.pipa.PipaSoundType;
import com.stump.genshinstrument_lm.client.gui.options.partial.CyclableSoundTypeInstrumentOptionsScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.InstrumentScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.grid.GridInstrumentScreen;
import com.stump.genshinstrument_lm.client.util.TogglablePedalSound;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PipaOptionsScreen extends CyclableSoundTypeInstrumentOptionsScreen<PipaSoundType> {
    private static final String SOUND_TYPE_KEY = "button.genshinstrument_lm.pipa.soundType",
        OPTIONS_LABEL_KEY = "label.genshinstrument_lm.pipa_options";

    public PipaOptionsScreen(GridInstrumentScreen screen) {
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
    protected PipaSoundType getInitSoundType() {
        return ModClientConfigs.PIPA_SOUND_TYPE.get();
    }

    @Override
    protected boolean isValidForSet(InstrumentScreen arg0) {
        return arg0 instanceof PipaScreen;
    }

    @Override
    public TogglablePedalSound<PipaSoundType> midiPedalListener() {
        return new TogglablePedalSound<>(PipaSoundType.REGULAR, PipaSoundType.TREMOLO);
    }


    @Override
    protected void saveSoundType(PipaSoundType arg0) {
        ModClientConfigs.PIPA_SOUND_TYPE.set(arg0);
    }

    @Override
    protected PipaSoundType[] values() {
        return PipaSoundType.values();
    }

}
