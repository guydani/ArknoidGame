package MenuPackage;

import Animations.AnimationRunner;
import Images.Background;
import Interface.Menu;
import Interface.Task;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guy on 15/10/2016.
 */
public class MenuAnimation implements Menu {
    private KeyboardSensor keyboard;
    private Background background;
    private boolean stop;
    private AnimationRunner animationRunner;
    private List<Selection> tasks;
    private Task task = null;

    public MenuAnimation(AnimationRunner runner) {
        this.animationRunner = runner;
        this.keyboard = this.animationRunner.getGui().getKeyboardSensor();
        this.stop = false;
        this.background = new Background("Images/Menu.jpg");
        this.tasks = new ArrayList<>();
    }

    @Override
    public void doOneFrame(DrawSurface d, double dt) {
        d.drawImage(0, 0, this.background.getImage());
        d.setColor(Color.cyan);
        d.drawText(50, 150, "Arkanoid Game", 100);
        d.setColor(Color.green);
        for(int i = 0; i < this.tasks.size(); i++) {
            Selection selection = this.tasks.get(i);
            d.drawText(100, 250 + i* 50, selection.getMessage() + "(" + selection.getKey() + ")", 40);
        }
        for(Selection selection: this.tasks) {
            if(this.keyboard.isPressed(selection.getKey())) {
                task = selection.getTask();
                this.stop = true;
            }
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.stop;
    }

    @Override
    public void addSelection(String key, String message, Object returnVal) {
        tasks.add(new Selection(key, (Task)returnVal, message));
    }

    @Override
    public Object getStatus() {
        return task;
    }
}
