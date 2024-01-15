package com.example.mbs_project.controller;

public interface InputSubscriber {
    /**
     * vorhanden Arten der Eingabe
     */
    public enum INPUT_EVENTS { LEFT, RIGHT, JUMP, RIGHT_LEFT_STOP, JUMP_STOP };

    /**
     * subscriber methode
     * @param input - übergibt die Eingabe
     */
    public void onInputEvent(INPUT_EVENTS input);
}
