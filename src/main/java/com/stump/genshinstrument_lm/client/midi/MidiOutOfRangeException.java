package com.stump.genshinstrument_lm.client.midi;

public class MidiOutOfRangeException extends Exception {
    
    public MidiOutOfRangeException() {
        super("MIDI note is out of allowed range");
    }

}
