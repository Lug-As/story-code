package ru.webwitcher.uni.lab3.furniture;

import ru.webwitcher.uni.lab3.scene.Location;

public abstract class Furniture {
    private final Location location;

    public Furniture(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
