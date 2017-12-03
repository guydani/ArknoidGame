package Images;

import Animations.GameLevel;
import Interface.Sprite;
import biuoop.DrawSurface;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Guy on 06/10/2016.
 */
public class Background implements Sprite {
    private Image image;

    public Background(String s) {
        this.image = null;
        image = new ImageIcon(s).getImage();
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.drawImage(0, 0, this.image);
    }

    @Override
    public void timePassed(double dt) {}

    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    public Image getImage() {
        return image;
    }
}

