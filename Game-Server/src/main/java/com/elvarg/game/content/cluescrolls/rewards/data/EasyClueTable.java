package com.elvarg.game.content.cluescrolls.rewards.data;

import com.elvarg.util.ItemIdentifiers;

public class EasyClueTable {
	public static final int MINIMUM_ROLLS = 2;
	public static final int MAXIMUM_ROLLS = 4;
	public static final int STANDARD_WEIGHT = 11;
	public static final int RARE_WEIGHT = 1;
 	public enum Standard {
		COINS(995, 50, 200, 1, Table.NONE),
		TROUT(334, 6, 10, 1, Table.NONE),
		SALMON(330, 6, 10, 1, Table.NONE),
		AIR_RUNE(556, 30, 50, 1, Table.NONE),
		FIRE_RUNE(554, 30, 50, 1, Table.NONE),
		WATER_RUNE(555, 30, 50, 1, Table.NONE),
		EARTH_RUNE(557, 30, 50, 1, Table.NONE),
		MIND_RUNE(558, 30, 50, 1, Table.NONE),
		BODY_RUNE(559, 30, 50, 1, Table.NONE),
		LAW_RUNE(563, 5, 10, 1, Table.NONE),
		CHAOS_RUNE(562, 5, 10, 1, Table.NONE),
		NATURE_RUNE(561, 5, 10, 1, Table.NONE),
		PURPLE_SWEETS(10476, 2, 6, 1, Table.NONE),
		BLACK_PLATEBODY(ItemIdentifiers.BLACK_PLATEBODY, 1, 1, 1, Table.NONE),
		BLACK_LONGSWORD(ItemIdentifiers.BLACK_LONGSWORD, 1, 1, 1, Table.NONE),
		BLACK_FULL_HELM(ItemIdentifiers.BLACK_FULL_HELM, 1, 1, 1, Table.NONE),
		BLACK_PLATELEGS(ItemIdentifiers.BLACK_PLATELEGS, 1, 1, 1, Table.NONE),
		BLACK_BATTLEAXE(ItemIdentifiers.BLACK_BATTLEAXE, 1, 1, 1, Table.NONE),
		BLACK_AXE(ItemIdentifiers.BLACK_AXE, 1, 1, 1, Table.NONE),
		STEEL_PICKAXE(ItemIdentifiers.STEEL_PICKAXE, 1, 1, 1, Table.NONE),
		BLACK_DAGGER(ItemIdentifiers.BLACK_DAGGER, 1, 1, 1, Table.NONE),
		STAFF_OF_AIR(ItemIdentifiers.STAFF_OF_AIR, 1, 1, 1, Table.NONE),
		STUDDED_CHAPS(ItemIdentifiers.STUDDED_CHAPS, 1, 1, 1, Table.NONE),
		STUDDED_BODY(ItemIdentifiers.STUDDED_BODY, 1, 1, 1, Table.NONE),
		WILLOW_SHORTBOW(ItemIdentifiers.WILLOW_SHORTBOW, 1, 1, 1, Table.NONE),
		COIF(ItemIdentifiers.COIF, 1, 1, 1, Table.NONE),
		BLACK_PICKAXE(ItemIdentifiers.BLACK_PICKAXE, 1, 1, 1, Table.NONE),
		EASY_AMULET(-1, -1, -1, 1, Table.EASY_STANDARD_AMULET),
		EASY_BLESSINGS(-1, -1, -1, 1, Table.EASY_STANDARD_BLESSINGS),
		EASY_BOW(-1, -1, -1, 1, Table.EASY_STANDARD_BOW),
		GENERAL_PRAYER_PAGE(-1, -1, -1, 1, Table.GENERAL_PRAYER_PAGE),
		GENERAL_FIRELIGHTER(-1, -1, -1, 1, Table.GENERAL_FIRELIGHTER),
		GENERAL_TELEPORT_SCROLL(-1, -1, -1, 1, Table.GENERAL_TELEPORT_SCROLL);
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Standard(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
			this.itemId = itemId;
			this.quantityMinimum = quantityMin;
			this.quantityMaximum = quantityMax;
			this.weight = weight;
			this.table = table;
		}
		
