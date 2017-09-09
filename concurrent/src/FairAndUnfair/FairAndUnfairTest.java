package FairAndUnfair;

import sleep.SleepUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by walmt on 2017/9/9.
 */
public class FairAndUnfairTest {
    private static ReentrantLock2 fairLock = new ReentrantLock2(true);
    private static ReentrantLock2 unfairLock = new ReentrantLock2(false);

    public static void main(String[] args) {
        FairAndUnfairTest fairAndUnfairTest = new FairAndUnfairTest();
//        fairAndUnfairTest.testLock(fairLock);
        fairAndUnfairTest.testLock(unfairLock);
    }

    private void testLock(ReentrantLock2 lock) {
        Job[] jobs = new Job[5];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new Job(lock);
        }
        for (int i = 0; i < jobs.length; i++) {
            jobs[i].start();
        }
    }

    private static class Job extends Thread {
        private ReentrantLock2 lock;
        public Job(ReentrantLock2 lock) {
            this.lock = lock;
        }
        public void run() {
            for (int i = 0; i < 2; i++) {
                try {
                    lock.lock();
                    System.out.print("Lock by [" + currentThread().getId() + "], ");
                    System.out.print("Waiting  by [");
                    lock.getQueuedThreads().forEach(t-> System.out.print(t.getId() + ","));
                    System.out.println("]");
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        public Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }
}
