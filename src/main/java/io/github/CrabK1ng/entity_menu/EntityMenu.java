package io.github.CrabK1ng.entity_menu;

import com.github.puzzle.loader.entrypoint.interfaces.ModInitializer;
import finalforeach.cosmicreach.settings.Keybind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityMenu implements ModInitializer {
	public static final String MOD_ID = "entity_menu";
	public static final String MOD_NAME = "Entity Menu";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
	public static final String KEY_NAME	= "MobMenu";

	// adds the keybinds
	public static final Keybind MenuKeybind = Keybind.fromDefaultKey(KEY_NAME, 34);

	@Override
	public void onInit() {
		LOGGER.info(EntityMenu.MOD_NAME+" Initialized!");
		LOGGER.info("keybind add: "+KEY_NAME);
	}
}

