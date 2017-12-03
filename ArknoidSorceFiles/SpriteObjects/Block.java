package SpriteObjects;

import Animations.GameLevel;
import GeometricShapes.Point;
import GeometricShapes.Rectangle;
import GeometricShapes.Velocity;
import Interface.Collidable;
import Interface.Sprite;
import biuoop.DrawSurface;
import java.util.Observable;


/**
 * Created by Guy on 13/09/2016.
 */
public class Block extends Observable implements Collidable, Sprite {
    private Rectangle rectangle;
    private int numberOfHits;
    private int value;

    public Block(Rectangle rectangle) {
        this.rectangle = rectangle;
        numberOfHits = 0;
        this.value = 10;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity v;
        if(this.rectangle.getDown().checkIfPointOnLine(collisionPoint) ||
                this.rectangle.getUp().checkIfPointOnLine(collisionPoint)) {
            v = new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * (-1));
        }
        else {
            v = new Velocity(currentVelocity.getDx() * (-1), currentVelocity.getDy());
        }
        setChanged();
        notifyObservers();
        return v;
    }

    public void drawOn(DrawSurface d) {
        this.getCollisionRectangle().drawOn(d);
    }

    @Override
    public void timePassed(double dt) {
    }

    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    public void addHit() {
        this.numberOfHits++;
    }

}
