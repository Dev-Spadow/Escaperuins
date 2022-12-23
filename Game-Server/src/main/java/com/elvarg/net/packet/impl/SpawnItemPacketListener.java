package com.elvarg.net.packet.impl;

import com.elvarg.game.GameConstants;
import com.elvarg.game.definition.ItemDefinition;
import com.elvarg.game.entity.impl.player.Player;
import com.elvarg.game.model.areas.impl.WildernessArea;
import com.elvarg.game.model.container.impl.Bank;
import com.elvarg.net.packet.Packet;
import com.elvarg.net.packet.PacketExecutor;

/**
 * This packet listener reads a item spawn request from the spawn tab.
 *
 * @author Professor Oak
 */

public class SpawnItemPacketListener implements PacketExecutor {

    public static void spawn(Player player, int item, int amount, boolean toBank) {

    }

    @Override
    public void execute(com.elvarg.game.entity.impl.player.Player player, Packet packet) {

    }
}
