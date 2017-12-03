package Animations;

import Interface.Animation;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * Created by Guy on 28/09/2016.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    public AnimationRunner() {
        this.gui = new GUI("ArknoidGame", 800,600);
        this.framesPerSecond = 60;
        this.sleeper = new Sleeper();
    }

    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = this.gui.getDrawSurface();
            animation.doOneFrame(d, ((double)1) / this.framesPerSecond);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    public GUI getGui() {
        return gui;
    }
}
