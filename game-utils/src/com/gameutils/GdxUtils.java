package com.gameutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

/**
 * created by Nicolas Wiedel on 05.01.2019
 */
public class GdxUtils {

    /** static color for cornflowerblue */
    public static final Color CORNFLOWER_BLUE =
            new Color(0.392f, 0.584f, 0.929f, 0.0f);

    /**
     *  cleas screen using default color
     */
    public static void clearScreen(){
        clearScreen(CORNFLOWER_BLUE);
    }

    /**
     * clearing screen using specified color
     *
     * @param color The color for clearing screen; if null, cornflowerblue is used
     */
    public static void clearScreen(Color color){
        if (color == null) {
            color = CORNFLOWER_BLUE;
        }

        Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
