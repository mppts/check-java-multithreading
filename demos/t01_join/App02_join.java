package demos.t01_join;

public class App02_join {
    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(() -> System.out.println("Example thread t1"));
        Thread th2 = new Thread(() -> System.out.println("Example thread t2"));

        th1.start();
        th2.start();

        /*
         * We do not need to call thFoo.join() and thBar.join().
         * Main thread will wait for the completion of all threads before app exits.
         */

    }
}
