package mod.maxbogomol.purrfect.registry.common.item;

import mod.maxbogomol.fluffy_fur.util.ColorUtil;
import mod.maxbogomol.purrfect.Purrfect;
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

@Mod.EventBusSubscriber(modid = Purrfect.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PurrfectCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Purrfect.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PURRFECT = CREATIVE_MODE_TABS.register("tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(PurrfectItems.GOLDEN_BELL_COLLAR.get()))
                    .title(Component.translatable("creative_tab.purrfect"))
                    .withLabelColor(ColorUtil.packColor(255, 55, 48, 54))
                    .withBackgroundLocation(new ResourceLocation(Purrfect.MOD_ID, "textures/gui/purrfect_item_tab.png"))
                    .withTabsImage(new ResourceLocation(Purrfect.MOD_ID, "textures/gui/purrfect_tabs.png"))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    public static void addCreativeTabContent(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == PurrfectCreativeTabs.PURRFECT.getKey()) {
            event.accept(PurrfectItems.PHARMACIST_TABLE);

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
        }
    }
}