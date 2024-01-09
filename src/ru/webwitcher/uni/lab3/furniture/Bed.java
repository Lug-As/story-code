package ru.webwitcher.uni.lab3.furniture;

import ru.webwitcher.uni.lab3.enums.PhysicalPosition;
import ru.webwitcher.uni.lab3.enums.Room;
import ru.webwitcher.uni.lab3.human.Human;

public class Bed extends Furniture {
    private final Semaphore<Human> semaphore;

    public Bed(Room room, int totalSeats) {
        super(room);
        this.semaphore = new Semaphore<>(totalSeats);
    }

    public Bed(Room room) {
        this(room, 1);
    }

    public void lieDownOn(Human user) {
        semaphore.occupy(user);
        user.setPhysicalPosition(PhysicalPosition.LYING);
        user.blockPosition();
    }

    public void sitDownOn(Human user) {
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
