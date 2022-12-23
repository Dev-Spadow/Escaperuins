package com.elvarg.game.content.cluescrolls.rewards.data;

import com.elvarg.util.ItemIdentifiers;

public class GeneralClueTable {
 	public enum Blessings {
		COINS(995, 10000, 15000, 7, Table.NONE),
		PURPLE_SWEETS(10476, 8, 12, 7, Table.NONE),
		SARADOMIN(20220, 1, 1, 1, Table.NONE),
		ZAMORAK(20223, 1, 1, 1, Table.NONE),
		GUTHIX(20226, 1, 1, 1, Table.NONE),
		ANCIENT(20235, 1, 1, 1, Table.NONE),
		BANDOS(20232, 1, 1, 1, Table.NONE),
		ARMADYL(20229, 1, 1, 1, Table.NONE);
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Blessings(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
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
 	
 	public enum Firelighter {
 		RED(ItemIdentifiers.RED_FIRELIGHTER, 5, 15, 1, Table.NONE),
 		GREEN(ItemIdentifiers.GREEN_FIRELIGHTER, 5, 15, 1, Table.NONE),
 		BLUE(ItemIdentifiers.BLUE_FIRELIGHTER, 5, 15, 1, Table.NONE),
 		PURPLE(ItemIdentifiers.PURPLE_FIRELIGHTER, 5, 15, 1, Table.NONE),
 		WHITE(ItemIdentifiers.WHITE_FIRELIGHTER, 5, 15, 1, Table.NONE);
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Firelighter(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
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
 	
 	public enum Teleport_Scrolls {
 		NARDAH(12402, 5, 15, 1, Table.NONE),
 		MOS_LE_HARMLESS(12411, 5, 15, 1, Table.NONE),
 		MORTTON(12406, 5, 15, 1, Table.NONE),
 		FELDIP_HILLS(12404, 5, 15, 1, Table.NONE),
 		LUNAR_ISLE(12405, 5, 15, 1, Table.NONE),
 		DIGSITE(12403, 5, 15, 1, Table.NONE),
 		PISCATORIS(12408, 5, 15, 1, Table.NONE),
 		PEST_CONTROL(12407, 5, 15, 1, Table.NONE),
 		TAI_BWO_WANNAI(12409, 5, 15, 1, Table.NONE),
 		LUMBERYARD(12642, 5, 15, 1, Table.NONE),
 		CHARGE_DRAGONSTONE(20238, 5, 15, 1, Table.NONE),
 		ELF_CAMP(12410, 5, 15, 1, Table.NONE),
 		;
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Teleport_Scrolls(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
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
 	
 	public enum Prayer_Page {
 		SARADOMIN_PAGE_ONE(3827, 1, 1, 1, Table.NONE),
 		SARADOMIN_PAGE_TWO(3828, 1, 1, 1, Table.NONE),
 		SARADOMIN_PAGE_THREE(3829, 1, 1, 1, Table.NONE),
 		SARADOMIN_PAGE_FOUR(3830, 1, 1, 1, Table.NONE),
 		ZAMORAK_PAGE_ONE(3831, 1, 1, 1, Table.NONE),
 		ZAMORAK_PAGE_TWO(3832, 1, 1, 1, Table.NONE),
 		ZAMORAK_PAGE_THREE(3833, 1, 1, 1, Table.NONE),
 		ZAMORAK_PAGE_FOUR(3834, 1, 1, 1, Table.NONE),
 		GUTHIX_PAGE_ONE(3835, 1, 1, 1, Table.NONE),
 		GUTHIX_PAGE_TWO(3836, 1, 1, 1, Table.NONE),
 		GUTHIX_PAGE_THREE(3837, 1, 1, 1, Table.NONE),
 		GUTHIX_PAGE_FOUR(3838, 1, 1, 1, Table.NONE),
 		BANDOS_PAGE_ONE(12613, 1, 1, 1, Table.NONE),
 		BANDOS_PAGE_TWO(12614, 1, 1, 1, Table.NONE),
 		BANDOS_PAGE_THREE(12615, 1, 1, 1, Table.NONE),
 		BANDOS_PAGE_FOUR(12616, 1, 1, 1, Table.NONE),
 		ARMADYL_PAGE_ONE(12617, 1, 1, 1, Table.NONE),
 		ARMADYL_PAGE_TWO(12618, 1, 1, 1, Table.NONE),
 		ARMADYL_PAGE_THREE(12619, 1, 1, 1, Table.NONE),
 		ARMADYL_PAGE_FOUR(12620, 1, 1, 1, Table.NONE),
 		ANCIENT_PAGE_ONE(12621, 1, 1, 1, Table.NONE),
 		ANCIENT_PAGE_TWO(12622, 1, 1, 1, Table.NONE),
 		ANCIENT_PAGE_THREE(12623, 1, 1, 1, Table.NONE),
 		ANCIENT_PAGE_FOUR(12624, 1, 1, 1, Table.NONE);
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Prayer_Page(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
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
 	
 	public enum Halfkey {
 		LOOP(987, 1, 1, 1, Table.NONE),
 		TEETH(985, 1, 1, 1, Table.NONE);
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Halfkey(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
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
 	
 	public enum Gilded {
 		PLATEBODY(3481, 1, 1, 1, Table.NONE),
 		PLATELEGS(3483, 1, 1, 1, Table.NONE),
 		PLATESKIRT(3485, 1, 1, 1, Table.NONE),
 		FULL_HELM(3486, 1, 1, 1, Table.NONE),
 		KITESHIELD(3488, 1, 1, 1, Table.NONE),
 		MED_HELM(20146, 1, 1, 1, Table.NONE),
 		CHAINBODY(20149, 1, 1, 1, Table.NONE),
 		SQUARE_SHIELD(20152, 1, 1, 1, Table.NONE),
 		TWO_HAND_SWORD(20155, 1, 1, 1, Table.NONE),
 		SPEAR(20158, 1, 1, 1, Table.NONE),
 		HASTA(20161, 1, 1, 1, Table.NONE);
		
		private int itemId;
		private int quantityMinimum;
		private int quantityMaximum;
		private int weight;
		private Table table;
		
		private Gilded(int itemId, int quantityMin, int quantityMax, int weight, Table table) {
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
