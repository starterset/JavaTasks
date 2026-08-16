package com.espboorg.demo.producerConsumer;

public class Consumer implements Runnable {
    String name;
    Thread thread;
    SimpleQueue queue;
    int value;

    public Consumer(String name, SimpleQueue queue) {
        this.name = name;
        this.thread = new Thread(this, this.name);
        this.queue = queue;
    }

    @Override
    public void run() {
        while (value <= 100) {
            value = queue.get();
        }
    }
}
