package cn.nukkit.recipe.impl;

import cn.nukkit.item.Item;
import cn.nukkit.recipe.RecipeType;

public class BlastFurnaceRecipe extends FurnaceRecipe {

    public BlastFurnaceRecipe(Item result, Item ingredient) {
        super(result, ingredient);
    }

    public BlastFurnaceRecipe(String recipeId, Item result, Item ingredient) {
        super(recipeId, result, ingredient);
    }

    @Override
    public RecipeType getType() {
        return this.ingredient.hasMeta() ? RecipeType.BLAST_FURNACE_DATA : RecipeType.BLAST_FURNACE;
    }
}
