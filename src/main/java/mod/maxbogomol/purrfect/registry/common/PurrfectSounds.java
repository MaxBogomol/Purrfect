package mod.maxbogomol.purrfect.registry.common;

import mod.maxbogomol.purrfect.Purrfect;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PurrfectSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, Purrfect.MOD_ID);

    public static final RegistryObject<SoundEvent> OPTIFINE_BREAK = SOUND_EVENTS.register("optifine_break", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Purrfect.MOD_ID, "optifine_break")));
    public static final RegistryObject<SoundEvent> OPTIFINE_STEP = SOUND_EVENTS.register("optifine_step", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Purrfect.MOD_ID, "optifine_step")));
    public static final RegistryObject<SoundEvent> OPTIFINE_PLACE = SOUND_EVENTS.register("optifine_place", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Purrfect.MOD_ID, "optifine_place")));
    public static final RegistryObject<SoundEvent> OPTIFINE_HIT = SOUND_EVENTS.register("optifine_hit", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Purrfect.MOD_ID, "optifine_hit")));
    public static final RegistryObject<SoundEvent> OPTIFINE_FALL = SOUND_EVENTS.register("optifine_fall", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Purrfect.MOD_ID, "optifine_fall")));

    public static final RegistryObject<SoundEvent> SODIUM_BREAK = SOUND_EVENTS.register("sodium_break", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Purrfect.MOD_ID, "sodium_break")));
    public static final RegistryObject<SoundEvent> SODIUM_STEP = SOUND_EVENTS.register("sodium_step", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Purrfect.MOD_ID, "sodium_step")));
    public static final RegistryObject<SoundEvent> SODIUM_PLACE = SOUND_EVENTS.register("sodium_place", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Purrfect.MOD_ID, "sodium_place")));
    public static final RegistryObject<SoundEvent> SODIUM_HIT = SOUND_EVENTS.register("sodium_hit", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Purrfect.MOD_ID, "sodium_hit")));
    public static final RegistryObject<SoundEvent> SODIUM_FALL = SOUND_EVENTS.register("sodium_fall", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Purrfect.MOD_ID, "sodium_fall")));

    public static final RegistryObject<SoundEvent> COLLAR_BELL = SOUND_EVENTS.register("collar_bell", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Purrfect.MOD_ID, "collar_bell")));

    public static final ForgeSoundType OPTIFINE = new ForgeSoundType(1f, 1f, OPTIFINE_BREAK, OPTIFINE_STEP, OPTIFINE_PLACE, OPTIFINE_HIT, OPTIFINE_FALL);
    public static final ForgeSoundType SODIUM = new ForgeSoundType(1f, 1f, SODIUM_BREAK, SODIUM_STEP, SODIUM_PLACE, SODIUM_HIT, SODIUM_FALL);
    
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
