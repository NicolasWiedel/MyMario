package com.mariobros.screens.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gameutils.GdxUtils;
import com.gameutils.ViewportUtils;
import com.gameutils.debug.DebugCameraController;
import com.mariobros.GameConfig;

public class GameRenderer {

    // == attributes ==
    /** Instanz des GameScreen **/
    private GameScreen game;
    /** Instanz des SpriteBatch **/
    private final SpriteBatch batch;
    /** Instanz des AssetManagers **/
    private final AssetManager assetManager;

    /** Instanz der Kamera **/
    private OrthographicCamera camera;
    /** Instanz des Viewports **/
    private Viewport viewport;

    // for debug
    /** Instanz eines ShapeRenderers zu Debugzwecken **/
    private ShapeRenderer renderer;
    /** Instanz des DebugCameraControllers aus der GameUtil **/
    private DebugCameraController debugCameraController;

    // == constructor ==
    /** Konstruktor mit GameWorld SpriteBatch und AssetManager als Parameter **/
    public GameRenderer(GameScreen game,SpriteBatch batch, AssetManager assetManager ){
        this.game = game;
        this.batch = batch;
        this.assetManager = assetManager;
        init();
    }

    // == init ==
    /** Methode zur initialisierung aller Graphikelemente **/
    private void init(){
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, camera);

        renderer = new ShapeRenderer();
        debugCameraController = new DebugCameraController();


        debugCameraController.setStartPosition(GameConfig.WORLD_CENTER_X, GameConfig.WORLD_CENTER_Y);
    }

    // == public methods ==
    /** Methode für das Rendering **/
    public void render(float delta){
        // clear screen
        GdxUtils.clearScreen();

        // debug
        debugCameraController.handleDebugInput(delta);
        debugCameraController.applyTo(camera);

        renderDebug();
    }

    /** Methode für das Ändern des Viewports **/
    public void resize(int width, int height){
        viewport.update(width, height, true);

        ViewportUtils.debugPixelsPerUnit(viewport);
    }

    /** Methode für disposing **/
    public void dispose(){

    }

    /** Methode für das RenderingDebug **/
    private void renderDebug(){
        viewport.apply();

        if(game.getInput().isDrawGrid()){
            ViewportUtils.drawGrid(viewport, renderer);
        }
        if(game.getInput().isDrawDebug()){
            renderer.setProjectionMatrix(camera.combined);
            renderer.begin(ShapeRenderer.ShapeType.Line);
            drawDebug();
            renderer.end();
        }
    }

    /** Methode für das Zeichnen von Debuglinien **/
    private void drawDebug(){
        // save old color
        Color oldColor = renderer.getColor().cpy();

        renderer.setColor(Color.BLUE);
        // render item debug


        // revert to old color
        renderer.setColor(oldColor);
    }
}
