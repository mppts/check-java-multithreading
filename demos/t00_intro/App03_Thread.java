// Use Thread class with lambdas

package demos.t00_intro;

public class App03_Thread {
    public static void main(String[] args) {
        var th = new Thread(() -> System.out.println("Runnable thread"));

        th.start();

        System.out.println("Main thread");
    }
}
