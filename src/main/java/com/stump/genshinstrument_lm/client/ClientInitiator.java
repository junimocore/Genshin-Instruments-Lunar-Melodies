package com.stump.genshinstrument_lm.client;

import com.stump.genshinstrument_lm.GInstrumentMod;
import com.stump.genshinstrument_lm.client.gui.instrument.InstrumentScreenRegistry;
import com.stump.genshinstrument_lm.client.gui.instrument.djemdjemdrum.DjemDjemDrumScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.floralzither.FloralZitherScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.gloriousdrum.AratakisGreatAndGloriousDrumScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.microphone.MicrophoneScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.microphone.MicrophoneStandScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.nightwind_horn.NightwindHornScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.partial.InstrumentScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.saxophone.SaxophoneScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.trombone.TromboneScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.ukelele.UkuleleScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.vintagelyre.VintageLyreScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.windsonglyre.WindsongLyreScreen;
import com.stump.genshinstrument_lm.item.clientExtensions.ModItemPredicates;
import com.stump.genshinstrument_lm.client.gui.instrument.guitar.GuitarScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.keyboard.KeyboardScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.koto.KotoScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.noteblockinstrument.NoteBlockInstrumentScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.pipa.PipaScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.shamisen.ShamisenScreen;
import com.stump.genshinstrument_lm.client.gui.instrument.violin.ViolinScreen;
import com.stump.genshinstrument_lm.util.CommonUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.model.SeparateTransformsModel;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Map;
import java.util.function.Supplier;

@EventBusSubscriber(value = Dist.CLIENT, bus = Bus.MOD, modid = GInstrumentMod.MODID)
public class ClientInitiator {

    private static final Class<?>[] LOAD_ME = new Class[] {
            // Load this ourselves because it's not included
            // in out instruments map - hence the theme loader of the
            // note block is not loaded.
            NoteBlockInstrumentScreen.class
    };

    private static final Map<ResourceLocation, Supplier<? extends InstrumentScreen>> INSTRUMENTS =
        Map.ofEntries(
                Map.entry(WindsongLyreScreen.INSTRUMENT_ID, WindsongLyreScreen::new),
                Map.entry(VintageLyreScreen.INSTRUMENT_ID, VintageLyreScreen::new),
                Map.entry(FloralZitherScreen.INSTRUMENT_ID, FloralZitherScreen::new),
                Map.entry(AratakisGreatAndGloriousDrumScreen.INSTRUMENT_ID, AratakisGreatAndGloriousDrumScreen::new),
                Map.entry(NightwindHornScreen.INSTRUMENT_ID, NightwindHornScreen::new),

                Map.entry(UkuleleScreen.INSTRUMENT_ID, UkuleleScreen::new),
                Map.entry(DjemDjemDrumScreen.INSTRUMENT_ID, DjemDjemDrumScreen::new),

                Map.entry(KeyboardScreen.INSTRUMENT_ID, KeyboardScreen::new),
                Map.entry(ViolinScreen.INSTRUMENT_ID, ViolinScreen::new),
                Map.entry(TromboneScreen.INSTRUMENT_ID, TromboneScreen::new),
                Map.entry(GuitarScreen.INSTRUMENT_ID, GuitarScreen::new),
                Map.entry(PipaScreen.INSTRUMENT_ID, PipaScreen::new),
                Map.entry(ShamisenScreen.INSTRUMENT_ID, ShamisenScreen::new),
                Map.entry(KotoScreen.INSTRUMENT_ID, KotoScreen::new),
                Map.entry(SaxophoneScreen.INSTRUMENT_ID, SaxophoneScreen::new),
                Map.entry(MicrophoneScreen.INSTRUMENT_ID, MicrophoneScreen::new),
                Map.entry(MicrophoneStandScreen.INSTRUMENT_ID, MicrophoneStandScreen::new)
        );

    @SubscribeEvent
    public static void initClient(final FMLClientSetupEvent event) {
        ModArmPose.load();
        ModItemPredicates.register();
        CommonUtil.loadClasses(LOAD_ME);

        InstrumentScreenRegistry.register(INSTRUMENTS);
    }

    @SubscribeEvent
    public static void modelLoadEvent(final ModelEvent.RegisterGeometryLoaders event) {
        event.register("separate_transforms", SeparateTransformsModel.Loader.INSTANCE);
    }
}
