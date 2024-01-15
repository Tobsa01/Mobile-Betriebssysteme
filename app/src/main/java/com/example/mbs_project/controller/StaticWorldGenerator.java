package com.example.mbs_project.controller;

import com.example.mbs_project.models.Collider;
import com.example.mbs_project.models.Rectangle;
import com.example.mbs_project.models.StaticObject;
import com.example.mbs_project.models.Vector2;

import java.util.ArrayList;
import java.util.List;

public class StaticWorldGenerator {
    public static List<Rectangle> getMap() {
        List<Rectangle> list = new ArrayList<Rectangle>();
        createForTest(list);
        return list;
    };

    private static void createForTest(List<Rectangle> list) {
        list.add(new Rectangle(new Vector2(-3,0 -0.5f), new Vector2(-2, 1 -0.5f)));
        list.add(new Rectangle(new Vector2(2,0-0.5f), new Vector2(10, 1-0.5f)));
        list.add(new Rectangle(new Vector2(-10,-2.5f), new Vector2(9, -1.5f)));
    }


}
