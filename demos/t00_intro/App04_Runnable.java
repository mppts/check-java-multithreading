// Use Runnable interface

package demos.t00_intro;

public class App04_Runnable {
    public static void main(String[] args) {
        var task = new InnerApp04_Runnable();

        var t1 = new Thread(task);
        var t2 = new Thread(task);

        t1.start();
        t2.start();

        System.out.println("Main thread");
    }
}

/**
 * InnerApp03_Runnable
 */
class InnerApp04_Runnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable exmaple");
    }
}