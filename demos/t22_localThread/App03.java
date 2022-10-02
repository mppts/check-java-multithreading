package demos.t22_localThread;

import java.util.stream.IntStream;

public class App03 {

    public static void main(String[] args) throws InterruptedException {
        final int nThreads = 3;

        var lstTh = IntStream.range(0, nThreads).mapToObj(t -> new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            for (int i = 0; i < 1000; ++i)
                MyTask.increaseCounter();

            System.out.println("Thread " + t + " gives counter = " + MyTask.getCounter());
        })).toList();

        lstTh.forEach(Thread::start);

        /*
         * By using thread-local storage, each thread has its own counter.
         * So, the counter in one thread is completely independent of each other.
         *
         * Thread-local storage helps us to AVOID SYNCHRONIZATION.
         */
    }

    private static class Counter {
        public int value = 0;
    }

    private static class MyTask {
        private static final ThreadLocal<Counter> thlCounter = ThreadLocal.withInitial(() -> new Counter());

        public static int getCounter() {
            return thlCounter.get().value;
        }

        public static void increaseCounter() {
            var counter = thlCounter.get();
            ++counter.value;
        }
    }

}