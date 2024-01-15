package com.example.mbs_project.controller;

public interface ControllerInterface {
    /**
     * infromiert alle subscriber das die Eingabe nach links von Nutzer benutzt wird wurde
     */
    public void onLeftMovement();
    /**
     * infromiert alle subscriber das die Eingabe nach rechts von Nutzer benutzt wird wurde
     */
    public void onRightMovement();
    /**
     * infromiert alle subscriber das der Nutzer die Eingabe für Links und Rechts beendet wurde
     */
    public void onStopMovement();
    /**
     * infromiert alle subscriber das die Eingabe springen von Nutzer benutzt wird wurde
     */
    public void onJump();
    /**
     * infromiert alle subscriber das der Nutzer die Eingabe springen beendet wurde
     */
    public void onStopJump();
}
