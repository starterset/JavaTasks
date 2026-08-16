package com.espboorg.effectiveJava.item3_singleton;

import java.io.Serial;
import java.io.Serializable;

public class SerializableConnection implements Serializable {
    private static SerializableConnection INSTANCE = null;

    private SerializableConnection() {
        if (INSTANCE != null) {
            throw new RuntimeException("Instance already exists");
        }
    }

    public static SerializableConnection getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new SerializableConnection();
        }
        return INSTANCE;
    }

    // readResolve method to preserve singleton property
    @Serial
    private Object readResolve() {
        return INSTANCE;
    }
}
