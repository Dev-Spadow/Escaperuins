package com.elvarg.game.entity.impl.object.impl;

import com.elvarg.game.entity.impl.player.Player;
import com.elvarg.game.model.Location;
import com.elvarg.game.model.dialogues.builders.DynamicDialogueBuilder;
import com.elvarg.game.model.dialogues.entries.impl.OptionDialogue;
import com.elvarg.game.model.teleportation.TeleportHandler;
import com.elvarg.game.model.teleportation.TeleportType;

public class FirstHomePortal extends DynamicDialogueBuilder {
    @Override
    public void build(Player player) {
        add(new OptionDialogue(0, (option) -> {
            switch (option) {
                case FIRST_OPTION:
                    if (TeleportHandler.checkReqs(player, new Location(2804, 3434))) {
                        TeleportHandler.teleport(player, new Location(2804, 3434), TeleportType.NORMAL, false);
                    }
                    break;
                default:
                    player.getPacketSender().sendInterfaceRemoval();
                    break;
            }
        }, "Catherby"));
    }
}
