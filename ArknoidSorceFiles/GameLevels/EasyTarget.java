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
public class EasyTarget extends AbstractLevel{

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(Velocity.fromAngleAndSpeed(5, 250));
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 200;
    }

    @Override
    public int paddleWidth() {
        return 150;
    }

    @Override
    public String levelName() {
        return "EasyTarget";
    }

    @Override
    public Sprite getBackground() {
        return new Background("Images/target.jpg");
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Block b = new Block(new Rectangle(new GeometricShapes.Point(400, 40), 50, 20, Color.gray));
        b.setValue(10);
        blocks.add(b);
        b = new Block(new Rectangle(new GeometricShapes.Point(350, 40), 50, 20, Color.gray));
        b.setValue(10);
        blocks.add(b);
        b = new Block(new Rectangle(new GeometricShapes.Point(400, 61), 50, 20, Color.gray));
        b.setValue(10);
        blocks.add(b);
        b = new Block(new Rectangle(new GeometricShapes.Point(350, 61), 50, 20, Color.gray));
        b.setValue(10);
        blocks.add(b);

        b = new Block(new Rectangle(new GeometricShapes.Point(130, 300), 50, 20, Color.gray));
        b.setValue(10);
        blocks.add(b);
        b = new Block(new Rectangle(new GeometricShapes.Point(181, 300), 50, 20, Color.gray));
        b.setValue(10);
        blocks.add(b);
        b = new Block(new Rectangle(new GeometricShapes.Point(130, 281), 50, 20, Color.gray));
        b.setValue(10);
        blocks.add(b);
        b = new Block(new Rectangle(new GeometricShapes.Point(181, 281), 50, 20, Color.gray));
        b.setValue(10);
        blocks.add(b);

        b = new Block(new Rectangle(new GeometricShapes.Point(560, 300), 50, 20, Color.gray));
        b.setValue(50);
        blocks.add(b);
        b = new Block(new Rectangle(new GeometricShapes.Point(611, 300), 50, 20, Color.gray));
        b.setValue(50);
        blocks.add(b);
        b = new Block(new Rectangle(new GeometricShapes.Point(560, 281), 50, 20, Color.gray));
        b.setValue(50);
        blocks.add(b);
        b = new Block(new Rectangle(new GeometricShapes.Point(611, 281), 50, 20, Color.gray));
        b.setValue(50);
        blocks.add(b);
        b = new Block(new Rectangle(new GeometricShapes.Point(380, 281), 50, 20, Color.gray));
        b.setValue(100);
        blocks.add(b);
        return blocks;
    }

}
