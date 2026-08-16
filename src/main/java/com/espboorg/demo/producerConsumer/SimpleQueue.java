package com.espboorg.demo.producerConsumer;

public class SimpleQueue {
    private int value = 0;
    boolean valueSet = false;

    synchronized public void put(int value) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("SimpleQueue interrupted");
            }
        }
        this.value = value;
        this.valueSet = true;
        System.out.println("Put: " + value);
        notify();
    }

    synchronized public int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("SimpleQueue interrupted");
            }
        }
        System.out.println("Get: " + value);
        this.valueSet = false;
        notify();
        return value;
    }
}
