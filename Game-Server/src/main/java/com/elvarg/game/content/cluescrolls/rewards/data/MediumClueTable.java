package com.elvarg.game.content.cluescrolls.rewards.data;

import com.elvarg.util.ItemIdentifiers;

public class MediumClueTable {
	public static final int MINIMUM_ROLLS = 3;
	public static final int MAXIMUM_ROLLS = 5;
	public static final int STANDARD_WEIGHT = 10;
	public static final int RARE_WEIGHT = 1;
	public enum Standard {
		COINS(995, 200, 1000, 1, Table.NONE),
		LOBSTER(ItemIdentifiers.LOBSTER_2, 8, 12, 1, Table.NONE),
		SWORDFISH(ItemIdentifiers.SWORDFISH_2, 8, 12, 1, Table.NONE),
		AIR_RUNE(ItemIdentifiers.AIR_RUNE, 50, 100, 1, Table.NONE),
		FIRE_RUNE(ItemIdentifiers.FIRE_RUNE, 50, 100, 1, Table.NONE),
		WATER_RUNE(ItemIdentifiers.WATER_RUNE, 50, 100, 1, Table.NONE),
		EARTH_RUNE(ItemIdentifiers.EARTH_RUNE, 50, 100, 1, Table.NONE),
		MIND_RUNE(ItemIdentifiers.MIND_RUNE, 50, 100, 1, Table.NONE),
		DEATH_RUNE(ItemIdentifiers.DEATH_RUNE, 10, 20, 1, Table.NONE),
		LAW_RUNE(ItemIdentifiers.LAW_RUNE, 10, 20, 1, Table.NONE),
		CHAOS_RUNE(ItemIdentifiers.CHAOS_RUNE, 10, 20, 1, Table.NONE),
		NATURE_RUNE(ItemIdentifiers.NATURE_RUNE, 10, 20, 1, Table.NONE),
		ADAMANT_LONGSWORD(ItemIdentifiers.ADAMANT_LONGSWORD, 1, 1, 1, Table.NONE),
		ADAMANT_FULL_HELM(ItemIdentifiers.ADAMANT_FULL_HELM, 1, 1, 1, Table.NONE),
		ADAMANT_PLATELEGS(ItemIdentifiers.ADAMANT_PLATELEGS, 1, 1, 1, Table.NONE),
		ADAMANT_BATTLEAXE(ItemIdentifiers.ADAMANT_BATTLEAXE, 1, 1, 1, Table.NONE),
		ADAMANT_AXE(ItemIdentifiers.ADAMANT_AXE, 1, 1, 1, Table.NONE),
		ADAMANT_PICKAXE(ItemIdentifiers.ADAMANT_PICKAXE, 1, 1, 1, Table.NONE),
		ADAMANT_DAGGER(ItemIdentifiers.ADAMANT_DAGGER, 1, 1, 1, Table.NONE),
		ADAMANT_PLATEBODY(ItemIdentifiers.ADAMANT_PLATEBODY, 1, 1, 1, Table.NONE),
		PURPLE_SWEETS(ItemIdentifiers.PURPLE_SWEETS_2, 5, 5, 1, Table.NONE),
		FIRE_BATTLESTAFF(ItemIdentifiers.FIRE_BATTLESTAFF, 1, 1, 1, Table.NONE),
		GREEN_DHIDE_CHAPS(ItemIdentifiers.GREEN_DHIDE_CHAPS, 1, 1, 1, Table.NONE),
		GREEN_DHIDE_BODY(ItemIdentifiers.GREEN_DHIDE_BODY, 1, 1, 1, Table.NONE),
		YEW_SHORTBOW(ItemIdentifiers.YEW_SHORTBOW, 1, 1, 1, Table.NONE),
		MEDIUM_AMULET(-1, -1, -1, 1, Table.EASY_STANDARD_AMULET),
		MEDIUM_BOW(-1, -1, -1, 1, Table.EASY_STANDARD_BOW),
		MEDIUM_FIRELIGHTER(-1, -1, -1, 1, Table.GENERAL_FIRELIGHTER),
		GENERAL_BLESSINGS(-1, -1, -1, 1, Table.GENERAL_BLESSING),
		GENERAL_PRAYER_PAGE(-1, -1, -1, 1, Table.GENERAL_PRAYER_PAGE),
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
		AMULET_OF_POWER(ItemIdentifiers.AMULET_OF_POWER, 1, 1, 9, Table.NONE),
		AMULET_OF_STRENGTH_TRIM(ItemIdentifiers.STRENGTH_AMULET_T_, 1, 1, 1, Table.NONE);
		
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
	
