package demos.t13_syncBlock;

import java.util.stream.IntStream;

public class App04 {
    public static void main(String[] args) throws InterruptedException {
        final int nThreads = 10;

        var threadsList = IntStream.range(0, nThreads)
                .mapToObj(i -> new Worker())
                .toList();

        for (var thread : threadsList) {
            thread.start();
        }
        for (var thread : threadsList) {
            thread.join();
        }

        System.out.println("counter = " + Worker.counter);
    }

    private static class Worker extends Thread {
        public static int counter = 0;

        @Override
        public void run() {
            incCounter();
        }

        private static synchronized void incCounter() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }

            for (int i = 0; i < 1000; ++i) {
                ++counter;
            }
        }
    }
}
