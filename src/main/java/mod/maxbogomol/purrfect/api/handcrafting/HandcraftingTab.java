package mod.maxbogomol.purrfect.api.handcrafting;

import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class HandcraftingTab {
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
}
