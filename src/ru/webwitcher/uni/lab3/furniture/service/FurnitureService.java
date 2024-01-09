package ru.webwitcher.uni.lab3.furniture.service;

import ru.webwitcher.uni.lab3.furniture.Furniture;
import ru.webwitcher.uni.lab3.human.Human;

abstract public class FurnitureService<F extends Furniture> {
    protected final F furniture;

    public FurnitureService(F furniture) {
        this.furniture = furniture;
    }

    protected void checkLocation(Human user) {
        if (!user.getLocation().equals(furniture.getRoom())) {
            throw new RuntimeException("Нет доступа к мебели - не та комната.");
        }
    }
}