		public int getItemId() {
			return itemId;
		}
		
		public int getMinimumQuantity() {
			return quantityMinimum;
		}
		
		public int getMaximumQuantity() {
			return quantityMaximum;
		}
		
		public int getWeight() {
			return weight;
		}
		
		public Table getTable() {
			return table;
		}
	}
 	
 	public enum Standard_Amulet {
		AMULET_OF_MAGIC(ItemIdentifiers.AMULET_OF_MAGIC, 1, 1, 9, Table.NONE),
		AMULET_OF_MAGIC_I(ItemIdentifiers.AMULET_OF_MAGIC_T_, 1, 1, 1, Table.NONE);
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Standard_Amulet(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
			this.itemId = itemId;
			this.quantityMinimum = quantityMin;
			this.quantityMaximum = quantityMax;
			this.weight = weight;
			this.table = table;
		}
		
		public int getItemId() {
			return itemId;
		}
		
		public int getMinimumQuantity() {
			return quantityMinimum;
		}
		
		public int getMaximumQuantity() {
			return quantityMaximum;
		}
		
		public int getWeight() {
			return weight;
		}
		
		public Table getTable() {
			return table;
		}
	}
 	
 	public enum Standard_Blessings {
		COINS(995, 3000, 7000, 2, Table.NONE),
		BLESSINGS(-1, -1, -1, 1, Table.GENERAL_BLESSING);
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Standard_Blessings(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
			this.itemId = itemId;
			this.quantityMinimum = quantityMin;
			this.quantityMaximum = quantityMax;
			this.weight = weight;
			this.table = table;
		}
		
		public int getItemId() {
			return itemId;
		}
		
		public int getMinimumQuantity() {
			return quantityMinimum;
		}
		
		public int getMaximumQuantity() {
			return quantityMaximum;
		}
		
		public int getWeight() {
			return weight;
		}
		
		public Table getTable() {
			return table;
		}
	}
 	
 	public enum Standard_Bow {
		WILLOW_LONGBOW(ItemIdentifiers.WILLOW_LONGBOW, 1, 1, 9, Table.NONE),
		WILLOW_COMPOSITE_BOW(ItemIdentifiers.WILLOW_COMP_BOW, 1, 1, 1, Table.NONE);
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Standard_Bow(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
			this.itemId = itemId;
			this.quantityMinimum = quantityMin;
			this.quantityMaximum = quantityMax;
			this.weight = weight;
			this.table = table;
		}
		
		public int getItemId() {
			return itemId;
		}
		
		public int getMinimumQuantity() {
			return quantityMinimum;
		}
		
		public int getMaximumQuantity() {
			return quantityMaximum;
		}
		
		public int getWeight() {
			return weight;
		}
		
		public Table getTable() {
			return table;
		}
	}
	
