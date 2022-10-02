package demos.t16_reentrantLock;

public class App03 {
    public static void main(String[] args) {
        final Object resource = "resource";

        new Thread(() -> {
            synchronized (resource) {
                System.out.println("First time acquiring the resource");

                synchronized (resource) {
                    System.out.println("Second time acquiring the resource");
                }
            }
        }).start();
    }
}
