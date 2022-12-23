package com.elvarg.game.content.cluescrolls.rewards.data;

import com.elvarg.util.ItemIdentifiers;

public class HardClueTable {
	public static final int MINIMUM_ROLLS = 4;
	public static final int MAXIMUM_ROLLS = 6;
	public static final int STANDARD_WEIGHT = 12;
	public static final int RARE_WEIGHT = 1;
	public enum Standard {
		COINS(995, 1000, 5000, 1, Table.NONE),
		LOBSTER(ItemIdentifiers.LOBSTER_2, 12, 15, 1, Table.NONE),
		SHARK(ItemIdentifiers.SHARK_2, 12, 15, 1, Table.NONE),
		LAW_RUNE(ItemIdentifiers.LAW_RUNE, 30, 50, 1, Table.NONE),
		BLOOD_RUNE(ItemIdentifiers.BLOOD_RUNE, 20, 30, 1, Table.NONE),
		NATURE_RUNE(ItemIdentifiers.NATURE_RUNE, 30, 50, 1, Table.NONE),
		PURPLE_SWEETS(ItemIdentifiers.PURPLE_SWEETS_2, 7, 15, 1, Table.NONE),
		RUNE_LONGSWORD(ItemIdentifiers.RUNE_LONGSWORD, 1, 1, 1, Table.NONE),
		RUNE_FULL_HELM(ItemIdentifiers.RUNE_FULL_HELM, 1, 1, 1, Table.NONE),
		RUNE_PLATELEGS(ItemIdentifiers.RUNE_PLATELEGS, 1, 1, 1, Table.NONE),
		RUNE_BATTLEAXE(ItemIdentifiers.RUNE_BATTLEAXE, 1, 1, 1, Table.NONE),
		RUNE_AXE(ItemIdentifiers.RUNE_AXE, 1, 1, 1, Table.NONE),
		RUNE_PICKAXE(ItemIdentifiers.RUNE_PICKAXE , 1, 1, 1, Table.NONE),
		RUNE_DAGGER(ItemIdentifiers.RUNE_DAGGER, 1, 1, 1, Table.NONE),
		RUNE_PLATEBODY(ItemIdentifiers.RUNE_PLATEBODY, 1, 1, 1, Table.NONE),
		RUNE_PLATESKIRT(ItemIdentifiers.RUNE_PLATESKIRT, 1, 1, 1, Table.NONE),
		RUNE_KITESHIELD(ItemIdentifiers.RUNE_KITESHIELD, 1, 1, 1, Table.NONE),
		BLACK_DHIDE_CHAPS(ItemIdentifiers.BLACK_DHIDE_CHAPS, 1, 1, 1, Table.NONE),
		BLACK_DHIDE_BODY(ItemIdentifiers.BLACK_DHIDE_BODY, 1, 1, 1, Table.NONE),
		MAGIC_SHORTBOW(ItemIdentifiers.MAGIC_SHORTBOW, 1, 1, 1, Table.NONE),
		HARD_STANDARD_BOW(-1, -1, -1, 1, Table.HARD_STANDARD_BOW),
		HARD_GENERAL_PRAYER_PAGE(-1, -1, -1, 1, Table.GENERAL_PRAYER_PAGE),
		HARD_GENERAL_FIRELIGHTER(-1, -1, -1, 1, Table.GENERAL_FIRELIGHTER),
		HARD_GENERAL_TELEPORT_SCROLL(-1, -1, -1, 1, Table.GENERAL_TELEPORT_SCROLL),
		HARD_GENERAL_BLESSING(-1, -1, -1, 1, Table.GENERAL_BLESSING);
		
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
	
