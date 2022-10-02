package demos.t24_atomic;

import java.util.stream.IntStream;

public class App01 {
    public static void main(String[] args) throws InterruptedException {
        Runnable doTask = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            Global.counter++;
        };

        var threadsList = IntStream.range(0, 1000)
                .mapToObj(i -> new Thread(doTask))
                .toList();

        for (var th : threadsList)
            th.start();

        for (var th : threadsList)
            th.join();

        // Unpredictable result
        System.out.println("counter = " + Global.counter);
    }

    private static class Global {
        public static volatile int counter = 0;
    }
}
