package com.example.mbs_project.models;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Vector2Test {
    @Test
    public void getXTest() {
        Vector2 vec = new Vector2(1, 0);
        Assert.assertEquals(1, vec.getX(), 0.0);
        vec.setX(-1);
        Assert.assertEquals(-1, vec.getX(), 0.0);
    }
    @Test
    public void getYTest() {
        Vector2 vec = new Vector2(0, 1);
        Assert.assertEquals(1, vec.getY(), 0.0);
        vec.setY(-1);
        Assert.assertEquals(-1, vec.getY(), 0.0);
    }
    @Test
    public void generateArrayTest() {
        Vector2 vec = new Vector2(1, 2);
        float[] array = vec.generateArray();
        Assert.assertEquals(1, array[0],0.0);
        Assert.assertEquals(2, array[1],0.0);
        vec.setX(-2);
        vec.setY(-1);
        array = vec.generateArray();
        Assert.assertEquals(-2, array[0],0.0);
        Assert.assertEquals(-1, array[1],0.0);
    }
}