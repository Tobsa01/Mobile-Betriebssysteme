package com.example.mbs_project.android;

import android.view.MotionEvent;

import com.example.mbs_project.controller.InputController;

public class InputControllerMobile {
    private Integer activePointerIndex;
    private Float activePointerIndex_lastY;
    private static InputControllerMobile instance;
    private InputControllerMobile() {};
    public void onMotionEvent(MotionEvent e) {
        if(activePointerIndex != null && e.getActionIndex() != activePointerIndex) return;
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                this.activePointerIndex = e.getActionIndex();
                this.activePointerIndex_lastY = e.getY(activePointerIndex);
                break;
            case MotionEvent.ACTION_MOVE:
                if (e.getY(activePointerIndex) > this.activePointerIndex_lastY) InputController.getInstance().onLeftMovement();
                if (e.getY(activePointerIndex) < this.activePointerIndex_lastY) InputController.getInstance().onRightMovement();
                break;
            case MotionEvent.ACTION_UP:
                this.activePointerIndex = null;
                this.activePointerIndex_lastY = null;
                InputController.getInstance().onStopMovement();
                break;
            default:
                break;
        }
    }

    public static InputControllerMobile getInstance() {
        if(instance == null) {
            instance = new InputControllerMobile();
        }
        return instance;
    }
}
