package com.espboorg.effectiveJava.item3_singleton;

import java.lang.ref.WeakReference;

public class WeakSingleton {
    private static volatile WeakReference<WeakSingleton> INSTANCE;

    private WeakSingleton() {
        if (INSTANCE != null) {
            throw new RuntimeException("Instance already exists");
        }
    }

    public static WeakSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (WeakReference.class) {
                if (INSTANCE == null) {
                    WeakSingleton instance = new WeakSingleton();
                    INSTANCE = new WeakReference<>(instance);
                    return instance;
                }
            }
        }
        WeakSingleton instance = INSTANCE.get();
        if (instance != null)
            return instance;

        synchronized (WeakSingleton.class) {
            instance = new WeakSingleton();
            INSTANCE = new WeakReference<>(instance);
            return instance;
        }
    }
}