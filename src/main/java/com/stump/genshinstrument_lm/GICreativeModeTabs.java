package com.stump.genshinstrument_lm;

import com.stump.genshinstrument_lm.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


@EventBusSubscriber(modid = GInstrumentMod.MODID, bus = Bus.MOD)
public class GICreativeModeTabs {

    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GInstrumentMod.MODID);

    public static void regsiter(final IEventBus bus) {
        TABS.register(bus);
    }

    public static final RegistryObject<CreativeModeTab> INSTRUMENTS_TAB =
            TABS.register("instruments_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("genshinstrument_lm.itemGroup.instruments"))
                    .icon(() -> new ItemStack(ModItems.FLORAL_ZITHER.get()))
                    .build()
            );

    public static final RegistryObject<CreativeModeTab> MUSIC_PRODUCTION_TAB =
            TABS.register("music_production_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.genshinstrument_lm.music_production_tab"))
                    .icon(() -> new ItemStack(ModItems.LOOPER.get()))
                    .withTabsBefore(INSTRUMENTS_TAB.getKey())
                    .build()
            );
}
