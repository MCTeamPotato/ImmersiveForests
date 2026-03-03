package me.kall.immersiveforests.mixin.compat;

import me.kall.immersiveforests.TreeBonusConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import pro.mikey.accelerateddecay.AcceleratedDecay;

@Mixin(value = AcceleratedDecay.class, remap = false)
public abstract class AcceleratedDecayMixin {
    @ModifyConstant(method = "seekLeaves", constant = @Constant(intValue = 7))
    private static int updateDistance(int constant) {
        return (int) (constant * TreeBonusConfig.FOLIAGE_DECAY_RANGE_BONUS);
    }
}
