package GameLevels;

import GeometricShapes.Velocity;
import Interface.LevelInformation;
import Interface.Sprite;
import SpriteObjects.Block;

import java.util.List;

/**
 * Created by Guy on 06/10/2016.
 */
public abstract class AbstractLevel implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return initialBallVelocities().size();
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
