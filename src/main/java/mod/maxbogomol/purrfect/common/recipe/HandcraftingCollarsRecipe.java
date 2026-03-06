package mod.maxbogomol.purrfect.common.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.api.furry.CollarPart;
import mod.maxbogomol.purrfect.api.furry.CollarPartUtil;
import mod.maxbogomol.purrfect.registry.common.PurrfectRecipes;
import mod.maxbogomol.purrfect.registry.common.item.PurrfectItems;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class HandcraftingCollarsRecipe implements Recipe<Container> {
    public static ResourceLocation TYPE_ID = new ResourceLocation(Purrfect.MOD_ID, "handcrafting_collars");
    private final ResourceLocation id;
    private final List<HandcraftingIngredient> inputs;
    private CollarPart collarPartColor = null;
    private CollarPart collarPartAccessory = null;
    private CollarPart collarPartDecoration = null;

    public HandcraftingCollarsRecipe(ResourceLocation id, HandcraftingIngredient... inputs) {
        this.id = id;
        this.inputs = List.of(inputs);
    }

    public HandcraftingCollarsRecipe setCollarPartColor(CollarPart collarPart) {
        this.collarPartColor = collarPart;
        return this;
    }

    public HandcraftingCollarsRecipe setCollarPartAccessory(CollarPart collarPart) {
        this.collarPartAccessory = collarPart;
        return this;
    }

    public HandcraftingCollarsRecipe setCollarPartDecoration(CollarPart collarPart) {
        this.collarPartDecoration = collarPart;
        return this;
    }

    @Override
    public boolean matches(Container container, Level level) {
        return matches(inputs, container);
    }

    public static boolean matches(List<HandcraftingIngredient> inputs, Container container) {
        List<HandcraftingIngredient> ingredientsMissing = new ArrayList<>();
        for (HandcraftingIngredient ingredient : inputs) {
            ingredientsMissing.add(new HandcraftingIngredient(ingredient.getIngredient(), ingredient.getCount()));
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
        return PurrfectRecipes.HANDCRAFTING_COLLARS_SERIALIZER.get();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public boolean isSpecial(){
        return true;
    }

    public static class Serializer implements RecipeSerializer<HandcraftingCollarsRecipe> {

        @Override
        public HandcraftingCollarsRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            CollarPart collarPartColor = null;
            CollarPart collarPartAccessory = null;
            CollarPart collarPartDecoration = null;

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            List<HandcraftingIngredient> inputs = new ArrayList<>();
            for (JsonElement e : ingredients) {
                JsonObject i = GsonHelper.getAsJsonObject(e.getAsJsonObject(), "ingredient");
                Ingredient ingredient = Ingredient.fromJson(i);
                int count = GsonHelper.getAsInt(e.getAsJsonObject(), "count", 1);
                inputs.add(new HandcraftingIngredient(ingredient, count));
            }

            if (json.has("color_part")) {
                collarPartColor = CollarPartUtil.deserializeCollarPartColor(GsonHelper.getAsJsonObject(json, "color_part"));
            }
            if (json.has("accessory_part")) {
                collarPartAccessory = CollarPartUtil.deserializeCollarPartAccessory(GsonHelper.getAsJsonObject(json, "accessory_part"));
            }
            if (json.has("decoration_part")) {
                collarPartDecoration = CollarPartUtil.deserializeCollarPartDecoration(GsonHelper.getAsJsonObject(json, "decoration_part"));
            }

            return new HandcraftingCollarsRecipe(recipeId, inputs.toArray(new HandcraftingIngredient[0])).setCollarPartColor(collarPartColor).setCollarPartAccessory(collarPartAccessory).setCollarPartDecoration(collarPartDecoration);
        }

        @Nullable
        @Override
        public HandcraftingCollarsRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            HandcraftingIngredient[] inputs = new HandcraftingIngredient[buffer.readInt()];
            for (int i = 0; i < inputs.length; i++) {
                Ingredient ingredient = Ingredient.fromNetwork(buffer);
                int count = buffer.readInt();
                inputs[i] = new HandcraftingIngredient(ingredient, count);
            }

            CollarPart collarPartColor = CollarPartUtil.collarPartColorFromNetwork(buffer);
            CollarPart collarPartAccessory = CollarPartUtil.collarPartAccessoryFromNetwork(buffer);
            CollarPart collarPartDecoration = CollarPartUtil.collarPartDecorationFromNetwork(buffer);

            return new HandcraftingCollarsRecipe(recipeId, inputs).setCollarPartColor(collarPartColor).setCollarPartAccessory(collarPartAccessory).setCollarPartDecoration(collarPartDecoration);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, HandcraftingCollarsRecipe recipe) {
            buffer.writeInt(recipe.getHandcraftingIngredients().size());
            for (HandcraftingIngredient input : recipe.getHandcraftingIngredients()) {
                input.getIngredient().toNetwork(buffer);
                buffer.writeInt(input.getCount());
            }
            CollarPartUtil.collarPartToNetwork(recipe.getCollarPartColor(), buffer);
            CollarPartUtil.collarPartToNetwork(recipe.getCollarPartAccessory(), buffer);
            CollarPartUtil.collarPartToNetwork(recipe.getCollarPartDecoration(), buffer);
        }
    }

    public List<HandcraftingIngredient> getHandcraftingIngredients() {
        return inputs;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return ItemStack.EMPTY;
    }

    public CollarPart getCollarPartColor() {
        return collarPartColor;
    }

    public CollarPart getCollarPartAccessory() {
        return collarPartAccessory;
    }

    public CollarPart getCollarPartDecoration() {
        return collarPartDecoration;
    }

    public boolean hasCollarPartColor() {
        return collarPartColor != null;
    }

    public boolean hasCollarPartAccessory() {
        return collarPartAccessory != null;
    }

    public boolean hasCollarPartDecoration() {
        return collarPartDecoration != null;
    }
}