	public enum Standard_Bow {
		MAGIC_LONGBOW(ItemIdentifiers.MAGIC_LONGBOW, 1, 1, 9, Table.NONE),
		MAGIC_COMPOSITE_BOW(ItemIdentifiers.MAGIC_COMP_BOW, 1, 1, 1, Table.NONE);
		
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
		ROBIN_HOOD_HAT(ItemIdentifiers.ROBIN_HOOD_HAT, 1, 1, 1, Table.NONE),
		RUNE_PLATEBODY_TRIM(ItemIdentifiers.RUNE_PLATEBODY_T_, 1, 1, 1, Table.NONE),
		RUNE_PLATELEGS_TRIM(ItemIdentifiers.RUNE_PLATELEGS_T_, 1, 1, 1, Table.NONE),
		RUNE_KITESHIELD_TRIM(ItemIdentifiers.RUNE_KITESHIELD_T_, 1, 1, 1, Table.NONE),
		RUNE_FULL_HELM_TRIM(ItemIdentifiers.RUNE_FULL_HELM_T_, 1, 1, 1, Table.NONE),
		RUNE_PLATESKIRT_TRIM(ItemIdentifiers.RUNE_PLATESKIRT_T_, 1, 1, 1, Table.NONE),
		RUNE_PLATEBODY_GOLD(ItemIdentifiers.RUNE_PLATEBODY_G_, 1, 1, 1, Table.NONE),
		RUNE_PLATELEGS_GOLD(ItemIdentifiers.RUNE_PLATELEGS_G_, 1, 1, 1, Table.NONE),
		RUNE_KITESHIELD_GOLD(ItemIdentifiers.RUNE_KITESHIELD_G_, 1, 1, 1, Table.NONE),
		RUNE_FULL_HELM_GOLD(ItemIdentifiers.RUNE_FULL_HELM_G_, 1, 1, 1, Table.NONE),
		RUNE_PLATEBODY_ZAMORAK(ItemIdentifiers.ZAMORAK_PLATEBODY, 1, 1, 1, Table.NONE),
		RUNE_PLATELEGS_ZAMORAK(ItemIdentifiers.ZAMORAK_PLATELEGS, 1, 1, 1, Table.NONE),
		RUNE_KITESHIELD_ZAMORAK(ItemIdentifiers.ZAMORAK_KITESHIELD, 1, 1, 1, Table.NONE),
		RUNE_FULL_HELM_ZAMORAK(ItemIdentifiers.ZAMORAK_FULL_HELM, 1, 1, 1, Table.NONE),
		RUNE_PLATESKIRT_ZAMORAK(ItemIdentifiers.ZAMORAK_PLATESKIRT, 1, 1, 1, Table.NONE),
		RUNE_PLATEBODY_SARADOMIN(ItemIdentifiers.SARADOMIN_PLATEBODY, 1, 1, 1, Table.NONE),
		RUNE_PLATELEGS_SARADOMIN(ItemIdentifiers.SARADOMIN_PLATELEGS, 1, 1, 1, Table.NONE),
		RUNE_KITESHIELD_SARADOMIN(ItemIdentifiers.SARADOMIN_KITESHIELD, 1, 1, 1, Table.NONE),
		RUNE_FULL_HELM_SARADOMIN(ItemIdentifiers.SARADOMIN_FULL_HELM, 1, 1, 1, Table.NONE),
		RUNE_PLATESKIRT_SARADOMIN(ItemIdentifiers.SARADOMIN_PLATESKIRT, 1, 1, 1, Table.NONE),
		RUNE_PLATEBODY_GUTHIX(ItemIdentifiers.GUTHIX_PLATEBODY, 1, 1, 1, Table.NONE),
		RUNE_PLATELEGS_GUTHIX(ItemIdentifiers.GUTHIX_PLATELEGS, 1, 1, 1, Table.NONE),
		RUNE_KITESHIELD_GUTHIX(ItemIdentifiers.GUTHIX_KITESHIELD, 1, 1, 1, Table.NONE),
		RUNE_FULL_HELM_GUTHIX(ItemIdentifiers.GUTHIX_FULL_HELM, 1, 1, 1, Table.NONE),
		RUNE_PLATESKIRT_GUTHIX(ItemIdentifiers.GUTHIX_PLATESKIRT, 1, 1, 1, Table.NONE),
		TAN_CAVALIER(ItemIdentifiers.TAN_CAVALIER, 1, 1, 1, Table.NONE),
		DARK_CAVALIER(ItemIdentifiers.DARK_CAVALIER, 1, 1, 1, Table.NONE),
		BLACK_CAVALIER(ItemIdentifiers.BLACK_CAVALIER, 1, 1, 1, Table.NONE),
		PIRATE_HAT(ItemIdentifiers.PIRATE_HAT, 1, 1, 1, Table.NONE),
		RUNE_SHIELD_H1(ItemIdentifiers.RUNE_SHIELD_H1_, 1, 1, 1, Table.NONE),
		RUNE_SHIELD_H2(ItemIdentifiers.RUNE_SHIELD_H2_, 1, 1, 1, Table.NONE),
		RUNE_SHIELD_H3(ItemIdentifiers.RUNE_SHIELD_H3_, 1, 1, 1, Table.NONE),
		RUNE_SHIELD_H4(ItemIdentifiers.RUNE_SHIELD_H4_, 1, 1, 1, Table.NONE),
		RUNE_SHIELD_H5(ItemIdentifiers.RUNE_SHIELD_H5_, 1, 1, 1, Table.NONE),
		BLUE_DHIDE_BODY_GOLD(ItemIdentifiers.BLUE_DHIDE_BODY_G_, 1, 1, 1, Table.NONE),
		BLUE_DHIDE_BODY_TRIM(ItemIdentifiers.BLUE_DHIDE_BODY_T_, 1, 1, 1, Table.NONE),
		BLUE_DHIDE_CHAPS_GOLD(ItemIdentifiers.BLUE_DHIDE_CHAPS_G_, 1, 1, 1, Table.NONE),
		BLUE_DHIDE_CHAPS_TRIM(ItemIdentifiers.BLUE_DHIDE_CHAPS_T_, 1, 1, 1, Table.NONE),
		ENCHANTED_HAT(ItemIdentifiers.ENCHANTED_HAT, 1, 1, 1, Table.NONE),
		ENCHANTED_TOP(ItemIdentifiers.ENCHANTED_TOP, 1, 1, 1, Table.NONE),
		ENCHANTED_ROBE(ItemIdentifiers.ENCHANTED_ROBE, 1, 1, 1, Table.NONE),
		RUNE_HELM_H1(ItemIdentifiers.RUNE_HELM_H1_, 1, 1, 1, Table.NONE),
		RUNE_HELM_H2(ItemIdentifiers.RUNE_HELM_H2_, 1, 1, 1, Table.NONE),
		RUNE_HELM_H3(ItemIdentifiers.RUNE_HELM_H3_, 1, 1, 1, Table.NONE),
		RUNE_HELM_H4(ItemIdentifiers.RUNE_HELM_H4_, 1, 1, 1, Table.NONE),
		RUNE_HELM_H5(ItemIdentifiers.RUNE_HELM_H5_, 1, 1, 1, Table.NONE),
		AMULET_OF_GLORY_TRIM(ItemIdentifiers.AMULET_OF_GLORY_T6_, 1, 1, 1, Table.NONE),
		ZAMORAK_BRACERS(ItemIdentifiers.ZAMORAK_BRACERS, 1, 1, 1, Table.NONE),
		ZAMORAK_DHIDE(ItemIdentifiers.ZAMORAK_DHIDE, 1, 1, 1, Table.NONE),
		ZAMORAK_CHAPS(ItemIdentifiers.ZAMORAK_CHAPS, 1, 1, 1, Table.NONE),
		ZAMORAK_COIF(ItemIdentifiers.ZAMORAK_COIF, 1, 1, 1, Table.NONE),
		GUTHIX_BRACERS(ItemIdentifiers.GUTHIX_BRACERS, 1, 1, 1, Table.NONE),
		GUTHIX_DHIDE(ItemIdentifiers.GUTHIX_DRAGONHIDE, 1, 1, 1, Table.NONE),
		GUTHIX_CHAPS(ItemIdentifiers.GUTHIX_CHAPS, 1, 1, 1, Table.NONE),
		GUTHIX_COIF(ItemIdentifiers.GUTHIX_COIF, 1, 1, 1, Table.NONE),
		SARADOMIN_BRACERS(ItemIdentifiers.SARADOMIN_BRACERS, 1, 1, 1, Table.NONE),
		SARADOMIN_DHIDE(ItemIdentifiers.SARADOMIN_BRACERS, 1, 1, 1, Table.NONE),
		SARADOMIN_CHAPS(ItemIdentifiers.SARADOMIN_CHAPS, 1, 1, 1, Table.NONE),
		SARADOMIN_COIF(ItemIdentifiers.SARADOMIN_COIF, 1, 1, 1, Table.NONE),
		SARADOMIN_CROZIER(ItemIdentifiers.SARADOMIN_CROZIER, 1, 1, 1, Table.NONE),
		GUTHIX_CROZIER(ItemIdentifiers.GUTHIX_CROZIER, 1, 1, 1, Table.NONE),
		ZAMORAK_CROZIER(ItemIdentifiers.ZAMORAK_CROZIER, 1, 1, 1, Table.NONE),
		SARADOMIN_STOLE(ItemIdentifiers.SARADOMIN_STOLE, 1, 1, 1, Table.NONE),
		GUTHX_STOLE(ItemIdentifiers.GUTHIX_STOLE, 1, 1, 1, Table.NONE),
		ZAMORAK_STOLE(ItemIdentifiers.ZAMORAK_STOLE, 1, 1, 1, Table.NONE),
		RED_DHIDE_BODY_TRIM(ItemIdentifiers.RED_DHIDE_BODY_T_, 1, 1, 1, Table.NONE),
		RED_DHIDE_CHAPS_TRIM(ItemIdentifiers.RED_DHIDE_CHAPS_T_, 1, 1, 1, Table.NONE),
		RED_DHIDE_BODY_GOLD(ItemIdentifiers.RED_DHIDE_BODY_G_, 1, 1, 1, Table.NONE),
		RED_DHIDE_CHAPS_GOLD(ItemIdentifiers.RED_DHIDE_CHAPS_G_, 1, 1, 1, Table.NONE),
		WHITE_CAVALIER(ItemIdentifiers.WHITE_CAVALIER, 1, 1, 1, Table.NONE),
		RED_CAVALIER(ItemIdentifiers.RED_CAVALIER, 1, 1, 1, Table.NONE),
		NAVY_CAVALIER(ItemIdentifiers.NAVY_CAVALIER, 1, 1, 1, Table.NONE),
		PITH_HELMET(ItemIdentifiers.PITH_HELMET, 1, 1, 1, Table.NONE),
		EXPLORER_BACKPACK(ItemIdentifiers.EXPLORER_BACKPACK, 1, 1, 1, Table.NONE),
		BANDOS_PLATEBODY(ItemIdentifiers.BANDOS_PLATEBODY, 1, 1, 1, Table.NONE),
		BANDOS_PLATELEGS(ItemIdentifiers.BANDOS_PLATELEGS, 1, 1, 1, Table.NONE),
		BANDOS_PLATESKIRT(ItemIdentifiers.BANDOS_PLATESKIRT, 1, 1, 1, Table.NONE),
		BANDOS_FULLHELM(ItemIdentifiers.BANDOS_FULL_HELM, 1, 1, 1, Table.NONE),
		BANDOS_KITESHIELD(ItemIdentifiers.BANDOS_KITESHIELD, 1, 1, 1, Table.NONE),
		ARMADYL_PLATEBODY(ItemIdentifiers.ARMADYL_PLATEBODY, 1, 1, 1, Table.NONE),
		ARMADYL_PLATELEGS(ItemIdentifiers.ARMADYL_PLATELEGS, 1, 1, 1, Table.NONE),
		ARMADYL_PLATESKIRT(ItemIdentifiers.ARMADYL_PLATESKIRT, 1, 1, 1, Table.NONE),
		ARMADYL_FULLHELM(ItemIdentifiers.ARMADYL_FULL_HELM, 1, 1, 1, Table.NONE),
		ARMADYL_KITESHIELD(ItemIdentifiers.ARMADYL_KITESHIELD, 1, 1, 1, Table.NONE),
		ANCIENT_PLATEBODY(ItemIdentifiers.ANCIENT_PLATEBODY, 1, 1, 1, Table.NONE),
		ANCIENT_PLATELEGS(ItemIdentifiers.ANCIENT_PLATELEGS, 1, 1, 1, Table.NONE),
		ANCIENT_PLATESKIRT(ItemIdentifiers.ANCIENT_PLATESKIRT, 1, 1, 1, Table.NONE),
		ANCIENT_FULLHELM(ItemIdentifiers.ANCIENT_FULL_HELM, 1, 1, 1, Table.NONE),
		ANCIENT_KITESHIELD(ItemIdentifiers.ANCIENT_KITESHIELD, 1, 1, 1, Table.NONE),
		ANCIENT_BRACERS(ItemIdentifiers.ANCIENT_BRACERS, 1, 1, 1, Table.NONE),
		ANCIENT_DHIDE(ItemIdentifiers.ANCIENT_DHIDE, 1, 1, 1, Table.NONE),
		ANCIENT_CHAPS(ItemIdentifiers.ANCIENT_CHAPS, 1, 1, 1, Table.NONE),
		ANCIENT_COIF(ItemIdentifiers.ANCIENT_COIF, 1, 1, 1, Table.NONE),
		BANDOS_BRACERS(ItemIdentifiers.BANDOS_BRACERS, 1, 1, 1, Table.NONE),
		BANDOS_DHIDE(ItemIdentifiers.BANDOS_DHIDE, 1, 1, 1, Table.NONE),
		BANDOS_CHAPS(ItemIdentifiers.BANDOS_CHAPS, 1, 1, 1, Table.NONE),
		BANDOS_COIF(ItemIdentifiers.BANDOS_COIF, 1, 1, 1, Table.NONE),	
		ARMADYL_BRACERS(ItemIdentifiers.ARMADYL_BRACERS, 1, 1, 1, Table.NONE),
		ARMADYL_DHIDE(ItemIdentifiers.ARMADYL_DHIDE, 1, 1, 1, Table.NONE),
		ARMADYL_CHAPS(ItemIdentifiers.ARMADYL_CHAPS, 1, 1, 1, Table.NONE),
		ARMADYL_COIF(ItemIdentifiers.ARMADYL_COIF, 1, 1, 1, Table.NONE),
		GREEN_DRAGON_MASK(ItemIdentifiers.GREEN_DRAGON_MASK, 1, 1, 1, Table.NONE),
		BLUE_DRAGON_MASK(ItemIdentifiers.BLUE_DRAGON_MASK, 1, 1, 1, Table.NONE),
		RED_DRAGON_MASK(ItemIdentifiers.RED_DRAGON_MASK, 1, 1, 1, Table.NONE),
		BLACK_DRAGON_MASK(ItemIdentifiers.BLACK_DRAGON_MASK, 1, 1, 1, Table.NONE),
		ZOMBIE_HEAD(ItemIdentifiers.ZOMBIE_HEAD, 1, 1, 1, Table.NONE),
		NUNCHAKU(ItemIdentifiers.NUNCHAKU, 1, 1, 1, Table.NONE),
		CYCLOPS_HEAD(ItemIdentifiers.CYCLOPS_HEAD, 1, 1, 1, Table.NONE),
		ANCIENT_DHIDE_BOOTS(ItemIdentifiers.ANCIENT_DHIDE_BOOTS, 1, 1, 1, Table.NONE),
		BANDOS_DHIDE_BOOTS(ItemIdentifiers.BANDOS_DHIDE_BOOTS, 1, 1, 1, Table.NONE),
		GUTHIX_DHIDE_BOOTS(ItemIdentifiers.GUTHIX_DHIDE_BOOTS, 1, 1, 1, Table.NONE),
		ARMADYL_DHIDE_BOOTS(ItemIdentifiers.ARMADYL_DHIDE_BOOTS, 1, 1, 1, Table.NONE),
		SARADOMIN_DHIDE_BOOTS(ItemIdentifiers.SARADOMIN_DHIDE_BOOTS, 1, 1, 1, Table.NONE),
		ZAMORAK_DHIDE_BOOTS(ItemIdentifiers.ZAMORAK_DHIDE_BOOTS, 1, 1, 1, Table.NONE),
		//DRAGON_BOOTS_ORNAMENT_KIT(ItemIdentifiers., 1, 1, 1, Table.NONE),
		//DUAL_SAI(ItemIdentifiers, 1, 1, 1, Table.NONE),
		//THIEVING_BAG(ItemIdentifiers, 1, 1, 1, Table.NONE),
		//RUNE_DEFENDER_ORNAMENT_KIT(ItemIdentifiers, 1, 1, 1, Table.NONE),
		//TZHAAR_KET_OM_ORNAMENT_KIT(ItemIdentifiers, 1, 1, 1, Table.NONE),
		//BESERKER_NECKLACE_ORNAMENT_KIT(ItemIdentifiers.BESERKER, 1, 1, 1, Table.NONE),
		RUNE_CANE(ItemIdentifiers.RUNE_CANE, 1, 1, 1, Table.NONE),
		HARD_MEGA_RARE(-1, -1, -1, 1, Table.HARD_RARE_MEGA_RARE),
		//HARD_BLESSED_SHIELDS(-1, -1, -1, 1, Table.HARD_RARE_BLESSED_SHIELDS),
		//HARD_TRAIL_HERALDIC(-1, -1, -1, 1, Table.HARD_RARE_HERALDIC_PLATEBODY)
		;
		
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
	
