package me.kall.immersiveforests.mixin;

import me.kall.immersiveforests.TreeBonusConfig;
import net.minecraft.util.Mth;
import net.minecraft.world.level.chunk.ChunkStatus;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ChunkStatus.class)
public abstract class ChunkStatusMixin {
    @Dynamic
    @ModifyConstant(method = {"method_51375", "lambda$static$11", "m_279978_"}, constant = @Constant(intValue = 1))
    private static int modifyWriteRadiusCutoff(int writeRadiusCutoff) {
        return Mth.ceil(TreeBonusConfig.FOLIAGE_XZ_BONUS * (double) writeRadiusCutoff);
    }
}
