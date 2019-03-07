package com.mariobros.screens.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gameutils.GdxUtils;
import com.gameutils.ViewportUtils;
import com.gameutils.debug.DebugCameraController;
import com.mariobros.GameConfig;
import com.mariobros.assets.AssetDescriptors;

public class GameRenderer {

    // == attributes ==
    /** Instanz des GameScreen **/
    private GameScreen game;
    /** Instanz des SpriteBatch **/
    private final SpriteBatch batch;
    /** Instanz des AssetManagers **/
    private final AssetManager assetManager;

    private OrthogonalTiledMapRenderer mapRenderer;

    /** Instanz der Kamera **/
    private OrthographicCamera camera;
    /** Instanz des Viewports **/
    private Viewport viewport;

    private TextureAtlas marioEnemies;
    private TextureRegion littleMario;
    private TextureRegion marioStand;

    // for debug
    /** Instanz eines ShapeRenderers zu Debugzwecken **/
    private ShapeRenderer renderer;
    /** Instanz des DebugCameraControllers aus der GameUtil **/
    private DebugCameraController debugCameraController;

    /** Box2d variables */
    private Box2DDebugRenderer b2dr;

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
        viewport = new FitViewport(GameConfig.V_WIDTH / GameConfig.PPM,
                GameConfig.V_HEIGHT / GameConfig.PPM, camera);

        mapRenderer = new OrthogonalTiledMapRenderer(game.getController().getMap(), 1 / GameConfig.PPM);

        b2dr = new Box2DDebugRenderer();

        marioEnemies = assetManager.get(AssetDescriptors.MARIO_ENEMIES);
        littleMario = marioEnemies.findRegion("little_mario");
        marioStand = new TextureRegion(littleMario);

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
//        debugCameraController.applyTo(camera);
        camera.update();

        renderMap();

        renderDebug();

        renderHud();

        renderMario();
    }

    /** Methode für das Ändern des Viewports **/
    public void resize(int width, int height){
        viewport.update(width, height, true);
        ViewportUtils.debugPixelsPerUnit(viewport);
    }

    /** Methode für disposing **/
    public void dispose(){
        b2dr.dispose();
    }

    // == private methods ==
    private void renderMap(){
        mapRenderer.setView(camera);
        mapRenderer.render();

        // rebder Box2DDebuglines
        b2dr.render(game.getController().getWorld(), camera.combined);
    }

    private void renderMario(){
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(marioStand,
                game.getController().getMario().getX(),
                game.getController().getMario().getY(),
                game.getController().getMario().getWidth(),
                game.getController().getMario().getHeight());
        batch.end();
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

    /** Methode für das Zeichnen des HUD **/
    private void renderHud(){
        batch.setProjectionMatrix(game.getController().getHud().getStage().getCamera().combined);
        game.getController().getHud().getStage().draw();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}
