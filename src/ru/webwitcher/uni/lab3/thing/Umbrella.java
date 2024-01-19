package ru.webwitcher.uni.lab3.thing;

public class Umbrella extends Thing implements CanProtectFromRain {
    private boolean isOpen = false;

    public Umbrella(Color color) {
        super(color);
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void open() {
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }
}
