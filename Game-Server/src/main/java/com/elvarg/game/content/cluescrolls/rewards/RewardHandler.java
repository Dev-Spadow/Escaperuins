package com.elvarg.game.content.cluescrolls.rewards;

import java.util.ArrayList;
import java.util.List;

import com.elvarg.game.content.cluescrolls.ClueLevel;
import com.elvarg.game.content.cluescrolls.rewards.data.EasyClueTable;
import com.elvarg.game.content.cluescrolls.rewards.data.GeneralClueTable;
import com.elvarg.game.content.cluescrolls.rewards.data.HardClueTable;
import com.elvarg.game.content.cluescrolls.rewards.data.MediumClueTable;
import com.elvarg.game.content.cluescrolls.rewards.data.Table;
import com.elvarg.game.entity.impl.player.Player;
import com.elvarg.game.model.Item;
import com.elvarg.util.ItemIdentifiers;
import com.elvarg.util.Misc;

public class RewardHandler {
	
	static ArrayList<Item> rewards = new ArrayList<Item>();
	private static int clueCasketIdOpened = 0;
	
	public static boolean open(Player player, int itemId) {
		ClueLevel difficulty = getClueLevel(itemId);
		if (!doesPlayerHaveACasket(player)) {
			return false;
		}
		if (!difficulty.equals(ClueLevel.NONE)) {
			openCasket(player, itemId, difficulty);
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean doesPlayerHaveACasket(Player player) {
		if (player.getInventory().contains(clueCasketIdOpened)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void openCasket(Player player, int itemId, ClueLevel difficulty) {
		long start = System.currentTimeMillis();
		int amountOfRolls = calculateRolls(difficulty);
		for (int i = 0; i < amountOfRolls; i++) {
			determineLoot(player, difficulty);
		}
		resetDataOnLootInterface(player);
		sendLootInterfaceToPlayer(player);
		addLootToPlayer(player);
		clearRewardsList();
		player.getInventory().delete(new Item(clueCasketIdOpened, 1));
		clueCasketIdOpened = 0;
		System.out.println("Opened casket in: " + (System.currentTimeMillis() - start) + "MS");
	}
	
	public static int calculateRolls(ClueLevel level) {
		switch (level) {
			case EASY:
				return Misc.randomInclusive(EasyClueTable.MINIMUM_ROLLS, EasyClueTable.MAXIMUM_ROLLS);
			case MEDIUM:
				return Misc.randomInclusive(MediumClueTable.MINIMUM_ROLLS, MediumClueTable.MAXIMUM_ROLLS);
			case HARD:
				return Misc.randomInclusive(HardClueTable.MINIMUM_ROLLS, HardClueTable.MAXIMUM_ROLLS);
			default:
				return 0;
		}
	}
	
	public static ClueLevel getClueLevel(int itemId) {
		switch (itemId) {
			case ItemIdentifiers.EASY_CASKET:
				clueCasketIdOpened = ItemIdentifiers.EASY_CASKET;
				return ClueLevel.EASY;
			case ItemIdentifiers.MEDIUM_CASKET:
				clueCasketIdOpened = ItemIdentifiers.MEDIUM_CASKET;
				return ClueLevel.MEDIUM;
			case ItemIdentifiers.HARD_CASKET:
				clueCasketIdOpened = ItemIdentifiers.HARD_CASKET;
				return ClueLevel.HARD;
			case ItemIdentifiers.ELITE_CASKET:
				clueCasketIdOpened = ItemIdentifiers.ELITE_CASKET;
				return ClueLevel.ELITE;
			case ItemIdentifiers.MASTER_CASKET:
				clueCasketIdOpened = ItemIdentifiers.MASTER_CASKET;
				return ClueLevel.MASTER;
			default:
				return ClueLevel.NONE;
		}
	}
	
	@SuppressWarnings("incomplete-switch")
	public static void determineLoot(Player player, ClueLevel level) {
		switch (level) {
			case EASY:
				int easyRandom = Misc.randomInclusive(1, EasyClueTable.STANDARD_WEIGHT + EasyClueTable.RARE_WEIGHT);
				if (easyRandom == EasyClueTable.RARE_WEIGHT) {
					EasyClueTable.Rare rare = determineEasyRareItemOrTable(player);
					if (rare.getTable().equals(Table.NONE)) {
						addLootToHashMap(player, rare.getItemId(), rare.getMinimumQuantity(), rare.getMaximumQuantity());
					} else {
						switch (rare.getTable()) {
							case EASY_RARE_CHEF:
								EasyClueTable.Rare_Chef chef = determineEasyRareChefItemOrTable(player);
								if (chef.getTable().equals(Table.NONE)) {
									addLootToHashMap(player, chef.getItemId(), chef.getMinimumQuantity(), chef.getMaximumQuantity());
								}
							break;
							case EASY_RARE_CAPE:
								EasyClueTable.Rare_Cape cape = determineEasyRareCapeItemOrTable(player);
								if (cape.getTable().equals(Table.NONE)) {
									addLootToHashMap(player, cape.getItemId(), cape.getMinimumQuantity(), cape.getMaximumQuantity());
								}
							break;
							case EASY_RARE_ELEGANT:
								EasyClueTable.Rare_Elegant ele = determineEasyRareElegantItemOrTable(player);
								if (ele.getTable().equals(Table.NONE)) {
									addLootToHashMap(player, ele.getItemId(), ele.getMinimumQuantity(), ele.getMaximumQuantity());
								}
							break;
							case EASY_RARE_MONK:
								EasyClueTable.Rare_Monk monk = determineEasyRareMonkItemOrTable(player);
								if (monk.getTable().equals(Table.NONE)) {
									if (Misc.randomInclusive(1, 5) == 3)
										addLootToHashMap(player, monk.getItemId(), monk.getMinimumQuantity(), monk.getMaximumQuantity());
									else 
										addLootToHashMap(player, 995, 3400, 8200);
								}
							break;
						}
					}
				} else {
					EasyClueTable.Standard sta = determineEasyStandardItemOrTable(player);
					if (sta.getTable().equals(Table.NONE)) {
						addLootToHashMap(player, sta.getItemId(), sta.getMinimumQuantity(), sta.getMaximumQuantity());
					} else {
						switch (sta.getTable()) {
							case EASY_STANDARD_AMULET:
								EasyClueTable.Standard_Amulet ammy = determineEasyStandardAmuletItemOrTable(player);
								if (ammy.getTable().equals(Table.NONE)) {
									addLootToHashMap(player, ammy.getItemId(), ammy.getMinimumQuantity(), ammy.getMaximumQuantity());
								}
							break;
							case EASY_STANDARD_BOW:
								EasyClueTable.Standard_Bow bow = determineEasyStandardBowItemOrTable(player);
								if (bow.getTable().equals(Table.NONE)) {
									addLootToHashMap(player, bow.getItemId(), bow.getMinimumQuantity(), bow.getMaximumQuantity());
								}
							break;
							case EASY_STANDARD_BLESSINGS:
								EasyClueTable.Standard_Blessings bless = determineEasyStandardBlessingsItemOrTable(player);
								if (bless.getTable().equals(Table.NONE)) {
									addLootToHashMap(player, bless.getItemId(), bless.getMinimumQuantity(), bless.getMaximumQuantity());
								} else {
									handleGeneralLoot(player, bless.getTable());
								}
							break;
							case GENERAL_PRAYER_PAGE:
							case GENERAL_FIRELIGHTER:
							case GENERAL_TELEPORT_SCROLL:
								handleGeneralLoot(player, sta.getTable());
							break;
						}
					}
				}
			break;
			
			case MEDIUM:
				int mediumRandom = Misc.randomInclusive(1, MediumClueTable.STANDARD_WEIGHT + MediumClueTable.RARE_WEIGHT);
				if (mediumRandom == MediumClueTable.RARE_WEIGHT) {
					MediumClueTable.Rare rare = determineMediumRareItemOrTable(player);
					if (rare.getTable().equals(Table.NONE)) {
						addLootToHashMap(player, rare.getItemId(), rare.getMinimumQuantity(), rare.getMaximumQuantity());
					} else {
						switch (rare.getTable()) {
							case MEDIUM_RARE_UNICORN:
								MediumClueTable.Rare_Unicorn uni = determineMediumRareUnicornItemOrTable(player);
								if (uni.getTable().equals(Table.NONE)) {
									addLootToHashMap(player, uni.getItemId(), uni.getMinimumQuantity(), uni.getMaximumQuantity());
								}
							break;
							case MEDIUM_RARE_ELEGANT:
								MediumClueTable.Rare_Elegant ele = determineMediumRareElegantItemOrTable(player);
								if (ele.getTable().equals(Table.NONE)) {
									addLootToHashMap(player, ele.getItemId(), ele.getMinimumQuantity(), ele.getMaximumQuantity());
								}
							break;
						}
					}
				} else {
					MediumClueTable.Standard sta = determineMediumStandardItemOrTable(player);
					if (sta.getTable().equals(Table.NONE)) {
						addLootToHashMap(player, sta.getItemId(), sta.getMinimumQuantity(), sta.getMaximumQuantity());
					} else {
						switch (sta.getTable()) {
							case MEDIUM_STANDARD_AMULET:
								MediumClueTable.Standard_Amulet ammy = determineMediumStandardAmuletItemOrTable(player);
								if (ammy.getTable().equals(Table.NONE)) {
									addLootToHashMap(player, ammy.getItemId(), ammy.getMinimumQuantity(), ammy.getMaximumQuantity());
								}
							break;
							case MEDIUM_STANDARD_BOW:
								MediumClueTable.Standard_Bow bow = determineMediumStandardBowItemOrTable(player);
								if (bow.getTable().equals(Table.NONE)) {
									addLootToHashMap(player, bow.getItemId(), bow.getMinimumQuantity(), bow.getMaximumQuantity());
								}
							break;
							case MEDIUM_STANDARD_FIRELIGHTER:
								MediumClueTable.Standard_Firelighter fire = determineMediumStandardFirelighterItemOrTable(player);
								if (fire.getTable().equals(Table.NONE)) {
									addLootToHashMap(player, fire.getItemId(), fire.getMinimumQuantity(), fire.getMaximumQuantity());
								} else {
									handleGeneralLoot(player, fire.getTable());
								}
							break;
							case GENERAL_PRAYER_PAGE:
							case GENERAL_TELEPORT_SCROLL:
							case GENERAL_BLESSING:
								handleGeneralLoot(player, sta.getTable());
							break;
						}
					}
				}
			break;
			
			case HARD:
				int hardRandom = Misc.randomInclusive(1, HardClueTable.STANDARD_WEIGHT + HardClueTable.RARE_WEIGHT);
				if (hardRandom == HardClueTable.RARE_WEIGHT) {
					HardClueTable.Rare rare = determineHardRareItemOrTable(player);
					if (rare.getTable().equals(Table.NONE)) {
						addLootToHashMap(player, rare.getItemId(), rare.getMinimumQuantity(), rare.getMaximumQuantity());
					} else {
						switch (rare.getTable()) {
							case HARD_RARE_MEGA_RARE:
								HardClueTable.Rare_Mega_Rare megaRare = determineHardRareMegaRareItemOrTable(player);
								if (megaRare.getTable().equals(Table.NONE)) {
									addLootToHashMap(player, megaRare.getItemId(), megaRare.getMinimumQuantity(), megaRare.getMaximumQuantity());
								} else {
									switch (megaRare.getTable()) {
										case GENERAL_GILDED:
											handleGeneralLoot(player, megaRare.getTable());
										break;
										case HARD_RARE_POTION:
											HardClueTable.Rare_Potion potion = determineHardRarePotionItemOrTable(player);
											if (potion.getTable().equals(Table.NONE)) {
												addLootToHashMap(player, potion.getItemId(), potion.getMinimumQuantity(), potion.getMaximumQuantity());
											}
										break;
										case HARD_RARE_THIRD_AGE:
											HardClueTable.Rare_Third_Age third = determineHardRareThirdAgeItemOrTable(player);
											if (third.getTable().equals(Table.NONE)) {
												addLootToHashMap(player, third.getItemId(), third.getMinimumQuantity(), third.getMaximumQuantity());
											}
										break;
									}
								}
							break;
							case HARD_RARE_BLESSED_SHIELDS:
							break;
						}
					}
				} else {
					HardClueTable.Standard sta = determineHardStandardItemOrTable(player);
					if (sta.getTable().equals(Table.NONE)) {
						addLootToHashMap(player, sta.getItemId(), sta.getMinimumQuantity(), sta.getMaximumQuantity());
					} else {
						switch(sta.getTable()) {
						case HARD_STANDARD_BOW:
							HardClueTable.Standard_Bow bow = determineHardStandardBowItemOrTable(player);
							if (bow.getTable().equals(Table.NONE)) {
								addLootToHashMap(player, bow.getItemId(), bow.getMinimumQuantity(), bow.getMaximumQuantity());
							}
						break;
						case GENERAL_PRAYER_PAGE:
						case GENERAL_TELEPORT_SCROLL:
						case GENERAL_BLESSING:
						case GENERAL_FIRELIGHTER:
							handleGeneralLoot(player, sta.getTable());
						break;
						}
					}
				}
			break;
		}
	}
	
	@SuppressWarnings("incomplete-switch")
	public static void handleGeneralLoot(Player player, Table table) {
		switch (table) {
			case GENERAL_BLESSING:
				GeneralClueTable.Blessings bless = determineGeneralBlessingsItemOrTable(player);
				if (bless.getTable().equals(Table.NONE)) {
					addLootToHashMap(player, bless.getItemId(), bless.getMinimumQuantity(), bless.getMaximumQuantity());
				}
			break;
			case GENERAL_FIRELIGHTER: 
				GeneralClueTable.Firelighter fire = determineGeneralFirelighterItemOrTable(player);
				if (fire.getTable().equals(Table.NONE)) {
					addLootToHashMap(player, fire.getItemId(), fire.getMinimumQuantity(), fire.getMaximumQuantity());
				}
			break;
			case GENERAL_TELEPORT_SCROLL:
				GeneralClueTable.Teleport_Scrolls ts = determineGeneralTeleportScrollItemOrTable(player);
				if (ts.getTable().equals(Table.NONE)) {
					addLootToHashMap(player, ts.getItemId(), ts.getMinimumQuantity(), ts.getMaximumQuantity());
				}
			break;	
			case GENERAL_PRAYER_PAGE: 
				GeneralClueTable.Prayer_Page page = determineGeneralPrayerPageItemOrTable(player);
				if (page.getTable().equals(Table.NONE)) {
					addLootToHashMap(player, page.getItemId(), page.getMinimumQuantity(), page.getMaximumQuantity());
				}
			break;
			case GENERAL_HALF_KEY:
				GeneralClueTable.Halfkey key = determineGeneralHalfKeyItemOrTable(player);
				if (key.getTable().equals(Table.NONE)) {
					addLootToHashMap(player, key.getItemId(), key.getMinimumQuantity(), key.getMaximumQuantity());
				}
			break;
			case GENERAL_GILDED:
				GeneralClueTable.Gilded gilded = determineGeneralGildedItemOrTable(player);
				if (gilded.getTable().equals(Table.NONE)) {
					addLootToHashMap(player, gilded.getItemId(), gilded.getMinimumQuantity(), gilded.getMaximumQuantity());
				}
			break;
		}
	}
	
	public static void addLootToHashMap(Player player, int itemId, int quantityMin, int quantityMax) {
		int quantity = Misc.randomInclusive(quantityMin, quantityMax);
		rewards.add(new Item(itemId, quantity));
	}
	
	public static void resetDataOnLootInterface(Player player) {
		for (int i = 0; i < 9; i ++) {
			player.getPacketSender().sendItemOnInterface(6963, -1, i, 0);
		}
	}
	
	public static void sendLootInterfaceToPlayer(Player player) {
		for (int i = 0; i < rewards.size(); i++) {
			player.getPacketSender().sendItemOnInterface(6963, rewards.get(i).getId(), i, rewards.get(i).getAmount());
		}
		player.getPacketSender().sendInterface(6960);
	}
	
	public static void addLootToPlayer(Player player) {
		for (int i = 0; i < rewards.size(); i++) {
			if (player.getInventory().getFreeSlots() <= 0  && !player.getInventory().contains(rewards.get(i))) {
				player.getBank(player.getCurrentBankTab()).add(new Item(rewards.get(i).getId(), rewards.get(i).getAmount()));
			} else {
				player.getInventory().add(new Item(rewards.get(i).getId(), rewards.get(i).getAmount()));
			}
		}
	}
	
	public static void clearRewardsList() {
		rewards.clear();
	}
	
	/**
	 * General Clue Table Builders
	 */
    private static GeneralClueTable.Blessings determineGeneralBlessingsItemOrTable(Player player) {
        List<GeneralClueTable.Blessings> generalClueTable = new ArrayList<GeneralClueTable.Blessings>();

        for (GeneralClueTable.Blessings bless : GeneralClueTable.Blessings.values()) {
        	for (int i = 0; i < bless.getWeight(); i++) {
            	generalClueTable.add(bless);	
        	}
        }
        
        return Misc.randomElement(generalClueTable);
    }
    
    private static GeneralClueTable.Firelighter determineGeneralFirelighterItemOrTable(Player player) {
        List<GeneralClueTable.Firelighter> generalClueTable = new ArrayList<GeneralClueTable.Firelighter>();

        for (GeneralClueTable.Firelighter light : GeneralClueTable.Firelighter.values()) {
        	for (int i = 0; i < light.getWeight(); i++) {
            	generalClueTable.add(light);	
        	}
        }
        
        return Misc.randomElement(generalClueTable);
    }
    
    private static GeneralClueTable.Teleport_Scrolls determineGeneralTeleportScrollItemOrTable(Player player) {
        List<GeneralClueTable.Teleport_Scrolls> generalClueTable = new ArrayList<GeneralClueTable.Teleport_Scrolls>();

        for (GeneralClueTable.Teleport_Scrolls ts : GeneralClueTable.Teleport_Scrolls.values()) {
        	for (int i = 0; i < ts.getWeight(); i++) {
            	generalClueTable.add(ts);	
        	}
        }
        
        return Misc.randomElement(generalClueTable);
    }
    
    private static GeneralClueTable.Prayer_Page determineGeneralPrayerPageItemOrTable(Player player) {
        List<GeneralClueTable.Prayer_Page> generalClueTable = new ArrayList<GeneralClueTable.Prayer_Page>();

        for (GeneralClueTable.Prayer_Page page : GeneralClueTable.Prayer_Page.values()) {
        	for (int i = 0; i < page.getWeight(); i++) {
            	generalClueTable.add(page);	
        	}
        }
        
        return Misc.randomElement(generalClueTable);
    }
    
    private static GeneralClueTable.Halfkey determineGeneralHalfKeyItemOrTable(Player player) {
        List<GeneralClueTable.Halfkey> generalClueTable = new ArrayList<GeneralClueTable.Halfkey>();

        for (GeneralClueTable.Halfkey half : GeneralClueTable.Halfkey.values()) {
        	for (int i = 0; i < half.getWeight(); i++) {
            	generalClueTable.add(half);	
        	}
        }
        
        return Misc.randomElement(generalClueTable);
    }
    
    private static GeneralClueTable.Gilded determineGeneralGildedItemOrTable(Player player) {
        List<GeneralClueTable.Gilded> generalClueTable = new ArrayList<GeneralClueTable.Gilded>();

        for (GeneralClueTable.Gilded gilded : GeneralClueTable.Gilded.values()) {
        	for (int i = 0; i < gilded.getWeight(); i++) {
            	generalClueTable.add(gilded);	
        	}
        }
        
        return Misc.randomElement(generalClueTable);
    }
	
	
	/**
	 * Easy Clue Table Builders
	 */
    private static EasyClueTable.Standard determineEasyStandardItemOrTable(Player player) {
        List<EasyClueTable.Standard> standardLootTable = new ArrayList<EasyClueTable.Standard>();

        for (EasyClueTable.Standard sta : EasyClueTable.Standard.values()) {
        	for (int i = 0; i < sta.getWeight(); i++) {
            	standardLootTable.add(sta);	
        	}
        }
        
        return Misc.randomElement(standardLootTable);
    }
    
    private static EasyClueTable.Standard_Amulet determineEasyStandardAmuletItemOrTable(Player player) {
        List<EasyClueTable.Standard_Amulet> standardLootTable = new ArrayList<EasyClueTable.Standard_Amulet>();

        for (EasyClueTable.Standard_Amulet sta : EasyClueTable.Standard_Amulet.values()) {
        	for (int i = 0; i < sta.getWeight(); i++) {
            	standardLootTable.add(sta);	
        	}
        }
        
        return Misc.randomElement(standardLootTable);
    }

    private static EasyClueTable.Standard_Bow determineEasyStandardBowItemOrTable(Player player) {
        List<EasyClueTable.Standard_Bow> standardLootTable = new ArrayList<EasyClueTable.Standard_Bow>();

        for (EasyClueTable.Standard_Bow sta : EasyClueTable.Standard_Bow.values()) {
        	for (int i = 0; i < sta.getWeight(); i++) {
            	standardLootTable.add(sta);	
        	}
        }
        
        return Misc.randomElement(standardLootTable);
    }
    
    private static EasyClueTable.Standard_Blessings determineEasyStandardBlessingsItemOrTable(Player player) {
        List<EasyClueTable.Standard_Blessings> standardLootTable = new ArrayList<EasyClueTable.Standard_Blessings>();

        for (EasyClueTable.Standard_Blessings sta : EasyClueTable.Standard_Blessings.values()) {
        	for (int i = 0; i < sta.getWeight(); i++) {
            	standardLootTable.add(sta);	
        	}
        }
        
        return Misc.randomElement(standardLootTable);
    }
    
    private static EasyClueTable.Rare determineEasyRareItemOrTable(Player player) {
        List<EasyClueTable.Rare> rareLootTable = new ArrayList<EasyClueTable.Rare>();

        for (EasyClueTable.Rare rare : EasyClueTable.Rare.values()) {
        	for (int i = 0; i < rare.getWeight(); i++) {
            	rareLootTable.add(rare);	
        	}
        }
        
        return Misc.randomElement(rareLootTable);
    }
    
    private static EasyClueTable.Rare_Chef determineEasyRareChefItemOrTable(Player player) {
        List<EasyClueTable.Rare_Chef> rareLootTable = new ArrayList<EasyClueTable.Rare_Chef>();

        for (EasyClueTable.Rare_Chef rare : EasyClueTable.Rare_Chef.values()) {
        	for (int i = 0; i < rare.getWeight(); i++) {
            	rareLootTable.add(rare);	
        	}
        }
        
        return Misc.randomElement(rareLootTable);
    }
    
    private static EasyClueTable.Rare_Monk determineEasyRareMonkItemOrTable(Player player) {
        List<EasyClueTable.Rare_Monk> rareLootTable = new ArrayList<EasyClueTable.Rare_Monk>();

        for (EasyClueTable.Rare_Monk rare : EasyClueTable.Rare_Monk.values()) {
        	for (int i = 0; i < rare.getWeight(); i++) {
            	rareLootTable.add(rare);	
        	}
        }
        
        return Misc.randomElement(rareLootTable);
    }
    
    private static EasyClueTable.Rare_Cape determineEasyRareCapeItemOrTable(Player player) {
        List<EasyClueTable.Rare_Cape> rareLootTable = new ArrayList<EasyClueTable.Rare_Cape>();

        for (EasyClueTable.Rare_Cape rare : EasyClueTable.Rare_Cape.values()) {
        	for (int i = 0; i < rare.getWeight(); i++) {
            	rareLootTable.add(rare);	
        	}
        }
        
        return Misc.randomElement(rareLootTable);
    }
    
    private static EasyClueTable.Rare_Elegant determineEasyRareElegantItemOrTable(Player player) {
        List<EasyClueTable.Rare_Elegant> rareLootTable = new ArrayList<EasyClueTable.Rare_Elegant>();

        for (EasyClueTable.Rare_Elegant rare : EasyClueTable.Rare_Elegant.values()) {
        	for (int i = 0; i < rare.getWeight(); i++) {
            	rareLootTable.add(rare);	
        	}
        }
        
        return Misc.randomElement(rareLootTable);
    }
    
    /**
     * Medium Clue Table Builders
     */
    private static MediumClueTable.Standard determineMediumStandardItemOrTable(Player player) {
        List<MediumClueTable.Standard> standardLootTable = new ArrayList<MediumClueTable.Standard>();

        for (MediumClueTable.Standard sta : MediumClueTable.Standard.values()) {
        	for (int i = 0; i < sta.getWeight(); i++) {
            	standardLootTable.add(sta);	
        	}
        }
        
        return Misc.randomElement(standardLootTable);
    }
    
    private static MediumClueTable.Standard_Bow determineMediumStandardBowItemOrTable(Player player) {
        List<MediumClueTable.Standard_Bow> standardLootTable = new ArrayList<MediumClueTable.Standard_Bow>();

        for (MediumClueTable.Standard_Bow sta : MediumClueTable.Standard_Bow.values()) {
        	for (int i = 0; i < sta.getWeight(); i++) {
            	standardLootTable.add(sta);	
        	}
        }
        
        return Misc.randomElement(standardLootTable);
    }
    
    private static MediumClueTable.Standard_Amulet determineMediumStandardAmuletItemOrTable(Player player) {
        List<MediumClueTable.Standard_Amulet> standardLootTable = new ArrayList<MediumClueTable.Standard_Amulet>();

        for (MediumClueTable.Standard_Amulet sta : MediumClueTable.Standard_Amulet.values()) {
        	for (int i = 0; i < sta.getWeight(); i++) {
            	standardLootTable.add(sta);	
        	}
        }
        
        return Misc.randomElement(standardLootTable);
    }
    
    private static MediumClueTable.Standard_Firelighter determineMediumStandardFirelighterItemOrTable(Player player) {
        List<MediumClueTable.Standard_Firelighter> list = new ArrayList<MediumClueTable.Standard_Firelighter>();

        for (MediumClueTable.Standard_Firelighter table : MediumClueTable.Standard_Firelighter.values()) {
        	for (int i = 0; i < table.getWeight(); i++) {
            	list.add(table);	
        	}
        }
        
        return Misc.randomElement(list);
    }
    
    private static MediumClueTable.Rare determineMediumRareItemOrTable(Player player) {
        List<MediumClueTable.Rare> list = new ArrayList<MediumClueTable.Rare>();

        for (MediumClueTable.Rare table : MediumClueTable.Rare.values()) {
        	for (int i = 0; i < table.getWeight(); i++) {
            	list.add(table);	
        	}
        }
        
        return Misc.randomElement(list);
    }
    
    private static MediumClueTable.Rare_Unicorn determineMediumRareUnicornItemOrTable(Player player) {
        List<MediumClueTable.Rare_Unicorn> list = new ArrayList<MediumClueTable.Rare_Unicorn>();

        for (MediumClueTable.Rare_Unicorn table : MediumClueTable.Rare_Unicorn.values()) {
        	for (int i = 0; i < table.getWeight(); i++) {
            	list.add(table);	
        	}
        }
        
        return Misc.randomElement(list);
    }
    
    private static MediumClueTable.Rare_Elegant determineMediumRareElegantItemOrTable(Player player) {
        List<MediumClueTable.Rare_Elegant> list = new ArrayList<MediumClueTable.Rare_Elegant>();

        for (MediumClueTable.Rare_Elegant table : MediumClueTable.Rare_Elegant.values()) {
        	for (int i = 0; i < table.getWeight(); i++) {
            	list.add(table);	
        	}
        }
        
        return Misc.randomElement(list);
    }
    
    /**
     * Hard Clue Table Builders
     */
    private static HardClueTable.Standard determineHardStandardItemOrTable(Player player) {
        List<HardClueTable.Standard> list = new ArrayList<HardClueTable.Standard>();

        for (HardClueTable.Standard table : HardClueTable.Standard.values()) {
        	for (int i = 0; i < table.getWeight(); i++) {
            	list.add(table);	
        	}
        }
        
        return Misc.randomElement(list);
    }
    
    private static HardClueTable.Standard_Bow determineHardStandardBowItemOrTable(Player player) {
        List<HardClueTable.Standard_Bow> list = new ArrayList<HardClueTable.Standard_Bow>();

        for (HardClueTable.Standard_Bow table : HardClueTable.Standard_Bow.values()) {
        	for (int i = 0; i < table.getWeight(); i++) {
            	list.add(table);	
        	}
        }
        
        return Misc.randomElement(list);
    }
    
    private static HardClueTable.Rare determineHardRareItemOrTable(Player player) {
        List<HardClueTable.Rare> list = new ArrayList<HardClueTable.Rare>();

        for (HardClueTable.Rare table : HardClueTable.Rare.values()) {
        	for (int i = 0; i < table.getWeight(); i++) {
            	list.add(table);	
        	}
        }
        
        return Misc.randomElement(list);
    }
    
    private static HardClueTable.Rare_Potion determineHardRarePotionItemOrTable(Player player) {
        List<HardClueTable.Rare_Potion> list = new ArrayList<HardClueTable.Rare_Potion>();

        for (HardClueTable.Rare_Potion table : HardClueTable.Rare_Potion.values()) {
        	for (int i = 0; i < table.getWeight(); i++) {
            	list.add(table);	
        	}
        }
        
        return Misc.randomElement(list);
    }
    
    private static HardClueTable.Rare_Mega_Rare determineHardRareMegaRareItemOrTable(Player player) {
        List<HardClueTable.Rare_Mega_Rare> list = new ArrayList<HardClueTable.Rare_Mega_Rare>();

        for (HardClueTable.Rare_Mega_Rare table : HardClueTable.Rare_Mega_Rare.values()) {
        	for (int i = 0; i < table.getWeight(); i++) {
            	list.add(table);	
        	}
        }
        
        return Misc.randomElement(list);
    }
    
    private static HardClueTable.Rare_Third_Age determineHardRareThirdAgeItemOrTable(Player player) {
        List<HardClueTable.Rare_Third_Age> list = new ArrayList<HardClueTable.Rare_Third_Age>();

        for (HardClueTable.Rare_Third_Age table : HardClueTable.Rare_Third_Age.values()) {
        	for (int i = 0; i < table.getWeight(); i++) {
            	list.add(table);	
        	}
        }
        
        return Misc.randomElement(list);
    }
}
