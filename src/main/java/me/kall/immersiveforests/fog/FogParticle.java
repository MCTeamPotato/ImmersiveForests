package me.kall.immersiveforests.fog;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

public class FogParticle extends TextureSheetParticle {
    private static final float MAX_ALPHA = 0.06f;

    public FogParticle(ClientLevel level, double x, double y, double z) {
        super(level, x, y, z, 0, 0, 0);

        this.quadSize = 3.0f + (float)(Math.random() * 2.0f);

        float half = this.quadSize / 2.0f;
        this.setBoundingBox(new AABB(x - half, y - half, z - half, x + half, y + half, z + half));

        this.alpha = 0.0f;

        this.lifetime = 120 + this.random.nextInt(80);

        this.xd = (Math.random() - 0.5) * 0.003;
        this.yd = (Math.random() - 0.5) * 0.001;
        this.zd = (Math.random() - 0.5) * 0.003;

        this.gravity = 0f;
        this.hasPhysics = false;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.age < 20) {
            this.alpha = MAX_ALPHA * (this.age / 20f);
        } else if (age > lifetime - 20) {
            this.alpha = MAX_ALPHA * ((this.lifetime - this.age) / 20f);
        } else {
            this.alpha = MAX_ALPHA;
        }

        this.xd += (Math.random() - 0.5) * 0.0005;
        this.zd += (Math.random() - 0.5) * 0.0005;

        this.xd *= 0.98;
        this.zd *= 0.98;
    }

    @Override
    public @NotNull ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class FogParticleProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public FogParticleProvider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(@NotNull SimpleParticleType particleType, @NotNull ClientLevel level, double x, double y, double z, double dx, double dy, double dz) {
            FogParticle fogParticle = new FogParticle(level, x, y, z);
            fogParticle.pickSprite(this.sprites);
            return fogParticle;
        }
    }
}