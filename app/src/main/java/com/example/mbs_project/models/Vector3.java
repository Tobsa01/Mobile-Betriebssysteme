package com.example.mbs_project.models;

public class Vector3 {
    private float x;
    private float y;
    private float z;

    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3(Vector2 vec2, float z) {
        this.x = vec2.getX();
        this.y = vec2.getY();
        this.z = z;
    }
    public float getY() {
        return this.y;
    }
    public float getX() {
        return this.x;
    }
    public float getZ() {
        return this.z;
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void setZ(float z) {
        this.z = z;
    }

    public float[] generateArray() {
        float[] res = { x, y, z};
        return res;
    }
}
