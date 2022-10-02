package demos.t07_returnValue;

public class App02_ResList {
    public static void main(String[] args) throws InterruptedException {
        int[] res = new int[2];

        var t1 = new Thread(() -> {
            res[0] = doubleVal(12);
        });

        var t2 = new Thread(() -> {
            res[1] = doubleVal(33);
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("T1: " + res[0]);
        System.out.println("T2: " + res[1]);
    }

    private static int doubleVal(int arg) {
        return arg * 2;
    }
}
