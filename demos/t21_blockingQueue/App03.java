package demos.t21_blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class App03 {
    public static void main(String[] args) {
        final BlockingQueue<String> queue = new SynchronousQueue<>();
        new Thread(() -> producer(queue)).start();
        new Thread(() -> consumer(queue)).start();
    }

    private static void producer(BlockingQueue<String> queue) {
        try {
            System.out.println("===puting Alice...");
            queue.put("Alice");
            System.out.println("===putting likes...");
            queue.put("likes");
            System.out.println("===putting singing...");
            queue.put("singing");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void consumer(BlockingQueue<String> queue) {
        String data;

        try {
            Thread.sleep(2000);

            for (int i = 0; i < 3; ++i) {
                System.out.println("\nWaiting for data...");

                data = queue.take();

                System.out.println("    " + data);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
