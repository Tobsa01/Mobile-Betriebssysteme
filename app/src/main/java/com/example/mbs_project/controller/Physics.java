package com.example.mbs_project.controller;

import android.util.Log;

import com.example.mbs_project.models.Collider;
import com.example.mbs_project.models.Rectangle;
import com.example.mbs_project.models.Vector2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Physics <T extends Collider> implements Collider {
    private List<T> colliders = new ArrayList<T>();
    public void setColliders(List<T> colliders) {
        this.colliders = colliders;
    }

    public void addCollider(T col) {
        this.colliders.add(col);
    }
    private void onCollision(Collider rec) {
        this.collisionDetected(rec);
    }
    public abstract void collisionDetected(Collider rec);
    public Vector2 checkNextCollisions(Collider object, Vector2 force) {
        if (force.getX() > 0f && rightColliding(object) && (topColliding(object) || bottomColliding(object))) {
            force.setX(object.getLeftX() - this.getRightX());
        } else if (force.getX() < 0f && leftColliding(object) && (topColliding(object) || bottomColliding(object))) {
            force.setX(object.getRightX() - this.getLeftX());
        }
        /**
        if (force.getY() > 0f && topColliding(object)) {
            force.setY(0);
        } else if (force.getY() < 0f && bottomColliding(object)) {
            force.setY(0);
        }
         */
        return force;
    };

    /**
     * checks collsisions
     */
    public Vector2 checkCollision(Vector2 force) {
        colliders.parallelStream().forEach(collider -> checkNextCollisions(collider, force));
        return force;
    };

    private boolean rightColliding(Collider object) {
        return this.getRightX() <= object.getRightX() && this.getRightX() >= object.getLeftX();
    }


    private boolean leftColliding(Collider object) {
        return this.getLeftX() <= object.getRightX() && this.getLeftX() >= object.getLeftX();
    }


    private boolean topColliding(Collider object) {
        boolean res = this.getTopY() >= object.getBottomY() && this.getTopY() <= object.getTopY();
        return this.getTopY() >= object.getBottomY() && this.getTopY() <= object.getTopY();
    }


    private boolean bottomColliding(Collider object) {
        boolean res = this.getBottomY() >= object.getBottomY() && this.getBottomY() <= object.getTopY();
        return res;
    }
}
