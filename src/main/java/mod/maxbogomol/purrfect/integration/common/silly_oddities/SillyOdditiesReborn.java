package mod.maxbogomol.purrfect.integration.common.silly_oddities;

import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.client.render.curio.FlowerWreathRenderer;
import mod.maxbogomol.purrfect.common.item.equipment.curio.FlowerWreathItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

public class SillyOdditiesReborn {
    public static boolean LOADED;
    public static String MOD_ID = "silly_oddities";

    public static class ItemsLoadedOnly {
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Purrfect.MOD_ID);

        public static FlowerWreathItem.FlowerWreathColor WILDFLOWERS_FLOWER_WREATH_COLOR;

        public static RegistryObject<Item> WILDFLOWERS_FLOWER_WREATH;
    }

    public static class LoadedOnly {
        public static void makeItems() {
            SillyOdditiesReborn.ItemsLoadedOnly.WILDFLOWERS_FLOWER_WREATH_COLOR = new FlowerWreathItem.FlowerWreathColor("wildflowers");

            SillyOdditiesReborn.ItemsLoadedOnly.WILDFLOWERS_FLOWER_WREATH = ItemsLoadedOnly.ITEMS.register("wildflowers_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(SillyOdditiesReborn.ItemsLoadedOnly.WILDFLOWERS_FLOWER_WREATH_COLOR));
        }
    }

    public static class ClientLoadedOnly {
        public static void registerItems(FMLClientSetupEvent event) {
            CuriosRendererRegistry.register(ItemsLoadedOnly.WILDFLOWERS_FLOWER_WREATH.get(), FlowerWreathRenderer::new);
        }
    }

    public static void init(IEventBus eventBus) {
        LOADED = ModList.get().isLoaded(MOD_ID);

        if (isLoaded()) {
            SillyOdditiesReborn.LoadedOnly.makeItems();
            ItemsLoadedOnly.ITEMS.register(eventBus);
        }
    }

    public static boolean isLoaded() {
        return LOADED;
    }
}
