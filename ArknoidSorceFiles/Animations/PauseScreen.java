package Animations;

import Interface.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * Created by Guy on 28/09/2016.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }
    public void doOneFrame(DrawSurface d, double dt) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) { this.stop = true; }
    }
    public boolean shouldStop() { return !this.stop; }
}
