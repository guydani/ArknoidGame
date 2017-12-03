package GameLevels;

import GeometricShapes.Rectangle;
import GeometricShapes.Velocity;
import Images.Background;
import Interface.Sprite;
import SpriteObjects.Block;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guy on 06/10/2016.
 */
public class BestFriend extends AbstractLevel {
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(Velocity.fromAngleAndSpeed(330, 400));
        velocities.add(Velocity.fromAngleAndSpeed(30, 400));
        velocities.add(Velocity.fromAngleAndSpeed(60, 400));
        velocities.add(Velocity.fromAngleAndSpeed(85, 400));
        velocities.add(Velocity.fromAngleAndSpeed(300, 400));
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 400;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "BestFriend";
    }

    @Override
    public Sprite getBackground() {
        return new Background("Images/wolf.jpg");
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Block b;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < i; j++) {
                b = new Block(new Rectangle(new GeometricShapes.Point(370 + i * 51, 40 + j * 21), 50, 20, Color.cyan));
                blocks.add(b);
            }
        }
        for(int j = 0; j < 8; j++) {
            for(int i = 0; i < j; i++) {
                b = new Block(new Rectangle(new GeometricShapes.Point(20 + i * 51, 20 + j * 21), 50, 20, Color.white));
                blocks.add(b);
            }
        }
        return blocks;
    }
}
