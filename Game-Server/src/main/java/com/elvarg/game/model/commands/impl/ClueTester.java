package com.elvarg.game.model.commands.impl;

import com.elvarg.game.content.cluescrolls.rewards.RewardHandler;
import com.elvarg.game.entity.impl.player.Player;
import com.elvarg.game.model.commands.Command;

public class ClueTester implements Command {
    @Override
    public void execute(Player player, String command, String[] parts) {
        for (int i = 0; i < 1000; i++) {
        	RewardHandler.open(player, 2724);
        }
    }

	@Override
	public boolean canUse(Player player) {
		// TODO Auto-generated method stub
		return true;
	}
}
