package com.example.mbs_project.models;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class RectangleTest {

    @Test
    public void getVectorListInRightOrder2Vector2() {
        Rectangle rec = new Rectangle(new Vector2(-1,-1), new Vector2(1,1));
        List<Vector3> list = rec.getVectorList();
        list.forEach(vec -> Assert.assertEquals(0, vec.getZ(), 0.0));
        // point 1
        Assert.assertEquals(1.0, list.get(0).getX(), 0.0);
        Assert.assertEquals(-1.0, list.get(0).getY(), 0.0);

        // point 2
        Assert.assertEquals(-1.0, list.get(1).getX(), 0.0);
        Assert.assertEquals(-1.0, list.get(1).getY(), 0.0);


        // point 3
        Assert.assertEquals(-1.0, list.get(2).getX(), 0.0);
        Assert.assertEquals(1.0, list.get(2).getY(), 0.0);

        // point 4
        Assert.assertEquals(1.0, list.get(3).getX(), 0.0);
        Assert.assertEquals(-1.0, list.get(3).getY(), 0.0);

        // point 5
        Assert.assertEquals(-1.0, list.get(4).getX(), 0.0);
        Assert.assertEquals(1.0, list.get(4).getY(), 0.0);

        // point 6
        Assert.assertEquals(1.0, list.get(5).getX(), 0.0);
        Assert.assertEquals(1.0, list.get(5).getY(), 0.0);
    }

    @Test
    public void getVectorListInRightOrder4Vector2() {
        Rectangle rec = new Rectangle(new Vector2(1,-1), new Vector2(-1,-1), new Vector2(-1,1), new Vector2(1,1));
        List<Vector3> list = rec.getVectorList();
        list.forEach(vec -> Assert.assertEquals(0, vec.getZ(), 0.0));
        // point 1
        Assert.assertEquals(1.0, list.get(0).getX(), 0.0);
        Assert.assertEquals(-1.0, list.get(0).getY(), 0.0);

        // point 2
        Assert.assertEquals(-1.0, list.get(1).getX(), 0.0);
        Assert.assertEquals(-1.0, list.get(1).getY(), 0.0);


        // point 3
        Assert.assertEquals(-1.0, list.get(2).getX(), 0.0);
        Assert.assertEquals(1.0, list.get(2).getY(), 0.0);

        // point 4
        Assert.assertEquals(1.0, list.get(3).getX(), 0.0);
        Assert.assertEquals(-1.0, list.get(3).getY(), 0.0);

        // point 5
        Assert.assertEquals(-1.0, list.get(4).getX(), 0.0);
        Assert.assertEquals(1.0, list.get(4).getY(), 0.0);

        // point 6
        Assert.assertEquals(1.0, list.get(5).getX(), 0.0);
        Assert.assertEquals(1.0, list.get(5).getY(), 0.0);
    }

    @Test
    public void getVectorListInRightOrder4Vector3() {
        Rectangle rec = new Rectangle(new Vector3(1,-1,1), new Vector3(-1,-1,1), new Vector3(-1,1,1), new Vector3(1,1,1));
        List<Vector3> list = rec.getVectorList();
        list.forEach(vec -> Assert.assertEquals(1, vec.getZ(), 0.0));

        // point 1
        Assert.assertEquals(1.0, list.get(0).getX(), 0.0);
        Assert.assertEquals(-1.0, list.get(0).getY(), 0.0);

        // point 2
        Assert.assertEquals(-1.0, list.get(1).getX(), 0.0);
        Assert.assertEquals(-1.0, list.get(1).getY(), 0.0);


        // point 3
        Assert.assertEquals(-1.0, list.get(2).getX(), 0.0);
        Assert.assertEquals(1.0, list.get(2).getY(), 0.0);

        // point 4
        Assert.assertEquals(1.0, list.get(3).getX(), 0.0);
        Assert.assertEquals(-1.0, list.get(3).getY(), 0.0);

        // point 5
        Assert.assertEquals(-1.0, list.get(4).getX(), 0.0);
        Assert.assertEquals(1.0, list.get(4).getY(), 0.0);

        // point 6
        Assert.assertEquals(1.0, list.get(5).getX(), 0.0);
        Assert.assertEquals(1.0, list.get(5).getY(), 0.0);
    }

    @Test
    public void getBottomY() {
        Rectangle rec = new Rectangle(new Vector2(-1,-1), new Vector2(1,1));
        Assert.assertEquals(-1, rec.getBottomY(), 0.0);
    }

    @Test
    public void getTopY() {
        Rectangle rec = new Rectangle(new Vector2(-1,-1), new Vector2(1,1));
        Assert.assertEquals(1, rec.getTopY(), 0.0);
    }

    @Test
    public void getLeftX() {
        Rectangle rec = new Rectangle(new Vector2(-1,-1), new Vector2(1,1));
        Assert.assertEquals(-1, rec.getLeftX(), 0.0);
    }

    @Test
    public void getRightX() {
        Rectangle rec = new Rectangle(new Vector2(-1,-1), new Vector2(1,1));
        Assert.assertEquals(1, rec.getRightX(), 0.0);
    }
}