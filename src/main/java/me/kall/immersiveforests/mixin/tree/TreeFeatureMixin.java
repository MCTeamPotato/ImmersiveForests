package me.kall.immersiveforests.mixin.tree;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import me.kall.immersiveforests.TreeBonusConfig;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Random;

@Mixin(TreeFeature.class)
public abstract class TreeFeatureMixin {
    @WrapOperation(method = "doPlace", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/feature/foliageplacers/FoliagePlacer;foliageHeight(Ljava/util/Random;ILnet/minecraft/world/level/levelgen/feature/configurations/TreeConfiguration;)I"))
    private int increaseHeight(FoliagePlacer foliagePlacer, Random random, int i, TreeConfiguration treeConfiguration, Operation<Integer> original) {
        return (int) (original.call(foliagePlacer, random, i, treeConfiguration) * TreeBonusConfig.FOLIAGE_Y_BONUS);
    }
}
