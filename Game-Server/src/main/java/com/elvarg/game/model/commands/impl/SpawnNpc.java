package com.elvarg.game.model.commands.impl;

import com.elvarg.game.World;
import com.elvarg.game.definition.loader.impl.NpcSpawnDefinitionLoader;
import com.elvarg.game.entity.impl.npc.NPC;
import com.elvarg.game.entity.impl.player.Player;
import com.elvarg.game.model.FacingDirection;
import com.elvarg.game.model.Location;
import com.elvarg.game.model.commands.Command;
import com.elvarg.game.model.rights.PlayerRights;
import com.elvarg.util.Misc;

import java.util.Locale;

public class SpawnNpc implements Command {
    @Override
    public void execute(Player player, String command, String[] parts) {
        if (parts.length != 6)
            return;
        int npcID = Integer.valueOf(parts[1]);
        int direction = Integer.valueOf(parts[2]);
        int areaToPopulate = Integer.valueOf(parts[3]);
        int amountOfNpcs = Integer.valueOf(parts[4]);
        int walkArea = Integer.valueOf(parts[5]);
        int x = player.getLocation().getX();
        int y = player.getLocation().getY();
        int z = player.getLocation().getZ();
        if (amountOfNpcs == 1) {
            NpcSpawnDefinitionLoader.writeNpcData(npcID, new Location(x,y,z), getFacingDirection(direction), walkArea, true);
        } else {
            for (int i = 0; i < amountOfNpcs; i++) {
                int randomX = Misc.getRandom(areaToPopulate);
                int randomY = Misc.getRandom(areaToPopulate);
                NpcSpawnDefinitionLoader.writeNpcData(npcID, new Location(x + randomX, y + randomY, z), getFacingDirection(direction), walkArea, true);
            }
        }
    }

    @Override
    public boolean canUse(Player player) {
        PlayerRights rights = player.getRights();
        return (rights == PlayerRights.OWNER || rights == PlayerRights.DEVELOPER);
    }

    public FacingDirection getFacingDirection(int direction) {
        switch(direction) {
            case 1:
                return FacingDirection.EAST;
            case 2:
                return FacingDirection.SOUTH;
            case 3:
                return FacingDirection.WEST;
            default:
                return FacingDirection.NORTH;
        }
    }
}
