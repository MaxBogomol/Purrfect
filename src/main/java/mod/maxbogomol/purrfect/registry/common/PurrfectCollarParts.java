package mod.maxbogomol.purrfect.registry.common;

import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.api.furry.CollarPartHandler;
import mod.maxbogomol.purrfect.common.collar.BellCollarPart;
import mod.maxbogomol.purrfect.common.collar.ColorCollarPart;
import mod.maxbogomol.purrfect.common.collar.DecorationCollarPart;
import mod.maxbogomol.purrfect.common.collar.LockCollarPart;

public class PurrfectCollarParts {
    public static ColorCollarPart COLLAR = new ColorCollarPart(Purrfect.MOD_ID+":collar");
    public static ColorCollarPart WHITE = new ColorCollarPart(Purrfect.MOD_ID+":white_collar");
    public static ColorCollarPart LIGHT_GRAY = new ColorCollarPart(Purrfect.MOD_ID+":light_gray_collar");
    public static ColorCollarPart GRAY = new ColorCollarPart(Purrfect.MOD_ID+":gray_collar");
    public static ColorCollarPart BLACK = new ColorCollarPart(Purrfect.MOD_ID+":black_collar");
    public static ColorCollarPart BROWN = new ColorCollarPart(Purrfect.MOD_ID+":brown_collar");
    public static ColorCollarPart RED = new ColorCollarPart(Purrfect.MOD_ID+":red_collar");
    public static ColorCollarPart ORANGE = new ColorCollarPart(Purrfect.MOD_ID+":orange_collar");
    public static ColorCollarPart YELLOW = new ColorCollarPart(Purrfect.MOD_ID+":yellow_collar");
    public static ColorCollarPart LIME = new ColorCollarPart(Purrfect.MOD_ID+":lime_collar");
    public static ColorCollarPart GREEN = new ColorCollarPart(Purrfect.MOD_ID+":green_collar");
    public static ColorCollarPart CYAN = new ColorCollarPart(Purrfect.MOD_ID+":cyan_collar");
    public static ColorCollarPart LIGHT_BLUE = new ColorCollarPart(Purrfect.MOD_ID+":light_blue_collar");
    public static ColorCollarPart BLUE = new ColorCollarPart(Purrfect.MOD_ID+":blue_collar");
    public static ColorCollarPart PURPLE = new ColorCollarPart(Purrfect.MOD_ID+":purple_collar");
    public static ColorCollarPart MAGENTA = new ColorCollarPart(Purrfect.MOD_ID+":magenta_collar");
    public static ColorCollarPart PINK = new ColorCollarPart(Purrfect.MOD_ID+":pink_collar");
    public static ColorCollarPart RAINBOW = new ColorCollarPart(Purrfect.MOD_ID+":rainbow_collar");

    public static BellCollarPart COPPER_BELL = new BellCollarPart(Purrfect.MOD_ID+":copper_bell");
    public static BellCollarPart IRON_BELL = new BellCollarPart(Purrfect.MOD_ID+":iron_bell");
    public static BellCollarPart GOLDEN_BELL = new BellCollarPart(Purrfect.MOD_ID+":golden_bell");
    public static BellCollarPart DIAMOND_BELL = new BellCollarPart(Purrfect.MOD_ID+":diamond_bell");
    public static BellCollarPart NETHERITE_BELL = new BellCollarPart(Purrfect.MOD_ID+":netherite_bell");
    public static LockCollarPart COPPER_LOCK = new LockCollarPart(Purrfect.MOD_ID+":copper_lock");
    public static LockCollarPart IRON_LOCK = new LockCollarPart(Purrfect.MOD_ID+":iron_lock");
    public static LockCollarPart GOLDEN_LOCK = new LockCollarPart(Purrfect.MOD_ID+":golden_lock");
    public static LockCollarPart DIAMOND_LOCK = new LockCollarPart(Purrfect.MOD_ID+":diamond_lock");
    public static LockCollarPart NETHERITE_LOCK = new LockCollarPart(Purrfect.MOD_ID+":netherite_lock");

    public static DecorationCollarPart SPIKES = new DecorationCollarPart(Purrfect.MOD_ID+":spikes");

    public static void register() {
        CollarPartHandler.COLOR.register(COLLAR);
        CollarPartHandler.COLOR.register(WHITE);
        CollarPartHandler.COLOR.register(LIGHT_GRAY);
        CollarPartHandler.COLOR.register(GRAY);
        CollarPartHandler.COLOR.register(BLACK);
        CollarPartHandler.COLOR.register(BROWN);
        CollarPartHandler.COLOR.register(RED);
        CollarPartHandler.COLOR.register(ORANGE);
        CollarPartHandler.COLOR.register(YELLOW);
        CollarPartHandler.COLOR.register(LIME);
        CollarPartHandler.COLOR.register(GREEN);
        CollarPartHandler.COLOR.register(CYAN);
        CollarPartHandler.COLOR.register(LIGHT_BLUE);
        CollarPartHandler.COLOR.register(BLUE);
        CollarPartHandler.COLOR.register(PURPLE);
        CollarPartHandler.COLOR.register(MAGENTA);
        CollarPartHandler.COLOR.register(PINK);
        CollarPartHandler.COLOR.register(RAINBOW);

        CollarPartHandler.ACCESSORY.register(COPPER_BELL);
        CollarPartHandler.ACCESSORY.register(IRON_BELL);
        CollarPartHandler.ACCESSORY.register(GOLDEN_BELL);
        CollarPartHandler.ACCESSORY.register(DIAMOND_BELL);
        CollarPartHandler.ACCESSORY.register(NETHERITE_BELL);
        CollarPartHandler.ACCESSORY.register(COPPER_LOCK);
        CollarPartHandler.ACCESSORY.register(IRON_LOCK);
        CollarPartHandler.ACCESSORY.register(GOLDEN_LOCK);
        CollarPartHandler.ACCESSORY.register(DIAMOND_LOCK);
        CollarPartHandler.ACCESSORY.register(NETHERITE_LOCK);

        CollarPartHandler.DECORATION.register(SPIKES);
    }
}
