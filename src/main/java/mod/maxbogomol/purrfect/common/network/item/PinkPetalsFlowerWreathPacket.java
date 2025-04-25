package mod.maxbogomol.purrfect.common.network.item;

import mod.maxbogomol.fluffy_fur.client.particle.ParticleBuilder;
import mod.maxbogomol.fluffy_fur.client.particle.data.LightParticleData;
import mod.maxbogomol.fluffy_fur.common.network.PositionClientPacket;
import mod.maxbogomol.fluffy_fur.registry.client.FluffyFurParticles;
import mod.maxbogomol.wizards_reborn.WizardsReborn;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.function.Supplier;

public class PinkPetalsFlowerWreathPacket extends PositionClientPacket {

    public PinkPetalsFlowerWreathPacket(double x, double y, double z) {
        super(x, y, z);
    }

    public PinkPetalsFlowerWreathPacket(Vec3 vec) {
        super(vec);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void execute(Supplier<NetworkEvent.Context> context) {
        Level level = WizardsReborn.proxy.getLevel();
        ParticleBuilder.create(FluffyFurParticles.CHERRY_LEAVES)
                .setParticleRenderType(ParticleRenderType.PARTICLE_SHEET_OPAQUE)
                .setLightData(LightParticleData.DEFAULT)
                .randomVelocity(0.1f)
                .setLifetime(40)
                .repeat(level, x, y, z, 5, 0.4f);
    }

    public static void register(SimpleChannel instance, int index) {
        instance.registerMessage(index, PinkPetalsFlowerWreathPacket.class, PinkPetalsFlowerWreathPacket::encode, PinkPetalsFlowerWreathPacket::decode, PinkPetalsFlowerWreathPacket::handle);
    }

    public static PinkPetalsFlowerWreathPacket decode(FriendlyByteBuf buf) {
        return decode(PinkPetalsFlowerWreathPacket::new, buf);
    }
}
