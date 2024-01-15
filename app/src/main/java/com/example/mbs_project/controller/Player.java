package com.example.mbs_project.controller;

import com.example.mbs_project.models.Collider;
import com.example.mbs_project.models.Rectangle;
import com.example.mbs_project.models.StaticObject;
import com.example.mbs_project.models.Vector2;
import com.example.mbs_project.models.Vector3;

import java.util.ArrayList;
import java.util.List;

public class Player extends Physics implements StaticObject {
    private static Player instance;
    private float width;
    private float height;
    private Vector2 position;
    private Player(Vector2 startPosition, float height, float width) {
        // privatising instance prevent initialising false way
        // singletonPattern
        this.position = new Vector2(0,0);
        this.height = height;
        this.width = width;
    }

    public static Player getInstance() {
        if (instance == null) throw new NullPointerException("Es existiert keine Player instance");
        return instance;
    }

    public static Player createInstance(Vector2 startPosition, float height, float width) throws InstantiationException {
        if (instance != null) throw new InstantiationException("Es existiert bereits eine Player Instance bitte diese Löschen");
        instance = new Player(startPosition, height, width);
        return instance;
    }
    public static void deleteInstance() {
        instance = null;
    }

    public Vector2 transformPosition(Vector2 force) {
        Vector2 checkedForce = this.checkCollision(force);
        this.position.setX(checkedForce.getX() + position.getX());
        this.position.setY(checkedForce.getY() + position.getY());
        return this.position;
    };

    public Vector2 getPosition() {
        return this.position;
    }

    @Override
    public float getBottomY() { return position.getY() - height / 2; }
    @Override
    public float getTopY() { return position.getY() + height / 2; }
    @Override
    public float getLeftX() {
        return position.getX() - width / 2;
    }

    @Override
    public float getRightX() {
        return position.getX() + width / 2;
    }
    @Override
    public void collisionDetected(Collider object) {
        if (object.getTopY() > this.getBottomY()) {
            this.position.setY(object.getTopY() + this.getBottomY());
        } else if (object.getBottomY() < this.getTopY()) {
            this.position.setY(object.getTopY() + this.getTopY());
        } else if (object.getRightX() > this.getLeftX()) {
            this.position.setX(object.getRightX() + this.getLeftX());
        } else if (object.getLeftX() < this.getRightX()) {
            this.position.setX(object.getLeftX() + this.getRightX());
        }
    }


    @Override
    public List<Vector3> getVectorList() {
        Vector2 bottomLeft = new Vector2(this.getLeftX(), this.getBottomY());
        Vector2 topRight = new Vector2(this.getTopY(), this.getRightX());
        Rectangle rec = new Rectangle(bottomLeft, topRight);
        return rec.getVectorList();
    }
}
