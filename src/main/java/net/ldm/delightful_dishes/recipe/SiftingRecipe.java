package net.ldm.delightful_dishes.recipe;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.ldm.delightful_dishes.core.BasicInventory;
import net.ldm.delightful_dishes.core.init.DelightfulDishes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public record SiftingRecipe(Ingredient ingredient, ItemStack result, Identifier id, float chance) implements Recipe<BasicInventory> {

    @Override
    public boolean matches(BasicInventory inventory, World world) {
        return ingredient.test(inventory.getStack(0));
    }

    @Override
    public ItemStack craft(BasicInventory inventory) {
        return this.getOutput().copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return result;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<SiftingRecipe> {
        public Type(){}
        public static final Type INSTANCE = new Type();
        public static final String ID = "sifting";
    }

    static class JsonFormat {
        JsonObject ingredient;
        String result;
        int min;
        int max;
        float chance;
    }

    public static class Serializer implements RecipeSerializer<SiftingRecipe> {
        Serializer(){}
        public static final Serializer INSTANCE = new Serializer();
        public static final Identifier ID = new Identifier(DelightfulDishes.MOD_ID, "sifting");

        @Override
        public SiftingRecipe read(Identifier id, JsonObject json) {
            JsonFormat recipeJson = new Gson().fromJson(json, JsonFormat.class);

            if (recipeJson.ingredient == null || recipeJson.result == null)
                throw new JsonSyntaxException("A required attribute is missing or null!");

            if (recipeJson.min == 0) recipeJson.min = 1;
            if (recipeJson.max == 0) recipeJson.max = recipeJson.min;
            if (recipeJson.chance < 0 || recipeJson.chance > 1) recipeJson.chance = 1;

            Ingredient input = Ingredient.fromJson(recipeJson.ingredient);
            Item output = Registries.ITEM.getOrEmpty(new Identifier(recipeJson.result)).orElseThrow(() ->
                    new JsonSyntaxException(String.format("Item '%s' does not exist", recipeJson.result)));

            ItemStack outputStack = new ItemStack(output, Random.create().nextBetween(recipeJson.min, recipeJson.max));

            return new SiftingRecipe(input, outputStack, id, recipeJson.chance);
        }

        @Override
        public SiftingRecipe read(Identifier id, PacketByteBuf buf) {
            Ingredient input = Ingredient.fromPacket(buf);
            ItemStack output = buf.readItemStack();
            return new SiftingRecipe(input, output, id, 1f);
        }

        @Override
        public void write(PacketByteBuf buf, SiftingRecipe recipe) {
            recipe.ingredient().write(buf);
            buf.writeItemStack(recipe.getOutput());
        }
    }
}
