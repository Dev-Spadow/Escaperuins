package com.elvarg.game.content.cluescrolls;

public enum RiddleClues {
	TEST(2677, "Testing", new int[]{3086, 3496}, ClueLevel.EASY);
	
	private int cluescrollId;
	private String clue;
	private int[] digCoordinates;
	private ClueLevel level;
	
	RiddleClues(int clueId, String clue, int[] digCoordinates, ClueLevel level) {
		this.cluescrollId = clueId;
		this.clue = clue;
		this.digCoordinates = digCoordinates;
		this.level = level;
	}
	
	public int getClueId() {
		return cluescrollId;
	}
	
	public String getClue() {
		return clue;
	}
	
	public int getClueDigX() {
		return digCoordinates[0];
	}
	
	public int getClueDigY() {
		return digCoordinates[1];
	}
	
	public int getClueDigZ() {
		return digCoordinates[2];
	}
	
	public ClueLevel getLevel() {
		return level;
	}
}
