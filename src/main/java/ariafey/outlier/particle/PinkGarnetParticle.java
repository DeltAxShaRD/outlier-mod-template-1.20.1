package ariafey.outlier.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class PinkGarnetParticle extends SpriteBillboardParticle {
    public PinkGarnetParticle(ClientWorld world, double XCoord, double YCoord, double ZCoord,
                                 SpriteProvider spriteSet, double xd, double yd, double zd) {
        super(world, XCoord, YCoord, ZCoord, xd, yd, zd);

        this.velocityMultiplier = 0.5f;
        this.velocityX = xd;
        this.velocityY = yd;
        this.velocityZ = zd;

        this.scale += 0.25f;
        this.maxAge = 10;
        this.setSpriteForAge(spriteSet);


    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteProvider) {
            this.sprites = spriteProvider;
        }

        public Particle createParticle(DefaultParticleType particleType, ClientWorld clientWorld,
                                       double x, double y, double z, double xd, double yd, double zd) {

            return new PinkGarnetParticle(clientWorld, x, y, z, this.sprites, xd, yd, zd);
        }
    }
}
