package com.elvarg.game.content.christmas;

import com.elvarg.game.definition.ItemDefinition;
import com.elvarg.game.entity.impl.object.GameObject;
import com.elvarg.game.entity.impl.object.MapObjects;
import com.elvarg.game.entity.impl.player.Player;
import com.elvarg.game.model.Item;
import com.elvarg.game.model.Location;
import com.elvarg.util.Misc;

import java.util.ArrayList;

public class CrateSearch {
    static ArrayList<Location> map = new ArrayList<>();

    private final static int[] COMMON_LOOT = {1205, 1973, 1977, 1978, 1984, 1993};
    private final static int[] RARE_LOOT = {6856, 6857, 6858, 6859, 6860, 6861, 6862, 6863, 962, 1989};

    public final static String[] ACCEPTED_OBJECT_NAMES = {"crate", "boxes", "bookcase", "drawer"};

    public static boolean isValid(Player player, Location loc, String name) {
        for (int i = 0; i < ACCEPTED_OBJECT_NAMES.length; i++) {
            if (name.contains(ACCEPTED_OBJECT_NAMES[i])) {
                openCrate(player, loc);
                return true;
            }
        }
        return false;
    }

    public static void openCrate(Player player, Location loc) {
        if (map.contains(loc)) {
            player.getPacketSender().sendMessage("You've recently searched this create");
            return;
        }
        if (map.size() >= 25) {
            map.clear();
        }
        map.add(loc);
        rollLoot(player);
    }

    public static void rollLoot(Player player) {
        int id = 0;
        if (Misc.randomInclusive(1, 50) == 25) {
            id = RARE_LOOT[Misc.randomInclusive(0, RARE_LOOT.length - 1)];
            player.getInventory().add(new Item(id));
            player.getPacketSender().sendMessage("You find a " + ItemDefinition.forId(id).getName());
        } else {
            if (Misc.randomInclusive(1, 4) == 1) {
                player.getPacketSender().sendMessage("You find nothing");
            } else {
                id = COMMON_LOOT[Misc.randomInclusive(0, COMMON_LOOT.length - 1)];
                player.getInventory().add(new Item(id));
                player.getPacketSender().sendMessage("You find a " + ItemDefinition.forId(id).getName());
            }
        }

    }
}