	public enum Rare_Blessed_Shield {
		GUTHIX_DHIDE_SHIELD(-1, 1, 1, 1, Table.NONE),
		SARADOMIN_DHIDE_SHIELD(-1, 1, 1, 1, Table.NONE),
		ZAMORAK_DHIDE_SHIELD(-1, 1, 1, 1, Table.NONE),
		ANCIENT_DHIDE_SHIELD(-1, 1, 1, 1, Table.NONE),
		ARMADYL_DHIDE_SHIELD(-1, 1, 1, 1, Table.NONE),
		BANDOS_DHIDE_SHIELD(-1, 1, 1, 1, Table.NONE);
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Rare_Blessed_Shield(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
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
	
	public enum Rare_Mega_Rare {
		SUPER_ENERGY_POTION(ItemIdentifiers.SUPER_ENERGY_4_2, 15, 15, 1, Table.NONE),
		SUPER_RESTORE_POTION(ItemIdentifiers.SUPER_RESTORE_4_2, 15, 15, 1, Table.NONE),
		ANTIFIRE_POTION(ItemIdentifiers.ANTIFIRE_POTION_4_2, 15, 15, 1, Table.NONE),
		HARD_POTION(-1, -1, -1, 1, Table.HARD_RARE_POTION),
		HARD_THIRD_AGE(-1, -1, -1, 1, Table.HARD_RARE_THIRD_AGE),
		GILDED(-1, -1, -1, 5, Table.GENERAL_GILDED);
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Rare_Mega_Rare(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
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

	public enum Rare_Potion {
		SUPER_ATTACK_POTION(ItemIdentifiers.SUPER_ATTACK_4_2, 5, 5, 1, Table.NONE),
		SUPER_DEFENSE_POTION(ItemIdentifiers.SUPER_DEFENCE_4_2, 5, 5, 1, Table.NONE),
		SUPER_STRENGTH_POTION(ItemIdentifiers.SUPER_STRENGTH_4_2, 5, 5, 1, Table.NONE);
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Rare_Potion(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
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
	
	public enum Rare_Third_Age {
		THIRD_AGE_RANGE_COIF(ItemIdentifiers._3RD_AGE_RANGE_COIF, 1, 1, 1, Table.NONE),
		THIRD_AGE_RANGE_TOP(ItemIdentifiers._3RD_AGE_RANGE_TOP, 1, 1, 1, Table.NONE),
		THIRD_AGE_RANGE_LEGS(ItemIdentifiers._3RD_AGE_RANGE_LEGS, 1, 1, 1, Table.NONE),
		THIRD_AGE_VAMBRACES(ItemIdentifiers._3RD_AGE_VAMBRACES, 1, 1, 1, Table.NONE),
		THIRD_AGE_ROBE_TOP(ItemIdentifiers._3RD_AGE_ROBE_TOP, 1, 1, 1, Table.NONE),
		THIRD_AGE_ROBE(ItemIdentifiers._3RD_AGE_ROBE, 1, 1, 1, Table.NONE),
		THIRD_AGE_MAGE_HAT(ItemIdentifiers._3RD_AGE_MAGE_HAT, 1, 1, 1, Table.NONE),
		THIRD_AGE_AMULET(ItemIdentifiers._3RD_AGE_AMULET, 1, 1, 1, Table.NONE),
		THIRD_AGE_PLATELEGS(ItemIdentifiers._3RD_AGE_PLATELEGS, 1, 1, 1, Table.NONE),
		THIRD_AGE_PLATEBODY(ItemIdentifiers._3RD_AGE_PLATEBODY, 1, 1, 1, Table.NONE),
		THIRD_AGE_FULL_HELM(ItemIdentifiers._3RD_AGE_FULL_HELMET, 1, 1, 1, Table.NONE),
		//THIRD_AGE_PLATESKIRT(ItemIdentifiers, 1, 1, 1, Table.NONE),
		THIRD_AGE_KITESHIELD(ItemIdentifiers._3RD_AGE_KITESHIELD, 1, 1, 1, Table.NONE);
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Rare_Third_Age(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
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
