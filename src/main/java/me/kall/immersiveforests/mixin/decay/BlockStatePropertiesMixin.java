package me.kall.immersiveforests.mixin.decay;

import com.google.common.collect.ImmutableSet;
import me.kall.immersiveforests.ImmersiveForests;
import me.kall.immersiveforests.TreeBonusConfig;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockStateProperties.class)
public abstract class BlockStatePropertiesMixin {
    @Mutable @Shadow @Final public static IntegerProperty DISTANCE;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void enhancedTrees$init(CallbackInfo ci) {
        ImmutableSet<Integer> values = ((IntegerPropertyAccessor) DISTANCE).values();
        int oldMax = 0;
        int oldMin = 100;
        for (Integer value : values) {
            if (oldMax < value) oldMax = value;
            if (oldMin > value) oldMin = value;
        }

        int newMax = (int) (TreeBonusConfig.FOLIAGE_DECAY_RANGE_BONUS * (double) oldMax);
        DISTANCE = IntegerProperty.create("distance", oldMin, newMax);
        ImmersiveForests.LOGGER.info("Max value of BlockStateProperties DISTANCE is updated from {} to {}", oldMax, newMax);
    }
}
