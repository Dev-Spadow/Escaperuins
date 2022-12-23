package com.elvarg.game.content.skill.skillable.impl;

import com.elvarg.game.content.PetHandler;
import com.elvarg.game.definition.ItemDefinition;
import com.elvarg.game.entity.impl.grounditem.ItemOnGroundManager;
import com.elvarg.game.entity.impl.npc.NPC;
import com.elvarg.game.entity.impl.player.Player;
import com.elvarg.game.model.Animation;
import com.elvarg.game.model.Item;
import com.elvarg.game.model.Projectile;
import com.elvarg.game.model.Skill;
import com.elvarg.game.task.Task;
import com.elvarg.game.task.TaskManager;
import com.elvarg.util.Chance;
import com.elvarg.util.Misc;

import javax.tools.Tool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Represents the Fishing skill.
 * @author Spadow
 * @author Professor Oak
 * @author Lare96
 */
public class Fishing extends DefaultSkillable {

    /**
     * All of the possible items you can get from a casket.
     */
    public static final Item[] CASKET_ITEMS = {new Item(1061), new Item(592), new Item(1059), new Item(995, 100000), new Item(4212), new Item(995, 50000), new Item(401), new Item(995, 150000), new Item(407)};
    /**
     * The NPC of the fishing spot we're fishing from
     */
    private final NPC fishSpot;

    /**
     * The tool we're using to fish.
     */
    private Optional<FishingTool> fishingTool = Optional.empty();
    
    /**
     * The {@link FishingSpot} we're fishing from
     */
    private final FishingSpot spot;

    /**
     * Constructs a new fishing instance.
     *
     * @param fishSpot The fish spot we're using to fish from.
     */
    public Fishing(NPC fishSpot, FishingSpot spot) {
        this.fishSpot = fishSpot;
        this.spot = spot;
    }

    @Override
    public boolean hasRequirements(Player player) {
    	/**Start the looking of a usable tool */
    	fishingTool = Optional.empty();
    	for (FishingTool tool : FishingTool.values()) {
    		if (player.getInventory().contains(tool.getId()) || player.getEquipment().contains(tool.getId())) {
    			for (int i = 0; i < tool.getFishingSpots().length; i++) {
    				if (tool.getFishingSpots()[i] == spot) {
    	                if (fishingTool.isPresent()) {
    	                    if (player.getSkillManager().getMaxLevel(Skill.FISHING) < tool.getLevel()) {
    	                        continue;
    	                    }
    	                    if (tool.getLevel() < fishingTool.get().getLevel()) {
    	                        continue;
    	                    }
    	                }
    	                
    	                fishingTool = Optional.of(tool);
    				}
    			}
    		} else {
    			for (int i = 0; i < tool.getFishingSpots().length; i++) {
    				if (tool.getFishingSpots()[i] == spot) {
						fishingTool = Optional.of(tool);
    				}
    			}
    		}
    	}
    	
        //Make sure player has tool..
        if (!player.getInventory().contains(fishingTool.get().getId()) && !player.getEquipment().contains(fishingTool.get().getId())) {
            player.getPacketSender().sendMessage("You need a " + ItemDefinition.forId(fishingTool.get().getId()).getName().toLowerCase() + " to do this.");
            return false;
        }

        //Check fishing level for tool..
        if (player.getSkillManager().getCurrentLevel(Skill.FISHING) < fishingTool.get().getLevel()) {
            player.getPacketSender().sendMessage("You need a Fishing level of at least " + fishingTool.get().getLevel() + " to use this fishing tool.");
            return false;
        }
        //Check the minimum required starting level to use a Fishing Spot
        if (player.getSkillManager().getCurrentLevel(Skill.FISHING) < spot.getRequiredLevel()) {
            player.getPacketSender().sendMessage("You need a Fishing level of at least " + spot.getRequiredLevel() + " to use this fishing spot.");
        }

        //Make sure player has required bait..
        if (spot.getRequiredBait() > 0) {
            if (!player.getInventory().contains(spot.getRequiredBait())) {
                player.getPacketSender().sendMessage("You do not have any " + ItemDefinition.forId(spot.getRequiredBait()).getName().toLowerCase() + "(s).");
                return false;
            }
        }

        return super.hasRequirements(player);
    }

