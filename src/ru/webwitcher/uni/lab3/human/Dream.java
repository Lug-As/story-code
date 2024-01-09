package ru.webwitcher.uni.lab3.human;

public class Dream {
    private String essence;

    public Dream(String essence) {
        this.essence = essence;
    }

    public String getEssence() {
        return essence;
    }

    public void setEssence(String essence) {
        this.essence = essence;
    }

    @Override
    public String toString() {
        return essence;
    }
}
