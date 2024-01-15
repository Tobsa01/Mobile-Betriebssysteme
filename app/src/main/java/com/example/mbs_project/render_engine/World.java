package com.example.mbs_project.render_engine;

import android.provider.Settings;
import android.util.Log;

import com.example.mbs_project.controller.Goal;
import com.example.mbs_project.controller.Player;
import com.example.mbs_project.controller.StaticWorldGenerator;
import com.example.mbs_project.models.Collider;
import com.example.mbs_project.models.Color;
import com.example.mbs_project.models.Vector2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class World {
    Player player;
    Goal goal;
    GL_Drawer playerDrawer;
    GL_Drawer staticWorldDrawer;
    GL_Drawer staticGoalDrawer;
    static World instance;
    static Vector2 fixedCamera = new Vector2(0,0);

    /**
     * creates a world
     */
    private World() {
        try {
            player = Player.createInstance(new Vector2(0, 0), 1, 1);
            player.setColliders(StaticWorldGenerator.getMap());

            playerDrawer = new GL_Drawer(player, new Color(102,51,0), -5);
            staticWorldDrawer = new GL_Drawer(StaticWorldGenerator.getMap(), new Color(0,125,125), -5);
            staticGoalDrawer = new GL_Drawer(goal, new Color(0,0,255), -5);


        } catch(Exception e) {
            Log.d("error", e.getMessage());
        }
    }

    public static World createWorld() throws InstantiationException {
        if (instance != null) throw new InstantiationException("Es existiert bereits eine World Instance bitte diese Löschen");
        instance = new World();
        return instance;
    }

    public static void resetWorld() {
        if (instance != null) throw new NullPointerException("Es existiert keine World instance");

    }

    public void draw(float[] mvpMatrix, Vector2 force) {
        Vector2 movement = player.transformPosition(force);
        playerDrawer.draw(mvpMatrix, fixedCamera);
        staticWorldDrawer.draw(mvpMatrix, movement);
    }
}
