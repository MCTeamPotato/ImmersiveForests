package me.kall.immersiveforests.mixin.decay;

import me.kall.immersiveforests.ImmersiveForests;
import me.kall.immersiveforests.TreeBonusConfig;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockStateProperties.class)
public abstract class BlockStatePropertiesMixin {
    @Mutable @Shadow @Final public static IntegerProperty DISTANCE;
    @Mutable @Shadow @Final public static int MAX_DISTANCE;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void enhancedTrees$init(CallbackInfo ci) {
        IntegerPropertyAccessor propertySetter = immersiveForests$getDist();
        int oldMax = propertySetter.max();
        int newMax = (int) (TreeBonusConfig.FOLIAGE_DECAY_RANGE_BONUS * (double) oldMax);
        DISTANCE = IntegerProperty.create("distance", propertySetter.min(), newMax);
        MAX_DISTANCE = newMax;
        ImmersiveForests.LOGGER.info("Max value of BlockStateProperties DISTANCE is updated from {} to {}", oldMax, newMax);
    }

    @Unique
    private static IntegerPropertyAccessor immersiveForests$getDist() {
        return (IntegerPropertyAccessor) (Object) DISTANCE;
    }
}
