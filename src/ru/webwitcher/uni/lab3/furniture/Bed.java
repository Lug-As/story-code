package ru.webwitcher.uni.lab3.furniture;

import ru.webwitcher.uni.lab3.enums.PhysicalPosition;
import ru.webwitcher.uni.lab3.human.Human;
import ru.webwitcher.uni.lab3.scene.Location;

public class Bed extends Furniture {
    private final Semaphore<Human> semaphore;

    public Bed(Location location, int totalSeats) {
        super(location);
        this.semaphore = new Semaphore<>(totalSeats);
    }

    public Bed(Location location) {
        this(location, 1);
    }

    public void lieDownOn(Human user) throws ResourceIsNotAvailableException {
        semaphore.occupy(user);
        user.setPhysicalPosition(PhysicalPosition.LYING);
        user.blockPosition();
    }

    public void sitDownOn(Human user) throws ResourceIsNotAvailableException {
        semaphore.occupy(user);
        user.setPhysicalPosition(PhysicalPosition.SITTING);
        user.blockPosition();
    }

    public void getUp(Human user) {
        semaphore.free(user);
        user.setPhysicalPosition(PhysicalPosition.STANDING);
        user.unblockPosition();
    }
}
