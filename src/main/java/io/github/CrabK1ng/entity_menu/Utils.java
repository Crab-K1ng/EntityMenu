package io.github.CrabK1ng.entity_menu;

import finalforeach.cosmicreach.entities.Entity;
import finalforeach.cosmicreach.entities.EntityCreator;
import finalforeach.cosmicreach.gamestates.GameState;
import finalforeach.cosmicreach.gamestates.InGame;
import finalforeach.cosmicreach.ui.UIElement;
import finalforeach.cosmicreach.world.Zone;

import static finalforeach.cosmicreach.gamestates.InGame.world;

public class Utils {

    public static UIElement getModButton(GameState parent) {
        UIElement MobMenuButton = new UIElement(-210.0F, 100.0F, 150.0F, 50.0F) {
            public void onClick() {
                super.onClick();
                GameState.switchToGameState(new MobMenu(parent,false));
            }
        };
        MobMenuButton.show();
        MobMenuButton.setText("MobMenu");
        return MobMenuButton;
    }

    public static void SpawnMob(String MobID){
        String mobToSpawnId = MobID;
        Entity mob = EntityCreator.get(mobToSpawnId);
        mob.setPosition(InGame.getLocalPlayer().getEntity().getPosition());
        Zone zone = InGame.getLocalPlayer().getZone(world);
        zone.allEntities.add(mob);
    }


    public static boolean MobMenuPressed() {
        return EntityMenu.MenuKeybind.isJustPressed();
    }

    public static String transformString(String input) {
        String[] parts = input.split(":");
        String lastPart = parts[parts.length - 1];
        String[] subParts = lastPart.split("_");
        StringBuilder result = new StringBuilder();
        for (String subPart : subParts) {
            if (!subPart.isEmpty()) {
                result.append(Character.toUpperCase(subPart.charAt(0)))
                        .append(subPart.substring(1))
                        .append(" ");
            }
        }
        return result.toString().trim();
    }
}
