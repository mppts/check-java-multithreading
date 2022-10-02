package demos.t13_syncBlock;

import java.util.concurrent.ExecutionException;

public class App01 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final int nThreads = 16;

        var worker = new MyTask();

        var threadsList = IntStream.range(0, nThreads).mapToObj(i -> new Thread(worker)).toList();

        for (var thread : threadsList)
            thread.start();

        for (var thread : threadsList)
            thread.join();

        System.out.println("counter = " + MyTask.counter);
    }

    private static class MyTask implements Runnable {
        public static int counter = 0;

        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }

            /*
             * synchronized (this) means that on "this" object,
             * only and only one thread can execute the enclosed block at one time.
             *
             * "this" is the monitor object, the code inside the block gets synchronized on
             * the monitor object.
             * Simply put, only one thread per monitor object can execute inside that block
             * of code.
             */

            synchronized (this) {
                for (int i = 0; i < 1000; ++i) {
                    ++counter;
                }
            }
        }
    }

}
