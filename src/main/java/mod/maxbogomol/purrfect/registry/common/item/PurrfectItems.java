package mod.maxbogomol.purrfect.registry.common.item;

import mod.maxbogomol.fluffy_fur.common.item.PlushItem;
import mod.maxbogomol.fluffy_fur.integration.common.curios.PlushHeadRenderer;
import mod.maxbogomol.fluffy_fur.registry.client.FluffyFurModels;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.api.furry.CollarPart;
import mod.maxbogomol.purrfect.api.furry.CollarPartHandler;
import mod.maxbogomol.purrfect.client.render.curio.CollarRenderer;
import mod.maxbogomol.purrfect.client.render.curio.FlowerWreathRenderer;
import mod.maxbogomol.purrfect.common.collar.AccessoryCollarPart;
import mod.maxbogomol.purrfect.common.collar.ColorCollarPart;
import mod.maxbogomol.purrfect.common.collar.DecorationCollarPart;
import mod.maxbogomol.purrfect.common.item.PurrfectRenderStandingAndWallBlockItem;
import mod.maxbogomol.purrfect.common.item.YarnItem;
import mod.maxbogomol.purrfect.common.item.equipment.LeashItem;
import mod.maxbogomol.purrfect.common.item.equipment.ShipkeyItem;
import mod.maxbogomol.purrfect.common.item.equipment.SillyTagItem;
import mod.maxbogomol.purrfect.common.item.equipment.curio.CollarItem;
import mod.maxbogomol.purrfect.common.item.equipment.curio.FlowerWreathItem;
import mod.maxbogomol.purrfect.integration.common.wizards_reborn.PurrfectWizardsReborn;
import mod.maxbogomol.purrfect.registry.client.PurrfectModels;
import mod.maxbogomol.purrfect.registry.common.block.PurrfectBlocks;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
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
    public static final RegistryObject<Item> SHRIMP_PLUSH = ITEMS.register("shrimp_plush", () -> new PlushItem(PurrfectBlocks.SHRIMP_PLUSH.get(), new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> FISH_PLUSH = ITEMS.register("fish_plush", () -> new PlushItem(PurrfectBlocks.FISH_PLUSH.get(), new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> CARROT_PLUSH = ITEMS.register("carrot_plush", () -> new PlushItem(PurrfectBlocks.CARROT_PLUSH.get(), new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));

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

    public static final RegistryObject<Item> COLLAR = ITEMS.register("collar", () -> new CollarItem(new Item.Properties().stacksTo(1)));

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
    public static final RegistryObject<Item> CHAIN_LEASH = ITEMS.register("chain_leash", () -> new LeashItem(LeashItem.CHAIN, new Item.Properties().stacksTo(1)));

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

    public static final RegistryObject<Item> COPPER_SHIPKEY = ITEMS.register("copper_shipkey", () -> new ShipkeyItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> IRON_SHIPKEY = ITEMS.register("iron_shipkey", () -> new ShipkeyItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> GOLDEN_SHIPKEY = ITEMS.register("golden_shipkey", () -> new ShipkeyItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> DIAMOND_SHIPKEY = ITEMS.register("diamond_shipkey", () -> new ShipkeyItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> NETHERITE_SHIPKEY = ITEMS.register("netherite_shipkey", () -> new ShipkeyItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SILLY_TAG = ITEMS.register("silly_tag", () -> new SillyTagItem(new Item.Properties()));

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
    public static final RegistryObject<Item> SILLY_ODDITIES_FLAG = ITEMS.register("silly_oddities_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.SILLY_ODDITIES_FLAG.get(), PurrfectBlocks.SILLY_ODDITIES_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> OPTIFINE_FLAG = ITEMS.register("optifine_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.OPTIFINE_FLAG.get(), PurrfectBlocks.OPTIFINE_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));
    public static final RegistryObject<Item> SODIUM_FLAG = ITEMS.register("sodium_flag", () -> new PurrfectRenderStandingAndWallBlockItem(PurrfectBlocks.SODIUM_FLAG.get(), PurrfectBlocks.SODIUM_WALL_FLAG.get(), new Item.Properties(), Direction.DOWN));

    public static final RegistryObject<Item> OPTIFINE_BLOCK = ITEMS.register("optifine_block", () -> new BlockItem(PurrfectBlocks.OPTIFINE_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> OPTIFINE_STAIRS = ITEMS.register("optifine_stairs", () -> new BlockItem(PurrfectBlocks.OPTIFINE_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> OPTIFINE_SLAB = ITEMS.register("optifine_slab", () -> new BlockItem(PurrfectBlocks.OPTIFINE_SLAB.get(), new Item.Properties()));

    public static final RegistryObject<Item> SODIUM_BLOCK = ITEMS.register("sodium_block", () -> new BlockItem(PurrfectBlocks.SODIUM_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> SODIUM_STAIRS = ITEMS.register("sodium_stairs", () -> new BlockItem(PurrfectBlocks.SODIUM_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> SODIUM_SLAB = ITEMS.register("sodium_slab", () -> new BlockItem(PurrfectBlocks.SODIUM_SLAB.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    @Mod.EventBusSubscriber(modid = Purrfect.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientRegistryEvents {
        @SubscribeEvent
        public static void registerItems(FMLClientSetupEvent event) {
            CuriosRendererRegistry.register(BLAHAJ_PLUSH.get(), PlushHeadRenderer::new);
            CuriosRendererRegistry.register(PINK_BLAHAJ_PLUSH.get(), PlushHeadRenderer::new);
            CuriosRendererRegistry.register(SHRIMP_PLUSH.get(), PlushHeadRenderer::new);
            CuriosRendererRegistry.register(FISH_PLUSH.get(), PlushHeadRenderer::new);
            CuriosRendererRegistry.register(CARROT_PLUSH.get(), PlushHeadRenderer::new);

            CuriosRendererRegistry.register(DANDELION_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
            CuriosRendererRegistry.register(POPPY_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
            CuriosRendererRegistry.register(BLUE_ORCHID_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
            CuriosRendererRegistry.register(ALLIUM_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
            CuriosRendererRegistry.register(AZURE_BLUET_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
            CuriosRendererRegistry.register(RED_TULIP_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
            CuriosRendererRegistry.register(ORANGE_TULIP_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
            CuriosRendererRegistry.register(WHITE_TULIP_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
            CuriosRendererRegistry.register(PINK_TULIP_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
            CuriosRendererRegistry.register(OXEYE_DAISY_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
            CuriosRendererRegistry.register(CORNFLOWER_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
            CuriosRendererRegistry.register(LILY_OF_THE_VALLEY_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
            CuriosRendererRegistry.register(PINK_PETALS_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
            CuriosRendererRegistry.register(SUNFLOWER_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
            CuriosRendererRegistry.register(LILAC_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
            CuriosRendererRegistry.register(ROSE_BUSH_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
            CuriosRendererRegistry.register(DEAD_BUSH_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
            CuriosRendererRegistry.register(WITHER_ROSE_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
            CuriosRendererRegistry.register(TORCHFLOWER_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
            CuriosRendererRegistry.register(PITCHER_PLANT_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
            CuriosRendererRegistry.register(CUTIE_FLOWER_WREATH.get(), FlowerWreathRenderer::new);

            CuriosRendererRegistry.register(COLLAR.get(), CollarRenderer::new);

            if (PurrfectWizardsReborn.isLoaded()) {
                PurrfectWizardsReborn.ClientLoadedOnly.registerItems(event);
            }

            ItemProperties.register(LEASH.get(), new ResourceLocation("active"), (stack, level, entity, seed) -> LeashItem.isActive(stack, level) ? 1 : 0);
            ItemProperties.register(WHITE_LEASH.get(), new ResourceLocation("active"), (stack, level, entity, seed) -> LeashItem.isActive(stack, level) ? 1 : 0);
            ItemProperties.register(LIGHT_GRAY_LEASH.get(), new ResourceLocation("active"), (stack, level, entity, seed) -> LeashItem.isActive(stack, level) ? 1 : 0);
            ItemProperties.register(GRAY_LEASH.get(), new ResourceLocation("active"), (stack, level, entity, seed) -> LeashItem.isActive(stack, level) ? 1 : 0);
            ItemProperties.register(BLACK_LEASH.get(), new ResourceLocation("active"), (stack, level, entity, seed) -> LeashItem.isActive(stack, level) ? 1 : 0);
            ItemProperties.register(BROWN_LEASH.get(), new ResourceLocation("active"), (stack, level, entity, seed) -> LeashItem.isActive(stack, level) ? 1 : 0);
            ItemProperties.register(RED_LEASH.get(), new ResourceLocation("active"), (stack, level, entity, seed) -> LeashItem.isActive(stack, level) ? 1 : 0);
            ItemProperties.register(ORANGE_LEASH.get(), new ResourceLocation("active"), (stack, level, entity, seed) -> LeashItem.isActive(stack, level) ? 1 : 0);
            ItemProperties.register(YELLOW_LEASH.get(), new ResourceLocation("active"), (stack, level, entity, seed) -> LeashItem.isActive(stack, level) ? 1 : 0);
            ItemProperties.register(LIME_LEASH.get(), new ResourceLocation("active"), (stack, level, entity, seed) -> LeashItem.isActive(stack, level) ? 1 : 0);
            ItemProperties.register(GREEN_LEASH.get(), new ResourceLocation("active"), (stack, level, entity, seed) -> LeashItem.isActive(stack, level) ? 1 : 0);
            ItemProperties.register(CYAN_LEASH.get(), new ResourceLocation("active"), (stack, level, entity, seed) -> LeashItem.isActive(stack, level) ? 1 : 0);
            ItemProperties.register(LIGHT_BLUE_LEASH.get(), new ResourceLocation("active"), (stack, level, entity, seed) -> LeashItem.isActive(stack, level) ? 1 : 0);
            ItemProperties.register(BLUE_LEASH.get(), new ResourceLocation("active"), (stack, level, entity, seed) -> LeashItem.isActive(stack, level) ? 1 : 0);
            ItemProperties.register(PURPLE_LEASH.get(), new ResourceLocation("active"), (stack, level, entity, seed) -> LeashItem.isActive(stack, level) ? 1 : 0);
            ItemProperties.register(MAGENTA_LEASH.get(), new ResourceLocation("active"), (stack, level, entity, seed) -> LeashItem.isActive(stack, level) ? 1 : 0);
            ItemProperties.register(PINK_LEASH.get(), new ResourceLocation("active"), (stack, level, entity, seed) -> LeashItem.isActive(stack, level) ? 1 : 0);
            ItemProperties.register(RAINBOW_LEASH.get(), new ResourceLocation("active"), (stack, level, entity, seed) -> LeashItem.isActive(stack, level) ? 1 : 0);
            ItemProperties.register(CHAIN_LEASH.get(), new ResourceLocation("active"), (stack, level, entity, seed) -> LeashItem.isActive(stack, level) ? 1 : 0);

            ItemProperties.register(SILLY_TAG.get(), new ResourceLocation("active"), (stack, level, entity, seed) -> SillyTagItem.hasTag(stack) ? 1 : 0);
        }

        @SubscribeEvent
        public static void modelRegistryItems(ModelEvent.RegisterAdditional event) {
            for (CollarPart part : CollarPartHandler.COLOR.getCollarParts()) {
                String id = part.getId();
                int i = id.indexOf(":");
                String modId = id.substring(0, i);
                String partId = id.substring(i + 1);
                event.register(new ModelResourceLocation(new ResourceLocation(modId, "collar/color/" + partId), "inventory"));
                event.register(new ModelResourceLocation(new ResourceLocation(modId, "collar/color/" + partId + "_bell"), "inventory"));
                event.register(new ModelResourceLocation(new ResourceLocation(modId, "collar/color/" + partId + "_lock"), "inventory"));
            }
            for (CollarPart part : CollarPartHandler.ACCESSORY.getCollarParts()) {
                String id = part.getId();
                int i = id.indexOf(":");
                String modId = id.substring(0, i);
                String partId = id.substring(i + 1);
                event.register(new ModelResourceLocation(new ResourceLocation(modId, "collar/accessory/" + partId), "inventory"));
            }
            for (CollarPart part : CollarPartHandler.DECORATION.getCollarParts()) {
                String id = part.getId();
                int i = id.indexOf(":");
                String modId = id.substring(0, i);
                String partId = id.substring(i + 1);
                event.register(new ModelResourceLocation(new ResourceLocation(modId, "collar/decoration/" + partId), "inventory"));
            }
        }

        @SubscribeEvent
        public static void modelBakeItems(ModelEvent.ModifyBakingResult event) {
            Map<ResourceLocation, BakedModel> map = event.getModels();

            PurrfectModels.addCollarModel(map, COLLAR.getId());
            for (CollarPart part : CollarPartHandler.COLOR.getCollarParts()) {
                if (part instanceof ColorCollarPart colorCollarPart) {
                    String id = part.getId();
                    int i = id.indexOf(":");
                    String modId = id.substring(0, i);
                    String partId = id.substring(i + 1);
                    BakedModel model = map.get(new ModelResourceLocation(new ResourceLocation(modId, "collar/color/" + partId), "inventory"));
                    colorCollarPart.setModel(model);
                    BakedModel bellModel = map.get(new ModelResourceLocation(new ResourceLocation(modId, "collar/color/" + partId + "_bell"), "inventory"));
                    colorCollarPart.setBellModel(bellModel);
                    BakedModel lockModel = map.get(new ModelResourceLocation(new ResourceLocation(modId, "collar/color/" + partId + "_lock"), "inventory"));
                    colorCollarPart.setLockModel(lockModel);
                }
            }
            for (CollarPart part : CollarPartHandler.ACCESSORY.getCollarParts()) {
                if (part instanceof AccessoryCollarPart accessoryCollarPart) {
                    String id = part.getId();
                    int i = id.indexOf(":");
                    String modId = id.substring(0, i);
                    String partId = id.substring(i + 1);
                    BakedModel model = map.get(new ModelResourceLocation(new ResourceLocation(modId, "collar/accessory/" + partId), "inventory"));
                    accessoryCollarPart.setModel(model);
                }
            }
            for (CollarPart part : CollarPartHandler.DECORATION.getCollarParts()) {
                if (part instanceof DecorationCollarPart decorationCollarPart) {
                    String id = part.getId();
                    int i = id.indexOf(":");
                    String modId = id.substring(0, i);
                    String partId = id.substring(i + 1);
                    BakedModel model = map.get(new ModelResourceLocation(new ResourceLocation(modId, "collar/decoration/" + partId), "inventory"));
                    decorationCollarPart.setModel(model);
                }
            }

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
            FluffyFurModels.addCustomRenderItemModel(map, SILLY_ODDITIES_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, OPTIFINE_FLAG.getId());
            FluffyFurModels.addCustomRenderItemModel(map, SODIUM_FLAG.getId());
        }
    }

    public static void setupItems() {
        SillyTagItem.addTag(Purrfect.MOD_ID+":heterosexual");
        SillyTagItem.addTag(Purrfect.MOD_ID+":lesbian");
        SillyTagItem.addTag(Purrfect.MOD_ID+":gay");
        SillyTagItem.addTag(Purrfect.MOD_ID+":bi");
        SillyTagItem.addTag(Purrfect.MOD_ID+":trans");
        SillyTagItem.addTag(Purrfect.MOD_ID+":enby");
        SillyTagItem.addTag(Purrfect.MOD_ID+":genderfluid");
        SillyTagItem.addTag(Purrfect.MOD_ID+":demiboy");
        SillyTagItem.addTag(Purrfect.MOD_ID+":demigirl");
        SillyTagItem.addTag(Purrfect.MOD_ID+":demigender");
        SillyTagItem.addTag(Purrfect.MOD_ID+":agender");
        SillyTagItem.addTag(Purrfect.MOD_ID+":pan");
        SillyTagItem.addTag(Purrfect.MOD_ID+":omni");
        SillyTagItem.addTag(Purrfect.MOD_ID+":poly");
        SillyTagItem.addTag(Purrfect.MOD_ID+":demisexual");
        SillyTagItem.addTag(Purrfect.MOD_ID+":ace");
        SillyTagItem.addTag(Purrfect.MOD_ID+":aro");
        SillyTagItem.addTag(Purrfect.MOD_ID+":aroace");

        SillyTagItem.addTag(Purrfect.MOD_ID+":boy");
        SillyTagItem.addTag(Purrfect.MOD_ID+":girl");
        SillyTagItem.addTag(Purrfect.MOD_ID+":thing");
        SillyTagItem.addTag(Purrfect.MOD_ID+":good_boy");
        SillyTagItem.addTag(Purrfect.MOD_ID+":good_girl");
        SillyTagItem.addTag(Purrfect.MOD_ID+":good_thing");
        SillyTagItem.addTag(Purrfect.MOD_ID+":bad_boy");
        SillyTagItem.addTag(Purrfect.MOD_ID+":bad_girl");
        SillyTagItem.addTag(Purrfect.MOD_ID+":bad_thing");
        SillyTagItem.addTag(Purrfect.MOD_ID+":top");
        SillyTagItem.addTag(Purrfect.MOD_ID+":bottom");
        SillyTagItem.addTag(Purrfect.MOD_ID+":smol");
        SillyTagItem.addTag(Purrfect.MOD_ID+":big");

        SillyTagItem.addTag(Purrfect.MOD_ID+":creature");
        SillyTagItem.addTag(Purrfect.MOD_ID+":puppy");
        SillyTagItem.addTag(Purrfect.MOD_ID+":kitten");
        SillyTagItem.addTag(Purrfect.MOD_ID+":fish");
        SillyTagItem.addTag(Purrfect.MOD_ID+":fop");
        SillyTagItem.addTag(Purrfect.MOD_ID+":the");
        SillyTagItem.addTag(Purrfect.MOD_ID+":furry");
        SillyTagItem.addTag(Purrfect.MOD_ID+":scalie");

        SillyTagItem.addTag(Purrfect.MOD_ID+":colon_three");
        SillyTagItem.addTag(Purrfect.MOD_ID+":fish_left");
        SillyTagItem.addTag(Purrfect.MOD_ID+":fish_right");
        SillyTagItem.addTag(Purrfect.MOD_ID+":owo");
        SillyTagItem.addTag(Purrfect.MOD_ID+":uwu");

        SillyTagItem.addTag(Purrfect.MOD_ID+":yapper");
        SillyTagItem.addTag(Purrfect.MOD_ID+":goober");
        SillyTagItem.addTag(Purrfect.MOD_ID+":silly");
        SillyTagItem.addTag(Purrfect.MOD_ID+":fluffy");
        SillyTagItem.addTag(Purrfect.MOD_ID+":gender");
        SillyTagItem.addTag(Purrfect.MOD_ID+":zampanio");
        SillyTagItem.addTag(Purrfect.MOD_ID+":implosive");
        SillyTagItem.addTag(Purrfect.MOD_ID+":tetramixin");
        SillyTagItem.addTag(Purrfect.MOD_ID+":greg");
        SillyTagItem.addTag(Purrfect.MOD_ID+":yes");
        SillyTagItem.addTag(Purrfect.MOD_ID+":no");
        SillyTagItem.addTag(Purrfect.MOD_ID+":puppy_brained");

        SillyTagItem.addSpecialTag(Purrfect.MOD_ID+":dev");
    }
}
