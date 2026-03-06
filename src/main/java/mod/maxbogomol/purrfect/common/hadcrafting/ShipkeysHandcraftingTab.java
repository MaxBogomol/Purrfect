package mod.maxbogomol.purrfect.common.hadcrafting;

import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.api.handcrafting.HandcraftingTab;
import mod.maxbogomol.purrfect.api.handcrafting.HandcraftingTabComponent;
import mod.maxbogomol.purrfect.client.gui.screen.HandcraftingTableScreen;
import mod.maxbogomol.purrfect.common.gui.menu.HandcraftingTableMenu;
import mod.maxbogomol.purrfect.common.hadcrafting.component.ShipkeysHandcraftingTabComponent;
import mod.maxbogomol.purrfect.common.item.equipment.ShipkeyItem;
import mod.maxbogomol.purrfect.common.network.PurrfectPacketHandler;
import mod.maxbogomol.purrfect.common.network.block.HandcraftingShipkeysCopyPacket;
import mod.maxbogomol.purrfect.registry.common.item.PurrfectItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public class ShipkeysHandcraftingTab extends HandcraftingTab {
    public final ResourceLocation SHIPKEY_SLOT_TEXTURE = new ResourceLocation(Purrfect.MOD_ID, "textures/gui/shipkey_handcrafting_slot.png");
    public static Supplier<ItemStack> ICON = () -> new ItemStack(PurrfectItems.GOLDEN_SHIPKEY.get());

    public ShipkeysHandcraftingTab(String id, Supplier<ItemStack> iconItemStack) {
        super(id, iconItemStack);
    }

    @Override
    public HandcraftingTabComponent getComponent() {
        return new ShipkeysHandcraftingTabComponent();
    }

    public ShipkeysHandcraftingTabComponent getComponent(HandcraftingTableMenu menu) {
        if (menu.tabComponent instanceof ShipkeysHandcraftingTabComponent shipkeysHandcraftingTabComponent) {
            return shipkeysHandcraftingTabComponent;
        }
        return new ShipkeysHandcraftingTabComponent();
    }

    @Override
    public void createMenu(HandcraftingTableMenu menu) {
        getComponent(menu).inputSlots = new SimpleContainer(2) {
            public void setChanged() {
                super.setChanged();
                menu.slotsChanged(this);
            }
        };

        menu.addSlot(new Slot(getComponent(menu).inputSlots, 0, 62, 72) {
            public boolean mayPlace(ItemStack stack) {
                return stack.getItem() instanceof ShipkeyItem;
            }
        });
        menu.addSlot(new Slot(getComponent(menu).inputSlots, 1, 98, 72) {
            public boolean mayPlace(ItemStack stack) {
                return stack.getItem() instanceof ShipkeyItem;
            }
        });
    }

    @Override
    public void removedMenu(HandcraftingTableMenu menu, Player player) {
        menu.clearContainer(player, getComponent(menu).inputSlots);
    }

    @Override
    public int getInventorySize(HandcraftingTableMenu menu) {
        return 2;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void renderBackground(HandcraftingTableScreen screen, GuiGraphics gui, int mouseX, int mouseY, float partialTicks) {
        int i = screen.getGuiLeft();
        int j = screen.getGuiTop();

        gui.blit(GUI, i + 61, j + 71, 176, 60, 18, 18, 256, 256);
        if (getComponent(screen.getMenu()).inputSlots.getItem(0).isEmpty()) gui.blit(SHIPKEY_SLOT_TEXTURE, i + 62, j + 72, 0, 0, 16, 16, 16, 16);

        gui.blit(GUI, i + 97, j + 71, 176, 60, 18, 18, 256, 256);
        if (getComponent(screen.getMenu()).inputSlots.getItem(1).isEmpty()) gui.blit(SHIPKEY_SLOT_TEXTURE, i + 98, j + 72, 0, 0, 16, 16, 16, 16);

        boolean hovered = (mouseX >= i + 79 + 1 && mouseY >= j + 71 + 1 && mouseX < i + 79 + 18 && mouseY < j + 71 + 17);
        gui.blit(GUI, i + 79, j + 71, hovered ?212 : 194, 60, 18, 18, 256, 256);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean mouseClicked(HandcraftingTableScreen screen, double mouseX, double mouseY, int button) {
        int i = screen.getGuiLeft();
        int j = screen.getGuiTop();

        if (!getComponent(screen.getMenu()).inputSlots.getItem(0).isEmpty() && !getComponent(screen.getMenu()).inputSlots.getItem(1).isEmpty()) {
            if (mouseX >= i + 79 + 1 && mouseY >= j + 71 + 1 && mouseX < i + 79 + 18 && mouseY < j + 71 + 17) {
                PurrfectPacketHandler.sendToServer(new HandcraftingShipkeysCopyPacket());
                Minecraft.getInstance().player.playNotifySound(SoundEvents.UI_BUTTON_CLICK.get(), SoundSource.NEUTRAL, 0.5f, 1.0f);
            }
        }

        return false;
    }

    public static boolean canCraftRecipe(Player player) {
        if (player != null) {
            AbstractContainerMenu containerMenu = player.containerMenu;
            if (containerMenu instanceof HandcraftingTableMenu handcraftingTableMenu) {
                return handcraftingTableMenu.stillValid(player);
            }
        }
        return false;
    }

    public static void craftRecipe(Player player, Level level) {
        if (level != null && player != null) {
            AbstractContainerMenu containerMenu = player.containerMenu;
            if (containerMenu instanceof HandcraftingTableMenu handcraftingTableMenu) {
                if (handcraftingTableMenu.tabComponent instanceof ShipkeysHandcraftingTabComponent tabComponent) {
                    if (!tabComponent.inputSlots.getItem(0).isEmpty() && !tabComponent.inputSlots.getItem(1).isEmpty()) {
                        ItemStack shipkey1 = tabComponent.inputSlots.getItem(0);
                        ItemStack shipkey2 = tabComponent.inputSlots.getItem(1);
                        if (ShipkeyItem.hasUUID(shipkey1) && !ShipkeyItem.hasUUID(shipkey2)) {
                            ShipkeyItem.setUUID(shipkey2, ShipkeyItem.getUUID(shipkey1));
                        }
                        if (!ShipkeyItem.hasUUID(shipkey1) && ShipkeyItem.hasUUID(shipkey2)) {
                            ShipkeyItem.setUUID(shipkey1, ShipkeyItem.getUUID(shipkey2));
                        }
                        handcraftingTableMenu.broadcastChanges();
                    }
                }
            }
        }
    }
}
