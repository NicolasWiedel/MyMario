package com.mariobros;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mariobros.sprites.Brick;
import com.mariobros.sprites.Coin;

/**
 * Created by Nicolas Wiedel on 06.03.2019.
 */
public class B2dWorldCreator {

    public B2dWorldCreator(World world, TiledMap map){
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        // ground
        for(MapObject object : map.getLayers().
                get(2).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect =((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2)  / GameConfig.PPM,
                    (rect.getY() + rect.getHeight() / 2)  / GameConfig.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2  / GameConfig.PPM,
                    rect.getHeight() / 2 / GameConfig.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }
        // pipes
        for(MapObject object : map.getLayers().
                get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect =((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2)  / GameConfig.PPM,
                    (rect.getY() + rect.getHeight() / 2)  / GameConfig.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2  / GameConfig.PPM,
                    rect.getHeight() / 2 / GameConfig.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }
        // bricks
        for(MapObject object : map.getLayers().
                get(5).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect =((RectangleMapObject) object).getRectangle();

            new Brick(world, map, rect);
        }
        // coins
        for(MapObject object : map.getLayers().
                get(4).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect =((RectangleMapObject) object).getRectangle();

            new Coin(world, map, rect);
        }
//        // goombas
//        for(MapObject object : map.getLayers().
//                get(6).getObjects().getByType(RectangleMapObject.class)){
//            Rectangle rect =((RectangleMapObject) object).getRectangle();
//
//            bdef.type = BodyDef.BodyType.StaticBody;
//            bdef.position.set((rect.getX() + rect.getWidth() / 2)  / GameConfig.PPM,
//                    (rect.getY() + rect.getHeight() / 2)  / GameConfig.PPM);
//
//            body = world.createBody(bdef);
//
//            shape.setAsBox(rect.getWidth() / 2  / GameConfig.PPM,
//                    rect.getHeight() / 2 / GameConfig.PPM);
//            fdef.shape = shape;
//            body.createFixture(fdef);
//        }
//        // turtles
//        for(MapObject object : map.getLayers().
//                get(7).getObjects().getByType(RectangleMapObject.class)){
//            Rectangle rect =((RectangleMapObject) object).getRectangle();
//
//            bdef.type = BodyDef.BodyType.StaticBody;
//            bdef.position.set((rect.getX() + rect.getWidth() / 2)  / GameConfig.PPM,
//                    (rect.getY() + rect.getHeight() / 2)  / GameConfig.PPM);
//
//            body = world.createBody(bdef);
//
//            shape.setAsBox(rect.getWidth() / 2  / GameConfig.PPM,
//                    rect.getHeight() / 2 / GameConfig.PPM);
//            fdef.shape = shape;
//            body.createFixture(fdef);
//        }
    }
}
