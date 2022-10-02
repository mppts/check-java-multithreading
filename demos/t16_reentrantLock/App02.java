package demos.t16_reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class App02 {
    public static void main(String[] args) {
        final int NUM_THREADS = 3;

        IntStream.range(0, NUM_THREADS).forEach(i -> new Worker((char) (i + 'A')).start());
    }

    private static class Worker extends Thread {
        private static Lock lk = new ReentrantLock();

        private char name;

        public Worker(char name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            lk.lock();
            System.out.println("First time %c acquiring the resource".formatted(name));

            lk.lock();
            System.out.println("Second time %c acquiring the resource".formatted(name));

            lk.unlock();
            lk.unlock();
        }
    }
}
