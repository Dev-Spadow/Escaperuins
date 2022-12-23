package com.runescape.data;

public class FishingSprites {
	public enum FishingSpotData {
    	SMALL_NET_OCEAN(8197, new int[] {Fish.SHRIMP.getFishId(), Fish.ANCHOVY.getFishId()}),
    	SMALL_NET_JUNGLE(8198, new int[] {Fish.KARAMBWANJI.getFishId()}),
    	FISHING_ROD_OCEAN(8199, new int[] {Fish.SARDINE.getFishId(), Fish.HERRING.getFishId()}),
       	BIG_FISHING_NET_OCEAN(8200, new int[] {Fish.MACKEREL.getFishId(), Fish.COD.getFishId(), Fish.BASS.getFishId(), Fish.CASKET.getFishId()}),
    	FLY_FISHING_ROD_RIVER(8201, new int[] {Fish.TROUT.getFishId(), Fish.SALMON.getFishId()}),
    	FISHING_ROD_RIVER(8202, new int[] {Fish.PIKE.getFishId()}),
    	FISHING_ROD_SWAMP(8203, new int[] {Fish.SLIMY_EEL.getFishId(), Fish.CAVE_EEL.getFishId()}),
    	SMALL_NET_SWAMP(8204, new int[] {Fish.FROG_SPAWN.getFishId()}),
    	HARPOON_OCEAN(8205, new int[] {Fish.TUNA.getFishId(), Fish.SWORDFISH.getFishId()}),
    	LOBSTER_POT_OCEAN(8206, new int[] {Fish.LOBSTER.getFishId()}),
    	BARBARIAN_FISHING_ROD(8207, new int[] {Fish.LEAPING_TROUT.getFishId(), Fish.LEAPING_SALMON.getFishId(), Fish.LEAPING_STURGEON.getFishId()}),
    	OILY_FISHING_ROD_LAVA(8208, new int[] {Fish.LAVA_EEL.getFishId()}),
    	SMALL_NET_FREMMINIK(8209, new int[] {Fish.MONKFISH.getFishId()}),
    	KARAMBWAN_VESSEL_JUNGLE(8210, new int[] {Fish.KARAMBWAN.getFishId()}),
    	HARPOON_DEEP_OCEAN(8211, new int[] {Fish.SHARK.getFishId()}),
    	SMALL_NET_DEEP_OCEAN(8212, new int[] {Fish.SEA_TURTLE.getFishId(), Fish.MANTA_RAY.getFishId()}),
    	SMALL_NET_FISHING_GUILD(8213, new int[] {Fish.MINNOWS.getFishId()}),
    	FISHING_ROD_ZEAH(8214, new int[] {Fish.ANGLERFISH.getFishId()}),
    	LOBSTER_POT_WILDERNESS(8215, new int[] {Fish.DARK_CRAB.getFishId()}),
    	FISHING_ROD_ARDOUGNE(8216, new int[] {Fish.SACRED_EEL.getFishId()}),
    	OILY_FISHING_ROD_INFERNAL(8217, new int[] {Fish.INFERNAL_EEL.getFishId()});
    	
		int npcId;
		int fishId[];
		
		private FishingSpotData(int npcId, int[] fishId) {
			this.npcId = npcId;
			this.fishId = fishId;
		}
		
		public int getNpcId() {
			return npcId;
		}
		
		public int getFishId(int index) {
			return fishId[index];
		}
		
		public int getFishIndexLength() {
			return fishId.length;
		}
	}
	
	private enum Fish {
        SHRIMP(317),
        SARDINE(327),
        KARAMBWANJI(3150),
        HERRING(345),
        ANCHOVY(321),
        MACKEREL(353),
        CASKET(405),
        OYSTER(407),
        TROUT(335),
        COD(341),
        PIKE(349),
        SLIMY_EEL(3379),
        SALMON(331),
        FROG_SPAWN(5004),
        TUNA(359),
        CAVE_EEL(5001),
        RAINBOW_FISH(10138),
        LOBSTER(377),
        BASS(363),
        LEAPING_TROUT(11328),
        SWORDFISH(371),
        LAVA_EEL(2148),
        LEAPING_SALMON(11330),
        MONKFISH(7944),
        KARAMBWAN(3142),
        LEAPING_STURGEON(11332),
        SHARK(383),
        SEA_TURTLE(395),
        INFERNAL_EEL(21293),
        MANTA_RAY(389),
        MINNOWS(21356),
        ANGLERFISH(13439),
        DARK_CRAB(11934),
        SACRED_EEL(13339);
		
		int fishId;
		
		private Fish(int fishId) {
			this.fishId = fishId;
		}
		
		public int getFishId() {
			return fishId;
		}
	}
}
