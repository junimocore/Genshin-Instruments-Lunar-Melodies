package com.stump.genshinstrument_lm.item.clientExtensions;

import com.stump.genshinstrument_lm.capability.instrumentOpen.InstrumentOpenProvider;
import com.stump.genshinstrument_lm.client.ModArmPose;
import net.minecraft.client.model.HumanoidModel.ArmPose;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class InstrumentItemClientExt implements IClientItemExtensions {
    @Override
    public @Nullable ArmPose getArmPose(LivingEntity entityLiving, InteractionHand hand, ItemStack itemStack) {
        if (!(entityLiving instanceof Player player))
            return null;
        
        if (!InstrumentOpenProvider.isOpen(player) || !InstrumentOpenProvider.isItem(player))
            return null;

        return ModArmPose.PLAYING_ITEM_INSTRUMENT;
    }
}
