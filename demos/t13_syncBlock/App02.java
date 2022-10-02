package demos.t13_syncBlock;

import java.util.stream.IntStream;

public class App02 {
    public static void main(String[] args) throws InterruptedException {
        final int nThreads = 10;

        var task = new MyTask();

        var threadsList = IntStream.range(0, nThreads)
                .mapToObj(i -> new Thread(task))
                .toList();

        for (var thread : threadsList) {
            thread.start();
        }

        for (var thread : threadsList) {
            thread.join();
        }

        System.out.println("counter = " + MyTask.counter);
    }
}

class MyTask implements Runnable {
    public static int counter = 0;

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        for (int i = 0; i < 1000; ++i) {
            ++counter;
        }
    }

}