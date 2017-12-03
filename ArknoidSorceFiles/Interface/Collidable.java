package Interface;

import GeometricShapes.Point;
import GeometricShapes.Rectangle;
import GeometricShapes.Velocity;
import SpriteObjects.Ball;

/**
 * Created by Guy on 13/09/2016.
 */
public interface Collidable {
    // Return the "collision shape" of the object.
    Rectangle getCollisionRectangle();

    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}