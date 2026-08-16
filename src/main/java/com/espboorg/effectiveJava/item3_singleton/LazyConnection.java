package com.espboorg.effectiveJava.item3_singleton;

// Singleton with lazy initialization
public final class LazyConnection {
    private static volatile LazyConnection INSTANCE = null;

    private LazyConnection() {
        if (INSTANCE != null) {
            throw new RuntimeException("Instance already exists");
        }
    }

    public static LazyConnection getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (LazyConnection.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazyConnection();
                }
            }
        }
        return INSTANCE;
    }
}
