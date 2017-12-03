package SpriteObjects;

import Animations.GameLevel;
import GeometricShapes.Point;
import GeometricShapes.Rectangle;
import GeometricShapes.Velocity;
import Interface.Collidable;
import Interface.Sprite;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.*;

/**
 * Created by Guy on 23/09/2016.
 */
public class Paddle implements Sprite, Collidable {
    public final int MAX_X = 800;
    private KeyboardSensor keyboard;
    private Rectangle rectangle;
    private int speed;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Paddle(int width) {
        this.rectangle = new Rectangle(new Point(350, 580), width, 30, Color.BLUE);
    }

    public void setKeyboard(KeyboardSensor keyboard) {
        this.keyboard = keyboard;
    }

    public void moveLeft(double dt) {
        if(this.rectangle.getUpperLeft().getX() - speed * dt > 20) {
            this.rectangle.setUpperLeft(new Point(this.rectangle.getUpperLeft().getX() - this.speed * dt,
                    this.rectangle.getUpperLeft().getY()));
        }
    }

    public void moveRight(double dt) {
        if(this.rectangle.getUpperLeft().getX() + this.getCollisionRectangle().getWidth() + speed * dt < MAX_X - 20) {
            this.rectangle.setUpperLeft(new Point(this.rectangle.getUpperLeft().getX() + this.speed * dt,
                    this.rectangle.getUpperLeft().getY()));
        }
    }

    // Sprite
    public void timePassed(double dt) {
        if(keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft(dt);
        } else if(keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight(dt);
        }
    }

    public void drawOn(DrawSurface d) {
        this.rectangle.drawOn(d);
    }

    // Collidable
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if(this.rectangle.getLeft().checkIfPointOnLine(collisionPoint) ||
                this.rectangle.getRight().checkIfPointOnLine(collisionPoint)) {
            if(!this.rectangle.getUp().checkIfPointOnLine(collisionPoint)) {
                return new Velocity(currentVelocity.getDx() * (-1), currentVelocity.getDy());
            }
        }
        double speed = currentVelocity.getSpeed();
        int width = (int)(this.rectangle.getWidth() / 5);
        int paddleX = (int)this.getCollisionRectangle().getUpperLeft().getX();
        int collisionX = (int)collisionPoint.getX();
        if(collisionX < paddleX + width) {
            return Velocity.fromAngleAndSpeed(300, speed);
        } else if(collisionX < paddleX + 2 * width) {
            return Velocity.fromAngleAndSpeed(330, speed);
        }else if(collisionX < paddleX + 3 * width) {
            return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * (-1));
        }else if(collisionX < paddleX + 4 * width) {
            return Velocity.fromAngleAndSpeed(30, speed);
        } else {
            return Velocity.fromAngleAndSpeed(60, speed);
        }
    }

    // Add this paddle to the game.
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    public void setLocation(Point point) {
        this.rectangle.setUpperLeft(point);
    }
}