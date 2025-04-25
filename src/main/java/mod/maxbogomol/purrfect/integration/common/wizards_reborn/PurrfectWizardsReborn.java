package mod.maxbogomol.purrfect.integration.common.wizards_reborn;

import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.common.item.equipment.curio.FlowerWreathItem;
import mod.maxbogomol.purrfect.common.network.PurrfectPacketHandler;
import mod.maxbogomol.purrfect.integration.common.wizards_reborn.network.item.PetalsOfInnocenceFlowerWreathPacket;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PurrfectWizardsReborn {
    public static boolean LOADED;
    public static String MOD_ID = "wizards_reborn";

    public static class ItemsLoadedOnly {
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Purrfect.MOD_ID);

        public static FlowerWreathItem.FlowerWreathColor PETALS_OF_INNOCENCE_FLOWER_WREATH_COLOR;

        public static RegistryObject<Item> PETALS_OF_INNOCENCE_FLOWER_WREATH;
    }

    public static class LoadedOnly {
        public static void makeItems() {
            PurrfectWizardsReborn.ItemsLoadedOnly.PETALS_OF_INNOCENCE_FLOWER_WREATH_COLOR = new PetalsOfInnocenceFlowerWreathColor("petals_of_innocence");

            PurrfectWizardsReborn.ItemsLoadedOnly.PETALS_OF_INNOCENCE_FLOWER_WREATH = ItemsLoadedOnly.ITEMS.register("petals_of_innocence_flower_wreath", () -> new FlowerWreathItem(new Item.Properties().stacksTo(1)).setColor(PurrfectWizardsReborn.ItemsLoadedOnly.PETALS_OF_INNOCENCE_FLOWER_WREATH_COLOR));
        }

        public static class PetalsOfInnocenceFlowerWreathColor extends FlowerWreathItem.FlowerWreathColor {

            public PetalsOfInnocenceFlowerWreathColor(String modId, String texture) {
                super(modId, texture);
            }

            public PetalsOfInnocenceFlowerWreathColor(String texture) {
                super(texture);
            }

            public void onLivingDamage(LivingDamageEvent event) {
                LivingEntity entity = event.getEntity();
                if (!entity.level().isClientSide()) {
                    PurrfectPacketHandler.sendToTracking(entity.level(), entity.blockPosition(), new PetalsOfInnocenceFlowerWreathPacket(entity.getEyePosition()));
                }
            }
        }
    }

    public static void init(IEventBus eventBus) {
        LOADED = ModList.get().isLoaded(MOD_ID);

        if (isLoaded()) {
            PurrfectWizardsReborn.LoadedOnly.makeItems();
            ItemsLoadedOnly.ITEMS.register(eventBus);
        }
    }

    public static boolean isLoaded() {
        return LOADED;
    }
}
