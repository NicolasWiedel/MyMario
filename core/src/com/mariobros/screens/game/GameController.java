package com.mariobros.screens.game;

import com.mariobros.scenes.Hud;

public class GameController  {

    // == attributes ==
    /** Instanz des GameScreens **/
    private GameScreen game;

    /** Instanz des Hud **/
    private Hud hud;

    /** Konstruktor mit der Referenz auf den GameScreen **/
    public GameController(GameScreen game){
        this.game = game;
        init();
    }

    // == init ==
    /** Initialisierungsmethode **/
    private void init() {
        hud = new Hud(game.getBatch(), game.getAssetManager());
    }

    /** Methode zur Spielsimulation */
    public void update(float delta){

    }

    // == public methods ==
    public Hud getHud() {
        return hud;

    }
}
