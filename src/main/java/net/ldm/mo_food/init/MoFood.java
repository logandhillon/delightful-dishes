package net.ldm.mo_food.init;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.ldm.mo_food.block.LettuceBlock;
import net.ldm.mo_food.block.PancakesBlock;
import net.ldm.mo_food.block.SweetPotatoesBlock;
import net.ldm.mo_food.item.DrinkableItem;
import net.ldm.mo_food.item.ShinyItem;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class MoFood implements ModInitializer {
    public static final String MOD_ID = "mo_food";

    //TODO: Go through every item until I find what is crashing the game.
    //TODO: Add BlockItems for every Block
    public static final Item OMELET = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "omelet"), new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(6).saturationModifier(6f).build())));
    public static final Item FLOUR = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "flour"), new Item(new FabricItemSettings()));
    public static final Block PANCAKES = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "pancakes"), new PancakesBlock(FabricBlockSettings.of(Material.CAKE).strength(0.5F).sounds(BlockSoundGroup.WOOL)));
    public static final BlockItem PANCAKES_BLOCK_ITEM = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pancakes"), new BlockItem(PANCAKES, new FabricItemSettings()));
    public static final Item RAW_BACON = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bacon"), new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 60 * 20, 3), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 15 * 20, 2), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 15 * 20, 1), 1.0f).build())));
    public static final Item COOKED_BACON = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cooked_bacon"), new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(1.5f).snack().build())));
    public static final Item MUFFIN = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "muffin"), new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(6).saturationModifier(1.2f).build())));
    public static final Item GOLDEN_MUFFIN = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "golden_muffin"), new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).food(new FoodComponent.Builder().hunger(6).saturationModifier(14.4f).build())));
    public static final Item ENCHANTED_MUFFIN = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "enchanted_golden_muffin"), new ShinyItem(new FabricItemSettings().rarity(Rarity.RARE).food(new FoodComponent.Builder().hunger(6).alwaysEdible().saturationModifier(9.6f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 10 * 20, 1), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 120 * 20, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 15 * 20, 1), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 15 * 20, 1), 1.0f).build())));
    public static final Item BAKED_SWEET_POTATO = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "baked_sweet_potato"), new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(5).saturationModifier(6.0f).build())));
    public static final Block SWEET_POTATOES =  Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "sweet_potatoes"), new SweetPotatoesBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));
    public static final Item SWEET_POTATO = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sweet_potato"), new BlockItem(SWEET_POTATOES, (new FabricItemSettings()).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.8f).build())));
    public static final Item SALTY_POTATO = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "salty_potato"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(7).saturationModifier(5.8f).build())));
    public static final Block SALT_BLOCK = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "salt_block"), new Block(FabricBlockSettings.of(Material.AGGREGATE).strength(0.5f).sounds(BlockSoundGroup.SAND)));
    public static final BlockItem SALT_BLOCK_ITEM = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "salt_block"), new BlockItem(SALT_BLOCK, new FabricItemSettings()));
    public static final Item SALT = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "salt"), new Item(new FabricItemSettings()));
    public static final Item SUPER_SALTY_POTATO = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "super_salty_potato"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(10).saturationModifier(0.6f).build())));
    public static final Item RAW_CHICKEN_NUGGET = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "chicken_nuggets"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.8f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 30 * 20, 0), 0.3f).build())));
    public static final Item COOKED_CHICKEN_NUGGET = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cooked_chicken_nuggets"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).snack().build())));
    //public static final Block TOMATOES =  Registry.register(Registries.ITEM, new Identifier(MOD_ID, "tomato"), new TomatoesBlock(FabricBlockSettings.of(Material.PLANT).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)));
    public static final Block LETTUCE_CROP =  Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "lettuce"), new LettuceBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));
    public static final Item LETTUCE = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "lettuce"), new BlockItem(LETTUCE_CROP, (new FabricItemSettings()).food(new FoodComponent.Builder().hunger(1).saturationModifier(1.2f).build())));

    public static final Item PIZZA_DOUGH = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pizza_dough"), new Item(new FabricItemSettings()));
    public static final Item CHEESE = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cheese"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(5).saturationModifier(6.2f).build())));
    public static final Item PIZZA_BREAD = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pizza_bread"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(8).saturationModifier(8.0f).build())));
    //public static final Block CHEESE_PIZZA =  Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cheese_pizza"), new CheesePizza(FabricBlockSettings.of(Material.CAKE).strength(0.5F).noCollision().sounds(BlockSoundGroup.WOOL)));
    //public static final Block PEPPERONI_PIZZA =  Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pepperoni_pizza"), new PepperoniPizza(FabricBlockSettings.of(Material.CAKE).strength(0.5F).noCollision().sounds(BlockSoundGroup.WOOL)));
    public static final Item RAW_CHEESE_PIZZA = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "raw_cheese_pizza"), new Item(new FabricItemSettings()));
    public static final Item RAW_PEPPERONI_PIZZA = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "raw_pepperoni_pizza"), new Item(new FabricItemSettings()));
    public static final Item MILK = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "milk"), new DrinkableItem(new FabricItemSettings()));
    public static final Item PEPPERONI = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "pepperoni"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(1).saturationModifier(1.0f).snack().build())));
    public static final Item RAW_WOLF_MEAT = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "wolf_meat"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().meat().hunger(2).saturationModifier(1.2f).build())));
    public static final Item COOKED_WOLF_MEAT = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cooked_wolf_meat"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().meat().hunger(6).saturationModifier(9.6f).build())));
    public static final Item RAW_HORSE_MEAT = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "horse_meat"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().meat().hunger(3).saturationModifier(1.8f).build())));
    public static final Item COOKED_HORSE_MEAT = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cooked_horse_meat"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().meat().hunger(8).saturationModifier(12.8f).build())));
    public static final Item RAW_CAT_STEAK = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cat_steak"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().meat().hunger(2).saturationModifier(1.2f).build())));
    public static final Item COOKED_CAT_STEAK = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cooked_cat_steak"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().meat().hunger(6).saturationModifier(9.6f).build())));
    public static final Item RAW_CALAMARI = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "calamari"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().meat().hunger(2).saturationModifier(0.4f).build())));
    public static final Item COOKED_CALAMARI = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cooked_calamari"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().meat().hunger(5).saturationModifier(6f).build())));
    public static final Item OLIVES = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "olives"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().snack().hunger(1).saturationModifier(1.2f).build())));
    public static final Item LEMON = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "lemon"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(1).saturationModifier(1.2f).build())));
    public static final Item OLIVE_OIL = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "olive_oil"), new DrinkableItem(new FabricItemSettings()));
    public static final Item FRENCH_FRIES = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "french_fries"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(6).saturationModifier(7.2f).build())));
    public static final Item LEMON_JUICE = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "lemon_juice"), new DrinkableItem(new FabricItemSettings()));
    public static final Item BUTTER = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "butter"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(4).saturationModifier(1.2f).build())));
    public static final Item RAW_BEEF_PATTY = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "beef_patty"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(3).saturationModifier(1.8f).build())));
    public static final Item COOKED_BEEF_PATTY = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cooked_beef_patty"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(7).saturationModifier(11.4f).build())));
    public static final Item DETOXIFIED_FLESH = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "detoxified_flesh"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.25f).build())));
    public static final Block GARLIC_CROP =  Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "garlic"), new LettuceBlock(FabricBlockSettings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));
    public static final Item GARLIC = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "lettuce"), new BlockItem(GARLIC_CROP, (new FabricItemSettings()).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.7f).snack().build())));
    public static final Item RAW_GARLIC_BREAD = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "garlic_bread"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(3).saturationModifier(4.6f).build())));
    public static final Item BAKED_GARLIC_BREAD = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "baked_garlic_bread"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(8).saturationModifier(9.6f).build())));
    public static final Item TOAST = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "toast"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(2).saturationModifier(2.0f).build())));
    public static final Item GARLIC_TOAST = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "garlic_bread_slice"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(3).saturationModifier(3.2f).build())));
    public static final Item BREADSTICKS = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "breadsticks"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.5f).build())));
    public static final Item GARLIC_BREADSTICKS = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "garlic_breadsticks"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.8f).build())));
    public static final Item BANANA = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "banana"), new Item((new FabricItemSettings()).food(new FoodComponent.Builder().hunger(4).saturationModifier(2.8f).build())));

    public static final SwordItem STONE_KNIFE = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "stone_knife"), new SwordItem(ToolMaterials.STONE, 1, -2.0f, (new FabricItemSettings()).recipeRemainder(MoFood.STONE_KNIFE)));
    public static final SwordItem IRON_KNIFE = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "iron_knife"), new SwordItem(ToolMaterials.IRON, 1, -2.0f, (new FabricItemSettings()).recipeRemainder(MoFood.IRON_KNIFE)));
    public static final SwordItem GOLDEN_KNIFE = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "golden_knife"), new SwordItem(ToolMaterials.GOLD, 1, -2.0f, (new FabricItemSettings()).recipeRemainder(MoFood.GOLDEN_KNIFE)));
    public static final SwordItem DIAMOND_KNIFE = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "diamond_knife"), new SwordItem(ToolMaterials.DIAMOND, 1, -2.0f, (new FabricItemSettings()).recipeRemainder(MoFood.DIAMOND_KNIFE)));
    public static final SwordItem NETHERITE_KNIFE = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "netherite_knife"), new SwordItem(ToolMaterials.NETHERITE, 1, -2.0f, (new FabricItemSettings()).recipeRemainder(MoFood.NETHERITE_KNIFE)));

    @Override
    public void onInitialize() {
        //TODO: Add all items into creative tabs. (ITEMS WILL NOT LOAD WITHOUT THIS)
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(OMELET);
            entries.add(RAW_BACON);
            entries.add(COOKED_BACON);
            entries.add(MUFFIN);
            entries.add(GOLDEN_MUFFIN);
            entries.add(ENCHANTED_MUFFIN);
            entries.add(SWEET_POTATO);
            entries.add(BAKED_SWEET_POTATO);
            entries.add(SALTY_POTATO);
            entries.add(SUPER_SALTY_POTATO);
            entries.add(RAW_CHICKEN_NUGGET);
            entries.add(COOKED_CHICKEN_NUGGET);
            entries.add(LETTUCE);
            entries.add(PIZZA_DOUGH);
            entries.add(CHEESE);
            entries.add(PIZZA_BREAD);
            entries.add(RAW_CHEESE_PIZZA);
            entries.add(RAW_PEPPERONI_PIZZA);
            entries.add(PEPPERONI);
            entries.add(RAW_WOLF_MEAT);
            entries.add(COOKED_WOLF_MEAT);
            entries.add(RAW_HORSE_MEAT);
            entries.add(COOKED_HORSE_MEAT);
            entries.add(RAW_CAT_STEAK);
            entries.add(COOKED_CAT_STEAK);
            entries.add(RAW_CALAMARI);
            entries.add(COOKED_CALAMARI);
            entries.add(OLIVES);
            entries.add(LEMON);
            entries.add(FRENCH_FRIES);
            entries.add(BUTTER);
            entries.add(RAW_BEEF_PATTY);
            entries.add(COOKED_BEEF_PATTY);
            entries.add(DETOXIFIED_FLESH);
            entries.add(RAW_GARLIC_BREAD);
            entries.add(BAKED_GARLIC_BREAD);
            entries.add(TOAST);
            entries.add(GARLIC_TOAST);
            entries.add(BREADSTICKS);
            entries.add(GARLIC_BREADSTICKS);
            entries.add(BANANA);
            entries.add(MILK);
            entries.add(OLIVE_OIL);
            entries.add(LEMON_JUICE);
            entries.add(PANCAKES_BLOCK_ITEM);
            entries.add(SWEET_POTATO);
            entries.add(LETTUCE);
            entries.add(GARLIC);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(FLOUR);
            entries.add(SALT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(STONE_KNIFE);
            entries.add(IRON_KNIFE);
            entries.add(GOLDEN_KNIFE);
            entries.add(DIAMOND_KNIFE);
            entries.add(NETHERITE_KNIFE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.add(SALT_BLOCK_ITEM));
    }
}