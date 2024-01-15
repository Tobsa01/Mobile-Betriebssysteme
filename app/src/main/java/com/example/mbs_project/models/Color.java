package com.example.mbs_project.models;

import android.util.Log;

public class Color {
    private float red;
    private float green;
    private float blue;

    public Color(int red, int green, int blue) {
        if(red < 0 || red > 255) throw new IllegalArgumentException("Der Frabwert rot ist nicht zwischen 0-255: " + Integer.valueOf(red).toString());
        if(green < 0 || green > 255) throw new IllegalArgumentException("Der Frabwert blau ist nicht zwischen 0-255: " + Integer.valueOf(green).toString());
        if(blue < 0 || blue > 255) throw new IllegalArgumentException("Der Frabwert gruen ist nicht zwischen 0-255: " + Integer.valueOf(blue).toString());
        this.red = red == 0 ? 0 : Float.valueOf(red) / 255f;
        this.green = green == 0 ? 0 : Float.valueOf(green) / 255f;
        this.blue = blue == 0 ? 0 : Float.valueOf(blue) / 255f;
    }

    public float[] getFloatArray() {
        float[] res = { red, green, blue, 1.0f };
        return res;
    }
}
