package mod.maxbogomol.purrfect.registry.common.item;

import mod.maxbogomol.fluffy_fur.common.creativetab.MultiCreativeTab;
import mod.maxbogomol.fluffy_fur.common.creativetab.SubCreativeTab;
import mod.maxbogomol.fluffy_fur.common.creativetab.SubCreativeTabStack;
import mod.maxbogomol.fluffy_fur.util.ColorUtil;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.integration.common.wizards_reborn.PurrfectWizardsReborn;
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
            () -> MultiCreativeTab.builder().icon(() -> new ItemStack(PurrfectItems.COLLAR.get()))
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

    public static final SubCreativeTab PLUSHIES =
            SubCreativeTab.create().subIcon(() -> new ItemStack(PurrfectItems.BLAHAJ_PLUSH.get()))
                    .title(Component.empty().append(getSillyName()).append(": ").append(Component.translatable("creative_tab.purrfect.sub.plushies")))
                    .subTitle(Component.translatable("creative_tab.purrfect.sub.plushies"))
                    .withSubTabImage(new ResourceLocation(Purrfect.MOD_ID, "textures/gui/purrfect_sub_tab.png"));

    public static final SubCreativeTab COLLARS =
            SubCreativeTab.create().subIcon(() -> new ItemStack(PurrfectItems.COLLAR.get()))
                    .title(Component.empty().append(getSillyName()).append(": ").append(Component.translatable("creative_tab.purrfect.sub.collars")))
                    .subTitle(Component.translatable("creative_tab.purrfect.sub.collars"))
                    .withSubTabImage(new ResourceLocation(Purrfect.MOD_ID, "textures/gui/purrfect_sub_tab.png"));

    public static final SubCreativeTab FLAGS =
            SubCreativeTab.create().subIcon(() -> new ItemStack(PurrfectItems.PRIDE_FLAG.get()))
                    .title(Component.empty().append(getSillyName()).append(": ").append(Component.translatable("creative_tab.purrfect.sub.flags")))
                    .subTitle(Component.translatable("creative_tab.purrfect.sub.flags"))
                    .withSubTabImage(new ResourceLocation(Purrfect.MOD_ID, "textures/gui/purrfect_sub_tab.png"));

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    public static void init() {
        if (PurrfectCreativeTabs.PURRFECT.get() instanceof MultiCreativeTab multiCreativeTab) {
            multiCreativeTab.addSubTab(ALL);
            multiCreativeTab.addSubTab(PHARMACY);
            multiCreativeTab.addSubTab(PLUSHIES);
            multiCreativeTab.addSubTab(COLLARS);
            multiCreativeTab.addSubTab(FLAGS);
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

            event.accept(PurrfectItems.DANDELION_FLOWER_WREATH);
            event.accept(PurrfectItems.POPPY_FLOWER_WREATH);
            event.accept(PurrfectItems.BLUE_ORCHID_FLOWER_WREATH);
            event.accept(PurrfectItems.ALLIUM_FLOWER_WREATH);
            event.accept(PurrfectItems.AZURE_BLUET_FLOWER_WREATH);
            event.accept(PurrfectItems.RED_TULIP_FLOWER_WREATH);
            event.accept(PurrfectItems.ORANGE_TULIP_FLOWER_WREATH);
            event.accept(PurrfectItems.WHITE_TULIP_FLOWER_WREATH);
            event.accept(PurrfectItems.PINK_TULIP_FLOWER_WREATH);
            event.accept(PurrfectItems.OXEYE_DAISY_FLOWER_WREATH);
            event.accept(PurrfectItems.CORNFLOWER_FLOWER_WREATH);
            event.accept(PurrfectItems.LILY_OF_THE_VALLEY_FLOWER_WREATH);
            event.accept(PurrfectItems.PINK_PETALS_FLOWER_WREATH);
            event.accept(PurrfectItems.SUNFLOWER_FLOWER_WREATH);
            event.accept(PurrfectItems.LILAC_FLOWER_WREATH);
            event.accept(PurrfectItems.ROSE_BUSH_FLOWER_WREATH);
            event.accept(PurrfectItems.PEONY_FLOWER_WREATH);
            event.accept(PurrfectItems.DEAD_BUSH_FLOWER_WREATH);
            event.accept(PurrfectItems.WITHER_ROSE_FLOWER_WREATH);
            event.accept(PurrfectItems.TORCHFLOWER_FLOWER_WREATH);
            event.accept(PurrfectItems.PITCHER_PLANT_FLOWER_WREATH);

            if (PurrfectWizardsReborn.isLoaded()) {
                event.accept(PurrfectWizardsReborn.ItemsLoadedOnly.PETALS_OF_INNOCENCE_FLOWER_WREATH);
            }

            //COLLARS
            addInSub(event, COLLARS, PurrfectItems.COLLAR);

            event.accept(PurrfectItems.LEASH);
            event.accept(PurrfectItems.WHITE_LEASH);
            event.accept(PurrfectItems.LIGHT_GRAY_LEASH);
            event.accept(PurrfectItems.GRAY_LEASH);
            event.accept(PurrfectItems.BLACK_LEASH);
            event.accept(PurrfectItems.BROWN_LEASH);
            event.accept(PurrfectItems.RED_LEASH);
            event.accept(PurrfectItems.ORANGE_LEASH);
            event.accept(PurrfectItems.YELLOW_LEASH);
            event.accept(PurrfectItems.LIME_LEASH);
            event.accept(PurrfectItems.GREEN_LEASH);
            event.accept(PurrfectItems.CYAN_LEASH);
            event.accept(PurrfectItems.LIGHT_BLUE_LEASH);
            event.accept(PurrfectItems.BLUE_LEASH);
            event.accept(PurrfectItems.PURPLE_LEASH);
            event.accept(PurrfectItems.MAGENTA_LEASH);
            event.accept(PurrfectItems.PINK_LEASH);
            event.accept(PurrfectItems.RAINBOW_LEASH);
            event.accept(PurrfectItems.CHAIN_LEASH);

            event.accept(PurrfectItems.WHITE_YARN);
            event.accept(PurrfectItems.LIGHT_GRAY_YARN);
            event.accept(PurrfectItems.GRAY_YARN);
            event.accept(PurrfectItems.BLACK_YARN);
            event.accept(PurrfectItems.BROWN_YARN);
            event.accept(PurrfectItems.RED_YARN);
            event.accept(PurrfectItems.ORANGE_YARN);
            event.accept(PurrfectItems.YELLOW_YARN);
            event.accept(PurrfectItems.LIME_YARN);
            event.accept(PurrfectItems.GREEN_YARN);
            event.accept(PurrfectItems.CYAN_YARN);
            event.accept(PurrfectItems.LIGHT_BLUE_YARN);
            event.accept(PurrfectItems.BLUE_YARN);
            event.accept(PurrfectItems.PURPLE_YARN);
            event.accept(PurrfectItems.MAGENTA_YARN);
            event.accept(PurrfectItems.PINK_YARN);
            event.accept(PurrfectItems.RAINBOW_YARN);

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

            addInSub(event, FLAGS, PurrfectItems.OPTIFINE_BLOCK);
            addInSub(event, FLAGS, PurrfectItems.OPTIFINE_STAIRS);
            addInSub(event, FLAGS, PurrfectItems.OPTIFINE_SLAB);

            addInSub(event, FLAGS, PurrfectItems.SODIUM_BLOCK);
            addInSub(event, FLAGS, PurrfectItems.SODIUM_STAIRS);
            addInSub(event, FLAGS, PurrfectItems.SODIUM_SLAB);
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