package ru.webwitcher.uni.lab3.furniture;

import ru.webwitcher.uni.lab3.enums.Room;
import ru.webwitcher.uni.lab3.human.Human;

public class Toilet extends Furniture implements Container<Object> {
    private Object content = null;

    private final Semaphore<Human> semaphore = new Semaphore<>();

    public Toilet(Room room) {
        super(room);
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

    public void occupy(Human user) {
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
