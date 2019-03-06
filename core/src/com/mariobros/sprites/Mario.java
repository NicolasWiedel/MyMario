package com.mariobros.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mariobros.GameConfig;

/**
 * Created by Nicolas Wiedel on 06.03.2019.
 */
public class Mario extends Sprite {

    private World world;
    private Body b2body;

    public Mario(World world){
        this.world = world;
        defineMario();
    }

    public void defineMario(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(32 / GameConfig.PPM, 32 / GameConfig.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5 / GameConfig.PPM);
        fdef.shape = shape;
        b2body.createFixture(fdef);
    }

    public Body getB2body() {
        return b2body;
    }
}
