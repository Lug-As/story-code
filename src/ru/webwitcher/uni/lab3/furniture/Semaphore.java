package ru.webwitcher.uni.lab3.furniture;

import java.util.HashSet;
import java.util.Set;

public class Semaphore<U> {
    private final int totalSeats;
    private final Set<U> users;

    public Semaphore(int totalSeats) {
        this.totalSeats = totalSeats;
        this.users = new HashSet<>(totalSeats);
    }

    public Semaphore() {
        this(1);
    }

    public void occupy(U user) {
        if (!users.contains(user)) {
            if (isBusy()) {
                throw new RuntimeException("Мест нет");
            }
            users.add(user);
        }
    }

    public boolean canUse(U user) {
        return users.contains(user);
    }

    public void ensureCanUse(U user) {
        if (!canUse(user)) {
            throw new RuntimeException("Данный пользователь не может использовать ресурс");
        }
    }

    public void free(U user) {
        users.remove(user);
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getTakenSeats() {
        return users.size();
    }

    public int getAvailableSeats() {
        return getTotalSeats() - getTakenSeats();
    }

    public boolean isAvailable() {
        return getAvailableSeats() > 0;
    }

    public boolean isBusy() {
        return !isAvailable();
    }
}
