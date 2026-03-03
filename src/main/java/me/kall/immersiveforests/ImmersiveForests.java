package me.kall.immersiveforests;

import me.kall.immersiveforests.registry.ForestParticles;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Mod(ImmersiveForests.MOD_ID)
public final class ImmersiveForests {
    public static final String MOD_ID = "immersiveforests";
    public static final Logger LOGGER = LogManager.getLogger("ImmersiveForests");

    public ImmersiveForests(@NotNull FMLJavaModLoadingContext context) {
        ForestParticles.PARTICLES.register(context.getModEventBus());
    }
}
