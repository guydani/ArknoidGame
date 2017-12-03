package SpriteObjects;

import GameClasses.CollisionInfo;
import Animations.GameLevel;
import GameClasses.GameEnvironment;
import GeometricShapes.Circle;
import GeometricShapes.Line;
import GeometricShapes.Point;
import GeometricShapes.Velocity;
import Interface.Sprite;
import biuoop.DrawSurface;

import java.awt.*;
import java.util.Observable;

/**
 * Created by Guy on 12/09/2016.
 */
public class Ball extends Observable implements Sprite {
    public final int MAX_Y = 600;
    private Circle circle;
    private Color color;
    private Velocity v;
    private GameEnvironment gameEnvironment;

    public Ball(double x, double y, int radius, Color c, GameEnvironment gameEnvironment) {
        this.circle = new Circle(x,y,radius);
        this.color = c;
        this.gameEnvironment = gameEnvironment;
    }

    public Ball(Point point, int radius, Color c, GameEnvironment gameEnvironment) {
        this.circle = new Circle(point, radius);
        this.color = c;
        this.gameEnvironment = gameEnvironment;
    }

    public java.awt.Color getColor() {
        return this.color;
    }

    // draw the ball on the given DrawSurface
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawCircle((int) this.circle.getPoint().getX(), (int) this.circle.getPoint().getY(), this.circle.getRadius());
        d.setColor(this.color);
        d.fillCircle((int) this.circle.getPoint().getX(), (int) this.circle.getPoint().getY(), this.circle.getRadius());
    }

    @Override
    public void timePassed(double dt) {
        moveOneStep(dt);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setVelocity(Velocity v) {
        this.v = v;
    }

    public Velocity getV() {
        return v;
    }

    public void moveOneStep(double dt)
    {
        Line trajectory = new Line(this.circle.getPoint(), new Point(this.circle.getPoint().getX() + this.v.getDx() * dt,
                this.circle.getPoint().getY() + this.v.getDy() * dt));
        CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(trajectory);
        if(collisionInfo != null) {
            this.setVelocity(collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(), this.v));
            Point p = trajectory.getP1();
            while(Math.abs(p.distance(collisionInfo.collisionPoint())) > this.circle.getRadius()) {
                p = trajectory.middle();
                trajectory.setStart(p);
            }
            //check an endpoint
            if(p.getX() != collisionInfo.collisionPoint().getX() &&
                    p.getY() != collisionInfo.collisionPoint().getY()) {
                this.circle.setPoint(p);
            }
        } else {
            this.circle.setPoint(trajectory.getP2());
            if(this.circle.getPoint().getY() >= MAX_Y ) {
                setChanged();
                notifyObservers();
            }
        }
    }

    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
