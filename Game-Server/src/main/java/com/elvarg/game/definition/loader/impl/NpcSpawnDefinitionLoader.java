package com.elvarg.game.definition.loader.impl;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import com.elvarg.game.GameConstants;
import com.elvarg.game.World;
import com.elvarg.game.definition.NpcSpawnDefinition;
import com.elvarg.game.definition.loader.DefinitionLoader;
import com.elvarg.game.entity.impl.npc.NPC;
import com.elvarg.game.model.FacingDirection;
import com.elvarg.game.model.Location;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.text.Position;

public class NpcSpawnDefinitionLoader extends DefinitionLoader {
    private static ArrayList<NpcSpawnDefinition> data = null;

    @Override
    public void load() throws Throwable {
        FileReader reader = new FileReader(file());
        NpcSpawnDefinition[] defs = new Gson().fromJson(reader, NpcSpawnDefinition[].class);
        for (NpcSpawnDefinition def : defs) {
            NPC npc = NPC.create(def.getId(), def.getPosition());
            npc.getMovementCoordinator().setRadius(def.getRadius());
            npc.setFace(def.getFacing());
            World.getAddNPCQueue().add(npc);
        }
        data = new ArrayList<>(Arrays.asList(defs));
        reader.close();
    }

    @Override
    public String file() {
        return GameConstants.DEFINITIONS_DIRECTORY + "npc_spawns.json";
    }

    private static final Gson builder = new GsonBuilder().setPrettyPrinting().create();
    private static final Path FILE_PATH = Paths.get(GameConstants.DEFINITIONS_DIRECTORY + "npc_spawns.json");

    public static void writeNpcData(int npcId, Location location, FacingDirection direction, int radious, boolean add) {
        try {
            if (add) {
                data.add(new NpcSpawnDefinition(npcId, location, direction, radious));
            } else {
                data.remove(new NpcSpawnDefinition(npcId, location, direction, radious));
            }
            String output = builder.toJson(data);
            Files.write(FILE_PATH, output.getBytes());
            NPC npc = new NPC(npcId, location);
            if (add) {
                World.getAddNPCQueue().add(npc);
            }
            System.out.println("Added npc this one here: " + npc.hashCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
