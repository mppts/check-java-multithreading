package demos.t11_raceCondition;

import java.util.stream.Stream;

public class App03_Race {
    public static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        final int nThreads = 4;

        var threadsList = Stream.generate(() -> new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            for (int i = 0; i < 100; i++) {
                Global.counter += 1;
                App03_Race.counter += 1;
            }
        })).limit(nThreads).toList();

        for (var thread : threadsList)
            thread.start();

        for (var thread : threadsList)
            thread.join();

        System.out.println("class counter = " + Global.counter);
        System.out.println("this.counter = " + App03_Race.counter);
    }

    private static class Global {
        public static int counter = 0;
    }
}
