package mod.maxbogomol.purrfect.common.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.registry.common.PurrfectRecipes;
import mod.maxbogomol.purrfect.registry.common.item.PurrfectItems;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class HandcraftingSortingRecipe implements Recipe<Container> {
    public static ResourceLocation TYPE_ID = new ResourceLocation(Purrfect.MOD_ID, "handcrafting_sorting");
    private final ResourceLocation id;
    private final List<String> recipes;
    private final int weight;

    public HandcraftingSortingRecipe(ResourceLocation id, int weight, String... recipes) {
        this.id = id;
        this.weight = weight;
        this.recipes = List.of(recipes);
    }

    @Override
    public boolean matches(Container container, Level level) {
        return true;
    }

    @Override
    public ItemStack assemble(Container container, RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(PurrfectItems.HANDCRAFTING_TABLE.get());
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeType<?> getType(){
        return BuiltInRegistries.RECIPE_TYPE.getOptional(TYPE_ID).get();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return PurrfectRecipes.HANDCRAFTING_SORTING_SERIALIZER.get();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public boolean isSpecial(){
        return true;
    }

    public static class Serializer implements RecipeSerializer<HandcraftingSortingRecipe> {

        @Override
        public HandcraftingSortingRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            int weight = GsonHelper.getAsInt(json, "weight", 0);
            JsonArray recipes = GsonHelper.getAsJsonArray(json, "recipes");
            List<String> recipesList = new ArrayList<>();
            for (JsonElement e : recipes) {
                recipesList.add(e.getAsString());
            }

            return new HandcraftingSortingRecipe(recipeId, weight, recipesList.toArray(new String[0]));
        }

        @Nullable
        @Override
        public HandcraftingSortingRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            String[] recipes = new String[buffer.readInt()];
            for (int i = 0; i < recipes.length; i++) {
                recipes[i] = buffer.readUtf();
            }
            int weight = buffer.readInt();
            return new HandcraftingSortingRecipe(recipeId, weight, recipes);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, HandcraftingSortingRecipe recipe) {
            buffer.writeInt(recipe.getRecipes().size());
            for (String recipeSort : recipe.getRecipes()) {
                buffer.writeUtf(recipeSort);
            }
            buffer.writeInt(recipe.getWeight());
        }
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    public List<String> getRecipes() {
        return recipes;
    }

    public int getWeight() {
        return weight;
    }
}