    @Override
    public void start(Player player) {
        player.getPacketSender().sendMessage("You begin to fish..");
        super.start(player);
    }

    @Override
    public void startAnimationLoop(Player player) {
        Task animLoop = new Task(4, player, true) {
            @Override
            protected void execute() {
            	if (fishingTool.get().getStartingAnimation() > 0) {
            		player.performAnimation(new Animation(fishingTool.get().getStartingAnimation()));
            	} else {
                    player.performAnimation(new Animation(fishingTool.get().getLoopingAnimation()));	
            	}
            }
        };
        TaskManager.submit(animLoop);
        getTasks().add(animLoop);
    }

    @Override
    public void onCycle(Player player) {
        //Handle random event..
        if (Misc.getRandom(1400) == 1) {
            AttackToolRandomEvent attackTool = new AttackToolRandomEvent(player, fishingTool.get(), fishSpot);
            TaskManager.submit(attackTool);
            cancel(player);
        }
    }

    @Override
    public void finishedCycle(Player player) {
        /** Random stop for that 'old school' rs feel :) */
        if (Misc.getRandom(90) == 0) {
            cancel(player);
        }

        /** Catch multiple fish with a big net. */
        if (fishingTool.get() == FishingTool.BIG_NET) {
            int amount = Misc.getRandom(4) + 1;
            int freeSlots = player.getInventory().getFreeSlots();

            if (!(freeSlots >= amount)) {
                amount = freeSlots;
            }

            for (int i = 0; i < amount; i++) {

                /** Get a random fish for us. */
                Fish caught = determineFish(player, spot);

                /** Catch the fish. */
                player.getPacketSender().sendMessage("You catch a " + caught.name().toLowerCase().replace("_", " ") + ".");
                player.getInventory().add(new Item(caught.getId()));
                player.getSkillManager().addExperience(Skill.FISHING, caught.getExperience());
            }

            /** Catch fish normally. */
        } else {
            /** Get a random fish for us. */
            Fish caught = determineFish(player, spot);
            PetHandler.onSkill(player, Skill.FISHING, caught.getPetChance());
            int amountToAdd = 1;
            
            if (caught.getId() == Fish.MINNOWS.getId()) {
            	amountToAdd += Misc.randomInclusive(9, 13);
            }
            
            /** Handles the Barbarian Fishing Agility, and Strength Experience Gains **/
            if (caught.getId() == Fish.LEAPING_TROUT.getId()) {
            	player.getSkillManager().addExperience(Skill.AGILITY, 5);
            	player.getSkillManager().addExperience(Skill.STRENGTH, 5);
            }
            
            if (caught.getId() == Fish.LEAPING_SALMON.getId()) {
            	player.getSkillManager().addExperience(Skill.AGILITY, 6);
            	player.getSkillManager().addExperience(Skill.STRENGTH, 6);
            }
            
            if (caught.getId() == Fish.LEAPING_STURGEON.getId()) {
            	player.getSkillManager().addExperience(Skill.AGILITY, 7);
            	player.getSkillManager().addExperience(Skill.STRENGTH, 7);
            }

            /** Catch the fish. */
            player.getPacketSender().sendMessage("You catch a " + caught.name().toLowerCase().replace("_", " ") + ".");
            player.getInventory().add(new Item(caught.getId(), amountToAdd));
            player.getSkillManager().addExperience(Skill.FISHING, caught.getExperience());

            /** Delete the item needed for the tools. */
            if (spot.getRequiredBait() > 0) {
                player.getInventory().delete(new Item(spot.getRequiredBait()));
            }
            
            /** Clue bottle reward handler */
            if (Misc.randomInclusive(1, 500) == 250) {
            	ClueBottles clueToGive = determineClueBottle(player);
            	player.getInventory().add(new Item(clueToGive.getItem()));
            	player.getPacketSender().sendMessage("You find a Clue Bottle.");
            }
        }
    }

