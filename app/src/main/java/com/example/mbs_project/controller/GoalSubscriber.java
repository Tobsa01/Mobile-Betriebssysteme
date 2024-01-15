package com.example.mbs_project.controller;

import com.example.mbs_project.models.Collider;

public interface GoalSubscriber {
    public void onGoalReached(Goal goal, Collider col);
}
