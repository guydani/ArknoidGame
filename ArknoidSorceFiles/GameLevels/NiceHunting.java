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
public class NiceHunting extends AbstractLevel{
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(Velocity.fromAngleAndSpeed(0, 500));
        velocities.add(Velocity.fromAngleAndSpeed(60, 500));
        velocities.add(Velocity.fromAngleAndSpeed(300, 500));
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 600;
    }

    @Override
    public int paddleWidth() {
        return 200;
    }

    @Override
    public String levelName() {
        return "NiceHunting";
    }

    @Override
    public Sprite getBackground() {
        return new Background("Images/cat.jpg");
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Block b;
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 15; j++) {
                 b = new Block(new Rectangle(new GeometricShapes.Point(20 + j * 51, 40 + i * 21), 50, 20, Color.white));
                blocks.add(b);
            }
        }
        return blocks;
    }
}
