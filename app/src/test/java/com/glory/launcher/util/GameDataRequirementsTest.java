package com.glory.launcher.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class GameDataRequirementsTest {
    private static final String[] REQUIRED_FILES = {
            "texdb/samp/samp.txt", "texdb/samp/samp.idx",
            "texdb/mobile/mobile.txt", "texdb/mobile/mobile.idx",
            "texdb/txd/txd.txt", "texdb/txd/txd.idx",
            "texdb/gta3/gta3.txt", "texdb/gta3/gta3.idx",
            "texdb/gta_int/gta_int.txt", "texdb/gta_int/gta_int.idx",
            "texdb/player/player.txt", "texdb/player/player.idx",
            "texdb/menu/menu.txt", "texdb/menu/menu.idx"
    };

    @Rule
    public final TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void missingTextureDatabaseFileIsIncomplete() throws Exception {
        File gameDir = temporaryFolder.newFolder("missing");
        createFiles(gameDir, REQUIRED_FILES.length - 1);

        assertFalse(GameDataRequirements.hasRequiredTextureDatabaseFiles(gameDir));
    }

    @Test
    public void allTextureDatabaseFilesMustBeNonEmpty() throws Exception {
        File gameDir = temporaryFolder.newFolder("complete");
        createFiles(gameDir, REQUIRED_FILES.length);

        assertTrue(GameDataRequirements.hasRequiredTextureDatabaseFiles(gameDir));

        File lastIndex = new File(gameDir, REQUIRED_FILES[REQUIRED_FILES.length - 1]);
        try (FileOutputStream stream = new FileOutputStream(lastIndex)) {
            stream.flush();
        }
        assertFalse(GameDataRequirements.hasRequiredTextureDatabaseFiles(gameDir));
    }

    private static void createFiles(File root, int count) throws Exception {
        for (int i = 0; i < count; i++) {
            File file = new File(root, REQUIRED_FILES[i]);
            File parent = file.getParentFile();
            if (!parent.mkdirs() && !parent.isDirectory()) {
                throw new IllegalStateException("Could not create fixture directory: " + parent);
            }
            try (FileOutputStream stream = new FileOutputStream(file)) {
                stream.write("fixture".getBytes(StandardCharsets.UTF_8));
            }
        }
    }
}
