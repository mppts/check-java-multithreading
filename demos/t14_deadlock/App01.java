package demos.t14_deadlock;

import java.util.concurrent.Semaphore;

public class App01 {
    public static void main(String[] args) throws InterruptedException {

        var mutex = new Semaphore(1);

        var threadFoo = new Thread(() -> doTask(mutex, "foo"));
        var threadBar = new Thread(() -> doTask(mutex, "bar"));

        threadFoo.start();
        threadBar.start();

        threadFoo.join();
        threadBar.join();

        System.out.println("You will never see this statement due to deadlock!");
    }

    private static void doTask(Semaphore mutex, String name) {
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " acquired resource");

        // mutex.release(); // Forget this statement ==> deadlock
    }
}
