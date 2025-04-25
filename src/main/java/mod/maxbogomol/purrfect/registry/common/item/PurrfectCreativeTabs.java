package mod.maxbogomol.purrfect.registry.common.item;

import mod.maxbogomol.fluffy_fur.util.ColorUtil;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.integration.common.wizards_reborn.PurrfectWizardsReborn;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Random;

@Mod.EventBusSubscriber(modid = Purrfect.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PurrfectCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Purrfect.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PURRFECT = CREATIVE_MODE_TABS.register("tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(PurrfectItems.GOLDEN_BELL_COLLAR.get()))
                    .title(getSillyName())
                    .withLabelColor(ColorUtil.packColor(255, 55, 48, 54))
                    .withBackgroundLocation(new ResourceLocation(Purrfect.MOD_ID, "textures/gui/purrfect_item_tab.png"))
                    .withTabsImage(new ResourceLocation(Purrfect.MOD_ID, "textures/gui/purrfect_tabs.png"))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    public static Component getSillyName() {
        Random random = new Random();
        int i = random.nextInt(0, 6);
        Component silly = Component.translatable("creative_tab.purrfect.silly." + i);
        return Component.translatable("creative_tab.purrfect").append(" ").append(silly);
    }

    public static void addCreativeTabContent(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == PurrfectCreativeTabs.PURRFECT.getKey()) {
            event.accept(PurrfectItems.PHARMACIST_TABLE);

            event.accept(PurrfectItems.PHARMACY_VIAL);
            event.accept(PurrfectItems.PHARMACY_VIAL_INK);
            event.accept(PurrfectItems.PHARMACY_VIAL_PINK_FOX);
            event.accept(PurrfectItems.PHARMACY_VIAL_GOATED);
            event.accept(PurrfectItems.PHARMACY_VIAL_CRYSTAL_RINGING);
            event.accept(PurrfectItems.PHARMACY_VIAL_RAINBOW_SPARK);
            event.accept(PurrfectItems.PHARMACY_VIAL_SLIMY_SLUG);

            event.accept(PurrfectItems.BLAHAJ_PLUSH);
            event.accept(PurrfectItems.PINK_BLAHAJ_PLUSH);

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

            event.accept(PurrfectItems.COLLAR);
            event.accept(PurrfectItems.WHITE_COLLAR);
            event.accept(PurrfectItems.LIGHT_GRAY_COLLAR);
            event.accept(PurrfectItems.GRAY_COLLAR);
            event.accept(PurrfectItems.BLACK_COLLAR);
            event.accept(PurrfectItems.BROWN_COLLAR);
            event.accept(PurrfectItems.RED_COLLAR);
            event.accept(PurrfectItems.ORANGE_COLLAR);
            event.accept(PurrfectItems.YELLOW_COLLAR);
            event.accept(PurrfectItems.LIME_COLLAR);
            event.accept(PurrfectItems.GREEN_COLLAR);
            event.accept(PurrfectItems.CYAN_COLLAR);
            event.accept(PurrfectItems.LIGHT_BLUE_COLLAR);
            event.accept(PurrfectItems.BLUE_COLLAR);
            event.accept(PurrfectItems.PURPLE_COLLAR);
            event.accept(PurrfectItems.MAGENTA_COLLAR);
            event.accept(PurrfectItems.PINK_COLLAR);
            event.accept(PurrfectItems.RAINBOW_COLLAR);

            event.accept(PurrfectItems.IRON_BELL_COLLAR);
            event.accept(PurrfectItems.WHITE_IRON_BELL_COLLAR);
            event.accept(PurrfectItems.LIGHT_GRAY_IRON_BELL_COLLAR);
            event.accept(PurrfectItems.GRAY_IRON_BELL_COLLAR);
            event.accept(PurrfectItems.BLACK_IRON_BELL_COLLAR);
            event.accept(PurrfectItems.BROWN_IRON_BELL_COLLAR);
            event.accept(PurrfectItems.RED_IRON_BELL_COLLAR);
            event.accept(PurrfectItems.ORANGE_IRON_BELL_COLLAR);
            event.accept(PurrfectItems.YELLOW_IRON_BELL_COLLAR);
            event.accept(PurrfectItems.LIME_IRON_BELL_COLLAR);
            event.accept(PurrfectItems.GREEN_IRON_BELL_COLLAR);
            event.accept(PurrfectItems.CYAN_IRON_BELL_COLLAR);
            event.accept(PurrfectItems.LIGHT_BLUE_IRON_BELL_COLLAR);
            event.accept(PurrfectItems.BLUE_IRON_BELL_COLLAR);
            event.accept(PurrfectItems.PURPLE_IRON_BELL_COLLAR);
            event.accept(PurrfectItems.MAGENTA_IRON_BELL_COLLAR);
            event.accept(PurrfectItems.PINK_IRON_BELL_COLLAR);
            event.accept(PurrfectItems.RAINBOW_IRON_BELL_COLLAR);

            event.accept(PurrfectItems.GOLDEN_BELL_COLLAR);
            event.accept(PurrfectItems.WHITE_GOLDEN_BELL_COLLAR);
            event.accept(PurrfectItems.LIGHT_GRAY_GOLDEN_BELL_COLLAR);
            event.accept(PurrfectItems.GRAY_GOLDEN_BELL_COLLAR);
            event.accept(PurrfectItems.BLACK_GOLDEN_BELL_COLLAR);
            event.accept(PurrfectItems.BROWN_GOLDEN_BELL_COLLAR);
            event.accept(PurrfectItems.RED_GOLDEN_BELL_COLLAR);
            event.accept(PurrfectItems.ORANGE_GOLDEN_BELL_COLLAR);
            event.accept(PurrfectItems.YELLOW_GOLDEN_BELL_COLLAR);
            event.accept(PurrfectItems.LIME_GOLDEN_BELL_COLLAR);
            event.accept(PurrfectItems.GREEN_GOLDEN_BELL_COLLAR);
            event.accept(PurrfectItems.CYAN_GOLDEN_BELL_COLLAR);
            event.accept(PurrfectItems.LIGHT_BLUE_GOLDEN_BELL_COLLAR);
            event.accept(PurrfectItems.BLUE_GOLDEN_BELL_COLLAR);
            event.accept(PurrfectItems.PURPLE_GOLDEN_BELL_COLLAR);
            event.accept(PurrfectItems.MAGENTA_GOLDEN_BELL_COLLAR);
            event.accept(PurrfectItems.PINK_GOLDEN_BELL_COLLAR);
            event.accept(PurrfectItems.RAINBOW_GOLDEN_BELL_COLLAR);

            event.accept(PurrfectItems.SPIKED_COLLAR);
            event.accept(PurrfectItems.WHITE_SPIKED_COLLAR);
            event.accept(PurrfectItems.LIGHT_GRAY_SPIKED_COLLAR);
            event.accept(PurrfectItems.GRAY_SPIKED_COLLAR);
            event.accept(PurrfectItems.BLACK_SPIKED_COLLAR);
            event.accept(PurrfectItems.BROWN_SPIKED_COLLAR);
            event.accept(PurrfectItems.RED_SPIKED_COLLAR);
            event.accept(PurrfectItems.ORANGE_SPIKED_COLLAR);
            event.accept(PurrfectItems.YELLOW_SPIKED_COLLAR);
            event.accept(PurrfectItems.LIME_SPIKED_COLLAR);
            event.accept(PurrfectItems.GREEN_SPIKED_COLLAR);
            event.accept(PurrfectItems.CYAN_SPIKED_COLLAR);
            event.accept(PurrfectItems.LIGHT_BLUE_SPIKED_COLLAR);
            event.accept(PurrfectItems.BLUE_SPIKED_COLLAR);
            event.accept(PurrfectItems.PURPLE_SPIKED_COLLAR);
            event.accept(PurrfectItems.MAGENTA_SPIKED_COLLAR);
            event.accept(PurrfectItems.PINK_SPIKED_COLLAR);
            event.accept(PurrfectItems.RAINBOW_SPIKED_COLLAR);

            event.accept(PurrfectItems.IRON_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.WHITE_IRON_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.LIGHT_GRAY_IRON_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.GRAY_IRON_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.BLACK_IRON_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.BROWN_IRON_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.RED_IRON_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.ORANGE_IRON_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.YELLOW_IRON_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.LIME_IRON_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.GREEN_IRON_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.CYAN_IRON_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.LIGHT_BLUE_IRON_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.BLUE_IRON_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.PURPLE_IRON_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.MAGENTA_IRON_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.PINK_IRON_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.RAINBOW_IRON_BELL_SPIKED_COLLAR);

            event.accept(PurrfectItems.GOLDEN_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.WHITE_GOLDEN_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.LIGHT_GRAY_GOLDEN_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.GRAY_GOLDEN_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.BLACK_GOLDEN_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.BROWN_GOLDEN_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.RED_GOLDEN_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.ORANGE_GOLDEN_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.YELLOW_GOLDEN_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.LIME_GOLDEN_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.GREEN_GOLDEN_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.CYAN_GOLDEN_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.LIGHT_BLUE_GOLDEN_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.BLUE_GOLDEN_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.PURPLE_GOLDEN_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.MAGENTA_GOLDEN_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.PINK_GOLDEN_BELL_SPIKED_COLLAR);
            event.accept(PurrfectItems.RAINBOW_GOLDEN_BELL_SPIKED_COLLAR);

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

            event.accept(PurrfectItems.FLAGPOLE);
            event.accept(PurrfectItems.WHITE_FLAG);
            event.accept(PurrfectItems.LIGHT_GRAY_FLAG);
            event.accept(PurrfectItems.GRAY_FLAG);
            event.accept(PurrfectItems.BLACK_FLAG);
            event.accept(PurrfectItems.BROWN_FLAG);
            event.accept(PurrfectItems.RED_FLAG);
            event.accept(PurrfectItems.ORANGE_FLAG);
            event.accept(PurrfectItems.YELLOW_FLAG);
            event.accept(PurrfectItems.LIME_FLAG);
            event.accept(PurrfectItems.GREEN_FLAG);
            event.accept(PurrfectItems.CYAN_FLAG);
            event.accept(PurrfectItems.LIGHT_BLUE_FLAG);
            event.accept(PurrfectItems.BLUE_FLAG);
            event.accept(PurrfectItems.PURPLE_FLAG);
            event.accept(PurrfectItems.MAGENTA_FLAG);
            event.accept(PurrfectItems.PINK_FLAG);
            event.accept(PurrfectItems.RAINBOW_FLAG);
            event.accept(PurrfectItems.HETEROSEXUAL_FLAG);
            event.accept(PurrfectItems.PRIDE_FLAG);
            event.accept(PurrfectItems.LESBIAN_FLAG);
            event.accept(PurrfectItems.GAY_FLAG);
            event.accept(PurrfectItems.BI_FLAG);
            event.accept(PurrfectItems.TRANS_FLAG);
            event.accept(PurrfectItems.ENBY_FLAG);
            event.accept(PurrfectItems.GENDERFLUID_FLAG);
            event.accept(PurrfectItems.DEMIBOY_FLAG);
            event.accept(PurrfectItems.DEMIGIRL_FLAG);
            event.accept(PurrfectItems.DEMIGENDER_FLAG);
            event.accept(PurrfectItems.AGENDER_FLAG);
            event.accept(PurrfectItems.PAN_FLAG);
            event.accept(PurrfectItems.OMNI_FLAG);
            event.accept(PurrfectItems.POLY_FLAG);
            event.accept(PurrfectItems.DEMISEXUAL_FLAG);
            event.accept(PurrfectItems.ACE_FLAG);
            event.accept(PurrfectItems.ARO_FLAG);
            event.accept(PurrfectItems.AROACE_FLAG);
            event.accept(PurrfectItems.KVASSSEXUAL_FLAG);
            event.accept(PurrfectItems.BEERSEXUAL_FLAG);
            event.accept(PurrfectItems.WIZARDS_REBORN_FLAG);
            event.accept(PurrfectItems.FLUFFY_FUR_FLAG);
        }
    }
}