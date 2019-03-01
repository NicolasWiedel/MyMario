package com.mariobros;

public class GameConfig {

    // == constants ==
    // only for desktop
    /** width of the screen in pixels **/
    public static final int WIDTH = 960;   // pixels
    /** height of the screen in pixels **/
    public static final int HEIGHT = 624;  // pixels

    /** width of the screen in world units **/
    public static final float WORLD_WIDTH = 240f;
    /** height of the screen in world units **/
    public static final float WORLD_HEIGHT = 13f;

    /** width of the shown screen in world units **/
    public static final float WORLD_SHOWN_WIDTH = 20f;
    /** height of the screen in world units **/
    public static final float WORLD_SHOWN_HEIGHT = 13f;

    /** middle in x direction of the screen in world units **/
    public static final float WORLD_CENTER_X = WORLD_SHOWN_WIDTH / 2f;
    /** middle in y direction of the screen in world units **/
    public static final float WORLD_CENTER_Y = WORLD_SHOWN_HEIGHT / 2f;
}
