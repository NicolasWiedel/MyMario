package com.mariobros;

public class GameConfig {

    // == constants ==
    // only for desktop
    /** width of the SameScreen in pixels **/
    public static final int WIDTH = 1200;   // pixels
    /** height of the GameScreen in pixels **/
    public static final int HEIGHT = 624;  // pixels

    /** width of the LoadingScreen in pixels **/
    public static final int LOADING_SCREEN_WIDTH = 1200;   // pixels
    /** height of the LoadingScreen in pixels **/
    public static final int LOADING_SCREEN_HEIGHT = 624;  // pixels

    /** width of the screen in world units **/
    public static final float WORLD_WIDTH = 240f;
    /** height of the screen in world units **/
    public static final float WORLD_HEIGHT = 13f;

    /** width of the shown screen in world units **/
    public static final float V_WIDTH = 400f;
    /** height of the screen in world units **/
    public static final float V_HEIGHT = 208f;
    public static final float PPM = 100f;

    /** middle in x direction of the screen in world units **/
    public static final float WORLD_CENTER_X = V_WIDTH / 2f;
    /** middle in y direction of the screen in world units **/
    public static final float WORLD_CENTER_Y = V_HEIGHT / 2f;
}
