package com.example.mbs_project.render_engine;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.SystemClock;
import android.util.Log;

import com.example.mbs_project.controller.InputController;
import com.example.mbs_project.controller.InputSubscriber;
import com.example.mbs_project.models.Vector2;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GL_Renderer implements GLSurfaceView.Renderer {
    float ratio;
    private final float[] mMVPMatrix = new float[16];
    private final float[] mVMatrix = new float[16];
    private final float[] projectionMatrix = new float[16];
    private World world;
    public void onSurfaceCreated(GL10 unused, EGLConfig config) {
        // Set the background frame color
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        lastFrame = SystemClock.elapsedRealtime();
        try {
            world = World.createWorld();
        } catch(Exception e) {
            Log.d("error", e.getMessage());
        }

    }

    static long currentTime;
    static long lastFrame;
    // input verarbeitungsobjekt
    Vector2 input =  new Vector2(0,0);

    public void onSurfaceChanged(GL10 unused, int width, int height) {
        // anpassungen an die form der view
        GLES20.glViewport(0, 0, width, height);
        ratio = (float) height / width;
        Matrix.frustumM(projectionMatrix, 0, -ratio, ratio, -1, 1, 3, 7);
        Matrix.setLookAtM(mVMatrix, 0, 0, 0, -3, 0f, 0f, 0f, -90f, 0f, 0f);
        Matrix.multiplyMM(mMVPMatrix, 0, projectionMatrix, 0, mVMatrix, 0);

        // ein lambda das auf eingaben reagiert
        InputController.getInstance().subscribeToInput(inputType -> {
            if(inputType == InputSubscriber.INPUT_EVENTS.RIGHT) {
                input.setX(1);
            } else if (inputType == InputSubscriber.INPUT_EVENTS.LEFT) {
                input.setX(-1);
            } else if (inputType == InputSubscriber.INPUT_EVENTS.RIGHT_LEFT_STOP) {
                input.setX(0);
            }
        });
    }

    public void onDrawFrame(GL10 unused) {
        currentTime = SystemClock.elapsedRealtime();
        float deltaTime = ((float) currentTime - (float) lastFrame) / 1000f;


        // Redraw background color
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        // redraw world
        world.draw(mMVPMatrix, new Vector2(input.getX() * deltaTime,input.getY() * deltaTime));
        lastFrame = currentTime;
    }


}
