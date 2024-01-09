package ru.webwitcher.uni.lab3.furniture.service;

import ru.webwitcher.uni.lab3.furniture.Mirror;
import ru.webwitcher.uni.lab3.human.Human;

public class MirrorService extends FurnitureService<Mirror> {
    public MirrorService(Mirror furniture) {
        super(furniture);
    }

    public void coverMirror(Human user) {
        checkLocation(user);
        furniture.cover(user);
    }

    public void uncoverMirror(Human user) {
        checkLocation(user);
        furniture.uncover(user);
    }

    public boolean lookInMirror(Human user) {
        checkLocation(user);
        return furniture.lookIn(user);
    }
}
