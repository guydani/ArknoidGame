package GameLevels;

import GeometricShapes.Rectangle;
import GeometricShapes.Velocity;
import Images.Background;
import Interface.LevelInformation;
import Interface.Sprite;
import SpriteObjects.Block;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guy on 06/10/2016.
 */
public class ClimbTheMountain extends AbstractLevel{

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(Velocity.fromAngleAndSpeed(330, 300));
        velocities.add(Velocity.fromAngleAndSpeed(30, 300));
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 300;
    }

    @Override
    public int paddleWidth() {
        return 150;
    }

    @Override
    public String levelName() {
        return "Climb The Mountain";
    }

    @Override
    public Sprite getBackground() {
        return new Background("Images/mountain.jpg");
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        for(int i = 0; i < 12; i++) {
            Block b = new Block(new Rectangle(new GeometricShapes.Point(100 + i * 51, 300), 50, 20, Color.cyan));
            blocks.add(b);
            b.setValue(10);
        }
        for(int i = 0; i < 10; i++) {
            Block b = new Block(new Rectangle(new GeometricShapes.Point(150 + i * 51, 279), 50, 20, Color.gray));
            blocks.add(b);
            b.setValue(20);
        }
        for(int i = 0; i < 8; i++) {
            Block b = new Block(new Rectangle(new GeometricShapes.Point(200 + i * 51, 258), 50, 20, Color.LIGHT_GRAY));
            blocks.add(b);
            b.setValue(30);
        }
        for(int i = 0; i < 6; i++) {
            Block b = new Block(new Rectangle(new GeometricShapes.Point(250 + i * 51, 237), 50, 20, Color.green));
            blocks.add(b);
            b.setValue(40);
        }
        for(int i = 0; i < 4; i++) {
            Block b = new Block(new Rectangle(new GeometricShapes.Point(300 + i * 51, 216), 50, 20, Color.yellow));
            blocks.add(b);
            b.setValue(50);
        }
        for(int i = 0; i < 2; i++) {
            Block b = new Block(new Rectangle(new GeometricShapes.Point(350 + i * 51, 195), 50, 20, Color.white));
            blocks.add(b);
            b.setValue(75);
        }
        Block b = new Block(new Rectangle(new GeometricShapes.Point(375, 174), 50, 20, Color.red));
        blocks.add(b);
        b.setValue(100);

        return blocks;
    }

}
