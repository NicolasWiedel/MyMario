package com.mariobros.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.math.Vector2;

public class GameInput {

    // == constants ==
    /** controler buttons */
    private static final int BUTTON_B = 1;
    private static final int BUTTON_X = 2;
    private static final int BUTTON_Y = 3;
    private static final int BUTTON_A = 0;
    private static final int X_AXIS = 1;
    private static final int Y_AXIS = 0;

    // == attributes ==
    /** Instanz des GameScreens **/
    private GameScreen game;
    /** Instanz der Geschwindigkeit **/
    private Vector2 velocity;
    /** Instanz des GamePas Controllers **/
    private Controller gamePad;

    /** Attribut zur Darstellung des DebugGrids **/
    private boolean drawGrid = false;
    /** Attribut zur Darstellung der Debugelemente der Entities **/
    private boolean drawDebug = false;

    /** Konstruktor mit der Referenz auf den GameScreen **/
    public GameInput(GameScreen game){
        this.game = game;
    }

    /** update Methode zum Abfangen von Benutzereingaben */
    public void update(float delta){

        Vector2 velocity = new Vector2(0, 0);

        // Keyboard input
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            velocity.x = -1;
        }if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            velocity.x = 1;
        }if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            velocity.y = 1;
        }if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            velocity.y = -1;
        }

        // gamepad input
        if (Controllers.getControllers().size != 0) {
            gamePad = Controllers.getControllers().first();
            if (!(gamePad.getAxis(X_AXIS) > -0.2f&& gamePad.getAxis(X_AXIS) < 0.2f)) {
                velocity.x = gamePad.getAxis(X_AXIS);
            }
            if (!(gamePad.getAxis(Y_AXIS) > -0.2f && gamePad.getAxis(Y_AXIS) < 0.1f)) {
                velocity.y = -gamePad.getAxis(Y_AXIS);
            }
        }

        this.velocity = velocity;

        /** auf Debug Input überprüfen */
        handleDebugInput();
    }

    // == private methods ==
    /** private Klasse zum Anzeigen und entfernen der Debugfunktionen **/
    private void handleDebugInput(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.F5)){
            toggleDrawGrid();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.F6)){
            toggleDebug();
        }
    }

    /** getter um die die Eingaben übergeben zu können */
    public Vector2 getVelocity() {
        return velocity;
    }

    /** getter für das DebugGrid **/
    public boolean isDrawGrid() { return drawGrid;  }
    /** getter für die Debugelemente **/
    public boolean isDrawDebug() {
        return drawDebug;
    }
    /** setter für das DebugGrid **/
    public void toggleDrawGrid(){
        drawGrid = !drawGrid;
    }
    /** setter für die Debugelemente **/
    public void toggleDebug(){
        drawDebug = !drawDebug;
    }
}
