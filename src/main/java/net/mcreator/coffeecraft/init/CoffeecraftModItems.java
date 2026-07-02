
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.coffeecraft.init;

import net.mcreator.coffeecraft.block.CoffeeBlock;
import net.mcreator.coffeecraft.block.ExpressoBlocBlock;
import net.mcreator.coffeecraft.item.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.BlockItem;

import net.mcreator.coffeecraft.block.display.RoasterAnimatedDisplayItem;
import net.mcreator.coffeecraft.block.display.GrinderAnimDisplayItem;
import net.mcreator.coffeecraft.CoffeecraftMod;

public class CoffeecraftModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, CoffeecraftMod.MODID);
	public static final RegistryObject<Item> COFFEE_CHERRY = REGISTRY.register("coffee_cherry", () -> new CoffeeCherryItem());
	public static final RegistryObject<Item> COFFEE_BEAN = REGISTRY.register("coffee_bean", () -> new CoffeeBeanItem());
	public static final RegistryObject<Item> COFFEE_BEAN_ROASTED = REGISTRY.register("coffee_bean_roasted", () -> new CoffeeBeanRoastedItem());
	public static final RegistryObject<Item> COFFEE_POWDER = REGISTRY.register("coffee_powder", () -> new CoffeePowderItem());
	public static final RegistryObject<Item> COFFEE_MAKER_BLACK_EMPTY = block(CoffeecraftModBlocks.COFFEE_MAKER_BLACK_EMPTY);
	public static final RegistryObject<Item> COFFEE_MAKER_WHITE_EMPTY = block(CoffeecraftModBlocks.COFFEE_MAKER_WHITE_EMPTY);
	public static final RegistryObject<Item> GRINDER_ANIM = REGISTRY.register(CoffeecraftModBlocks.GRINDER_ANIM.getId().getPath(), () -> new GrinderAnimDisplayItem(CoffeecraftModBlocks.GRINDER_ANIM.get(), new Item.Properties()));
	public static final RegistryObject<Item> ROASTER_ANIMATED = REGISTRY.register(CoffeecraftModBlocks.ROASTER_ANIMATED.getId().getPath(), () -> new RoasterAnimatedDisplayItem(CoffeecraftModBlocks.ROASTER_ANIMATED.get(), new Item.Properties()));
	// 註冊咖啡皆用新法
	public static final RegistryObject<Item> SHORT_MUG = REGISTRY.register("short_mug", () ->
			CoffeeItem.create(new FoodProperties.Builder().nutrition(1).saturationMod(0f).alwaysEat()
			.effect(()->new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 0),1.0F).build()
					, CoffeecraftModBlocks.EXPRESSO_BLOC));
	public static final RegistryObject<Item> LONG_MUG = REGISTRY.register("long_mug", () ->
			CoffeeItem.create(new FoodProperties.Builder().nutrition(0).saturationMod(0f).alwaysEat()
					.effect(()->new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 1),1.0F).build(),
					CoffeecraftModBlocks.LUNGO_BLOC));
	public static final RegistryObject<Item> COFFEE_SWEET_EXPRESSO = REGISTRY.register("coffee_sweet_expresso", () ->
			CoffeeItem.create(new FoodProperties.Builder().nutrition(0).saturationMod(0f).alwaysEat()
					.effect(()->new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 0),1.0F)
					.effect(()->new MobEffectInstance(MobEffects.NIGHT_VISION, 3600, 0),1.0F).build(),
					CoffeecraftModBlocks.COFFEE_SWEET_EXPRESSO_BLOC));
	public static final RegistryObject<Item> COFFEE_SWEET_LUNGO = REGISTRY.register("coffee_sweet_lungo", () ->
			CoffeeItem.create(new FoodProperties.Builder().nutrition(0).saturationMod(0f).alwaysEat()
					.effect(()->new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 1),1.0F)
					.effect(()->new MobEffectInstance(MobEffects.NIGHT_VISION, 3600, 0),1.0F).build(),
					CoffeecraftModBlocks.COFFEE_SWEET_LUNGO_BLOC));
	public static final RegistryObject<Item> COFFEE_CAPPUCCINO = REGISTRY.register("coffee_cappuccino", () ->
			CoffeeItem.create(new FoodProperties.Builder().nutrition(6).saturationMod(0f).alwaysEat()
					.effect(()->new MobEffectInstance(MobEffects.HEAL, 20, 0),1.0F).build(),
					CoffeecraftModBlocks.COFFEE_CAPPUCCINO_BLOC));
	public static final RegistryObject<Item> COFFEE_MOCHA = REGISTRY.register("coffee_mocha", () ->
			CoffeeItem.create(new FoodProperties.Builder().nutrition(6).saturationMod(0f).alwaysEat()
							.effect(()->new MobEffectInstance(MobEffects.HEAL, 20, 0),1.0F)
							.effect(()->new MobEffectInstance(MobEffects.JUMP, 2400, 1),1.0F).build(),
					CoffeecraftModBlocks.COFFEE_MOCHA_BLOC));
	public static final RegistryObject<Item> COFFEE_EGG = REGISTRY.register("coffee_egg", () ->
			CoffeeItem.create(new FoodProperties.Builder().nutrition(6).saturationMod(0f).alwaysEat()
							.effect(()->new MobEffectInstance(MobEffects.SATURATION, 4800, 0),1.0F).build(),
					CoffeecraftModBlocks.COFFEE_EGG_BLOC));
	public static final RegistryObject<Item> COFFEE_ICED = REGISTRY.register("coffee_iced", () ->
			CoffeeItem.create(new FoodProperties.Builder().nutrition(1).saturationMod(0f).alwaysEat()
							.effect(()->new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3600, 1),1.0F).build(),
					CoffeecraftModBlocks.COFFEE_ICED_BLOC));
	public static final RegistryObject<Item> COFFEE_CARROT = REGISTRY.register("coffee_carrot", () ->
			CoffeeItem.create(new FoodProperties.Builder().nutrition(6).saturationMod(0f).alwaysEat()
							.effect(()->new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0),1.0F)
							.effect(()->new MobEffectInstance(MobEffects.SATURATION, 3600, 0),1.0F).build(),
					CoffeecraftModBlocks.COFFEE_CARROT_BLOC));
	public static final RegistryObject<Item> COFFEE_HONEY = REGISTRY.register("coffee_honey", () ->
			CoffeeItem.create(new FoodProperties.Builder().nutrition(6).saturationMod(0f).alwaysEat()
							.effect(()->new MobEffectInstance(MobEffects.REGENERATION, 3600, 0),1.0F).build(),
					CoffeecraftModBlocks.COFFEE_HONEY_BLOC));
	public static final RegistryObject<Item> COFFEE_NETHER = REGISTRY.register("coffee_nether",()->
			CoffeeItem.create(new FoodProperties.Builder().nutrition(6).saturationMod(0f).alwaysEat()
							.effect(()->new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3600, 0),1.0F).build(),
					Rarity.UNCOMMON,
					CoffeecraftModBlocks.COFFEE_NETHER_BLOC));
	public static final RegistryObject<Item> END_COFFEE = REGISTRY.register("end_coffee", () ->
			CoffeeItem.create(new FoodProperties.Builder().nutrition(6).saturationMod(0f).alwaysEat()
					.effect(()->new MobEffectInstance(MobEffects.LEVITATION, 400, 1),1.0F)
					.effect(()->new MobEffectInstance(MobEffects.SLOW_FALLING, 400, 1),1.0F).build(),
					Rarity.RARE,
					CoffeecraftModBlocks.END_COFFEE_BLOC));
	public static final RegistryObject<Item> CROISSANT = REGISTRY.register("croissant", () -> new CroissantItem());
	public static final RegistryObject<Item> COFFEE_PANCARTE = block(CoffeecraftModBlocks.COFFEE_PANCARTE);
	public static final RegistryObject<Item> BAG_COFFEE_ROASTED = block(CoffeecraftModBlocks.BAG_COFFEE_ROASTED);
	public static final RegistryObject<Item> BAG_COFFEE_BEAN = block(CoffeecraftModBlocks.BAG_COFFEE_BEAN);
	public static final RegistryObject<Item> BAG_COFFEE_POWDER = block(CoffeecraftModBlocks.BAG_COFFEE_POWDER);
	public static final RegistryObject<Item> BARISTA_CHESTPLATE = REGISTRY.register("barista_chestplate", () -> new BaristaItem.Chestplate());
	public static final RegistryObject<Item> BARISTA_SMALL_CHESTPLATE = REGISTRY.register("barista_small_chestplate", () -> new BaristaSmallItem.Chestplate());
	public static final RegistryObject<Item> COFFEE_FLUID_BUCKET = REGISTRY.register("coffee_fluid_bucket", () -> new CoffeeFluidItem());
	public static final RegistryObject<Item> TERRACOTTA_MUG = block(CoffeecraftModBlocks.TERRACOTTA_MUG);
	public static final RegistryObject<Item> WHITE_MUG = block(CoffeecraftModBlocks.WHITE_MUG);
	public static final RegistryObject<Item> BLACK_MUG = block(CoffeecraftModBlocks.BLACK_MUG);
	public static final RegistryObject<Item> BLUE_MUG = block(CoffeecraftModBlocks.BLUE_MUG);
	public static final RegistryObject<Item> BROWN_MUG = block(CoffeecraftModBlocks.BROWN_MUG);
	public static final RegistryObject<Item> CYAN_MUG = block(CoffeecraftModBlocks.CYAN_MUG);
	public static final RegistryObject<Item> GRAY_MUG = block(CoffeecraftModBlocks.GRAY_MUG);
	public static final RegistryObject<Item> GREEN_MUG = block(CoffeecraftModBlocks.GREEN_MUG);
	public static final RegistryObject<Item> LIGHT_BLUE_MUG = block(CoffeecraftModBlocks.LIGHT_BLUE_MUG);
	public static final RegistryObject<Item> LIGHT_GRAY_MUG = block(CoffeecraftModBlocks.LIGHT_GRAY_MUG);
	public static final RegistryObject<Item> LIME_MUG = block(CoffeecraftModBlocks.LIME_MUG);
	public static final RegistryObject<Item> MAGENTA_MUG = block(CoffeecraftModBlocks.MAGENTA_MUG);
	public static final RegistryObject<Item> ORANGE_MUG = block(CoffeecraftModBlocks.ORANGE_MUG);
	public static final RegistryObject<Item> PINK_MUG = block(CoffeecraftModBlocks.PINK_MUG);
	public static final RegistryObject<Item> PURPLE_MUG = block(CoffeecraftModBlocks.PURPLE_MUG);
	public static final RegistryObject<Item> RED_MUG = block(CoffeecraftModBlocks.RED_MUG);
	public static final RegistryObject<Item> YELLOW_MUG = block(CoffeecraftModBlocks.YELLOW_MUG);
	public static final RegistryObject<Item> COFFEE_BOX_BLOC = block(CoffeecraftModBlocks.COFFEE_BOX_BLOC);
	public static final RegistryObject<Item> GRINDER = block(CoffeecraftModBlocks.GRINDER);
	public static final RegistryObject<Item> ROASTER = block(CoffeecraftModBlocks.ROASTER);
	public static final RegistryObject<Item> COFFEE_PLANT_STAGE_0 = block(CoffeecraftModBlocks.COFFEE_PLANT_STAGE_0);
	public static final RegistryObject<Item> COFFEE_PLANT_STAGE_1 = block(CoffeecraftModBlocks.COFFEE_PLANT_STAGE_1);
	public static final RegistryObject<Item> TERRACOTTA_MUG_2 = block(CoffeecraftModBlocks.TERRACOTTA_MUG_2);
	public static final RegistryObject<Item> TERRACOTTA_MUG_3 = block(CoffeecraftModBlocks.TERRACOTTA_MUG_3);
	public static final RegistryObject<Item> WHITE_MUG_2 = block(CoffeecraftModBlocks.WHITE_MUG_2);
	public static final RegistryObject<Item> WHITE_MUG_3 = block(CoffeecraftModBlocks.WHITE_MUG_3);
	public static final RegistryObject<Item> BLACK_MUG_2 = block(CoffeecraftModBlocks.BLACK_MUG_2);
	public static final RegistryObject<Item> BLACK_MUG_3 = block(CoffeecraftModBlocks.BLACK_MUG_3);
	public static final RegistryObject<Item> BLUE_MUG_2 = block(CoffeecraftModBlocks.BLUE_MUG_2);
	public static final RegistryObject<Item> BLUE_MUG_3 = block(CoffeecraftModBlocks.BLUE_MUG_3);
	public static final RegistryObject<Item> BROWN_MUG_2 = block(CoffeecraftModBlocks.BROWN_MUG_2);
	public static final RegistryObject<Item> BROWN_MUG_3 = block(CoffeecraftModBlocks.BROWN_MUG_3);
	public static final RegistryObject<Item> CYAN_MUG_2 = block(CoffeecraftModBlocks.CYAN_MUG_2);
	public static final RegistryObject<Item> CYAN_MUG_3 = block(CoffeecraftModBlocks.CYAN_MUG_3);
	public static final RegistryObject<Item> GRAY_MUG_2 = block(CoffeecraftModBlocks.GRAY_MUG_2);
	public static final RegistryObject<Item> GRAY_MUG_3 = block(CoffeecraftModBlocks.GRAY_MUG_3);
	public static final RegistryObject<Item> GREEN_MUG_2 = block(CoffeecraftModBlocks.GREEN_MUG_2);
	public static final RegistryObject<Item> GREEN_MUG_3 = block(CoffeecraftModBlocks.GREEN_MUG_3);
	public static final RegistryObject<Item> LIGHT_BLUE_MUG_2 = block(CoffeecraftModBlocks.LIGHT_BLUE_MUG_2);
	public static final RegistryObject<Item> LIGHT_BLUE_MUG_3 = block(CoffeecraftModBlocks.LIGHT_BLUE_MUG_3);
	public static final RegistryObject<Item> LIGHT_GRAY_MUG_2 = block(CoffeecraftModBlocks.LIGHT_GRAY_MUG_2);
	public static final RegistryObject<Item> LIGHT_GRAY_MUG_3 = block(CoffeecraftModBlocks.LIGHT_GRAY_MUG_3);
	public static final RegistryObject<Item> LIME_MUG_2 = block(CoffeecraftModBlocks.LIME_MUG_2);
	public static final RegistryObject<Item> LIME_MUG_3 = block(CoffeecraftModBlocks.LIME_MUG_3);
	public static final RegistryObject<Item> MAGENTA_MUG_2 = block(CoffeecraftModBlocks.MAGENTA_MUG_2);
	public static final RegistryObject<Item> MAGENTA_MUG_3 = block(CoffeecraftModBlocks.MAGENTA_MUG_3);
	public static final RegistryObject<Item> ORANGE_MUG_2 = block(CoffeecraftModBlocks.ORANGE_MUG_2);
	public static final RegistryObject<Item> ORANGE_MUG_3 = block(CoffeecraftModBlocks.ORANGE_MUG_3);
	public static final RegistryObject<Item> PINK_MUG_2 = block(CoffeecraftModBlocks.PINK_MUG_2);
	public static final RegistryObject<Item> PINK_MUG_3 = block(CoffeecraftModBlocks.PINK_MUG_3);
	public static final RegistryObject<Item> PURPLE_MUG_2 = block(CoffeecraftModBlocks.PURPLE_MUG_2);
	public static final RegistryObject<Item> PURPLE_MUG_3 = block(CoffeecraftModBlocks.PURPLE_MUG_3);
	public static final RegistryObject<Item> RED_MUG_2 = block(CoffeecraftModBlocks.RED_MUG_2);
	public static final RegistryObject<Item> RED_MUG_3 = block(CoffeecraftModBlocks.RED_MUG_3);
	public static final RegistryObject<Item> YELLOW_MUG_2 = block(CoffeecraftModBlocks.YELLOW_MUG_2);
	public static final RegistryObject<Item> YELLOW_MUG_3 = block(CoffeecraftModBlocks.YELLOW_MUG_3);
	public static final RegistryObject<Item> COFFEE_MAKER_BLACK = block(CoffeecraftModBlocks.COFFEE_MAKER_BLACK);
	public static final RegistryObject<Item> COFFEE_MAKER_WHITE = block(CoffeecraftModBlocks.COFFEE_MAKER_WHITE);
	public static final RegistryObject<Item> COFFE_PLANT_STAGE_3_BOTTOM = block(CoffeecraftModBlocks.COFFE_PLANT_STAGE_3_BOTTOM);
	public static final RegistryObject<Item> COFFEE_PLANT_STAGE_3_TOP = block(CoffeecraftModBlocks.COFFEE_PLANT_STAGE_3_TOP);
	public static final RegistryObject<Item> COFFEE_PLANT_STAGE_4_BOTTOM = block(CoffeecraftModBlocks.COFFEE_PLANT_STAGE_4_BOTTOM);
	public static final RegistryObject<Item> COFFEE_PLANT_STAGE_4_TOP = block(CoffeecraftModBlocks.COFFEE_PLANT_STAGE_4_TOP);
	public static final RegistryObject<Item> COFFEE_PLANT_STAGE_5_BOTTOM = block(CoffeecraftModBlocks.COFFEE_PLANT_STAGE_5_BOTTOM);
	public static final RegistryObject<Item> COFFEE_PLANT_STAGE_5_TOP = block(CoffeecraftModBlocks.COFFEE_PLANT_STAGE_5_TOP);
	public static final RegistryObject<Item> COFFEE_PLANT_STAGE_6_BOTTOM = block(CoffeecraftModBlocks.COFFEE_PLANT_STAGE_6_BOTTOM);
	public static final RegistryObject<Item> COFFEE_PLANT_STAGE_6_TOP = block(CoffeecraftModBlocks.COFFEE_PLANT_STAGE_6_TOP);
	public static final RegistryObject<Item> COFFEE_PLANT = doubleBlock(CoffeecraftModBlocks.COFFEE_PLANT);
	public static final RegistryObject<Item> COFFEE_PLANT_STAGE_2 = block(CoffeecraftModBlocks.COFFEE_PLANT_STAGE_2);
	public static final RegistryObject<Item> COFFEE_CARROT_BLOC = block(CoffeecraftModBlocks.COFFEE_CARROT_BLOC);
	public static final RegistryObject<Item> EXPRESSO_BLOC = block(CoffeecraftModBlocks.EXPRESSO_BLOC);
	public static final RegistryObject<Item> LUNGO_BLOC = block(CoffeecraftModBlocks.LUNGO_BLOC);
	public static final RegistryObject<Item> END_COFFEE_BLOC = block(CoffeecraftModBlocks.END_COFFEE_BLOC);
	public static final RegistryObject<Item> COFFEE_EGG_BLOC = block(CoffeecraftModBlocks.COFFEE_EGG_BLOC);
	public static final RegistryObject<Item> COFFEE_ICED_BLOC = block(CoffeecraftModBlocks.COFFEE_ICED_BLOC);
	public static final RegistryObject<Item> COFFEE_NETHER_BLOC = block(CoffeecraftModBlocks.COFFEE_NETHER_BLOC);
	public static final RegistryObject<Item> COFFEE_HONEY_BLOC = block(CoffeecraftModBlocks.COFFEE_HONEY_BLOC);
	public static final RegistryObject<Item> COFFEE_MOCHA_BLOC = block(CoffeecraftModBlocks.COFFEE_MOCHA_BLOC);
	public static final RegistryObject<Item> COFFEE_CAPPUCCINO_BLOC = block(CoffeecraftModBlocks.COFFEE_CAPPUCCINO_BLOC);
	public static final RegistryObject<Item> CROISSANT_BLOC = block(CoffeecraftModBlocks.CROISSANT_BLOC);
	public static final RegistryObject<Item> COFFEE_SWEET_LUNGO_BLOC = block(CoffeecraftModBlocks.COFFEE_SWEET_LUNGO_BLOC);
	public static final RegistryObject<Item> COFFEE_SWEET_EXPRESSO_BLOC = block(CoffeecraftModBlocks.COFFEE_SWEET_EXPRESSO_BLOC);

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
	}
}