    @Override
    public boolean loopRequirements() {
        return true;
    }

    @Override
    public boolean allowFullInventory() {
        return false;
    }

    @Override
    public int cyclesRequired(Player player) {
    	int baseCycles = spot.getBaseCycles();
    	int fastestCycles = spot.getFastestCycles();
    	int baseDivider = 10;
    	int currentFishingLevel = player.getSkillManager().getCurrentLevel(Skill.FISHING);
    	if (currentFishingLevel >= 26 && currentFishingLevel <= 50) {
    		baseDivider -= 1;
    	} else if (currentFishingLevel >= 51 && currentFishingLevel <= 75) {
    		baseDivider -= 2;
    	} else if (currentFishingLevel >= 76 && currentFishingLevel <= 100) {
    		baseDivider -= 3;
    	} else if (currentFishingLevel >= 101 && currentFishingLevel <= 124) {
    		baseDivider -= 4;
    	} else if (currentFishingLevel == 125) {
    		baseDivider -= 5;
    	} else if (currentFishingLevel > 125) {
    		baseDivider -= 6;
    	}
    	baseCycles = (int) Math.floor(baseCycles / fishingTool.get().getSpeed());
    	baseCycles -= (int) Math.floor(player.getSkillManager().getCurrentLevel(Skill.FISHING) / baseDivider);
    	if (baseCycles < fastestCycles) {
    		baseCycles = fastestCycles;
    	}
        return baseCycles;
    }

    /**
     * Gets a random fish to be caught for the player based on fishing level and
     * rarity.
     *
     * @param player the player that needs a fish.
     * @param tool   the tool this player is fishing with.
     */
    private Fish determineFish(Player player, FishingSpot spot) {
        List<Fish> fishList = new ArrayList<Fish>();

        /** Determine which fish are able to be caught. */
        for (Fish fish : spot.getFish()) {
            if (fish.getLevel() <= player.getSkillManager().getCurrentLevel(Skill.FISHING)) {
                fishList.add(fish);
            }
        }

        /** Filter the fish based on rarity. */
        for (Iterator<Fish> iterator = fishList.iterator(); iterator.hasNext(); ) {
            Fish fish = iterator.next();

            if (fishList.size() == 1) {
                /** Return this fish if it's the only one left in the list. */
                return fish;
            }

            if (!fish.getChance().success()) {
                iterator.remove();
            }
        }

        /** Return a random fish from the list. */
        return Misc.randomElement(fishList);
    }
    
    /**
     * 
     */
    private ClueBottles determineClueBottle(Player player) {
        List<ClueBottles> bottlesList = new ArrayList<ClueBottles>();

        /** Iterates through ClueBottles enum and adds all elements to a list*/
        for (ClueBottles cb : ClueBottles.values()) {
        	bottlesList.add(cb);
        }

        /** Filters the list based on rarity, and determines the clue bottle to give */
        for (Iterator<ClueBottles> iterator = bottlesList.iterator(); iterator.hasNext(); ) {
            ClueBottles cb = iterator.next();

            if (bottlesList.size() == 1) {
                /** Return this clue bottle if it's the only one left in the list. */
                return cb;
            }

            if (!cb.getChance().success()) {
                iterator.remove();
            }
        }

        /** Return a random fish from the list. */
        return Misc.randomElement(bottlesList);
    }

