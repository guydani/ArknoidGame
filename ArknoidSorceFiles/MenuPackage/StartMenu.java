package MenuPackage;

import Animations.AnimationRunner;
import Animations.HighScoresAnimation;
import Interface.Menu;
import Interface.Task;
import Scores.HighScoresTable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guy on 15/10/2016.
 */
public class StartMenu {
    private HighScoresTable highScoresTable;
    private AnimationRunner animationRunner;
    private List<Selection> tasks;
    private Menu menu;

    public StartMenu() {
        this.animationRunner = new AnimationRunner();
        this.highScoresTable = HighScoresTable.loadFromFile(new File("highscores.txt"), 10);
        this.tasks = new ArrayList<>();
    }

    public void run() {
        Task task;
        while(true) {
            createMain();
            this.animationRunner.run(this.menu);
            task = (Task)this.menu.getStatus();
            task.run();
        }
    }

    private void createMain() {
        this.menu = new MenuAnimation(animationRunner);
        Task<Void> showHiScoresTask  = new Task<Void>() {
            public Void run() {
                animationRunner.run(new HighScoresAnimation(highScoresTable, animationRunner.getGui().getKeyboardSensor()));
                return null;
            }
        };
        Task<Void> quit  = new Task<Void>() {
            public Void run() {
                highScoresTable.save(new File("highscores.txt"));
                animationRunner.getGui().close();
                System.exit(1);
                return null;
            }
        };
        GameFlow gameFlow = new GameFlow(this.animationRunner, highScoresTable);
        this.menu.addSelection("s", "Play The Game", gameFlow);
        this.menu.addSelection("h", "Show High Scores", showHiScoresTask);
        this.menu.addSelection("q", "Quit", quit);
    }

    public static void main(String[] args) {
        StartMenu startMenu = new StartMenu();
        startMenu.run();
    }
}
