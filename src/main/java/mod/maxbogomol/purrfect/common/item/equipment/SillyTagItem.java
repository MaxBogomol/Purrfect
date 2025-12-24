package mod.maxbogomol.purrfect.common.item.equipment;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;

public class SillyTagItem extends Item {

    public static ArrayList<String> tagList = new ArrayList<>();

    public SillyTagItem(Properties properties) {
        super(properties);
    }

    public static void addTag(String tag) {
        tagList.add(tag);
    }

    public static void setTag(ItemStack stack, String tag) {
        CompoundTag nbt = stack.getOrCreateTag();
        nbt.putString("tag", tag);
    }

    public static String getTag(ItemStack stack) {
        CompoundTag nbt = stack.getOrCreateTag();
        if (nbt.contains("tag")) {
            return nbt.getString("tag");
        }
        return "";
    }

    public static boolean hasTag(ItemStack stack) {
        String tag = getTag(stack);
        return !tag.isEmpty() || stack.hasCustomHoverName();
    }

    public static String getTranslatedTag(String id) {
        int i = id.indexOf(":");
        String modId = id.substring(0, i);
        String tagId = id.substring(i + 1);
        return "silly_tag." + modId + "." + tagId;
    }

    public static List<ItemStack> getAllItems(Item item) {
        List<ItemStack> list = new ArrayList<>();

        for (String tag : tagList) {
            ItemStack stack = new ItemStack(item);
            setTag(stack, tag);
            list.add(stack);
        }

        return list;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, Level level, List<Component> list, TooltipFlag flags) {
        String tag = getTag(stack);

        if (tag.isEmpty()) {
            if (!stack.hasCustomHoverName()) {
                list.add(Component.translatable("lore.purrfect.silly_tag.gender").withStyle(ChatFormatting.GRAY));
            } else {
                list.add(Component.translatable("lore.purrfect.silly_tag.tag").withStyle(ChatFormatting.GOLD).append(CommonComponents.SPACE).append(Component.literal(stack.getHoverName().getString()).withStyle(ChatFormatting.YELLOW).withStyle(ChatFormatting.ITALIC)));
            }
        } else {
            list.add(Component.translatable("lore.purrfect.silly_tag.tag").withStyle(ChatFormatting.GOLD).append(CommonComponents.SPACE).append(Component.translatable(getTranslatedTag(tag)).withStyle(ChatFormatting.YELLOW)));
        }
    }
}
