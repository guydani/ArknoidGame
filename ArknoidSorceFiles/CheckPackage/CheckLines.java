package CheckPackage;
/**
 * Created by Guy on 12/09/2016.
 */

import GeometricShapes.Line;
import GeometricShapes.Point;
import biuoop.GUI;
import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
/*
public class CheckLines {
        public void drawRandomCircles() {
            Random rand = new Random();
            GUI gui = new GUI("Random Circles Example", 400, 300);
            DrawSurface d = gui.getDrawSurface();
            d.setColor(Color.RED);
            ArrayList<Line> a = new ArrayList();
            for (int i = 0; i < 10; ++i) {

                int x1 = rand.nextInt(400) + 1; // get integer in range 1-400
                int y1 = rand.nextInt(300) + 1; // get integer in range 1-300
                int x2 = rand.nextInt(400) + 1; // get integer in range 1-400
                int y2 = rand.nextInt(300) + 1; // get integer in range 1-300
                Line ran = new Line(x1, y1, x2, y2);
                a.add(ran);
                ran.DrawLine(d);
            }
            for(int i = 0 ; i < 10; i++) {
                for(int j = 0; j < 10; j++) {
                    if(i == j)
                        continue;
                    if(a.get(i).isIntersecting(a.get(j))) {
                        Point p = a.get(i).intersectionWith(a.get(j));
                        d.setColor(Color.BLUE);
                        d.fillCircle((int)p.getX(),(int)p.getY(),2);
                    }
                }
            }
            gui.show(d);
        }

        public static void main(String[] args) {
            CheckLines example = new CheckLines();
            example.drawRandomCircles();
        }

}
*/