package ru.webwitcher.uni.lab3.furniture;

import java.util.HashSet;
import java.util.Set;

public class Semaphore<U> {
    private final int totalSeats;
    private final Set<U> users;
    private final Object resource;

    public Semaphore(Object resource, int totalSeats) {
        this.totalSeats = totalSeats;
        this.users = new HashSet<>(totalSeats);
        this.resource = resource;
    }

    public Semaphore(Object resource) {
        this(resource, 1);
    }

    public void occupy(U user) throws ResourceIsNotAvailableException {
        if (!users.contains(user)) {
            if (isBusy()) {
                throw new ResourceIsNotAvailableException(resource);
            }
            users.add(user);
        }
    }

    public boolean canUse(U user) {
        return users.contains(user);
    }

    public void ensureCanUse(U user) {
        if (!canUse(user)) {
            throw new AccessDeniedException(resource);
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
