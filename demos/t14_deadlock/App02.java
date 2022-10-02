package demos.t14_deadlock;

public class App02 {
    public static void main(String[] args) throws InterruptedException {
        final Object resourceA = "resourceA";
        final Object resourceB = "resourceB";

        var threadFoo = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("foo acquired resource A");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                synchronized (resourceB) {
                    System.out.println("foo acquired resource B");
                }
            }
        });

        var threadBar = new Thread(() -> {
            synchronized (resourceB) {
                System.out.println("bar acquired resource B");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                synchronized (resourceA) {
                    System.out.println("bar acquired resource A");
                }
            }
        });

        threadFoo.start();
        threadBar.start();
        threadFoo.join();
        threadBar.join();

        System.out.println("You will never see this statement due to deadlock!");
    }
}
