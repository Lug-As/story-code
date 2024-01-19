package ru.webwitcher.uni.lab3.thing;

public abstract class Thing {
    private final Color color;

    public Thing(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
