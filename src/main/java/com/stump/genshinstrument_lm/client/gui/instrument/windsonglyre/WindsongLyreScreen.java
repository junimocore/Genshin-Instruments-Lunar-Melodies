package com.stump.genshinstrument_lm.client.gui.instrument.windsonglyre;

import com.stump.genshinstrument_lm.GInstrumentMod;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.InstrumentThemeLoader;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.grid.GridInstrumentScreen;
import com.stump.genshinstrument_lm.sound.GISounds;
import com.stump.genshinstrument_lm.sound.SoundOption;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WindsongLyreScreen extends GridInstrumentScreen {
    public static final ResourceLocation INSTRUMENT_ID = new ResourceLocation(GInstrumentMod.MODID, "windsong_lyre");

    @Override
    public ResourceLocation getInstrumentId() {
        return INSTRUMENT_ID;
    }


    @Override
    public SoundOption getSoundOption() {
        return new SoundOption(GISounds.WINDSONG_LYRE_NOTE_SOUNDS);
    }


    public static final InstrumentThemeLoader THEME_LOADER = new InstrumentThemeLoader(INSTRUMENT_ID);
    @Override
    public InstrumentThemeLoader getThemeLoader() {
        return THEME_LOADER;
    }
    
}
