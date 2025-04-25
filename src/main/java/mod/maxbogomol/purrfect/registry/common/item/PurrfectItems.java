package mod.maxbogomol.purrfect.registry.common.item;

import mod.maxbogomol.fluffy_fur.common.item.PlushItem;
import mod.maxbogomol.fluffy_fur.registry.client.FluffyFurModels;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.client.render.curio.CollarRenderer;
import mod.maxbogomol.purrfect.client.render.curio.FlowerWreathRenderer;
import mod.maxbogomol.purrfect.common.item.PurrfectRenderStandingAndWallBlockItem;
import mod.maxbogomol.purrfect.common.item.YarnItem;
import mod.maxbogomol.purrfect.common.item.equipment.LeashItem;
import mod.maxbogomol.purrfect.common.item.equipment.curio.CollarItem;
import mod.maxbogomol.purrfect.common.item.equipment.curio.FlowerWreathItem;
import mod.maxbogomol.purrfect.registry.common.block.PurrfectBlocks;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

import java.util.Map;

public class PurrfectItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Purrfect.MOD_ID);

    public static final RegistryObject<Item> PHARMACIST_TABLE = ITEMS.register("pharmacist_table", () -> new BlockItem(PurrfectBlocks.PHARMACIST_TABLE.get(), new Item.Properties()));

    public static final RegistryObject<Item> PHARMACY_VIAL = ITEMS.register("pharmacy_vial", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> PHARMACY_VIAL_INK = ITEMS.register("pharmacy_vial_ink", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> PHARMACY_VIAL_PINK_FOX = ITEMS.register("pharmacy_vial_pink_fox", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> PHARMACY_VIAL_GOATED = ITEMS.register("pharmacy_vial_goated", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> PHARMACY_VIAL_CRYSTAL_RINGING = ITEMS.register("pharmacy_vial_crystal_ringing", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> PHARMACY_VIAL_RAINBOW_SPARK = ITEMS.register("pharmacy_vial_rainbow_spark", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> PHARMACY_VIAL_SLIMY_SLUG = ITEMS.register("pharmacy_vial_slimy_slug", () -> new Item(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> BLAHAJ_PLUSH = ITEMS.register("blahaj_plush", () -> new PlushItem(PurrfectBlocks.BLAHAJ_PLUSH.get(), new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> PINK_BLAHAJ_PLUSH = ITEMS.register("pink_blahaj_plush", () -> new PlushItem(PurrfectBlocks.PINK_BLAHAJ_PLUSH.get(), new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> DANDELION_FLOWER_WREATH = ITEMS.register("dandelion_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.DANDELION));
    public static final RegistryObject<Item> POPPY_FLOWER_WREATH = ITEMS.register("poppy_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.POPPY));
    public static final RegistryObject<Item> BLUE_ORCHID_FLOWER_WREATH = ITEMS.register("blue_orchid_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.BLUE_ORCHID));
    public static final RegistryObject<Item> ALLIUM_FLOWER_WREATH = ITEMS.register("allium_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.ALLIUM));
    public static final RegistryObject<Item> AZURE_BLUET_FLOWER_WREATH = ITEMS.register("azure_bluet_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.AZURE_BLUET));
    public static final RegistryObject<Item> RED_TULIP_FLOWER_WREATH = ITEMS.register("red_tulip_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.RED_TULIP));
    public static final RegistryObject<Item> ORANGE_TULIP_FLOWER_WREATH = ITEMS.register("orange_tulip_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.ORANGE_TULIP));
    public static final RegistryObject<Item> WHITE_TULIP_FLOWER_WREATH = ITEMS.register("white_tulip_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.WHITE_TULIP));
    public static final RegistryObject<Item> PINK_TULIP_FLOWER_WREATH = ITEMS.register("pink_tulip_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.PINK_TULIP));
    public static final RegistryObject<Item> OXEYE_DAISY_FLOWER_WREATH = ITEMS.register("oxeye_daisy_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.OXEYE_DAISY));
    public static final RegistryObject<Item> CORNFLOWER_FLOWER_WREATH = ITEMS.register("cornflower_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.CORNFLOWER));
    public static final RegistryObject<Item> LILY_OF_THE_VALLEY_FLOWER_WREATH = ITEMS.register("lily_of_the_valley_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.LILY_OF_THE_VALLEY));
    public static final RegistryObject<Item> PINK_PETALS_FLOWER_WREATH = ITEMS.register("pink_petals_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.PINK_PETALS));
    public static final RegistryObject<Item> SUNFLOWER_FLOWER_WREATH = ITEMS.register("sunflower_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.SUNFLOWER));
    public static final RegistryObject<Item> LILAC_FLOWER_WREATH = ITEMS.register("lilac_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.LILAC));
    public static final RegistryObject<Item> ROSE_BUSH_FLOWER_WREATH = ITEMS.register("rose_bush_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.ROSE_BUSH));
    public static final RegistryObject<Item> PEONY_FLOWER_WREATH = ITEMS.register("peony_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.PEONY));
    public static final RegistryObject<Item> DEAD_BUSH_FLOWER_WREATH = ITEMS.register("dead_bush_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.DEAD_BUSH));
    public static final RegistryObject<Item> WITHER_ROSE_FLOWER_WREATH = ITEMS.register("wither_rose_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.WITHER_ROSE));
    public static final RegistryObject<Item> TORCHFLOWER_FLOWER_WREATH = ITEMS.register("torchflower_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.TORCHFLOWER));
    public static final RegistryObject<Item> PITCHER_PLANT_FLOWER_WREATH = ITEMS.register("pitcher_plant_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.PITCHER_PLANT));
    public static final RegistryObject<Item> CUTIE_FLOWER_WREATH = ITEMS.register("cutie_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(FlowerWreathItem.CUTIE));

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

    public static final RegistryObject<Item> LEASH = ITEMS.register("leash", () -> new LeashItem(LeashItem.LEASH, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> WHITE_LEASH = ITEMS.register("white_leash", () -> new LeashItem(LeashItem.WHITE, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LIGHT_GRAY_LEASH = ITEMS.register("light_gray_leash", () -> new LeashItem(LeashItem.LIGHT_GRAY, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> GRAY_LEASH = ITEMS.register("gray_leash", () -> new LeashItem(LeashItem.GRAY, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BLACK_LEASH = ITEMS.register("black_leash", () -> new LeashItem(LeashItem.BLACK, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BROWN_LEASH = ITEMS.register("brown_leash", () -> new LeashItem(LeashItem.BROWN, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> RED_LEASH = ITEMS.register("red_leash", () -> new LeashItem(LeashItem.RED, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ORANGE_LEASH = ITEMS.register("orange_leash", () -> new LeashItem(LeashItem.ORANGE, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> YELLOW_LEASH = ITEMS.register("yellow_leash", () -> new LeashItem(LeashItem.YELLOW, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LIME_LEASH = ITEMS.register("lime_leash", () -> new LeashItem(LeashItem.LIME, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> GREEN_LEASH = ITEMS.register("green_leash", () -> new LeashItem(LeashItem.GREEN, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> CYAN_LEASH = ITEMS.register("cyan_leash", () -> new LeashItem(LeashItem.CYAN, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LIGHT_BLUE_LEASH = ITEMS.register("light_blue_leash", () -> new LeashItem(LeashItem.LIGHT_BLUE, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BLUE_LEASH = ITEMS.register("blue_leash", () -> new LeashItem(LeashItem.BLUE, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PURPLE_LEASH = ITEMS.register("purple_leash", () -> new LeashItem(LeashItem.PURPLE, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MAGENTA_LEASH = ITEMS.register("magenta_leash", () -> new LeashItem(LeashItem.MAGENTA, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PINK_LEASH = ITEMS.register("pink_leash", () -> new LeashItem(LeashItem.PINK, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> RAINBOW_LEASH = ITEMS.register("rainbow_leash", () -> new LeashItem(LeashItem.RAINBOW, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> WHITE_YARN = ITEMS.register("white_yarn", () -> new YarnItem(YarnItem.WHITE, new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> LIGHT_GRAY_YARN = ITEMS.register("light_gray_yarn", () -> new YarnItem(YarnItem.LIGHT_GRAY, new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> GRAY_YARN = ITEMS.register("gray_yarn", () -> new YarnItem(YarnItem.GRAY, new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> BLACK_YARN = ITEMS.register("black_yarn", () -> new YarnItem(YarnItem.BLACK, new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> BROWN_YARN = ITEMS.register("brown_yarn", () -> new YarnItem(YarnItem.BROWN, new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> RED_YARN = ITEMS.register("red_yarn", () -> new YarnItem(YarnItem.RED, new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> ORANGE_YARN = ITEMS.register("orange_yarn", () -> new YarnItem(YarnItem.ORANGE, new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> YELLOW_YARN = ITEMS.register("yellow_yarn", () -> new YarnItem(YarnItem.YELLOW, new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> LIME_YARN = ITEMS.register("lime_yarn", () -> new YarnItem(YarnItem.LIME, new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> GREEN_YARN = ITEMS.register("green_yarn", () -> new YarnItem(YarnItem.GREEN, new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> CYAN_YARN = ITEMS.register("cyan_yarn", () -> new YarnItem(YarnItem.CYAN, new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> LIGHT_BLUE_YARN = ITEMS.register("light_blue_yarn", () -> new YarnItem(YarnItem.LIGHT_BLUE, new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> BLUE_YARN = ITEMS.register("blue_yarn", () -> new YarnItem(YarnItem.BLUE, new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> PURPLE_YARN = ITEMS.register("purple_yarn", () -> new YarnItem(YarnItem.PURPLE, new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> MAGENTA_YARN = ITEMS.register("magenta_yarn", () -> new YarnItem(YarnItem.MAGENTA, new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> PINK_YARN = ITEMS.register("pink_yarn", () -> new YarnItem(YarnItem.PINK, new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> RAINBOW_YARN = ITEMS.register("rainbow_yarn", () -> new YarnItem(YarnItem.RAINBOW, new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> FLAGPOLE = ITEMS.register("flagpole", () -> new BlockItem(PurrfectBlocks.FLAGPOLE.get(), new Item.Properties()));
    public static final RegistryObject<Item> WHITE_FLAG = ITEMS.register("white_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.WHITE_FLAG.get(), PurrfectBlocks.WHITE_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> LIGHT_GRAY_FLAG = ITEMS.register("light_gray_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.LIGHT_GRAY_FLAG.get(), PurrfectBlocks.LIGHT_GRAY_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> GRAY_FLAG = ITEMS.register("gray_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.GRAY_FLAG.get(), PurrfectBlocks.GRAY_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> BLACK_FLAG = ITEMS.register("black_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.BLACK_FLAG.get(), PurrfectBlocks.BLACK_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> BROWN_FLAG = ITEMS.register("brown_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.BROWN_FLAG.get(), PurrfectBlocks.BROWN_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> RED_FLAG = ITEMS.register("red_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.RED_FLAG.get(), PurrfectBlocks.RED_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> ORANGE_FLAG = ITEMS.register("orange_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.ORANGE_FLAG.get(), PurrfectBlocks.ORANGE_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> YELLOW_FLAG = ITEMS.register("yellow_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.YELLOW_FLAG.get(), PurrfectBlocks.YELLOW_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> LIME_FLAG = ITEMS.register("lime_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.LIME_FLAG.get(), PurrfectBlocks.LIME_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> GREEN_FLAG = ITEMS.register("green_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.GREEN_FLAG.get(), PurrfectBlocks.GREEN_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> CYAN_FLAG = ITEMS.register("cyan_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.CYAN_FLAG.get(), PurrfectBlocks.CYAN_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> LIGHT_BLUE_FLAG = ITEMS.register("light_blue_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.LIGHT_BLUE_FLAG.get(), PurrfectBlocks.LIGHT_BLUE_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> BLUE_FLAG = ITEMS.register("blue_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.BLUE_FLAG.get(), PurrfectBlocks.BLUE_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> PURPLE_FLAG = ITEMS.register("purple_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.PURPLE_FLAG.get(), PurrfectBlocks.PURPLE_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> MAGENTA_FLAG = ITEMS.register("magenta_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.MAGENTA_FLAG.get(), PurrfectBlocks.MAGENTA_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> PINK_FLAG = ITEMS.register("pink_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.PINK_FLAG.get(), PurrfectBlocks.PINK_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> RAINBOW_FLAG = ITEMS.register("rainbow_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.RAINBOW_FLAG.get(), PurrfectBlocks.RAINBOW_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> HETEROSEXUAL_FLAG = ITEMS.register("heterosexual_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.HETEROSEXUAL_FLAG.get(), PurrfectBlocks.HETEROSEXUAL_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> PRIDE_FLAG = ITEMS.register("pride_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.PRIDE_FLAG.get(), PurrfectBlocks.PRIDE_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> LESBIAN_FLAG = ITEMS.register("lesbian_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.LESBIAN_FLAG.get(), PurrfectBlocks.LESBIAN_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> GAY_FLAG = ITEMS.register("gay_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.GAY_FLAG.get(), PurrfectBlocks.GAY_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> BI_FLAG = ITEMS.register("bi_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.BI_FLAG.get(), PurrfectBlocks.BI_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> TRANS_FLAG = ITEMS.register("trans_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.TRANS_FLAG.get(), PurrfectBlocks.TRANS_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> ENBY_FLAG = ITEMS.register("enby_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.ENBY_FLAG.get(), PurrfectBlocks.ENBY_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> GENDERFLUID_FLAG = ITEMS.register("genderfluid_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.GENDERFLUID_FLAG.get(), PurrfectBlocks.GENDERFLUID_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEMIBOY_FLAG = ITEMS.register("demiboy_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.DEMIBOY_FLAG.get(), PurrfectBlocks.DEMIBOY_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEMIGIRL_FLAG = ITEMS.register("demigirl_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.DEMIGIRL_FLAG.get(), PurrfectBlocks.DEMIGIRL_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEMIGENDER_FLAG = ITEMS.register("demigender_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.DEMIGENDER_FLAG.get(), PurrfectBlocks.DEMIGENDER_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> AGENDER_FLAG = ITEMS.register("agender_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.AGENDER_FLAG.get(), PurrfectBlocks.AGENDER_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> PAN_FLAG = ITEMS.register("pan_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.PAN_FLAG.get(), PurrfectBlocks.PAN_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> OMNI_FLAG = ITEMS.register("omni_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.OMNI_FLAG.get(), PurrfectBlocks.OMNI_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> POLY_FLAG = ITEMS.register("poly_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.POLY_FLAG.get(), PurrfectBlocks.POLY_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> DEMISEXUAL_FLAG = ITEMS.register("demisexual_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.DEMISEXUAL_FLAG.get(), PurrfectBlocks.DEMISEXUAL_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> ACE_FLAG = ITEMS.register("ace_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.ACE_FLAG.get(), PurrfectBlocks.ACE_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> ARO_FLAG = ITEMS.register("aro_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.ARO_FLAG.get(), PurrfectBlocks.ARO_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> AROACE_FLAG = ITEMS.register("aroace_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.AROACE_FLAG.get(), PurrfectBlocks.AROACE_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> KVASSSEXUAL_FLAG = ITEMS.register("kvasssexual_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.KVASSSEXUAL_FLAG.get(), PurrfectBlocks.KVASSSEXUAL_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> BEERSEXUAL_FLAG = ITEMS.register("beersexual_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.BEERSEXUAL_FLAG.get(), PurrfectBlocks.BEERSEXUAL_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> WIZARDS_REBORN_FLAG = ITEMS.register("wizards_reborn_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.WIZARDS_REBORN_FLAG.get(), PurrfectBlocks.WIZARDS_REBORN_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> FLUFFY_FUR_FLAG = ITEMS.register("fluffy_fur_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.FLUFFY_FUR_FLAG.get(), PurrfectBlocks.FLUFFY_FUR_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));

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
                if (!string.isEmpty()) {
                    if (!string.contains(".")) break;
                    int i = string.indexOf(".");
                    string = string.substring(i + 1);
                    if (!string.contains(".")) break;
                    i = string.indexOf(".");
                    String modId = string.substring(0, i);
                    if (modId.equals(Purrfect.MOD_ID) && item instanceof CollarItem) {
                        CuriosRendererRegistry.register(item, CollarRenderer::new);
                    }
                    if (modId.equals(Purrfect.MOD_ID) && item instanceof FlowerWreathItem) {
                        CuriosRendererRegistry.register(item, FlowerWreathRenderer::new);
                    }
                }
            }
        }

        @SubscribeEvent
        public static void modelBakeItems(ModelEvent.ModifyBakingResult event) {
            Map<ResourceLocation, BakedModel> map = event.getModels();

            FluffyFurModels.addCustomRenderItemModel(map, WHITE_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, LIGHT_GRAY_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, GRAY_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, BLACK_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, BROWN_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, RED_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, ORANGE_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, YELLOW_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, LIME_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, GREEN_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, CYAN_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, LIGHT_BLUE_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, BLUE_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, PURPLE_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, MAGENTA_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, PINK_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, RAINBOW_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, HETEROSEXUAL_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, PRIDE_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, LESBIAN_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, GAY_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, BI_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, TRANS_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, ENBY_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, GENDERFLUID_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, DEMIBOY_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, DEMIGIRL_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, DEMIGENDER_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, AGENDER_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, PAN_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, OMNI_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, POLY_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, DEMISEXUAL_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, ACE_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, ARO_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, AROACE_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, KVASSSEXUAL_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, BEERSEXUAL_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, WIZARDS_REBORN_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, FLUFFY_FUR_FLAG.getId());
        }
    }
}
