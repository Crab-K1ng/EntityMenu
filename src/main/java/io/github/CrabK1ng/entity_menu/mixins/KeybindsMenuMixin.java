package io.github.CrabK1ng.entity_menu.mixins;

import finalforeach.cosmicreach.gamestates.KeybindsMenu;
import finalforeach.cosmicreach.settings.Keybind;
import io.github.CrabK1ng.entity_menu.EntityMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeybindsMenu.class)
public class KeybindsMenuMixin {
    @Shadow
    private void addKeybindButton(String label, Keybind keybind) {}
    @Inject(method = "<init>", at = @At("TAIL"))
    public void KeybindsMixin(CallbackInfo info) {
        this.addKeybindButton(EntityMenu.KEY_NAME, EntityMenu.MenuKeybind);
    }
}