    /**
     * All of the tools that can be used to catch fish.
     *
     * @author lare96
     */
	public enum FishingTool {
		NET(303, 1, 1, -1, 621, FishingSpot.SMALL_NET_OCEAN, FishingSpot.SMALL_NET_DEEP_OCEAN, FishingSpot.SMALL_NET_FISHING_GUILD, FishingSpot.SMALL_NET_FREMMINIK, FishingSpot.SMALL_NET_JUNGLE, FishingSpot.SMALL_NET_SWAMP),
		BIG_NET(305, 16, 1, -1, 620, FishingSpot.BIG_FISHING_NET_OCEAN),
		FISHING_ROD(307, 5, 1, 622, 623, FishingSpot.FISHING_ROD_OCEAN, FishingSpot.FISHING_ROD_RIVER, FishingSpot.FISHING_ROD_SWAMP, FishingSpot.FISHING_ROD_ARDOUGNE, FishingSpot.FISHING_ROD_ZEAH),
		FLY_FISHING_ROD(309, 20, 1, 622, 623, FishingSpot.FLY_FISHING_ROD_RIVER),
		HARPOON(311, 35, 1, -1, 618, FishingSpot.HARPOON_DEEP_OCEAN, FishingSpot.HARPOON_OCEAN),
		LOBSTER_POT(301, 40, 1, -1, 619, FishingSpot.LOBSTER_POT_OCEAN, FishingSpot.LOBSTER_POT_WILDERNESS),
		BARBARIAN_ROD(11323, 48, 1, 622, 623, FishingSpot.BARBARIAN_FISHING_ROD),
		OILY_FISHING_ROD(1585, 53, 1, 622, 623, FishingSpot.OILY_FISHING_ROD_INFERNAL, FishingSpot.OILY_FISHING_ROD_LAVA),
		DRAGON_HARPOON(21029, 61, 1.20, -1, 7401, FishingSpot.HARPOON_DEEP_OCEAN, FishingSpot.HARPOON_OCEAN),
		INFERNAL_HARPOON(21031, 61, 1.20, -1, 7402, FishingSpot.HARPOON_DEEP_OCEAN, FishingSpot.HARPOON_OCEAN),
		KARAMBWAN_VESSEL(3157, 65, 1, -1, 1193, FishingSpot.KARAMBWAN_VESSEL_JUNGLE);

		/** The item id of the tool. */
		private int id;

		/** The level you need to be to use this tool. */
		private int level;

		/** The speed of this tool. */
		private double speed;

		/** The starting animation performed when using this tool. */
		private int startingAnimation;
		
		/** The looping animation performed when using this tool. */
		private int loopingAnimation;
		
		/** The fishing spots this tool is usable at */
		private FishingSpot[] spots;

		/**
		 * Creates a new {@link Tool}.
		 * 
		 * @param id
		 *        the item id of the tool.
		 * @param level
		 *        the level you need to be to use this tool.
		 * @param needed
		 *        the id of an item needed to use this tool.
		 * @param speed
		 *        the speed of this tool.
		 * @param animation
		 *        the animation performed when using this tool.
		 */
		private FishingTool(int id, int level, double speed, int startingAnimation, int loopingAnimation, FishingSpot... fishingSpots ) {
			this.id = id;
			this.level = level;
			this.speed = speed;
			this.startingAnimation = startingAnimation;
			this.loopingAnimation = loopingAnimation;
			this.spots = fishingSpots;
		}

		/**
		 * Gets the item id of this tool.
		 * 
		 * @return the item id.
		 */
		public int getId() {
			return id;
		}

		/**
		 * Gets the level you need to be to use this tool.
		 * 
		 * @return the level needed.
		 */
		public int getLevel() {
			return level;
		}

		/**
		 * Get the speed modifier of this tool
		 * 
		 * @return the speed.
		 */
		public double getSpeed() {
			return speed;
		}

		/**
		 * Gets the starting animation performed when using this tool.
		 * 
		 * @return the starting animation.
		 */
		public int getStartingAnimation() {
			return startingAnimation;
		}
		
		/**
		 * Gets the looping animation performed when using this tool.
		 * 
		 * @return the looping animation.
		 */
		public int getLoopingAnimation() {
			return loopingAnimation;
		}
		
		/**
		 * Gets the fishing spots this tool is usable at
		 * 
		 * @return the fish available.
		 */
		public FishingSpot[] getFishingSpots() {
			return spots;
		}
	}
    
