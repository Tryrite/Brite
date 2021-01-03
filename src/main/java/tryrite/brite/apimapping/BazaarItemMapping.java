package tryrite.brite.apimapping;

import java.util.HashMap;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

public class BazaarItemMapping {
	public static HashMap<String,Entry>itemMap = new HashMap<String,Entry>();
	public static HashMap<String,Entry>FarmingMap = new HashMap<String,Entry>();
	public static HashMap<String,Entry>miningMap = new HashMap<String,Entry>();
	public static HashMap<String,Entry>combatMap = new HashMap<String,Entry>();
	public static HashMap<String,Entry>woodAndFishesMap = new HashMap<String,Entry>();
	public static HashMap<String,Entry>odditiesMap = new HashMap<String,Entry>();
	
	

	static {
		FarmingMap.put("WHEAT", new Entry("WHEAT","wheat",new ItemStack(Items.wheat)));
		FarmingMap.put("ENCHANTED_BREAD",  new Entry("ENCHANTED_BREAD","Enchanted Bread",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.bread))));
		FarmingMap.put("HAY_BLOCK",  new Entry("HAY_BLOCK","hay block",new ItemStack(Blocks.hay_block)));
		FarmingMap.put("ENCHANTED_HAY_BLOCK",  new Entry("ENCHANTED_HAY_BLOCK","Enchanted Hay Block",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.hay_block))));
		FarmingMap.put("TIGHTLY_TIED_HAY_BALE",new Entry("TIGHTLY_TIED_HAY_BALE","Tightly Tied Hay Bale",BazaarItemMapping.getItemStackFromMeta("dedecf64-1ed4-3413-855f-0a38789cd63e","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjdjMzNjZDBjMTRiYTgzMGRhMTQ5OTA3ZjdhNmFhZTgzNWI2YTM1YWVhMDFlMGNlMDczZmIzYzU5Y2M0NjMyNiJ9fX0=")));

		FarmingMap.put("CARROT_ITEM", new Entry("CARROT_ITEM","Carrot",new ItemStack(Items.carrot)));
		FarmingMap.put("ENCHANTED_CARROT", new Entry("ENCHANTED_CARROT","Enchanted Carrot",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.carrot))));
		FarmingMap.put("ENCHANTED_CARROT_STICK", new Entry("ENCHANTED_CARROT_STICK","Enchanted Carrot On A Stick",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.carrot_on_a_stick))));
		FarmingMap.put("ENCHANTED_GOLDEN_CARROT", new Entry("ENCHANTED_GOLDEN_CARROT","Enchanted Golden Carrot",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.golden_carrot))));
		
		FarmingMap.put("POTATO_ITEM", new Entry("POTATO_ITEM","Potato",new ItemStack(Items.potato)));
		FarmingMap.put("ENCHANTED_POTATO", new Entry("ENCHANTED_POTATO","Enchanted Potato",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.potato))));
		FarmingMap.put("ENCHANTED_BAKED_POTATO", new Entry("ENCHANTED_BAKED_POTATO","Enchanted Baked Potato",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.baked_potato))));
		
		FarmingMap.put("PUMPKIN", new Entry("PUMPKIN","Pumpkin",new ItemStack(Blocks.pumpkin)));
		FarmingMap.put("ENCHANTED_PUMPKIN", new Entry("ENCHANTED_PUMPKIN","Enchanted Pumpkin",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.pumpkin))));
		FarmingMap.put("POLISHED_PUMPKIN", new Entry("POLISHED_PUMPKIN","Polished Pumpkin",BazaarItemMapping.getItemStackFromMeta("3508645c-9fd9-3501-b79c-d490f6c4d028","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGRiNzExZmY1MmVlZGRhNTljNDM0YmIwMzE2OTc2M2Q3YzQwYjViODkxMjc3NzhmZWFjZDYzYWE5NGRmYyJ9fX0=")));
		
		FarmingMap.put("MELON", new Entry("MELON","Melon",new ItemStack(Items.melon)));
		FarmingMap.put("ENCHANTED_MELON", new Entry("ENCHANTED_MELON","Enchanted Melon",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.melon))));
		FarmingMap.put("ENCHANTED_GLISTERING_MELON", new Entry("ENCHANTED_GLISTERING_MELON","Enchanted Glistering Melon",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.speckled_melon))));
		FarmingMap.put("ENCHANTED_MELON_BLOCK", new Entry("ENCHANTED_MELON_BLOCK","Enchanted Melon Block",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.melon_block))));
		
		FarmingMap.put("SEEDS", new Entry("SEEDS","Seeds",new ItemStack(Items.wheat_seeds)));
		FarmingMap.put("ENCHANTED_SEEDS", new Entry("ENCHANTED_SEEDS","Ench. Seeds",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.wheat_seeds))));
		
		FarmingMap.put("RED_MUSHROOM", new Entry("RED_MUSHROOM","Red Mushroom",new ItemStack(Blocks.red_mushroom)));
		FarmingMap.put("ENCHANTED_RED_MUSHROOM", new Entry("ENCHANTED_RED_MUSHROOM","Enchanted Red Mushroom",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.red_mushroom))));
		FarmingMap.put("HUGE_MUSHROOM_2", new Entry("HUGE_MUSHROOM_2","Red Mushroom Block",new ItemStack(Blocks.red_mushroom_block)));
		FarmingMap.put("ENCHANTED_HUGE_MUSHROOM_2", new Entry("ENCHANTED_HUGE_MUSHROOM_2","Enchanted Red Mushroom Block",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.red_mushroom_block))));
		
		FarmingMap.put("BROWN_MUSHROOM", new Entry("BROWN_MUSHROOM","Brown Mushroom",new ItemStack(Blocks.brown_mushroom)));
		FarmingMap.put("ENCHANTED_BROWN_MUSHROOM", new Entry("ENCHANTED_BROWN_MUSHROOM","Enchanted Brown Mushroom",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.brown_mushroom))));
		FarmingMap.put("HUGE_MUSHROOM_1", new Entry("HUGE_MUSHROOM_1","Brown Mushroom Block",new ItemStack(Blocks.brown_mushroom_block)));
		FarmingMap.put("ENCHANTED_HUGE_MUSHROOM_1", new Entry("ENCHANTED_HUGE_MUSHROOM_1","Enchanted Brown Mushroom Block",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.brown_mushroom_block))));
		
		FarmingMap.put("INK_SACK:3", new Entry("INK_SACK:3","Cocoa",new ItemStack(Items.dye,1,3)));
		FarmingMap.put("ENCHANTED_COCOA", new Entry("ENCHANTED_COCOA","Enchanted Cocoa",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.dye,1,3))));
		FarmingMap.put("ENCHANTED_COOKIE", new Entry("ENCHANTED_COOKIE","Enchanted Cookie",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.cookie))));
		
		FarmingMap.put("CACTUS", new Entry("CACTUS","Cactus",new ItemStack(Blocks.cactus)));
		FarmingMap.put("ENCHANTED_CACTUS_GREEN", new Entry("ENCHANTED_CACTUS_GREEN","Enchanted Cactus Green",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.dye,1,2))));//maybe this is how you set specific dyes idk
		FarmingMap.put("ENCHANTED_CACTUS", new Entry("ENCHANTED_CACTUS","Enchanted Cactus",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.cactus))));
		
		FarmingMap.put("SUGAR_CANE", new Entry("SUGAR_CANE","Sugar Cane",new ItemStack(Items.reeds)));
		FarmingMap.put("ENCHANTED_SUGAR", new Entry("ENCHANTED_SUGAR","Enchanted Sugar",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.sugar))));
		FarmingMap.put("ENCHANTED_PAPER", new Entry("ENCHANTED_PAPER","Enchanted Paper",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.paper))));
		FarmingMap.put("ENCHANTED_SUGAR_CANE", new Entry("ENCHANTED_SUGAR_CANE","Enchanted Sugar Cane",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.reeds))));
		
		FarmingMap.put("FEATHER", new Entry("FEATHER","Feather",new ItemStack(Items.feather)));
		FarmingMap.put("ENCHANTED_FEATHER", new Entry("ENCHANTED_FEATHER","Enchanted Feather",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.feather))));
		
		FarmingMap.put("LEATHER", new Entry("LEATHER","Leather",new ItemStack(Items.leather)));
		FarmingMap.put("ENCHANTED_LEATHER", new Entry("ENCHANTED_LEATHER","Enchanted Leather",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.leather))));
		FarmingMap.put("RAW_BEEF", new Entry("RAW_BEEF","Raw Beef",new ItemStack(Items.beef)));
		FarmingMap.put("ENCHANTED_RAW_BEEF", new Entry("ENCHANTED_RAW_BEEF","Enchanted Raw Beef",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.beef))));
		
		FarmingMap.put("PORK", new Entry("PORK","Pork",new ItemStack(Items.porkchop)));
		FarmingMap.put("ENCHANTED_PORK", new Entry("ENCHANTED_PORK","Enchanted Pork",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.porkchop))));
		FarmingMap.put("ENCHANTED_GRILLED_PORK", new Entry("ENCHANTED_GRILLED_PORK","Enchanted Grilled Pork",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.cooked_porkchop))));
		
		FarmingMap.put("RAW_CHICKEN", new Entry("RAW_CHICKEN","Raw Chicken",new ItemStack(Items.chicken)));
		FarmingMap.put("ENCHANTED_RAW_CHICKEN", new Entry("ENCHANTED_RAW_CHICKEN","Enchanted Raw Chicken",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.chicken))));
		FarmingMap.put("ENCHANTED_EGG", new Entry("ENCHANTED_EGG","Enchanted Egg",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.egg))));
		FarmingMap.put("ENCHANTED_CAKE", new Entry("ENCHANTED_CAKE","Enchanted Cake",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.cake))));
		FarmingMap.put("SUPER_EGG", new Entry("SUPER_EGG","Super Egg",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.spawn_egg,1,56))));//maybe
		
		FarmingMap.put("MUTTON", new Entry("MUTTON","Mutton",new ItemStack(Items.mutton)));
		FarmingMap.put("ENCHANTED_MUTTON", new Entry("ENCHANTED_MUTTON","Enchanted Button",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.mutton))));
		FarmingMap.put("ENCHANTED_COOKED_MUTTON", new Entry("ENCHANTED_COOKED_MUTTON","Enchanted Cooked Mutton",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.cooked_mutton))));
		
		FarmingMap.put("RABBIT", new Entry("RABBIT","Rabbit",new ItemStack(Items.rabbit)));
		FarmingMap.put("ENCHANTED_RABBIT", new Entry("ENCHANTED_RABBIT","Enchanted Rabbit",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.rabbit))));
		FarmingMap.put("RABBIT_FOOT", new Entry("RABBIT_FOOT","Rabbit Foot",new ItemStack(Items.rabbit_foot)));
		FarmingMap.put("ENCHANTED_RABBIT_FOOT", new Entry("ENCHANTED_RABBIT_FOOT","Enchanted Rabbit Foot",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.rabbit_foot))));
		FarmingMap.put("RABBIT_HIDE", new Entry("RABBIT_HIDE","Rabbit Hide",new ItemStack(Items.rabbit_hide)));
		FarmingMap.put("ENCHANTED_RABBIT_HIDE", new Entry("ENCHANTED_RABBIT_HIDE","Enchanted Rabbit Hide",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.rabbit_hide))));
		
		FarmingMap.put("NETHER_STALK", new Entry("NETHER_STALK","Nether Wart",new ItemStack(Items.rabbit)));
		FarmingMap.put("ENCHANTED_NETHER_STALK", new Entry("ENCHANTED_NETHER_STALK","Enchanted Nether Wart",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.rabbit))));
		FarmingMap.put("MUTANT_NETHER_STALK", new Entry("MUTANT_NETHER_STALK","Mutant Nether Wart",BazaarItemMapping.getItemStackFromMeta("94c29902-dee6-3e1a-ba2e-e13e2bc243a4","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTExYTNjZWM3YWFmOTA0MjEyY2NmOTNiYjY3YTNjYWYzZDY0OTc4M2JhOTBiOGI2MGJiNjNjNzY4N2ViMzlmIn19fQ==")));
		
		miningMap.put("COBBLESTONE", new Entry("COBBLESTONE","Cobblestone",new ItemStack(Blocks.cobblestone)));
		miningMap.put("ENCHANTED_COBBLESTONE", new Entry("ENCHANTED_COBBLESTONE","Enchanted Cobblestone",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.cobblestone))));
		
		miningMap.put("COAL", new Entry("COAL","Coal",new ItemStack(Items.coal)));
		miningMap.put("ENCHANTED_COAL", new Entry("ENCHANTED_COAL","Enchanted Coal",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.coal))));
		miningMap.put("ENCHANTED_CHARCOAL", new Entry("ENCHANTED_CHARCOAL","Enchanted Charcoal",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.coal,1,1))));//maybe
		miningMap.put("ENCHANTED_COAL_BLOCK", new Entry("ENCHANTED_COAL_BLOCK","Enchanted Coal Block",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.coal_block))));
		
		miningMap.put("IRON_INGOT", new Entry("IRON_INGOT","Iron Ingot",new ItemStack(Items.iron_ingot)));
		miningMap.put("ENCHANTED_IRON", new Entry("ENCHANTED_IRON","Enchanted Iron Ingot",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.iron_ingot))));
		miningMap.put("ENCHANTED_IRON_BLOCK", new Entry("ENCHANTED_IRON_BLOCK","Enchanted Iron Block",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.iron_block))));
		
		miningMap.put("GOLD_INGOT", new Entry("GOLD_INGOT","Gold Ingot",new ItemStack(Items.gold_ingot)));
		miningMap.put("ENCHANTED_GOLD", new Entry("ENCHANTED_GOLD","Enchanted Gold Ingot",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.gold_ingot))));
		miningMap.put("ENCHANTED_GOLD_BLOCK", new Entry("ENCHANTED_GOLD_BLOCK","Enchanted Gold Block",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.gold_block))));
		
		miningMap.put("DIAMOND", new Entry("DIAMOND","Diamond",new ItemStack(Items.diamond)));
		miningMap.put("ENCHANTED_DIAMOND", new Entry("ENCHANTED_DIAMOND","Enchanted Diamond",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.diamond))));
		miningMap.put("ENCHANTED_DIAMOND_BLOCK", new Entry("ENCHANTED_DIAMOND_BLOCK","Enchanted Diamond Block",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.diamond_block))));

		miningMap.put("INK_SACK:4", new Entry("INK_SACK:4","Lapis Lazuli",new ItemStack(Items.diamond)));
		miningMap.put("ENCHANTED_LAPIS_LAZULI", new Entry("ENCHANTED_LAPIS_LAZULI","Enchanted Lapis Lazuli",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.dye,1,4))));
		miningMap.put("ENCHANTED_LAPIS_LAZULI_BLOCK", new Entry("ENCHANTED_LAPIS_LAZULI_BLOCK","Enchanted Lapis Lazuli Block",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.lapis_block))));
		
		miningMap.put("EMERALD", new Entry("EMERALD","Emerald",new ItemStack(Items.emerald)));
		miningMap.put("ENCHANTED_EMERALD", new Entry("ENCHANTED_EMERALD","Enchanted Emerald",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.emerald))));
		miningMap.put("ENCHANTED_EMERALD_BLOCK", new Entry("ENCHANTED_EMERALD_BLOCK","Enchanted Emerald Block",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.emerald_block))));
		
		miningMap.put("REDSTONE", new Entry("REDSTONE","Redstone",new ItemStack(Items.redstone)));
		miningMap.put("ENCHANTED_REDSTONE", new Entry("ENCHANTED_REDSTONE","Enchanted Redstone",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.redstone))));
		miningMap.put("ENCHANTED_REDSTONE_BLOCK", new Entry("ENCHANTED_REDSTONE_BLOCK","Enchanted Redstone Block",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.redstone_block))));
		
		miningMap.put("QUARTZ", new Entry("QUARTZ","Quartz",new ItemStack(Items.quartz)));
		miningMap.put("ENCHANTED_QUARTZ", new Entry("ENCHANTED_QUARTZ","Enchanted Quartz",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.quartz))));
		miningMap.put("ENCHANTED_QUARTZ_BLOCK", new Entry("ENCHANTED_QUARTZ_BLOCK","Enchanted Quartz Block",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.quartz_block))));
		
		miningMap.put("OBSIDIAN", new Entry("OBSIDIAN","Obsidian",new ItemStack(Blocks.obsidian)));
		miningMap.put("ENCHANTED_OBSIDIAN", new Entry("ENCHANTED_OBSIDIAN","Enchanted Obsidian",new ItemStack(Blocks.obsidian)));
		
		miningMap.put("GLOWSTONE_DUST", new Entry("GLOWSTONE_DUST","Glowstone Dust",new ItemStack(Items.glowstone_dust)));
		miningMap.put("ENCHANTED_GLOWSTONE_DUST", new Entry("ENCHANTED_GLOWSTONE_DUST","Enchanted Glowstone Dust",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.glowstone_dust))));
		miningMap.put("ENCHANTED_GLOWSTONE", new Entry("ENCHANTED_GLOWSTONE","Enchanted Glowstone",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.glowstone))));
		miningMap.put("ENCHANTED_REDSTONE_LAMP", new Entry("ENCHANTED_REDSTONE_LAMP","Enchanted Redstone Lamp",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.redstone_lamp))));
		
		miningMap.put("GRAVEL", new Entry("GRAVEL","Gravel",new ItemStack(Blocks.gravel)));
		
		miningMap.put("FLINT", new Entry("FLINT","Flint",new ItemStack(Items.flint)));
		miningMap.put("ENCHANTED_FLINT", new Entry("ENCHANTED_FLINT","Enchanted Flint",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.flint))));
		
		miningMap.put("ICE", new Entry("ICE","Ice",new ItemStack(Blocks.ice)));
		miningMap.put("PACKED_ICE", new Entry("PACKED_ICE","Packed Ice",new ItemStack(Blocks.packed_ice)));
		miningMap.put("ENCHANTED_ICE", new Entry("ENCHANTED_ICE","Enchanted Ice",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.ice))));
		miningMap.put("ENCHANTED_PACKED_ICE", new Entry("ENCHANTED_PACKED_ICE","Enchanted Packed Ice",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.packed_ice))));
		
		miningMap.put("NETHERRACK", new Entry("NETHERRACK","Netherrack",new ItemStack(Blocks.netherrack)));
		
		miningMap.put("SAND", new Entry("SAND","Sand",new ItemStack(Blocks.sand)));
		miningMap.put("ENCHANTED_SAND", new Entry("ENCHANTED_SAND","Enchanted Sand",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.sand))));
		
		miningMap.put("ENDER_STONE", new Entry("ENDER_STONE","Endstone",new ItemStack(Blocks.end_stone)));
		miningMap.put("ENCHANTED_ENDSTONE", new Entry("ENCHANTED_ENDSTONE","Enchanted Endstone",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.end_stone))));
		
		miningMap.put("SNOW_BALL", new Entry("SNOW_BALL","Snowball",new ItemStack(Items.snowball)));
		miningMap.put("SNOW_BLOCK", new Entry("SNOW_BLOCK","Snow Block",new ItemStack(Blocks.snow)));
		miningMap.put("ENCHANTED_SNOW_BLOCK", new Entry("ENCHANTED_SNOW_BLOCK","Enchanted Snow Block",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.snow))));
		
		combatMap.put("ROTTEN_FLESH", new Entry("ROTTEN_FLESH","Rotten Flesh",new ItemStack(Items.rotten_flesh)));
		combatMap.put("ENCHANTED_ROTTEN_FLESH", new Entry("ENCHANTED_ROTTEN_FLESH","Enchanted Rotten Flesh",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.rotten_flesh))));
		
		combatMap.put("BONE", new Entry("BONE","Bone",new ItemStack(Items.bone)));
		combatMap.put("ENCHANTED_BONE", new Entry("ENCHANTED_BONE","Enchanted Bone",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.bone))));
		combatMap.put("ENCHANTED_BONE_BLOCK", new Entry("ENCHANTED_BONE_BLOCK","Enchanted Bone Block",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.snow))));
		
		combatMap.put("STRING", new Entry("STRING","String", new ItemStack(Items.string)));
		combatMap.put("ENCHANTED_STRING", new Entry("ENCHANTED_STRING","Enchanted String",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.string))));
		
		combatMap.put("SPIDER_EYE", new Entry("SPIDER_EYE","Spider Eye",new ItemStack(Items.spider_eye)));
		combatMap.put("ENCHANTED_SPIDER_EYE", new Entry("ENCHANTED_SPIDER_EYE","Enchanted Spider Eye",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.spider_eye))));
		combatMap.put("ENCHANTED_FERMENTED_SPIDER_EYE", new Entry("ENCHANTED_FERMENTED_SPIDER_EYE","Enchanted Fermented Spider Eye",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.fermented_spider_eye))));
		
		combatMap.put("SULPHUR", new Entry("SULPHUR","Gunpowder",new ItemStack(Items.gunpowder)));
		combatMap.put("ENCHANTED_GUNPOWDER", new Entry("ENCHANTED_GUNPOWDER","Enchanted Gunpowder",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.gunpowder))));
		combatMap.put("ENCHANTED_FIREWORK_ROCKET", new Entry("ENCHANTED_FIREWORK_ROCKET","Enchanted Firework Rocket",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.fireworks))));
		
		combatMap.put("ENDER_PEARL", new Entry("ENDER_PEARL","Ender Pearl",new ItemStack(Items.ender_pearl)));
		combatMap.put("ENCHANTED_ENDER_PEARL", new Entry("ENCHANTED_ENDER_PEARL","Enchanted Ender Pearl",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.ender_pearl))));
		combatMap.put("ENCHANTED_EYE_OF_ENDER", new Entry("ENCHANTED_EYE_OF_ENDER","Enchanted Eye Of Ender",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.ender_eye))));
		
		combatMap.put("GHAST_TEAR", new Entry("GHAST_TEAR","Ghast Tear",new ItemStack(Items.ghast_tear)));
		combatMap.put("ENCHANTED_GHAST_TEAR", new Entry("ENCHANTED_GHAST_TEAR","Enchanted Ghast Tear",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.ghast_tear))));
		
		combatMap.put("SLIME_BALL", new Entry("SLIME_BALL","Slime Ball",new ItemStack(Items.slime_ball)));
		combatMap.put("ENCHANTED_SLIME_BALL", new Entry("ENCHANTED_SLIME_BALL","Enchanted Slime Ball",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.slime_ball))));
		combatMap.put("ENCHANTED_SLIME_BLOCK", new Entry("ENCHANTED_SLIME_BLOCK","Enchanted Slime Block",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.slime_block))));
		
		combatMap.put("BLAZE_ROD", new Entry("BLAZE_ROD","Blaze Rod",new ItemStack(Items.blaze_rod)));
		combatMap.put("ENCHANTED_BLAZE_POWDER", new Entry("ENCHANTED_BLAZE_POWDER","Enchanted Blaze Powder",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.blaze_powder))));
		combatMap.put("ENCHANTED_BLAZE_ROD", new Entry("ENCHANTED_BLAZE_ROD","Enchanted Blaze Rod",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.blaze_rod))));
		
		combatMap.put("MAGMA_CREAM", new Entry("MAGMA_CREAM","Magma Cream",new ItemStack(Items.magma_cream)));
		combatMap.put("ENCHANTED_MAGMA_CREAM", new Entry("ENCHANTED_MAGMA_CREAM","Enchanted Magma Cream",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.magma_cream))));
		
		combatMap.put("GRIFFIN_FEATHER", new Entry("GRIFFIN_FEATHER","Griffin Feather",new ItemStack(Items.feather)));
		combatMap.put("DAEDALUS_STICK", new Entry("DAEDALUS_STICK","Daedalus Stick",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.stick))));
		combatMap.put("ANCIENT_CLAW", new Entry("ANCIENT_CLAW","Ancient Claw",new ItemStack(Items.flint)));
		combatMap.put("ENCHANTED_ANCIENT_CLAW", new Entry("ENCHANTED_ANCIENT_CLAW","Enchanted Ancient Claw",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.flint))));
		
		combatMap.put("REVENANT_FLESH", new Entry("REVENANT_FLESH","Revenant Flesh",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.rotten_flesh))));
		combatMap.put("REVENANT_VISCERA", new Entry("REVENANT_VISCERA","Revenant Viscera",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.cooked_porkchop))));
		
		combatMap.put("TARANTULA_WEB", new Entry("TARANTULA_WEB","Tarantula Web",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.string))));
		combatMap.put("TARANTULA_SILK", new Entry("TARANTULA_SILK","Tarantula Silk",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.web))));
		
		combatMap.put("WOLF_TOOTH", new Entry("WOLF_TOOTH","Wolf Tooth",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.ghast_tear))));
		combatMap.put("GOLDEN_TOOTH", new Entry("GOLDEN_TOOTH","Golden Tooth",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.gold_nugget))));
		
		woodAndFishesMap.put("LOG", new Entry("LOG","Log",new ItemStack(Blocks.log,1,0)));
		woodAndFishesMap.put("ENCHANTED_OAK_LOG", new Entry("ENCHANTED_OAK_LOG","Enchanted Oak Log",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.log,1,0))));
		
		woodAndFishesMap.put("LOG:1", new Entry("LOG:1","Spruce Log",new ItemStack(Blocks.log,1,1)));
		woodAndFishesMap.put("ENCHANTED_SPRUCE_LOG", new Entry("ENCHANTED_SPRUCE_LOG","Enchanted Spruce Log",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.log,1,1))));
		
		woodAndFishesMap.put("LOG:2", new Entry("LOG:2","Birch Log",new ItemStack(Blocks.log,1,2)));
		woodAndFishesMap.put("ENCHANTED_BIRCH_LOG", new Entry("ENCHANTED_BIRCH_LOG","Enchanted Birch Log",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.log,1,2))));
		
		woodAndFishesMap.put("LOG_2:1", new Entry("LOG_2:1","Dark Oak Log",new ItemStack(Blocks.log2,1,1)));
		woodAndFishesMap.put("ENCHANTED_DARK_OAK_LOG", new Entry("ENCHANTED_DARK_OAK_LOG","Enchanted Dark Oak Log",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.log2,1,1))));
		
		woodAndFishesMap.put("LOG_2", new Entry("LOG_2","Acacia Log",new ItemStack(Blocks.log,1,0)));
		woodAndFishesMap.put("ENCHANTED_ACACIA_LOG", new Entry("ENCHANTED_ACACIA_LOG","Enchanted Acacia Log",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.log,1,0))));
		
		woodAndFishesMap.put("LOG:3", new Entry("LOG:3","Jungle Log",new ItemStack(Blocks.log,1,3)));
		woodAndFishesMap.put("ENCHANTED_JUNGLE_LOG", new Entry("ENCHANTED_JUNGLE_LOG","Enchanted Jungle Log",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.log,1,3))));
		
		woodAndFishesMap.put("RAW_FISH", new Entry("RAW_FISH","Fish",new ItemStack(Items.fish,1,0)));
		woodAndFishesMap.put("ENCHANTED_RAW_FISH", new Entry("ENCHANTED_RAW_FISH","Enchanted Fish",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.fish,1,0))));
		woodAndFishesMap.put("ENCHANTED_COOKED_FISH", new Entry("ENCHANTED_COOKED_FISH","Enchanted Cooked Fish",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.cooked_fish,1,0))));
		
		woodAndFishesMap.put("RAW_FISH:1", new Entry("RAW_FISH:1","Raw Salmon",new ItemStack(Items.fish,1,1)));
		woodAndFishesMap.put("ENCHANTED_RAW_SALMON", new Entry("ENCHANTED_RAW_SALMON","Enchanted Raw Salmon",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.fish,1,1))));
		woodAndFishesMap.put("ENCHANTED_COOKED_SALMON", new Entry("ENCHANTED_COOKED_SALMON","Enchanted Cooked Salmon",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.cooked_fish,1,1))));
		
		woodAndFishesMap.put("RAW_FISH:2", new Entry("RAW_FISH:2","Clownfish",new ItemStack(Items.fish,1,2)));
		woodAndFishesMap.put("ENCHANTED_CLOWNFISH", new Entry("ENCHANTED_CLOWNFISH","Enchanted Clownfish",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.fish,1,2))));
		
		woodAndFishesMap.put("RAW_FISH:3", new Entry("RAW_FISH:3","Pufferfish",new ItemStack(Items.fish,1,3)));
		woodAndFishesMap.put("ENCHANTED_PUFFERFISH", new Entry("ENCHANTED_PUFFERFISH","Enchanted Pufferfish",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.fish,1,2))));
		
		woodAndFishesMap.put("PRISMARINE_SHARD", new Entry("PRISMARINE_SHARD","Prismarine Shard",new ItemStack(Items.prismarine_shard)));
		woodAndFishesMap.put("ENCHANTED_PRISMARINE_SHARD", new Entry("ENCHANTED_PRISMARINE_SHARD","Enchanted Prismarine Shard",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.prismarine_shard))));
		
		woodAndFishesMap.put("PRISMARINE_CRYSTALS", new Entry("PRISMARINE_CRYSTALS","Prismarine Crystals",new ItemStack(Items.prismarine_crystals)));
		woodAndFishesMap.put("ENCHANTED_PRISMARINE_CRYSTALS", new Entry("ENCHANTED_PRISMARINE_CRYSTALS","Enchanted Prismarine Cystals",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.prismarine_crystals))));
		
		woodAndFishesMap.put("CLAY_BALL", new Entry("CLAY_BALL","Clay Ball",new ItemStack(Items.clay_ball)));
		woodAndFishesMap.put("ENCHANTED_CLAY_BALL", new Entry("ENCHANTED_CLAY_BALL","Enchanted Clay Ball",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.clay_ball))));
		
		woodAndFishesMap.put("WATER_LILY", new Entry("WATER_LILY","",new ItemStack(Blocks.waterlily)));
		woodAndFishesMap.put("ENCHANTED_WATER_LILY", new Entry("ENCHANTED_WATER_LILY","",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.waterlily))));
		
		woodAndFishesMap.put("INK_SACK", new Entry("INK_SACK","Ink Sac",new ItemStack(Items.dye,1,0)));
		woodAndFishesMap.put("ENCHANTED_INK_SACK", new Entry("ENCHANTED_INK_SACK","Enchanted Ink Sac",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.dye,1,0))));
		
		woodAndFishesMap.put("SPONGE", new Entry("SPONGE","Sponge",new ItemStack(Blocks.sponge,1,0)));
		woodAndFishesMap.put("ENCHANTED_SPONGE", new Entry("ENCHANTED_SPONGE","Enchanted Sponge",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.sponge,1,0))));
		woodAndFishesMap.put("ENCHANTED_WET_SPONGE", new Entry("ENCHANTED_WET_SPONGE","Enchanted Wet Sponge",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.sponge,1,1))));
		
		woodAndFishesMap.put("CARROT_BAIT", new Entry("CARROT_BAIT","Carrot Bait",BazaarItemMapping.getItemStackFromMeta("0842969c-2692-3bd7-8483-2b7b2c2b7f63","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGQzYTZiZDk4YWMxODMzYzY2NGM0OTA5ZmY4ZDJkYzYyY2U4ODdiZGNmM2NjNWIzODQ4NjUxYWU1YWY2YiJ9fX0=")));
		woodAndFishesMap.put("WOLF_TOOTH", new Entry("WOLF_TOOTH","Wolf Tooth",BazaarItemMapping.getItemStackFromMeta("7b2c475f-ac70-34ce-af36-be5009df1585","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWY5MWExNDg2N2VmOTg2Nzg3MmRjZGM4YzU0ZTNkNGNmYjVlNTI1ZGNjZmI3Zjk5YTczMTRhNDVmYWViMzAxZSJ9fX0=")));
		woodAndFishesMap.put("FISH_BAIT", new Entry("FISH_BAIT","Fish Bait",BazaarItemMapping.getItemStackFromMeta("1b379ea9-7eb2-3e40-bf48-559eaf4da1f6","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjliYjE4ZTFjZmU2ZWRmMDM1MzVlNWZkYzY0ODJlMDlhN2ZkZjk1MTI1Yzg2MTEyNjliOWRlOWQ1NDcxNWI5ZCJ9fX0=")));
		woodAndFishesMap.put("LIGHT_BAIT", new Entry("LIGHT_BAIT","Light Bait",BazaarItemMapping.getItemStackFromMeta("0f759208-92ff-3686-b38b-d4f821a9247e","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzM2YTlhZGQyNTY0NWJmY2MzNzdjMjVlZjBjMmU5OTAxZDE5NDkzYzNlOTgxZWJjNmJhN2ExYTFiNjQ2NmNlNCJ9fX0=")));
		woodAndFishesMap.put("DARK_BAIT", new Entry("DARK_BAIT","Dark Bait",BazaarItemMapping.getItemStackFromMeta("df2c3cc0-6792-3af3-b127-e0d934b485b7","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzMzYzUxNmYzZjM4MDkxNmQ0MWE5MzU1YTMxOWY4NTk0M2FhY2M4YTljMWI0YTEzODAxNzQ4NGI2MTExNGY2OCJ9fX0=")));
		woodAndFishesMap.put("SPOOKY_BAIT", new Entry("SPOOKY_BAIT","Spooky Bait",BazaarItemMapping.getItemStackFromMeta("74b7ab7c-3268-3a70-8937-026e1416dd7f","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTEwNzRiYTc5NjE2YzdkOGNmOGUzMzg0OTAzOWY2NzQxMGEyZjdjOWNlNzkzZDQ0N2UyMWY1YWEyNGQ1MDEwOCJ9fX0=")));
		woodAndFishesMap.put("SPIKED_BAIT", new Entry("SPIKED_BAIT","Spiked Bait",BazaarItemMapping.getItemStackFromMeta("a82c3c93-de2a-338c-a766-7c2985f6648c","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTEyYmM1ZWYyNmYzNjdiZGJkNzExNmU4MGZkZTRhZjE4MjNjMGU5MzYwYWZhYjAyYTlkM2E0Y2I2ZDVmY2Q4MiJ9fX0=")));
		woodAndFishesMap.put("BLESSED_BAIT", new Entry("BLESSED_BAIT","Blessed Bait",BazaarItemMapping.getItemStackFromMeta("54b94885-521b-3700-a138-31330f0aba0d","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjA2MGE0NjQ5N2NlZTc2MTEzNDZjOWRkOGViOGY1ZGU0NDgzZGUyNTkxNDcyMTEzNTM4NDgzNTZkZTE1ZDE5In19fQ==")));
		woodAndFishesMap.put("ICE_BAIT", new Entry("ICE_BAIT","Ice Bait",BazaarItemMapping.getItemStackFromMeta("b2b19dcd-dc67-31df-a790-e6cf07ae12ac","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTExMzY2MTZkOGM0YTg3YTU0Y2U3OGE5N2I1NTE2MTBjMmIyYzhmNmQ0MTBiYzM4Yjg1OGY5NzRiMTEzYjIwOCJ9fX0=")));
		woodAndFishesMap.put("WHALE_BAIT", new Entry("WHALE_BAIT","Whale Bait",BazaarItemMapping.getItemStackFromMeta("d88b7890-b977-3de5-acc6-5e14b17cc1f3","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNhYTcxNjc2ZTgxZmI1M2EwNDBkZmRjYTNlNWI0N2Q1M2U2ZWZkNjY1ZTY5ZmI0Mzk3NzhlOGM0ZWZiMWNjIn19fQ==")));
		woodAndFishesMap.put("SHARK_BAIT", new Entry("SHARK_BAIT","Shark Bait",BazaarItemMapping.getItemStackFromMeta("9a6c7271-a12d-3941-914c-7c456a086c5a","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWRmZjkwNDEyNGVmZTQ4NmIzYTU0MjYxZGJiODA3MmIwYTRlMTE2MTVhZDhkNzM5NGQ4MTRlMGU4YzhlZjllYiJ9fX0=")));
		
		woodAndFishesMap.put("NURSE_SHARK_TOOTH", new Entry("NURSE_SHARK_TOOTH","Nurse Shark Tooth",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.ghast_tear))));
		woodAndFishesMap.put("BLUE_SHARK_TOOTH", new Entry("BLUE_SHARK_TOOTH","Blue Shark Tooth",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.ghast_tear))));
		woodAndFishesMap.put("TIGER_SHARK_TOOTH", new Entry("TIGER_SHARK_TOOTH","Tiger Shark Tooth",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.ghast_tear))));
		woodAndFishesMap.put("GREAT_WHITE_SHARK_TOOTH", new Entry("GREAT_WHITE_SHARK_TOOTH","Great White Shark Tooth",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.ghast_tear))));
		woodAndFishesMap.put("SHARK_FIN", new Entry("SHARK_FIN","Shark Fin",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.prismarine_shard))));
		woodAndFishesMap.put("ENCHANTED_SHARK_FIN", new Entry("ENCHANTED_SHARK_FIN","Enchanted Shark Fin",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.prismarine_shard))));
		
		odditiesMap.put("BOOSTER_COOKIE", new Entry("BOOSTER_COOKIE","Booster Cookie",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.cookie))));
		
		odditiesMap.put("HOT_POTATO_BOOK", new Entry("HOT_POTATO_BOOK","Hot Potato Book",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.book))));
		odditiesMap.put("FUMING_POTATO_BOOK", new Entry("FUMING_POTATO_BOOK","Fuming Potato Book",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.book))));
		
		odditiesMap.put("COMPACTOR", new Entry("COMPACTOR","Compactor",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.book))));
		odditiesMap.put("SUPER_COMPACTOR_3000", new Entry("SUPER_COMPACTOR_3000","Super Compactor 3000",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.book))));
		
		odditiesMap.put("SUMMONING_EYE", new Entry("SUMMONING_EYE","Summoning Eye",BazaarItemMapping.getItemStackFromMeta("00a702b9-7bad-3205-a04b-52478d8c0e7f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGFhOGZjOGRlNjQxN2I0OGQ0OGM4MGI0NDNjZjUzMjZlM2Q5ZGE0ZGJlOWIyNWZjZDQ5NTQ5ZDk2MTY4ZmMwIn19fQ==")));
		
		odditiesMap.put("PROTECTOR_FRAGMENT", new Entry("PROTECTOR_FRAGMENT","Protector Dragon Fragment",BazaarItemMapping.getItemStackFromMeta("a228e918-722d-3a31-bc13-c9f905a0d3a2", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHBzOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzQ4ZGUzMzlhZjYzYTIyOWM5MjM4ZDAyN2U0N2Y1M2VlYjU2MTQxYTQxOWY1MWIzNWMzMWVhMTQ5NGI0MzVkZDMifX19")));
		odditiesMap.put("OLD_FRAGMENT", new Entry("OLD_FRAGMENT","Old Dragon Fragment",BazaarItemMapping.getItemStackFromMeta("a3d7724b-faaf-3472-8010-4a67aba84d7c","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHBzOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzdhYTA5YWQxNzdmYmNjYzUzZmEzMTZjYzA0YmRkMmM5MzY2YmFlZDg4OWRmNzZjNWEyOWRlZmVhODE3MGRlZjUifX19")));
		odditiesMap.put("UNSTABLE_FRAGMENT", new Entry("UNSTABLE_FRAGMENT","Unstable Dragon Fragment",BazaarItemMapping.getItemStackFromMeta("59b41a23-b7d0-33df-a196-968957aa0b48","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHBzOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzk4MjI4YzIzNGMzOTAzYzUxMmE1YTBhYTQ1MjYwZTdiNTY3ZTBlMjBlZWZjN2Q1NjFjY2VjOTdiMjk1ODcxYWYifX19")));
		odditiesMap.put("STRONG_FRAGMENT", new Entry("STRONG_FRAGMENT","Strong Dragon Fragment",BazaarItemMapping.getItemStackFromMeta("ddc6eaac-9166-3188-a081-7a33ebaaa3cd","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHBzOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzZlZTMyZmJkNGM3YjAzYjg2OTA3OGFhMWY0OTNhMzkwZTZlMTNiNDYxZDYxMzcwN2VhZmIzMjZkYmNkMmI0YjUifX19")));
		odditiesMap.put("YOUNG_FRAGMENT", new Entry("YOUNG_FRAGMENT","Young Dragon Fragment",BazaarItemMapping.getItemStackFromMeta("b896dea7-c289-3450-97b6-6de89f48ae4b","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHBzOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzRiNWJkNmI2NGU4YmQ2YzU4ZjVjZDFlNzlhNTUwMmQ0NDQ4YmFmYzAwNmQyZmUwNTY4ZjZhMGQ2Yjg2ZDQ0OWUifX19")));
		odditiesMap.put("WISE_FRAGMENT", new Entry("WISE_FRAGMENT","Wise Dragon Fragment",BazaarItemMapping.getItemStackFromMeta("ca156a9a-0286-3005-a839-a6c4dd4c671e","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHBzOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzFkNzYyMGIyZTQ5MzQ5NjNiYjEyNTA4MzEwZDA1NDk0YzA2N2RjMzNlMDA4Y2VjZjJjZDdiNDU0OTY1NGZhYjMifX19")));
		odditiesMap.put("SUPERIOR_FRAGMENT", new Entry("SUPERIOR_FRAGMENT","Superior Dragon Fragment",BazaarItemMapping.getItemStackFromMeta("51e54c0e-92ce-3b9f-9ee0-e35e8a302396","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHBzOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzZmODliMTUwYmU5YzRjNTI0OWYzNTVmNjhlYTBjNDM5MTMwMGE5YmUxZjI2MGQ3NTBmYzM1YTE4MTdhZDc5NmUifX19")));
		odditiesMap.put("HOLY_FRAGMENT", new Entry("HOLY_FRAGMENT","Holy Dragon Fragment",BazaarItemMapping.getItemStackFromMeta("37edaf41-ceec-35e0-bd7e-f4fc81957e4e","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODNkOWE4MmUzMDcxYzgxYWQ0MmFiNDgyYTdjODA3M2JlYzZiODdlNjIwNDM1M2E0ZTdjZTIwMDM2MjIyNzUzYyJ9fX0K")));
		
		odditiesMap.put("ENCHANTED_LAVA_BUCKET", new Entry("ENCHANTED_LAVA_BUCKET","Enchanted Lava Bucket",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.lava_bucket))));
		odditiesMap.put("HAMSTER_WHEEL", new Entry("HAMSTER_WHEEL","Hamster Wheel",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Blocks.trapdoor))));
		odditiesMap.put("FOUL_FLESH", new Entry("FOUL_FLESH","Foul Flesh",new ItemStack(Items.coal,1,1)));
		odditiesMap.put("CATALYST", new Entry("CATALYST","Catalyst",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.nether_star))));
		odditiesMap.put("HYPER_CATALYST", new Entry("HYPER_CATALYST","Hyper Catalyst",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.nether_star))));
		
		odditiesMap.put("GREEN_CANDY", new Entry("GREEN_CANDY","Green Candy",BazaarItemMapping.getItemStackFromMeta("0961dbb3-2167-3f75-92e4-ec8eb4f57e55", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2UwNjIyZDAxY2ZkYWUzODZjYzdkZDgzNDI3Njc0YjQyMmY0NmQwYTU3ZTY3YTIwNjA3ZTZjYTRiOWFmM2IwMSJ9fX0=")));
		odditiesMap.put("PURPLE_CANDY", new Entry("PURPLE_CANDY","Purple Candy",BazaarItemMapping.getItemStackFromMeta("5b0e6bf0-6312-3476-b5f8-dbc9a8849a1f","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTVkN2FlZTRlOTdhZDg0MDk1ZjU1NDA1ZWUxMzA1ZDFmYzg1NTRjMzA5ZWRiMTJhMWRiODYzY2RlOWMxZWM4MCJ9fX0=")));
		odditiesMap.put("ECTOPLASM", new Entry("ECTOPLASM","Ectoplasm",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.prismarine_crystals))));
		odditiesMap.put("PUMPKIN_GUTS", new Entry("PUMPKIN_GUTS","Pumpkin Guts",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.pumpkin_seeds))));
		odditiesMap.put("SPOOKY_SHARD", new Entry("SPOOKY_SHARD","Spooky Shard",BazaarItemMapping.getItemStackFromMeta("9b2c06ec-28b4-399f-a7f8-34f795f6e040","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjYwMDAzYTcxNGYyMGI5YTAwMTcxMDg4NGYyYjMwNjNkMmJhNGVjZmE4ZjVmY2M2MzRiOTIxMWMzOGI4MzU5In19fQ==")));
		odditiesMap.put("WEREWOLF_SKIN", new Entry("WEREWOLF_SKIN","Werewolf Skin",new ItemStack(Items.leather)));
		odditiesMap.put("SOUL_FRAGMENT", new Entry("SOUL_FRAGMENT","Soul Fragment",BazaarItemMapping.getItemStackFromMeta("e1b7a919-7d51-3c04-b268-2d35eea99f7e","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDFjODc0NTRmMWVlNTg1YjkwZmRiM2EzZTQwOTUyYTVjMmY4MGMwYTQ5ZGZlYzYyODcwZmRmZjE4Mzk2N2E4NCJ9fX0=")));
		
		odditiesMap.put("WHITE_GIFT", new Entry("WHITE_GIFT","White Gift",BazaarItemMapping.getItemStackFromMeta("7732c5e4-1800-3b90-a70f-727d2969254b","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTBmNTM5ODUxMGIxYTA1YWZjNWIyMDFlYWQ4YmZjNTgzZTU3ZDcyMDJmNTE5M2IwYjc2MWZjYmQwYWUyIn19fQ==")));
		odditiesMap.put("GREEN_GIFT", new Entry("GREEN_GIFT","Green Gift",BazaarItemMapping.getItemStackFromMeta("d5eb6a2a-3f10-3d6b-ba6a-4d46bb58a5cb","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWQ5N2Y0ZjQ0ZTc5NmY3OWNhNDMwOTdmYWE3YjRmZTkxYzQ0NWM3NmU1YzI2YTVhZDc5NGY1ZTQ3OTgzNyJ9fX0")));
		odditiesMap.put("RED_GIFT", new Entry("RED_GIFT","Red Gift",BazaarItemMapping.getItemStackFromMeta("bc74cb05-2758-3395-93ec-70452a983604","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjczYTIxMTQxMzZiOGVlNDkyNmNhYTUxNzg1NDE0MDM2YTJiNzZlNGYxNjY4Y2I4OWQ5OTcxNmM0MjEifX19")));
		
		odditiesMap.put("REFINED_MINERAL", new Entry("REFINED_MINERAL","Refined Mineral",new ItemStack(Items.dye,1,12)));
		
		odditiesMap.put("RECOMBOBULATOR_3000", new Entry("RECOMBOBULATOR_3000","Recombobulator 3000",BazaarItemMapping.getItemStackFromMeta("96538e7f-6b56-3557-9b7d-458afe4239e9","eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTdjY2QzNmRjOGY3MmFkY2IxZjhjOGU2MWVlODJjZDk2ZWFkMTQwY2YyYTE2YTEzNjZiZTliNWE4ZTNjYzNmYyJ9fX0K")));
		
		odditiesMap.put("JACOBS_TICKET", new Entry("JACOBS_TICKET","Jacobs Ticket",new ItemStack(Items.name_tag)));
		
		odditiesMap.put("EXP_BOTTLE", new Entry("EXP_BOTTLE","Experience Bottle",new ItemStack(Items.experience_bottle)));
		odditiesMap.put("GRAND_EXP_BOTTLE", new Entry("GRAND_EXP_BOTTLE","Grand Experience Bottle",new ItemStack(Items.experience_bottle)));
		odditiesMap.put("TITANIC_EXP_BOTTLE", new Entry("TITANIC_EXP_BOTTLE","Titanic Experience Bottle",new ItemStack(Items.experience_bottle)));
		odditiesMap.put("COLOSSAL_EXP_BOTTLE", new Entry("COLOSSAL_EXP_BOTTLE","Colossal Experience Bottle",new ItemStack(Items.experience_bottle)));
		
		odditiesMap.put("STOCK_OF_STONKS", new Entry("STOCK_OF_STONKS","Stock Of Stonks",BazaarItemMapping.getEnchantedItemStack(new ItemStack(Items.book))));		
		
		//BazaarItemMapping.getItemStackFromMeta("","")));
		
		itemMap.putAll(FarmingMap);
		itemMap.putAll(miningMap);
		itemMap.putAll(combatMap);
		itemMap.putAll(woodAndFishesMap);
		itemMap.putAll(odditiesMap);
	}
	public static ItemStack getEnchantedItemStack(ItemStack stack) {
		stack.setTagInfo("ench", new NBTTagList());
		return stack;
	}
	
	public static ItemStack getItemStackFromMeta(String uuid,String value) {

		ItemStack stack = new ItemStack(Items.skull,1,3);

		NBTTagCompound nbttagcompound = new NBTTagCompound();
		NBTTagList list = new NBTTagList();

		NBTTagCompound top = new NBTTagCompound();
		top.setTag("Id", new NBTTagString(uuid));

		NBTTagCompound also = new NBTTagCompound();

		NBTTagCompound alsos = new NBTTagCompound();
		alsos.setTag("Value", new NBTTagString(value));
		list.appendTag(alsos);
		also.setTag("textures", list);

		top.setTag("Properties", also);
		nbttagcompound.setTag("SkullOwner", top);

		stack.setTagCompound(nbttagcompound);
		
		return stack;

	}

	public static ItemStack getItemStack(String id) {
		return itemMap.get(id).stack;
	}
	
	public static class Entry{
		public String apiName;
		public String itemName;
		public ItemStack stack;
		
		public Entry(String apiName, String itemName, ItemStack stack) {
			this.apiName = apiName;
			this.itemName = itemName;
			this.stack = stack;
		}
	}
}
