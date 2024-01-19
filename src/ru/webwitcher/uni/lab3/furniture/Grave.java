package ru.webwitcher.uni.lab3.furniture;


public class Grave implements Container<Coffin> {
    private Coffin coffin = null;

    private boolean isOpen = true;

    public boolean isOpen() {
        return isOpen;
    }

    public void coverUp() {
        isOpen = true;
    }

    public void fill(Coffin content) {
        coffin = content;
    }

    public void empty() {
        coffin = null;
    }

    public boolean isEmpty() {
        return coffin == null;
    }
}
