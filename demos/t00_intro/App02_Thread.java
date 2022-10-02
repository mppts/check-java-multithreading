// Use anonymus Thread class 

package demos.t00_intro;

public class App02_Thread {

    public static void main(String[] args) throws InterruptedException {
        var th = new Thread() {
            @Override
            public void run() {
                System.out.println("Example thread");
            }
        };

        th.start();

        System.out.println("Main thread");

    }

}
