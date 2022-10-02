package demos.t07_returnValue;

public class App01_Threads {
    public static void main(String[] args) throws InterruptedException {
        var t1 = new InnerApp01_Threads(10);
        var t2 = new InnerApp01_Threads(42);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("T1: " + t1.res);
        System.out.println("T2: " + t2.res);

    }
}

class InnerApp01_Threads extends Thread {
    public int arg = 0;
    public int res = 0;

    public InnerApp01_Threads(int arg) {
        super();
        this.arg = arg;
    }

    @Override
    public void run() {
        res = arg * 2;
    }
}
