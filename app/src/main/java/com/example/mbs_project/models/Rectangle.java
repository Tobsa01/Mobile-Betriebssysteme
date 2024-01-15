package com.example.mbs_project.models;

import com.example.mbs_project.models.StaticObject;
import com.example.mbs_project.models.Vector3;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Collider, StaticObject {
    // bottom right
    private Vector3 point1;
    // bottom left
    private Vector3 point2;
    // top left
    private Vector3 point3;
    // top right
    private Vector3 point4;
    // safes all the vectors
    private List<Vector3> list = new ArrayList<Vector3>();

    /**
     *  create a rectangle
     * @param point1 - bottom right point
     * @param point2 - bottom left point
     * @param point3 - top left point
     * @param point4 - top right point
     */
    public Rectangle(Vector3 point1, Vector3 point2, Vector3 point3, Vector3 point4) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;

        this.createList();
    }

    /**
     *  create a rectangle
     * @param point1 - bottom right point
     * @param point2 - bottom left point
     * @param point3 - top left point
     * @param point4 - top right point
     */
    public Rectangle(Vector2 point1, Vector2 point2, Vector2 point3, Vector2 point4) {
        this.point1 = new Vector3(point1, 0f);
        this.point2 = new Vector3(point2, 0f);
        this.point3 = new Vector3(point3, 0f);
        this.point4 = new Vector3(point4, 0f);

        this.createList();
    }
    /**
     *  create a rectangle
     * @param leftBottom - left bottom point
     * @param rightTop - rightTop point
     */
    public Rectangle(Vector2 leftBottom, Vector2 rightTop) {
        this.point2 = new Vector3(new Vector2(leftBottom.getX(), leftBottom.getY()), 0f);
        this.point1 = new Vector3(new Vector2(rightTop.getX(), leftBottom.getY()), 0f);
        this.point3 = new Vector3(new Vector2(leftBottom.getX(), rightTop.getY()), 0f);
        this.point4 = new Vector3(new Vector2(rightTop.getX(), rightTop.getY()), 0f);

        this.createList();
    }

    private void createList() {
        list.add(this.point1);
        list.add(this.point2);
        list.add(this.point3);

        list.add(this.point1);
        list.add(this.point3);
        list.add(this.point4);
    }

    @Override
    public List<Vector3> getVectorList() {
        return list;
    };

    @Override
    public float getBottomY() {
        return this.point1.getY();
    }

    @Override
    public float getTopY() {
        return this.point4.getY();
    }

    @Override
    public float getLeftX() {
        return this.point2.getX();
    }

    @Override
    public float getRightX() {
        return this.point4.getX();
    }
}
