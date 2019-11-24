package com.autoframework;

public class M {

    public static void sp(int seconds) {
        long millis = seconds * 1000;//1000L
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
