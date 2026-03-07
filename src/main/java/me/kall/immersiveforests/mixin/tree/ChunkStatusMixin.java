package me.kall.immersiveforests.mixin.tree;

import me.kall.immersiveforests.TreeBonusConfig;
import net.minecraft.util.Mth;
import net.minecraft.world.level.chunk.status.ChunkStatusTasks;
import net.minecraft.world.level.chunk.status.ChunkStep;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ChunkStatusTasks.class)
public abstract class ChunkStatusMixin {
    @ModifyVariable(method = "generateFeatures", at = @At("HEAD"), argsOnly = true)
    private static ChunkStep modifyWriteRadiusCutoff(ChunkStep chunkStep) {
        ((ChunkStepAccessor)(Object)chunkStep).setBlockStateWriteRadius(Math.min(Mth.ceil(TreeBonusConfig.FOLIAGE_XZ_BONUS * (double) chunkStep.blockStateWriteRadius()), 8));
        return chunkStep;
    }

    @Mixin(ChunkStep.class)
    private interface ChunkStepAccessor {
        @Mutable
        @Accessor("blockStateWriteRadius")
        void setBlockStateWriteRadius(int blockStateWriteRadius);
    }
}
