package com.stump.genshinstrument_lm.client.gui.instrument.noteblockinstrument;


import com.stump.genshinstrument_lm.client.gui.instrument.partial.grid.GridInstrumentScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.note.grid.NoteGridButton;

public class NoteBlockInstrumentNote extends NoteGridButton {

    public NoteBlockInstrumentNote(int row, int column, GridInstrumentScreen instrumentScreen, int pitch) {
        super(row, column, instrumentScreen, pitch);
    }

    // Layout starts from the bottom in a note block instrument, not the top
    // Hence, perform a column flip
    @Override
    public int getNoteOffset() {
        final GridInstrumentScreen gridInstrument = (GridInstrumentScreen)instrumentScreen;
        return row + gridInstrument.noteGrid.getFlippedColumn(column) * gridInstrument.rows();
    }
    
}
