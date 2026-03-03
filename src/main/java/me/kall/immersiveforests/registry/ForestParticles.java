package me.kall.immersiveforests.registry;

import me.kall.immersiveforests.ImmersiveForests;
import me.kall.immersiveforests.fog.FogParticle;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ForestParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ImmersiveForests.MOD_ID);

    public static final RegistryObject<SimpleParticleType> FOG = PARTICLES.register("fog", () -> new SimpleParticleType(false));

    @SubscribeEvent
    public static void particleRegistry(@NotNull RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(FOG.get(), FogParticle.FogParticleProvider::new);
    }
}
