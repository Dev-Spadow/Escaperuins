package com.elvarg.game.entity.impl.object.impl;

import com.elvarg.game.GameConstants;
import com.elvarg.game.entity.impl.player.Player;
import com.elvarg.game.model.Location;
import com.elvarg.game.model.dialogues.builders.DynamicDialogueBuilder;
import com.elvarg.game.model.dialogues.entries.impl.OptionDialogue;
import com.elvarg.game.model.teleportation.TeleportHandler;
import com.elvarg.game.model.teleportation.TeleportType;

public class SecondHomePortal extends DynamicDialogueBuilder {

    @Override
    public void build(Player player) {
        add(new OptionDialogue(0, (option) -> {
            switch (option) {
                case FIRST_OPTION:
                    if (TeleportHandler.checkReqs(player, new Location(3237, 9858))) {
                        TeleportHandler.teleport(player, new Location(3237, 9858), TeleportType.NORMAL, false);
                    }
                    break;
                case SECOND_OPTION:
                    if (TeleportHandler.checkReqs(player, new Location(2869, 9827))) {
                        TeleportHandler.teleport(player, new Location(2869, 9827), TeleportType.NORMAL, false);
                    }
                    break;
                default:
                    player.getPacketSender().sendInterfaceRemoval();
                    break;
            }
        }, "Varrock Sewers", "Taverley Dungeon"));
    }
}
