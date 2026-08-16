package com.espboorg.demo.producerConsumer;

public class Main {

    public static void main(String[] args) {
        SimpleQueue dc = new SimpleQueue();
        Producer producer = new Producer("Producer", dc);
        Consumer consumer = new Consumer("Consumer", dc);

        producer.thread.start();
        consumer.thread.start();

        System.out.println("Press Ctrl+C to Exit");
    }
}
