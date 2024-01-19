package ru.webwitcher.uni.lab3.furniture;

import ru.webwitcher.uni.lab3.human.Human;
import ru.webwitcher.uni.lab3.scene.Location;

public class Mirror extends Furniture {
    private boolean covered = false;

    public Mirror(Location location) {
        super(location);
    }

    public boolean isCovered() {
        return covered;
    }

    public void cover(Human user) {
        this.covered = true;
    }

    public void uncover(Human user) {
        this.covered = false;
    }

    public boolean lookIn(Human user) {
        return !covered;
    }
}
