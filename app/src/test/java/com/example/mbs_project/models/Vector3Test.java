package com.example.mbs_project.models;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Vector3Test {
    @Test
    public void getXTest() {
        Vector3 vec = new Vector3(1, 0, 0);
        Assert.assertEquals(1, vec.getX(), 0.0);
        vec.setX(-1);
        Assert.assertEquals(-1, vec.getX(), 0.0);
        vec = new Vector3(new Vector2(1,0), 0);
        Assert.assertEquals(1, vec.getX(), 0.0);
        vec.setX(-1);
        Assert.assertEquals(-1, vec.getX(), 0.0);
    }
    @Test
    public void getYTest() {
        Vector3 vec = new Vector3(0, 1, 0);
        Assert.assertEquals(1, vec.getY(), 0.0);
        vec.setY(-1);
        Assert.assertEquals(-1, vec.getY(), 0.0);
        vec = new Vector3(new Vector2(0,1), 0);
        Assert.assertEquals(1, vec.getY(), 0.0);
        vec.setY(-1);
        Assert.assertEquals(-1, vec.getY(), 0.0);
    }


    @Test
    public void getZTest() {
        Vector3 vec = new Vector3(0, 0, 1);
        Assert.assertEquals(1, vec.getZ(), 0.0);
        vec.setZ(-1);
        Assert.assertEquals(-1, vec.getZ(), 0.0);
        vec = new Vector3(new Vector2(0,0), 1);
        Assert.assertEquals(1, vec.getZ(), 0.0);
        vec.setZ(-1);
        Assert.assertEquals(-1, vec.getZ(), 0.0);
    }
    @Test
    public void generateArrayTest() {
        Vector3 vec = new Vector3(1, 2, 3);
        float[] array = vec.generateArray();
        Assert.assertEquals(1, array[0],0.0);
        Assert.assertEquals(2, array[1],0.0);
        Assert.assertEquals(3, array[2],0.0);
        vec.setX(-2);
        vec.setY(-1);
        vec.setZ(-5);
        array = vec.generateArray();
        Assert.assertEquals(-2, array[0],0.0);
        Assert.assertEquals(-1, array[1],0.0);
        Assert.assertEquals(-5, array[2],0.0);
    }
}