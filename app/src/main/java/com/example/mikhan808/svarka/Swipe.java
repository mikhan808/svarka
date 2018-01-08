package com.example.mikhan808.svarka;

/**
 * Created by МишаИОля on 08.01.2018.
 */

public class Swipe {
    public static final int CANCEL = -1;
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    public static final int MIN_DELTA = 50;

    public static int getDirection(float startX, float startY, float endX, float endY) {
        float x = endX - startX;
        float y = endY - startY;
        if (Math.abs(x) > MIN_DELTA || Math.abs(y) > MIN_DELTA) {
            if (Math.abs(x) > Math.abs(y)) {
                if(x>0)
                    return RIGHT;
                else return LEFT;
            }
            else {
                if (y>0)
                    return DOWN;
                else return UP;
            }
        }
        else return CANCEL;
    }
}
