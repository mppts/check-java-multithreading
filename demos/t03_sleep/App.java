package demos.t03_sleep;

public class App {
    public static void main(String[] args) throws InterruptedException {
        var t = new Thread(() -> {
            System.out.println("Example thread: start to sleep");

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }

            System.out.println("Example thread: woke up");
        });

        t.start();
        t.join();

        System.out.println("Main thread");
    }
}
