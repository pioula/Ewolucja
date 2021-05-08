package robs;

import java.util.Random;

public abstract class Probability {
    public static boolean isHappened(double p) {
        Random r = new Random();
        return r.nextInt(100) < p;
    }
}
