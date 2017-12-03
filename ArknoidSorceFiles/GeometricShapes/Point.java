/**
 * Created by Guy on 11/09/2016.
 */
package GeometricShapes;

import java.awt.geom.Point2D;

public class Point extends Point2D{
    private double x;
    private double y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point other) {
        return Math.sqrt(((this.x - other.getX())*(this.x - other.getX()))+((this.y - other.getY())*(this.y - other.getY())));
    }

    // equals -- return true is the points are equal, false otherwise
    public boolean equals(Point other) {
        if((this.x == other.getX()) && (this.y == other.getY()))
            return true;
        return false;
    }

    @Override
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Return the x and y values of this point
    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

}
