package mod.maxbogomol.purrfect.integration.client.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.registry.common.PurrfectRecipes;
import mod.maxbogomol.purrfect.registry.common.item.PurrfectItems;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

@JeiPlugin
public class PurrfectJei implements IModPlugin {
    private static final Comparator<Recipe<?>> BY_ID = Comparator.comparing(Recipe::getId);

    @Nonnull
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Purrfect.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new HandcraftingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new HandcraftingCollarsRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(HandcraftingRecipeCategory.TYPE, sortRecipes(PurrfectRecipes.HANDCRAFTING.get(), BY_ID));
        registration.addRecipes(HandcraftingCollarsRecipeCategory.TYPE, sortRecipes(PurrfectRecipes.HANDCRAFTING_COLLARS.get(), BY_ID));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(PurrfectItems.HANDCRAFTING_TABLE.get()), HandcraftingRecipeCategory.TYPE);
        registration.addRecipeCatalyst(new ItemStack(PurrfectItems.HANDCRAFTING_TABLE.get()), HandcraftingCollarsRecipeCategory.TYPE);
    }

    private static <T extends Recipe<C>, C extends Container> List<T> sortRecipes(RecipeType<T> type, Comparator<? super T> comparator) {
        @SuppressWarnings("unchecked")
        Collection<T> recipes = (Collection<T>) Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(type);
        List<T> list = new ArrayList<>(recipes);
        list.sort(comparator);
        return list;
    }
}