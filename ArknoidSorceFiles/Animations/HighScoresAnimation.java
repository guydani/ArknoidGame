package Animations;

import Images.Background;
import Interface.Animation;
import Scores.HighScoresTable;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.*;

/**
 * Created by Guy on 14/10/2016.
 */
public class HighScoresAnimation implements Animation{
    private HighScoresTable highScoresTable;
    private KeyboardSensor keyboard;
    Background background;
    private boolean stop;

    public HighScoresAnimation(HighScoresTable highScoresTable, KeyboardSensor keyboard) {
        this.highScoresTable = highScoresTable;
        this.keyboard = keyboard;
        this.stop = false;
        this.background = new Background("Images/HighScores.jpg");
    }

    public void doOneFrame(DrawSurface d, double dt) {
        d.drawImage(0,0,this.background.getImage());
        for(int i = 0; i < this.highScoresTable.getHighScores().size(); i++) {
            d.setColor(Color.pink);
            d.drawText(120 , 126 + i * 50, this.highScoresTable.getHighScores().get(i).getName(), 30);
            d.setColor(Color.yellow);
            d.drawText(550, 126 + i * 50, Integer.toString(this.highScoresTable.getHighScores().get(i).getScore()), 30);
            d.drawText(290, 80, "PRESS SPACE TO QUIT", 20);
            if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) { this.stop = true; }
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.stop;
    }
}
