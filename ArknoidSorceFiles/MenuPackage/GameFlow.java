package MenuPackage;

import Animations.*;
import GameClasses.Counter;
import GameLevels.BestFriend;
import GameLevels.ClimbTheMountain;
import GameLevels.EasyTarget;
import GameLevels.NiceHunting;
import Interface.LevelInformation;
import Interface.Task;
import Scores.HighScoresTable;
import Scores.ScoreInfo;
import biuoop.DialogManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guy on 06/10/2016.
 */
public class GameFlow implements Task{
    private AnimationRunner animationRunner;
    private GameLevel gameLevel;
    private Counter lives;
    private Counter scores;
    private boolean isThePlayerWin;
    private HighScoresTable highScoresTable;

    public GameFlow(AnimationRunner animationRunner, HighScoresTable highScoresTable) {
        this.animationRunner = animationRunner;
        this.lives = new Counter(7);
        this.scores = new Counter(0);
        this.gameLevel = new GameLevel(this.animationRunner, this.lives, this.scores);
        this.isThePlayerWin = true;
        this.highScoresTable = highScoresTable;
    }

    public Void run() {
        List<LevelInformation> levelInformations = new ArrayList<>();
        levelInformations.add(new EasyTarget());
        levelInformations.add(new ClimbTheMountain());
        levelInformations.add(new BestFriend());
        levelInformations.add(new NiceHunting());
        for (LevelInformation levelInfo : levelInformations) {
            this.gameLevel.setLevelInformation(levelInfo, animationRunner);
            this.gameLevel.initialize();
            this.gameLevel.setShouldStop(false);
            if(!this.gameLevel.PlayGame()) {
                break;
            }
        }
        if (isThePlayerWin) {
            this.animationRunner.run(new GameOverAnimation(this.animationRunner,
                    this.scores.getValue()));
        } else {
            this.animationRunner.run(new WinAnimation(this.animationRunner.getGui().getKeyboardSensor(),
                    this.scores.getValue()));
        }
        if(this.highScoresTable.getRank(this.scores.getValue()) < this.highScoresTable.sizeTable()) {
            DialogManager dialog = this.animationRunner.getGui().getDialogManager();
            String name = dialog.showQuestionDialog("Name", "What is your name?", "");
            this.highScoresTable.add(new ScoreInfo(name, this.scores.getValue()));
        }
        this.animationRunner.run(new HighScoresAnimation(this.highScoresTable,
                this.animationRunner.getGui().getKeyboardSensor()));
        this.highScoresTable.save(new File("highscores.txt"));
        return null;
    }

}
