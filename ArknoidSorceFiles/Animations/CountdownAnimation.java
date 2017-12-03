package Animations;

import GameClasses.SpriteCollection;
import Interface.Animation;
import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.*;

/**
 * Created by Guy on 29/09/2016.
 */
public class CountdownAnimation implements Animation {
    private double numOfSecond;
    private int countFrom;
    private int countDown;
    private SpriteCollection gameScreen;
    private boolean isFirst;
    private Sleeper sleeper;

    public CountdownAnimation(double numOfSecond, int countFrom, SpriteCollection gameScreen) {
        this.numOfSecond = numOfSecond;
        this.countFrom = countFrom;
        this.countDown = countFrom;
        this.gameScreen = gameScreen;
        this.isFirst = true;
        this.sleeper = new Sleeper();
    }

    @Override
    public void doOneFrame(DrawSurface d, double dt) {
        this.gameScreen.drawAllOn(d);
        drawCountDown(d, countDown);
        countDown--;
        long lingerFor = (long) (1000 * (this.numOfSecond / this.countFrom));
        if (!this.isFirst) {
            this.sleeper.sleepFor(lingerFor);
        } else {
            this.isFirst = false;
        }
    }

    @Override
    public boolean shouldStop(){
        if(countDown >= 0) {
            return true;
        }
        return false;
    }

    public void drawCountDown(DrawSurface d, int num) {
        d.setColor(Color.black);
        d.drawText(400, 300, "" + Integer.toString(num), 60);
    }
}
