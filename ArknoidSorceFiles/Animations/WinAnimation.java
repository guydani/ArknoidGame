package Animations;

import Images.Background;
import Interface.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.*;

/**
 * Created by Guy on 09/10/2016.
 */
public class WinAnimation implements Animation {
    private KeyboardSensor keyboard;
    Background background;
    private boolean stop;
    private int scores;

    public WinAnimation(KeyboardSensor keyboard, int scores) {
        this.keyboard = keyboard;
        this.background = new Background("Images/trofie.jpg");
        this.stop = false;
        this.scores = scores;
    }

    @Override
    public void doOneFrame(DrawSurface d, double dt) {
        d.drawImage(0,0,this.background.getImage());
        d.setColor(Color.cyan);
        d.drawText(d.getWidth() / 2 - 100, d.getHeight() / 2 - 70, "YOU WIN!", 50);
        d.drawText(d.getWidth() / 2 - 220 , d.getHeight() / 2 + 58 - 70, "YOUR SCORE IS " + Integer.toString(this.scores), 50);
        d.drawText(120, 580, "PRESS ENTER TO QUIT", 50);
        if (this.keyboard.isPressed(KeyboardSensor.ENTER_KEY)) { this.stop = true; }
    }

    @Override
    public boolean shouldStop() { return !this.stop; }
}
