package com.stump.genshinstrument_lm.client.gui.instrument.partial.grid;

import com.stump.genshinstrument_lm.client.gui.instrument.partial.IHeldInstrumentScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.note.grid.HeldGridNoteButton;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.note.grid.NoteGridButton;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.note.held.IHoldableNoteButton;
import com.stump.genshinstrument_lm.event.InstrumentPlayedEvent;
import com.stump.genshinstrument_lm.sound.NoteSound;
import com.stump.genshinstrument_lm.sound.held.HeldNoteSound;
import com.stump.genshinstrument_lm.sound.held.HeldNoteSound.Phase;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class HeldGridInstrumentScreen extends GridInstrumentScreen implements IHeldInstrumentScreen {

    private HeldNoteSound[] heldNoteSounds = getInitHeldNoteSounds();
    public abstract HeldNoteSound[] getInitHeldNoteSounds();

    @Override
    public void setHeldNoteSounds(final HeldNoteSound[] heldNoteSounds) {
        this.heldNoteSounds = heldNoteSounds;
        notesIterable().forEach((btn) ->
            ((IHoldableNoteButton)btn).setHeldNoteSound(heldNoteSounds[((NoteGridButton)btn).posToIndex()])
        );
    }
    @Override
    public HeldNoteSound[] getHeldNoteSounds() {
        return heldNoteSounds;
    }

    @Override
    public NoteSound[] getInitSounds() {
        return HeldNoteSound.getSounds(getInitHeldNoteSounds(), Phase.ATTACK);
    }

    @Override
    public NoteGridButton createNote(int row, int column) {
        return new HeldGridNoteButton(row, column, this, getInitHeldNoteSounds());
    }


    @Override
    public void foreignPlay(final InstrumentPlayedEvent<?> event) {
        foreignPlayHeld(event);
    }


    @Override
    public void onClose(final boolean notify) {
        closeHeldScreen();
        super.onClose(notify);
    }
}
