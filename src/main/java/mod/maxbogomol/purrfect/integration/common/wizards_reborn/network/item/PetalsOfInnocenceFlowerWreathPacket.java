package mod.maxbogomol.purrfect.integration.common.wizards_reborn.network.item;

import mod.maxbogomol.fluffy_fur.client.particle.ParticleBuilder;
import mod.maxbogomol.fluffy_fur.client.particle.data.LightParticleData;
import mod.maxbogomol.fluffy_fur.common.network.PositionClientPacket;
import mod.maxbogomol.wizards_reborn.WizardsReborn;
import mod.maxbogomol.wizards_reborn.registry.client.WizardsRebornParticles;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.function.Supplier;

public class PetalsOfInnocenceFlowerWreathPacket extends PositionClientPacket {

    public PetalsOfInnocenceFlowerWreathPacket(double x, double y, double z) {
        super(x, y, z);
    }

    public PetalsOfInnocenceFlowerWreathPacket(Vec3 vec) {
        super(vec);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void execute(Supplier<NetworkEvent.Context> context) {
        Level level = WizardsReborn.proxy.getLevel();
        ParticleBuilder.create(WizardsRebornParticles.INNOCENT_WOOD_LEAVES)
                .setParticleRenderType(ParticleRenderType.PARTICLE_SHEET_OPAQUE)
                .setLightData(LightParticleData.DEFAULT)
                .randomVelocity(0.1f)
                .setLifetime(40)
                .repeat(level, x, y, z, 5, 0.4f);
    }

    public static void register(SimpleChannel instance, int index) {
        instance.registerMessage(index, PetalsOfInnocenceFlowerWreathPacket.class, PetalsOfInnocenceFlowerWreathPacket::encode, PetalsOfInnocenceFlowerWreathPacket::decode, PetalsOfInnocenceFlowerWreathPacket::handle);
    }

    public static PetalsOfInnocenceFlowerWreathPacket decode(FriendlyByteBuf buf) {
        return decode(PetalsOfInnocenceFlowerWreathPacket::new, buf);
    }
}
