package com.mariobros.sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mariobros.GameConfig;

/**
 * Created by Nicolas Wiedel on 06.03.2019.
 */
public abstract class InteractiveTileObject {

    protected World world;
    protected TiledMap map;
    protected TiledMapTile tile;
    protected Rectangle bounds;
    protected Body body;

    public InteractiveTileObject(World world, TiledMap map, Rectangle bounds){
        this.world = world;
        this.map = map;
        this.bounds = bounds;

        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();

        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set((bounds.getX() + bounds.getWidth() / 2)  / GameConfig.PPM,
                (bounds.getY() + bounds.getHeight() / 2)  / GameConfig.PPM);

        body = world.createBody(bdef);

        shape.setAsBox(bounds.getWidth() / 2  / GameConfig.PPM,
                bounds.getHeight() / 2 / GameConfig.PPM);
        fdef.shape = shape;
        body.createFixture(fdef);
    }
}
