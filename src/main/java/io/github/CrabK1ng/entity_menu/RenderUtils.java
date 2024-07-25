package io.github.CrabK1ng.entity_menu;

import finalforeach.cosmicreach.gamestates.*;
import finalforeach.cosmicreach.ui.UIElement;

public class RenderUtils {
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
}
