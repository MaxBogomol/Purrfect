package mod.maxbogomol.purrfect.common.hadcrafting;

import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.api.handcrafting.HandcraftingTab;
import mod.maxbogomol.purrfect.api.handcrafting.HandcraftingTabComponent;
import mod.maxbogomol.purrfect.client.gui.screen.HandcraftingTableScreen;
import mod.maxbogomol.purrfect.common.gui.menu.HandcraftingTableMenu;
import mod.maxbogomol.purrfect.common.hadcrafting.component.SillyTagsHandcraftingTabComponent;
import mod.maxbogomol.purrfect.common.item.equipment.SillyTagItem;
import mod.maxbogomol.purrfect.common.network.PurrfectPacketHandler;
import mod.maxbogomol.purrfect.common.network.block.HandcraftingSillyTagCraftPacket;
import mod.maxbogomol.purrfect.registry.common.item.PurrfectItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SillyTagsHandcraftingTab extends HandcraftingTab {
    public final ResourceLocation TAG_SLOT_TEXTURE = new ResourceLocation(Purrfect.MOD_ID, "textures/gui/silly_tag_handcrafting_slot.png");
    public static Supplier<ItemStack> ICON = () -> {
        ItemStack tag = new ItemStack(PurrfectItems.SILLY_TAG.get());
        SillyTagItem.setTag(tag, Purrfect.MOD_ID+":nameless");
        return tag;
    };

    public static List<String> tags = new ArrayList<>();
    public String selectedTag = null;
    public int scroll = 0;

    public SillyTagsHandcraftingTab(String id, Supplier<ItemStack> iconItemStack) {
        super(id, iconItemStack);
    }

    @Override
    public HandcraftingTabComponent getComponent() {
        return new SillyTagsHandcraftingTabComponent();
    }

    public SillyTagsHandcraftingTabComponent getComponent(HandcraftingTableMenu menu) {
        if (menu.tabComponent instanceof SillyTagsHandcraftingTabComponent sillyTagsHandcraftingTabComponent) {
            return sillyTagsHandcraftingTabComponent;
        }
        return new SillyTagsHandcraftingTabComponent();
    }

    @Override
    public void createMenu(HandcraftingTableMenu menu) {
        getComponent(menu).inputSlot = new SimpleContainer(1) {
            public void setChanged() {
                super.setChanged();
                menu.slotsChanged(this);
            }
        };
        getComponent(menu).resultSlot = new ResultContainer();

        menu.addSlot(new Slot(getComponent(menu).inputSlot, 0, 8, 126) {
            public boolean mayPlace(ItemStack stack) {
                return stack.getItem().equals(PurrfectItems.SILLY_TAG.get());
            }

            public void onTake(Player player, ItemStack stack) {
                getComponent(menu).resultSlot.clearContent();
                selectedTag = null;
            }
        });
        menu.addSlot(new Slot(getComponent(menu).resultSlot, 1, 62, 126) {
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            public void onTake(Player player, ItemStack stack) {
                getComponent(menu).inputSlot.setItem(0, ItemStack.EMPTY);
                selectedTag = null;
            }
        });
    }

    @Override
    public void removedMenu(HandcraftingTableMenu menu, Player player) {
        menu.clearContainer(player, getComponent(menu).inputSlot);
    }

    @Override
    public int getInventorySize(HandcraftingTableMenu menu) {
        return 2;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void init(HandcraftingTableScreen screen) {
        tags = new ArrayList<>(SillyTagItem.tagList);
        tags.removeAll(SillyTagItem.specialTagList);
        selectedTag = null;
        scroll = 0;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void renderBackground(HandcraftingTableScreen screen, GuiGraphics gui, int mouseX, int mouseY, float partialTicks) {
        int i = screen.getGuiLeft();
        int j = screen.getGuiTop();

        for (int si = 0; si < 6; si++) {
            for (int sj = 0; sj < 8; sj++) {
                gui.blit(GUI, i + 7 + (sj * 18), j + 17 + (si * 18), 176, 60, 18, 18, 256, 256);
            }
        }

        gui.blit(GUI, i + 7, j + 125, 176, 60, 18, 18, 256, 256);
        if (getComponent(screen.getMenu()).inputSlot.isEmpty()) gui.blit(TAG_SLOT_TEXTURE, i + 8, j + 126, 0, 0, 16, 16, 16, 16);

        gui.blit(GUI, i + 32, j + 125, 230, 60, 22  , 18, 256, 256);

        gui.blit(GUI, i + 61, j + 125, 176, 60, 18, 18, 256, 256);
        if (getComponent(screen.getMenu()).resultSlot.isEmpty()) gui.blit(TAG_SLOT_TEXTURE, i + 62, j + 126, 0, 0, 16, 16, 16, 16);

        gui.blit(GUI, i + 152, j + 17, 216, 0, 16, 18, 256, 256);
        gui.blit(GUI, i + 152, j + 35, 16, 90, 216, 18, 16, 18, 256, 256);
        gui.blit(GUI, i + 152, j + 125, 216, 36, 16, 18, 256, 256);

        int size = (int) (Math.ceil(tags.size() / 8f) - 6);
        int offset = size > 0 ? ((scroll / size) * 107) : 0;
        gui.blit(GUI, i + 154, j + 19 + offset, 232, 0, 12, 15, 256, 256);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void render(HandcraftingTableScreen screen, GuiGraphics gui, int mouseX, int mouseY, float partialTicks) {
        int i = screen.getGuiLeft();
        int j = screen.getGuiTop();

        Minecraft minecraft = Minecraft.getInstance();
        ItemStack hoveredItem = ItemStack.EMPTY;

        if (!getComponent(screen.getMenu()).inputSlot.isEmpty()) {
            int ii = scroll * 8;
            for (int si = 0; si < 6; si++) {
                for (int sj = 0; sj < 8; sj++) {
                    if (tags.size() <= ii) break;
                    String tag = tags.get(ii);
                    ItemStack itemStack = new ItemStack(PurrfectItems.SILLY_TAG.get());
                    SillyTagItem.setTag(itemStack, tag);
                    gui.renderItem(itemStack, i + 7 + (sj * 18) + 1, j + 17 + (si * 18) + 1);
                    gui.renderItemDecorations(minecraft.font, itemStack, i + 7 + (sj * 18) + 1, j + 17 + (si * 18) + 1);
                    boolean hovered = (mouseX >= i + 7 + (sj * 18) + 1 && mouseY >= j + 17 + (si * 18) + 1 && mouseX < i + 7 + (sj * 18) + 17 && mouseY < j + 17 + (si * 18) + 17);
                    if (hovered) hoveredItem = itemStack;
                    ii++;
                    if (ii >= tags.size()) break;
                }
                if (ii >= tags.size()) break;
            }
        }

        if (!hoveredItem.isEmpty()) {
            gui.renderTooltip(minecraft.font, hoveredItem, mouseX, mouseY);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean mouseClicked(HandcraftingTableScreen screen, double mouseX, double mouseY, int button) {
        int i = screen.getGuiLeft();
        int j = screen.getGuiTop();

        if (!getComponent(screen.getMenu()).inputSlot.isEmpty()) {
            int ii = scroll * 8;
            for (int si = 0; si < 6; si++) {
                for (int sj = 0; sj < 8; sj++) {
                    if (tags.size() <= ii) break;
                    String tag = tags.get(ii);
                    boolean hovered = (mouseX >= i + 7 + (sj * 18) && mouseY >= j + 17 + (si * 18) && mouseX < i + 7 + (sj * 18) + 18 && mouseY < j + 17 + (si * 18) + 18);
                    if (hovered) {
                        selectedTag = tag;
                        if (!getComponent(screen.getMenu()).inputSlot.isEmpty())
                            PurrfectPacketHandler.sendToServer(new HandcraftingSillyTagCraftPacket(selectedTag));
                        Minecraft.getInstance().player.playNotifySound(SoundEvents.UI_BUTTON_CLICK.get(), SoundSource.NEUTRAL, 0.5f, 1.0f);
                        return true;
                    }
                    ii++;
                    if (ii >= tags.size()) break;
                }
                if (ii >= tags.size()) break;
            }
        }

        return false;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean mouseScrolled(HandcraftingTableScreen screen, double mouseX, double mouseY, double delta) {
        int i = screen.getGuiLeft();
        int j = screen.getGuiTop();

        if (tags.size() > 48) {
            if (mouseX >= i + 7 && mouseY >= j + 17 && mouseX < i + 169 && mouseY < j + 143) {
                int add = (int) -delta;
                scroll = scroll + add;
                if (scroll < 0) {
                    scroll = 0;
                } else if (scroll > (int) (Math.ceil(tags.size() / 8f)) - 6) {
                    scroll = (int) (Math.ceil(tags.size() / 8f)) - 6;
                } else {
                    Minecraft.getInstance().player.playNotifySound(SoundEvents.UI_BUTTON_CLICK.get(), SoundSource.NEUTRAL, 0.1f, 2.0f);
                }
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

    public static void craftRecipe(Player player, Level level, String tag) {
        if (level != null && player != null) {
            AbstractContainerMenu containerMenu = player.containerMenu;
            if (containerMenu instanceof HandcraftingTableMenu handcraftingTableMenu) {
                if (handcraftingTableMenu.tabComponent instanceof SillyTagsHandcraftingTabComponent tabComponent) {
                    if (!tabComponent.inputSlot.getItem(0).isEmpty()) {
                        ItemStack itemStack = tabComponent.inputSlot.getItem(0).copy();
                        SillyTagItem.setTag(itemStack, tag);
                        tabComponent.resultSlot.setItem(0, itemStack);
                        handcraftingTableMenu.broadcastChanges();
                    }
                }
            }
        }
    }
}
