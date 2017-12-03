package GeometricShapes;

/**
 * Created by Guy on 12/09/2016.
 */
// Velocity specifies the change in position on the `x` and the `y` axes.
public class Velocity {
    private double dx;
    private double dy;

    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = Math.sin(angle * Math.PI / 180) * speed;
        double dy = Math.cos(angle * Math.PI / 180) * speed * (-1);
        return new Velocity(dx, dy);
    }

    public double getSpeed() {
        return Math.sqrt(this.dx * this.dx + this.dy * this.dy);
    }
}