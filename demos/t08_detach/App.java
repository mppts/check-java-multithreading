package demos.t08_detach;

public class App {
    public static void main(String[] args) throws InterruptedException {
        var t = new Thread(() -> {

            System.out.println("Example thread is starting...");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            System.out.println("Example thread is exiting...");
        });

        t.setDaemon(true);
        t.start();

        // comment to force example thread termination
        Thread.sleep(3000);

        System.out.println("Main thread is exiting");
    }
}
