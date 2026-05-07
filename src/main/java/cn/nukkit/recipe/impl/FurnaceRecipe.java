package cn.nukkit.recipe.impl;

import cn.nukkit.item.Item;
import cn.nukkit.recipe.RecipeType;
import cn.nukkit.recipe.SmeltingRecipe;
import cn.nukkit.registry.RecipeRegistry;
import lombok.Getter;

import java.util.UUID;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public class FurnaceRecipe implements SmeltingRecipe {

    private String recipeId;

    private UUID id;

    protected final Item output;

    protected Item ingredient;

    @Getter
    private final int networkId;

    public FurnaceRecipe(Item result, Item ingredient) {
        this(null, result, ingredient);
    }

    public FurnaceRecipe(String recipeId, Item result, Item ingredient) {
        this.output = result.clone();
        this.ingredient = ingredient;
        this.recipeId = recipeId;
        this.networkId = ++RecipeRegistry.NEXT_NETWORK_ID;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public Item getInput() {
        return this.ingredient.clone();
    }

    @Override
    public Item getResult() {
        return this.output.clone();
    }

    @Override
    public RecipeType getType() {
        return this.ingredient.hasMeta() ? RecipeType.FURNACE_DATA : RecipeType.FURNACE;
    }

    public void setInput(Item item) {
        this.ingredient = item.clone();
    }

    public void setId(UUID id) {
        this.id = id;
        if (this.recipeId == null) {
            this.recipeId = this.id.toString();
        }
    }

    @Override
    public boolean isValidRecipe(int protocol) {
        return true;
    }
}
