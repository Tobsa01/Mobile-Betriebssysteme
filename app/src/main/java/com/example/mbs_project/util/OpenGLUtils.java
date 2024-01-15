package com.example.mbs_project.util;

import android.opengl.GLES20;
import android.util.Log;

import com.example.mbs_project.models.StaticObject;
import com.example.mbs_project.models.Vector3;

import java.util.List;
import java.util.stream.Collectors;

public class OpenGLUtils {
    public static int loadShader(int type, String shaderCode) {

        // create a vertex shader type (GLES20.GL_VERTEX_SHADER)
        // or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
        int shader = GLES20.glCreateShader(type);

        // add the source code to the shader and compile it
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);

        return shader;
    }

    public static void checkGlError(String glOperation) {
        int error;
        while ((error = GLES20.glGetError()) != GLES20.GL_NO_ERROR) {
            Log.e("OpenGLUtils", glOperation + ": glError " + error);
            throw new RuntimeException(glOperation + ": glError " + error);
        }
    }

    public static Vector3 transfromX(Vector3 v, float x) {
        v.setX(v.getX() + x);
        return v;
    }

    public static Vector3 transfromY(Vector3 v, float y) {
        v.setY(v.getY() + y);
        return v;
    }

    public static Vector3 transfromZ(Vector3 v, float z) {
        v.setZ(v.getZ() + z);
        return v;
    }

    public static List<Vector3> transformVectors(List<Vector3> modifyList, float x, float y, float z) {
        return modifyList.stream().map(v -> {
            Vector3 clone = v;
            transfromX(v, x);
            transfromY(v, y);
            transfromZ(v, z);
            return v;
        }).collect(Collectors.toList());
    }

    public static float[] createFloatArray(List<Vector3> vecList) {
        float[] res = new float[vecList.size() * 3];
        int count = 0;
        for(Vector3 v : vecList) {
            res[count * 3] = v.getX();
            res[count * 3 + 1] = v.getY();
            res[count * 3 + 2] = v.getZ();
            count++;
        };
        return res;
    }

    public static <T extends StaticObject> float[] createFloatArrayFromStaticObjects(List<T> staticObjects) {
        List<Vector3> vecList = staticObjects.stream().map(el -> el.getVectorList()).flatMap(List::stream).collect(Collectors.toList());
        return createFloatArray(vecList);
    }
}
