package io.github.CrabK1ng.entity_menu.mixins;

import com.badlogic.gdx.Gdx;
import finalforeach.cosmicreach.TickRunner;
import finalforeach.cosmicreach.gamestates.*;
import finalforeach.cosmicreach.ui.UI;
import io.github.CrabK1ng.entity_menu.MobMenu;
import io.github.CrabK1ng.entity_menu.Utils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import static finalforeach.cosmicreach.gamestates.GameState.currentGameState;

@Mixin(UI.class)
public class UIMixin {
    @Inject(method = "render", at = @At("HEAD"))
    public void renderMixin(CallbackInfo info) {
        if (Utils.MobMenuPressed()) {
            boolean cursorCatched = Gdx.input.isCursorCatched();
            Gdx.input.setCursorCatched(false);
            if (currentGameState instanceof MobMenu){
                TickRunner.INSTANCE.continueTickThread();
                GameState.switchToGameState(GameState.IN_GAME);
            }else {
                GameState.switchToGameState(new PauseMenu(cursorCatched));
                GameState.switchToGameState(new MobMenu(currentGameState, true));
            }
        }
    }
}
