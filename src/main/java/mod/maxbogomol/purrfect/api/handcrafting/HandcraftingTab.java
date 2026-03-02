package mod.maxbogomol.purrfect.api.handcrafting;

import mod.maxbogomol.fluffy_fur.util.ColorUtil;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.client.gui.screen.HandcraftingTableScreen;
import mod.maxbogomol.purrfect.common.gui.menu.HandcraftingTableMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public class HandcraftingTab {
    public final ResourceLocation GUI = new ResourceLocation(Purrfect.MOD_ID, "textures/gui/handcrafting_table.png");
    public final int TITLE_COLOR = ColorUtil.packColor(255, 115, 32, 33);

    public String id;

    public Supplier<ItemStack> iconItemStack = () -> null;

    public HandcraftingTab(String id, Supplier<ItemStack> iconItemStack) {
        this.id = id;
        this.iconItemStack = iconItemStack;
    }

    public String getId() {
        return id;
    }

    public ItemStack getIconItem() {
        return iconItemStack.get();
    }

    public String getTranslatedName() {
        return getTranslatedName(id);
    }

    public static String getTranslatedName(String id) {
        int i = id.indexOf(":");
        String modId = id.substring(0, i);
        String tabId = id.substring(i + 1);
        return "handcrafting_tab." + modId + "." + tabId;
    }

    public HandcraftingTabComponent getComponent() {
        return new HandcraftingTabComponent();
    }

    public HandcraftingTabComponent getComponent(HandcraftingTableMenu menu) {
        return menu.tabComponent;
    }

    public void createMenu(HandcraftingTableMenu menu) {

    }

    public void removedMenu(HandcraftingTableMenu menu, Player player) {

    }

    public void slotsChanged(HandcraftingTableMenu menu, Container inventory) {

    }

    public int getInventorySize(HandcraftingTableMenu menu) {
        return 0;
    }

    @OnlyIn(Dist.CLIENT)
    public void init(HandcraftingTableScreen screen) {

    }

    @OnlyIn(Dist.CLIENT)
    public void tick(HandcraftingTableScreen screen) {

    }

    @OnlyIn(Dist.CLIENT)
    public void renderBackground(HandcraftingTableScreen screen, GuiGraphics gui, int mouseX, int mouseY, float partialTicks) {

    }

    @OnlyIn(Dist.CLIENT)
    public void render(HandcraftingTableScreen screen, GuiGraphics gui, int mouseX, int mouseY, float partialTicks) {

    }

    @OnlyIn(Dist.CLIENT)
    public boolean mouseClicked(HandcraftingTableScreen screen, double mouseX, double mouseY, int button) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean mouseScrolled(HandcraftingTableScreen screen, double mouseX, double mouseY, double delta) {
        return false;
    }
}
