package io.github.CrabK1ng.entity_menu.mixins;

import finalforeach.cosmicreach.gamestates.GameState;
import finalforeach.cosmicreach.gamestates.PauseMenu;
import io.github.CrabK1ng.entity_menu.RenderUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PauseMenu.class)
public class PauseMenuMixin extends GameState {
    @Inject(method = "create", at = @At("TAIL"))
    private void injected(CallbackInfo ci) {
        this.uiObjects.add(RenderUtils.getModButton(this));
    }
}
