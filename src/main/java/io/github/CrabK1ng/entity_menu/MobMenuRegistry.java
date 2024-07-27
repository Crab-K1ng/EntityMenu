package io.github.CrabK1ng.entity_menu;

import java.util.ArrayList;
import java.util.List;

public class MobMenuRegistry {

    public static class MobButtonInfo {
        public final String label;
        public final String mobID;

        public MobButtonInfo(String label, String mobID) {
            this.label = label;
            this.mobID = mobID;
        }
    }

    private static final List<MobButtonInfo> mobButtons = new ArrayList<>();

    public static void registerMobButton(String label, String mobID) {
        mobButtons.add(new MobButtonInfo(label, mobID));
    }

    public static List<MobButtonInfo> getMobButtons() {
        return new ArrayList<>(mobButtons);
    }
}

