package com.example.mbs_project.models;

import org.junit.Assert;
import org.junit.Test;

public class ColorTest {

    @Test
    public void getFloatArrayInRightOrder() {
        Color color = new Color(10,20,30);
        float[] res_color =  {0.0392f, 0.078f, 0.11f,1};
        Assert.assertArrayEquals(color.getFloatArray(), res_color, 0.01f);
    }

    @Test
    public void errorOnInstanzeNegativeValues() {
        Assert.assertThrows(IllegalArgumentException.class,() -> new Color(-10,20,30));
        Assert.assertThrows(IllegalArgumentException.class,() -> new Color(10,-20,30));
        Assert.assertThrows(IllegalArgumentException.class,() -> new Color(10,20,-30));
    }

    @Test
    public void errorOnInstanzeHighValues() {
        Assert.assertThrows(IllegalArgumentException.class,() -> new Color(256,20,30));
        Assert.assertThrows(IllegalArgumentException.class,() -> new Color(10,256,30));
        Assert.assertThrows(IllegalArgumentException.class,() -> new Color(10,20,256));
    }
}