package com.example.mbs_project.android;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import com.example.mbs_project.render_engine.GL_SurfaceView;

public class NextActivity extends Activity {
    private GLSurfaceView gLView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create a GLSurfaceView instance and set it
        // as the ContentView for this Activity.
        gLView = new GL_SurfaceView(this);
        setContentView(gLView);
    }
}
