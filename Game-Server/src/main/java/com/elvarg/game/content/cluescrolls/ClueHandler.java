package com.elvarg.game.content.cluescrolls;

import com.elvarg.game.entity.impl.player.Player;
import com.elvarg.game.model.Item;
import com.elvarg.game.model.container.impl.Equipment;
import com.elvarg.util.ItemIdentifiers;
import com.elvarg.util.Misc;

public class ClueHandler {
	
	public static boolean sendRiddleToPlayer(Player player, int itemId) {
		for (RiddleClues riddle : RiddleClues.values()) {
			if (riddle.getClueId() == itemId) {
				player.getPacketSender().sendMessage(riddle.getClue());
				return true;
			}
		}
		return false;
	}
	
	public static void handleRiddleDig(Player player) {
		for (RiddleClues riddle : RiddleClues.values()) {
			if (player.getInventory().contains(new Item(riddle.getClueId()))) {
				if (isInDigAreaForRiddleClue(player, riddle.getLevel(), riddle.getClueDigX(), riddle.getClueDigY())) {
					player.getInventory().delete(new Item(riddle.getClueId()));
					rewardClueCasket(player, riddle.getLevel());
				}
			}
		}
	}
	
	public static boolean isInDigAreaForRiddleClue(Player player, ClueLevel level, int x, int y) {
		int areaSearchX = 0;
		int areaSearchY = 0;
		switch (level) {
			case EASY:
				areaSearchX = 4;
				areaSearchY = 4;
			break;
			case MEDIUM:
				areaSearchX = 3;
				areaSearchY = 3;
			break;
			case HARD:
				areaSearchX = 2;
				areaSearchY = 2;
			break;
			case ELITE:
				areaSearchX = 1;
				areaSearchY = 1;
			break;
			case MASTER:
				areaSearchX = 0;
				areaSearchY = 0;
			break;
			default:
				areaSearchX = 0;
				areaSearchY = 0;
				
		}
		if (player.getLocation().getX() >= x - areaSearchX && player.getLocation().getX() <= x + areaSearchX &&
				player.getLocation().getY() >= y - areaSearchY && player.getLocation().getY() <= y + areaSearchY) {
			return true;
		} else {
			return false;
		}
	}
	
    public static boolean wearingRingOfWealth(Player player) {
        return player.getEquipment().getItems()[Equipment.RING_SLOT].getId() == 2572;
    }
	
	public static void rewardClueCasket(Player player, ClueLevel level) {
		boolean rewardDouble = false;
		if (wearingRingOfWealth(player)) {
			if (Misc.inclusive(1, 100) == 1) {
				rewardDouble = true;
			}
		}
		switch (level) {
		case EASY:
			player.getInventory().add(new Item(ItemIdentifiers.EASY_CASKET, rewardDouble ? 2 : 1));
		break;
		case MEDIUM:
			player.getInventory().add(new Item(ItemIdentifiers.MEDIUM_CASKET, rewardDouble ? 2 : 1));
		break;
		case HARD:
			player.getInventory().add(new Item(ItemIdentifiers.HARD_CASKET, rewardDouble ? 2 : 1));
		break;
		case ELITE:
			player.getInventory().add(new Item(ItemIdentifiers.ELITE_CASKET, rewardDouble ? 2 : 1));
		break;
		case MASTER:
			player.getInventory().add(new Item(ItemIdentifiers.MASTER_CASKET, rewardDouble ? 2 : 1));
		break;
		default:
		}
	}

}
