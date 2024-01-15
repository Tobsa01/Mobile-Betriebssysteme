package com.example.mbs_project.render_engine;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.MotionEvent;

import com.example.mbs_project.android.InputControllerMobile;

public class GL_SurfaceView extends GLSurfaceView {
    private final GL_Renderer renderer;

    static final long refreshRate = 1 / 60;
    public static boolean moveDetected;

    public GL_SurfaceView(Context context) {
        super(context);

        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);

        renderer = new GL_Renderer();

        // Set the Renderer for drawing on the GLSurfaceView

        setRenderer(renderer);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

        // create thread for rerender
        Runnable r = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                requestRender();
                try {
                    synchronized (this) {
                        Thread.sleep(1000 * refreshRate);
                    }
                } catch (Exception e) {

                }
            }
        };
        Thread t = new Thread(r);
        t.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        InputControllerMobile.getInstance().onMotionEvent(e);
        return true;
    }
}
