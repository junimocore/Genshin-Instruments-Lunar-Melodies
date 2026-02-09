package com.stump.genshinstrument_lm.client.gui.instrument.nightwind_horn;

import com.stump.genshinstrument_lm.GInstrumentMod;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.IHeldInstrumentScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.InstrumentThemeLoader;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.grid.GridInstrumentScreen;
import com.stump.genshinstrument_lm.sound.GISounds;
import com.stump.genshinstrument_lm.sound.SoundOption;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NightwindHornScreen extends GridInstrumentScreen implements IHeldInstrumentScreen {
    public static final ResourceLocation INSTRUMENT_ID = new ResourceLocation(GInstrumentMod.MODID, "nightwind_horn");

    @Override
    public ResourceLocation getInstrumentId() {
        return INSTRUMENT_ID;
    }

    @Override
    public SoundOption getSoundOption() {
        return new SoundOption(GISounds.NIGHTWIND_HORN);
    }

    @Override
    public int columns() {
        return 2;
    }

    @Override
    protected void renderInstrumentBackground(final GuiGraphics gui) {
        final int clefX = grid.getX() - getNoteSize() + 8;

        renderClef(gui, 0, clefX, "treble");
        renderClef(gui, 1, clefX, "bass");

        for (int i = 0; i < columns(); i++)
            renderStaff(gui, i);
    }


    public static final InstrumentThemeLoader THEME_LOADER = new InstrumentThemeLoader(INSTRUMENT_ID);
    @Override
    public InstrumentThemeLoader getThemeLoader() {
        return THEME_LOADER;
    }
}
