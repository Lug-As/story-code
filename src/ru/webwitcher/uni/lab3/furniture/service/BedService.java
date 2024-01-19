package ru.webwitcher.uni.lab3.furniture.service;

import ru.webwitcher.uni.lab3.furniture.Bed;
import ru.webwitcher.uni.lab3.furniture.ResourceIsNotAvailableException;
import ru.webwitcher.uni.lab3.human.Human;

public class BedService extends FurnitureService<Bed> {
    public BedService(Bed furniture) {
        super(furniture);
    }

    public void lieDownOnBed(Human user) throws ResourceIsNotAvailableException {
        checkLocation(user);
        furniture.lieDownOn(user);
    }

    public void sitDownOnBed(Human user) throws ResourceIsNotAvailableException {
        checkLocation(user);
        furniture.sitDownOn(user);
    }

    public void getUpFromBed(Human human) {
        furniture.getUp(human);
    }
}