    /**
     * All of the fishing spots that can be used to catch fish
     * ORDER: Level
     */
    public enum FishingSpot {
    	SMALL_NET_OCEAN(1, 10, 3, -1, Fish.SHRIMP, Fish.ANCHOVY),
    	SMALL_NET_JUNGLE(5, 11, 3, -1, Fish.KARAMBWANJI),
    	FISHING_ROD_OCEAN(5, 11, 3, 313, Fish.SARDINE, Fish.HERRING),
       	BIG_FISHING_NET_OCEAN(16, 13, 3, -1, Fish.MACKEREL, Fish.COD, Fish.BASS, Fish.CASKET),
    	FLY_FISHING_ROD_RIVER(20, 14, 3, 314, Fish.TROUT, Fish.SALMON),
    	FISHING_ROD_RIVER(25, 15, 3, 313, Fish.PIKE),
    	FISHING_ROD_SWAMP(28, 16, 3, 313, Fish.SLIMY_EEL, Fish.CAVE_EEL),
    	SMALL_NET_SWAMP(33, 17, 3, -1, Fish.FROG_SPAWN),
    	HARPOON_OCEAN(35, 18, 4, -1, Fish.TUNA, Fish.SWORDFISH),
    	LOBSTER_POT_OCEAN(40, 20, 4, -1, Fish.LOBSTER),
    	BARBARIAN_FISHING_ROD(48, 23, 4, 314, Fish.LEAPING_TROUT, Fish.LEAPING_SALMON, Fish.LEAPING_STURGEON),
    	OILY_FISHING_ROD_LAVA(53, 23, 4, 313, Fish.LAVA_EEL),
    	SMALL_NET_FREMMINIK(62, 24, 4, -1, Fish.MONKFISH),
    	KARAMBWAN_VESSEL_JUNGLE(65, 24, 5, 3150, Fish.KARAMBWAN),
    	HARPOON_DEEP_OCEAN(76, 25, 5, -1, Fish.SHARK),
    	SMALL_NET_DEEP_OCEAN(79, 25, 5, -1, Fish.SEA_TURTLE, Fish.MANTA_RAY),
    	SMALL_NET_FISHING_GUILD(82, 25, 5, -1, Fish.MINNOWS),
    	FISHING_ROD_ZEAH(82, 25, 5, 13431, Fish.ANGLERFISH),
    	LOBSTER_POT_WILDERNESS(85, 26, 5, 11940, Fish.DARK_CRAB),
    	FISHING_ROD_ARDOUGNE(87, 26, 5, 313, Fish.SACRED_EEL),
    	OILY_FISHING_ROD_INFERNAL(87, 26, 5, 313, Fish.INFERNAL_EEL);
    	
    	/**
    	 * Sets the required starting level to able to fish from this spot. 
    	 */
    	private int requiredStartingLevel;
    	
    	/**
    	 * Sets the base amount of cycles required to catch a fish from the fishing spot.
    	 */
    	private int baseCycles;
    	
    	/**
    	 * Sets the fastest amount of cycles required to catch a fish from the fishing spot.
    	 */
    	private int fastestCycles;
    	
    	/**
    	 * Sets required bait to be able to fish at this spot
    	 */
    	private int requiredBait;
    	
		/** All of the fish you can catch at the Fishing Spot */
		private Fish[] fish;
		
		private FishingSpot(int level, int baseCycles, int fastCycles, int baitId, Fish... fish) {
			this.requiredStartingLevel = level;
			this.baseCycles = baseCycles;
			this.fastestCycles = fastCycles;
			this.requiredBait = baitId;
			this.fish = fish;
		}
		
		/**
		 * Gets the fish you can catch with this tool.
		 * 
		 * @return the fish available.
		 */
		public Fish[] getFish() {
			return fish;
		}
		
		/**
		 * Gets the id of the bait required to fish from this spot
		 * 
		 * @return the item needed.
		 */
		public int getRequiredBait() {
			return requiredBait;
		}
		
		/**
		 * Gets the minimum required starting level to fish at this spot
		 * 
		 * @return the level needed.
		 */
		public int getRequiredLevel() {
			return requiredStartingLevel;
		}
		
		/**
		 * Gets the base amount of cycles required to catch a fish from this fishing spot
		 * 
		 * @return baseCycles
		 */
		public int getBaseCycles() {
			return baseCycles;
		}
		
