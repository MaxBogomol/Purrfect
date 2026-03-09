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

public class HandcraftingRecipe implements Recipe<Container> {
    public static ResourceLocation TYPE_ID = new ResourceLocation(Purrfect.MOD_ID, "handcrafting");
    private final ResourceLocation id;
    private final List<HandcraftingIngredient> inputs;
    private final ItemStack output;
    private String special;

    public HandcraftingRecipe(ResourceLocation id, ItemStack output, HandcraftingIngredient... inputs) {
        this.id = id;
        this.output = output;
        this.inputs = List.of(inputs);
    }

    public HandcraftingRecipe setSpecial(String special) {
        this.special = special;
        return this;
    }

    @Override
    public boolean matches(Container container, Level level) {
        return matches(inputs, container, 1);
    }

    public boolean matches(Container container, Level level, int multiplier) {
        return matches(inputs, container, multiplier);
    }

    public static boolean matches(List<HandcraftingIngredient> inputs, Container container, int multiplier) {
        List<HandcraftingIngredient> ingredientsMissing = new ArrayList<>();
        for (HandcraftingIngredient ingredient : inputs) {
            ingredientsMissing.add(new HandcraftingIngredient(ingredient.getIngredient(), ingredient.getCount() * multiplier));
        }
        boolean empty = true;

        for (HandcraftingIngredient ingredient : ingredientsMissing) {
            for (int i = 0; i < container.getContainerSize(); i++) {
                ItemStack stack = container.getItem(i);
                if (ingredient.getIngredient().test(stack)) {
                    ingredient.remove(stack.getCount());
                    if (ingredient.isEmpty()) break;
                }
            }
        }

        for (HandcraftingIngredient ingredient : ingredientsMissing) {
            if (!ingredient.isEmpty()) empty = false;
        }

        return empty;
    }

    @Override
    public ItemStack assemble(Container container, RegistryAccess registryAccess) {
        return output;
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
        return PurrfectRecipes.HANDCRAFTING_SERIALIZER.get();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public boolean isSpecial(){
        return true;
    }

    public static class Serializer implements RecipeSerializer<HandcraftingRecipe> {

        @Override
        public HandcraftingRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));
            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            List<HandcraftingIngredient> inputs = new ArrayList<>();
            for (JsonElement e : ingredients) {
                JsonObject i = GsonHelper.getAsJsonObject(e.getAsJsonObject(), "ingredient");
                Ingredient ingredient = Ingredient.fromJson(i);
                int count = GsonHelper.getAsInt(e.getAsJsonObject(), "count", 1);
                inputs.add(new HandcraftingIngredient(ingredient, count));
            }
            String special = GsonHelper.getAsString(json, "special", "");

            return new HandcraftingRecipe(recipeId, output, inputs.toArray(new HandcraftingIngredient[0])).setSpecial(special);
        }

        @Nullable
        @Override
        public HandcraftingRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            HandcraftingIngredient[] inputs = new HandcraftingIngredient[buffer.readInt()];
            for (int i = 0; i < inputs.length; i++) {
                Ingredient ingredient = Ingredient.fromNetwork(buffer);
                int count = buffer.readInt();
                inputs[i] = new HandcraftingIngredient(ingredient, count);
            }
            ItemStack output = buffer.readItem();
            String special = buffer.readUtf();
            return new HandcraftingRecipe(recipeId, output, inputs).setSpecial(special);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, HandcraftingRecipe recipe) {
            buffer.writeInt(recipe.getHandcraftingIngredients().size());
            for (HandcraftingIngredient input : recipe.getHandcraftingIngredients()) {
                input.getIngredient().toNetwork(buffer);
                buffer.writeInt(input.getCount());
            }
            buffer.writeItemStack(recipe.getResultItem(RegistryAccess.EMPTY), false);
            buffer.writeUtf(recipe.getSpecial());
        }
    }

    public List<HandcraftingIngredient> getHandcraftingIngredients() {
        return inputs;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return output;
    }

    public String getSpecial() {
        return special;
    }
}
