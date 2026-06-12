package mod.maxbogomol.purrfect.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class PurrfectServerConfig {
    public static ForgeConfigSpec.ConfigValue<Boolean>
            BREAKABLE_LEASH;
    public static ForgeConfigSpec.ConfigValue<Double>
            LEASH_MIN_DISTANCE, LEASH_MAX_DISTANCE;

    public PurrfectServerConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Leash").push("leash");
        BREAKABLE_LEASH = builder.comment("Enables leash breaking at maximum distance.").define("breakableLeash", true);
        LEASH_MIN_DISTANCE = builder.comment("Distance after which the leash begins to attract the player.").defineInRange("leashMinDistance", 10d, 1d, 25d);
        LEASH_MAX_DISTANCE = builder.comment("Distance after which the leash may break.").defineInRange("leashMaxDistance", 50d, 10d, 250d);
        builder.pop();
    }

    public static final PurrfectServerConfig INSTANCE;
    public static final ForgeConfigSpec SPEC;

    static {
        final Pair<PurrfectServerConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(PurrfectServerConfig::new);
        SPEC = specPair.getRight();
        INSTANCE = specPair.getLeft();
    }
}
