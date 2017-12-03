package GameClasses;

import Animations.GameLevel;
import SpriteObjects.Ball;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Guy on 25/09/2016.
 */
public class BallRemover implements Observer{
    private GameLevel gameLevel;
    private Counter counter;

    public BallRemover(GameLevel gameLevel, Counter counter) {
        this.gameLevel = gameLevel;
        this.counter = counter;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Ball) {
            this.gameLevel.getSprites().removeSprite((Ball)o);
            this.counter.decrease(1);
            if(counter.getValue() == 0) {
                this.gameLevel.setShouldStop(true);
            }
        }
    }

    public void setAnotherBall(int i) {
        this.counter.increase(i);
    }

    public int getBalls() { return this.counter.getValue(); }
}
