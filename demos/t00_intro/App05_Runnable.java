// Use Runnable interface with lambdas

package demos.t00_intro;

public class App05_Runnable {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Runnable thread");

        var t1 = new Thread(task);
        var t2 = new Thread(task);

        t1.start();
        t2.start();

        System.out.println("Main thread");
    }
}
