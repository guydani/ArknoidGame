package GameClasses;

import SpriteObjects.Block;
import GeometricShapes.Line;
import GeometricShapes.Point;
import Interface.Collidable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guy on 14/09/2016.
 */
public class GameEnvironment {
    List <Collidable> collidableList;

    public GameEnvironment() {
        this.collidableList = new ArrayList<Collidable>();
    }

    // add the given collidable to the environment.
    public void addCollidable(Collidable c) {
        this.collidableList.add(c);
    }

    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<CollisionInfo> collisionInfoList = new ArrayList<>();
            for(Collidable c: this.collidableList) {
            if(trajectory.isIntersecting(c.getCollisionRectangle().getUp())) {
                Point p = trajectory.intersectionWith(c.getCollisionRectangle().getUp());
                if(p != null) {
                    collisionInfoList.add(new CollisionInfo(c, p));
                }
            }
            if(trajectory.isIntersecting(c.getCollisionRectangle().getDown())) {
                Point p = trajectory.intersectionWith(c.getCollisionRectangle().getDown());
                if(p != null) {
                    collisionInfoList.add(new CollisionInfo(c, p));
                }
            }
            if(trajectory.isIntersecting(c.getCollisionRectangle().getLeft())) {
                Point p = trajectory.intersectionWith(c.getCollisionRectangle().getLeft());
                if(p != null) {
                    collisionInfoList.add(new CollisionInfo(c, p));
                }
            }
            if(trajectory.isIntersecting(c.getCollisionRectangle().getRight())) {
                Point p = trajectory.intersectionWith(c.getCollisionRectangle().getRight());
                if(p != null) {
                    collisionInfoList.add(new CollisionInfo(c, p));
                }
            }
        }
        if(collisionInfoList.isEmpty())
            return null;
        else {
            CollisionInfo collisionInfo = collisionInfoList.get(0);
            Point ballCenter = trajectory.getP1();
            double distance = ballCenter.distance(collisionInfoList.get(0).collisionPoint());
            double d;
            for(CollisionInfo c: collisionInfoList) {
                d = ballCenter.distance(c.collisionPoint());
                if(d < distance) {
                    distance = d;
                    collisionInfo = c;
                }
            }
            if(collisionInfo.collisionObject() instanceof Block) {
                ((Block) collisionInfo.collisionObject()).addHit();
            }
            return collisionInfo;
        }
    }

    public void removeColidable(Collidable collidable) {
        this.collidableList.remove(collidable);
    }

}