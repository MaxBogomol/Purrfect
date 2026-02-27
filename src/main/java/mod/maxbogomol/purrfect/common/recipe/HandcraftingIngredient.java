package mod.maxbogomol.purrfect.common.recipe;

import net.minecraft.world.item.crafting.Ingredient;

public class HandcraftingIngredient {
    public final Ingredient ingredient;
    public int count;

    public HandcraftingIngredient(Ingredient ingredient, int count) {
        this.ingredient = ingredient;
        this.count = count;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public int getCount() {
        return count;
    }

    public void remove(int count) {
        this.count = this.count - count;
    }

    public boolean isEmpty() {
        return count <= 0;
    }
}
