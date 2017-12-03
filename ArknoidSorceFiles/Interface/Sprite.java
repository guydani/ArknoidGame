package Interface;

import biuoop.DrawSurface;

/**
 * Created by Guy on 23/09/2016.
 */
public interface Sprite {
    // draw the sprite to the screen
    void drawOn(DrawSurface d);
    // notify the sprite that time has passed
    void timePassed(double dt);
}
