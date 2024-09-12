package com.example.webinar20.shared_state;

// как решить проблему shared mutable state в java?
class MutableIntegerJava {

    private int value;

    //Problem
    public synchronized int increment() {
        return value++;
    }

    public int getValue() {
        return value;
    }

}

class SharedMutableState {
    public static void main(String[] args) throws InterruptedException {
        MutableIntegerJava mutableInteger = new MutableIntegerJava();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                mutableInteger.increment();
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                mutableInteger.increment();
            }
        });
        t2.start();
        t1.join();
        t2.join();
        System.out.println(mutableInteger.getValue()); // 200_000 не выводится(
    }
}
