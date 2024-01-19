package ru.webwitcher.uni.lab3.furniture.service;

import ru.webwitcher.uni.lab3.furniture.ResourceIsNotAvailableException;
import ru.webwitcher.uni.lab3.furniture.Toilet;
import ru.webwitcher.uni.lab3.human.Human;

public class ToiletService extends FurnitureService<Toilet> {
    public ToiletService(Toilet furniture) {
        super(furniture);
    }

    public void occupyToilet(Human user) throws ResourceIsNotAvailableException {
        checkLocation(user);
        furniture.occupy(user);
    }

    public void freeToilet(Human user) {
        furniture.free(user);
    }

    public void fillToilet(Human user, Object object) {
        checkLocation(user);
        furniture.ensureCanUse(user);
        furniture.fill(object);
    }

    public void flushToilet(Human user) {
        checkLocation(user);
        furniture.ensureCanUse(user);
        furniture.empty();
    }
}
