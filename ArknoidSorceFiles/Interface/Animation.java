package Interface;

import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * Created by Guy on 28/09/2016.
 */
public interface Animation {
    void doOneFrame(DrawSurface d, double dt);
    boolean shouldStop();
}