		/**
		 * Gets the fastest amount of cycles required to catch a fish from this fishing spot
		 * 
		 * @return fastestCycles
		 */
		public int getFastestCycles() {
			return fastestCycles;
		}
    }

    /**
     * All of the fish that can be caught while fishing.
     *
     * @author lare96
     */
    public enum Fish {
        SHRIMP(317, 1, 50000, Chance.VERY_COMMON, 10),
        SARDINE(327, 5, 49000, Chance.VERY_COMMON, 20),
        KARAMBWANJI(3150, 5, 49000, Chance.VERY_COMMON, 5),
        HERRING(345, 10, 48000, Chance.VERY_COMMON, 30),
        ANCHOVY(321, 15, 47000,Chance.SOMETIMES, 40),
        MACKEREL(353, 16, 46800, Chance.VERY_COMMON, 20),
        CASKET(405, 16, 46800, Chance.ALMOST_IMPOSSIBLE, 100),
        OYSTER(407, 16, 46800, Chance.EXTREMELY_RARE, 80),
        TROUT(335, 20, 45000, Chance.VERY_COMMON, 50),
        COD(341, 23, 44400, Chance.VERY_COMMON, 45),
        PIKE(349, 25, 44000, Chance.VERY_COMMON, 60),
        SLIMY_EEL(3379, 28, 43400, Chance.EXTREMELY_RARE, 65),
        SALMON(331, 30, 43000, Chance.VERY_COMMON, 70),
        FROG_SPAWN(5004, 33, 42400, Chance.VERY_COMMON, 75),
        TUNA(359, 35, 42000, Chance.VERY_COMMON, 80),
        CAVE_EEL(5001, 38, 41400, Chance.SOMETIMES, 80),
        RAINBOW_FISH(10138, 38, 41400, Chance.VERY_COMMON, 80),
        LOBSTER(377, 40, 41000, Chance.VERY_COMMON, 90),
        BASS(363, 46, 39800, Chance.SOMETIMES, 100),
        LEAPING_TROUT(11328, 48, 39400, Chance.VERY_COMMON, 50),
        SWORDFISH(371, 50, 39000, Chance.COMMON, 100),
        LAVA_EEL(2148, 53, 38400, Chance.VERY_COMMON, 60),
        LEAPING_SALMON(11330, 58, 37400, Chance.COMMON, 70),
        MONKFISH(7944, 62, 36600, Chance.VERY_COMMON, 120),
        KARAMBWAN(3142, 65, 36000, Chance.VERY_COMMON, 50),
        LEAPING_STURGEON(11332, 70, 35000, Chance.UNCOMMON, 80),
        SHARK(383, 76, 33800, Chance.COMMON, 110),
        SEA_TURTLE(395, 79, 33200, Chance.VERY_COMMON, 110),
        INFERNAL_EEL(21293, 80, 33000, Chance.VERY_COMMON, 85),
        MANTA_RAY(389, 81, 32800, Chance.COMMON, 120),
        MINNOWS(21356, 82, 32600, Chance.VERY_COMMON, 26),
        ANGLERFISH(13439, 82, 32600, Chance.VERY_COMMON, 120),
        DARK_CRAB(11934, 85, 32000, Chance.ALWAYS, 130),
        SACRED_EEL(13339, 87, 31600, Chance.ALWAYS, 105);

        /**
         * The item id of the fish.
         */
        private int id;

        /**
         * The level needed to be able to catch the fish.
         */
        private int level;

        /**
         * The pet chance associated with this fish
         */
        private int petChance;

        /**
         * The chance of catching this fish (when grouped with other fishes).
         */
        private Chance chance;

        /**
         * The experience gained from catching this fish.
         */
        private int experience;

        /**
         * Creates a new {@link Fish}.
         *
         * @param id         the item id of the fish.
         * @param level      the level needed to be able to catch the fish.
         * @param chance     the chance of catching this fish (when grouped with other
         *                   fishes).
         * @param experience the experience gained from catching this fish.
         */
        private Fish(int id, int level, int petChance, Chance chance, int experience) {
            this.id = id;
            this.level = level;
            this.petChance = petChance;
            this.chance = chance;
            this.experience = experience;
        }

