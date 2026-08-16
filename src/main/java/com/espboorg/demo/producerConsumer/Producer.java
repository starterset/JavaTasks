package com.espboorg.demo.producerConsumer;

public class Producer implements Runnable {
    String name;
    Thread thread;
    SimpleQueue queue;

    public Producer(String threadName, SimpleQueue queue) {
        this.name = threadName;
        this.thread = new Thread(this, this.name);
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            queue.put(i);
        }
    }
}
