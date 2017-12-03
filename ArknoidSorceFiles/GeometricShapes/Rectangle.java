package GeometricShapes;

import biuoop.DrawSurface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Guy on 13/09/2016.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    private Color color;

    public Rectangle(Point upperLeft, double width, double height, Color color) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public Line getUp() {
        return new Line(this.getUpperLeft(), new Point(this.getUpperLeft().getX() + this.width, this.getUpperLeft().getY()));
    }

    public Line getDown() {
        return new Line(new Point(this.getUpperLeft().getX(), this.getUpperLeft().getY() + this.height),
                new Point(this.getUpperLeft().getX() + width, this.getUpperLeft().getY() + this.height));
    }

    public Line getLeft() {
        return new Line(this.getUpperLeft(),
                new Point(this.getUpperLeft().getX(), this.getUpperLeft().getY() + this.height));
    }

    public Line getRight() {
        return new Line(new Point(this.getUpperLeft().getX() + this.width, this.getUpperLeft().getY()),
                new Point(this.getUpperLeft().getX() + width, this.getUpperLeft().getY() + this.height));
    }

    public Point getUpperLeft() {
        return upperLeft;
    }

    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawRectangle((int) this.getUpperLeft().getX(), (int) this.getUpperLeft().getY(),
                (int) this.getWidth(), (int) this.getHeight());
        d.setColor(this.color);
        d.fillRectangle((int)this.getUpperLeft().getX(),(int)this.getUpperLeft().getY(),
                (int)this.getWidth(),(int)this.getHeight());
    }
}
