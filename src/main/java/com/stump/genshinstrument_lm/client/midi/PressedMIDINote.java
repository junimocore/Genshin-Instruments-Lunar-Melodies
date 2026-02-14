package com.stump.genshinstrument_lm.client.midi;

import com.stump.genshinstrument_lm.client.gui.instrument.partial.note.NoteButton;
import com.stump.genshinstrument_lm.sound.NoteSound;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public record PressedMIDINote(
    int notePitch,
    NoteButton pressedNote,
    NoteSound sound
)
{}


