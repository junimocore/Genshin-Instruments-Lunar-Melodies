package com.stump.genshinstrument_lm.client.gui.instrument.gw2_drum;

import com.stump.genshinstrument_lm.client.config.ModClientConfigs;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.note.NoteButton;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.note.label.INoteLabel;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.note.label.NoteLabelSupplier;
import com.stump.genshinstrument_lm.util.LabelUtil;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public enum Gw2DrumNoteLabel implements INoteLabel {
	KEYBOARD_LAYOUT((note) ->
		INoteLabel.upperComponent(getGw2DrumNoteButton(note).getKey().getDisplayName())
	),
	QWERTY((note) ->
		INoteLabel.getQwerty(getGw2DrumNoteButton(note).getKey())
	),
	NOTE_NAME((note) -> Component.literal(
		note.getFormattedNoteName()
	)),
	DO_RE_MI((note) ->
        LabelUtil.toDoReMi(note.getFormattedNoteName())
    ),

    NONE(NoteLabelSupplier.EMPTY);


    private final NoteLabelSupplier labelSupplier;
	Gw2DrumNoteLabel(final NoteLabelSupplier supplier) {
        labelSupplier = supplier;
    }

	public static INoteLabel[] availableVals() {
        return INoteLabel.filterQwerty(values(), ModClientConfigs.GW2_DRUM_LABEL_TYPE.get(), QWERTY);
    }


	@Override
	public NoteLabelSupplier getLabelSupplier() {
        return labelSupplier;
	}


	private static Gw2DrumNoteButton getGw2DrumNoteButton(final NoteButton btn) {
        return (Gw2DrumNoteButton)btn;
    }
}