package com.elvarg.game;

import com.elvarg.game.model.Location;

/**
 * A class containing different attributes which affect the game in different
 * ways.
 *
 * @author Professor Oak
 */
public class GameConstants {

	/**
	 * The name of the game.
	 */
	public static final String NAME = "Escaperuins";

	/**
	 * The secure game UID /Unique Identifier/
	 */
	public static final int CLIENT_UID = 8784521;

	/**
	 * The directory of the definition files.
	 */
	public static final String DEFINITIONS_DIRECTORY = "./data/definitions/";

	/**
	 * The directory of the clipping files.
	 */
	public static final String CLIPPING_DIRECTORY = "./data/clipping/";

	/**
	 * The flag that determines if processing should be parallelized, improving the
	 * performance of the server times {@code n} (where
	 * {@code n = Runtime.getRuntime().availableProcessors()}) at the cost of
	 * substantially more CPU usage.
	 */
	public static final boolean CONCURRENCY = (Runtime.getRuntime().availableProcessors() > 1);

	/**
	 * The game engine cycle rate in milliseconds.
	 */
	public static final int GAME_ENGINE_PROCESSING_CYCLE_RATE = 600;

	/**
	 * The maximum amount of iterations for a queue/list that should occur each
	 * cycle.
	 */
	public static final int QUEUED_LOOP_THRESHOLD = 45;

	/**
	 * The default position, where players will spawn upon logging in for the first
	 * time.
	 */
	public static final Location DEFAULT_LOCATION = new Location(3217, 3423);

	/**
	 * Should the inventory be refreshed immediately on switching items or should it
	 * be delayed until next game cycle?
	 */
	public static final boolean QUEUE_SWITCHING_REFRESH = false;

	/**
	 * The maximum amount of drops that can be rolled from the dynamic drop table.
	 */
	public static final int DROP_THRESHOLD = 2;

	/**
	 * Multiplies the experience gained.
	 */
	public static final double COMBAT_SKILLS_EXP_MULTIPLIER = 10;
	public static final double REGULAR_SKILLS_EXP_MULTIPLIER = 30;

	/**
	 * The gameframe's tab interface ids.
	 */
	public static final int TAB_INTERFACES[] = { 2423, 3917, 31000, 3213, 1644, 5608, -1, 37128, 5065, 5715, 2449,
			42500, 147, 32000 };

	public static final int ALLOWED_SPAWNS[] = {};
	
	/**
	 * Mining Configurations
	 * {@value} ORESDEPLETE - Determines if rocks are able to be depleted and need a respawn. False: Rocks don't deplete / True: Rock's Deplete
	 * {@value} WOODCUTSTYLE_MINING - Allows for multiple ores to be mined from one rock. False: Only 1 ore will be mined, and rock will be "Depleted" / True: Multiple ores will be able to be mined before depletion
	 * WOODCUTSTYLE_MINING has higher priority over ORESDEPLETE. Ores will not deplete if WOODCUTSTYLE_MINING is True
	 */
	public static final boolean ORESDEPLETE = false;
	public static final boolean WOODCUTSTYLE_MINING = true;
}
