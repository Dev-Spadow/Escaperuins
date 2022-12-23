package com.elvarg.game.entity.impl.object.impl;

import com.elvarg.game.entity.impl.player.Player;
import com.elvarg.game.model.Location;
import com.elvarg.game.model.dialogues.builders.DynamicDialogueBuilder;
import com.elvarg.game.model.dialogues.entries.impl.OptionDialogue;
import com.elvarg.game.model.teleportation.TeleportHandler;
import com.elvarg.game.model.teleportation.TeleportType;

public class SpiritTreeNetwork extends DynamicDialogueBuilder {
    @Override
    public void build(Player player) {
        add(new OptionDialogue(0, (option) -> {
            switch (option) {
                case FIRST_OPTION:
                    if (TeleportHandler.checkReqs(player, new Location(2460, 3444))) {
                        TeleportHandler.teleport(player, new Location(2460, 3444), TeleportType.NORMAL, false);
                    }
                    break;
                case SECOND_OPTION:
                    if (TeleportHandler.checkReqs(player, new Location(2542, 3170))) {
                        TeleportHandler.teleport(player, new Location(2542, 3170), TeleportType.NORMAL, false);
                    }
                    break;
                case THIRD_OPTION:
                    if (TeleportHandler.checkReqs(player, new Location(3184, 3508))) {
                        TeleportHandler.teleport(player, new Location(3184, 3508), TeleportType.NORMAL, false);
                    }
                    break;
                default:
                    player.getPacketSender().sendInterfaceRemoval();
                    break;
            }
        }, "Tree Gnome Village", "Tree Gnome Stronghold", "Grand Exchange"));
    }
}
