package GameClasses;

import GeometricShapes.Point;
import Interface.Collidable;

/**
 * Created by Guy on 14/09/2016.
 */
public class CollisionInfo {
    private Collidable collidable;
    private Point collisionPoint;

    public CollisionInfo(Collidable collidable, Point collisionPoint) {
        this.collidable = collidable;
        this.collisionPoint = collisionPoint;
    }

    // the point at which the collision occurs.
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    // the collidable object involved in the collision.
    public Collidable collisionObject() {
        return this.collidable;
    }
}