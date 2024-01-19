package ru.webwitcher.uni.lab3.human;

import ru.webwitcher.uni.lab3.enums.Emotion;
import ru.webwitcher.uni.lab3.enums.ImpossiblePromise;
import ru.webwitcher.uni.lab3.enums.PhysicalPosition;
import ru.webwitcher.uni.lab3.food.Food;
import ru.webwitcher.uni.lab3.scene.Location;
import ru.webwitcher.uni.lab3.utils.Utils;

import java.util.*;

public class Human {
    private final String name;

    private boolean isAlive = true;

    private boolean isSleeping = false;

    private int energy = 75;

    private int health = 75;

    private PhysicalPosition physicalPosition = PhysicalPosition.STANDING;

    private Location location;

    private Emotion currentEmotion = Emotion.NORMAL;

    private final List<Dream> dreams = new ArrayList<>();

    private final Map<ImpossiblePromise, Integer> impossiblePromisesCounter = new HashMap<>();

    private final Deque<Food> belly = new LinkedList<>();

    private float alcoholLevel = 0;

    private boolean positionBlocked = false;

    public boolean isWet = false;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void die() {
        setEnergy(0);
        setHealth(0);
        isAlive = false;
    }

    public boolean isSleeping() {
        return isSleeping;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = Utils.constrain(energy, 0, 100);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Utils.constrain(health, 0, 100);
    }

    public float getAlcoholLevel() {
        return alcoholLevel;
    }

    public void setAlcoholLevel(float alcoholLevel) {
        this.alcoholLevel = Utils.constrain(alcoholLevel, 0, 5);
    }

    public void blockPosition() {
        positionBlocked = true;
    }

    public void unblockPosition() {
        positionBlocked = false;
    }

    public boolean isPositionBlocked() {
        return positionBlocked;
    }

    public PhysicalPosition getPhysicalPosition() {
        return physicalPosition;
    }

    public void setPhysicalPosition(PhysicalPosition physicalPosition) {
        this.physicalPosition = physicalPosition;
    }

    public Location getLocation() {
        return location;
    }

    public void goTo(Location location) {
        if (isPositionBlocked()) {
            throw new RuntimeException("Позиция человека заблокирована.");
        }
        if (this.location != null) {
            this.location.removeCharacter(this);
        }
        this.location = location;
        location.addCharacter(this);
    }

    public List<Dream> getDreams() {
        return dreams;
    }

    public Deque<Food> getBelly() {
        return belly;
    }

    public Map<ImpossiblePromise, Integer> getPromisesCounter() {
        return impossiblePromisesCounter;
    }

    public void promise(ImpossiblePromise promise) {
        if (impossiblePromisesCounter.containsKey(promise)) {
            impossiblePromisesCounter.put(promise, impossiblePromisesCounter.get(promise) + 1);
        } else {
            impossiblePromisesCounter.put(promise, 1);
        }
    }

    public Emotion getCurrentEmotion() {
        return currentEmotion;
    }

    public void setCurrentEmotion(Emotion currentEmotion) {
        this.currentEmotion = currentEmotion;
    }

    public void sleep() {
        setPhysicalPosition(PhysicalPosition.LYING);
        isSleeping = true;
        addHealth(10);
    }

    public void cry() {
        setCurrentEmotion(Emotion.DEPRESSIVE);
        addEnergy(-20);
    }

    public void awake() {
        isSleeping = false;
    }

    public Vomit threwUp() {
        setCurrentEmotion(Emotion.DISGUSTED);
        addEnergy(-20);
        addHealth(10);
        return new Vomit(belly.pollLast());
    }

    public boolean isWet() {
        return isWet;
    }

    public void getWet() {
        isWet = true;
        addEnergy(-15);
        addEnergy(-10);
    }

    public void dryUp() {
        isWet = false;
    }

    public boolean isProtectedFromGettingWet() {
        // true if has a thing that can protect from the rain
        return new Random().nextBoolean();
    }

    public void addHealth(int health) {
        setHealth(getHealth() + health);
    }

    public void addEnergy(int energy) {
        setEnergy(getEnergy() + energy);
    }

    public void addAlcoholLevel(float alcoholLevel) {
        setAlcoholLevel(getAlcoholLevel() + alcoholLevel);
    }

    public void consume(Food food) {
        food.digest(this);
        belly.add(food);
    }
}
