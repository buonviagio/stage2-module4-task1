package com.mjc.stage2;

public class ThreadSafeSingleton {
    // Write your code here!
    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton (){}

    public static ThreadSafeSingleton getInstance() {
        ThreadSafeSingleton threadSafeSingleton = instance;
        if (threadSafeSingleton == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
