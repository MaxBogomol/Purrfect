package mod.maxbogomol.purrfect.registry.common;

import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.common.gui.menu.HandcraftingTableMenu;
import mod.maxbogomol.purrfect.client.gui.screen.HandcraftingTableScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PurrfectMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Purrfect.MOD_ID);

    public static final RegistryObject<MenuType<HandcraftingTableMenu>> HANDCRAFTING_TABLE_CONTAINER = MENU_TYPES.register("handcrafting_table",
            () -> IForgeMenuType.create(((containerId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                Level level = inv.player.getCommandSenderWorld();
                return new HandcraftingTableMenu(containerId, level, pos, inv, inv.player);})));

    public static void register(IEventBus eventBus) {
        MENU_TYPES.register(eventBus);
    }

    @Mod.EventBusSubscriber(modid = Purrfect.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientRegistryEvents {
        @SubscribeEvent
        public static void clientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(HANDCRAFTING_TABLE_CONTAINER.get(), HandcraftingTableScreen::new);
        }
    }
}
