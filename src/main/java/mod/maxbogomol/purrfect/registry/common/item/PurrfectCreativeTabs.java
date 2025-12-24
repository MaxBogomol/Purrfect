package mod.maxbogomol.purrfect.registry.common.item;

import mod.maxbogomol.fluffy_fur.common.creativetab.MultiCreativeTab;
import mod.maxbogomol.fluffy_fur.common.creativetab.SubCreativeTab;
import mod.maxbogomol.fluffy_fur.common.creativetab.SubCreativeTabStack;
import mod.maxbogomol.fluffy_fur.util.ColorUtil;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.common.item.equipment.SillyTagItem;
import mod.maxbogomol.purrfect.common.item.equipment.curio.CollarItem;
import mod.maxbogomol.purrfect.integration.common.wizards_reborn.PurrfectWizardsReborn;
import mod.maxbogomol.purrfect.registry.common.PurrfectCollarParts;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;
import java.util.Random;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Purrfect.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PurrfectCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Purrfect.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PURRFECT = CREATIVE_MODE_TABS.register("tab",
            () -> MultiCreativeTab.builder().icon(() -> {
                        ItemStack collar = new ItemStack(PurrfectItems.COLLAR.get());
                        CollarItem.setAccessory(collar, PurrfectCollarParts.GOLDEN_BELL);
                        return collar;
                    })
                    .title(getSillyName())
                    .withLabelColor(ColorUtil.packColor(255, 55, 48, 54))
                    .withBackgroundLocation(new ResourceLocation(Purrfect.MOD_ID, "textures/gui/purrfect_item_tab.png"))
                    .withTabsImage(new ResourceLocation(Purrfect.MOD_ID, "textures/gui/purrfect_tabs.png"))
                    .withSubArrowsImage(new ResourceLocation(Purrfect.MOD_ID, "textures/gui/purrfect_sub_arrows.png"))
                    .multiBuild());

    public static final SubCreativeTabStack ALL =
            SubCreativeTabStack.create()
                    .subTitle(Component.translatable("creative_tab.purrfect"))
                    .withSubTabImage(new ResourceLocation(Purrfect.MOD_ID, "textures/gui/purrfect_sub_tab.png"));

    public static final SubCreativeTab PHARMACY =
            SubCreativeTab.create().subIcon(() -> new ItemStack(PurrfectItems.PHARMACIST_TABLE.get()))
                    .title(Component.empty().append(getSillyName()).append(": ").append(Component.translatable("creative_tab.purrfect.sub.pharmacy")))
                    .subTitle(Component.translatable("creative_tab.purrfect.sub.pharmacy"))
                    .withSubTabImage(new ResourceLocation(Purrfect.MOD_ID, "textures/gui/purrfect_sub_tab.png"));

    public static final SubCreativeTabStack THINGS =
            SubCreativeTabStack.create().subIcon(() -> new ItemStack(PurrfectItems.PHARMACIST_TABLE.get()))
                    .title(Component.empty().append(getSillyName()).append(": ").append(Component.translatable("creative_tab.purrfect.sub.things")))
                    .subTitle(Component.translatable("creative_tab.purrfect.sub.things"))
                    .withSubTabImage(new ResourceLocation(Purrfect.MOD_ID, "textures/gui/purrfect_sub_tab.png"));

    public static final SubCreativeTab PLUSHIES =
            SubCreativeTab.create().subIcon(() -> new ItemStack(PurrfectItems.BLAHAJ_PLUSH.get()))
                    .title(Component.empty().append(getSillyName()).append(": ").append(Component.translatable("creative_tab.purrfect.sub.plushies")))
                    .subTitle(Component.translatable("creative_tab.purrfect.sub.plushies"))
                    .withSubTabImage(new ResourceLocation(Purrfect.MOD_ID, "textures/gui/purrfect_sub_tab.png"));

    public static final SubCreativeTab FLOWER_WREATHS =
            SubCreativeTab.create().subIcon(() -> new ItemStack(PurrfectItems.DANDELION_FLOWER_WREATH.get()))
                    .title(Component.empty().append(getSillyName()).append(": ").append(Component.translatable("creative_tab.purrfect.sub.flower_wreaths")))
                    .subTitle(Component.translatable("creative_tab.purrfect.sub.flower_wreaths"))
                    .withSubTabImage(new ResourceLocation(Purrfect.MOD_ID, "textures/gui/purrfect_sub_tab.png"));

    public static final SubCreativeTab COLLAR = SubCreativeTab.create();

    public static final SubCreativeTab COLLARS =
            SubCreativeTab.create().subIcon(() -> {
                        ItemStack collar = new ItemStack(PurrfectItems.COLLAR.get());
                        CollarItem.setColor(collar, PurrfectCollarParts.PINK);
                        CollarItem.setAccessory(collar, PurrfectCollarParts.GOLDEN_BELL);
                        return collar;
                    })
                    .title(Component.empty().append(getSillyName()).append(": ").append(Component.translatable("creative_tab.purrfect.sub.collars")))
                    .subTitle(Component.translatable("creative_tab.purrfect.sub.collars"))
                    .withSubTabImage(new ResourceLocation(Purrfect.MOD_ID, "textures/gui/purrfect_sub_tab.png"));

    public static final SubCreativeTab FURRY_THINGS =
            SubCreativeTab.create().subIcon(() -> new ItemStack(PurrfectItems.PINK_LEASH.get()))
                    .title(Component.empty().append(getSillyName()).append(": ").append(Component.translatable("creative_tab.purrfect.sub.furry_things")))
                    .subTitle(Component.translatable("creative_tab.purrfect.sub.furry_things"))
                    .withSubTabImage(new ResourceLocation(Purrfect.MOD_ID, "textures/gui/purrfect_sub_tab.png"));

    public static final SubCreativeTab TAGS =
            SubCreativeTab.create().subIcon(() -> new ItemStack(PurrfectItems.SILLY_TAG.get()))
                    .title(Component.empty().append(getSillyName()).append(": ").append(Component.translatable("creative_tab.purrfect.sub.tags")))
                    .subTitle(Component.translatable("creative_tab.purrfect.sub.tags"))
                    .withSubTabImage(new ResourceLocation(Purrfect.MOD_ID, "textures/gui/purrfect_sub_tab.png"));

    public static final SubCreativeTab FLAGS =
            SubCreativeTab.create().subIcon(() -> new ItemStack(PurrfectItems.PRIDE_FLAG.get()))
                    .title(Component.empty().append(getSillyName()).append(": ").append(Component.translatable("creative_tab.purrfect.sub.flags")))
                    .subTitle(Component.translatable("creative_tab.purrfect.sub.flags"))
                    .withSubTabImage(new ResourceLocation(Purrfect.MOD_ID, "textures/gui/purrfect_sub_tab.png"));

    public static final SubCreativeTab GRAPHICS =
            SubCreativeTab.create().subIcon(() -> new ItemStack(PurrfectItems.OPTIFINE_BLOCK.get()))
                    .title(Component.empty().append(getSillyName()).append(": ").append(Component.translatable("creative_tab.purrfect.sub.graphics")))
                    .subTitle(Component.translatable("creative_tab.purrfect.sub.graphics"))
                    .withSubTabImage(new ResourceLocation(Purrfect.MOD_ID, "textures/gui/purrfect_sub_tab.png"));

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    public static void init() {
        if (PurrfectCreativeTabs.PURRFECT.get() instanceof MultiCreativeTab multiCreativeTab) {
            multiCreativeTab.addSubTab(ALL);
            multiCreativeTab.addSubTab(PHARMACY);
            multiCreativeTab.addSubTab(THINGS);
            multiCreativeTab.addSubTab(PLUSHIES);
            multiCreativeTab.addSubTab(FLOWER_WREATHS);
            multiCreativeTab.addSubTab(COLLARS);
            multiCreativeTab.addSubTab(FURRY_THINGS);
            multiCreativeTab.addSubTab(TAGS);
            multiCreativeTab.addSubTab(FLAGS);
            multiCreativeTab.addSubTab(GRAPHICS);

            THINGS.addSubTab(PLUSHIES).addSubTab(FLOWER_WREATHS).addSubTab(COLLAR).addSubTab(FURRY_THINGS).addSubTab(FLAGS).addSubTab(GRAPHICS);
        }
    }

    public static Component getSillyName() {
        Random random = new Random();
        int i = random.nextInt(0, 6);
        Component silly = Component.translatable("creative_tab.purrfect.silly." + i);
        return Component.translatable("creative_tab.purrfect").append(" ").append(silly);
    }

    public static void addCreativeTabContent(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == PurrfectCreativeTabs.PURRFECT.getKey()) {
            //PHARMACY
            addInSub(event, PHARMACY, PurrfectItems.PHARMACIST_TABLE);

            addInSub(event, PHARMACY, PurrfectItems.PHARMACY_VIAL);
            addInSub(event, PHARMACY, PurrfectItems.PHARMACY_VIAL_INK);
            addInSub(event, PHARMACY, PurrfectItems.PHARMACY_VIAL_PINK_FOX);
            addInSub(event, PHARMACY, PurrfectItems.PHARMACY_VIAL_GOATED);
            addInSub(event, PHARMACY, PurrfectItems.PHARMACY_VIAL_CRYSTAL_RINGING);
            addInSub(event, PHARMACY, PurrfectItems.PHARMACY_VIAL_RAINBOW_SPARK);
            addInSub(event, PHARMACY, PurrfectItems.PHARMACY_VIAL_SLIMY_SLUG);

            //PLUSHIES
            addInSub(event, PLUSHIES, PurrfectItems.BLAHAJ_PLUSH);
            addInSub(event, PLUSHIES, PurrfectItems.PINK_BLAHAJ_PLUSH);
            addInSub(event, PLUSHIES, PurrfectItems.SHRIMP_PLUSH);
            addInSub(event, PLUSHIES, PurrfectItems.FISH_PLUSH);
            addInSub(event, PLUSHIES, PurrfectItems.CARROT_PLUSH);

            //FLOWER_WREATHS
            addInSub(event, FLOWER_WREATHS, PurrfectItems.DANDELION_FLOWER_WREATH);
            addInSub(event, FLOWER_WREATHS, PurrfectItems.POPPY_FLOWER_WREATH);
            addInSub(event, FLOWER_WREATHS, PurrfectItems.BLUE_ORCHID_FLOWER_WREATH);
            addInSub(event, FLOWER_WREATHS, PurrfectItems.ALLIUM_FLOWER_WREATH);
            addInSub(event, FLOWER_WREATHS, PurrfectItems.AZURE_BLUET_FLOWER_WREATH);
            addInSub(event, FLOWER_WREATHS, PurrfectItems.RED_TULIP_FLOWER_WREATH);
            addInSub(event, FLOWER_WREATHS, PurrfectItems.ORANGE_TULIP_FLOWER_WREATH);
            addInSub(event, FLOWER_WREATHS, PurrfectItems.WHITE_TULIP_FLOWER_WREATH);
            addInSub(event, FLOWER_WREATHS, PurrfectItems.PINK_TULIP_FLOWER_WREATH);
            addInSub(event, FLOWER_WREATHS, PurrfectItems.OXEYE_DAISY_FLOWER_WREATH);
            addInSub(event, FLOWER_WREATHS, PurrfectItems.CORNFLOWER_FLOWER_WREATH);
            addInSub(event, FLOWER_WREATHS, PurrfectItems.LILY_OF_THE_VALLEY_FLOWER_WREATH);
            addInSub(event, FLOWER_WREATHS, PurrfectItems.PINK_PETALS_FLOWER_WREATH);
            addInSub(event, FLOWER_WREATHS, PurrfectItems.SUNFLOWER_FLOWER_WREATH);
            addInSub(event, FLOWER_WREATHS, PurrfectItems.LILAC_FLOWER_WREATH);
            addInSub(event, FLOWER_WREATHS, PurrfectItems.ROSE_BUSH_FLOWER_WREATH);
            addInSub(event, FLOWER_WREATHS, PurrfectItems.PEONY_FLOWER_WREATH);
            addInSub(event, FLOWER_WREATHS, PurrfectItems.DEAD_BUSH_FLOWER_WREATH);
            addInSub(event, FLOWER_WREATHS, PurrfectItems.WITHER_ROSE_FLOWER_WREATH);
            addInSub(event, FLOWER_WREATHS, PurrfectItems.TORCHFLOWER_FLOWER_WREATH);
            addInSub(event, FLOWER_WREATHS, PurrfectItems.PITCHER_PLANT_FLOWER_WREATH);

            if (PurrfectWizardsReborn.isLoaded()) {
                addInSub(event, FLOWER_WREATHS, PurrfectWizardsReborn.ItemsLoadedOnly.PETALS_OF_INNOCENCE_FLOWER_WREATH);
            }

            //COLLARS
            addInSub(event, COLLAR, PurrfectItems.COLLAR);
            addInSub(COLLARS, CollarItem.getAllItems(PurrfectItems.COLLAR.get()));

            //FURRY_THINGS
            addInSub(event, FURRY_THINGS, PurrfectItems.LEASH);
            addInSub(event, FURRY_THINGS, PurrfectItems.WHITE_LEASH);
            addInSub(event, FURRY_THINGS, PurrfectItems.LIGHT_GRAY_LEASH);
            addInSub(event, FURRY_THINGS, PurrfectItems.GRAY_LEASH);
            addInSub(event, FURRY_THINGS, PurrfectItems.BLACK_LEASH);
            addInSub(event, FURRY_THINGS, PurrfectItems.BROWN_LEASH);
            addInSub(event, FURRY_THINGS, PurrfectItems.RED_LEASH);
            addInSub(event, FURRY_THINGS, PurrfectItems.ORANGE_LEASH);
            addInSub(event, FURRY_THINGS, PurrfectItems.YELLOW_LEASH);
            addInSub(event, FURRY_THINGS, PurrfectItems.LIME_LEASH);
            addInSub(event, FURRY_THINGS, PurrfectItems.GREEN_LEASH);
            addInSub(event, FURRY_THINGS, PurrfectItems.CYAN_LEASH);
            addInSub(event, FURRY_THINGS, PurrfectItems.LIGHT_BLUE_LEASH);
            addInSub(event, FURRY_THINGS, PurrfectItems.BLUE_LEASH);
            addInSub(event, FURRY_THINGS, PurrfectItems.PURPLE_LEASH);
            addInSub(event, FURRY_THINGS, PurrfectItems.MAGENTA_LEASH);
            addInSub(event, FURRY_THINGS, PurrfectItems.PINK_LEASH);
            addInSub(event, FURRY_THINGS, PurrfectItems.RAINBOW_LEASH);
            addInSub(event, FURRY_THINGS, PurrfectItems.CHAIN_LEASH);

            addInSub(event, FURRY_THINGS, PurrfectItems.WHITE_YARN);
            addInSub(event, FURRY_THINGS, PurrfectItems.LIGHT_GRAY_YARN);
            addInSub(event, FURRY_THINGS, PurrfectItems.GRAY_YARN);
            addInSub(event, FURRY_THINGS, PurrfectItems.BLACK_YARN);
            addInSub(event, FURRY_THINGS, PurrfectItems.BROWN_YARN);
            addInSub(event, FURRY_THINGS, PurrfectItems.RED_YARN);
            addInSub(event, FURRY_THINGS, PurrfectItems.ORANGE_YARN);
            addInSub(event, FURRY_THINGS, PurrfectItems.YELLOW_YARN);
            addInSub(event, FURRY_THINGS, PurrfectItems.LIME_YARN);
            addInSub(event, FURRY_THINGS, PurrfectItems.GREEN_YARN);
            addInSub(event, FURRY_THINGS, PurrfectItems.CYAN_YARN);
            addInSub(event, FURRY_THINGS, PurrfectItems.LIGHT_BLUE_YARN);
            addInSub(event, FURRY_THINGS, PurrfectItems.BLUE_YARN);
            addInSub(event, FURRY_THINGS, PurrfectItems.PURPLE_YARN);
            addInSub(event, FURRY_THINGS, PurrfectItems.MAGENTA_YARN);
            addInSub(event, FURRY_THINGS, PurrfectItems.PINK_YARN);
            addInSub(event, FURRY_THINGS, PurrfectItems.RAINBOW_YARN);

            addInSub(event, FURRY_THINGS, PurrfectItems.COPPER_SHIPKEY);
            addInSub(event, FURRY_THINGS, PurrfectItems.IRON_SHIPKEY);
            addInSub(event, FURRY_THINGS, PurrfectItems.GOLDEN_SHIPKEY);
            addInSub(event, FURRY_THINGS, PurrfectItems.DIAMOND_SHIPKEY);
            addInSub(event, FURRY_THINGS, PurrfectItems.NETHERITE_SHIPKEY);

            //TAGS
            addInSub(event, TAGS, PurrfectItems.SILLY_TAG);
            addInSub(event, TAGS, SillyTagItem.getAllItems(PurrfectItems.SILLY_TAG.get()));

            //FLAGS
            addInSub(event, FLAGS, PurrfectItems.FLAGPOLE);
            addInSub(event, FLAGS, PurrfectItems.WHITE_FLAG);
            addInSub(event, FLAGS, PurrfectItems.LIGHT_GRAY_FLAG);
            addInSub(event, FLAGS, PurrfectItems.GRAY_FLAG);
            addInSub(event, FLAGS, PurrfectItems.BLACK_FLAG);
            addInSub(event, FLAGS, PurrfectItems.BROWN_FLAG);
            addInSub(event, FLAGS, PurrfectItems.RED_FLAG);
            addInSub(event, FLAGS, PurrfectItems.ORANGE_FLAG);
            addInSub(event, FLAGS, PurrfectItems.YELLOW_FLAG);
            addInSub(event, FLAGS, PurrfectItems.LIME_FLAG);
            addInSub(event, FLAGS, PurrfectItems.GREEN_FLAG);
            addInSub(event, FLAGS, PurrfectItems.CYAN_FLAG);
            addInSub(event, FLAGS, PurrfectItems.LIGHT_BLUE_FLAG);
            addInSub(event, FLAGS, PurrfectItems.BLUE_FLAG);
            addInSub(event, FLAGS, PurrfectItems.PURPLE_FLAG);
            addInSub(event, FLAGS, PurrfectItems.MAGENTA_FLAG);
            addInSub(event, FLAGS, PurrfectItems.PINK_FLAG);
            addInSub(event, FLAGS, PurrfectItems.RAINBOW_FLAG);
            addInSub(event, FLAGS, PurrfectItems.HETEROSEXUAL_FLAG);
            addInSub(event, FLAGS, PurrfectItems.PRIDE_FLAG);
            addInSub(event, FLAGS, PurrfectItems.LESBIAN_FLAG);
            addInSub(event, FLAGS, PurrfectItems.GAY_FLAG);
            addInSub(event, FLAGS, PurrfectItems.BI_FLAG);
            addInSub(event, FLAGS, PurrfectItems.TRANS_FLAG);
            addInSub(event, FLAGS, PurrfectItems.ENBY_FLAG);
            addInSub(event, FLAGS, PurrfectItems.GENDERFLUID_FLAG);
            addInSub(event, FLAGS, PurrfectItems.DEMIBOY_FLAG);
            addInSub(event, FLAGS, PurrfectItems.DEMIGIRL_FLAG);
            addInSub(event, FLAGS, PurrfectItems.DEMIGENDER_FLAG);
            addInSub(event, FLAGS, PurrfectItems.AGENDER_FLAG);
            addInSub(event, FLAGS, PurrfectItems.PAN_FLAG);
            addInSub(event, FLAGS, PurrfectItems.OMNI_FLAG);
            addInSub(event, FLAGS, PurrfectItems.POLY_FLAG);
            addInSub(event, FLAGS, PurrfectItems.DEMISEXUAL_FLAG);
            addInSub(event, FLAGS, PurrfectItems.ACE_FLAG);
            addInSub(event, FLAGS, PurrfectItems.ARO_FLAG);
            addInSub(event, FLAGS, PurrfectItems.AROACE_FLAG);
            addInSub(event, FLAGS, PurrfectItems.KVASSSEXUAL_FLAG);
            addInSub(event, FLAGS, PurrfectItems.BEERSEXUAL_FLAG);
            addInSub(event, FLAGS, PurrfectItems.WIZARDS_REBORN_FLAG);
            addInSub(event, FLAGS, PurrfectItems.FLUFFY_FUR_FLAG);
            addInSub(event, FLAGS, PurrfectItems.SILLY_ODDITIES_FLAG);
            addInSub(event, FLAGS, PurrfectItems.OPTIFINE_FLAG);
            addInSub(event, FLAGS, PurrfectItems.SODIUM_FLAG);

            //GRAPHICS
            addInSub(event, GRAPHICS, PurrfectItems.OPTIFINE_BLOCK);
            addInSub(event, GRAPHICS, PurrfectItems.OPTIFINE_STAIRS);
            addInSub(event, GRAPHICS, PurrfectItems.OPTIFINE_SLAB);

            addInSub(event, GRAPHICS, PurrfectItems.SODIUM_BLOCK);
            addInSub(event, GRAPHICS, PurrfectItems.SODIUM_STAIRS);
            addInSub(event, GRAPHICS, PurrfectItems.SODIUM_SLAB);
        }
    }

    public static void addInSub(BuildCreativeModeTabContentsEvent event, SubCreativeTab subTab, Supplier<? extends ItemLike> item) {
        event.accept(item);
        subTab.addDisplayItem(item.get());
    }

    public static void addInSub(BuildCreativeModeTabContentsEvent event, SubCreativeTab subTab, ItemStack item) {
        event.accept(item);
        subTab.addDisplayItem(item);
    }

    public static void addInSub(BuildCreativeModeTabContentsEvent event, SubCreativeTab subTab, Collection<ItemStack> items) {
        event.acceptAll(items);
        subTab.addDisplayItems(items);
    }

    public static void addInSub(SubCreativeTab subTab, Supplier<? extends ItemLike> item) {
        subTab.addDisplayItem(item.get());
    }

    public static void addInSub(SubCreativeTab subTab, ItemStack item) {
        subTab.addDisplayItem(item);
    }

    public static void addInSub(SubCreativeTab subTab, Collection<ItemStack> items) {
        subTab.addDisplayItems(items);
    }
}