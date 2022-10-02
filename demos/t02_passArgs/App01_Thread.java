// pass args to Thread class

package demos.t02_passArgs;

/**
 * App01_Thread
 */
public class App01_Thread {

    public static void main(String[] args) {
        var t1 = new ExampleThread(1, "The first thread (expected)");
        var t2 = new ExampleThread(4, "The next one (expected)");

        t1.start();
        t2.start();
    }
}

class ExampleThread extends Thread {
    private int i;
    private String s;

    public ExampleThread(int i, String s) {
        super();
        this.i = i;
        this.s = s;
    }

    @Override
    public void run() {
        System.out.printf("%d. %s\n", this.i, this.s);
    }
}