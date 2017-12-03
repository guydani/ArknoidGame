package Animations;

import Images.Background;
import Interface.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.*;

/**
 * Created by Guy on 09/10/2016.
 */
public class GameOverAnimation implements Animation{
    private AnimationRunner animationRunner;
    Background background;
    private boolean stop;
    private int scores;

    public GameOverAnimation(AnimationRunner animationRunner, int scores) {
        this.animationRunner = animationRunner;
        this.background = new Background("Images/gameOver.jpg");
        this.stop = false;
        this.scores = scores;
    }

    @Override
    public void doOneFrame(DrawSurface d, double dt) {
        d.drawImage(0,0,this.background.getImage());
        d.setColor(Color.green);
        d.drawText(d.getWidth() / 2 - 150, d.getHeight() / 2 , "GAME OVER!", 50);
        d.drawText(d.getWidth() / 2 - 220 , d.getHeight() / 2 + 58 , "YOUR SCORE IS " + Integer.toString(this.scores), 50);
        d.drawText(120, 580, "PRESS ENTER TO QUIT", 50);
        if (this.animationRunner.getGui().getKeyboardSensor().isPressed(KeyboardSensor.ENTER_KEY)) { this.stop = true; }
    }

    @Override
    public boolean shouldStop() { return !this.stop; }
}