        /**
         * Gets the item id of the fish.
         *
         * @return the item id.
         */
        public int getId() {
            return id;
        }

        /**
         * Gets the level needed to be able to catch the fish.
         *
         * @return the level.
         */
        public int getLevel() {
            return level;
        }

        /**
         * Gets the chance of catching this fish (when grouped with other
         * fishes).
         *
         * @return the chance.
         */
        public Chance getChance() {
            return chance;
        }

        /**
         * Gets the experience gained from catching this fish.
         *
         * @return the experience.
         */
        public int getExperience() {
            return experience;
        }
        
        /**
         * Gets the chance at which we may obtain a pet from fishing this fish.
         *
         * @return the experience.
         */
        public int getPetChance() {
            return petChance;
        }
    }
    
    /**
     * Represents the Clue Bottles we can obtain whilst fishing
     */
    public enum ClueBottles {
    	EASY(13648, Chance.COMMON),
    	MEDIUM(13649, Chance.SOMETIMES),
    	HARD(13650, Chance.VERY_UNCOMMON),
    	ELITE(13651, Chance.EXTREMELY_RARE);
    	
    	private int itemId;
    	
    	private Chance chance;
    	
    	private ClueBottles(int item, Chance chance) {
    		this.itemId = item;
    		this.chance = chance;
    	}
    	
    	public int getItem() {
    		return itemId;
    	}
    	
    	public Chance getChance() {
    		return chance;
    	}
    }

    /**
     * Represents a random event which attacks a player's tool, forcing it
     * to drop onto the ground.
     * <p>
     * This is a custom version of the OSRS "Big fish random event", which was
     * deleted in a update. The NPC "big fish" was deleted along with it,
     * so we simply shoot the projectile from the fish spot.
     *
     * @author Professor Oak
     * @author Lare96
     */
    private static final class AttackToolRandomEvent extends Task {
        /**
         * The defence animation the player will perform
         * when attacked.
         */
        private static final Animation DEFENCE_ANIM = new Animation(404);

        /**
         * The projectile which will be fired towards
         * the player from the fishing spot.
         */
        private static final int PROJECTILE_ID = 94;

        /**
         * The player being attacked by a fish.
         */
        private final Player player;

        /**
         * The tool the player is using when being
         * attacked by a fish. This will be removed
         * from inventory and put on the ground.
         */
        private final FishingTool tool;

        /**
         * The fishing spot's position. The
         * attacking npc.
         */
        private final NPC fishSpot;

        /**
         * This {@link Task}'s current tick.
         */
        private int tick;

        /**
         * Did we delete the player's tool?
         */
        private boolean deletedTool;

        /**
         * Creates this task.
         *
         * @param player
         * @param tool
         * @param spot
         */
        public AttackToolRandomEvent(Player player, FishingTool tool, NPC fishSpot) {
            super(1, player, true);
            this.player = player;
            this.tool = tool;
            this.fishSpot = fishSpot;
        }

        @Override
        protected void execute() {
            switch (tick) {
                case 0:
                    //Fire projectile at player.
                    new Projectile(fishSpot, player, PROJECTILE_ID, 40, 70, 31, 33).sendProjectile();
                    break;
                case 2:
                    //Defence animation..
                    player.performAnimation(DEFENCE_ANIM);
                    break;
                case 3:
                    //Delete tool from inventory and put on ground..
                    if (player.getInventory().contains(tool.getId())) {
                        player.getInventory().delete(tool.getId(), 1);
                        deletedTool = true;
                    }
                    break;
                case 4:
                    //Spawn tool on ground if it was deleted from inventory..
                    if (deletedTool) {
                        ItemOnGroundManager.register(player, new Item(tool.getId()));
                        player.getPacketSender().sendMessage("A big fish attacked and you were forced to drop your " + ItemDefinition.forId(tool.getId()).getName().toLowerCase() + ".");
                    }

                    //Stop task..
                    stop();
                    break;
            }
            tick++;
        }
    }
}
