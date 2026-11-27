package com.glory.launcher.util;

import java.io.File;

public final class GameDataRequirements {
    private static final String[] REQUIRED_TEXTURE_DATABASE_FILES = {
            "texdb/samp/samp.txt",
            "texdb/samp/samp.idx",
            "texdb/mobile/mobile.txt",
            "texdb/mobile/mobile.idx",
            "texdb/txd/txd.txt",
            "texdb/txd/txd.idx",
            "texdb/gta3/gta3.txt",
            "texdb/gta3/gta3.idx",
            "texdb/gta_int/gta_int.txt",
            "texdb/gta_int/gta_int.idx",
            "texdb/player/player.txt",
            "texdb/player/player.idx",
            "texdb/menu/menu.txt",
            "texdb/menu/menu.idx"
    };

    private GameDataRequirements() {}

    public static boolean hasRequiredTextureDatabaseFiles(File gameDir) {
        if (gameDir == null || !gameDir.isDirectory()) {
            return false;
        }

        for (String relativePath : REQUIRED_TEXTURE_DATABASE_FILES) {
            File file = new File(gameDir, relativePath);
            if (!file.isFile() || file.length() == 0) {
                return false;
            }
        }
        return true;
    }
}
