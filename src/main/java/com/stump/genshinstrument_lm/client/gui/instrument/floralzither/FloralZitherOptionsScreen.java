package com.stump.genshinstrument_lm.client.gui.instrument.floralzither;

import com.stump.genshinstrument_lm.client.config.ModClientConfigs;
import com.stump.genshinstrument_lm.client.config.enumType.ZitherSoundType;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.InstrumentScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.grid.GridInstrumentScreen;
import com.stump.genshinstrument_lm.client.gui.options.partial.SoundTypeOptionsScreen;
import com.stump.genshinstrument_lm.client.util.TogglablePedalSound;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FloralZitherOptionsScreen extends SoundTypeOptionsScreen<ZitherSoundType> {
    private static final String SOUND_TYPE_KEY = "button.genshinstrument_lm.zither.soundType",
        OPTIONS_LABEL_KEY = "label.genshinstrument_lm.zither_options";
    
    public FloralZitherOptionsScreen(final GridInstrumentScreen screen) {
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
    protected ZitherSoundType getInitSoundType() {
        return ModClientConfigs.ZITHER_SOUND_TYPE.get();
    }

    @Override
    protected ZitherSoundType[] values() {
        return ZitherSoundType.values();
    }

    @Override
    public TogglablePedalSound<ZitherSoundType> midiPedalListener() {
        return new TogglablePedalSound<>(ZitherSoundType.NEW, ZitherSoundType.OLD);
    }



    @Override
    protected void saveSoundType(ZitherSoundType soundType) {
        ModClientConfigs.ZITHER_SOUND_TYPE.set(soundType);
    }

    @Override
    protected boolean isValidForSet(InstrumentScreen screen) {
        return screen instanceof FloralZitherScreen;
    }
}
