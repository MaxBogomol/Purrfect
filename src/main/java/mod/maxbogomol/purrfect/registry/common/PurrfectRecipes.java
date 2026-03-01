package mod.maxbogomol.purrfect.registry.common;

import mod.maxbogomol.purrfect.Purrfect;
import mod.maxbogomol.purrfect.common.recipe.HandcraftingRecipe;
import mod.maxbogomol.purrfect.common.recipe.HandcraftingSortingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PurrfectRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Purrfect.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> RECIPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, Purrfect.MOD_ID);

    public static final RegistryObject<HandcraftingSortingRecipe.Serializer> HANDCRAFTING_SORTING_SERIALIZER = RECIPE_SERIALIZERS.register("handcrafting_sorting", HandcraftingSortingRecipe.Serializer::new);
    public static final RegistryObject<HandcraftingRecipe.Serializer> HANDCRAFTING_SERIALIZER = RECIPE_SERIALIZERS.register("handcrafting", HandcraftingRecipe.Serializer::new);

    public static RegistryObject<RecipeType<HandcraftingSortingRecipe>> HANDCRAFTING_SORTING = RECIPES.register("handcrafting_sorting", () -> RecipeType.simple(HandcraftingSortingRecipe.TYPE_ID));
    public static RegistryObject<RecipeType<HandcraftingRecipe>> HANDCRAFTING = RECIPES.register("handcrafting", () -> RecipeType.simple(HandcraftingRecipe.TYPE_ID));

    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZERS.register(eventBus);
        RECIPES.register(eventBus);
    }
}
