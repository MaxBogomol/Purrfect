package mod.maxbogomol.purrfect.registry.common.item;

import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.client.render.curio.CollarRenderer;
import mod.maxbogomol.purrfect.common.item.equipment.curio.CollarItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

public class PurrfectItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Purrfect.MOD_ID);

    public static final RegistryObject<Item> COLLAR = ITEMS.register("collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.COLLAR));
    public static final RegistryObject<Item> WHITE_COLLAR = ITEMS.register("white_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.WHITE));
    public static final RegistryObject<Item> LIGHT_GRAY_COLLAR = ITEMS.register("light_gray_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.LIGHT_GRAY));
    public static final RegistryObject<Item> GRAY_COLLAR = ITEMS.register("gray_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.GRAY));
    public static final RegistryObject<Item> BLACK_COLLAR = ITEMS.register("black_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.BLACK));
    public static final RegistryObject<Item> BROWN_COLLAR = ITEMS.register("brown_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.BROWN));
    public static final RegistryObject<Item> RED_COLLAR = ITEMS.register("red_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.RED));
    public static final RegistryObject<Item> ORANGE_COLLAR = ITEMS.register("orange_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.ORANGE));
    public static final RegistryObject<Item> YELLOW_COLLAR = ITEMS.register("yellow_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.YELLOW));
    public static final RegistryObject<Item> LIME_COLLAR = ITEMS.register("lime_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.LIME));
    public static final RegistryObject<Item> GREEN_COLLAR = ITEMS.register("green_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.GREEN));
    public static final RegistryObject<Item> CYAN_COLLAR = ITEMS.register("cyan_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.CYAN));
    public static final RegistryObject<Item> LIGHT_BLUE_COLLAR = ITEMS.register("light_blue_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.LIGHT_BLUE));
    public static final RegistryObject<Item> BLUE_COLLAR = ITEMS.register("blue_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.BLUE));
    public static final RegistryObject<Item> PURPLE_COLLAR = ITEMS.register("purple_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.PURPLE));
    public static final RegistryObject<Item> MAGENTA_COLLAR = ITEMS.register("magenta_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.MAGENTA));
    public static final RegistryObject<Item> PINK_COLLAR = ITEMS.register("pink_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.PINK));
    public static final RegistryObject<Item> RAINBOW_COLLAR = ITEMS.register("rainbow_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.RAINBOW));

    public static final RegistryObject<Item> IRON_BELL_COLLAR = ITEMS.register("iron_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.COLLAR).setBell(CollarItem.IRON_BELL));
    public static final RegistryObject<Item> WHITE_IRON_BELL_COLLAR = ITEMS.register("white_iron_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.WHITE).setBell(CollarItem.IRON_BELL));
    public static final RegistryObject<Item> LIGHT_GRAY_IRON_BELL_COLLAR = ITEMS.register("light_gray_iron_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.LIGHT_GRAY).setBell(CollarItem.IRON_BELL));
    public static final RegistryObject<Item> GRAY_IRON_BELL_COLLAR = ITEMS.register("gray_iron_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.GRAY).setBell(CollarItem.IRON_BELL));
    public static final RegistryObject<Item> BLACK_IRON_BELL_COLLAR = ITEMS.register("black_iron_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.BLACK).setBell(CollarItem.IRON_BELL));
    public static final RegistryObject<Item> BROWN_IRON_BELL_COLLAR = ITEMS.register("brown_iron_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.BROWN).setBell(CollarItem.IRON_BELL));
    public static final RegistryObject<Item> RED_IRON_BELL_COLLAR = ITEMS.register("red_iron_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.RED).setBell(CollarItem.IRON_BELL));
    public static final RegistryObject<Item> ORANGE_IRON_BELL_COLLAR = ITEMS.register("orange_iron_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.ORANGE).setBell(CollarItem.IRON_BELL));
    public static final RegistryObject<Item> YELLOW_IRON_BELL_COLLAR = ITEMS.register("yellow_iron_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.YELLOW).setBell(CollarItem.IRON_BELL));
    public static final RegistryObject<Item> LIME_IRON_BELL_COLLAR = ITEMS.register("lime_iron_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.LIME).setBell(CollarItem.IRON_BELL));
    public static final RegistryObject<Item> GREEN_IRON_BELL_COLLAR = ITEMS.register("green_iron_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.GREEN).setBell(CollarItem.IRON_BELL));
    public static final RegistryObject<Item> CYAN_IRON_BELL_COLLAR = ITEMS.register("cyan_iron_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.CYAN).setBell(CollarItem.IRON_BELL));
    public static final RegistryObject<Item> LIGHT_BLUE_IRON_BELL_COLLAR = ITEMS.register("light_blue_iron_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.LIGHT_BLUE).setBell(CollarItem.IRON_BELL));
    public static final RegistryObject<Item> BLUE_IRON_BELL_COLLAR = ITEMS.register("blue_iron_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.BLUE).setBell(CollarItem.IRON_BELL));
    public static final RegistryObject<Item> PURPLE_IRON_BELL_COLLAR = ITEMS.register("purple_iron_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.PURPLE).setBell(CollarItem.IRON_BELL));
    public static final RegistryObject<Item> MAGENTA_IRON_BELL_COLLAR = ITEMS.register("magenta_iron_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.MAGENTA).setBell(CollarItem.IRON_BELL));
    public static final RegistryObject<Item> PINK_IRON_BELL_COLLAR = ITEMS.register("pink_iron_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.PINK).setBell(CollarItem.IRON_BELL));
    public static final RegistryObject<Item> RAINBOW_IRON_BELL_COLLAR = ITEMS.register("rainbow_iron_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.RAINBOW).setBell(CollarItem.IRON_BELL));

    public static final RegistryObject<Item> GOLDEN_BELL_COLLAR = ITEMS.register("golden_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.COLLAR).setBell(CollarItem.GOLDEN_BELL));
    public static final RegistryObject<Item> WHITE_GOLDEN_BELL_COLLAR = ITEMS.register("white_golden_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.WHITE).setBell(CollarItem.GOLDEN_BELL));
    public static final RegistryObject<Item> LIGHT_GRAY_GOLDEN_BELL_COLLAR = ITEMS.register("light_gray_golden_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.LIGHT_GRAY).setBell(CollarItem.GOLDEN_BELL));
    public static final RegistryObject<Item> GRAY_GOLDEN_BELL_COLLAR = ITEMS.register("gray_golden_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.GRAY).setBell(CollarItem.GOLDEN_BELL));
    public static final RegistryObject<Item> BLACK_GOLDEN_BELL_COLLAR = ITEMS.register("black_golden_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.BLACK).setBell(CollarItem.GOLDEN_BELL));
    public static final RegistryObject<Item> BROWN_GOLDEN_BELL_COLLAR = ITEMS.register("brown_golden_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.BROWN).setBell(CollarItem.GOLDEN_BELL));
    public static final RegistryObject<Item> RED_GOLDEN_BELL_COLLAR = ITEMS.register("red_golden_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.RED).setBell(CollarItem.GOLDEN_BELL));
    public static final RegistryObject<Item> ORANGE_GOLDEN_BELL_COLLAR = ITEMS.register("orange_golden_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.ORANGE).setBell(CollarItem.GOLDEN_BELL));
    public static final RegistryObject<Item> YELLOW_GOLDEN_BELL_COLLAR = ITEMS.register("yellow_golden_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.YELLOW).setBell(CollarItem.GOLDEN_BELL));
    public static final RegistryObject<Item> LIME_GOLDEN_BELL_COLLAR = ITEMS.register("lime_golden_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.LIME).setBell(CollarItem.GOLDEN_BELL));
    public static final RegistryObject<Item> GREEN_GOLDEN_BELL_COLLAR = ITEMS.register("green_golden_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.GREEN).setBell(CollarItem.GOLDEN_BELL));
    public static final RegistryObject<Item> CYAN_GOLDEN_BELL_COLLAR = ITEMS.register("cyan_golden_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.CYAN).setBell(CollarItem.GOLDEN_BELL));
    public static final RegistryObject<Item> LIGHT_BLUE_GOLDEN_BELL_COLLAR = ITEMS.register("light_blue_golden_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.LIGHT_BLUE).setBell(CollarItem.GOLDEN_BELL));
    public static final RegistryObject<Item> BLUE_GOLDEN_BELL_COLLAR = ITEMS.register("blue_golden_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.BLUE).setBell(CollarItem.GOLDEN_BELL));
    public static final RegistryObject<Item> PURPLE_GOLDEN_BELL_COLLAR = ITEMS.register("purple_golden_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.PURPLE).setBell(CollarItem.GOLDEN_BELL));
    public static final RegistryObject<Item> MAGENTA_GOLDEN_BELL_COLLAR = ITEMS.register("magenta_golden_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.MAGENTA).setBell(CollarItem.GOLDEN_BELL));
    public static final RegistryObject<Item> PINK_GOLDEN_BELL_COLLAR = ITEMS.register("pink_golden_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.PINK).setBell(CollarItem.GOLDEN_BELL));
    public static final RegistryObject<Item> RAINBOW_GOLDEN_BELL_COLLAR = ITEMS.register("rainbow_golden_bell_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.RAINBOW).setBell(CollarItem.GOLDEN_BELL));

    public static final RegistryObject<Item> SPIKED_COLLAR = ITEMS.register("spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.COLLAR).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> WHITE_SPIKED_COLLAR = ITEMS.register("white_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.WHITE).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> LIGHT_GRAY_SPIKED_COLLAR = ITEMS.register("light_gray_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.LIGHT_GRAY).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> GRAY_SPIKED_COLLAR = ITEMS.register("gray_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.GRAY).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> BLACK_SPIKED_COLLAR = ITEMS.register("black_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.BLACK).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> BROWN_SPIKED_COLLAR = ITEMS.register("brown_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.BROWN).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> RED_SPIKED_COLLAR = ITEMS.register("red_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.RED).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> ORANGE_SPIKED_COLLAR = ITEMS.register("orange_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.ORANGE).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> YELLOW_SPIKED_COLLAR = ITEMS.register("yellow_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.YELLOW).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> LIME_SPIKED_COLLAR = ITEMS.register("lime_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.LIME).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> GREEN_SPIKED_COLLAR = ITEMS.register("green_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.GREEN).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> CYAN_SPIKED_COLLAR = ITEMS.register("cyan_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.CYAN).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> LIGHT_BLUE_SPIKED_COLLAR = ITEMS.register("light_blue_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.LIGHT_BLUE).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> BLUE_SPIKED_COLLAR = ITEMS.register("blue_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.BLUE).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> PURPLE_SPIKED_COLLAR = ITEMS.register("purple_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.PURPLE).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> MAGENTA_SPIKED_COLLAR = ITEMS.register("magenta_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.MAGENTA).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> PINK_SPIKED_COLLAR = ITEMS.register("pink_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.PINK).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> RAINBOW_SPIKED_COLLAR = ITEMS.register("rainbow_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.RAINBOW).setSpikes(CollarItem.SPIKES));

    public static final RegistryObject<Item> IRON_BELL_SPIKED_COLLAR = ITEMS.register("iron_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.COLLAR).setBell(CollarItem.IRON_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> WHITE_IRON_BELL_SPIKED_COLLAR = ITEMS.register("white_iron_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.WHITE).setBell(CollarItem.IRON_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> LIGHT_GRAY_IRON_BELL_SPIKED_COLLAR = ITEMS.register("light_gray_iron_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.LIGHT_GRAY).setBell(CollarItem.IRON_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> GRAY_IRON_BELL_SPIKED_COLLAR = ITEMS.register("gray_iron_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.GRAY).setBell(CollarItem.IRON_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> BLACK_IRON_BELL_SPIKED_COLLAR = ITEMS.register("black_iron_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.BLACK).setBell(CollarItem.IRON_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> BROWN_IRON_BELL_SPIKED_COLLAR = ITEMS.register("brown_iron_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.BROWN).setBell(CollarItem.IRON_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> RED_IRON_BELL_SPIKED_COLLAR = ITEMS.register("red_iron_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.RED).setBell(CollarItem.IRON_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> ORANGE_IRON_BELL_SPIKED_COLLAR = ITEMS.register("orange_iron_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.ORANGE).setBell(CollarItem.IRON_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> YELLOW_IRON_BELL_SPIKED_COLLAR = ITEMS.register("yellow_iron_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.YELLOW).setBell(CollarItem.IRON_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> LIME_IRON_BELL_SPIKED_COLLAR = ITEMS.register("lime_iron_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.LIME).setBell(CollarItem.IRON_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> GREEN_IRON_BELL_SPIKED_COLLAR = ITEMS.register("green_iron_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.GREEN).setBell(CollarItem.IRON_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> CYAN_IRON_BELL_SPIKED_COLLAR = ITEMS.register("cyan_iron_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.CYAN).setBell(CollarItem.IRON_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> LIGHT_BLUE_IRON_BELL_SPIKED_COLLAR = ITEMS.register("light_blue_iron_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.LIGHT_BLUE).setBell(CollarItem.IRON_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> BLUE_IRON_BELL_SPIKED_COLLAR = ITEMS.register("blue_iron_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.BLUE).setBell(CollarItem.IRON_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> PURPLE_IRON_BELL_SPIKED_COLLAR = ITEMS.register("purple_iron_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.PURPLE).setBell(CollarItem.IRON_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> MAGENTA_IRON_BELL_SPIKED_COLLAR = ITEMS.register("magenta_iron_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.MAGENTA).setBell(CollarItem.IRON_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> PINK_IRON_BELL_SPIKED_COLLAR = ITEMS.register("pink_iron_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.PINK).setBell(CollarItem.IRON_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> RAINBOW_IRON_BELL_SPIKED_COLLAR = ITEMS.register("rainbow_iron_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.RAINBOW).setBell(CollarItem.IRON_BELL).setSpikes(CollarItem.SPIKES));

    public static final RegistryObject<Item> GOLDEN_BELL_SPIKED_COLLAR = ITEMS.register("golden_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.COLLAR).setBell(CollarItem.GOLDEN_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> WHITE_GOLDEN_BELL_SPIKED_COLLAR = ITEMS.register("white_golden_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.WHITE).setBell(CollarItem.GOLDEN_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> LIGHT_GRAY_GOLDEN_BELL_SPIKED_COLLAR = ITEMS.register("light_gray_golden_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.LIGHT_GRAY).setBell(CollarItem.GOLDEN_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> GRAY_GOLDEN_BELL_SPIKED_COLLAR = ITEMS.register("gray_golden_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.GRAY).setBell(CollarItem.GOLDEN_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> BLACK_GOLDEN_BELL_SPIKED_COLLAR = ITEMS.register("black_golden_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.BLACK).setBell(CollarItem.GOLDEN_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> BROWN_GOLDEN_BELL_SPIKED_COLLAR = ITEMS.register("brown_golden_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.BROWN).setBell(CollarItem.GOLDEN_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> RED_GOLDEN_BELL_SPIKED_COLLAR = ITEMS.register("red_golden_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.RED).setBell(CollarItem.GOLDEN_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> ORANGE_GOLDEN_BELL_SPIKED_COLLAR = ITEMS.register("orange_golden_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.ORANGE).setBell(CollarItem.GOLDEN_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> YELLOW_GOLDEN_BELL_SPIKED_COLLAR = ITEMS.register("yellow_golden_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.YELLOW).setBell(CollarItem.GOLDEN_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> LIME_GOLDEN_BELL_SPIKED_COLLAR = ITEMS.register("lime_golden_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.LIME).setBell(CollarItem.GOLDEN_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> GREEN_GOLDEN_BELL_SPIKED_COLLAR = ITEMS.register("green_golden_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.GREEN).setBell(CollarItem.GOLDEN_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> CYAN_GOLDEN_BELL_SPIKED_COLLAR = ITEMS.register("cyan_golden_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.CYAN).setBell(CollarItem.GOLDEN_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> LIGHT_BLUE_GOLDEN_BELL_SPIKED_COLLAR = ITEMS.register("light_blue_golden_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.LIGHT_BLUE).setBell(CollarItem.GOLDEN_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> BLUE_GOLDEN_BELL_SPIKED_COLLAR = ITEMS.register("blue_golden_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.BLUE).setBell(CollarItem.GOLDEN_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> PURPLE_GOLDEN_BELL_SPIKED_COLLAR = ITEMS.register("purple_golden_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.PURPLE).setBell(CollarItem.GOLDEN_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> MAGENTA_GOLDEN_BELL_SPIKED_COLLAR = ITEMS.register("magenta_golden_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.MAGENTA).setBell(CollarItem.GOLDEN_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> PINK_GOLDEN_BELL_SPIKED_COLLAR = ITEMS.register("pink_golden_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.PINK).setBell(CollarItem.GOLDEN_BELL).setSpikes(CollarItem.SPIKES));
    public static final RegistryObject<Item> RAINBOW_GOLDEN_BELL_SPIKED_COLLAR = ITEMS.register("rainbow_golden_bell_spiked_collar", () -> new CollarItem(new Item.Properties().stacksTo(1)).setColor(CollarItem.RAINBOW).setBell(CollarItem.GOLDEN_BELL).setSpikes(CollarItem.SPIKES));

    public static final RegistryObject<Item> WHITE_CLEW = ITEMS.register("white_clew", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LIGHT_GRAY_CLEW = ITEMS.register("light_gray_clew", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> GRAY_CLEW = ITEMS.register("gray_clew", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BLACK_CLEW = ITEMS.register("black_clew", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BROWN_CLEW = ITEMS.register("brown_clew", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> RED_CLEW = ITEMS.register("red_clew", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ORANGE_CLEW = ITEMS.register("orange_clew", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> YELLOW_CLEW = ITEMS.register("yellow_clew", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LIME_CLEW = ITEMS.register("lime_clew", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> GREEN_CLEW = ITEMS.register("green_clew", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> CYAN_CLEW = ITEMS.register("cyan_clew", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LIGHT_BLUE_CLEW = ITEMS.register("light_blue_clew", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BLUE_CLEW = ITEMS.register("blue_clew", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PURPLE_CLEW = ITEMS.register("purple_clew", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MAGENTA_CLEW = ITEMS.register("magenta_clew", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PINK_CLEW = ITEMS.register("pink_clew", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> RAINBOW_CLEW = ITEMS.register("rainbow_clew", () -> new Item(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    @Mod.EventBusSubscriber(modid = Purrfect.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientRegistryEvents {
        @SubscribeEvent
        public static void registerItems(FMLClientSetupEvent event) {
            IForgeRegistry<Item> items = ForgeRegistries.ITEMS;
            for (Item item : items) {
                String string = item.getDescriptionId();
                int i = string.indexOf(".");
                string = string.substring(i + 1);
                i = string.indexOf(".");
                String modId = string.substring(0, i);
                if (modId.equals(Purrfect.MOD_ID) && item instanceof CollarItem) {
                    CuriosRendererRegistry.register(item, CollarRenderer::new);
                }
            }
        }
    }
}
