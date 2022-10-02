// Use Thread class

package demos.t00_intro;

public class App01_Thread {
    public static void main(String[] args) throws InterruptedException {
        // external
        var th = new ExampleThread();
        th.start();

        System.out.println("Main thread");
    }
}

class ExampleThread extends Thread {
    @Override
    public void run() {
        System.out.println("Example thread");
    }
}