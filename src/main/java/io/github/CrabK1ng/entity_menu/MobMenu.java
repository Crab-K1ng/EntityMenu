package io.github.CrabK1ng.entity_menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import finalforeach.cosmicreach.TickRunner;
import finalforeach.cosmicreach.gamestates.GameState;
import finalforeach.cosmicreach.gamestates.PauseMenu;
import finalforeach.cosmicreach.lang.Lang;
import finalforeach.cosmicreach.ui.UIElement;
import finalforeach.cosmicreach.ui.VerticalAnchor;

public class MobMenu extends GameState {
   private final GameState parent;
   private final boolean keybind;
   int ix = 0;
   int iy = 0;
   private void addMobSpawnButton(String label, String MobID) {
      MobSpawnButton MobSpawnButton = new MobSpawnButton(
         label, MobID, 275.0F * ((float)this.iy - 1.0F + 0.5f), (float)(50 + 60 * this.ix), 250.0F, 50.0F
      );
      MobSpawnButton.updateText();
      MobSpawnButton.vAnchor = VerticalAnchor.TOP_ALIGNED;
      MobSpawnButton.show();
      this.uiObjects.add(MobSpawnButton);

      ++this.iy;
      if (this.ix > 6) {
         this.ix = 0;
         ++this.iy;
      }
      if (this.iy == 2) {
         this.iy = 0;
         ++this.ix;
      }
   }

   public MobMenu(final GameState parent, boolean keybind) {
      this.parent = parent;
      this.keybind = keybind;
      this.addMobSpawnButton("Drone Interceptor", "base:entity_drone_interceptor");
      this.addMobSpawnButton("Drone Trap Interceptor", "base:entity_drone_trap_interceptor");
      UIElement doneButton = new UIElement(0.0F, -50.0F, 250.0F, 50.0F) {
         @Override
         public void onClick() {
            super.onClick();
            returnToPrevious(keybind);
         }
      };
      doneButton.vAnchor = VerticalAnchor.BOTTOM_ALIGNED;
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

   class MobSpawnButton extends UIElement {
      String MobID;
      String label;

      public MobSpawnButton(String label , String MobID, float x, float y, float w, float h) {
         super(x, y, w, h);
         this.MobID = MobID;
         this.label = label;
      }

      @Override
      public void onClick() {
         super.onClick();
         TickRunner.INSTANCE.continueTickThread();
         GameState.switchToGameState(GameState.IN_GAME);
         Utils.SpawnMob(this.MobID);
      }

      @Override
      public void updateText() {
         this.setText(this.label + " ");
      }
   }
}
