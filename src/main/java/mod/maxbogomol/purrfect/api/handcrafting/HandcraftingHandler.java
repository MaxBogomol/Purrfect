package mod.maxbogomol.purrfect.api.handcrafting;

import mod.maxbogomol.purrfect.common.gui.menu.HandcraftingTableMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HandcraftingHandler {
    private static final Component CONTAINER_TITLE = Component.translatable("block.purrfect.handcrafting_table");

    public static Map<String, HandcraftingTab> tabs = new HashMap<>();
    public static ArrayList<HandcraftingTab> tabsList = new ArrayList<>();

    public static int selected = 0;
    public static int scroll = 0;

    public static void addTab(String id, HandcraftingTab tab) {
        tabs.put(id, tab);
        tabsList.add(tab);
    }

    public static HandcraftingTab getTab(int id) {
        return tabsList.get(id);
    }

    public static HandcraftingTab getTab(String id) {
        return tabs.get(id);
    }

    public static void register(HandcraftingTab tab) {
        tabs.put(tab.getId(), tab);
        tabsList.add(tab);
    }

    public static int size() {
        return tabsList.size();
    }

    public static ArrayList<HandcraftingTab> getTabs() {
        return tabsList;
    }

    public static MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos, HandcraftingTab tab) {
        return new SimpleMenuProvider((containerId, playerInventory, player) -> {
            return new HandcraftingTableMenu(containerId, level, pos, playerInventory, player, tab);
        }, CONTAINER_TITLE);
    }
}
