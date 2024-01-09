package ru.webwitcher.uni.lab3.furniture.service;

import ru.webwitcher.uni.lab3.furniture.Toilet;
import ru.webwitcher.uni.lab3.human.Human;

public class ToiletService extends FurnitureService<Toilet> {
    public ToiletService(Toilet furniture) {
        super(furniture);
    }

    public void fillToilet(Human user, Object object) {
        checkLocation(user);
        furniture.fill(object);
    }

    public void flushToilet(Human user) {
        checkLocation(user);
        furniture.empty();
    }
}
