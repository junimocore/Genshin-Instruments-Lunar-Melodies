package com.stump.genshinstrument_lm.client.gui.instrument.noteblockinstrument;

import com.stump.genshinstrument_lm.GInstrumentMod;
import com.stump.genshinstrument_lm.item.NoteBlockInstrumentItem;
import com.stump.genshinstrument_lm.sound.GISounds;
import com.stump.genshinstrument_lm.client.gui.instrument.floralzither.FloralZitherScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.InstrumentThemeLoader;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.grid.GridInstrumentScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.note.grid.NoteGridButton;
import com.stump.genshinstrument_lm.client.midi.InstrumentMidiReceiver;
import com.stump.genshinstrument_lm.sound.NoteSound;
import com.stump.genshinstrument_lm.sound.SoundOption;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NoteBlockInstrumentScreen extends GridInstrumentScreen {
    public static final String[] NOTES_LAYOUT = {"F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F"};

    public final NoteBlockInstrument instrumentType;
    public final ResourceLocation instrumentId;
    private final SoundOption soundOption;
    
    public NoteBlockInstrumentScreen(final NoteBlockInstrument instrumentType) {
        this.instrumentType = instrumentType;
        instrumentId = new ResourceLocation(GInstrumentMod.MODID, NoteBlockInstrumentItem.getId(instrumentType));

        // Update the sound to match the note block's
        this.soundOption = new SoundOption(GISounds.getNoteblockSounds(instrumentType));
    }

    @Override
    public SoundOption getSoundOption() {
        return soundOption;
    }

    @Override
    public boolean isGenshinInstrument() {
        return false;
    }


    @Override
    public int rows() {
        return 8;
    }

    public int getNoteSize() {
        return (int)(super.getNoteSize() * .85f);
    }
    @Override
    public NoteGridButton createNoteButton(int row, int column, int pitch) {
        return new NoteBlockInstrumentNote(row, column, this, pitch);
    }


    @Override
    public ResourceLocation getInstrumentId() {
        return instrumentId;
    }
    

    @Override
    public NoteSound[] getInitSounds() {
        return getSoundOption().getNoteSounds();
    }

    @Override
    public String[] noteLayout() {
        return NOTES_LAYOUT;
    }

    @Override
    public boolean isSSTI() {
        return true;
    }


    @Override
    public InstrumentMidiReceiver initMidiReceiver() {
        return new NoteBlockInstrumentMIDIReceiver(this);
    }

    public static final InstrumentThemeLoader THEME_LOADER = InstrumentThemeLoader.fromOther(
        FloralZitherScreen.THEME_LOADER,
        new ResourceLocation(GInstrumentMod.MODID, "note_block_instrument")
    );
        
    @Override
    public InstrumentThemeLoader getThemeLoader() {
        return THEME_LOADER;
    }
}
