package com.elvarg.game.content.christmas;

import com.elvarg.game.entity.impl.player.Player;
import com.elvarg.game.model.Item;
import com.elvarg.util.Misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box {
    public enum BoxData {
        ITEM1(25, 2, 1),
        ITEM2(25, 3, 1),
        ITEM3(50, 4, 1),
        ITEM4(75, 5, 1),
        ITEM5(100, 6, 1);

        int chance, itemId, quantity;

        BoxData(int chance, int id, int amount) {
            this.chance = chance;
            this.itemId = id;
            this.quantity = amount;
        }

        public int getChance() {
            return chance;
        }

        public int getItemId() {
            return itemId;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    public static void openbox(Player plr) {
        int bestChanced = 0;
        ArrayList<Item> itemsObtained = new ArrayList<>();
        List<BoxData> boxData = new ArrayList<>();
        for (BoxData box : BoxData.values()) {
            boxData.add(box);
        }
        Collections.shuffle(boxData);
        itemsObtained.add(new Item(1, 1)); //Default Item
        for (int i = 0; i < boxData.size(); i++) {
            int random = Misc.randomInclusive(1, boxData.get(i).getChance());
            if (random == 1) {
                if (boxData.get(i).getChance() > bestChanced) {
                    itemsObtained.remove(0);
                    bestChanced = boxData.get(i).getChance();
                    itemsObtained.add(new Item(boxData.get(i).getItemId(), boxData.get(i).getQuantity()));
                }
            }
        }
        plr.getInventory().add(new Item(itemsObtained.get(0).getId(), itemsObtained.get(0).getAmount()));
    }
}
