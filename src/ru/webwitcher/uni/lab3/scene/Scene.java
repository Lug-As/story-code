package ru.webwitcher.uni.lab3.scene;

import java.time.LocalDateTime;

public class Scene {
    private final Action action;

    private LocalDateTime dateTime;

    public Scene(Action action) {
        this.action = action;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void play() {
        action.action(this);
    }
}
