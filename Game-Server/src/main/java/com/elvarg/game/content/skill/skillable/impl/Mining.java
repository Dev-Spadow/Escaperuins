package com.elvarg.game.content.skill.skillable.impl;

import com.elvarg.game.GameConstants;
import com.elvarg.game.content.PetHandler;
import com.elvarg.game.definition.ItemDefinition;
import com.elvarg.game.entity.impl.object.GameObject;
import com.elvarg.game.entity.impl.object.MapObjects;
import com.elvarg.game.entity.impl.player.Player;
import com.elvarg.game.model.Animation;
import com.elvarg.game.model.Skill;
import com.elvarg.game.model.container.impl.Equipment;
import com.elvarg.game.task.Task;
import com.elvarg.game.task.TaskManager;
import com.elvarg.game.task.impl.TimedObjectReplacementTask;
import com.elvarg.util.Misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Represents the Mining skill.
 *
 * @author Professor Oak
 */
public class Mining extends DefaultSkillable {

    /**
     * The {@link GameObject} to mine.
     */
    private final GameObject rockObject;
    /**
     * The {@code rock} as an enumerated type
     * which contains information about it, such as
     * required level.
     */
    private final Rock rock;
    /**
     * The pickaxe we're using to mine.
     */
    private Optional<Pickaxe> pickaxe = Optional.empty();

    /**
     * Constructs a new {@link Mining}.
     *
     * @param rockObject The rock to mine.
     * @param rock       The rock's data
     */
    public Mining(GameObject rockObject, Rock rock) {
        this.rockObject = rockObject;
        this.rock = rock;
    }

    @Override
    public void start(Player player) {
        player.getPacketSender().sendMessage("You swing your pickaxe at the rock..");
        super.start(player);
    }

    @Override
    public void startAnimationLoop(Player player) {
        Task animLoop = new Task(6, player, true) {
            @Override
            protected void execute() {
                player.performAnimation(pickaxe.get().getAnimation());
            }
        };
        TaskManager.submit(animLoop);
        getTasks().add(animLoop);
    }

    @Override
    public void onCycle(Player player) {
        PetHandler.onSkill(player, Skill.MINING);
    }

    @Override
    public void finishedCycle(Player player) {
    	boolean infernalPerkTriggered = false;
        // Add ores..
        if (player.getEquipment().getItems()[Equipment.WEAPON_SLOT].getId() == 13243
                || player.getInventory().contains(13243) || player.getEquipment().getItems()[Equipment.WEAPON_SLOT].getId() == 22518
                || player.getInventory().contains(22518)) {
        	if (Misc.inclusive(1, 3) == 3) {
        		if (rock.getBarId() !=  -1)
        			infernalPerkTriggered = true;
        	}
        }
        if (infernalPerkTriggered) {
        	player.getInventory().add(rock.getBarId(), 1);
        	player.getPacketSender().sendMessage("Your infernal pickaxe burns hot.");
        	player.getSkillManager().addExperience(Skill.SMITHING, rock.getSmeltXpReward());
        } else {
        	player.getInventory().add(rock.getOreId(), 1);
            player.getPacketSender().sendMessage("You mine a " + ItemDefinition.forId(rock.getOreId()).getName());
        }
        // Add exp..
        player.getSkillManager().addExperience(Skill.MINING, rock.getXpReward());

        // Stop skilling..
        if (GameConstants.WOODCUTSTYLE_MINING) {
        	if (Misc.randomInclusive(1, 40) == 17) {
        		player.getPacketSender().sendMessage("You have stopped mining.");
        		cancel(player);
        	}
        	
        } else {
        	cancel(player);
            // Despawn object and respawn it after a short period of time..
            if (GameConstants.ORESDEPLETE) {
                TaskManager.submit(new TimedObjectReplacementTask(rockObject,
                        new GameObject(2704, rockObject.getLocation(), 10, 0, player.getPrivateArea()),
                        rock.getRespawnTimer()));
            }
        }
    }

    @Override
    public int cyclesRequired(Player player) {
        int cycles = rock.getCycles() + Misc.getRandom(4);
        cycles -= (int) player.getSkillManager().getMaxLevel(Skill.MINING) * 0.1;
        cycles -= cycles * pickaxe.get().getSpeed();
        if (cycles < 3) {
            cycles = 3;
        }
        return cycles;
    }

