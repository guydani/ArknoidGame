package SpriteObjects;
import GameClasses.Counter;
import Animations.GameLevel;
import GeometricShapes.Rectangle;
import Interface.Sprite;
import biuoop.DrawSurface;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Guy on 25/09/2016.
 */
public class Indicator implements Observer, Sprite {
    private Rectangle rectangle;
    private Counter scores;
    private Counter lives;
    private String name;

    public Indicator(Rectangle rectangle, Counter scores, Counter lives) {
        this.rectangle = rectangle;
        this.scores = scores;
        this.lives = lives;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Block) {
            this.scores.increase(((Block) o).getValue());
        }
    }

    public int getScores() {
        return this.scores.getValue();
    }

    @Override
    public void drawOn(DrawSurface d) {
        this.rectangle.drawOn(d);
        d.setColor(Color.BLUE);
        d.drawText((int)(this.rectangle.getUpperLeft().getX() + 10),
                (int)(this.rectangle.getUpperLeft().getY() + this.rectangle.getHeight()),
                    "Lives:" + Integer.toString(getLives()) + "     Score:"
                        + Integer.toString(this.getScores()) + "         LevelName:"
                            + this.name, 20);
    }

    @Override
    public void timePassed(double dt) {
    }

    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    public int getLives() {
        return this.lives.getValue();
    }

    public void decreaseLives(int i) {
        this.lives.decrease(i);
    }

}
