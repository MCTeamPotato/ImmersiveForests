package me.kall.immersiveforests.fog;

import me.kall.immersiveforests.registry.ForestParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class FogSpawner {
    private static final List<AABB> FOG_ZONES = List.of(
            new AABB(-50, 60, -50, 50, 70, 50),
            new AABB(100, 40, 100, 150, 55, 150)
    );

    private static final int PARTICLES_PER_TICK = 3;
    private static final double SPAWN_RADIUS = 16.0;

    @SubscribeEvent
    public static void onClientTick(TickEvent.@NotNull ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null || mc.player == null || mc.isPaused()) return;

        Player player = mc.player;

        for (AABB zone : FOG_ZONES) {
            if (!zone.inflate(SPAWN_RADIUS).contains(player.position())) continue;

            for (int i = 0; i < PARTICLES_PER_TICK; i++) {
                double x = zone.minX + Math.random() * (zone.maxX - zone.minX);
                double y = zone.minY + Math.random() * (zone.maxY - zone.minY);
                double z = zone.minZ + Math.random() * (zone.maxZ - zone.minZ);

                double dist = player.distanceToSqr(x, y, z);
                if (dist > SPAWN_RADIUS * SPAWN_RADIUS) continue;

                mc.level.addParticle(ForestParticles.FOG.get(), x, y, z, 0, 0, 0);
                System.out.println("Rendering at " + x + " " + y + " " + z);
            }
        }
    }
}