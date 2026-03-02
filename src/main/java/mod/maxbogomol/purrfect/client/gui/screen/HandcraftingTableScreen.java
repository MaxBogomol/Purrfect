package mod.maxbogomol.purrfect.client.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import mod.maxbogomol.fluffy_fur.util.ColorUtil;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.api.handcrafting.HandcraftingHandler;
import mod.maxbogomol.purrfect.api.handcrafting.HandcraftingTab;
import mod.maxbogomol.purrfect.common.gui.menu.HandcraftingTableMenu;
import mod.maxbogomol.purrfect.common.network.PurrfectPacketHandler;
import mod.maxbogomol.purrfect.common.network.block.HandcraftingOpenMenuPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Inventory;

public class HandcraftingTableScreen extends AbstractContainerScreen<HandcraftingTableMenu> {
    private final ResourceLocation GUI = new ResourceLocation(Purrfect.MOD_ID, "textures/gui/handcrafting_table.png");
    private final int TITLE_COLOR = ColorUtil.packColor(255, 115, 32, 33);

    public HandcraftingTableScreen(HandcraftingTableMenu screenContainer, Inventory inv, Component titleIn) {
        super(screenContainer, inv, titleIn);
        this.imageHeight = 248;
        this.inventoryLabelY = this.inventoryLabelY + 82;
    }

    @Override
    public void init() {
        super.init();
        getMenu().tab.init(this);
    }

    @Override
    public void tick() {
        super.tick();
        getMenu().tab.tick(this);
    }

