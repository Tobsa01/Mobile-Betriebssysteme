package com.example.mbs_project.controller;

import java.util.ArrayList;
import java.util.List;

public class InputController implements ControllerInterface {
    List<InputSubscriber> subscribers = new ArrayList<InputSubscriber>();
    private static InputController instance;
    public static InputController getInstance() {
        if(instance == null) {
            instance = new InputController();
        }
        return instance;
    }

    /**
     * subscribe auf veränderungen der Eingaben
     * @param subscriber - subscriber der veränderungen erhalten möchte
     */
    public void subscribeToInput(InputSubscriber subscriber) {
        if(subscribers.contains(subscriber) || subscriber == null) return;
        subscribers.add(subscriber);
    }

    /**
     * unsubscribe subscribe auf veränderungen der Eingaben
     * @param subscriber - subscriber der veränderungen nicht mehr erhalten möchte
     */
    public void unsubscribeToInput(InputSubscriber subscriber) {
        if(!subscribers.contains(subscriber)) return;
        subscribers.remove(subscriber);
    }
    private void notifySubscribers(InputSubscriber.INPUT_EVENTS event) {
        subscribers.forEach(subscriber -> subscriber.onInputEvent(event));
    }
    @Override
    public void onLeftMovement() {
        notifySubscribers(InputSubscriber.INPUT_EVENTS.LEFT);
    }

    @Override
    public void onRightMovement() {
        notifySubscribers(InputSubscriber.INPUT_EVENTS.RIGHT);
    }

    @Override
    public void onStopMovement() {
        notifySubscribers(InputSubscriber.INPUT_EVENTS.RIGHT_LEFT_STOP);
    }

    @Override
    public void onJump() {
        notifySubscribers(InputSubscriber.INPUT_EVENTS.JUMP);
    }

    @Override
    public void onStopJump() {
        notifySubscribers(InputSubscriber.INPUT_EVENTS.JUMP_STOP);
    }
}
