/**
 * Created by Guy on 11/09/2016.
 */
package GeometricShapes;

import biuoop.DrawSurface;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Line extends java.awt.geom.Line2D {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(double x1, double y1, double x2, double y2) {
        Point start = new Point(x1,y1);
        Point end = new Point(x2,y2);
        this.start = start;
        this.end = end;
    }

    @Override
    public double getX1() {
        return this.start.getX();
    }

    @Override
    public double getY1() {
        return this.start.getY();
    }

    @Override
    public Point getP1() {
        return this.start;
    }

    @Override
    public double getX2() {
        return this.end.getX();
    }

    @Override
    public double getY2() {
        return this.end.getY();
    }

    @Override
    public Point getP2() {
        return this.end;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public void setLine(double x1, double y1, double x2, double y2) {
        this.start.setLocation(x1,y1);
        this.end.setLocation(x2,y2);
    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }

    public boolean isIntersecting(Line other) {
        return this.intersectsLine(other);
    }

    public Point intersectionWith(Line other) {
        double d = (this.getX1() - this.getX2())*(other.getY1() - other.getY2()) -
                (this.getY1() - this.getY2()) * (other.getX1() - other.getX2());
        if (d == 0)
            return null;
        double x = ((other.getX1() - other.getX2()) * (this.getX1() * this.getY2() - this.getY1() * this.getX2())
                - (this.getX1() - this.getX2()) * (other.getX1() * other.getY2() - other.getY1() * other.getX2()))/d;
        double y = ((other.getY1() - other.getY2()) * (this.getX1() * this.getY2() - this.getY1() * this.getX2())
                - (this.getY1() - this.getY2()) * (other.getX1() * other.getY2() - other.getY1() * other.getX2()))/d;
        return new Point(x,y);
    }

    public boolean equals(Line other) {
        if((this.start.equals(other.getP1()) && this.end.equals(other.getP2())
                || (this.start.equals(other.getP2()) && this.end.equals(other.getP1())))) {
            return true;
        }
        return false;
    }

    // Return the length of the line
    public double length() {
        return this.start.distance(this.end);
    }

    // Returns the middle point of the line
    public Point middle() {
        return new Point((this.getX1() + this.getX2())/ 2, (this.getY1() + this.getY2())/2);
    }
    public void DrawLine(DrawSurface d) {
        d.drawLine((int)this.start.getX(), (int)this.start.getY(), (int)this.end.getX(), (int)this.end.getY());
    }

    public boolean checkIfPointOnLine(Point p) {
        return  this.getP1().distance(p) + this.getP2().distance(p) == this.getP1().distance(this.getP2());
    }
}
