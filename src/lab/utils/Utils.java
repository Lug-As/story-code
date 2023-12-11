package lab.utils;

public class Utils {
    public static int constrain(int value, int min, int max) {
        return Math.min(Math.max(value, min), max);
    }

    public static float constrain(float value, float min, float max) {
        return Math.min(Math.max(value, min), max);
    }
}
