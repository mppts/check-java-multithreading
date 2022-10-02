package demos.t18_RWBlock;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App01 {
    public static void main(String[] args) {
        ReadWriteLock rwlock = new ReentrantReadWriteLock();

        final int nThreadsRead = 10;
        final int nThreadsWrite = 4;
        final int nArgs = 3;

        var lstArg = IntStream.range(0, nArgs).toArray();
        var rand = new Random();

        var threadListRead = Stream.generate(() -> new Thread(() -> {
            int waitTime = lstArg[rand.nextInt(lstArg.length)];
            try {
                Thread.sleep(1000 * waitTime);
            } catch (InterruptedException e) {
            }

            rwlock.readLock().lock();

            System.out.println("read: " + Resource.value);

            rwlock.readLock().unlock();
        })).limit(nThreadsRead).toList();

        var threadListWrite = Stream.generate(() -> new Thread(() -> {

            int waitTime = lstArg[rand.nextInt(lstArg.length)];
            try {
                Thread.sleep(1000 * waitTime);
            } catch (InterruptedException e) {
            }

            rwlock.writeLock().lock();

            Resource.value = rand.nextInt(100);
            System.out.println("write: " + Resource.value);

            rwlock.writeLock().unlock();
        })).limit(nThreadsWrite).toList();

        threadListRead.forEach(Thread::start);
        threadListWrite.forEach(Thread::start);
    }
}

class Resource {
    public static volatile int value;
}