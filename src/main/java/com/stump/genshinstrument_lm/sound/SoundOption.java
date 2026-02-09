package com.stump.genshinstrument_lm.sound;

import com.stump.genshinstrument_lm.sound.held.HeldNoteSound;

public class SoundOption {
    private final NoteSound[] noteSounds;
    private final HeldNoteSound[] heldSounds;

    // Constructor for standard notes
    public SoundOption(NoteSound[] noteSounds) {
        this.noteSounds = noteSounds;
        this.heldSounds = null;
    }

    // Constructor for held notes
    public SoundOption(HeldNoteSound[] heldSounds) {
        this.heldSounds = heldSounds;
        this.noteSounds = null;
    }

    public boolean isHeld() {
        return heldSounds != null;
    }

    public NoteSound[] getNoteSounds() {
        return noteSounds;
    }

    public HeldNoteSound[] getHeldSounds() {
        return heldSounds;
    }

    public NoteSound[] getNoteSoundsForGrid() {
        if (isHeld()) {
            return HeldNoteSound.getSounds(heldSounds, HeldNoteSound.Phase.ATTACK);
        } else {
            return noteSounds;
        }
    }
}