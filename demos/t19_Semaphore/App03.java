package demos.t19_Semaphore;

import java.util.concurrent.Semaphore;

public class App03 {
    public static void main(String[] args) {
        var semTire = new Semaphore(4);
        var semChassis = new Semaphore(0);

        Runnable makeTire = () -> {
            for (int i = 0; i < 8; ++i) {
                try {
                    semTire.acquire();

                    System.out.println("Make 1 tire");
                    Thread.sleep(1000);

                    semChassis.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Runnable makeChassis = () -> {
            for (int i = 0; i < 4; ++i) {
                try {
                    semChassis.acquire(4);

                    System.out.println("Make 1 chassis");
                    Thread.sleep(3000);

                    semTire.release(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(makeTire).start();
        new Thread(makeTire).start();
        new Thread(makeChassis).start();
    }
}
