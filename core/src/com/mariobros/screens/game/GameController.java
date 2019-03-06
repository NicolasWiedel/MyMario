package com.mariobros.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mariobros.B2dWorldCreator;
import com.mariobros.GameConfig;
import com.mariobros.assets.AssetDescriptors;
import com.mariobros.scenes.Hud;
import com.mariobros.sprites.Mario;

import java.security.Key;

public class GameController  {

    // == attributes ==
    /** Instanz des GameScreens **/
    private GameScreen game;

    /** Instanz des Hud **/
    private Hud hud;

    /** Instanz der Map **/
    private TiledMap map;

    /** Box2d variables */
    private World world;

    /** Instanz von Mario **/
    private Mario mario;

    /** Konstruktor mit der Referenz auf den GameScreen **/
    public GameController(GameScreen game){
        this.game = game;
        init();
    }

    // == init ==
    /** Initialisierungsmethode **/
    private void init() {
        hud = new Hud(game.getBatch(), game.getAssetManager());
        map = game.getAssetManager().get(AssetDescriptors.LEVEL1);

        // Box2D World
        world = new World(new Vector2(0, -10),true);

        mario = new Mario(world);

        new B2dWorldCreator(world, map);
    }

    /** Methode zur Spielsimulation */
    public void update(float delta){
        if (mario.getB2body().getLinearVelocity().x <= 2f &&
                mario.getB2body().getLinearVelocity().x >= -2f) {
            mario.getB2body().applyLinearImpulse(game.getInput().getVelocity(),
                    mario.getB2body().getWorldCenter(), true);
        }


        world.step(1/60f, 6, 2);

        game.getRenderer().getCamera().position.x = mario.getB2body().getPosition().x;
    }

    public void dispose(){
        map.dispose();
        world.dispose();
        hud.dispose();
    }

    // == public methods ==
    public Hud getHud() {
        return hud;
    }
    public World getWorld() {
        return world;
    }

    public TiledMap getMap() {
        return map;
    }
}
