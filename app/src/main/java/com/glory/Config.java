package com.glory;

public class Config {
    public static String APP_PATH = "/storage/emulated/0/RockstarRp/";
    public static String PATH_DOWNLOADS = APP_PATH + "downloads/";
    public static String GAME_PATH = APP_PATH;
    // Server address (single source of truth for the Java side).
    // Keep in sync with the native server configuration.
    public static final String SERVER_HOST = "5.57.37.215";
    public static final int SERVER_PORT = 7777;

    public static final String API_LINK = "https://Rexo-RP.ir/";

    public static void setGamePath(String path) {
        if (!path.endsWith("/")) {
            path = path + "/";
        }
        APP_PATH = path;
        GAME_PATH = path;
        PATH_DOWNLOADS = path + "downloads/";
    }
}
