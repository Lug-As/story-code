package ru.webwitcher.uni.lab3.furniture;

import ru.webwitcher.uni.lab3.human.Human;
import ru.webwitcher.uni.lab3.scene.Location;

public class Toilet extends Furniture implements Container<Object> {
    private Object content = null;

    private final Semaphore<Human> semaphore = new Semaphore<>(this);

    public Toilet(Location location) {
        super(location);
    }

    public Object getContent() {
        return content;
    }

    public void fill(Object o) {
        content = o;
    }

    public void empty() {
        content = null;
        System.gc();
    }

    public boolean isEmpty() {
        return content == null;
    }

    public void occupy(Human user) throws ResourceIsNotAvailableException {
        semaphore.occupy(user);
        user.blockPosition();
    }

    public void free(Human user) {
        semaphore.free(user);
        user.unblockPosition();
    }

    public boolean canUse(Human user) {
        return semaphore.canUse(user);
    }

    public void ensureCanUse(Human user) {
        semaphore.ensureCanUse(user);
    }
}
