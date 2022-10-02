package demos.t12_mutex;

import java.beans.IntrospectionException;
import java.util.concurrent.Semaphore;
import java.util.stream.Stream;

public class App01_Semaphore {

    public static Semaphore mutex = new Semaphore(1);
    public static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        final int nThreads = 16;

        var threadslist = Stream.generate(() -> new Thread(() -> {
            try {
                Thread.sleep(1000);

                App01_Semaphore.mutex.acquire();
                for (int i = 0; i < 100; i++) {
                    App01_Semaphore.counter++;
                }
                App01_Semaphore.mutex.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        })).limit(nThreads).toList();

        for (var thread : threadslist)
            thread.start();

        for (var thread : threadslist)
            thread.join();

        System.out.println("counter = " + App01_Semaphore.counter);
    }
}
