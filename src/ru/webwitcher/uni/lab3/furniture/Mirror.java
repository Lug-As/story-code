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

    public void setCovered(Human user, boolean covered) {
        checkLocation(user);
        this.covered = covered;
    }

    public void cover(Human user) {
        setCovered(user, true);
    }

    public void uncover(Human user) {
        setCovered(user, false);
    }

    public boolean lookIn(Human user) {
        checkLocation(user);
        return !covered;
    }
}