	public enum Rare {
		BLACK_PLATEBODY_TRIM(ItemIdentifiers.BLACK_PLATEBODY_T_, 1, 1, 1, Table.NONE),
		BLACK_PLATELEGS_TRIM(ItemIdentifiers.BLACK_PLATELEGS_T_, 1, 1, 1, Table.NONE),
		BLACK_FULL_HELM_TRIM(ItemIdentifiers.BLACK_FULL_HELM_T_, 1, 1, 1, Table.NONE),
		BLACK_KITESHIELD_TRIM(ItemIdentifiers.BLACK_KITESHIELD_T_, 1, 1, 1, Table.NONE),
		BLACK_PLATESKIRT_TRIM(ItemIdentifiers.BLACK_PLATESKIRT_T_, 1, 1, 1, Table.NONE),
		BLACK_PLATEBODY_GOLD(ItemIdentifiers.BLACK_PLATEBODY_G_, 1, 1, 1, Table.NONE),
		BLACK_PLATELEGS_GOLD(ItemIdentifiers.BLACK_PLATELEGS_G_, 1, 1, 1, Table.NONE),
		BLACK_FULL_HELM_GOLD(ItemIdentifiers.BLACK_FULL_HELM_G_, 1, 1, 1, Table.NONE),
		BLACK_KITESHIELD_GOLD(ItemIdentifiers.BLACK_KITESHIELD_G_, 1, 1, 1, Table.NONE),
		BLACK_PLATESKIRT_GOLD(ItemIdentifiers.BLACK_SKIRT_G_, 1, 1, 1, Table.NONE),
		HIGHYWAYMAN_MASK(ItemIdentifiers.HIGHWAYMAN_MASK, 1, 1, 1, Table.NONE),
		BLUE_BERRET(ItemIdentifiers.BLUE_BERET, 1, 1, 1, Table.NONE),
		BLACK_BERRET(ItemIdentifiers.BLACK_BERET, 1, 1, 1, Table.NONE),
		WHITE_BERRET(ItemIdentifiers.WHITE_BERET, 1, 1, 1, Table.NONE),
		BLACK_HERALDIC_KITESHIELD_H1(ItemIdentifiers.BLACK_SHIELD_H1_, 1, 1, 1, Table.NONE),
		BLACK_HERALDIC_KITESHIELD_H2(ItemIdentifiers.BLACK_SHIELD_H2_, 1, 1, 1, Table.NONE),
		BLACK_HERALDIC_KITESHIELD_H3(ItemIdentifiers.BLACK_SHIELD_H3_, 1, 1, 1, Table.NONE),
		BLACK_HERALDIC_KITESHIELD_H4(ItemIdentifiers.BLACK_SHIELD_H4_, 1, 1, 1, Table.NONE),
		BLACK_HERALDIC_KITESHIELD_H5(ItemIdentifiers.BLACK_SHIELD_H5_, 1, 1, 1, Table.NONE),
		STUDDED_BODY_GOLD(ItemIdentifiers.STUDDED_BODY_G_, 1, 1, 1, Table.NONE),
		STUDDED_BODY_TRIM(ItemIdentifiers.STUDDED_BODY_T_, 1, 1, 1, Table.NONE),
		STUDDED_CHAPS_GOLD(ItemIdentifiers.STUDDED_CHAPS_G_, 1, 1, 1, Table.NONE),
		STUDDED_CHAPS_TRIM(ItemIdentifiers.STUDDED_CHAPS_T_, 1, 1, 1, Table.NONE),
		BLUE_SKIRT_GOLD(ItemIdentifiers.BLUE_SKIRT_G_, 1, 1, 1, Table.NONE),
		BLUE_SKIRT_TRIM(ItemIdentifiers.BLUE_SKIRT_T_, 1, 1, 1, Table.NONE),
		BLUE_WIZARD_ROBE_GOLD(ItemIdentifiers.BLUE_WIZARD_ROBE_G_, 1, 1, 1, Table.NONE),
		BLUE_WIZARD_ROBE_TRIM(ItemIdentifiers.BLUE_WIZARD_ROBE_T_, 1, 1, 1, Table.NONE),
		BLUE_WIZARD_HAT_GOLD(ItemIdentifiers.BLUE_WIZARD_HAT_G_, 1, 1, 1, Table.NONE),
		BLUE_WIZARD_HAT_TRIM(ItemIdentifiers.BLUE_WIZARD_HAT_T_, 1, 1, 1, Table.NONE),
		BLACK_HELM_H1(ItemIdentifiers.BLACK_HELM_H1_, 1, 1, 1, Table.NONE),
		BLACK_HELM_H2(ItemIdentifiers.BLACK_HELM_H2_, 1, 1, 1, Table.NONE),
		BLACK_HELM_H3(ItemIdentifiers.BLACK_HELM_H3_, 1, 1, 1, Table.NONE),
		BLACK_HELM_H4(ItemIdentifiers.BLACK_HELM_H4_, 1, 1, 1, Table.NONE),
		BLACK_HELM_H5(ItemIdentifiers.BLACK_HELM_H5_, 1, 1, 1, Table.NONE),
		BOBS_RED_SHIRT(ItemIdentifiers.BOBS_RED_SHIRT, 1, 1, 1, Table.NONE),
		BOBS_BLUE_SHIRT(ItemIdentifiers.BOBS_BLUE_SHIRT, 1, 1, 1, Table.NONE),
		BOBS_GREEN_SHIRT(ItemIdentifiers.BOBS_GREEN_SHIRT, 1, 1, 1, Table.NONE),
		BOBS_BLACK_SHIRT(ItemIdentifiers.BOBS_BLACK_SHIRT, 1, 1, 1, Table.NONE),
		BOBS_PURPLE_SHIRT(ItemIdentifiers.BOBS_PURPLE_SHIRT, 1, 1, 1, Table.NONE),
		POWDERED_WIG(ItemIdentifiers.A_POWDERED_WIG, 1, 1, 1, Table.NONE),
		FLARED_TROUSERS(ItemIdentifiers.FLARED_TROUSERS, 1, 1, 1, Table.NONE),
		PANTALOONS(ItemIdentifiers.PANTALOONS, 1, 1, 1, Table.NONE),
		SLEEPING_CAP(ItemIdentifiers.SLEEPING_CAP, 1, 1, 1, Table.NONE),
		SARADOMIN_ROBE_TOP(ItemIdentifiers.SARADOMIN_ROBE_TOP, 1, 1, 1, Table.NONE),
		SARADOMIN_ROBE_LEGS(ItemIdentifiers.SARADOMIN_ROBE_LEGS, 1, 1, 1, Table.NONE),
		GUTHIX_ROBE_TOP(ItemIdentifiers.GUTHIX_ROBE_TOP, 1, 1, 1, Table.NONE),
		GUTHIX_ROBE_LEGS(ItemIdentifiers.GUTHIX_ROBE_LEGS, 1, 1, 1, Table.NONE),
		ZAMORAK_ROBE_TOP(ItemIdentifiers.ZAMORAK_ROBE_TOP, 1, 1, 1, Table.NONE),
		ZAMORAK_ROBE_LEGS(ItemIdentifiers.ZAMORAK_ROBE_LEGS, 1, 1, 1, Table.NONE),
		BRONZE_PLATEBODY_TRIM(ItemIdentifiers.BRONZE_PLATEBODY_T_, 1, 1, 1, Table.NONE),
		BRONZE_PLATELEGS_TRIM(ItemIdentifiers.BRONZE_PLATELEGS_T_, 1, 1, 1, Table.NONE),
		BRONZE_PLATESKIRT_TRIM(ItemIdentifiers.BRONZE_PLATESKIRT_T_, 1, 1, 1, Table.NONE),
		BRONZE_KITESHIELD_TRIM(ItemIdentifiers.BRONZE_KITESHIELD_T_, 1, 1, 1, Table.NONE),
		BRONZE_FULL_HELM_TRIM(ItemIdentifiers.BRONZE_FULL_HELM_T_, 1, 1, 1, Table.NONE),
		BRONZE_PLATEBODY_GOLD(ItemIdentifiers.BRONZE_PLATEBODY_G_, 1, 1, 1, Table.NONE),
		BRONZE_PLATELEGS_GOLD(ItemIdentifiers.BRONZE_PLATELEGS_G_, 1, 1, 1, Table.NONE),
		BRONZE_PLATESKIRT_GOLD(ItemIdentifiers.BRONZE_PLATESKIRT_G_, 1, 1, 1, Table.NONE),
		BRONZE_KITESHIELD_GOLD(ItemIdentifiers.BRONZE_KITESHIELD_G_, 1, 1, 1, Table.NONE),
		BRONZE_FULL_HELM_GOLD(ItemIdentifiers.BRONZE_FULL_HELM_G_, 1, 1, 1, Table.NONE),
		IRON_PLATEBODY_TRIM(ItemIdentifiers.IRON_PLATEBODY_T_, 1, 1, 1, Table.NONE),
		IRON_PLATELEGS_TRIM(ItemIdentifiers.IRON_PLATELEGS_T_, 1, 1, 1, Table.NONE),
		IRON_PLATESKIRT_TRIM(ItemIdentifiers.IRON_PLATESKIRT_T_, 1, 1, 1, Table.NONE),
		IRON_KITESHIELD_TRIM(ItemIdentifiers.IRON_KITESHIELD_T_, 1, 1, 1, Table.NONE),
		IRON_FULL_HELM_TRIM(ItemIdentifiers.IRON_FULL_HELM_T_, 1, 1, 1, Table.NONE),
		IRON_PLATEBODY_GOLD(ItemIdentifiers.IRON_PLATEBODY_G_, 1, 1, 1, Table.NONE),
		IRON_PLATELEGS_GOLD(ItemIdentifiers.IRON_PLATELEGS_G_, 1, 1, 1, Table.NONE),
		IRON_PLATESKIRT_GOLD(ItemIdentifiers.IRON_PLATESKIRT_G_, 1, 1, 1, Table.NONE),
		IRON_KITESHIELD_GOLD(ItemIdentifiers.IRON_KITESHIELD_G_, 1, 1, 1, Table.NONE),
		IRON_FULL_HELM_GOLD(ItemIdentifiers.IRON_FULL_HELM_G_, 1, 1, 1, Table.NONE),
		BEANIE(ItemIdentifiers.BEANIE, 1, 1, 1, Table.NONE),
		IMP_MASK(ItemIdentifiers.IMP_MASK, 1, 1, 1, Table.NONE),
		GOBLIN_MASK(ItemIdentifiers.GOBLIN_MASK, 1, 1, 1, Table.NONE),
		ANCIENT_ROBE_TOP(ItemIdentifiers.ANCIENT_ROBE_TOP, 1, 1, 1, Table.NONE),
		ANCIENT_ROBE_LEGS(ItemIdentifiers.ANCIENT_ROBE_LEGS, 1, 1, 1, Table.NONE),
		ARMADYL_ROBE_TOP(ItemIdentifiers.ARMADYL_ROBE_TOP, 1, 1, 1, Table.NONE),
		ARMADYL_ROBE_LEGS(ItemIdentifiers.ARMADYL_ROBE_LEGS, 1, 1, 1, Table.NONE),
		BANDOS_ROBE_TOP(ItemIdentifiers.BANDOS_ROBE_TOP, 1, 1, 1, Table.NONE),
		BANDOS_ROBE_LEGS(ItemIdentifiers.BANDOS_ROBE_LEGS, 1, 1, 1, Table.NONE),
		BLACK_CANE(ItemIdentifiers.BLACK_CANE, 1, 1, 1, Table.NONE),
		BLACK_SKIRT_GOLD(ItemIdentifiers.BLACK_SKIRT_G_, 1, 1, 1, Table.NONE),
		BLACK_SKIRT_TRIM(ItemIdentifiers.BLACK_SKIRT_T_, 1, 1, 1, Table.NONE),
		BLACK_WIZARD_ROBE_GOLD(ItemIdentifiers.BLACK_WIZARD_ROBE_G_, 1, 1, 1, Table.NONE),
		BLACK_WIZARD_ROBE_TRIM(ItemIdentifiers.BLACK_WIZARD_ROBE_T_, 1, 1, 1, Table.NONE),
		BLACK_WIZARD_HAT_GOLD(ItemIdentifiers.BLACK_WIZARD_HAT_G_, 1, 1, 1, Table.NONE),
		BLACK_WIZARD_HAT_TRIM(ItemIdentifiers.BLACK_WIZARD_HAT_T_, 1, 1, 1, Table.NONE),
		WOODEN_SHIELD_GOLD(ItemIdentifiers.WOODEN_SHIELD_G_, 1, 1, 1, Table.NONE),
		STEEL_PLATEBODY_TRIM(ItemIdentifiers.STEEL_PLATEBODY_T_, 1, 1, 1, Table.NONE),
		STEEL_PLATELEGS_TRIM(ItemIdentifiers.STEEL_PLATELEGS_T_, 1, 1, 1, Table.NONE),
		STEEL_PLATESKIRT_TRIM(ItemIdentifiers.STEEL_PLATESKIRT_T_, 1, 1, 1, Table.NONE),
		STEEL_KITESHIELD_TRIM(ItemIdentifiers.STEEL_KITESHIELD_T_, 1, 1, 1, Table.NONE),
		STEEL_FULL_HELM_TRIM(ItemIdentifiers.STEEL_FULL_HELM_T_, 1, 1, 1, Table.NONE),
		STEEL_PLATEBODY_GOLD(ItemIdentifiers.STEEL_PLATEBODY_G_, 1, 1, 1, Table.NONE),
		STEEL_PLATELEGS_GOLD(ItemIdentifiers.STEEL_PLATELEGS_G_, 1, 1, 1, Table.NONE),
		STEEL_PLATESKIRT_GOLD(ItemIdentifiers.STEEL_PLATESKIRT_G_, 1, 1, 1, Table.NONE),
		STEEL_KITESHIELD_GOLD(ItemIdentifiers.STEEL_KITESHIELD_G_, 1, 1, 1, Table.NONE),
		STEEL_FULL_HELM_GOLD(ItemIdentifiers.STEEL_FULL_HELM_G_, 1, 1, 1, Table.NONE),
		RED_BERRET(ItemIdentifiers.RED_BERET, 1, 1, 1, Table.NONE),
		//POWER_AMULET_TRIM(ItemIdentifiers.ampow, 1, 1, 1, Table.NONE),
		//RAIN_BOW(1, 1, 1, 1, Table.NONE),
		//JOIN_OF_HAM(1, 1, 1, 1, Table.NONE),
		//STAFF_OF_BOB_THE_CAT(1, 1, 1, 1, Table.NONE),
		//LEATHER_BODY_GOLD(1, 1, 1, 1, Table.NONE),
		//LEATHER_CHAPS_GOLD(1, 1, 1, 1, Table.NONE),
		//BLACK_PLATEBODY_H1(1, 1, 1, 1, Table.NONE),
		//BLACK_PLATEBODY_H2(1, 1, 1, 1, Table.NONE),
		//BLACK_PLATEBODY_H3(1, 1, 1, 1, Table.NONE),
		//BLACK_PLATEBODY_H4(1, 1, 1, 1, Table.NONE),
		//BLACK_PLATEBODY_H5(1, 1, 1, 1, Table.NONE),
		RARE_CHEF(-1, -1, -1, 1, Table.EASY_RARE_CHEF),
		RARE_CAPE(-1, -1, -1, 1, Table.EASY_RARE_CAPE),
		RARE_MONK(-1, -1, -1, 1, Table.EASY_RARE_MONK),
		RARE_ELEGANT(-1,-1, -1, 6, Table.EASY_RARE_ELEGANT);
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Rare(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
			this.itemId = itemId;
			this.quantityMinimum = quantityMin;
			this.quantityMaximum = quantityMax;
			this.weight = weight;
			this.table = table;
		}
		
