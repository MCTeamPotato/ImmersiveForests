package me.kall.immersiveforests.mixin.tree;

import me.kall.immersiveforests.TreeBonusConfig;
import net.minecraft.util.UniformInt;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FoliagePlacer.class)
public abstract class FoliagePlacerMixin {
    @Mutable @Shadow @Final protected UniformInt radius;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void enhancedTrees$init(UniformInt radius, UniformInt offset, CallbackInfo ci) {
        this.radius = UniformInt.of((int) (((UniformIntAccessor)radius).getBaseValue() * TreeBonusConfig.FOLIAGE_XZ_BONUS), (int) (((UniformIntAccessor)radius).getSpread() * TreeBonusConfig.FOLIAGE_XZ_BONUS));
    }

    @Mixin(UniformInt.class)
    public interface UniformIntAccessor {
        @Accessor("baseValue")
        int getBaseValue();

        @Accessor("spread")
        int getSpread();
    }
}
