package com.example.mbs_project.models;

public class Vector2 {
    private float x;
    private float y;

    /**
     * representiert einen Vector 2
     * @param x - breiten wert
     * @param y - höhen wert
     */
    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return member y
     */
    public float getY() {
        return this.y;
    }

    /**
     * @return memeber x
     */
    public float getX() {
        return this.x;
    }

    /**
     * setzt member x
     * @param x - der wert auf den x gesetzt werden soll
     */
    public void setX(float x) {
        this.x = x;
    }
    /**
     * setzt member y
     * @param y - der wert auf den x gesetzt werden soll
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * geordnetes array x, y
     * @return - { x, y }
     */
    public float[] generateArray() {
        float[] res = { x, y };
        return res;
    }
}
