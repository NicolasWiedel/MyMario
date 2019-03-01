package com.mariobros.screens.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gameutils.game.GameBase;

public class GameScreen extends ScreenAdapter {

    // == attributes ==
    /** Instanz der Spiele Basis **/
    private final GameBase gameBase;
    /** Instanz des AssetManagers **/
    private final AssetManager assetManager;
    /** Instanz des SpriteBatch **/
    private final SpriteBatch batch;

    /** Instanz des Inputs durch den User */
    private GameInput input;
    /** Instanz des GameControllers, der die gesamte Simulation des Spiels enthält */
    private GameController controller;
    /** Instanz des GameRenderer */
    private GameRenderer renderer;

    /** Konstruktor, dem die Spiele Basis übergeben wird **/
    public GameScreen(GameBase gameBase){
        this.gameBase = gameBase;
        assetManager = gameBase.getAssetManager();
        batch = gameBase.getBatch();
    }

    // == public methods ==
    /** Ort für die Instantiierung einzelner Attribute **/
    @Override
    public void show() {
        input = new GameInput(this);
        controller = new GameController(this);
        renderer = new GameRenderer(this, batch, assetManager);
    }

    /** Methode zur Dürchführung der Spielelogig und des Rendering **/
    @Override
    public void render(float delta) {
        input.update(delta);
        controller.update(delta);
        renderer.render(delta);
    }

    /** Methode zum Verändern der Größe des Screens **/
    @Override
    public void resize(int width, int height) {
        renderer.resize(width, height);
    }

    /** Methode für das Verstecken des Screens **/
    @Override
    public void hide() {
        dispose();
    }

    /** Methode für die Beendigung des Screens **/
    @Override
    public void dispose() {
        renderer.dispose();
    }

    /** getter für AssetManager */
    public AssetManager getAssetManager() {
        return assetManager;
    }
    /** getter für SpriteBatch */
    public SpriteBatch getBatch() {
        return batch;
    }
    /** getter für Input */
    public GameInput getInput() {
        return input;
    }
    /** getter für GameController */
    public GameController getController() {
        return controller;
    }
}
