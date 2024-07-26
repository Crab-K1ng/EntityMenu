package io.github.CrabK1ng.entity_menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import finalforeach.cosmicreach.TickRunner;
import finalforeach.cosmicreach.gamestates.GameState;
import finalforeach.cosmicreach.gamestates.PauseMenu;
import finalforeach.cosmicreach.lang.Lang;
import finalforeach.cosmicreach.ui.*;

import static io.github.CrabK1ng.entity_menu.EntityMenu.*;
import static io.github.CrabK1ng.entity_menu.Utils.transformString;

public class MobMenu extends GameState {
   private final GameState parent;
   private final boolean keybind;

   public MobMenu(GameState parent, boolean keybind) {
      this.parent = parent;
      this.keybind = keybind;
       UIElement spawnDroneInterceptorButton = new UIElement(-137.0F, -200.0F, 250.0F, 50.0F) {
         @Override
         public void onClick() {
            super.onClick();
            TickRunner.INSTANCE.continueTickThread();
            GameState.switchToGameState(GameState.IN_GAME);
            Utils.SpawnMob("base:entity_drone_interceptor");
         }
      };
      spawnDroneInterceptorButton.setText("spawn Drone Interceptor");
      spawnDroneInterceptorButton.show();
      this.uiObjects.add(spawnDroneInterceptorButton);

      UIElement spawnDroneTrapButton = new UIElement(137.0F, -200.0F, 250.0F, 50.0F) {
         @Override
         public void onClick() {
            super.onClick();
            TickRunner.INSTANCE.continueTickThread();
            GameState.switchToGameState(GameState.IN_GAME);
            Utils.SpawnMob("base:entity_drone_trap_interceptor");
         }
      };
      spawnDroneTrapButton.setText("spawn Drone Trap");
      spawnDroneTrapButton.show();
      this.uiObjects.add(spawnDroneTrapButton);

      UIElement spawnEmptyButton = new UIElement(137.0F, -125.0F, 250.0F, 50.0F) {
         @Override
         public void onClick() {
            super.onClick();
            TickRunner.INSTANCE.continueTickThread();
            GameState.switchToGameState(GameState.IN_GAME);
            Utils.SpawnMob("base:entity_drone_trap_interceptor");
         }
      };
      spawnEmptyButton.setText("spawn Empty");
      spawnEmptyButton.show();
      this.uiObjects.add(spawnEmptyButton);

      ///////////////
      UIElement spawnEmpty2Button = new UIElement(-137.0F, -125.0F, 250.0F, 50.0F) {
         @Override
         public void onClick() {
            super.onClick();
            TickRunner.INSTANCE.continueTickThread();
            GameState.switchToGameState(GameState.IN_GAME);
            Utils.SpawnMob(EntityMenu.MOD_ID);
         }
      };
      spawnEmpty2Button.setText("spawn Empty");
      spawnEmpty2Button.show();
      this.uiObjects.add(spawnEmpty2Button);
      ////////////

      UIElement doneButton = new UIElement(0.0F, 200.0F, 250.0F, 50.0F) {
         @Override
         public void onClick() {
            super.onClick();
            MobMenu.this.returnToPrevious(keybind);
         }
      };
      doneButton.setText(Lang.get("doneButton"));
      doneButton.show();
      this.uiObjects.add(doneButton);
   }

   private void returnToPrevious(boolean keybind) {
      if (keybind){
         TickRunner.INSTANCE.continueTickThread();
         GameState.switchToGameState(GameState.IN_GAME);
      } else if (this.parent instanceof PauseMenu) {
         GameState.switchToGameState(this.parent);
      }
      else {
         switchToGameState(this.parent);
      }
   }

   @Override
   public void render() {
      super.render();
      if (Gdx.input.isKeyJustPressed(111)) {
         if (this.keybind){
            TickRunner.INSTANCE.continueTickThread();
            GameState.switchToGameState(GameState.IN_GAME);
         }else {
            this.returnToPrevious(false);
         }
      }

      ScreenUtils.clear(0.145F, 0.078F, 0.153F, 1.0F, true);
      Gdx.gl.glEnable(2929);
      Gdx.gl.glDepthFunc(513);
      Gdx.gl.glEnable(2884);
      Gdx.gl.glCullFace(1029);
      Gdx.gl.glEnable(3042);
      Gdx.gl.glBlendFunc(770, 771);
      IN_GAME.render();
      this.drawUIElements();
   }
}