	public enum Standard_Bow {
		YEW_LONGBOW(ItemIdentifiers.YEW_LONGBOW, 1, 1, 9, Table.NONE),
		YEW_COMPOSITE_BOW(ItemIdentifiers.YEW_COMP_BOW, 1, 1, 1, Table.NONE);
		
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
	
	public enum Standard_Firelighter {
		GNOMISH_FIRELIGHTER(ItemIdentifiers.GNOMISH_FIRELIGHTER, 1, 1, 1, Table.NONE),
		GENERAL_FIRELIGHTER(-1, -1, -1, 9, Table.GENERAL_FIRELIGHTER);
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Standard_Firelighter(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
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
		RANGER_BOOTS(ItemIdentifiers.RANGER_BOOTS, 1, 1, 1, Table.NONE),
		WIZARD_BOOTS(ItemIdentifiers.WIZARD_BOOTS, 1, 1, 1, Table.NONE),
		ADAMANT_PLATEBODY_TRIM(ItemIdentifiers.ADAMANT_PLATEBODY_T_, 1, 1, 1, Table.NONE),
		ADAMANT_PLATELEGS_TRIM(ItemIdentifiers.ADAMANT_PLATELEGS_T_, 1, 1, 1, Table.NONE),
		ADAMANT_PLATESKIRT_TRIM(ItemIdentifiers.ADAMANT_PLATESKIRT_T_, 1, 1, 1, Table.NONE),
		ADAMANT_KITESHIELD_TRIM(ItemIdentifiers.ADAMANT_KITESHIELD_T_, 1, 1, 1, Table.NONE),
		ADAMANT_FULL_HELM_TRIM(ItemIdentifiers.ADAMANT_FULL_HELM_T_, 1, 1, 1, Table.NONE),
		ADAMANT_PLATEBODY_GOLD(ItemIdentifiers.ADAMANT_PLATEBODY_G_, 1, 1, 1, Table.NONE),
		ADAMANT_PLATELEGS_GOLD(ItemIdentifiers.ADAMANT_PLATELEGS_G_, 1, 1, 1, Table.NONE),
		ADAMANT_PLATESKIRT_GOLD(ItemIdentifiers.ADAMANT_PLATESKIRT_G_, 1, 1, 1, Table.NONE),
		ADAMANT_KITESHIELD_GOLD(ItemIdentifiers.ADAMANT_KITESHIELD_G_, 1, 1, 1, Table.NONE),
		ADAMANT_FULL_HELM_GOLD(ItemIdentifiers.ADAMANT_FULL_HELM_G_, 1, 1, 1, Table.NONE),
		RED_HEADBAND(ItemIdentifiers.RED_HEADBAND, 1, 1, 1, Table.NONE),
		BLACK_HEADBAND(ItemIdentifiers.BLACK_HEADBAND, 1, 1, 1, Table.NONE),
		BROWN_HEADBAND(ItemIdentifiers.BROWN_HEADBAND, 1, 1, 1, Table.NONE),
		ADAMANT_SHIELD_H1(ItemIdentifiers.ADAMANT_SHIELD_H1_, 1, 1, 1, Table.NONE),
		ADAMANT_SHIELD_H2(ItemIdentifiers.ADAMANT_SHIELD_H2_, 1, 1, 1, Table.NONE),
		ADAMANT_SHIELD_H3(ItemIdentifiers.ADAMANT_SHIELD_H3_, 1, 1, 1, Table.NONE),
		ADAMANT_SHIELD_H4(ItemIdentifiers.ADAMANT_SHIELD_H4_, 1, 1, 1, Table.NONE),
		ADAMANT_SHIELD_H5(ItemIdentifiers.ADAMANT_SHIELD_H5_, 1, 1, 1, Table.NONE),
		RED_BOATER(ItemIdentifiers.RED_BOATER, 1, 1, 1, Table.NONE),
		ORANGE_BOATER(ItemIdentifiers.ORANGE_BOATER, 1, 1, 1, Table.NONE),
		GREEN_BOATER(ItemIdentifiers.GREEN_BOATER, 1, 1, 1, Table.NONE),
		BLACK_BOATER(ItemIdentifiers.BLACK_BOATER, 1, 1, 1, Table.NONE),
		BLUE_BOATER(ItemIdentifiers.BLUE_BOATER, 1, 1, 1, Table.NONE),
		GREEN_DHIDE_BODY_GOLD(ItemIdentifiers.GREEN_DHIDE_BODY_G_, 1, 1, 1, Table.NONE),
		GREEN_DHIDE_BODY_TRIM(ItemIdentifiers.GREEN_DHIDE_BODY_T_, 1, 1, 1, Table.NONE),
		GREEN_DHIDE_CHAPS_GOLD(ItemIdentifiers.GREEN_DHIDE_CHAPS_G_, 1, 1, 1, Table.NONE),
		GREEN_DHIDE_CHAPS_TRIM(ItemIdentifiers.GREEN_DHIDE_CHAPS_T_, 1, 1, 1, Table.NONE),
		ADAMANT_HELM_H1(ItemIdentifiers.ADAMANT_HELM_H1_, 1, 1, 1, Table.NONE),
		ADAMANT_HELM_H2(ItemIdentifiers.ADAMANT_HELM_H2_, 1, 1, 1, Table.NONE),
		ADAMANT_HELM_H3(ItemIdentifiers.ADAMANT_HELM_H3_, 1, 1, 1, Table.NONE),
		ADAMANT_HELM_H4(ItemIdentifiers.ADAMANT_HELM_H4_, 1, 1, 1, Table.NONE),
		ADAMANT_HELM_H5(ItemIdentifiers.ADAMANT_HELM_H5_, 1, 1, 1, Table.NONE),
		SARADOMIN_MITRE(ItemIdentifiers.SARADOMIN_MITRE, 1, 1, 1, Table.NONE),
		SARADOMIN_CLOAK(ItemIdentifiers.SARADOMIN_CLOAK, 1, 1, 1, Table.NONE),
		GUTHIX_MITRE(ItemIdentifiers.GUTHIX_MITRE, 1, 1, 1, Table.NONE),
		GUTHIX_CLOAK(ItemIdentifiers.GUTHIX_CLOAK, 1, 1, 1, Table.NONE),
		ZAMORAK_MITRE(ItemIdentifiers.ZAMORAK_MITRE, 1, 1, 1, Table.NONE),
		ZAMORAK_CLOAK(ItemIdentifiers.ZAMORAK_CLOAK, 1, 1, 1, Table.NONE),
		MITHRIL_PLATEBODY_TRIM(ItemIdentifiers.MITHRIL_PLATEBODY_T_, 1, 1, 1, Table.NONE),
		MITHRIL_PLATELEGS_TRIM(ItemIdentifiers.MITHRIL_PLATELEGS_T_, 1, 1, 1, Table.NONE),
		MITHRIL_PLATESKIRT_TRIM(ItemIdentifiers.MITHRIL_PLATESKIRT_T_, 1, 1, 1, Table.NONE),
		MITHRIL_KITESHIELD_TRIM(ItemIdentifiers.MITHRIL_KITESHIELD_T_, 1, 1, 1, Table.NONE),
		MITHRIL_FULL_HELM_TRIM(ItemIdentifiers.MITHRIL_FULL_HELM_T_, 1, 1, 1, Table.NONE),
		MITHRIL_PLATEBODY_GOLD(ItemIdentifiers.MITHRIL_PLATEBODY_G_, 1, 1, 1, Table.NONE),
		MITHRIL_PLATELEGS_GOLD(ItemIdentifiers.MITHRIL_PLATELEGS_G_, 1, 1, 1, Table.NONE),
		MITHRIL_PLATESKIRT_GOLD(ItemIdentifiers.MITHRIL_PLATESKIRT_G_, 1, 1, 1, Table.NONE),
		MITHRIL_KITESHIELD_GOLD(ItemIdentifiers.MITHRIL_KITESHIELD_G_, 1, 1, 1, Table.NONE),
		MITHRIL_FULL_HELM_GOLD(ItemIdentifiers.MITHRIL_FULL_HELM_G_, 1, 1, 1, Table.NONE),
		LEPRECHAUN_HAT(ItemIdentifiers.LEPRECHAUN_HAT, 1, 1, 1, Table.NONE),
		WHITE_HEADBAND(ItemIdentifiers.WHITE_HEADBAND, 1, 1, 1, Table.NONE),
		BLUE_HEADBAND(ItemIdentifiers.BLUE_HEADBAND, 1, 1, 1, Table.NONE),
		GOLD_HEADBAND(ItemIdentifiers.GOLD_HEADBAND, 1, 1, 1, Table.NONE),
		PINK_HEADBAND(ItemIdentifiers.PINK_HEADBAND, 1, 1, 1, Table.NONE),
		GREEN_HEADBAND(ItemIdentifiers.GREEN_HEADBAND, 1, 1, 1, Table.NONE),
		PINK_BOATER(ItemIdentifiers.PINK_BOATER, 1, 1, 1, Table.NONE),
		PURPLE_BOATER(ItemIdentifiers.PURPLE_BOATER, 1, 1, 1, Table.NONE),
		WHITE_BOATER(ItemIdentifiers.WHITE_BOATER, 1, 1, 1, Table.NONE),
		CAT_MASK(ItemIdentifiers.CAT_MASK, 1, 1, 1, Table.NONE),
		PENGUIN_MASK(ItemIdentifiers.PENGUIN_MASK, 1, 1, 1, Table.NONE),
		ANCIENT_MITRE(ItemIdentifiers.ANCIENT_MITRE, 1, 1, 1, Table.NONE),
		ANCIENT_CLOAK(ItemIdentifiers.ANCIENT_CLOAK, 1, 1, 1, Table.NONE),
		ARMADYL_MITRE(ItemIdentifiers.ARMADYL_MITRE, 1, 1, 1, Table.NONE),
		ARMADYL_CLOAK(ItemIdentifiers.ARMADYL_CLOAK, 1, 1, 1, Table.NONE),
		BANDOS_MITRE(ItemIdentifiers.BANDOS_MITRE, 1, 1, 1, Table.NONE),
		BANDOS_CLOAK(ItemIdentifiers.BANDOS_CLOAK, 1, 1, 1, Table.NONE),
		ANCIENT_STOLE(ItemIdentifiers.ANCIENT_STOLE, 1, 1, 1, Table.NONE),
		ANCIENT_STAFF(ItemIdentifiers.ANCIENT_CROZIER, 1, 1, 1, Table.NONE),
		ARMADYL_STOLE(ItemIdentifiers.ARMADYL_STOLE, 1, 1, 1, Table.NONE),
		ARMADYL_STAFF(ItemIdentifiers.ARMADYL_CROZIER, 1, 1, 1, Table.NONE),
		BANDOS_STOLE(ItemIdentifiers.BANDOS_STOLE, 1, 1, 1, Table.NONE),
		BANDOS_STAFF(ItemIdentifiers.BANDOS_CROZIER, 1, 1, 1, Table.NONE),
		CRIER_HAT(ItemIdentifiers.CRIER_HAT, 1, 1, 1, Table.NONE),
		ADAMANT_CANE(ItemIdentifiers.ADAMANT_CANE, 1, 1, 1, Table.NONE),
		ARCEUUS_BANNER(ItemIdentifiers.ARCEUUS_BANNER, 1, 1, 1, Table.NONE),
		PISCARILIUS_BANNER(ItemIdentifiers.PISCARILIUS_BANNER, 1, 1, 1, Table.NONE),
		HOSIDIUS_BANNER(ItemIdentifiers.HOSIDIUS_BANNER, 1, 1, 1, Table.NONE),
		SHAYZIEN_BANNER(ItemIdentifiers.SHAYZIEN_BANNER, 1, 1, 1, Table.NONE),
		LOVAKENGJ_BANNER(ItemIdentifiers.LOVAKENGJ_BANNER, 1, 1, 1, Table.NONE),
		CABBAGE_SHIELD(ItemIdentifiers.CABBAGE_ROUND_SHIELD, 1, 1, 1, Table.NONE),
		CRIER_COAT(ItemIdentifiers.CRIER_COAT, 1, 1, 1, Table.NONE),
		CRIER_BELL(ItemIdentifiers.CRIER_BELL, 1, 1, 1, Table.NONE),
		BLACK_LEPRECHAUN_HAT(ItemIdentifiers.BLACK_LEPRECHAUN_HAT, 1, 1, 1, Table.NONE),
		HOLY_SANDLES(ItemIdentifiers.HOLY_SANDALS, 1, 1, 1, Table.NONE),
		//ADAMANT_PLATEBODY_H1(1, 1, 1, 1, Table.NONE),
		//ADAMANT_PLATEBODY_H2(1, 1, 1, 1, Table.NONE),
		//ADAMANT_PLATEBODY_H3(1, 1, 1, 1, Table.NONE),
		//ADAMANT_PLATEBODY_H4(1, 1, 1, 1, Table.NONE),
		//ADAMANT_PLATEBODY_H5(1, 1, 1, 1, Table.NONE),
		//WOLF_MASK(1, 1, 1, 1, Table.NONE),
		//WOLF_CLOAK(1, 1, 1, 1, Table.NONE),
		//CLIMBING_BOOTS_GOLD(1, 1, 1, 1, Table.NONE),
		//SPIKED_MANACLES(1, 1, 1, 1, Table.NONE),
		UNICORN(-1, -1, -1, 1, Table.MEDIUM_RARE_UNICORN),
		ELEGANT(-1, -1, -1, 8, Table.MEDIUM_RARE_ELEGANT);
		
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
	
	public enum Rare_Unicorn {
		Black(ItemIdentifiers.BLACK_UNICORN_MASK, 1, 1, 1, Table.NONE),
		WHITE(ItemIdentifiers.WHITE_UNICORN_MASK, 1, 1, 1, Table.NONE);
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Rare_Unicorn(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
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
		PRUPLE_ELEGANT_SHIRT(ItemIdentifiers.PURPLE_ELEGANT_SHIRT, 1, 1, 1, Table.NONE),
		PURPLE_ELEGANT_LEGS(ItemIdentifiers.PURPLE_ELEGANT_LEGS, 1, 1, 1, Table.NONE),
		PURPLE_ELEGANT_BLOUSE(ItemIdentifiers.PURPLE_ELEGANT_BLOUSE, 1, 1, 1, Table.NONE),
		PURPLE_ELEGANT_SKIRT(ItemIdentifiers.PURPLE_ELEGANT_SKIRT, 1, 1, 1, Table.NONE),
		BLACK_ELEGANT_SHIRT(ItemIdentifiers.BLACK_ELEGANT_SHIRT, 1, 1, 1, Table.NONE),
		BLACK_ELEGANT_LEGS(ItemIdentifiers.BLACK_ELEGANT_LEGS, 1, 1, 1, Table.NONE),
		//BLACK_ELEGANT_BLOUSE(ItemIdentifiers.BLACK_ELEGANT_BLOUSE, 1, 1, 1, Table.NONE),
		//BLACK_ELEGANT_SKIRT(ItemIdentifiers.BLACK_ELEGANT_SKIRT, 1, 1, 1, Table.NONE),
		PINK_ELEGANT_SHIRT(ItemIdentifiers.PINK_ELEGANT_SHIRT, 1, 1, 1, Table.NONE),
		PINK_ELEGANT_LEGS(ItemIdentifiers.PINK_ELEGANT_LEGS, 1, 1, 1, Table.NONE),
		PINK_ELEGANT_BLOUSE(ItemIdentifiers.PINK_ELEGANT_BLOUSE, 1, 1, 1, Table.NONE),
		PINK_ELEGANT_SKIRT(ItemIdentifiers.PINK_ELEGANT_SKIRT, 1, 1, 1, Table.NONE),
		GOLD_ELEGANT_SHIRT(ItemIdentifiers.GOLD_ELEGANT_SHIRT, 1, 1, 1, Table.NONE),
		GOLD_ELEGANT_LEGS(ItemIdentifiers.GOLD_ELEGANT_LEGS, 1, 1, 1, Table.NONE),
		GOLD_ELEGANT_BLOUSE(ItemIdentifiers.GOLD_ELEGANT_BLOUSE, 1, 1, 1, Table.NONE),
		GOLD_ELEGANT_SKIRT(ItemIdentifiers.GOLD_ELEGANT_SKIRT, 1, 1, 1, Table.NONE);
		
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
