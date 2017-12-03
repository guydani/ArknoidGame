package GameClasses;

import Interface.Sprite;
import biuoop.DrawSurface;

import java.util.ArrayList;

/**
 * Created by Guy on 23/09/2016.
 */
public class SpriteCollection {
    private ArrayList<Sprite> spriteArrayList;

    public SpriteCollection() {
        this.spriteArrayList = new ArrayList<Sprite>();
    }
    public void addSprite(Sprite s) {
        this.spriteArrayList.add(s);
    }
    public void removeSprite(Sprite s) {
        this.spriteArrayList.remove(s);
    }
    // call timePassed() on all sprites.
    public void notifyAllTimePassed(double dt) {
        ArrayList<Sprite> arrayList = new ArrayList(this.spriteArrayList);
        for(Sprite s: arrayList) {
            s.timePassed(dt);
        }
    }

    // call drawOn(d) on all sprites.
    public void drawAllOn(DrawSurface d) {
        for(Sprite s: this.spriteArrayList) {
            s.drawOn(d);
        }
    }

    public ArrayList<Sprite> getSpriteArrayList() {
        return spriteArrayList;
    }
}
