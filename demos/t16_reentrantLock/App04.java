package demos.t16_reentrantLock;

import java.util.stream.IntStream;

public class App04 {
    public static void main(String[] args) throws InterruptedException {
        final int nThreads = 3;

        IntStream.range(0, nThreads).forEach(i -> new Worker((char) (i + 'A')).start());
    }

    private static class Worker extends Thread {
        private static Object lock = new Object();

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

            synchronized (lock) {
                System.out.println("First time %c acquiring the lock".formatted(name));

                synchronized (lock) {
                    System.out.println("Second time %c acquiring the lock".formatted(name));
                }
            }
        }
    }

}
