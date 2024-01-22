package ru.webwitcher.uni.lab3.utils;

public abstract class Utils {
    public static int constrain(int value, int min, int max) {
        return Math.min(Math.max(value, min), max);
    }

    public static float constrain(float value, float min, float max) {
        return Math.min(Math.max(value, min), max);
    }
}