		public int getItemId() {
			return itemId;
		}
		
		public int getMinimumQuantity() {
			return quantityMinimum;
		}
		
		public int getMaximumQuantity() {
			return quantityMaximum;
		}
		
		public int getWeight() {
			return weight;
		}
		
		public Table getTable() {
			return table;
		}
	}
	
	public enum Rare_Chef {
		GOLDEN_APRON(ItemIdentifiers.GOLDEN_APRON, 1, 1, 1, Table.NONE),
		GOLDEN_CHEFS_HAT(ItemIdentifiers.GOLDEN_CHEFS_HAT, 1, 1, 1, Table.NONE);
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Rare_Chef(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
			this.itemId = itemId;
			this.quantityMinimum = quantityMin;
			this.quantityMaximum = quantityMax;
			this.weight = weight;
			this.table = table;
		}
		
		public int getItemId() {
			return itemId;
		}
		
		public int getMinimumQuantity() {
			return quantityMinimum;
		}
		
		public int getMaximumQuantity() {
			return quantityMaximum;
		}
		
		public int getWeight() {
			return weight;
		}
		
		public Table getTable() {
			return table;
		}
	}
	
	public enum Rare_Monk {
		MONK_ROBETOP_GOLD(ItemIdentifiers.MONKS_ROBE_TOP_G_, 1, 1, 1, Table.NONE),
		MONK_ROBELEGS_GOLD(ItemIdentifiers.MONKS_ROBE_G_, 1, 1, 1, Table.NONE);
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Rare_Monk(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
			this.itemId = itemId;
			this.quantityMinimum = quantityMin;
			this.quantityMaximum = quantityMax;
			this.weight = weight;
			this.table = table;
		}
		
