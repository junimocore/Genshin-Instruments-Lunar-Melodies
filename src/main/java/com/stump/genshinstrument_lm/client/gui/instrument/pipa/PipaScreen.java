package com.stump.genshinstrument_lm.client.gui.instrument.pipa;

import com.stump.genshinstrument_lm.GInstrumentMod;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.InstrumentThemeLoader;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.grid.GridInstrumentScreen;
import com.stump.genshinstrument_lm.client.gui.options.partial.InstrumentOptionsScreen;
import com.stump.genshinstrument_lm.sound.SoundOption;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PipaScreen extends GridInstrumentScreen {
    public static final ResourceLocation INSTRUMENT_ID = new ResourceLocation(GInstrumentMod.MODID, "pipa");

    @Override
    public ResourceLocation getInstrumentId() {
        return INSTRUMENT_ID;
    }

    @Override
    public SoundOption getSoundOption() {
        return ((PipaOptionsScreen) optionsScreen)
                .getPreferredSoundType()
                .getSoundArr()
                .get();
    }

    @Override
    protected InstrumentOptionsScreen initInstrumentOptionsScreen() {
        return new PipaOptionsScreen(this);
    }


    public static final InstrumentThemeLoader THEME_LOADER = new InstrumentThemeLoader(INSTRUMENT_ID);
    @Override
    public InstrumentThemeLoader getThemeLoader() {
        return THEME_LOADER;
    }

    @Override
    public boolean isGenshinInstrument() {
        return false;
    }
}