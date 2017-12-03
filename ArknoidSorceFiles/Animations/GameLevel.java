package Animations;

import GameClasses.*;
import GeometricShapes.*;
import GeometricShapes.Point;
import GeometricShapes.Rectangle;
import Interface.Animation;
import Interface.Collidable;
import Interface.LevelInformation;
import Interface.Sprite;
import SpriteObjects.Ball;
import SpriteObjects.Block;
import SpriteObjects.Indicator;
import SpriteObjects.Paddle;
import biuoop.DrawSurface;
import java.awt.*;
import java.util.List;

/**
 * Created by Guy on 28/09/2016.
 */
public class GameLevel implements Animation {
    private boolean shouldStop = false;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private BlockRemover blockRemover;
    private BallRemover ballRemover;
    private Indicator indicator;
    private AnimationRunner animationRunner;
    private LevelInformation levelInformation;
    private Paddle paddle;

    public GameLevel(LevelInformation levelInformation, AnimationRunner animationRunner, Counter lives,
                     Counter scores) {
        this.levelInformation = levelInformation;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.blockRemover = new BlockRemover(this, new Counter(this.levelInformation.numberOfBlocksToRemove()));
        this.ballRemover = new BallRemover(this, new Counter(0));
        this.indicator = new Indicator(new Rectangle(new GeometricShapes.Point(0, 0), 800, 20, Color.gray),
                scores, lives);
        this.indicator.setName(this.levelInformation.levelName());
        this.animationRunner = animationRunner;
        this.paddle = new Paddle(this.levelInformation.paddleWidth());
        this.paddle.setSpeed(this.levelInformation.paddleSpeed());
    }

    public GameLevel(AnimationRunner animationRunner, Counter lives,
                     Counter scores)
    {
        this.animationRunner = animationRunner;
        this.indicator = new Indicator(new Rectangle(new GeometricShapes.Point(0, 0), 800, 20, Color.gray),
                scores, lives);
    }

    public void setLevelInformation(LevelInformation levelInformation, AnimationRunner animationRunner) {
        this.levelInformation = levelInformation;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.blockRemover = new BlockRemover(this, new Counter(this.levelInformation.numberOfBlocksToRemove()));
        this.ballRemover = new BallRemover(this, new Counter(0));
        this.paddle = new Paddle(this.levelInformation.paddleWidth());
        this.paddle.setSpeed(this.levelInformation.paddleSpeed());
        this.indicator.setName(this.levelInformation.levelName());
        this.animationRunner = animationRunner;
    }

    @Override
    public void doOneFrame(DrawSurface d, double dt) {
        if (this.animationRunner.getGui().getKeyboardSensor().isPressed("p")) {
            this.animationRunner.run(new PauseScreen(this.animationRunner.getGui().getKeyboardSensor()));
        }
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed(dt);
    }

    @Override
    public boolean shouldStop() {
        return !shouldStop;
    }

    public SpriteCollection getSprites() {
        return sprites;
    }

    public GameEnvironment getEnvironment() {
        return environment;
    }

    public void setShouldStop(boolean b) {
        this.shouldStop = b;
    }

    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    public void initialize() {
        this.sprites.addSprite(this.levelInformation.getBackground());
        this.indicator.addToGame(this);
        Block bUp = new Block(new Rectangle(new GeometricShapes.Point(0, 20), 800, 20, Color.BLACK));
        Block bLeft = new Block(new Rectangle(new GeometricShapes.Point(0, 20), 20, 600, Color.BLACK));
        Block bRight = new Block(new Rectangle(new GeometricShapes.Point(780, 20), 20, 600, Color.BLACK));
        bUp.setValue(0);
        bLeft.setValue(0);
        bRight.setValue(0);
        bUp.addToGame(this);
        bLeft.addToGame(this);
        bRight.addToGame(this);
        List<Block> list = this.levelInformation.blocks();
        for(Block block: list) {
            block.addToGame(this);
            block.addObserver(blockRemover);
            block.addObserver(indicator);
        }
    }

    private void setPaddleAndBalls() {
        this.ballRemover.setAnotherBall(this.levelInformation.numberOfBalls());
        this.paddle.addToGame(this);
        this.paddle.setKeyboard(this.animationRunner.getGui().getKeyboardSensor());
        List<Velocity> velocities = this.levelInformation.initialBallVelocities();
        for(int i = 0; i < this.levelInformation.numberOfBalls(); i++) {
            Ball b = new Ball(370, 570, 5, Color.lightGray, this.environment);
            b.addObserver(this.ballRemover);
            //b.addObserver(this.indicator);
            b.setVelocity(velocities.get(i));
            b.addToGame(this);
        }
    }

    private void deletePaddleAndBalls() {
        this.paddle.setLocation(new Point(350, 580));
        for(Sprite s: this.sprites.getSpriteArrayList()) {
            if(s instanceof Ball) {
                this.sprites.removeSprite(s);
            }
        }
    }

    public boolean PlayGame() {
        while(this.indicator.getLives() > 0) {
            this.setShouldStop(false);
            setPaddleAndBalls();
            this.animationRunner.run(new CountdownAnimation(2, 3, this.getSprites()));
            this.animationRunner.run(this);
            if(blockRemover.getNumberOfBlocks() > 0) {
                this.indicator.decreaseLives(1);
            } else {
                return true;
            }
            deletePaddleAndBalls();
        }
        return false;
    }

}
