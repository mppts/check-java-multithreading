package demos.t15_monitor;

import java.util.stream.IntStream;

public class App01 {
    public static void main(String[] args) {
        var counter = new Counter();
        var monitor = new MyMonitor();
        monitor.init(counter);

        final int nThreads = 10;

        var threadsList = IntStream.range(0, nThreads)
                .mapToObj(t -> new Thread(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }

                    for (int i = 0; i < 1000; ++i)
                        monitor.increaseCounter();
                })).toList();

        for (var thread : threadsList) {
            thread.start();
        }

        for (var thread : threadsList) {
            thread.join();
        }

        System.out.println("counter = " + counter.value);
    }
}

class Counter {
    public int value = 0;
}

class MyMonitor {
    private Counter counter = null;

    public void init(Counter counter) {
        this.counter = counter;
    }

    public void increaseCounter() {
        synchronized (counter) {
            counter.value++;
        }
    }
}