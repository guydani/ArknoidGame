package GameClasses;

import Animations.GameLevel;
import Interface.Sprite;
import SpriteObjects.Block;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Guy on 25/09/2016.
 */
public class BlockRemover implements Observer {
    private GameLevel gameLevel;
    private Counter counter;

    public BlockRemover(GameLevel gameLevel, Counter counter) {
        this.gameLevel = gameLevel;
        this.counter = counter;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Block) {
            gameLevel.getEnvironment().removeColidable((Block)o);
            gameLevel.getSprites().removeSprite((Sprite)o);
            counter.decrease(1);
            if(counter.getValue() == 0) {
                gameLevel.setShouldStop(true);
            }
        }
    }

    public int getNumberOfBlocks() { return this.counter.getValue(); }
}