		public int getItemId() {
			return itemId;
		}
		
		public int getMinimumQuantity() {
			return quantityMinimum;
		}
		
		public int getMaximumQuantity() {
			return quantityMaximum;
		}
		
		public int getWeight() {
			return weight;
		}
		
		public Table getTable() {
			return table;
		}
	}
	
	public enum Rare_Cape {
		WILDERNESS_CAPE_ZERO(ItemIdentifiers.TEAM_CAPE_ZERO, 1, 1, 1, Table.NONE),
		WILDERNESS_CAPE_I(ItemIdentifiers.TEAM_CAPE_I, 1, 1, 1, Table.NONE),
		//CAPE_OF_SKULLS(1, 1, 1, 1, Table.NONE)
		WILDERNESS_CAPE_X(ItemIdentifiers.TEAM_CAPE_X, 1, 1, 1, Table.NONE);
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Rare_Cape(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
			this.itemId = itemId;
			this.quantityMinimum = quantityMin;
			this.quantityMaximum = quantityMax;
			this.weight = weight;
			this.table = table;
		}
		
		public int getItemId() {
			return itemId;
		}
		
		public int getMinimumQuantity() {
			return quantityMinimum;
		}
		
		public int getMaximumQuantity() {
			return quantityMaximum;
		}
		
