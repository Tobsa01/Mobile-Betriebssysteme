package com.example.mbs_project.models;

public interface Collider {
    /**
     * --
     *
     * @return - position des unteren randes der Hitbox
     */
    public float getBottomY();
    public float getTopY();
    public float getLeftX();
    public float getRightX();
}
