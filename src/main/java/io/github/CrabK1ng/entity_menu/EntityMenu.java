package io.github.CrabK1ng.entity_menu;

import dev.crmodders.cosmicquilt.api.entrypoint.ModInitializer;
import finalforeach.cosmicreach.settings.Keybind;
import io.github.CrabK1ng.entity_test.EntityTest;
import org.quiltmc.loader.api.ModContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class EntityMenu implements ModInitializer {
	public static final String MOD_ID = "entity_menu";
	public static final String MOD_NAME = "Entity Menu";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
	public static final String KEY_NAME	= "MobMenu";

	// adds the keybinds
	public static final Keybind MenuKeybind = Keybind.fromDefaultKey(KEY_NAME, 34);
	//public static final List<String> MOB_ID = new ArrayList<>();

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info(EntityMenu.MOD_NAME+" Initialized!");
		//MOB_ID.add("test_entity:test_entity");
		LOGGER.info("keybind add: "+KEY_NAME);
		//for (String mobName : MOB_ID) {
		//	LOGGER.info(mobName);
		//}
	}
}