		public int getWeight() {
			return weight;
		}
		
		public Table getTable() {
			return table;
		}
	}
	
	public enum Rare_Elegant {
		RED_ELEGANT_SHIRT(ItemIdentifiers.RED_ELEGANT_SHIRT, 1, 1, 1, Table.NONE),
		RED_ELEGANT_LEGS(ItemIdentifiers.RED_ELEGANT_LEGS, 1, 1, 1, Table.NONE),
		RED_ELEGANT_BLOUSE(ItemIdentifiers.RED_ELEGANT_BLOUSE, 1, 1, 1, Table.NONE),
		RED_ELEGANT_SKIRT(ItemIdentifiers.RED_ELEGANT_SKIRT, 1, 1, 1, Table.NONE),
		GREEN_ELEGANT_SHIRT(ItemIdentifiers.GREEN_ELEGANT_SHIRT, 1, 1, 1, Table.NONE),
		GREEN_ELEGANT_LEGS(ItemIdentifiers.GREEN_ELEGANT_LEGS, 1, 1, 1, Table.NONE),
		GREEN_ELEGANT_BLOUSE(ItemIdentifiers.GREEN_ELEGANT_BLOUSE, 1, 1, 1, Table.NONE),
		GREEN_ELEGANT_SKIRT(ItemIdentifiers.GREEN_ELEGANT_SKIRT, 1, 1, 1, Table.NONE),
		BLUE_ELEGANT_SHIRT(ItemIdentifiers.BLUE_ELEGANT_SHIRT, 1, 1, 1, Table.NONE),
		BLUE_ELEGANT_LEGS(ItemIdentifiers.BLUE_ELEGANT_LEGS, 1, 1, 1, Table.NONE),
		BLUE_ELEGANT_BLOUSE(ItemIdentifiers.BLUE_ELEGANT_BLOUSE, 1, 1, 1, Table.NONE),
		BLUE_ELEGANT_SKIRT(ItemIdentifiers.BLUE_ELEGANT_SKIRT, 1, 1, 1, Table.NONE);
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Rare_Elegant(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
			this.itemId = itemId;
			this.quantityMinimum = quantityMin;
			this.quantityMaximum = quantityMax;
			this.weight = weight;
			this.table = table;
		}
		
		public int getItemId() {
			return itemId;
		}
		
		public int getMinimumQuantity() {
			return quantityMinimum;
		}
		
		public int getMaximumQuantity() {
			return quantityMaximum;
		}
		
		public int getWeight() {
			return weight;
		}
		
		public Table getTable() {
			return table;
		}
	}
 }