    @Override
    public boolean hasRequirements(Player player) {
        //Attempt to find a pickaxe..
        pickaxe = Optional.empty();
        for (Pickaxe a : Pickaxe.values()) {
            if (player.getEquipment().getItems()[Equipment.WEAPON_SLOT].getId() == a.getId()
                    || player.getInventory().contains(a.getId())) {

                //If we have already found a pickaxe,
                //don't select others that are worse or can't be used
                if (pickaxe.isPresent()) {
                    if (player.getSkillManager().getMaxLevel(Skill.MINING) < a.getRequiredLevel()) {
                        continue;
                    }
                    if (a.getRequiredLevel() < pickaxe.get().getRequiredLevel()) {
                        continue;
                    }
                }

                pickaxe = Optional.of(a);
            }
        }

        //Check if we found one..
        if (!pickaxe.isPresent()) {
            player.getPacketSender().sendMessage("You don't have a pickaxe which you can use.");
            return false;
        }

        //Check if we have the required level to mine this {@code rock} using the {@link Pickaxe} we found..
        if (player.getSkillManager().getCurrentLevel(Skill.MINING) < pickaxe.get().getRequiredLevel()) {
            player.getPacketSender().sendMessage("You don't have a pickaxe which you have the required Mining level to use.");
            return false;
        }

        //Check if we have the required level to mine this {@code rock}..
        if (player.getSkillManager().getCurrentLevel(Skill.MINING) < rock.getRequiredLevel()) {
            player.getPacketSender().sendMessage("You need a Mining level of at least " + rock.getRequiredLevel() + " to mine this rock.");
            return false;
        }

        //Finally, check if the rock object remains there.
        //Another player may have mined it already.
        if (!MapObjects.exists(rockObject)) {
            return false;
        }

        return super.hasRequirements(player);
    }

    @Override
    public boolean loopRequirements() {
        return true;
    }

    @Override
    public boolean allowFullInventory() {
        return false;
    }

    public GameObject getTreeObject() {
        return rockObject;
    }

    /**
     * Holds data related to the pickaxes
     * that can be used for this skill.
     */
    public static enum Pickaxe {
        INFERNO_ADZE(22518, 1, new Animation(4482), 0.25),
        BRONZE(1265, 1, new Animation(625), 0.03),
        IRON(1267, 1, new Animation(626), 0.05),
        STEEL(1269, 6, new Animation(627), 0.09),
        BLACK(12297, 11, new Animation(3873), 0.10),
        MITHRIL(1273, 21, new Animation(628), 0.13),
        ADAMANT(1271, 31, new Animation(629), 0.16),
        RUNE(1275, 41, new Animation(624), 0.20),
        DRAGON(11920, 61, new Animation(7139), 0.25),
        DRAGON_OR(12797, 61, new Animation(335), 0.25),
        INFERNAL(13243, 61, new Animation(4482), 0.25),
        THIRD_AGE(20014, 81, new Animation(7283), 0.50);

        private final int id, requiredLevel;
        private final Animation animation;
        private final double speed;

        private Pickaxe(int id, int req, Animation animaion, double speed) {
            this.id = id;
            this.requiredLevel = req;
            this.animation = animaion;
            this.speed = speed;
        }

        public int getId() {
            return id;
        }

        public int getRequiredLevel() {
            return requiredLevel;
        }

        public Animation getAnimation() {
            return animation;
        }

        public double getSpeed() {
            return this.speed;
        }
    }

    /**
     * Holds data related to the rocks
     * which can be used to train this skill.
     */
    public static enum Rock {
        CLAY(new int[]{7487, 7454}, 1, 5, 434, 11, 2, -1, -1),
        COPPER(new int[]{7484}, 1, 18, 436, 12, 4, 2349, 9),
        TIN(new int[]{7485, 7486}, 1, 18, 438, 12, 4, 2349, 9),
        IRON(new int[]{7488}, 15, 35, 440, 13, 5, 2351, 20),
        SILVER(new int[]{7457, 7490}, 20, 40, 442, 14, 7, 2355, 40),
        COAL(new int[]{7489}, 30, 50, 453, 15, 7, -1, -1),
        GOLD(new int[]{7491}, 40, 65, 444, 15, 10, 2357, 65),
        MITHRIL(new int[]{7492}, 50, 80, 447, 17, 11, 2359, 140),
        ADAMANTITE(new int[]{7493}, 70, 95, 449, 18, 14, 2361, 200),
        RUNITE(new int[]{7494}, 85, 125, 451, 23, 45, 2363, 265);

        private static final Map<Integer, Rock> rocks = new HashMap<Integer, Rock>();

        static {
            for (Rock t : Rock.values()) {
                for (int obj : t.objects) {
                    rocks.put(obj, t);
                }
                rocks.put(t.getOreId(), t);
            }
        }

        private int objects[];
        private int oreId, requiredLevel, xpReward, cycles, respawnTimer, barId, smeltXpReward;

        private Rock(int[] objects, int requiredLevel, int xpReward, int oreId, int cycles, int respawnTimer, int barId, int smeltXpReward) {
            this.objects = objects;
            this.requiredLevel = requiredLevel;
            this.xpReward = xpReward;
            this.oreId = oreId;
            this.cycles = cycles;
            this.respawnTimer = respawnTimer;
            this.barId = barId;
            this.smeltXpReward = smeltXpReward;
        }

        public static Optional<Rock> forObjectId(int objectId) {
            return Optional.ofNullable(rocks.get(objectId));
        }

        public int getRespawnTimer() {
            return respawnTimer;
        }

        public int getRequiredLevel() {
            return requiredLevel;
        }

        public int getXpReward() {
            return xpReward;
        }

        public int getOreId() {
            return oreId;
        }

        public int getCycles() {
            return cycles;
        }
        
        public int getBarId() {
            return barId;
        }
        
        public int getSmeltXpReward() {
        	return smeltXpReward;
        }
    }
}
