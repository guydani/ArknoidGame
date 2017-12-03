package CheckPackage;

/**
 * Created by Guy on 12/09/2016.
 */
/*
public class SimpleAnimation {
    public static void main(String[] args) {
        SimpleAnimation example = new SimpleAnimation();
        example.drawSimpleAnimation();
    }

    private void drawSimpleAnimation() {
        Random rand = new Random();
        GUI gui = new GUI("title",300,400);
        Sleeper sleeper = new Sleeper();
        ArrayList<Ball> a = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {

            int x = rand.nextInt(400) + 1; // get integer in range 1-400
            int y = rand.nextInt(300) + 1; // get integer in range 1-300
            int r = 20; // get integer in range 1-400
            Ball ball = new Ball(x, y, r, java.awt.Color.BLACK);
            ball.setVelocity(Velocity.fromAngleAndSpeed(5 + i*2, 5 + i*2));
            a.add(ball);
        }
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            Ball b;
            for(int i = 0; i < 5; i++) {
                b = a.get(i);
                b.moveOneStep();
                b.drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}
*/