package ru.webwitcher.uni.lab3.furniture;

import ru.webwitcher.uni.lab3.enums.Room;
import ru.webwitcher.uni.lab3.human.Human;

public class Mirror extends Furniture {
    private boolean covered = false;

    public Mirror(Room room) {
        super(room);
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
