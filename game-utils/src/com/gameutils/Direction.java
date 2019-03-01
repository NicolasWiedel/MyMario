package com.gameutils;

/**
 * Created by Nicolas Wiedel on 05.01.2019.
 */
public enum Direction {

    UP,
    DOWN,
    LEFT,
    RIGHT;

    // == public methods ==
    public boolean isUp() {
        return this == UP;
    }

    public boolean isDown() {
        return this == DOWN;
    }

    public boolean isLeft() {
        return this == LEFT;
    }

    public boolean isRight() {
        return this == RIGHT;
    }
}
