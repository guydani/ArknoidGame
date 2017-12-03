package CheckPackage;

import SpriteObjects.Ball;
import SpriteObjects.Block;
import GameClasses.GameEnvironment;
import GeometricShapes.*;
import GeometricShapes.Point;
import GeometricShapes.Rectangle;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.awt.*;

/**
 * Created by Guy on 14/09/2016.
 */
/*
public class CheckGameEnvironment {
    public void drawBlocks() {
        GUI gui = new GUI("Blocks example", 400, 400);
        DrawSurface d = gui.getDrawSurface();
        Sleeper sleeper = new Sleeper();
        GameEnvironment gameEnvironment = new GameEnvironment();
        d.setColor(Color.black);
        Block bUp = new Block(new Rectangle(new Point(0,0),400,10));
        Block bDown = new Block(new Rectangle(new Point(0,0),10,400));
        Block bRight = new Block(new Rectangle(new Point(390,0),10,400));
        Block bLeft = new Block(new Rectangle(new Point(0,390),400,10));
        Block block = new Block(new Rectangle(new Point(200,200),50,50));
        gameEnvironment.addCollidable(bUp);
        gameEnvironment.addCollidable(bDown);
        gameEnvironment.addCollidable(bLeft);
        gameEnvironment.addCollidable(bRight);
        gameEnvironment.addCollidable(block);
        Ball ball = new Ball(new Point(200,200), 10, Color.red, gameEnvironment);
        ball.setVelocity(Velocity.fromAngleAndSpeed(50,25));
        while (true) {
            d = gui.getDrawSurface();
            ball.moveOneStep();
            ball.drawOn(d);
            bUp.drawOn(d, Color.RED);
            bDown.drawOn(d, Color.RED);
            bRight.drawOn(d, Color.RED);
            bLeft.drawOn(d,Color.RED);
            block.drawOn(d,Color.cyan);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }

    public static void main(String[] args) {
        CheckGameEnvironment example = new CheckGameEnvironment();
        example.drawBlocks();
    }
}
*/