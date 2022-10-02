package demos.t06_terminate;

import java.util.concurrent.atomic.AtomicBoolean;

public class App02_Flag {

    public static void main(String[] args) throws InterruptedException {
        var flagStop = new AtomicBoolean(false);

        var th = new Thread(() -> {
            while (true) {
                if (flagStop.get()) {
                    break;
                }
                System.out.println("Running...");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        });

        th.start();

        Thread.sleep(2000);

        flagStop.set(true);
    }
}
