package com.example.mbs_project.render_engine;

import android.opengl.GLES20;

import com.example.mbs_project.models.Rectangle;
import com.example.mbs_project.util.OpenGLUtils;
import com.example.mbs_project.models.Color;
import com.example.mbs_project.models.StaticObject;
import com.example.mbs_project.models.Vector2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;

public class GL_Drawer {
    private final String fragmentShaderCode =
            "precision mediump float;" +
                    "uniform vec4 vColor;" +
                    "void main() {" +
                    "  gl_FragColor = vColor;" +
                    "}";

    private FloatBuffer vertexBuffer;

    // number of coordinates per vertex in this array
    static final int COORDS_PER_VERTEX = 3;
    static final int vertexStride = COORDS_PER_VERTEX * 4;
    private float color[];
    int renderProgram;
    int vPositionHandle;
    int vColorHandle;
    int mvpHandle;
    int vMoveHandle;
    private int vertexCount;
    private float[] staticObjectsAsFloatArray;
    private ByteBuffer bb;
    private float layer;
    private GL_Drawer(Color color, float layer, float[] staticObjectsAsFloatArray) {
        this.color = color.getFloatArray();
        this.layer = layer;

        // initialising opengl world
        vertexCount = staticObjectsAsFloatArray.length;
        bb = ByteBuffer.allocateDirect(vertexCount * 4);
        bb.order(ByteOrder.nativeOrder());
        vertexBuffer = bb.asFloatBuffer();
        // add the coordinates to the FloatBuffer
        vertexBuffer.put(staticObjectsAsFloatArray);
        // set the buffer to read the first coordinate
        vertexBuffer.position(0);

        int vertexShader = OpenGLUtils.loadShader(GLES20.GL_VERTEX_SHADER, createVertexCode());
        int fragmentShader = OpenGLUtils.loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);

        // initialise rendering
        renderProgram = GLES20.glCreateProgram();             // create empty OpenGL ES Program
        GLES20.glAttachShader(renderProgram, vertexShader);   // add the vertex shader to program
        GLES20.glAttachShader(renderProgram, fragmentShader); // add the fragment shader to program
        GLES20.glLinkProgram(renderProgram);
    }
    public GL_Drawer(StaticObject staticObject, Color color, float layer) {
        this(color, layer, OpenGLUtils.createFloatArray(staticObject.getVectorList()));
    }
    public <T extends StaticObject> GL_Drawer(List<T> staticObjects, Color color, float layer) {
        this(color, layer, OpenGLUtils.createFloatArrayFromStaticObjects(staticObjects));
    }

    public void draw(float[] mvpMatrix, Vector2 cameraPosition) {
        // start buffer from 0
        vertexBuffer.position(0);
        // switch gl programm
        GLES20.glUseProgram(renderProgram);

        // get handle to vertex shader vMove member
        vMoveHandle = GLES20.glGetUniformLocation(renderProgram, "vMove");

        // set vMove in storage
        GLES20.glUniform2fv(vMoveHandle, 1, cameraPosition.generateArray(), 0);

        // get handle to vertex shader's vPosition member
        vPositionHandle = GLES20.glGetAttribLocation(renderProgram, "vPosition");
        GLES20.glEnableVertexAttribArray(vPositionHandle);
        GLES20.glVertexAttribPointer(vPositionHandle, COORDS_PER_VERTEX,
                GLES20.GL_FLOAT, false,
                vertexStride, vertexBuffer);



        // Enable a handle to the triangle vertices
        // get handle to fragment shader's vColor member
        vColorHandle = GLES20.glGetUniformLocation(renderProgram, "vColor");

        // Set color for drawing the triangle
        GLES20.glUniform4fv(vColorHandle, 1, color, 0);

        // get handle to shape's transformation matrix
        mvpHandle = GLES20.glGetUniformLocation(renderProgram, "uMVPMatrix");
        OpenGLUtils.checkGlError("glGetUniformLocation");

        // Apply the projection and view transformation
        GLES20.glUniformMatrix4fv(mvpHandle, 1, true, mvpMatrix, 0);
        OpenGLUtils.checkGlError("glUniformMatrix4fv");

        // Draw the triangle
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertexCount / 3);
        GLES20.glDisableVertexAttribArray(vPositionHandle);
    }

    private String createVertexCode() {
        return
                // This matrix member variable provides a hook to manipulate
                // the coordinates of the objects that use this vertex shader
                "uniform mat4 uMVPMatrix;" +
                        "attribute vec4 vPosition;" +
                        "uniform vec2 vMove;" +
                        "void main() {" +
                        // the matrix must be included as a modifier of gl_Position
                        "  gl_Position = uMVPMatrix * (vPosition + vec4( vMove.x, vMove.y, " + Float.toString(this.layer) + " , 0.0));" +
                        "}";
    }
}
