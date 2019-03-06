package com.mariobros.sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Nicolas Wiedel on 06.03.2019.
 */
public class Brick extends InteractiveTileObject {

    public Brick(World world, TiledMap map, Rectangle bounds){
        super(world, map, bounds);
    }
}
