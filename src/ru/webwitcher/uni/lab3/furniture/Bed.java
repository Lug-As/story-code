package ru.webwitcher.uni.lab3.furniture;

import ru.webwitcher.uni.lab3.enums.PhysicalPosition;
import ru.webwitcher.uni.lab3.enums.Room;
import ru.webwitcher.uni.lab3.human.Human;

import java.util.HashSet;
import java.util.Set;

public class Bed extends Furniture {
    private int totalSeats = 1;

    private final Set<Human> users = new HashSet<>();

    public Bed(Room room) {
        super(room);
    }

    public Bed(Room room, int totalSeats) {
        super(room);
        this.totalSeats = totalSeats;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getTakenSeats() {
        return users.size();
    }

    public int getFreeSeats() {
        return getTotalSeats() - getTakenSeats();
    }

    public Set<Human> getUsers() {
        return users;
    }

    public boolean isFree() {
        return getFreeSeats() > 0;
    }

    public boolean isBusy() {
        return !isFree();
    }

    public void lieDownOn(Human user) {
        takeSeat(user);
        user.setPhysicalPosition(PhysicalPosition.LYING);
    }

    public void sitDownOn(Human user) {
        takeSeat(user);
        user.setPhysicalPosition(PhysicalPosition.SITTING);
    }

    private void takeSeat(Human user) {
        if (!users.contains(user)) {
            checkLocation(user);
            if (isBusy()) {
                throw new RuntimeException("Кровать занята"); // можно вынести логику занятия мест в кастомный семафор
            }
            users.add(user);
        }
    }

    public void getUp(Human user) {
        freeUpSeat(user);
        user.setPhysicalPosition(PhysicalPosition.STANDING);
    }

    private void freeUpSeat(Human user) {
        users.remove(user);
    }
}