    @Override
    public void render(GuiGraphics gui, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(gui);
        super.render(gui, mouseX, mouseY, partialTicks);
        renderSelectedTab(gui, mouseX, mouseY, partialTicks);
        this.renderTooltip(gui, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        Component title = Component.translatable(getMenu().tab.getTranslatedName());
        guiGraphics.drawString(this.font, title, this.titleLabelX, this.titleLabelY, TITLE_COLOR, false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 4210752, false);
    }

    @Override
    protected void renderBg(GuiGraphics gui, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        int i = this.leftPos;
        int j = this.topPos;
        gui.blit(GUI, i, j, 0, 0, this.imageWidth, this.imageHeight);

        renderTabs(gui, mouseX, mouseY, partialTicks);
        renderSelectedTabBackground(gui, mouseX, mouseY, partialTicks);
    }

    public void renderTabs(GuiGraphics gui, int mouseX, int mouseY, float partialTicks) {
        int i = this.leftPos;
        int j = this.topPos;

        int ii = 0;
        for (HandcraftingTab tab : HandcraftingHandler.getTabs()) {
            int scroll = ii - HandcraftingHandler.scroll;
            boolean selected = ii == HandcraftingHandler.selected;
            boolean hovered = (mouseX >= i - (selected ? 26 : 22) && mouseY >= j + 10 + (scroll * 22) && mouseX < i - (selected ? 26 : 22) + 20 && mouseY < j + 10 + (scroll * 22) + 20);
            if (HandcraftingHandler.getTabs().size() <= 6 || (scroll >= 0 && scroll < 6)) {
                gui.blit(GUI, i - (selected ? 26 : 22), j + 10 + (scroll * 22), hovered ? 196 : 176, 0, 20, 20, 256, 256);
                if (tab.getIconItem() != null) {
                    gui.renderItem(tab.getIconItem(), i - (selected ? 26 : 22) + 2, j + 10 + (scroll * 22) + 2);
                }
            }
            ii++;
        }

        if (HandcraftingHandler.getTabs().size() > 6) {
            if (HandcraftingHandler.scroll > 0) {
                boolean hovered = (mouseX >= i - 22 && mouseY >= j - 12 && mouseX < i - 22 + 20 && mouseY < j - 12 + 20);
                gui.blit(GUI, i - 22, j - 12, hovered ? 196 : 176, 20, 20, 20, 256, 256);
            }
            if (HandcraftingHandler.scroll < HandcraftingHandler.getTabs().size() - 6) {
                boolean hovered = (mouseX >= i - 22 && mouseY >= j + 142 && mouseX < i - 22 + 20 && mouseY < j + 142 + 20);
                gui.blit(GUI, i - 22, j + 142, hovered ? 196 : 176, 40, 20, 20, 256, 256);
            }
        }
    }

    public void renderSelectedTabBackground(GuiGraphics gui, int mouseX, int mouseY, float partialTicks) {
        getMenu().tab.renderBackground(this, gui, mouseX, mouseY, partialTicks);
    }

    public void renderSelectedTab(GuiGraphics gui, int mouseX, int mouseY, float partialTicks) {
        getMenu().tab.render(this, gui, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        super.mouseClicked(mouseX, mouseY, button);
        int i = this.leftPos;
        int j = this.topPos;
        int ii = 0;
        for (HandcraftingTab tab : HandcraftingHandler.getTabs()) {
            int scroll = ii - HandcraftingHandler.scroll;
            boolean selected = ii == HandcraftingHandler.selected;
            boolean hovered = (mouseX >= i - (selected ? 26 : 22) && mouseY >= j + 10 + (scroll * 22) && mouseX < i - (selected ? 26 : 22) + 20 && mouseY < j + 10 + (scroll * 22) + 20);
            if (hovered && (HandcraftingHandler.getTabs().size() <= 6 || (scroll >= 0 && scroll < 6))) {
                HandcraftingHandler.selected = ii;
                PurrfectPacketHandler.sendToServer(new HandcraftingOpenMenuPacket(getMenu().blockPos, tab));
                Minecraft.getInstance().player.playNotifySound(SoundEvents.UI_BUTTON_CLICK.get(), SoundSource.NEUTRAL, 0.5f, 1.0f);
                return true;
            }
            ii++;
        }
        if (HandcraftingHandler.getTabs().size() > 6) {
            if (HandcraftingHandler.scroll > 0) {
                boolean hovered = (mouseX >= i - 22 && mouseY >= j - 12 && mouseX < i - 22 + 20 && mouseY < j - 12 + 20);
                if (hovered) {
                    HandcraftingHandler.scroll--;
                    Minecraft.getInstance().player.playNotifySound(SoundEvents.UI_BUTTON_CLICK.get(), SoundSource.NEUTRAL, 0.5f, 1.0f);
                    return true;
                }
            }
            if (HandcraftingHandler.scroll < HandcraftingHandler.getTabs().size() - 6) {
                boolean hovered = (mouseX >= i - 22 && mouseY >= j + 142 && mouseX < i - 22 + 20 && mouseY < j + 142 + 20);
                if (hovered) {
                    HandcraftingHandler.scroll++;
                    Minecraft.getInstance().player.playNotifySound(SoundEvents.UI_BUTTON_CLICK.get(), SoundSource.NEUTRAL, 0.5f, 1.0f);
                    return true;
                }
            }
        }
        if (getMenu().tab.mouseClicked(this, mouseX, mouseY, button)) return true;
        return false;
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
        super.mouseScrolled(mouseX, mouseY, delta);
        int i = this.getGuiLeft();
        int j = this.getGuiTop();
        if (mouseX >= i - 26 && mouseY >= j - 12 && mouseX <= i && mouseY < j + 140) {
            if (HandcraftingHandler.getTabs().size() > 6) {
                int add = (int) -delta;
                HandcraftingHandler.scroll = HandcraftingHandler.scroll + add;
                if (HandcraftingHandler.scroll < 0) {
                    HandcraftingHandler.scroll = 0;
                } else if (HandcraftingHandler.scroll > HandcraftingHandler.getTabs().size() - 6) {
                    HandcraftingHandler.scroll = HandcraftingHandler.getTabs().size() - 6;
                } else {
                    Minecraft.getInstance().player.playNotifySound(SoundEvents.UI_BUTTON_CLICK.get(), SoundSource.NEUTRAL, 0.1f, 2.0f);
                }
            }
            return true;
        }
        if (getMenu().tab.mouseScrolled(this, mouseX, mouseY, delta)) return true;
        return false;
    }
}
