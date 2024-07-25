package io.github.CrabK1ng.entity_menu;

import finalforeach.cosmicreach.entities.Entity;
import finalforeach.cosmicreach.entities.EntityCreator;
import finalforeach.cosmicreach.gamestates.InGame;
import finalforeach.cosmicreach.world.Zone;

import static finalforeach.cosmicreach.gamestates.InGame.world;

public class Utils {

    public static void SpawnMob(String MobID){
        String mobToSpawnId = MobID;
        Entity mob = EntityCreator.get(mobToSpawnId);
        mob.setPosition(InGame.getLocalPlayer().getEntity().getPosition());
        Zone zone = InGame.getLocalPlayer().getZone(world);
        zone.allEntities.add(mob);
    }
}
