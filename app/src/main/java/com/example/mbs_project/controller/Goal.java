package com.example.mbs_project.controller;

import android.util.Log;

import com.example.mbs_project.models.Collider;
import com.example.mbs_project.models.Rectangle;
import com.example.mbs_project.models.StaticObject;
import com.example.mbs_project.models.Vector2;
import com.example.mbs_project.models.Vector3;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.ArrayDeque;

public class Goal extends Physics implements StaticObject {

    private List<GoalSubscriber> subscribers = new ArrayList<GoalSubscriber>();
    private List<Object> additionalData;
    private float width;
    private float height;
    private Vector2 position;
    public Goal(Vector2 startPosition, float height, float width, List<Object> additionalData) {
        this.position = startPosition;
        this.height = height;
        this.width = width;
        this.additionalData = additionalData;
    }

    public List<Object> getData() {
        return additionalData;
    }
    public void subscribeToGoalReach(GoalSubscriber subscriber) {
        if(subscribers.contains(subscriber) || subscriber == null) return;
        subscribers.add(subscriber);
    }


    public void unbscribeToGoalReach(GoalSubscriber subscriber) {
        if(!subscribers.contains(subscriber)) return;
        subscribers.remove(subscriber);
    }
    private void notifySubscribers(Collider collider) {
        subscribers.forEach(subscriber -> subscriber.onGoalReached(this, collider));
    }
    @Override
    public void collisionDetected(Collider rec) {
        this.notifySubscribers(rec);
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
    public float getRightX() { return position.getX() + width / 2; }

    @Override
    public List<Vector3> getVectorList() {
        Vector2 bottomLeft = new Vector2(this.getLeftX(), this.getBottomY());
        Vector2 topRight = new Vector2(this.getTopY(), this.getRightX());
        Rectangle rec = new Rectangle(bottomLeft, topRight);
        return rec.getVectorList();
    }
}
