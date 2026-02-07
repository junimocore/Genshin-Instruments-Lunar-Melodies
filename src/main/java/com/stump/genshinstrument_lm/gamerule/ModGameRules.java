package com.stump.genshinstrument_lm.gamerule;

import com.stump.genshinstrument_lm.GInstrumentMod;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameRules.Category;

public abstract class ModGameRules {

    public static void load() {}

    public static final GameRules.Key<GameRules.IntegerValue>
        RULE_LOOPER_MAX_NOTES = GameRules.register(GInstrumentMod.MODID+"_looperMaxNotes", Category.MISC, GameRules.IntegerValue.create(255))
    ;
    
}
