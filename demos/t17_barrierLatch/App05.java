package demos.t17_barrierLatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class App05 {
    public static void main(String[] args) throws InterruptedException {
        var lstArg = List.of(
                new ThreadArg("Send request to egg.net to get data", 6),
                new ThreadArg("Send request to foo.org to get data", 2),
                new ThreadArg("Send request to bar.com to get data", 4));

        var syncPoint = new CountDownLatch(lstArg.size());

        lstArg.forEach(arg -> new Thread(() -> {
            try {
                Thread.sleep(1000 * arg.waitTime);

                System.out.println(arg.message);
                syncPoint.countDown();

                Thread.sleep(8000);
                System.out.println("Cleanup");
            } catch (InterruptedException e) {
            }
        }).start());

        syncPoint.await();

        System.out.println("\nNow we have enough data to progress to next step\n");
    }

    private record ThreadArg(String message, int waitTime) {
    }
}
